/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.editobject;

import bean.Vbi;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author panda
 */
public class PropertiesVbiPanel extends JPanelBGGradient{
    
    private Vbi bean;
    
    
    private JLabel ccLabel;
    
    private JCheckBox ccIndicatorCheck;
    
    private JCheckBox ccVisibleCheck;
    private JComboBox ccChannelCombo;
    
    
    private JLabel xdsLabel;
    
    private JCheckBox xdsVisibleCheck;
    
    
    private JLabel ttLabel;
    
    private JCheckBox ttIndicatorCheck;
    
    private JCheckBox ttVisibleCheck;
    
    private JLabel ttPageLabel;
    private JTextField ttPageField;
    
    
    private JLabel vitcLabel;
    
    private JCheckBox vitcVisibleCheck;
    
    public PropertiesVbiPanel(Vbi bean) throws MVException {
        setLayout(null);
        this.bean = bean;
        Font labelFont = new Font("Arial", Font.BOLD, 12);
        
        ccLabel = new JLabel();
        ccLabel.setFont(labelFont);
        ccLabel.setText("CC (US)");
        ccLabel.setBounds(20, 20, 200, 20);
        add(ccLabel);
        
    
        ccIndicatorCheck = new JCheckBoxTransBG();
        ccIndicatorCheck.setText("Indicator");
        ccIndicatorCheck.setSelected(bean.getCcIndicator().getVal());
        ccIndicatorCheck.setBounds(20, 45, 200, 20);
        add(ccIndicatorCheck);
    
        ccVisibleCheck = new JCheckBoxTransBG();
        ccVisibleCheck.setText("Visible");
        ccVisibleCheck.setSelected(bean.getCcVisible().getVal());
        ccVisibleCheck.setBounds(20, 70, 100, 20);
        add(ccVisibleCheck);
        ccChannelCombo = ComponentFactory.createComboBox(bean.getCcType().getOptionsName(), bean.getCcType().getVal());
        ccChannelCombo.setBounds(120, 70, 160, 20);
        add(ccChannelCombo);
    
    
        xdsLabel = new JLabel();
        xdsLabel.setFont(labelFont);
        xdsLabel.setText("XDS (US)");
        xdsLabel.setBounds(20, 110, 200, 20);
        add(xdsLabel);
    
        xdsVisibleCheck = new JCheckBoxTransBG();
        xdsVisibleCheck.setText("Visible");
        xdsVisibleCheck.setSelected(bean.getXdsVisible().getVal());
        xdsVisibleCheck.setBounds(20, 135, 200, 20);
        add(xdsVisibleCheck);
    
    
        ttLabel = new JLabel();
        ttLabel.setFont(labelFont);
        ttLabel.setText("TT (UK)");
        ttLabel.setBounds(20, 175, 200, 20);
        add(ttLabel);
    
        ttIndicatorCheck = new JCheckBoxTransBG();
        ttIndicatorCheck.setText("Indicator");
        ttIndicatorCheck.setSelected(bean.getTtIndicator().getVal());
        ttIndicatorCheck.setBounds(20, 200, 200, 20);
        add(ttIndicatorCheck);
    
        ttVisibleCheck = new JCheckBoxTransBG();
        ttVisibleCheck.setText("Visible");
        ttVisibleCheck.setSelected(bean.getTtVisible().getVal());
        ttVisibleCheck.setBounds(20, 225, 200, 20);
        add(ttVisibleCheck);
    
        ttPageLabel = new JLabel();
        ttPageLabel.setText("Page");
        ttPageLabel.setBounds(20, 250, 80, 20);
        add(ttPageLabel);
        ttPageField = ComponentFactory.createTextField(bean.getTtPage().getVal(), bean.getTtPage().getMin(), bean.getTtPage().getMax());
        ttPageField.setBounds(120, 250, 80, 20);
        add(ttPageField);
        
    
        vitcLabel = new JLabel();
        vitcLabel.setFont(labelFont);
        vitcLabel.setText("VITC");
        vitcLabel.setBounds(20, 290, 200, 20);
        add(vitcLabel);
        
        vitcVisibleCheck = new JCheckBoxTransBG();
        vitcVisibleCheck.setText("Visible");
        vitcVisibleCheck.setSelected(bean.getVitcVisible().getVal());
        vitcVisibleCheck.setBounds(20, 315, 200, 20);
        add(vitcVisibleCheck);
    }
    
    public void save() {
        bean.getCcIndicator().setVal(ccIndicatorCheck.isSelected());
        bean.getCcVisible().setVal(ccVisibleCheck.isSelected());
        bean.getCcType().setVal(ccChannelCombo.getSelectedItem().toString()); 
        bean.getXdsVisible().setVal(xdsVisibleCheck.isSelected());
        bean.getTtIndicator().setVal(ttIndicatorCheck.isSelected());
        bean.getTtVisible().setVal(ttVisibleCheck.isSelected());
        bean.getTtPage().setVal(Integer.parseInt(ttPageField.getText()));
        bean.getVitcVisible().setVal(vitcVisibleCheck.isSelected());
    }
        

}
