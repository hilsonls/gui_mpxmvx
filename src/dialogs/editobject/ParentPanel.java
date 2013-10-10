/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 

package dialogs.editobject;

import java.awt.Component;

import bean.Parent;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ParentPanel extends JPanelBGGradient{
        private Parent bean;
        
        private JLabel nameLabel;
        private JComboBox nameCombo;
            
        private JLabel positionLabel;
        private JComboBox positionCombo;
        
        private JLabel xLabel;
        private JTextField xField;
            
        private JLabel yLabel;
        private JTextField yField;

        //private JLabel visibleLabel;
        private JCheckBox lockSizeCheck;
        
        
    public ParentPanel(Parent bean) throws MVException {
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        
        this.bean = bean;
        
        nameLabel = new JLabel("Parent tile");
        nameCombo = ComponentFactory.createComboBox(bean.getOptionsName(), bean.getVal(), false);
            
        positionLabel = new JLabel("Anchor position");
        positionCombo = ComponentFactory.createComboBox(bean.getAnchorPoint().getOptionsName(), bean.getAnchorPoint().getVal());

        xLabel = new JLabel("X Offset");
        xField = ComponentFactory.createTextField(bean.getXoffs().getVal());
        yLabel = new JLabel("Y Offset");
        yField = ComponentFactory.createTextField(bean.getYoffs().getVal());
        
        lockSizeCheck = new JCheckBoxTransBG("Lock size");
        lockSizeCheck.setSelected(bean.getLockSizeRatio().getVal());
        
        layout.addGrid(new Component[][] {
                {nameLabel, nameCombo},
                {positionLabel, positionCombo},
        });
        layout.addGap();
        layout.addRow(new Component[] {xLabel, xField, yLabel, yField});
        layout.addGap();
        layout.add(lockSizeCheck);
    }
    
    public void save() {
        try { 
            String sel = nameCombo.getSelectedItem().toString();
            int objid = -1;
            
            
            
            bean.setVal(sel);
            bean.setObjid(objid);
            
            if(sel.compareToIgnoreCase("none") != 0){
                String [] sp = sel.split(" ",3);
                bean.setObjid(Integer.parseInt(sp[1]));
            }
            //bean.deleteObjid();
        } catch(NullPointerException npe) {
        }
        
        bean.getAnchorPoint().setVal(positionCombo.getSelectedItem().toString());
        bean.getAnchorPoint().setIntval(positionCombo.getSelectedIndex());
        bean.getXoffs().setVal(Integer.parseInt(xField.getText()));
        bean.getYoffs().setVal(Integer.parseInt(yField.getText()));
        bean.getLockSizeRatio().setVal(lockSizeCheck.isSelected());
    }
}
