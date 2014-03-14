package dialogs.editobject;
 
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import bean.Audio;
import bean.ObjectSequence;
import eccezioni.MVException;
import gui.components.ChangeListenerColorHandled;
import gui.components.JDioTabbedPane;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class PropertiesPanel extends JPanelBGGradient{
    private ObjectSequence bean;
    
    private JTabbedPane tabbedPane;
    
    private JScrollPane propVideoScrollPane;
    private JScrollPane propAudioScrollPane;
    private JScrollPane propErrorScrollPane;
    private JScrollPane propTallyScrollPane;
    private JScrollPane propVbiScrollPane;
    private JScrollPane propWssScrollPane;
    private JScrollPane propSagScrollPane;
    private JScrollPane propLogoScrollPane;
    private JScrollPane propClockScrollPane;
    private JScrollPane propTextScrollPane;
    private JScrollPane propTimerScrollPane;
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
    private FlowLayout layout;
    
    private int tileType;



    public PropertiesPanel(ObjectSequence bean) throws MVException {
        layout = new FlowLayout(FlowLayout.LEFT);
        setLayout(layout);
        this.bean = bean;
        
        
        propVideoPanel = new PropertiesVideoPanel(bean.getVidAudProperties().getVidAudSource(), bean.getVideoProperties());
        Audio audioBean0 = bean.getVidAudProperties().getAudio(0);
        Audio audioBean1 = bean.getVidAudProperties().getAudio(1);
        if (audioBean0.getId() < audioBean1.getId()) {
            propAudioPanel = new PropertiesAudioPanel(audioBean0, audioBean1);
        } else {
            propAudioPanel = new PropertiesAudioPanel(audioBean1, audioBean0);
        }
        propErrorPanel = new PropertiesErrorPanel(bean.getVidAudProperties().getError());
        propTallyPanel = new PropertiesTallyPanel(bean.getVideoProperties().getTally());
        propVbiPanel = new PropertiesVbiPanel(bean.getVideoProperties().getVbi());
        propWssPanel = new PropertiesWssPanel(bean.getVideoProperties().getWss());
        propSagPanel = new PropertiesSagPanel(bean.getVideoProperties().getSag());        
        propLogoPanel = new PropertiesLogoPanel(bean.getLogoProperties());
        propClockPanel = new PropertiesClockPanel(bean.getClockProperties());
        propTextPanel = new PropertiesTextPanel(bean.getTextProperties());
        propTimerPanel = new PropertiesTimerPanel(bean.getTimerProperties());

        propVideoScrollPane = new JScrollPane(propVideoPanel);
        propAudioScrollPane = new JScrollPane(propAudioPanel);
        propErrorScrollPane = new JScrollPane(propErrorPanel);
        propTallyScrollPane = new JScrollPane(propTallyPanel);
        propVbiScrollPane = new JScrollPane(propVbiPanel);
        propWssScrollPane = new JScrollPane(propWssPanel);
        propSagScrollPane = new JScrollPane(propSagPanel);
        propLogoScrollPane = new JScrollPane(propLogoPanel);
        propClockScrollPane = new JScrollPane(propClockPanel);
        propTextScrollPane = new JScrollPane(propTextPanel);
        propTimerScrollPane = new JScrollPane(propTimerPanel);

        tabbedPane = new JDioTabbedPane();
        tabbedPane.setUI(new BasicTabbedPaneUI());
        tabbedPane.setBackground(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor());
        tabbedPane.addChangeListener(new ChangeListenerColorHandled(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor(), StyleInterface.getInstance().getTabbedPaneForegroundColor()));
        
        tileType = EditObjectDialog.TILE_TYPE_OTHER;
        
        addComponentListener(new ComponentAdapter() {
            /**
             * Resize the child pane when this panel is resized
             */
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension size = getSize();
                size.width -= layout.getHgap() * 2;
                size.height -= layout.getVgap() * 2;
                tabbedPane.setPreferredSize(size);
            }
        });
        
        add(tabbedPane);
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
        tabbedPane.removeAll();

        switch (tileType) {
        case EditObjectDialog.TILE_TYPE_VIDEO:
            tabbedPane.addTab("Source", propVideoScrollPane);
            tabbedPane.addTab("Audio", propAudioScrollPane);
            tabbedPane.addTab("Error", propErrorScrollPane);
            tabbedPane.addTab("Tally", propTallyScrollPane);
            tabbedPane.addTab("VBI", propVbiScrollPane);
            tabbedPane.addTab("WSS", propWssScrollPane);
            tabbedPane.addTab("SAG", propSagScrollPane);
            propVideoPanel.enableDisplayOnAllCheckBox(true);
            break;
            
        case EditObjectDialog.TILE_TYPE_AUDIO:
            tabbedPane.addTab("Source", propVideoScrollPane);
            tabbedPane.addTab("Audio", propAudioScrollPane);
            tabbedPane.addTab("Error", propErrorScrollPane);
            propVideoPanel.enableDisplayOnAllCheckBox(false);
            break;
            
        case EditObjectDialog.TILE_TYPE_LOGO:
            tabbedPane.addTab("Logo", propLogoScrollPane);
            break;
            
        case EditObjectDialog.TILE_TYPE_CLOCK:
            tabbedPane.addTab("Clock", propClockScrollPane);
            break;
            
        case EditObjectDialog.TILE_TYPE_TEXT:
            tabbedPane.addTab("Text", propTextScrollPane);
            break;
            
        case EditObjectDialog.TILE_TYPE_TIMER:
            tabbedPane.addTab("Timer", propTimerScrollPane);
            break;
            
        default:
            break;
        }
    }
}