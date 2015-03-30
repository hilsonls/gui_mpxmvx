package dialogs.moduleproperties;

import java.awt.Color;

import bean.Port;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JPanelBGGradient;

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author antonio
 */
public class SerialPortsConfigurePanel extends JPanelBGGradient{

    private Port bean;

    private JLabel baudLabel;
    private JComboBox baudCombo;

    private JLabel bitsLabel;
    private JComboBox bitsCombo;

    private JLabel parityLabel;
    private JComboBox parityCombo;

    private JLabel stopLabel;
    private JComboBox stopCombo;

    private JLabel flowLabel;
    private JComboBox flowCombo;

    private JLabel protocolLabel;
    private JComboBox protocolCombo;
    
    private JLabel controllerLabel;

    public SerialPortsConfigurePanel(Port bean) throws MVException {

        setLayout(null);
        setBounds(1, 30, 400, 400);

        this.bean = bean;

        baudLabel = new JLabel();
        baudLabel.setText("Baud");
        baudLabel.setBounds(50, 20, 70, 20);
        baudLabel.setHorizontalAlignment(JLabel.RIGHT);
        add(baudLabel);
        baudCombo = ComponentFactory.createComboBox(bean.getBaud().getOptionsName(), bean.getBaud().getVal());
        baudCombo.setBounds(130, 20, 150, 20);
        add(baudCombo);

        bitsLabel = new JLabel();
        bitsLabel.setText("Data Bits");
        bitsLabel.setBounds(50, 50, 70, 20);
        bitsLabel.setHorizontalAlignment(JLabel.RIGHT);
        add(bitsLabel);
        bitsCombo = ComponentFactory.createComboBox(bean.getBits().getVal(), bean.getBits().getMin(), bean.getBits().getMax());
        bitsCombo.setBounds(130, 50, 150, 20);
        add(bitsCombo);

        parityLabel = new JLabel();
        parityLabel.setText("Parity");
        parityLabel.setBounds(50, 80, 70, 20);
        parityLabel.setHorizontalAlignment(JLabel.RIGHT);
        add(parityLabel);
        parityCombo = ComponentFactory.createComboBox(bean.getParity().getOptionsName(), bean.getParity().getVal());
        parityCombo.setBounds(130, 80, 150, 20);
        add(parityCombo);

        stopLabel = new JLabel();
        stopLabel.setText("Stop Bits");
        stopLabel.setBounds(50, 110, 70, 20);
        stopLabel.setHorizontalAlignment(JLabel.RIGHT);
        add(stopLabel);
        stopCombo = ComponentFactory.createComboBox(bean.getStop().getVal(), bean.getStop().getMin(), bean.getStop().getMax());
        stopCombo.setBounds(130, 110, 150, 20);
        add(stopCombo);

        flowLabel = new JLabel();
        flowLabel.setText("Flow Control");
        flowLabel.setBounds(50, 140, 70, 20);
        flowLabel.setHorizontalAlignment(JLabel.RIGHT);
        add(flowLabel);
        flowCombo = ComponentFactory.createComboBox(bean.getFlow().getOptionsName(), bean.getFlow().getVal());
        flowCombo.setBounds(130, 140, 150, 20);
        add(flowCombo);

        protocolLabel = new JLabel();
        protocolLabel.setText("Protocol");
        protocolLabel.setBounds(50, 170, 70, 20);
        protocolLabel.setHorizontalAlignment(JLabel.RIGHT);
        add(protocolLabel);
        protocolCombo = ComponentFactory.createComboBox(bean.getProtocol().getOptionsName(), bean.getProtocol().getVal());
        protocolCombo.setBounds(130, 170, 150, 20);
        add(protocolCombo);
        
        int controlSlot;
        if (bean.getController() != null)
            controlSlot = bean.getController().getVal();
        else
            controlSlot = -1;
        if (controlSlot >= 0) {
            controllerLabel = new JLabel();
            controllerLabel.setBounds(50, 200, 250, 20);
            controllerLabel.setText("Card in slot " + controlSlot + " has control of the serial port");
            controllerLabel.setForeground(Color.RED);
            add(controllerLabel);
            baudCombo.setEnabled(false);
            bitsCombo.setEnabled(false);
            parityCombo.setEnabled(false);
            stopCombo.setEnabled(false);
            flowCombo.setEnabled(false);
        }
    }

    public void save() {
        bean.getBaud().setVal(baudCombo.getSelectedItem().toString());
        bean.getBits().setVal(Integer.parseInt(bitsCombo.getSelectedItem().toString()));
        bean.getFlow().setVal(flowCombo.getSelectedItem().toString());
        bean.getParity().setVal(parityCombo.getSelectedItem().toString());
        bean.getProtocol().setVal(protocolCombo.getSelectedItem().toString());
        bean.getStop().setVal(Integer.parseInt(stopCombo.getSelectedItem().toString()));
    }

}
