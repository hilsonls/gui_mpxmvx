package dialogs.timercontrol;

import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.TileObject;
import gui.TilesWorkspace;
import gui.components.BoundedIntTextField;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;
import gui.style.StyleInterface;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author michael
 */
public class TimerControlDialog extends JDialog{
    
    private JPanel buttonsPanel;
    private JButton closeButton;
    
    private JPanel controlButtonsPanel;
    private JButton resetButton;
    private JButton startButton;
    private JButton stopButton;
    
    private JTextField resetHour;
    private JTextField resetMinute;
    private JTextField resetSecond;
    private JLabel resetHourLabel;
    private JLabel resetMinuteLabel;
    private JLabel resetSecondLabel;
    
    private TilesWorkspace tilesWorkspace;
    
    private Timer timer;
    
    private int idModulo;
    
    public TimerControlDialog(Frame frame, TilesWorkspace tilesWorkspace, int idModulo) throws MVException {
        super(frame);
        
        this.tilesWorkspace = tilesWorkspace;
        this.idModulo = idModulo;
        
        tilesWorkspace.addTimerControl(tilesWorkspace.getSelectedObject(), this);
        
        setTitle("Timer control (" + tilesWorkspace.getSelectedObject().getItemName() + ")");
        setResizable(false);
        setModal(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Locate the dialog where the mouse is
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration());
        screenSize.width -= insets.right;
        screenSize.height -= insets.bottom;
        Dimension size = new Dimension(250, 180);
        Point location = MouseInfo.getPointerInfo().getLocation();
        if (location.x + size.width > screenSize.width) {
            location.x = screenSize.width - size.width;
        }
        if (location.y + size.height > screenSize.height) {
            location.y = screenSize.height - size.height;
            if (location.y < insets.top) {
                size.height += location.y;
                size.height -= insets.top;
                location.y = insets.top;
            }
        }
        setLocation(location);
        setSize(size);
        
        ButtonActionListener buttonActionListener = new ButtonActionListener();
        
        buttonsPanel = new JPanelBGGradient(StyleInterface.getInstance().getButtonPanelBackgroundTopColor(), StyleInterface.getInstance().getButtonPanelBackgroundBottomColor(),true);
        buttonsPanel.setLayout(new FlowLayout(1, 10, 10));
        buttonsPanel.setPreferredSize(new Dimension(40, 40));
        closeButton = new JButton();
        closeButton.setText("Close");
        closeButton.setActionCommand("OK");
        closeButton.addActionListener(buttonActionListener);
        closeButton.setPreferredSize(new Dimension(100, 25));
        this.getRootPane().setDefaultButton(closeButton);
        buttonsPanel.add(closeButton);
        getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
        
//        controlButtonsPanel = new JPanelBGGradient(StyleInterface.getInstance().getButtonPanelBackgroundTopColor(), StyleInterface.getInstance().getButtonPanelBackgroundBottomColor(),true);
        controlButtonsPanel = new JPanel();
        VGroupLayout controlButtonsLayout = new VGroupLayout(controlButtonsPanel);
        controlButtonsPanel.setLayout(controlButtonsLayout);
        controlButtonsPanel.setPreferredSize(new Dimension(40, 80));
        resetButton = new JButton();
        resetButton.setText("Reset");
        resetButton.addActionListener(buttonActionListener);
        resetButton.setPreferredSize(new Dimension(200, 25));
        startButton = new JButton();
        startButton.setText("Start");
        startButton.addActionListener(buttonActionListener);
        startButton.setPreferredSize(new Dimension(100, 25));
        stopButton = new JButton();
        stopButton.setText("Stop");
        stopButton.addActionListener(buttonActionListener);
        stopButton.setPreferredSize(new Dimension(100, 25));
        controlButtonsLayout.addRow(new Component[] {
                resetButton, startButton, stopButton
        });
        
        TileObject tileObject = tilesWorkspace.getSelectedObject();
        int startTime = tileObject.getBean().getObjectSequence().getTimerProperties().getStartTime().getVal();
        int [] startTimeFields = secToHourMinSec(startTime);
        resetHourLabel = new JLabel("hh");
        resetHourLabel.setMaximumSize(new Dimension(20, 20));
        resetHour = new BoundedIntTextField(startTimeFields[0], 0, 23, true);
        resetHour.setMaximumSize(new Dimension(20, 20));
        resetMinuteLabel = new JLabel("mm");
        resetMinuteLabel.setMaximumSize(new Dimension(20, 20));
        resetMinute = new BoundedIntTextField(startTimeFields[1], 0, 59, true);
        resetMinute.setMaximumSize(new Dimension(20, 20));
        resetSecondLabel = new JLabel("ss");
        resetSecondLabel.setMaximumSize(new Dimension(20, 20));
        resetSecond = new BoundedIntTextField(startTimeFields[2], 0, 59, true);
        resetSecond.setMaximumSize(new Dimension(20, 20));
        controlButtonsLayout.addGrid(new Component[][] {
                {resetHourLabel, resetMinuteLabel, resetSecondLabel},
                {resetHour, resetMinute, resetSecond},
        });
        
        getContentPane().add(controlButtonsPanel, BorderLayout.NORTH);
        
        addEscapeListener();
        addCloseListener();
        addTimer();
        
        setVisible(true);
    } 
    
