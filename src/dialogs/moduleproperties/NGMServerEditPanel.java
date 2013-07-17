package dialogs.moduleproperties;

import bean.NgmServer;
import gui.components.IpAddressTextField;
import gui.components.JPanelBGGradient;
import gui.components.NotEmptyTextField;
import gui.style.StyleInterface;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Marco Ricci & Antonio Poggi
 */
public class NGMServerEditPanel extends JPanelBGGradient{
    private NgmServer bean;
    
    private JLabel aliasLabel;
    private JTextField aliasField;
   
    private JLabel ipAddrLabel;
    private JTextField ipAddrField;
    
            
    public NGMServerEditPanel(NgmServer bean) {
        setLayout(null);
        setBounds(1, 30, 450, 400);
        
        this.bean = bean;
    
 
        aliasLabel = new JLabel();
        aliasLabel.setText(StyleInterface.getInstance().getDataXXNgm()+ " Server Name");
        aliasLabel.setBounds(20, 20, 140, 20);
        add(aliasLabel);
        aliasField = new NotEmptyTextField(StyleInterface.getInstance().getDataXXNgm()+ " Server must have a name");
        aliasField.setText(bean.getAlias().getVal());
        aliasField.setEditable(true);
        aliasField.setBounds(160, 20, 180, 20);
        //aliasField.setFocusable(false);
        add(aliasField);
        //aliasField.requestFocusInWindow();
        
        
        ipAddrLabel = new JLabel();
        ipAddrLabel.setText("IP Address");
        ipAddrLabel.setBounds(20, 80, 140, 20);
        add(ipAddrLabel);
        ipAddrField = new IpAddressTextField(false);
        ipAddrField.setText(bean.getIpaddr().getVal());
        ipAddrField.setBounds(160, 80, 180, 20);
        add(ipAddrField);
        //getIpAddrField().requestFocusInWindow();
        
             
    }
    
    public void save() {
        bean.getAlias().setVal(getAliasField().getText());
        bean.getIpaddr().setVal(getIpAddrField().getText());
        
    }

    public void verifyFields() {
        
        getIpAddrField().requestFocusInWindow();
        getAliasField().requestFocusInWindow();
       
    }

    public JTextField getIpAddrField() {
        return ipAddrField;
    }

    public JTextField getAliasField() {
        return aliasField;
    }
    
    
    
    
    
}
