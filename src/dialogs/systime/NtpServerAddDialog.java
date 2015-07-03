package dialogs.systime;

import bean.NtpServer;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Marco Ricci & Antonio Poggi
 */
public class NtpServerAddDialog extends JDialog {
    
    private NtpServerAddPanel ntpServerAddPanel;
    private int idModulo;
    private NtpServer bean;
    
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;  
    
    
    public NtpServerAddDialog(Frame frame, int idModulo) {
        super(frame, true);
        setTitle("Add NTP Server");
        setResizable(false);
        setDefaultCloseOperation(0);
        setLocation(100, 100);
        setSize(380, 220);
        setPreferredSize(new Dimension(380, 220));
        
        this.idModulo = idModulo;
        this.bean = new NtpServer();
        
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
        
        ntpServerAddPanel = new NtpServerAddPanel(bean);
        ntpServerAddPanel.getHostField().getDocument().addDocumentListener(new HostActionListener());
        okButton.setEnabled(!ntpServerAddPanel.getHostField().getText().isEmpty());
        getContentPane().add(ntpServerAddPanel, "Center");
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
    
    private class HostActionListener implements DocumentListener {

        @Override
        public void changedUpdate(DocumentEvent arg0) {
            okButton.setEnabled(!ntpServerAddPanel.getHostField().getText().isEmpty());
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            okButton.setEnabled(!ntpServerAddPanel.getHostField().getText().isEmpty());
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            okButton.setEnabled(!ntpServerAddPanel.getHostField().getText().isEmpty());
        }
    }
    
    private void okAction() {
        try {
            ntpServerAddPanel.save();
            CtrlWorkspace.getInstance().addNtpServerToMV(idModulo, bean);
            dispose(); 
        } catch (MVException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    private void cancelAction(){
        dispose();
    }
}