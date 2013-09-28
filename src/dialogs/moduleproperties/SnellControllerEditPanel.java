package dialogs.moduleproperties;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bean.SnellController;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.IpAddressTextField;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.NotEmptyTextField;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author Michael Gardiner
 */
public class SnellControllerEditPanel extends JPanelBGGradient{
    private static final int BOUNDS_X = 0;
    private static final int BOUNDS_Y = 0; 
    private static final int MARGIN_X = 10;
    private static final int FIELD_SPACING_Y = 40;
    private static final int FIELD_H = 20;
    private static final int LABEL_X = MARGIN_X;
    private static final int NAME_LABEL_W = 60;
    private static final int IPADDR_LABEL_W = 150;
    private static final int START_Y = 20;
    private static final int NAME_FIELD_X = LABEL_X + NAME_LABEL_W;
    private static final int NAME_FIELD_W = 200;
    private static final int IPADDR_FIELD_X = LABEL_X + IPADDR_LABEL_W;
    private static final int IPADDR_FIELD_W = NAME_FIELD_W - (IPADDR_LABEL_W - NAME_LABEL_W);
    private static final int PORT_LABEL_X = IPADDR_FIELD_X + IPADDR_FIELD_W;
    private static final int PORT_LABEL_W = 60;
    private static final int PORT_FIELD_X = PORT_LABEL_X + PORT_LABEL_W + MARGIN_X;
    private static final int PORT_FIELD_W = 100;
    private static final int BOUNDS_W = PORT_FIELD_X + PORT_FIELD_W + MARGIN_X;
    private static final int USEABLE_W = BOUNDS_W - 2 * MARGIN_X;

    private SnellController bean;
    
    private JLabel nameLabel;
    private JTextField nameField;
    
    private JCheckBox dualControllerCheckBox;
   
    private JLabel[] ipAddrLabel;
    private IpAddressTextField[] ipAddrField;
    private JLabel[] portLabel;
    private JTextField[] portField;
    
            
    public SnellControllerEditPanel(SnellController bean) {
        setLayout(null);
        
        this.bean = bean;
        
        MyItemListener mIL = new MyItemListener();
        
        int y = START_Y;

        dualControllerCheckBox = new JCheckBoxTransBG();
        dualControllerCheckBox.setText("Dual controller");
        dualControllerCheckBox.setSelected(!(bean.getIpaddr2().equals("0.0.0.0") || bean.getIpaddr2().equals("")));
        dualControllerCheckBox.setBounds(LABEL_X, y, USEABLE_W, FIELD_H);
        dualControllerCheckBox.addActionListener(mIL);
        add(dualControllerCheckBox);
        y += FIELD_SPACING_Y;

        nameLabel = new JLabel();
        nameLabel.setText("Name");
        nameLabel.setBounds(LABEL_X, y, NAME_LABEL_W, FIELD_H);
        add(nameLabel);
        nameField = new NotEmptyTextField("Controller must have a name");
        nameField.setText(bean.getName());
        nameField.setEditable(true);
        nameField.setBounds(NAME_FIELD_X, y, NAME_FIELD_W, FIELD_H);
        add(nameField);
        y += FIELD_SPACING_Y;
        
        ipAddrLabel = new JLabel[2];
        ipAddrField = new IpAddressTextField[2];
        portLabel = new JLabel[2];
        portField = new JTextField[2];
        for (int i = 0; i < 2; i++, y += FIELD_SPACING_Y) {
            ipAddrLabel[i] = new JLabel();
            ipAddrLabel[i].setText(i == 0 ? "Controller 1 IP address" : "Controller 2 IP address");
            ipAddrLabel[i].setBounds(LABEL_X, y, IPADDR_LABEL_W, FIELD_H);
            add(ipAddrLabel[i]);
            ipAddrField[i] = new IpAddressTextField(false, false);
            ipAddrField[i].setText(i == 0 ? bean.getIpaddr1() : bean.getIpaddr2());
            ipAddrField[i].setBounds(IPADDR_FIELD_X, y, IPADDR_FIELD_W, FIELD_H);
            add(ipAddrField[i]);

            portLabel[i] = new JLabel();
            portLabel[i].setText("Port");
            portLabel[i].setBounds(PORT_LABEL_X, y, PORT_LABEL_W, FIELD_H);
            portLabel[i].setHorizontalAlignment(SwingConstants.RIGHT);
            add(portLabel[i]);
            int port = (i == 0 ? bean.getPort1() : bean.getPort2());
            portField[i] = ComponentFactory.createTextField(port, 0, 65535);
            portField[i].setBounds(PORT_FIELD_X, y, PORT_FIELD_W, FIELD_H);
            add(portField[i]);
        }
        
        ipAddrField[1].setEnabled(dualControllerCheckBox.isSelected());
        portField[1].setEnabled(dualControllerCheckBox.isSelected());
        
        setBounds(BOUNDS_X, BOUNDS_Y, BOUNDS_W, y + START_Y + FIELD_H);
    }
    
    public void save() throws MVException {
        verifyFields();
        bean.setName(getNameField().getText());
        bean.setIpaddr1(getIpAddrField(0).getText());
        bean.setPort1(Integer.parseInt(getPortField(0).getText()));
        if (dualControllerCheckBox.isSelected()) {
            bean.setIpaddr2(getIpAddrField(1).getText());
            bean.setPort2(Integer.parseInt(getPortField(1).getText()));
        } else {
            bean.setIpaddr2("");
            bean.setPort2(0);
        }
    }

    private void verifyFields() throws MVException {
        StringBuilder msg = new StringBuilder();
        
        if (nameField.getText().isEmpty()) {
            throw new MVException("Enter a name for the controller");
        }
        if (!ipAddrField[0].verify(msg)) {
            throw new MVException(msg.toString());
        }
        if (dualControllerCheckBox.isSelected() && !ipAddrField[1].verify(msg)) {
            throw new MVException(msg.toString());
        }
    }

    public JTextField getNameField() {
    	return nameField;
    }
    
    public JTextField getIpAddrField(int index) {
        return ipAddrField[index];
    }

    public JTextField getPortField(int index) {
        return portField[index];
    }
    
    private class MyItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Object obj = ae.getSource();
            if (obj == dualControllerCheckBox) {
                ipAddrField[1].setEnabled(dualControllerCheckBox.isSelected());
                portField[1].setEnabled(dualControllerCheckBox.isSelected());
            }
        }
    }

}
