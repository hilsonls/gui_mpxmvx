/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.editobject;

import java.awt.Component;
import java.awt.Dimension;

import bean.Border;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.JSliderPanel;
import gui.components.VGroupLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;


public class BorderPanel extends JPanelBGGradient{
    private Border bean;
    
    private JLabel separatorLabel;
    private JSliderPanel separatorSlider;
        
    private JLabel widthLabel;
    private JSliderPanel widthSlider;
    
    private JLabel colorLabel;
    private JComboBox colorCombo;
        
    private JCheckBox visibleCheck;
        
        
    public BorderPanel(Border bean) throws MVException {
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        
        this.bean = bean;
        
        separatorLabel = new JLabel("Separator");
        separatorSlider = new JSliderPanel(bean.getSeparator().getMin(), bean.getSeparator().getMax(), bean.getSeparator().getVal());

        widthLabel = new JLabel("Width");
        widthSlider = new JSliderPanel(bean.getWidth().getMin(), bean.getWidth().getMax(), bean.getWidth().getVal());

        colorLabel = new JLabel("Colour");
        colorCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());  
        
        visibleCheck = new JCheckBoxTransBG("Visible");
        visibleCheck.setSelected(bean.getVisible().getVal());
        
        layout.addGrid(new Component[][] {
                {separatorLabel, separatorSlider},
                {widthLabel, widthSlider},
                {colorLabel, colorCombo}
        });
        layout.add(visibleCheck);
    }
    
    public void save() {
        bean.getSeparator().setVal(separatorSlider.getValue());
        bean.getWidth().setVal(widthSlider.getValue());
        bean.getColour().setVal(colorCombo.getSelectedItem().toString());
        bean.getVisible().setVal(visibleCheck.isSelected());
    }
}
