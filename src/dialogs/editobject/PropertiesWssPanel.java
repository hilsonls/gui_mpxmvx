/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.editobject;

import bean.AspectDefault;
import bean.Wss;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author panda
 */
public class PropertiesWssPanel extends JPanelBGGradient{
    
    private Wss bean;
    
    private JLabel modeLabel;
    private JComboBox modeCombo;
    
    private JLabel colorLabel;
    private JComboBox colorCombo;
    
    private JCheckBox autoCheck;
    
    private JLabel videoAspectLabel;
    private JComboBox videoAspectCombo;
    private static final String videoAspectSdHdString = "4:3 for SD, 16:9 for HD";
    private int videoAspectSdHdIndex;
    
    private JCheckBox indicatorCheck;
    
    
    public PropertiesWssPanel(Wss bean) throws MVException {
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        this.bean = bean;
        
        modeLabel = new JLabel("Mode");
        modeCombo = ComponentFactory.createComboBox(bean.getMode().getOptionsName(), bean.getMode().getVal());
        modeCombo.setToolTipText("Type of wide screen information to detect");
    
        autoCheck = new JCheckBoxTransBG("Auto size video image to the WSS/AFD aspect ratio");
        autoCheck.setSelected(bean.getAspectEnabled().getVal());
        autoCheck.setToolTipText("Size the video to the WSS/AFD information");
        
        videoAspectLabel = new JLabel("Default aspect ratio");
        videoAspectCombo = ComponentFactory.createComboBox(bean.getAspectDefault().getOptionsName(), bean.getAspectDefault().getVal());
        String hdValStr = bean.getAspectDefault().getHdVal();
        if (hdValStr != null && !hdValStr.isEmpty()) {
            videoAspectCombo.addItem(videoAspectSdHdString);
            videoAspectSdHdIndex = videoAspectCombo.getItemCount() - 1;
            if (hdValStr.compareTo("16:9") == 0 && bean.getAspectDefault().getVal().compareTo("4:3") == 0)
                videoAspectCombo.setSelectedIndex(videoAspectSdHdIndex);
        }
        videoAspectCombo.setToolTipText("Aspect ratio to use when WSS/AFD detection is disabled or there is no WSS/AFD info");
        
        indicatorCheck = new JCheckBoxTransBG("Indicator on");
        indicatorCheck.setSelected(bean.getAspectIndicator().getVal());
        indicatorCheck.setToolTipText("Display aspect ratio information when available");

        colorLabel = new JLabel("Indicator colour");
        colorCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());

        layout.addRow(new Component[] {modeLabel, modeCombo});
        layout.addGap();
        layout.add(autoCheck);
        layout.addRow(new Component[] {videoAspectLabel, videoAspectCombo});
        layout.addGap();
        layout.add(indicatorCheck);
        layout.addRow(new Component[] {colorLabel, colorCombo});
    }
    
    public void save() {
        bean.getMode().setVal(modeCombo.getSelectedItem().toString());
        bean.getColour().setVal(colorCombo.getSelectedItem().toString());
        bean.getAspectEnabled().setVal(autoCheck.isSelected());
        bean.getAspectIndicator().setVal(indicatorCheck.isSelected());
        if (videoAspectSdHdIndex == 0 || videoAspectCombo.getSelectedIndex() < videoAspectSdHdIndex) {
            bean.getAspectDefault().setVal(videoAspectCombo.getSelectedItem().toString());
            bean.getAspectDefault().setHdVal(videoAspectCombo.getSelectedItem().toString());
        } else {
            bean.getAspectDefault().setVal("4:3");
            bean.getAspectDefault().setHdVal("16:9");
        }
    }
    
    public JComboBox getVideoAspectRatioCombo() {
        return videoAspectCombo;
    }

}
