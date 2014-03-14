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
import eccezioni.MVException;

public class PropertiesAudioPanel extends JPanelBGGradient {
    private Audio[] bean;
    
    private static final int NUM_METERS = 2;
    
    private JCheckBox showMeter1;
    private JCheckBox showMeter2;
    
    private JTabbedPane tabbedPane;
    
    private JScrollPane [] propAudioMeterScrollPane;
    private PropertiesAudioMeterPanel [] propAudioMeterPanel;
    
    private VGroupLayout layout;
    
    public PropertiesAudioPanel(Audio bean0, Audio bean1) throws MVException {
        layout = new VGroupLayout(this);
        setLayout(layout);
        
        this.bean = new Audio[NUM_METERS];
        this.bean[0] = bean0;
        this.bean[1] = bean1;
        
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
            propAudioMeterPanel[i] = new PropertiesAudioMeterPanel(bean[i]);
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
        propAudioMeterPanel[0].save();
        propAudioMeterPanel[1].save();
    }

}
