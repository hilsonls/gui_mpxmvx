/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.components;

import gui.style.StyleInterface;
import gui.style.StyleInterface;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Antonio
 */
public class ChangeListenerColorHandled implements ChangeListener {

    private int lastSelectedIndex = -1;
    private Color bg;
    private Color fg;

    public void stateChanged( ChangeEvent e )
      {
        JTabbedPane tab = (JTabbedPane)e.getSource();
        if( lastSelectedIndex != -1 )
        {
          tab.setForegroundAt( lastSelectedIndex, fg );
          tab.setBackgroundAt( lastSelectedIndex, bg);
        }


        int sIdx = tab.getSelectedIndex();
        Color fg = Color.black;
        Color bg = Color.white;

        if (sIdx !=-1){
        tab.setForegroundAt( sIdx, fg );
        tab.setBackgroundAt( sIdx, bg );
        }
        lastSelectedIndex = sIdx;
      }

    public ChangeListenerColorHandled( Color bg, Color fg) {
        this.bg=bg;
        this.fg=fg;
    }

    public ChangeListenerColorHandled() {
        this.bg= StyleInterface.getInstance().getTabbedPaneBackgroundColor();
        this.fg= StyleInterface.getInstance().getTabbedPaneForegroundColor();
    }





}
