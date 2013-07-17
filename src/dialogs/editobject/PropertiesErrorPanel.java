package dialogs.editobject;

import eccezioni.MVException;
import bean.Error;
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
public class PropertiesErrorPanel extends JPanelBGGradient{
    
    private Error bean;
    
    private JLabel colorLabel;
    private JComboBox colorCombo;
    
    private JLabel clearLabel;
    private JComboBox clearCombo;
    
    private JCheckBox showCheck;
    
    private JCheckBox visibleCheck;
    
    public PropertiesErrorPanel(Error bean) throws MVException {
        setLayout(null);
        this.bean = bean;
        
        colorLabel = new JLabel();
        colorLabel.setText("Colour");
        colorLabel.setBounds(20, 20, 80, 20);
        add(colorLabel);
        colorCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());
        colorCombo.setBounds(120, 20, 170, 20);
        add(colorCombo);
        
        clearLabel = new JLabel();
        clearLabel.setText("Clear");
        clearLabel.setBounds(20, 60, 80, 20);
        add(clearLabel);
        clearCombo = ComponentFactory.createComboBox(bean.getClearColour().getOptionsName(), bean.getClearColour().getVal());
        clearCombo.setBounds(120, 60, 170, 20);
        add(clearCombo);
        
        showCheck = new JCheckBoxTransBG();
        showCheck.setText("Show alarm name");
        showCheck.setSelected(bean.getShowName().getVal());
        showCheck.setBounds(20, 100, 240, 20);
        add(showCheck);
        
        visibleCheck = new JCheckBoxTransBG();
        visibleCheck.setText("Visible");
        visibleCheck.setSelected(bean.getVisible().getVal());
        visibleCheck.setBounds(20, 140, 240, 20);
        add(visibleCheck);
    }

    public void save() {
        bean.getColour().setVal(colorCombo.getSelectedItem().toString());
        bean.getClearColour().setVal(clearCombo.getSelectedItem().toString());
        bean.getShowName().setVal(showCheck.isSelected());
        bean.getVisible().setVal(visibleCheck.isSelected());
    }
}
