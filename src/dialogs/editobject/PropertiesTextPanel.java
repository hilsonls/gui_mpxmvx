package dialogs.editobject;

import bean.TextProperties;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
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
        
        setLayout(null);
        this.bean = bean;
        
        textCount = bean.getLineCount();
        textCheck = new JCheckBox[textCount];
        textField = new JTextField[textCount];
        
        int top = 20;
        for (int i = 0; i < textCount; i++) {
            textCheck[i] = new JCheckBoxTransBG();
            textCheck[i].setText("Text");
            textCheck[i].setSelected(bean.getLine(i).getEnabled().getVal());
            textCheck[i].setBounds(20, top, 80, 20);
            textCheck[i].addItemListener(mIL);
            add(textCheck[i]);
            textField[i] = ComponentFactory.createTextField(bean.getLine(i).getText().getVal(), 40);
            textField[i].setBounds(120, top, 180, 20);
            add(textField[i]);
            top += 35;
        }
        
        alignmentLabel = new JLabel();
        alignmentLabel.setText("Alignment");
        alignmentLabel.setBounds(20, top, 80, 20);
        add(alignmentLabel);
        alignmentCombo = ComponentFactory.createComboBox(bean.getAlignment().getOptionsName(), bean.getAlignment().getVal());
        alignmentCombo.setBounds(120, top, 180, 20);
        add(alignmentCombo);        
        
        top += 35;
        fontLabel = new JLabel();
        fontLabel.setText("Font");
        fontLabel.setBounds(20, top, 80, 20);
        add(fontLabel);
        fontNameCombo = ComponentFactory.createComboBox(bean.getFont().getOptionsName(), bean.getFont().getVal());
        fontNameCombo.setBounds(65, top, 235, 20);
        add(fontNameCombo);
        
        top += 35;
        
        fontSizeLabel = new JLabel();
        fontSizeLabel.setText("Font Size");
        fontSizeLabel.setBounds(20, top, 80, 20);
        add(fontSizeLabel);
        fontSizeCombo = ComponentFactory.createComboBox(bean.getFontSize().getOptionsName(), bean.getFontSize().getVal());
        fontSizeCombo.setBounds(120, top, 55, 20);
        add(fontSizeCombo);
        
        top += 35;
        foregroundLabel = new JLabel();
        foregroundLabel.setText("Foreground");
        foregroundLabel.setBounds(20, top, 80, 20);
        add(foregroundLabel);
        foregroundCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());
        foregroundCombo.setBounds(120, top, 180, 20);
        add(foregroundCombo);
        
        top += 35;
        backgroundLabel = new JLabel();
        backgroundLabel.setText("Background");
        backgroundLabel.setBounds(20, top, 80, 20);
        add(backgroundLabel);
        backgroundCombo = ComponentFactory.createComboBox(bean.getBkcolour().getOptionsName(), bean.getBkcolour().getVal());
        backgroundCombo.setBounds(120, top, 180, 20);
        add(backgroundCombo);
        
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