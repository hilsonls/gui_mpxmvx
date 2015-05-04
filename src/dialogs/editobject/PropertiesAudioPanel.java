package dialogs.editobject;

import gui.components.ChangeListenerColorHandled;
import gui.components.JDioTabbedPane;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;
import gui.components.JCheckBoxTransBG;
import gui.style.StyleInterface;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import bean.Audio;
import bean.VidAudProperties;
import eccezioni.MVException;

public class PropertiesAudioPanel extends JPanelBGGradient {
    private Audio[] bean;
    private VidAudProperties vidAudPropBean;
    
    private static final int NUM_METERS = 2;
    
    private JCheckBox showMeter1;
    private JCheckBox showMeter2;
    
    private JTabbedPane tabbedPane;
    
    private JScrollPane [] propAudioMeterScrollPane;
    private PropertiesAudioMeterPanel [] propAudioMeterPanel;
    
    private VGroupLayout layout;

    public PropertiesAudioPanel(VidAudProperties vidAudPropBean) throws MVException {
        layout = new VGroupLayout(this);
        setLayout(layout);
        
        this.vidAudPropBean = vidAudPropBean;
        this.bean = new Audio[NUM_METERS];
        
        Audio audioBean0 = vidAudPropBean.getAudio(0);
        Audio audioBean1 = vidAudPropBean.getAudio(1);
        if (audioBean0.getId() < audioBean1.getId()) {
            this.bean[0] = audioBean0;
            this.bean[1] = audioBean1;
        } else {
            this.bean[0] = audioBean1;
            this.bean[1] = audioBean0;
        }
        
        showMeter1 = new JCheckBoxTransBG("Display meter 1");
        showMeter1.setSelected(bean[0].getVisible().getVal());
        showMeter2 = new JCheckBoxTransBG("Display meter 2");
        showMeter2.setSelected(bean[1].getVisible().getVal());
        
        propAudioMeterScrollPane = new JScrollPane[NUM_METERS];
        propAudioMeterPanel = new PropertiesAudioMeterPanel[NUM_METERS];

        tabbedPane = new JDioTabbedPane();
        tabbedPane.setUI(new BasicTabbedPaneUI());
        tabbedPane.setBackground(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor());
        tabbedPane.addChangeListener(new ChangeListenerColorHandled(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor(), StyleInterface.getInstance().getTabbedPaneForegroundColor()));

        for (int i = 0; i < NUM_METERS; i++) {
            // TODO change bean to bean.getAudioMeter...
            propAudioMeterPanel[i] = new PropertiesAudioMeterPanel(this, bean[i]);
            propAudioMeterScrollPane[i] = new JScrollPane(propAudioMeterPanel[i]);
            tabbedPane.addTab("Audio meter " + (i+1), propAudioMeterScrollPane[i]);
        }
        
        
//        addComponentListener(new ComponentAdapter() {
//            /**
//             * Resize the child pane when this panel is resized
//             */
//            @Override
//            public void componentResized(ComponentEvent e) {
//                Dimension size = getSize();
//                size.width -= 40;
//                size.height -= 60;
//                tabbedPane.setPreferredSize(size);
//            }
//        });
        
        
        layout.addRow(new Component[] {showMeter1, showMeter2});
        layout.add(tabbedPane);
    }
    
    public void save() {
        bean[0].getVisible().setVal(showMeter1.isSelected());
        bean[1].getVisible().setVal(showMeter2.isSelected());
        vidAudPropBean.setAutoFitAudioMeters(propAudioMeterPanel[0].isAutoFit());
        propAudioMeterPanel[0].save();
        propAudioMeterPanel[1].save();
    }

    public void updateAutoFit(boolean autoFit) {
        for (int i = 0; i < NUM_METERS; i++) {
            propAudioMeterPanel[i].updateAutoFit(autoFit);
        }
    }
    
    public VidAudProperties getVidAudPropBean() {
        return vidAudPropBean;
    }
}
