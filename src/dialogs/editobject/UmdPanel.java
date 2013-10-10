package dialogs.editobject;

import bean.Umd;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.JSliderPanel;
import gui.components.VGroupLayout;

import java.awt.Component;
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
        
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        
        this.bean = bean;
        
        text1Check = new JCheckBoxTransBG("Text 1st line");
        text1Check.setSelected(bean.getUmdText(0).getEnabled().getVal());
        text1Check.addItemListener(mIL);
        text1Field = ComponentFactory.createTextField(bean.getUmdText(0).getText().getVal(), 40);

        text2Check = new JCheckBoxTransBG("Text 2nd line");
        text2Check.setSelected(bean.getUmdText(1).getEnabled().getVal());
        text2Check.addItemListener(mIL);
        text2Field = ComponentFactory.createTextField(bean.getUmdText(1).getText().getVal(), 40);
        
        fontLabel = new JLabel("Font");
        fontNameCombo = ComponentFactory.createComboBox(bean.getFont().getOptionsName(), bean.getFont().getVal());
        
        fontSizeLabel = new JLabel("Font size");
        fontSizeCombo = ComponentFactory.createComboBox(bean.getFontSize().getOptionsName(), bean.getFontSize().getVal());

        foregroundLabel = new JLabel("Foreground colour");
        foregroundCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());
        
        backgroundLabel = new JLabel("Background colour");
        backgroundCombo = ComponentFactory.createComboBox(bean.getBkcolour().getOptionsName(), bean.getBkcolour().getVal());
        
        positionLabel = new JLabel("Position");
        positionLabel.setText("Position");
        positionCombo = ComponentFactory.createComboBox(bean.getUmdPosition().getOptionsName(), bean.getUmdPosition().getVal());
        
        separatorCheck = new JCheckBoxTransBG("Separator");
        separatorCheck.setSelected(bean.getUmdSeparator().getVal());
        separatorCheck.addItemListener(mIL);
        separatorCombo = ComponentFactory.createComboBox(bean.getUmdSeparatorColour().getOptionsName(), bean.getUmdSeparatorColour().getVal());
        
        insideCheck = new JCheckBoxTransBG("Inside tile");
        insideCheck.setSelected(bean.getInside().getVal());
        insideCheck.addItemListener(mIL);
        
        transparentCheck = new JCheckBoxTransBG("Transparent on video");
        transparentCheck.setSelected(bean.getTransparent().getVal());
        transparentCheck.addItemListener(mIL);
        
        transparentLabel = new JLabel("Transparency level");
        transparentSlider = new JSliderPanel(bean.getTransparentLevel().getMin(), bean.getTransparentLevel().getMax(), bean.getTransparentLevel().getVal());
        
        visibleCheck = new JCheckBoxTransBG("Visible");
        visibleCheck.setSelected(bean.getVisible().getVal());
        
        layout.addGrid(new Component[][] {
                {text1Check, text1Field},
                {text2Check, text2Field},
        });
        layout.addGap();
        layout.addGrid(new Component[][] {
                {fontLabel, fontNameCombo},
                {fontSizeLabel, fontSizeCombo},
        });
        layout.addGrid(new Component[][] {
                {foregroundLabel, foregroundCombo},
                {backgroundLabel, backgroundCombo},
        });
        layout.addGrid(new Component[][] {
                {positionLabel, positionCombo},
                {separatorCheck, separatorCombo},
        });
        layout.addGap();
        layout.add(insideCheck);
        layout.add(transparentCheck);
        layout.addRow(new Component[] {transparentLabel, transparentSlider});
        layout.add(visibleCheck);
        
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