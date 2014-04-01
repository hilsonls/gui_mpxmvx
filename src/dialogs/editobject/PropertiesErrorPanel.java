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
    
    private JLabel fontSizeLabel;
    private JComboBox fontSizeCombo;
    
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

        fontSizeLabel = new JLabel("Font size");
        fontSizeCombo = new JComboBox();
        fontSizeCombo.addItem("Auto");
        fontSizeCombo.addItem("8");
        fontSizeCombo.addItem("10");
        fontSizeCombo.addItem("12");
        fontSizeCombo.addItem("14");
        fontSizeCombo.addItem("18");
        fontSizeCombo.addItem("24");
        fontSizeCombo.addItem("28");
        fontSizeCombo.addItem("36");
        fontSizeCombo.addItem("48");
        fontSizeCombo.addItem("72");
        loadFontSize();

        layout.add(visibleCheck);
        layout.add(showCheck);
        layout.addRow(new Component[] {fontSizeLabel, fontSizeCombo});
        layout.add(colourPanel);

        checkComponentEnablingConditions();
    }

    public void save() {
        bean.getColour().setVal(colorCombo.getSelectedItem().toString());
        bean.getClearColour().setVal(clearCombo.getSelectedItem().toString());
        bean.getShowName().setVal(showCheck.isSelected());
        bean.getVisible().setVal(visibleCheck.isSelected());
        saveFontSize();
    }
    
    private void loadFontSize() {
        int fontSize = bean.getObjectErrorMsgSize().getVal();
        if (fontSize <= 0) {
            fontSizeCombo.setSelectedIndex(0);
        } else {
            int selectedIndex = -1;
            for (int i = 1; i < fontSizeCombo.getItemCount(); i++) {
                try {
                    int comboSize = Integer.valueOf(fontSizeCombo.getItemAt(i).toString());
                    if (fontSize <= comboSize) {
                        selectedIndex = i;
                        break;
                    }
                } catch (Exception e) {
                }
            }
            
            if (selectedIndex < 0) {
                fontSizeCombo.setSelectedIndex(fontSizeCombo.getItemCount() - 1);
            } else {
                fontSizeCombo.setSelectedIndex(selectedIndex);
            }
        }
    }
    
    private void saveFontSize() {
        int selectedIndex = fontSizeCombo.getSelectedIndex();
        if (selectedIndex == 0) {
            bean.getObjectErrorMsgSize().setVal(0);
        } else {
            int comboSize = -1;
            try {
                comboSize = Integer.valueOf(fontSizeCombo.getSelectedItem().toString());
            } catch (Exception e) {
            }
            
            if (comboSize < 0) {
                comboSize = 0;
                
            }
            bean.getObjectErrorMsgSize().setVal(comboSize);
        }
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
