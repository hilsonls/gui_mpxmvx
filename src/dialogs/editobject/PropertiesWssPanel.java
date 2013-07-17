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
    
    private JLabel aspectLabel;
    
    private JCheckBox autoCheck;
    
    private JLabel defaultLabel;
    private JComboBox defaultCombo;
    
    private JCheckBox indicatorCheck;
    
    
    public PropertiesWssPanel(Wss bean) throws MVException {
        setLayout(null);
        this.bean = bean;
        
        modeLabel = new JLabel();
        modeLabel.setText("Mode");
        modeLabel.setBounds(20, 20, 80, 20);
        add(modeLabel);
        modeCombo = ComponentFactory.createComboBox(bean.getMode().getOptionsName(), bean.getMode().getVal());
        modeCombo.setBounds(120, 20, 180, 20);
        add(modeCombo);
    
        colorLabel = new JLabel();
        colorLabel.setText("Colour");
        colorLabel.setBounds(20, 60, 80, 20);
        add(colorLabel);
        colorCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());
        colorCombo.setBounds(120, 60, 180, 20);
        add(colorCombo);
    
        
        aspectLabel = new JLabel();
        aspectLabel.setFont(new Font("Arial", Font.BOLD, 12));
        aspectLabel.setText("Aspect ratio");
        aspectLabel.setBounds(20, 110, 200, 20);
        add(aspectLabel);
    
        autoCheck = new JCheckBoxTransBG();
        autoCheck.setText("Auto size");
        autoCheck.setSelected(bean.getAspectEnabled().getVal());
        autoCheck.setBounds(20, 135, 200, 20);
        add(autoCheck);
        
        defaultLabel = new JLabel();
        defaultLabel.setText("Default");
        defaultLabel.setBounds(20, 160, 80, 20);
        add(defaultLabel);
        defaultCombo = ComponentFactory.createComboBox(bean.getAspectDefault().getOptionsName(), bean.getAspectDefault().getVal());
        defaultCombo.setBounds(120, 160, 180, 20);
        add(defaultCombo);
    
        indicatorCheck = new JCheckBoxTransBG();
        indicatorCheck.setText("Indicator");
        indicatorCheck.setSelected(bean.getAspectIndicator().getVal());
        indicatorCheck.setBounds(20, 185, 200, 20);
        add(indicatorCheck);
    }
    
    public void save() {
        bean.getMode().setVal(modeCombo.getSelectedItem().toString());
        bean.getColour().setVal(colorCombo.getSelectedItem().toString());
        bean.getAspectEnabled().setVal(autoCheck.isSelected());
        bean.getAspectDefault().setVal(defaultCombo.getSelectedItem().toString());
        bean.getAspectIndicator().setVal(indicatorCheck.isSelected());
    }

}
