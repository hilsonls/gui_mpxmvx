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
    }

    public void enableDisplayOnAllCheckBox(boolean enable){
        if(CtrlWorkspace.getInstance().getModule(0).getScreen().getNumScreens().getVal()>1){
            if(enable){
                allScreenCheckBox.setSelected(beanVideo.getDisplayOnAllScreens().getVal());
                allScreenCheckBox.setVisible(true);
            }
            else{
                allScreenCheckBox.setVisible(false);
            }
        }
    }
    
    public void save() {
        bean.setVal(sourceCombo.getSelectedItem().toString());
        beanVideo.getDisplayOnAllScreens().setVal(allScreenCheckBox.isSelected());
    }
}
