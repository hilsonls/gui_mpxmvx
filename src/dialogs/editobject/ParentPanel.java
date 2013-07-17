/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 

package dialogs.editobject;

import bean.Parent;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
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
        setLayout(null);
        
        this.bean = bean;
        
        nameLabel = new JLabel();
        nameLabel.setText("Name");
        nameLabel.setBounds(20, 20, 80, 20);
        add(nameLabel);
        nameCombo = ComponentFactory.createComboBox(bean.getOptionsName(), bean.getVal(), false);
        nameCombo.setBounds(120, 20, 180, 20);
        add(nameCombo);
            
        positionLabel = new JLabel();
        positionLabel.setText("Position");
        positionLabel.setBounds(20, 60, 80, 20);
        add(positionLabel);
        positionCombo = ComponentFactory.createComboBox(bean.getAnchorPoint().getOptionsName(), bean.getAnchorPoint().getVal());
        positionCombo.setBounds(120, 60, 180, 20);
        add(positionCombo);

        xLabel = new JLabel();
        xLabel.setText("X Offset");
        xLabel.setBounds(20, 100, 60, 20);
        add(xLabel);
        xField = ComponentFactory.createTextField(bean.getXoffs().getVal());
        xField.setBounds(85, 100, 50, 20);
        add(xField);
        yLabel = new JLabel();
        yLabel.setText("Y Offset");
        yLabel.setBounds(185, 100, 60, 20);
        add(yLabel);
        yField = ComponentFactory.createTextField(bean.getYoffs().getVal());
        yField.setBounds(250, 100, 50, 20);
        add(yField);
        
        lockSizeCheck = new JCheckBoxTransBG();
        lockSizeCheck.setText("Lock size");
        lockSizeCheck.setSelected(bean.getLockSizeRatio().getVal());
        lockSizeCheck.setBounds(20, 140, 150, 20);
        add(lockSizeCheck);
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
