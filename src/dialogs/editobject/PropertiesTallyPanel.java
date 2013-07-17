/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.editobject;

import bean.Tally;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
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
        setLayout(null);
        this.bean = bean;
        
        tallyLabel = new JLabel();
        tallyLabel.setText("Tally");
        tallyLabel.setBounds(20, 20, 80, 20);
        add(tallyLabel);
        
        tallyCombo = ComponentFactory.createComboBox(bean.getType().getOptionsName(), bean.getType().getVal());
        tallyCombo.setBounds(120, 20, 180, 20);
        add(tallyCombo);
        
        styleLabel = new JLabel();
        styleLabel.setText("Style");
        styleLabel.setBounds(20, 60, 80, 20);
        add(styleLabel);
        styleCombo = ComponentFactory.createComboBox(bean.getStyle().getOptionsName(), bean.getStyle().getVal());
        styleCombo.setBounds(120, 60, 180, 20);
        add(styleCombo);
        
        shapeLabel = new JLabel();
        shapeLabel.setText("Shape");
        shapeLabel.setBounds(20, 100, 80, 20);
        add(shapeLabel);
        shapeCombo = ComponentFactory.createComboBox(bean.getShape().getOptionsName(), bean.getShape().getVal());
        shapeCombo.setBounds(120, 100, 180, 20);
        add(shapeCombo);
        
        positionLabel = new JLabel();
        positionLabel.setText("Position");
        positionLabel.setBounds(20, 140, 80, 20);
        add(positionLabel);
        positionCombo = ComponentFactory.createComboBox(bean.getTallyPosition().getOptionsName(), bean.getTallyPosition().getVal());
        positionCombo.setBounds(120, 140, 180, 20);
        add(positionCombo);
        
        disabledLabel = new JLabel();
        disabledLabel.setText("Disabled");
        disabledLabel.setBounds(20, 180, 80, 20);
        add(disabledLabel);
        disabledCombo = ComponentFactory.createComboBox(bean.getDisabledColourSource().getOptionsName(), bean.getDisabledColourSource().getVal());
        disabledCombo.setBounds(120, 180, 180, 20);
        add(disabledCombo);
        
        colorLabel = new JLabel();
        colorLabel.setText("Colour");
        colorLabel.setBounds(20, 220, 80, 20);
        add(colorLabel);
        colorCombo = ComponentFactory.createComboBox(bean.getDisabledColour().getOptionsName(), bean.getDisabledColour().getVal());
        colorCombo.setBounds(120, 220, 180, 20);
        add(colorCombo);
        
        visibleCheck = new JCheckBoxTransBG();
        visibleCheck.setText("Visible");
        visibleCheck.setSelected(bean.getVisible().getVal());
        visibleCheck.setBounds(20, 260, 240, 20);
        add(visibleCheck);
                
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
  
}
