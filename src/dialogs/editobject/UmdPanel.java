package dialogs.editobject;

import bean.Umd;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.JSliderPanel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class UmdPanel extends JPanelBGGradient{
    private Umd bean;
    private int tileType;

    private JCheckBox text1Check;
    private JTextField text1Field;

    private JCheckBox text2Check;
    private JTextField text2Field;

    private JLabel fontLabel;
    private JComboBox fontNameCombo;
    private JComboBox fontSizeCombo;

    private JLabel foregroundLabel;
    private JComboBox foregroundCombo;

    private JLabel backgroundLabel;
    private JComboBox backgroundCombo;

    private JLabel positionLabel;
    private JComboBox positionCombo;

    private JCheckBox separatorCheck;
    private JComboBox separatorCombo;

    private JCheckBox insideCheck;

    private JCheckBox transparentCheck;

    private JLabel transparentLabel;
    private JSliderPanel transparentSlider;

    //private JLabel visibleLabel;
    private JCheckBox visibleCheck;
    private JLabel fontSizeLabel;
        
        
    public UmdPanel(Umd bean) throws MVException {
        MyItemListener mIL = new MyItemListener();
        
        setLayout(null);
        
        this.bean = bean;
        
        text1Check = new JCheckBoxTransBG();
        text1Check.setText("Text 1st line");
        text1Check.setSelected(bean.getUmdText(0).getEnabled().getVal());
        text1Check.setBounds(20, 20, 100, 20);
        text1Check.addItemListener(mIL);
        add(text1Check);
        text1Field = ComponentFactory.createTextField(bean.getUmdText(0).getText().getVal(), 40);
        text1Field.setBounds(120, 20, 180, 20);
        add(text1Field);

        text2Check = new JCheckBoxTransBG();
        text2Check.setText("Text 2nd line");
        text2Check.setSelected(bean.getUmdText(1).getEnabled().getVal());
        text2Check.setBounds(20, 55, 100, 20);
        text2Check.addItemListener(mIL);
        add(text2Check);
        text2Field = ComponentFactory.createTextField(bean.getUmdText(1).getText().getVal(), 40);
        text2Field.setBounds(120, 55, 180, 20);
        add(text2Field);        
        
        fontLabel = new JLabel();
        fontLabel.setText("Font");
        fontLabel.setBounds(20, 90, 80, 20);
        add(fontLabel);
        //Font font = new Font("Arial", Font.BOLD, 10);
        fontNameCombo = ComponentFactory.createComboBox(bean.getFont().getOptionsName(), bean.getFont().getVal());
        fontNameCombo.setBounds(65, 90, 235, 20);
        //fontNameCombo.setFont(font);
        add(fontNameCombo);
        
        fontSizeLabel = new JLabel();
        fontSizeLabel.setText("Font size");
        fontSizeLabel.setBounds(20, 125, 80, 20);
        add(fontSizeLabel);
        fontSizeCombo = ComponentFactory.createComboBox(bean.getFontSize().getOptionsName(), bean.getFontSize().getVal());
        fontSizeCombo.setBounds(120, 125, 55, 20);
        add(fontSizeCombo);

        foregroundLabel = new JLabel();
        foregroundLabel.setText("Foreground");
        foregroundLabel.setBounds(20, 160, 80, 20);
        add(foregroundLabel);
        foregroundCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());
        foregroundCombo.setBounds(120, 160, 180, 20);
        add(foregroundCombo);
        
        backgroundLabel = new JLabel();
        backgroundLabel.setText("Background");
        backgroundLabel.setBounds(20, 195, 80, 20);
        add(backgroundLabel);
        backgroundCombo = ComponentFactory.createComboBox(bean.getBkcolour().getOptionsName(), bean.getBkcolour().getVal());
        backgroundCombo.setBounds(120, 195, 180, 20);
        add(backgroundCombo);
        
        positionLabel = new JLabel();
        positionLabel.setText("Position");
        positionLabel.setBounds(20, 230, 80, 20);
        add(positionLabel);
        positionCombo = ComponentFactory.createComboBox(bean.getUmdPosition().getOptionsName(), bean.getUmdPosition().getVal());
        positionCombo.setBounds(120, 230, 180, 20);
        add(positionCombo);
        
        separatorCheck = new JCheckBoxTransBG();
        separatorCheck.setText("Separator");
        separatorCheck.setBounds(20, 265, 90, 20);
        separatorCheck.setSelected(bean.getUmdSeparator().getVal());
        separatorCheck.addItemListener(mIL);
        add(separatorCheck);
        separatorCombo = ComponentFactory.createComboBox(bean.getUmdSeparatorColour().getOptionsName(), bean.getUmdSeparatorColour().getVal());
        separatorCombo.setBounds(120, 265, 180, 20);
        add(separatorCombo);
        
        insideCheck = new JCheckBoxTransBG();
        insideCheck.setText("Inside tile");
        insideCheck.setBounds(20, 300, 120, 20);
        insideCheck.setSelected(bean.getInside().getVal());
        insideCheck.addItemListener(mIL);
        add(insideCheck);
        
        transparentCheck = new JCheckBoxTransBG();
        transparentCheck.setText("Transparent on video");
        transparentCheck.setBounds(20, 335, 180, 20);
        transparentCheck.setSelected(bean.getTransparent().getVal());
        transparentCheck.addItemListener(mIL);
        add(transparentCheck);
        
        transparentLabel = new JLabel();
        transparentLabel.setText("Transparency level");
        transparentLabel.setBounds(20, 370, 120, 20);
        add(transparentLabel);
        transparentSlider = new JSliderPanel(bean.getTransparentLevel().getMin(), bean.getTransparentLevel().getMax(), bean.getTransparentLevel().getVal());
        transparentSlider.setBounds(145, 370, 155, 20);
        add(transparentSlider);
        
        visibleCheck = new JCheckBoxTransBG();
        visibleCheck.setText("Visible");
        visibleCheck.setBounds(20, 405, 80, 20);
        visibleCheck.setSelected(bean.getVisible().getVal());
        add(visibleCheck); 
    }
    
    public void save() {
        bean.getUmdText(0).getEnabled().setVal(text1Check.isSelected());
        bean.getUmdText(0).getText().setVal(text1Field.getText());
        
        bean.getUmdText(1).getEnabled().setVal(text2Check.isSelected());
        bean.getUmdText(1).getText().setVal(text2Field.getText());
        
        try{
            bean.getFont().setVal(fontNameCombo.getSelectedItem().toString());
        } catch (NullPointerException npe) {}
        bean.getFontSize().setVal(fontSizeCombo.getSelectedItem().toString());
        
        bean.getColour().setVal(foregroundCombo.getSelectedItem().toString());
        
        bean.getBkcolour().setVal(backgroundCombo.getSelectedItem().toString());
        
        bean.getUmdPosition().setVal(positionCombo.getSelectedItem().toString());
        
        bean.getUmdSeparator().setVal(separatorCheck.isSelected());
        bean.getUmdSeparatorColour().setVal(separatorCombo.getSelectedItem().toString());
        
        bean.getInside().setVal(insideCheck.isSelected());
        
        bean.getTransparent().setVal(transparentCheck.isSelected());
        
        bean.getTransparentLevel().setVal(transparentSlider.getValue());
        
        bean.getVisible().setVal(visibleCheck.isSelected());
     
    }
    
    public void setTileType(int tileType) {
        this.tileType = tileType;
        checkComponentEnablingConditions();
    }
    
    private void checkComponentEnablingConditions() {
        /*if (tileType==EditObjectDialog.TILE_TYPE_VIDEO) {
            insideCheck.setEnabled(true);
            transparentCheck.setEnabled(insideCheck.isSelected());
            transparentLabel.setEnabled(insideCheck.isSelected() && transparentCheck.isSelected());
            transparentSlider.setEnabled(insideCheck.isSelected() && transparentCheck.isSelected());
        } else {
            insideCheck.setEnabled(false);
            transparentCheck.setEnabled(false);
            transparentLabel.setEnabled(false);
            transparentSlider.setEnabled(false);
        }*/
        text1Field.setEnabled(text1Check.isSelected());
        text2Field.setEnabled(text2Check.isSelected());
        separatorCombo.setEnabled(separatorCheck.isSelected());
    }
    
    private class MyItemListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            checkComponentEnablingConditions();
        }
        
    }
    
}