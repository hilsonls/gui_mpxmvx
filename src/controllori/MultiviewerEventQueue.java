/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllori;


import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.InvocationEvent;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

/**
 *
 * @author panda
 */
public class MultiviewerEventQueue extends EventQueue{
    private MouseEvent firstPress;
    private MouseEvent firstRelease;
    private MouseEvent firstClick;
    private boolean mayWillBeDragged = false;
    
    private Timer timer;
    private TimerTask firstPressTask;
    private TimerTask firstReleaseTask;
    private TimerTask firstClickTask;
    private int doubleClickInterval;
    private boolean suspend;
    
    private static MultiviewerEventQueue instance;

    private MultiviewerEventQueue() {
        timer = new Timer();
        suspend = false;
        doubleClickInterval = (Integer)Toolkit.getDefaultToolkit().getDesktopProperty("awt.multiClickInterval");
        if (doubleClickInterval>300)
            doubleClickInterval = 300;
        //tTask = new DelayedMouseClickTimerTask();
    }
    
        //pattern Singleton
    public static MultiviewerEventQueue getInstance() {
      if(instance == null) {
         instance = new MultiviewerEventQueue();
         Toolkit.getDefaultToolkit().getSystemEventQueue().push(instance);
      }
      return instance;
    }

    @Override
    protected void dispatchEvent(AWTEvent event) {
        //System.out.println(((event==firstClick)?"==":"!=")+"firstClick");
        //System.out.println(((event==firstClick)?"===":"!==")+"firstClick");
        if (suspend && !(event instanceof InvocationEvent))
            return;

        boolean shouldWaitForDblClick = false;
        
        if (event instanceof MouseEvent && ((MouseEvent)event).getID()!=MouseEvent.MOUSE_MOVED) {
            MouseEvent me = (MouseEvent)event;
            Component target = SwingUtilities.getDeepestComponentAt(me.getComponent(), me.getX(), me.getY());
            //System.out.println(target);
            if (target instanceof JTree) {
                shouldWaitForDblClick = true;
                //System.out.println("    "+event.paramString());
                //System.out.println();                
            }
        } 
        
        if (!shouldWaitForDblClick) {
            super.dispatchEvent(event);
            return;            
        }

        if (mayWillBeDragged && event.getID()==MouseEvent.MOUSE_DRAGGED) {
            //System.out.println("Mouse will be dragged, forcing mousepress dispatch: "+firstPress.paramString());
            mayWillBeDragged = false;
            firstPressTask.cancel();
            super.dispatchEvent(firstPress);
        }        
        
        if (event!=firstPress && event != firstRelease && event!=firstClick && 
                event instanceof MouseEvent && ((MouseEvent)event).getButton()==MouseEvent.BUTTON1) {

            MouseEvent e = (MouseEvent)event;

            if (e.getClickCount() == 1) {  
                switch (e.getID()) {
                    case MouseEvent.MOUSE_PRESSED:
                        firstPress = e;
                        mayWillBeDragged = true;
                        firstPressTask = new DelayedMouseClickTimerTask(new Runnable() {
                            public void run() {
                                dispatchEvent(firstPress);
                            }
                        });
                        timer.schedule(firstPressTask, doubleClickInterval);
                        return;
                    case MouseEvent.MOUSE_RELEASED:
                        firstRelease = e;
                        mayWillBeDragged = false;
                        firstReleaseTask = new DelayedMouseClickTimerTask(new Runnable() {
                            public void run() {
                                dispatchEvent(firstRelease);
                            }
                        });
                        timer.schedule(firstReleaseTask, doubleClickInterval);
                        return;
                    case MouseEvent.MOUSE_CLICKED:
                        firstClick = e;
                        mayWillBeDragged = false;
                        firstClickTask = new DelayedMouseClickTimerTask(new Runnable() {
                            public void run() {
                                dispatchEvent(firstClick);
                            }
                        });
                        timer.schedule(firstClickTask, doubleClickInterval);
                        return;
                }
                
                
                
                
            } else if (e.getClickCount() == 2) {
                
                firstPressTask.cancel();
                firstReleaseTask.cancel();
                firstClickTask.cancel();
            
            }
        }
        
        //if (event instanceof MouseEvent && ((MouseEvent)event).getID()!=MouseEvent.MOUSE_MOVED)
        //    System.out.println(event.paramString());
        
        super.dispatchEvent(event);
    }

    public boolean isSuspend() {
        return suspend;
    }

    public void setSuspend(boolean suspend) {
        this.suspend = suspend;
    }
    
    private class DelayedMouseClickTimerTask extends TimerTask {
        
        private Runnable toRun;

        public DelayedMouseClickTimerTask(Runnable toRun) {
            this.toRun = toRun;
        }
        
        @Override
        public void run() {
            //cancel();
            //System.out.println("DelayedMouseClickTimerTask isDispatchThread? "+EventQueue.isDispatchThread());
            EventQueue.invokeLater(toRun);
        }   
    }
}
