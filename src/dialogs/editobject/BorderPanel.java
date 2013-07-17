/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.editobject;

import bean.Border;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.JSliderPanel;
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
            
        private JLabel styleLabel;
        private JComboBox styleCombo;

        //private JLabel visibleLabel;
        private JCheckBox visibleCheck;
        
        
    public BorderPanel(Border bean) throws MVException {
        setLayout(null);
        
        this.bean = bean;
        
        separatorLabel = new JLabel();
        separatorLabel.setText("Separator");
        separatorLabel.setBounds(20, 20, 80, 20);
        add(separatorLabel);
        separatorSlider = new JSliderPanel(bean.getSeparator().getMin(), bean.getSeparator().getMax(), bean.getSeparator().getVal());
        separatorSlider.setBounds(120, 20, 180, 20);
        add(separatorSlider);
            
        widthLabel = new JLabel();
        widthLabel.setText("Width");
        widthLabel.setBounds(20, 60, 80, 20);
        add(widthLabel);
        widthSlider = new JSliderPanel(bean.getWidth().getMin(), bean.getWidth().getMax(), bean.getWidth().getVal());
        widthSlider.setBounds(120, 60, 180, 20);
        add(widthSlider);

        colorLabel = new JLabel();
        colorLabel.setText("Colour");
        colorLabel.setBounds(20, 100, 80, 20);
        add(colorLabel);
        colorCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());  
        colorCombo.setBounds(120, 100, 180, 20);
        add(colorCombo);
        
        //styleLabel = new JLabel();
       // styleLabel.setText("Style");
      //  styleLabel.setBounds(20, 140, 80, 20);
      //  add(styleLabel); 
      //  styleCombo = ComponentFactory.createComboBox(bean.getStyle().getOptionsName(), bean.getStyle().getVal());  
      //  styleCombo.setBounds(120, 140, 180, 20);
      //  add(styleCombo);
        
        visibleCheck = new JCheckBoxTransBG();
        visibleCheck.setText("Visible");
        visibleCheck.setSelected(bean.getVisible().getVal());
        visibleCheck.setBounds(20, 140, 150, 20);
        add(visibleCheck);
    }
    
    public void save() {
        bean.getSeparator().setVal(separatorSlider.getValue());
        bean.getWidth().setVal(widthSlider.getValue());
        bean.getColour().setVal(colorCombo.getSelectedItem().toString());
        //bean.getStyle().setVal(styleCombo.getSelectedItem().toString());
        bean.getVisible().setVal(visibleCheck.isSelected());
    }
}
