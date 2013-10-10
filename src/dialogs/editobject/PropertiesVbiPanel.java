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
import gui.components.VGroupLayout;

import java.awt.Component;
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
    
    private JCheckBox xdsVisibleCheck;
    
    
    private JLabel ttLabel;
    
    private JCheckBox ttIndicatorCheck;
    
    private JCheckBox ttVisibleCheck;
    
    private JLabel ttPageLabel;
    private JTextField ttPageField;
    
    
    private JLabel vitcLabel;
    
    private JCheckBox vitcVisibleCheck;
    
    public PropertiesVbiPanel(Vbi bean) throws MVException {
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        this.bean = bean;
        Font labelFont = new Font("Arial", Font.BOLD, 12);
        
        ccLabel = new JLabel("Closed Captioning (EIA-608)");
        ccLabel.setFont(labelFont);
        
        ccIndicatorCheck = new JCheckBoxTransBG("Indicator on");
        ccIndicatorCheck.setSelected(bean.getCcIndicator().getVal());
        ccIndicatorCheck.setToolTipText("Show \"CC\" at top when signal detected");
    
        ccVisibleCheck = new JCheckBoxTransBG("Display service");
        ccVisibleCheck.setSelected(bean.getCcVisible().getVal());
        ccChannelCombo = ComponentFactory.createComboBox(bean.getCcType().getOptionsName(), bean.getCcType().getVal());
    
        xdsVisibleCheck = new JCheckBoxTransBG("Show XDS information");
        xdsVisibleCheck.setSelected(bean.getXdsVisible().getVal());
    
        ttLabel = new JLabel("Teletext");
        ttLabel.setFont(labelFont);
    
        ttIndicatorCheck = new JCheckBoxTransBG("Indicator on");
        ttIndicatorCheck.setSelected(bean.getTtIndicator().getVal());
        ttIndicatorCheck.setToolTipText("Show \"WST\" at top when signal detected");

        ttVisibleCheck = new JCheckBoxTransBG("Display service");
        ttVisibleCheck.setSelected(bean.getTtVisible().getVal());
    
        ttPageLabel = new JLabel("Page number");
        ttPageField = ComponentFactory.createTextField(bean.getTtPage().getVal(), bean.getTtPage().getMin(), bean.getTtPage().getMax());
        
        vitcLabel = new JLabel("D-VITC / Ancillary timecode");
        vitcLabel.setFont(labelFont);
        
        vitcVisibleCheck = new JCheckBoxTransBG("Visible");
        vitcVisibleCheck.setSelected(bean.getVitcVisible().getVal());
        
        layout.add(ccLabel);
        layout.add(ccIndicatorCheck);
        layout.addRow(new Component[] {ccVisibleCheck, ccChannelCombo});
        layout.add(xdsVisibleCheck);
        layout.addGap();
        layout.add(ttLabel);
        layout.add(ttIndicatorCheck);
        layout.add(ttVisibleCheck);
        layout.addRow(new Component[] {ttPageLabel, ttPageField});
        layout.addGap();
        layout.add(vitcLabel);
        layout.add(vitcVisibleCheck);
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
