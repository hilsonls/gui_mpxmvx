package dialogs.remote;

import bean.Remote;
import controllori.CtrlProtocol;
import eccezioni.MVException;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Marco Ricci & Antonio Poggi
 */
public class NetworkConfigDialog extends JDialog {
    
    private NetworkConfigPanel networkConfigPanel;
    private int idModulo;
    private Remote remote;
    
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;  
    
    public NetworkConfigDialog(Frame frame, Remote remote, int idModulo) {
        super(frame, true);
        setTitle("Remote's Network Configuration");
        setResizable(false);
        setDefaultCloseOperation(2);
        setLocation(100, 100);
        setSize(330, 260);
        
        this.idModulo = idModulo;
        this.remote = remote;
        
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
        
        networkConfigPanel = new NetworkConfigPanel(remote);
        getContentPane().add(networkConfigPanel, "Center");
    } 
    
    private class ButtonActionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent actionevent){
            Object obj = actionevent.getSource();
            if(obj == okButton){
                networkConfigPanel.verifyFields();
                if(okButton.hasFocus())
                    okAction();
            }
            else if(obj == cancelButton)
                cancelAction();
        }
    }
    
    private void okAction() {
        try {
            networkConfigPanel.save();
            CtrlProtocol.getInstance().saveRemoteToMV(idModulo, remote);
            dispose(); 
        } catch (MVException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    private void cancelAction(){
        dispose();
    }
}