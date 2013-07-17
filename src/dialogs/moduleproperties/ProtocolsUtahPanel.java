/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.moduleproperties;

import bean.UtahUSI;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author panda
 */
public class ProtocolsUtahPanel extends JPanelBGGradient {

    private UtahUSI bean;

    private JLabel tcpPortLabel;
    private JTextField tcpPortField;

    private JCheckBox enabledCheck;

    ProtocolsUtahPanel(UtahUSI bean) {
    
        setLayout(null);
        setBounds(1, 30, 400, 400);

        this.bean = bean;

        tcpPortLabel = new JLabel();
        tcpPortLabel.setText("TCP Port");
        tcpPortLabel.setBounds(20, 20, 80, 20);
        add(tcpPortLabel);
        tcpPortField = ComponentFactory.createTextField(bean.getTcpPort().getVal(), bean.getTcpPort().getMin(), bean.getTcpPort().getMax());
        tcpPortField.setBounds(120, 20, 80, 20);
        add(tcpPortField);

        enabledCheck = new JCheckBoxTransBG();
        enabledCheck.setText("Enabled");
        enabledCheck.setBounds(20, 50, 120, 20);
        enabledCheck.setSelected(bean.getEnabled().getVal());
        add(enabledCheck);
    }

    public void save() {
        bean.getTcpPort().setVal(Integer.parseInt(tcpPortField.getText()));
        bean.getEnabled().setVal(enabledCheck.isSelected());
    }

}
