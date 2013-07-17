package dialogs.audiosetup;

import bean.AudioSetup;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Marco Ricci & Antonio Poggi
 */
public class AudioSetupDialog extends JDialog {
    
    private AudioSetupPanel audioSetupPanel;
    
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;
    
    private int idModulo;
    
    
    public AudioSetupDialog(Frame frame, int idModulo, AudioSetup bean) throws MVException {
        super(frame);
        
        //memorizzo l'id del modulo;
        this.idModulo = idModulo;
        
        
        setTitle("Audio Setup");
        setResizable(false);
        setModal(true);
        setDefaultCloseOperation(2);
        setLocation(100, 100);
        setSize(350, 350);
        
        ButtonActionListener buttonActionListener = new ButtonActionListener();
        
        buttonsPanel = new JPanelBGGradient(StyleInterface.getInstance().getButtonPanelBackgroundTopColor(), StyleInterface.getInstance().getButtonPanelBackgroundBottomColor(),true);
        buttonsPanel.setLayout(new FlowLayout(1, 10, 10));
        buttonsPanel.setPreferredSize(new Dimension(40, 40));
        okButton = new JButton();
        okButton.setText("OK");
        okButton.setActionCommand("OK");
        okButton.addActionListener(buttonActionListener);
        okButton.setPreferredSize(new Dimension(100, 25));
        this.getRootPane().setDefaultButton(okButton);
        buttonsPanel.add(okButton);
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        cancelButton.setActionCommand("Cancel");
        cancelButton.addActionListener(buttonActionListener);
        cancelButton.setPreferredSize(new Dimension(100, 25));
        buttonsPanel.add(cancelButton);
        getContentPane().add(buttonsPanel, "South");
        
        audioSetupPanel = new AudioSetupPanel(frame, idModulo, bean);
        getContentPane().add(audioSetupPanel, "Center");
        setVisible(true);
    } 
    
    private class ButtonActionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent actionevent){
            Object obj = actionevent.getSource();
            if(obj == okButton)
                okAction();
            else if(obj == cancelButton)
                cancelAction();
        }
    }
    
    private void okAction() {
        try {
            audioSetupPanel.save();
            CtrlWorkspace.getInstance().saveAudioSetupToMV(idModulo);
            dispose();
        } catch (MVException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    private void cancelAction(){
        
        dispose();
    
    }
}