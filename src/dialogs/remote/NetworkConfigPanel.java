package dialogs.remote;

import bean.Remote;
import gui.components.IpAddressTextField;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Marco Ricci & Antonio Poggi
 */
public class NetworkConfigPanel extends JPanelBGGradient{
    private Remote bean;
    
    private JLabel macAddrLabel;
    private JTextField macAddrField;
    
    private JCheckBox dhcpCheck;
    
    private JLabel ipAddrLabel;
    private JTextField ipAddrField;
    
    private JLabel netmaskLabel;
    private JTextField netmaskField;
    
    private JLabel gatewayLabel;
    private JTextField gatewayField;
            
    public NetworkConfigPanel(Remote bean) {
        setLayout(null);
        setBounds(1, 30, 400, 400);
        
        this.bean = bean;
        MyItemListener mIL = new MyItemListener();
 
        macAddrLabel = new JLabel();
        macAddrLabel.setText("MAC Address");
        macAddrLabel.setBounds(20, 20, 100, 20);
        add(macAddrLabel);
        macAddrField = new JTextField();
        macAddrField.setText(bean.getMac().getVal());
        macAddrField.setEditable(false);
        macAddrField.setBounds(120, 20, 180, 20);
        add(macAddrField);
        
        dhcpCheck = new JCheckBoxTransBG();
        dhcpCheck.setText("Use DHCP");
        dhcpCheck.setSelected(bean.getDhcp().getVal());
        dhcpCheck.addItemListener(mIL);
        dhcpCheck.setBounds(20, 50, 120, 20);
        add(dhcpCheck);
        
        ipAddrLabel = new JLabel();
        ipAddrLabel.setText("IP Address");
        ipAddrLabel.setBounds(20, 80, 100, 20);
        add(ipAddrLabel);
        ipAddrField = new IpAddressTextField(false);
        ipAddrField.setText(bean.getIpaddr().getVal());
        ipAddrField.setBounds(120, 80, 180, 20);
        add(ipAddrField);
        
        netmaskLabel = new JLabel();
        netmaskLabel.setText("Netmask");
        netmaskLabel.setBounds(20, 110, 100, 20);
        add(netmaskLabel);
        netmaskField = new IpAddressTextField(false);
        netmaskField.setText(bean.getNetmask().getVal());
        netmaskField.setBounds(120, 110, 180, 20);
        add(netmaskField);

        gatewayLabel = new JLabel();
        gatewayLabel.setText("Gateway");
        gatewayLabel.setBounds(20, 140, 100, 20);
        add(gatewayLabel);
        gatewayField = new IpAddressTextField(true);
        gatewayField.setText(bean.getGateway().getVal());
        gatewayField.setBounds(120, 140, 180, 20);
        add(gatewayField);
          
    }
    
    public void save() {
        bean.getDhcp().setVal(dhcpCheck.isSelected());
        bean.getIpaddr().setVal(ipAddrField.getText());
        bean.getNetmask().setVal(netmaskField.getText());
        bean.getGateway().setVal(gatewayField.getText());
    }
    
    private void checkComponentEnablingConditions() {
        boolean useDhcp = dhcpCheck.isSelected();
        ipAddrField.setEnabled(!useDhcp);
        netmaskField.setEnabled(!useDhcp);
        gatewayField.setEnabled(!useDhcp);
    }
    
    private class MyItemListener implements ItemListener {

        public void itemStateChanged(ItemEvent ie) {
            checkComponentEnablingConditions();
        }
    }
    
        public void verifyFields() {
        
        ipAddrField.requestFocusInWindow();
        netmaskField.requestFocusInWindow();
        gatewayField.requestFocusInWindow();
        
    }
}
