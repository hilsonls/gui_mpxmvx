package dialogs.moduleproperties;

import bean.Network;
import bean.SnmpMgr;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.IpAddressTextField;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Marco Ricci & Antonio Poggi
 */
public class NetworkPanel extends JPanelBGGradient{
    private Network bean;
    private Frame frame;
    private int idModulo;
    
    private JLabel hostnameLabel;
    private JTextField hostnameField;
    
    private JCheckBox dhcpCheck;
    
    private JLabel ipAddrLabel;
    private JTextField ipAddrField;
    
    private JLabel netmaskLabel;
    private JTextField netmaskField;
    
    private JLabel gatewayLabel;
    private JTextField gatewayField;
    
    private JLabel dns1Label;
    private JTextField dns1Field;
    
    private JLabel dns2Label;
    private JTextField dns2Field;
    
    private JButton applyButton;
    
    private JSeparator separator;
    
    private JLabel snmpVLabel;
    private JRadioButton snmpV1Radio;
    private JRadioButton snmpV2Radio;
    private ButtonGroup snmpVGroup;
    
    private JLabel snmpLabel;
    private JList snmpList;
    private DefaultListModel snmpListModel;
    private JButton addButton;
    private JButton deleteButton;
            
    public NetworkPanel(Network bean, int idModulo, Frame frame) {
        setLayout(null);
        setBounds(1, 30, 400, 400);
        
        this.bean = bean;
        this.idModulo = idModulo;
        this.frame = frame;
        MyItemListener mIL = new MyItemListener();
        
        hostnameLabel = new JLabel();
        hostnameLabel.setText("Hostname");
        hostnameLabel.setBounds(20, 20, 100, 20);
        add(hostnameLabel);
        hostnameField = ComponentFactory.createTextField(bean.getHostname().getVal(), 40);
        hostnameField.setBounds(120, 20, 180, 20);
        add(hostnameField);
        
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
    
        dns1Label = new JLabel();
        dns1Label.setText("DNS Server 1");
        dns1Label.setBounds(20, 170, 100, 20);
        add(dns1Label);
        dns1Field = new IpAddressTextField(true);
        dns1Field.setText(bean.getDns(0).getVal());
        dns1Field.setBounds(120, 170, 180, 20);
        add(dns1Field);
        
        dns2Label = new JLabel();
        dns2Label.setText("DNS Server 2");
        dns2Label.setBounds(20, 200, 100, 20);
        add(dns2Label);
        dns2Field = new IpAddressTextField(true);
        dns2Field.setText(bean.getDns(1).getVal());
        dns2Field.setBounds(120, 200, 180, 20);
        add(dns2Field);
        
        applyButton = new JButton();
        applyButton.setText("Apply");
        applyButton.addActionListener(mIL);
        applyButton.setBounds(140, 230, 80, 20);
        add(applyButton);
        
        separator = new JSeparator();
        separator.setBounds(5, 260, 370, 2);
        add(separator);
    
        snmpVLabel = new JLabel();
        snmpVLabel.setText("SNMP Version");
        snmpVLabel.setBounds(20, 270, 100, 20);
        add(snmpVLabel);
        snmpV1Radio = new JRadioButton();
        snmpV1Radio.setOpaque(false);
        snmpV1Radio.setText("v1");
        snmpV1Radio.setSelected(!bean.getSnmpv2c().getVal());
        snmpV1Radio.setBounds(145, 270, 50, 20);
        add(snmpV1Radio);
        snmpV2Radio = new JRadioButton();
        snmpV2Radio.setOpaque(false);
        snmpV2Radio.setText("v2c");
        snmpV2Radio.setSelected(bean.getSnmpv2c().getVal());
        snmpV2Radio.setBounds(195, 270, 60, 20);
        add(snmpV2Radio);
        snmpVGroup = new ButtonGroup();
        snmpVGroup.add(snmpV1Radio);
        snmpVGroup.add(snmpV2Radio);
    
        snmpLabel = new JLabel();
        snmpLabel.setText("SNMP");
        snmpLabel.setBounds(20, 300, 100, 20);
        add(snmpLabel);
        snmpListModel = new DefaultListModel();
        Iterator it = bean.getSnmpMgrs().iterateSnmpMgr();
        while (it.hasNext()) {
            SnmpMgr snmpMgr = (SnmpMgr)it.next();
            snmpListModel.addElement(snmpMgr.getVal());
        }
        snmpList = new JList(snmpListModel);
        snmpList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        snmpList.setBorder(BorderFactory.createLoweredBevelBorder());
        snmpList.setBounds(120, 300, 160, 100);
        JScrollPane sp = new JScrollPane();
        sp.setOpaque(true);
        sp.getViewport().add(snmpList);
        sp.setBounds(120, 300, 160, 100);
        add(sp);
        addButton = new JButton();
        addButton.setText("Add");
        addButton.addActionListener(mIL);
        addButton.setBounds(290, 325, 80, 20);
        add(addButton);
        deleteButton = new JButton();
        deleteButton.setText("Delete");
        deleteButton.addActionListener(mIL);
        deleteButton.setBounds(290, 355, 80, 20);
        add(deleteButton);

        checkComponentEnablingConditions();
    }
    
