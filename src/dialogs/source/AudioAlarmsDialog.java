package dialogs.source;

import bean.Source;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author dio
 */
public class AudioAlarmsDialog extends JDialog {
    
    
    private Source bean;
      
    private AudioAlarmsPanel audioAlarmsPanel;
    
    private JPanel buttonsPanel;
    private JButton okButton;
    
    
    private class ButtonActionListener implements ActionListener
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            Object obj = actionevent.getSource();
            if(obj == okButton)
                okAction();
           
           
        }
    }
    
    public AudioAlarmsDialog(Frame frame, AudioAlarmsPanel audioAlarmsPanel) {
        
        super(frame);
        
        
        this.audioAlarmsPanel = audioAlarmsPanel;
        ButtonActionListener buttonActionListener = new ButtonActionListener();
        
        setTitle("Audio Alarms");
        setResizable(false);
        setModal(true);
        setDefaultCloseOperation(2);
        setLocation(100, 100);
        setSize(460, 550);
        
        
        buttonsPanel = new JPanelBGGradient(StyleInterface.getInstance().getButtonPanelBackgroundTopColor(), StyleInterface.getInstance().getButtonPanelBackgroundBottomColor(),true);
        buttonsPanel.setLayout(new FlowLayout(1, 10, 10));
        buttonsPanel.setPreferredSize(new Dimension(40, 40));
        okButton = new JButton();
        okButton.setText("OK");
        okButton.setActionCommand("OK");
        okButton.setPreferredSize(new Dimension(100, 25));
        okButton.addActionListener(buttonActionListener);
        this.getRootPane().setDefaultButton(okButton);
        buttonsPanel.add(okButton);
        getContentPane().add(buttonsPanel, "South");
        
       
                       
        getContentPane().add(audioAlarmsPanel, "Center");
        setVisible(true);
    }

    private void okAction() {
        
            dispose();
            
    }
    
    
    
    
}
