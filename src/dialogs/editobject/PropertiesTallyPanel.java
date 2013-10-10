/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.editobject;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import bean.Tally;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author panda
 */
public class PropertiesTallyPanel extends JPanelBGGradient{
    private Tally bean;
    
    private JLabel tallyLabel;
    private JComboBox tallyCombo;
    
    private JLabel styleLabel;
    private JComboBox styleCombo;
    
    private JLabel shapeLabel;
    private JComboBox shapeCombo;
    
    private JLabel positionLabel;
    private JComboBox positionCombo;
    
    private JLabel disabledLabel;
    private JComboBox disabledCombo;
    
    private JLabel colorLabel;
    private JComboBox colorCombo;
    
    private JCheckBox visibleCheck;
    
    public PropertiesTallyPanel(Tally bean) throws MVException {
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        this.bean = bean;

        MyItemListener mIL = new MyItemListener();

        visibleCheck = new JCheckBoxTransBG("Enabled");
        visibleCheck.setSelected(bean.getVisible().getVal());
        visibleCheck.addItemListener(mIL);

        tallyLabel = new JLabel("Left-right sources");
        tallyCombo = ComponentFactory.createComboBox(bean.getType().getOptionsName(), bean.getType().getVal());
        
        styleLabel = new JLabel("Left-right on colours");
        styleCombo = ComponentFactory.createComboBox(bean.getStyle().getOptionsName(), bean.getStyle().getVal());
        
        shapeLabel = new JLabel("Shape");
        shapeCombo = ComponentFactory.createComboBox(bean.getShape().getOptionsName(), bean.getShape().getVal());
        
        positionLabel = new JLabel("Position");
        positionCombo = ComponentFactory.createComboBox(bean.getTallyPosition().getOptionsName(), bean.getTallyPosition().getVal());
        
        disabledLabel = new JLabel();
        disabledLabel.setText("Off colour");
        disabledCombo = ComponentFactory.createComboBox(bean.getDisabledColourSource().getOptionsName(), bean.getDisabledColourSource().getVal());
        
        colorLabel = new JLabel("User colour");
        colorCombo = ComponentFactory.createComboBox(bean.getDisabledColour().getOptionsName(), bean.getDisabledColour().getVal());
        
        layout.add(visibleCheck);
        layout.addGap();
        layout.addGrid(new Component[][] { 
                {tallyLabel, tallyCombo},
                {null, null},
                {styleLabel, styleCombo},
                {null, null},
                {shapeLabel, shapeCombo},
                {null, null},
                {positionLabel, positionCombo},
                {null, null},
                {disabledLabel, disabledCombo},
                {null, null},
                {colorLabel, colorCombo},
        });
        
        checkComponentEnablingConditions();
    }
    
    public void save() {
        bean.getType().setVal(tallyCombo.getSelectedItem().toString());
        bean.getStyle().setVal(styleCombo.getSelectedItem().toString());
        bean.getShape().setVal(shapeCombo.getSelectedItem().toString());
        bean.getTallyPosition().setVal(positionCombo.getSelectedItem().toString());
        bean.getDisabledColourSource().setVal(disabledCombo.getSelectedItem().toString());
        bean.getDisabledColour().setVal(colorCombo.getSelectedItem().toString());
        bean.getVisible().setVal(visibleCheck.isSelected());
    }
  
    private void checkComponentEnablingConditions() {
        tallyCombo.setEnabled(visibleCheck.isSelected());
        styleCombo.setEnabled(visibleCheck.isSelected());
        shapeCombo.setEnabled(visibleCheck.isSelected());
        positionCombo.setEnabled(visibleCheck.isSelected());
        disabledCombo.setEnabled(visibleCheck.isSelected());
        colorCombo.setEnabled(visibleCheck.isSelected());
    }
    
    private class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            checkComponentEnablingConditions();
        }

    }

}
