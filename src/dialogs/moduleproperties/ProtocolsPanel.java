package dialogs.moduleproperties;

import bean.Protocols;
import eccezioni.MVException;
import gui.components.ChangeListenerColorHandled;
import gui.components.JDioTabbedPane;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;
import java.awt.Frame;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class ProtocolsPanel extends JPanelBGGradient {

    private Protocols bean;
    private int idModulo;
    private Frame frame;
    private JTabbedPane tabbedPane;
    private ProtocolsSerialPanel protSerialPanel;
    private ProtocolsSierraPanel protSierraPanel;
    private ProtocolsUtahPanel protUtahPanel;
    private ProtocolsSnellPanel protSnellPanel;

    public ProtocolsPanel(Protocols bean, int idModulo, Frame frame) throws MVException {
        setLayout(null);

        this.bean = bean;
        this.idModulo = idModulo;
        this.frame = frame;

        protSerialPanel = new ProtocolsSerialPanel(bean.getPorts(), idModulo, frame);
        protSierraPanel = new ProtocolsSierraPanel(bean.getSierraRouter());
        protUtahPanel = new ProtocolsUtahPanel(bean.getUtahUSI());

        tabbedPane = new JDioTabbedPane();
        tabbedPane.setUI(new BasicTabbedPaneUI());
        tabbedPane.setBackground(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor());
        tabbedPane.addChangeListener(new ChangeListenerColorHandled(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor(), StyleInterface.getInstance().getTabbedPaneForegroundColor()));
        tabbedPane.setBounds(5, 1, 450, 480);
        tabbedPane.add(protSerialPanel);
        tabbedPane.setTitleAt(0, "Serial Ports");

        if (StyleInterface.getCompany().equalsIgnoreCase("Barco")) {
            tabbedPane.add(protUtahPanel);
            tabbedPane.setTitleAt(1, "Utah USI");
        }
        else if (!StyleInterface.getCompany().equalsIgnoreCase("Snell")) { // Sierra & Chromatec

            tabbedPane.add(protSierraPanel);
            tabbedPane.setTitleAt(1, "Sierra Router");
        }
        if (StyleInterface.getCompany().equalsIgnoreCase("Chromatec")) {

            protSnellPanel = new ProtocolsSnellPanel(bean.getSnellRouter());
            tabbedPane.add(protSnellPanel);
            tabbedPane.setTitleAt(2, "Snell Router Network");

        } 
        if (StyleInterface.getCompany().equalsIgnoreCase("Snell")){ //Snell
            protSnellPanel = new ProtocolsSnellPanel(bean.getSnellRouter());
            tabbedPane.add(protSnellPanel);
            tabbedPane.setTitleAt(1, "Snell Router Network");
        }

        //SNELL AUDIO VIDEO E DATAXX TABS
//        if (StyleInterface.getCompany().equalsIgnoreCase("Snell") || StyleInterface.getCompany().equalsIgnoreCase("Chromatec")) {
//
//            protSnellPanel = new ProtocolsSnellPanel(bean.getSnellRouter());
//            tabbedPane.add(protSnellPanel);
//            tabbedPane.setTitleAt(2, "Snell Router Network");
//        }

        tabbedPane.setSelectedComponent(protSerialPanel);
        add(tabbedPane);
        //setVisible(true);
        }

    public void save() {
//        protSerialPanel.save();
//        if (StyleInterface.getCompany().equalsIgnoreCase("Barco")) {
//            protUtahPanel.save();
//        } else if (StyleInterface.getCompany().equalsIgnoreCase("Sierra") || StyleInterface.getCompany().equalsIgnoreCase("Chromatec")) {
//            protSierraPanel.save();
//        }
//        //SNELL AUDIO VIDEO E DATAXX TABS
//        if (StyleInterface.getCompany().equalsIgnoreCase("Snell") || StyleInterface.getCompany().equalsIgnoreCase("Chromatec")) {
//            protSnellPanel.save();
//        }
        if (StyleInterface.getCompany().equalsIgnoreCase("Barco")) {
            protUtahPanel.save();
        } else if (!StyleInterface.getCompany().equalsIgnoreCase("Snell")) { // Sierra & Chromatec
            protSierraPanel.save();
        }
        if (StyleInterface.getCompany().equalsIgnoreCase("Snell") || StyleInterface.getCompany().equalsIgnoreCase("Chromatec")) {
            protSnellPanel.save();
        }
    }
}
