package dialogs.editobject;

import bean.TextProperties;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class PropertiesTextPanel extends JPanelBGGradient{
    private TextProperties bean;
    
    private JCheckBox[] textCheck;
    private JTextField[] textField;
    private int textCount;

    private JLabel alignmentLabel;
    private JComboBox alignmentCombo;
    
    private JLabel fontLabel;
    private JComboBox fontNameCombo;
    private JComboBox fontSizeCombo;

    private JLabel foregroundLabel;
    private JComboBox foregroundCombo;

    private JLabel backgroundLabel;
    private JComboBox backgroundCombo;
    private JLabel fontSizeLabel;
        
    public PropertiesTextPanel(TextProperties bean) throws MVException {
        MyItemListener mIL = new MyItemListener();
        
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        this.bean = bean;
        
        textCount = bean.getLineCount();
        textCheck = new JCheckBox[textCount];
        textField = new JTextField[textCount];
        
        for (int i = 0; i < textCount; i++) {
            textCheck[i] = new JCheckBoxTransBG("Text");
            textCheck[i].setSelected(bean.getLine(i).getEnabled().getVal());
            textCheck[i].addItemListener(mIL);
            textField[i] = ComponentFactory.createTextField(bean.getLine(i).getText().getVal(), 40);
        }
        
        alignmentLabel = new JLabel("Alignment");
        alignmentCombo = ComponentFactory.createComboBox(bean.getAlignment().getOptionsName(), bean.getAlignment().getVal());
        
        fontLabel = new JLabel("Font");
        fontNameCombo = ComponentFactory.createComboBox(bean.getFont().getOptionsName(), bean.getFont().getVal());
        
        fontSizeLabel = new JLabel("Font Size");
        fontSizeCombo = ComponentFactory.createComboBox(bean.getFontSize().getOptionsName(), bean.getFontSize().getVal());
        
        foregroundLabel = new JLabel("Foreground");
        foregroundCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());
        
        backgroundLabel = new JLabel("Background");
        backgroundCombo = ComponentFactory.createComboBox(bean.getBkcolour().getOptionsName(), bean.getBkcolour().getVal());
        
        for (int i = 0; i < textCount; i++) {
            layout.addRow(new Component[] {textCheck[i], textField[i]});
        }
        layout.addGrid(new Component[][] {
                {alignmentLabel, alignmentCombo},
                {fontLabel, fontNameCombo},
                {fontSizeLabel, fontSizeCombo},
                {foregroundLabel, foregroundCombo},
                {backgroundLabel, backgroundCombo},
        });
        
        checkComponentEnablingConditions();
    }
    
    public void save() {
        for (int i = 0; i < textCount; i++) {
            bean.getLine(i).getEnabled().setVal(textCheck[i].isSelected());
            bean.getLine(i).getText().setVal(textField[i].getText());
        }
        
        bean.getAlignment().setVal(alignmentCombo.getSelectedItem().toString());
        
        try{
            bean.getFont().setVal(fontNameCombo.getSelectedItem().toString());
        } catch (NullPointerException npe) {}
        
        bean.getFontSize().setVal(fontSizeCombo.getSelectedItem().toString());
        bean.getColour().setVal(foregroundCombo.getSelectedItem().toString());
        bean.getBkcolour().setVal(backgroundCombo.getSelectedItem().toString());
    }
    
    private void checkComponentEnablingConditions() {
        for (int i = 0; i < textCount; i++) {
            textField[i].setEnabled(textCheck[i].isSelected());
        }
    }
    
    private class MyItemListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            checkComponentEnablingConditions();
        }   
    }
}