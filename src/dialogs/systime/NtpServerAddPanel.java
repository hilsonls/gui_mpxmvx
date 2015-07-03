package dialogs.systime;

import bean.NtpServer;
import gui.components.JPanelBGGradient;
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
        hostField = new JTextField();
        hostField.setText("");
        hostField.setEditable(true);
        hostField.setBounds(160, 20, 180, 20);
        add(hostField);
    }
    
    public void save() {
        bean.setVal(hostField.getText());        
    }

    public JTextField getHostField() {
        return hostField;
    }
}
