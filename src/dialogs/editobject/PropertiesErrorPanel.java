package dialogs.editobject;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import eccezioni.MVException;
import bean.Error;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author panda
 */
public class PropertiesErrorPanel extends JPanelBGGradient{
    
    private Error bean;
    
    private JPanel colourPanel;
    
    private JLabel colorLabel;
    private JComboBox colorCombo;
    
    private JLabel clearLabel;
    private JComboBox clearCombo;
    
    private JCheckBox showCheck;
    
    private JCheckBox visibleCheck;
    
    public PropertiesErrorPanel(Error bean) throws MVException {
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        this.bean = bean;
        
        MyItemListener mIL = new MyItemListener();
        
        visibleCheck = new JCheckBoxTransBG("Enable alarm alerts");
        visibleCheck.setSelected(bean.getVisible().getVal());
        visibleCheck.addItemListener(mIL);

        showCheck = new JCheckBoxTransBG("Display alarm messages");
        showCheck.setSelected(bean.getShowName().getVal());

        colorLabel = new JLabel("Alarm active");
        colorCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());
        
        clearLabel = new JLabel("All alarms recently cleared");
        clearCombo = ComponentFactory.createComboBox(bean.getClearColour().getOptionsName(), bean.getClearColour().getVal());

        colourPanel = new JPanel();
        VGroupLayout colourLayout = new VGroupLayout(colourPanel);
        colourPanel.setLayout(colourLayout);
        colourPanel.setBorder(new TitledBorder("Border and error message colours"));
        colourPanel.setOpaque(false);
        colourLayout.addGrid(new Component[][] {
                {colorLabel, colorCombo},
                {clearLabel, clearCombo},
        });

        layout.add(visibleCheck);
        layout.add(showCheck);
        layout.add(colourPanel);
        
        checkComponentEnablingConditions();
    }

    public void save() {
        bean.getColour().setVal(colorCombo.getSelectedItem().toString());
        bean.getClearColour().setVal(clearCombo.getSelectedItem().toString());
        bean.getShowName().setVal(showCheck.isSelected());
        bean.getVisible().setVal(visibleCheck.isSelected());
    }
    
    private void checkComponentEnablingConditions() {
        showCheck.setEnabled(visibleCheck.isSelected());
        colourPanel.setEnabled(visibleCheck.isSelected());
        colorLabel.setEnabled(visibleCheck.isSelected());
        colorCombo.setEnabled(visibleCheck.isSelected());
        clearLabel.setEnabled(visibleCheck.isSelected());
        clearCombo.setEnabled(visibleCheck.isSelected());
    }
    
    private class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            checkComponentEnablingConditions();
        }

    }

}