    public void save() {
        save(false);
    }
    
    private void save(boolean applyBtn) {
        bean.getHostname().setVal(hostnameField.getText());
        bean.getDhcp().setVal(dhcpCheck.isSelected());
        bean.getIpaddr().setVal(ipAddrField.getText());
        bean.getNetmask().setVal(netmaskField.getText());
        bean.getGateway().setVal(gatewayField.getText());
        bean.getDns(0).setVal(dns1Field.getText());
        bean.getDns(1).setVal(dns2Field.getText());
        
        if (!applyBtn) {
            bean.getSnmpv2c().setVal(snmpV2Radio.isSelected());
        }
    }
    
    private void checkComponentEnablingConditions() {
        boolean useDhcp = dhcpCheck.isSelected();
        ipAddrField.setEnabled(!useDhcp);
        netmaskField.setEnabled(!useDhcp);
        gatewayField.setEnabled(!useDhcp);
        dns1Field.setEnabled(!useDhcp);
        dns2Field.setEnabled(!useDhcp);
    }
    
    private void applyButton() {
        int choice = JOptionPane.showConfirmDialog(null, "If you apply these network settings now the application will close \nand you will have to restart it in the browser using the new IP address", "Are you sure you want to apply the network settings?", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            save(true);
            try {
                CtrlWorkspace.getInstance().saveNetworkToMV(idModulo, true);
                System.exit(0);
            } catch (MVException mve) {
                JOptionPane.showMessageDialog(null, "An error has occurred while applying network settings", "Operation aborted", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void addButton() {
        IpAddressCustomDialog ipAddrCD = new IpAddressCustomDialog(frame);
        ipAddrCD.pack();
        ipAddrCD.setLocationRelativeTo(this);
        ipAddrCD.setVisible(true);
        
        String ipAddr = ipAddrCD.getValidatedText();
        
        if (ipAddr!=null) {
            try {
                CtrlWorkspace.getInstance().addSnmpMgr(idModulo, ipAddr);
                snmpListModel.addElement(ipAddr);
            } catch (MVException mve) {
               JOptionPane.showMessageDialog(null, "An error has occurred while adding SNMP server entry", "Operation aborted", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    }
    
    private void deleteButton() {
        String selected = (String)snmpList.getSelectedValue();
        
        if (selected != null) {
            try {
                CtrlWorkspace.getInstance().removeSnmpMgr(idModulo, selected);
                snmpListModel.removeElement(selected);
            } catch (MVException mve) {
                JOptionPane.showMessageDialog(null, "An error has occurred while deleting selected SNMP server entry", "Operation aborted", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class MyItemListener implements ItemListener, ActionListener {

        public void itemStateChanged(ItemEvent ie) {
            checkComponentEnablingConditions();
        }

        public void actionPerformed(ActionEvent ae) {
            Object obj = ae.getSource();
            if (obj == applyButton)
                applyButton();
            else if (obj == addButton) {
                addButton();
            } else if (obj == deleteButton) {
                deleteButton();
            }
        }
    }
    
    private class IpAddressCustomDialog extends JDialog implements ActionListener, PropertyChangeListener {
        private static final String _255 = "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        private static final String IP_REGEX = "^(?:" + _255 + "\\.){3}" + _255 + "$";
        
        private String typedText = null;
        private JTextField textField;

        private JOptionPane optionPane;

        private String btnString1 = "Add";
        private String btnString2 = "Cancel";

        /**
         * Returns null if the typed string was invalid;
         * otherwise, returns the string as the user entered it.
         */
        public String getValidatedText() {
            return typedText;
        }

        public IpAddressCustomDialog(Frame frame) {
            super(frame, true);
            //dd = parent;

            setTitle("Add SNMP Server");

            //Array di componenti da visualizzare.
            String msgString1 = "Insert SNMP Server ip address";
            textField = new JTextField();
            Object[] array = {msgString1, textField};

            //Array di stringhe usate per creare i pulsanti da visualizzare
            Object[] options = {btnString1, btnString2};

            optionPane = new JOptionPane(array,
                                        JOptionPane.QUESTION_MESSAGE,
                                        JOptionPane.YES_NO_OPTION,
                                        null,
                                        options,
                                        options[0]);

            setContentPane(optionPane);

            //Handle window closing correctly.
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                    public void windowClosing(WindowEvent we) {
                    /*
                     * Instead of directly closing the window,
                     * we're going to change the JOptionPane's
                     * value property.
                     */
                        optionPane.setValue(new Integer(
                                            JOptionPane.CLOSED_OPTION));
                }
            });

            //Ensure the text field always gets the first focus.
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent ce) {
                    textField.requestFocusInWindow();
                }
            });

            //Register an event handler that puts the text into the option pane.
            textField.addActionListener(this);

            //Register an event handler that reacts to option pane state changes.
            optionPane.addPropertyChangeListener(this);
        }

        /** This method handles events for the text field. */
        public void actionPerformed(ActionEvent e) {
            optionPane.setValue(btnString1);
        }

        /** This method reacts to state changes in the option pane. */
        public void propertyChange(PropertyChangeEvent e) {
            String prop = e.getPropertyName();

            if (isVisible()
             && (e.getSource() == optionPane)
             && (JOptionPane.VALUE_PROPERTY.equals(prop) ||
                 JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
                Object value = optionPane.getValue();

                if (value == JOptionPane.UNINITIALIZED_VALUE) {
                    //ignore reset
                    return;
                }

                //Reset the JOptionPane's value.
                //If you don't do this, then if the user
                //presses the same button next time, no
                //property change event will be fired.
                optionPane.setValue(
                        JOptionPane.UNINITIALIZED_VALUE);

                if (btnString1.equals(value)) {
                    if (textField.getText().trim().matches(IP_REGEX)) {
                        //we're done; clear and dismiss the dialog
                        typedText = textField.getText().trim();
                        clearAndHide();
                    } else {
                        //text was invalid
                        textField.selectAll();
                        JOptionPane.showMessageDialog(IpAddressCustomDialog.this,
                                                      "Please insert a valid ip address",
                                                      "Invalid Value",
                                                      JOptionPane.WARNING_MESSAGE);
                                       
                        typedText = null;
                        textField.requestFocusInWindow();
                    }
                } else { 
                    typedText = null;
                    clearAndHide();
                }
            }
        }

        /** This method clears the dialog and hides it. */
        public void clearAndHide() {
            textField.setText(null);
            setVisible(false);
        }
    }
}
