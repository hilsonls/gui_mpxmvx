package dialogs.moduleproperties;


import bean.Gpis;
import eccezioni.MVException;
import gui.components.ChangeListenerColorHandled;
import gui.components.JDioTabbedPane;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class GPIsPanel extends JPanelBGGradient{
    
    private Gpis beanGPI;

    private int idModulo;

    private JTabbedPane tabbedPane;

    private GPOAlarmsPanel gpoAlarmsPanel;
    private GPIInputPanel gpiInputPanel;

    public GPIsPanel(Gpis beanGPI, int idModulo) throws MVException {
        setLayout(null);

        this.beanGPI = beanGPI;
        this.idModulo = idModulo;

        gpoAlarmsPanel = new GPOAlarmsPanel(beanGPI, idModulo);
        gpiInputPanel = new GPIInputPanel(beanGPI, idModulo);
        
        tabbedPane = new JDioTabbedPane();
        tabbedPane.setUI(new BasicTabbedPaneUI());
        tabbedPane.setBackground(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor());
        tabbedPane.addChangeListener(new ChangeListenerColorHandled(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor(), StyleInterface.getInstance().getTabbedPaneForegroundColor()));
        tabbedPane.setBounds(5, 1, 440, 452);
        tabbedPane.add(gpoAlarmsPanel);
        tabbedPane.setTitleAt(0, "GPO Alarms");
        tabbedPane.add(gpiInputPanel);
        tabbedPane.setTitleAt(1, "GPI Inputs");


        tabbedPane.setSelectedComponent(gpoAlarmsPanel);
        add(tabbedPane);
        //setVisible(true);
    }

    public void save() {
        gpoAlarmsPanel.save();
        gpiInputPanel.save();
        
    }

}