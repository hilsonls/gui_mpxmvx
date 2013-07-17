package dialogs.moduleproperties;

import bean.SnellRouter;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.ChangeListenerColorHandled;
import gui.components.IpAddressTextField;
import gui.components.JCheckBoxTransBG;
import gui.components.JDioTabbedPane;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class ProtocolsSnellPanel extends JPanelBGGradient{
    private SnellRouter bean;

    JCheckBox enabledCheck;
    JLabel ipAddrLabel;
    JTextField ipAddrField;
    JLabel portLabel;
    JTextField portField;
    JLabel routerLabel;
    private JTabbedPane tabbedPane;

    private ProtocolsSnellVideoPanel protSnellVideoPanel;
    private ProtocolsSnellAudioPanel protSnellAudioPanel;
    private ProtocolsSnellDataxxPanel protSnellDataxxPanel;


    public ProtocolsSnellPanel(SnellRouter bean) throws MVException {
        setLayout(null);

        this.bean = bean;

        MyItemListener mIL = new MyItemListener();

        enabledCheck = new JCheckBoxTransBG();
        enabledCheck.setText("Use TCP/IP");
        enabledCheck.setSelected(bean.getUseTcpIp().getVal());
        enabledCheck.addItemListener(mIL);
        enabledCheck.setBounds(10, 10, 100, 20);
        add(enabledCheck);
        ipAddrLabel = new JLabel();
        ipAddrLabel.setText("IP Address");
        ipAddrLabel.setBounds(115, 10, 70, 20);
        add(ipAddrLabel);
        ipAddrField = new IpAddressTextField(false);
        ipAddrField.setText(bean.getIpaddr().getVal());
        ipAddrField.setBounds(185, 10, 110, 20);
        add(ipAddrField);
        portLabel = new JLabel();
        portLabel.setText("TCP Port");
        portLabel.setBounds(300, 10, 55, 20);
        add(portLabel);
        portField = ComponentFactory.createTextField(bean.getTcpPort().getVal(), bean.getTcpPort().getMin(), bean.getTcpPort().getMax());
        portField.setBounds(360, 10, 50, 20);
        add(portField);

        routerLabel = new JLabel();
        routerLabel.setText((bean.getUseTcpIp().getVal()?"Router connection: Ethernet":"Router connection: Serial Port"));
        routerLabel.setBounds(10, 35, 300, 20);
        add(routerLabel);

        protSnellVideoPanel = new ProtocolsSnellVideoPanel(bean.getVideo());
        protSnellAudioPanel = new ProtocolsSnellAudioPanel(bean.getAudioSnell());
        protSnellDataxxPanel = new ProtocolsSnellDataxxPanel(bean.getDataxx());
        
        tabbedPane = new JDioTabbedPane();
        tabbedPane.setUI(new BasicTabbedPaneUI());
        tabbedPane.setBackground(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor());
        tabbedPane.addChangeListener(new ChangeListenerColorHandled(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor(), StyleInterface.getInstance().getTabbedPaneForegroundColor()));
        tabbedPane.setBounds(5, 55, 440, 420);
        tabbedPane.add(protSnellVideoPanel);
        tabbedPane.setTitleAt(0, "Video Router");
        tabbedPane.add(protSnellAudioPanel);
        tabbedPane.setTitleAt(1, "Ext Audio Router");
        tabbedPane.add(protSnellDataxxPanel);
        tabbedPane.setTitleAt(2, "Data-xx Router");
        tabbedPane.setSelectedComponent(protSnellVideoPanel);
        add(tabbedPane);

        checkComponentEnablingConditions();
        //setVisible(true);
    }

    public void save() {
        bean.getUseTcpIp().setVal(enabledCheck.isSelected());
        bean.getIpaddr().setVal(ipAddrField.getText());
        bean.getTcpPort().setVal(Integer.parseInt(portField.getText()));
        protSnellVideoPanel.save();
        protSnellDataxxPanel.save();
        protSnellAudioPanel.save();
        
    }

    private void checkComponentEnablingConditions() {
        boolean enabled = enabledCheck.isSelected();
        ipAddrField.setEnabled(enabled);
        portField.setEnabled(enabled);
        routerLabel.setText((enabled?"Router connection: Ethernet":"Router connection: Serial Port"));
    }

    private class MyItemListener implements ItemListener{

        public void itemStateChanged(ItemEvent ie) {
            checkComponentEnablingConditions();
        }


    }
}