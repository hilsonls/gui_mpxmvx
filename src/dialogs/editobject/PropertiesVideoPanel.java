/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.editobject;

import java.awt.Component;

import bean.Ports;
import bean.VidAudSource;
import bean.VideoProperties;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author panda
 */
public class PropertiesVideoPanel extends JPanelBGGradient{

    private VidAudSource bean;
    private VideoProperties beanVideo;
    
    private JLabel sourceLabel;
    private JComboBox sourceCombo;
    
    private JCheckBox allScreenCheckBox;
    
    private bean.InputResolutionDisplay beanInRes;
    private JCheckBox resolutionDisplayCheckBox;
    private JLabel resolutionSecondsLabel;
    private JTextField resolutionSecondsField;
    private JLabel resolutionColorLabel;
    private JComboBox resolutionColorCombo;
    
    private JCheckBox overscanCheckBox;
    
    public PropertiesVideoPanel(VidAudSource bean, VideoProperties beanVideo) throws MVException {
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        
        this.bean = bean;
        this.beanVideo = beanVideo;
        
        sourceLabel = new JLabel("Source");
        sourceCombo = ComponentFactory.createComboBox(bean.getOptionsName(), bean.getVal());
        
        allScreenCheckBox = new JCheckBox("Display on all screens");
        allScreenCheckBox.setVisible(false);
        allScreenCheckBox.setOpaque(false);
       // allScreenCheckBox.setSelected(beanVideo.getDisplayOnAllScreens().getVal());
        
        layout.addRow(new Component[] {sourceLabel, sourceCombo});
        layout.add(allScreenCheckBox);
        
        overscanCheckBox = new JCheckBox("Overscan");
        overscanCheckBox.setVisible(false);
        overscanCheckBox.setOpaque(false);
        overscanCheckBox.setSelected(beanVideo.isOverscan());
        overscanCheckBox.setToolTipText("Display image using 5% overscan");
        layout.add(overscanCheckBox);

        beanInRes = beanVideo.getInputResolutionDisplay();
        if (beanInRes != null) {
            resolutionDisplayCheckBox = new JCheckBox("Display resolution");
            resolutionDisplayCheckBox.setSelected(beanInRes.isOn());
            resolutionDisplayCheckBox.setOpaque(false);
            resolutionSecondsLabel = new JLabel("Duration of display (secs)");
            resolutionSecondsField = ComponentFactory.createTextField(beanInRes.getDuration(), 0, 0x7fffffff);
            resolutionColorLabel = new JLabel("Colour");
            resolutionColorCombo = ComponentFactory.createComboBox(beanInRes.getColour().getOptionsName(), beanInRes.getColour().getVal());
            
            layout.addGap();
            layout.add(resolutionDisplayCheckBox);
            layout.addRow(new Component[] {resolutionSecondsLabel, resolutionSecondsField});
            layout.addRow(new Component[] {resolutionColorLabel, resolutionColorCombo});
        }
    }

    public void enableVideoSpecificFields(boolean enable) {
        if(CtrlWorkspace.getInstance().getModule(0).getScreen().getNumScreens().getVal()>1){
            if(enable){
                allScreenCheckBox.setSelected(beanVideo.getDisplayOnAllScreens().getVal());
                allScreenCheckBox.setVisible(true);
            }
            else{
                allScreenCheckBox.setVisible(false);
            }
        }

        overscanCheckBox.setVisible(enable);
    }
    
    public void save() {
        bean.setVal(sourceCombo.getSelectedItem().toString());
        beanVideo.getDisplayOnAllScreens().setVal(allScreenCheckBox.isSelected());
        beanVideo.setOverscan(overscanCheckBox.isSelected());
        if (beanInRes != null) {
            beanInRes.setOn(resolutionDisplayCheckBox.isSelected());
            beanInRes.getColour().setVal(resolutionColorCombo.getSelectedItem().toString());
            beanInRes.setDuration(Integer.valueOf(resolutionSecondsField.getText()));
        }
    }
}
