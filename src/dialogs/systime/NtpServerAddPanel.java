package dialogs.systime;

import bean.NtpServer;
import gui.components.JPanelBGGradient;
import gui.components.NotEmptyTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Marco Ricci & Antonio Poggi
 */
public class NtpServerAddPanel extends JPanelBGGradient{
    private NtpServer bean;
    
    private JLabel hostLabel;
    private JTextField hostField;
            
    public NtpServerAddPanel(NtpServer bean) {
        setLayout(null);
        setBounds(1, 30, 450, 300);
        
        this.bean = bean;
    
 
        hostLabel = new JLabel();
        hostLabel.setText("NTP server name");
        hostLabel.setBounds(20, 20, 120, 20);
        add(hostLabel);
        hostField = new NotEmptyTextField("NTP Server must have a name");
        hostField.setText("");
        hostField.setEditable(true);
        hostField.setBounds(160, 20, 180, 20);
        add(hostField);
    }
    
    public void save() {
        bean.setVal(hostField.getText());        
    }

    public void verifyFields() {
        hostField.requestFocusInWindow();
        //getIpAddrField().requestFocusInWindow();
        //getAliasField().requestFocusInWindow();
       
    }
/*
    public JTextField getIpAddrField() {
        return ipAddrField;
    }

    public JTextField getAliasField() {
        return aliasField;
    }
  */  
    
    
    
    
}
