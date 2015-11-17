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
    private ProtocolsSnellPanel protSnellPanel;
    private ProtocolsTslPanel protTslPanel;

    public ProtocolsPanel(Protocols bean, int idModulo, Frame frame) throws MVException {
        setLayout(null);

        this.bean = bean;
        this.idModulo = idModulo;
        this.frame = frame;

        protSerialPanel = new ProtocolsSerialPanel(bean.getPorts(), idModulo, frame);
        protSierraPanel = new ProtocolsSierraPanel(bean.getSierraRouter());

        int paneNumber = 0;
        
        tabbedPane = new JDioTabbedPane();
        tabbedPane.setUI(new BasicTabbedPaneUI());
        tabbedPane.setBackground(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor());
        tabbedPane.addChangeListener(new ChangeListenerColorHandled(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor(), StyleInterface.getInstance().getTabbedPaneForegroundColor()));
        tabbedPane.setBounds(5, 1, 540, 520);
        tabbedPane.add(protSerialPanel);
        tabbedPane.setTitleAt(paneNumber, "Serial Ports");
        paneNumber++;

        if (!StyleInterface.getCompany().equalsIgnoreCase("Snell")) { // Sierra & Chromatec

            tabbedPane.add(protSierraPanel);
            tabbedPane.setTitleAt(paneNumber, "Sierra Router");
            paneNumber++;
        }
        if (StyleInterface.getCompany().equalsIgnoreCase("Chromatec")) {

            protSnellPanel = new ProtocolsSnellPanel(bean.getSnellRouter(), idModulo, frame);
            tabbedPane.add(protSnellPanel);
            tabbedPane.setTitleAt(paneNumber, "Snell Router Network");
            paneNumber++;

        } 
        if (StyleInterface.getCompany().equalsIgnoreCase("Snell")){ //Snell
            protSnellPanel = new ProtocolsSnellPanel(bean.getSnellRouter(), idModulo, frame);
            tabbedPane.add(protSnellPanel);
            tabbedPane.setTitleAt(paneNumber, "Snell Router Network");
            paneNumber++;
        }
        
        if (bean.getTsl() != null) {
            protTslPanel = new ProtocolsTslPanel(bean.getTsl(), idModulo, frame);
            tabbedPane.add(protTslPanel);
            tabbedPane.setTitleAt(paneNumber, "TSL UMD V3.1/V4.0");
            paneNumber++;
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
//        if (StyleInterface.getCompany().equalsIgnoreCase("Sierra") || StyleInterface.getCompany().equalsIgnoreCase("Chromatec")) {
//            protSierraPanel.save();
//        }
//        //SNELL AUDIO VIDEO E DATAXX TABS
//        if (StyleInterface.getCompany().equalsIgnoreCase("Snell") || StyleInterface.getCompany().equalsIgnoreCase("Chromatec")) {
//            protSnellPanel.save();
//        }
        if (!StyleInterface.getCompany().equalsIgnoreCase("Snell")) { // Sierra & Chromatec
            protSierraPanel.save();
        }
        if (StyleInterface.getCompany().equalsIgnoreCase("Snell") || StyleInterface.getCompany().equalsIgnoreCase("Chromatec")) {
            protSnellPanel.save();
        }
        if (protTslPanel != null)
            protTslPanel.save();
    }
}
