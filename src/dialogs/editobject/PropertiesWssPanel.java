/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.editobject;

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
    
    private JCheckBox indicatorCheck;
    
    
    public PropertiesWssPanel(Wss bean) throws MVException {
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        this.bean = bean;
        
        modeLabel = new JLabel("Mode");
        modeCombo = ComponentFactory.createComboBox(bean.getMode().getOptionsName(), bean.getMode().getVal());
        modeCombo.setToolTipText("Type of wide screen information to detect");
    
        autoCheck = new JCheckBoxTransBG("Auto size video image to the correct aspect ratio");
        autoCheck.setSelected(bean.getAspectEnabled().getVal());
        autoCheck.setToolTipText("Size the video to the WSS/AFD information");
        
        indicatorCheck = new JCheckBoxTransBG("Indicator on");
        indicatorCheck.setSelected(bean.getAspectIndicator().getVal());
        indicatorCheck.setToolTipText("Display aspect ratio information when available");

        colorLabel = new JLabel("Indicator colour");
        colorCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());

        layout.addRow(new Component[] {modeLabel, modeCombo});
        layout.addGap();
        layout.add(autoCheck);
        layout.addGap();
        layout.add(indicatorCheck);
        layout.addRow(new Component[] {colorLabel, colorCombo});
    }
    
    public void save() {
        bean.getMode().setVal(modeCombo.getSelectedItem().toString());
        bean.getColour().setVal(colorCombo.getSelectedItem().toString());
        bean.getAspectEnabled().setVal(autoCheck.isSelected());
        bean.getAspectIndicator().setVal(indicatorCheck.isSelected());
    }

}
