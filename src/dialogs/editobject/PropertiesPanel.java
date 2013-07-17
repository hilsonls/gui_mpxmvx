package dialogs.editobject;
 
import bean.ObjectSequence;
import eccezioni.MVException;
import gui.components.ChangeListenerColorHandled;
import gui.components.JDioTabbedPane;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class PropertiesPanel extends JPanelBGGradient{
    private ObjectSequence bean;
    
    private JTabbedPane tabbedPane;
    
    private PropertiesVideoPanel propVideoPanel;
    private PropertiesAudioPanel propAudioPanel;
    private PropertiesErrorPanel propErrorPanel;
    private PropertiesTallyPanel propTallyPanel;
    private PropertiesVbiPanel propVbiPanel;
    private PropertiesWssPanel propWssPanel;
    private PropertiesSagPanel propSagPanel;    
    private PropertiesLogoPanel propLogoPanel;
    private PropertiesClockPanel propClockPanel;
    private PropertiesTextPanel propTextPanel;
    private PropertiesTimerPanel propTimerPanel;
    
    private int tileType;



    public PropertiesPanel(ObjectSequence bean) throws MVException {
        setLayout(null);
        
        this.bean = bean;
        
        propVideoPanel = new PropertiesVideoPanel(bean.getVidAudProperties().getVidAudSource(), bean.getVideoProperties());
        propAudioPanel = new PropertiesAudioPanel(bean.getVidAudProperties().getAudio());
        propErrorPanel = new PropertiesErrorPanel(bean.getVidAudProperties().getError());
        propTallyPanel = new PropertiesTallyPanel(bean.getVideoProperties().getTally());
        propVbiPanel = new PropertiesVbiPanel(bean.getVideoProperties().getVbi());
        propWssPanel = new PropertiesWssPanel(bean.getVideoProperties().getWss());
        propSagPanel = new PropertiesSagPanel(bean.getVideoProperties().getSag());        
        propLogoPanel = new PropertiesLogoPanel(bean.getLogoProperties());
        propClockPanel = new PropertiesClockPanel(bean.getClockProperties());
        propTextPanel = new PropertiesTextPanel(bean.getTextProperties());
        propTimerPanel = new PropertiesTimerPanel(bean.getTimerProperties());



        tabbedPane = new JDioTabbedPane();
        tabbedPane.setUI(new BasicTabbedPaneUI());
        tabbedPane.setBackground(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor());
        tabbedPane.addChangeListener(new ChangeListenerColorHandled(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor(), StyleInterface.getInstance().getTabbedPaneForegroundColor()));
        tabbedPane.setBounds(5, 1, 320, 452);
        tabbedPane.add(propVideoPanel);
        tabbedPane.add(propAudioPanel);
        tabbedPane.add(propErrorPanel);
        tabbedPane.add(propTallyPanel);
        tabbedPane.add(propVbiPanel);
        tabbedPane.add(propWssPanel);
        tabbedPane.add(propSagPanel);
        
        tabbedPane.setSelectedComponent(propVideoPanel);
        tabbedPane.setTitleAt(0, "Source");
        tabbedPane.setTitleAt(1, "Audio");
        tabbedPane.setTitleAt(2, "Error");
        tabbedPane.setTitleAt(3, "Tally");
        tabbedPane.setTitleAt(4, "VBI");
        tabbedPane.setTitleAt(5, "WSS");
        tabbedPane.setTitleAt(6, "SAG");
        
        add(tabbedPane);
        //setVisible(true);
    }
    
    public void save() {
        propVideoPanel.save();
        propAudioPanel.save();
        propErrorPanel.save();
        propTallyPanel.save();
        propVbiPanel.save();
        propWssPanel.save();
        propSagPanel.save();
        propLogoPanel.save();
        propClockPanel.save();
        propTextPanel.save();
        propTimerPanel.save();
    }
    
    public int getTabCount() {
        return tabbedPane.getTabCount();
    }
    
    public void setTileType(int tileType) {
        this.tileType = tileType;
        checkTabsEnablingConditions();
    }
    
    private void checkTabsEnablingConditions() {
        if (tileType == EditObjectDialog.TILE_TYPE_VIDEO) {
            tabbedPane.removeAll();
            tabbedPane.addTab("Source", propVideoPanel);
            tabbedPane.addTab("Audio", propAudioPanel);
            tabbedPane.addTab("Error", propErrorPanel);
            tabbedPane.addTab("Tally", propTallyPanel);
            tabbedPane.addTab("VBI", propVbiPanel);
            tabbedPane.addTab("WSS", propWssPanel);
            tabbedPane.addTab("SAG", propSagPanel);
            propVideoPanel.enableDisplayOnAllCheckBox(true);
        } else if (tileType == EditObjectDialog.TILE_TYPE_AUDIO) {
            tabbedPane.removeAll();
            tabbedPane.addTab("Source", propVideoPanel);
            tabbedPane.addTab("Audio", propAudioPanel);
            tabbedPane.addTab("Error", propErrorPanel);
            propVideoPanel.enableDisplayOnAllCheckBox(false);
        } else if (tileType == EditObjectDialog.TILE_TYPE_LOGO) {
            tabbedPane.removeAll();
            tabbedPane.addTab("Logo", propLogoPanel);
        } else if (tileType == EditObjectDialog.TILE_TYPE_CLOCK) {
            tabbedPane.removeAll();
            tabbedPane.addTab("Clock", propClockPanel);
        } else if (tileType == EditObjectDialog.TILE_TYPE_TEXT) {
            tabbedPane.removeAll();
            tabbedPane.addTab("Text", propTextPanel);
        } else if (tileType == EditObjectDialog.TILE_TYPE_TIMER) {
            tabbedPane.removeAll();
            tabbedPane.addTab("Timer", propTimerPanel);
        }
        else {
            tabbedPane.removeAll();            
        }
    }    
}