    private class ButtonActionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent actionevent){
            Object obj = actionevent.getSource();
            if(obj == closeButton)
                okAction();
            else if (obj == resetButton)
                resetAction();
            else if (obj == startButton)
                startAction();
            else if (obj == stopButton)
                stopAction();
        }
    }
    
    private void closingAction() {
        timer.stop();
        tilesWorkspace.removeTimerControl(this);
    }

    private void okAction() {
        closingAction();
        dispose();
    }
    
    /**
     * Close dialog when Esc key pressed
     */
    private void addEscapeListener() {
        ActionListener escListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                okAction();
            }
        };
        
        getRootPane().registerKeyboardAction(escListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    
    private void addCloseListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closingAction();
                super.windowClosing(e);
            }
        });
    }
    
    private void timerEvent() {
        if (!tilesWorkspace.isTimerControlValid(this))
            okAction();
    }
    
    private void addTimer() {
        ActionListener timerListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                timerEvent();
            }
            
        };
        
        timer = new Timer(1000, timerListener);
        timer.start();
    }
    
    private void resetAction() {
        TileObject tile = tilesWorkspace.getTimerControlTileObject(this);
        if (tile != null) {
            int hms = HourMinSecToSecs(new int[]{Integer.valueOf(resetHour.getText()),Integer.valueOf(resetMinute.getText()),Integer.valueOf(resetSecond.getText())});
            tile.getBean().getObjectSequence().getTimerProperties().getStartTime().setVal(hms);
            sendAction("reset", "startTime=\"" + hms + "\"");
        } else {
            sendAction("reset", "");
        }
    }
    
    private void startAction() {
        sendAction("start", "");
    }
    
    private void stopAction() {
        sendAction("stop", "");
    }
    
    private void sendAction(String s, String extraAttr) {
        try {
            int id = tilesWorkspace.getTimerControlTileId(this);
            CtrlWorkspace.getInstance().sendTimerAction(0, id, s, extraAttr);
        } catch (MVException ex) {
            // TODO
        }
    }
    
    private int[] secToHourMinSec(int secs) {
        int[] fields = new int[]{0, 0, 0};
        int hours = secs / 3600;
        int minutes = secs / 60 - hours * 60 ;
        int seconds = secs % 60;
        fields[0] = hours;
        fields[1] = minutes;
        fields[2] = seconds;
        return fields;
    }
    
    private int HourMinSecToSecs(int[] fields) {
        int secs = 0;
        secs += fields[0] * 3600;
        secs += fields[1] * 60;
        secs += fields[2];
        return secs;
    }
    
}
