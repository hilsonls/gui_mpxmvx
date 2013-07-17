package dialogs.editobject;

import bean.Sag;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.JSliderPanel;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class PropertiesSagPanel extends JPanelBGGradient{
    private Sag bean;

    private JLabel screenAreaLabel;
    private JLabel sagCageLabel;
    
    private JCheckBox visibleCheck;
    
    private JLabel sagLabel;
    private JComboBox sagCombo;

    private JCheckBox customCheck;

    private JLabel verticalLabel;
    private JSliderPanel verticalSlider;
    private JLabel perc1Label;
    
    private JLabel horizontalLabel;
    private JSliderPanel horizontalSlider;
    private JLabel perc2Label;
        
        
    public PropertiesSagPanel(Sag bean) throws MVException {
        MyItemListener mIL = new MyItemListener();
        
        setLayout(null);
        
        this.bean = bean;
        
        screenAreaLabel = new JLabel();
        screenAreaLabel.setText("");
        screenAreaLabel.setBounds(20, 20, 280, 200);
        screenAreaLabel.setBackground(Color.BLUE);
        screenAreaLabel.setOpaque(true);
        add(screenAreaLabel);
        sagCageLabel = new JLabel();
        sagCageLabel.setText("");
        sagCageLabel.setBounds(60, 60, 160, 80);
        sagCageLabel.setBackground(Color.GRAY);
        sagCageLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
        sagCageLabel.setOpaque(true);
        screenAreaLabel.add(sagCageLabel);
        
        visibleCheck = new JCheckBoxTransBG();
        visibleCheck.setText("Visible");
        visibleCheck.setBounds(20, 240, 100, 20);
        visibleCheck.setSelected(bean.getSagVisible().getVal());
        visibleCheck.addItemListener(mIL);
        add(visibleCheck); 
        
        sagLabel = new JLabel();
        sagLabel.setText("Safe Area Cage");
        sagLabel.setBounds(20, 275, 120, 20);
        add(sagLabel);
        sagCombo = ComponentFactory.createComboBox(bean.getPreset().getOptionsName(), bean.getPreset().getVal());
        sagCombo.setBounds(150, 275, 150, 20);
        sagCombo.addItemListener(mIL);
        add(sagCombo);
        
        customCheck = new JCheckBoxTransBG();
        customCheck.setText("Setup Custom Cage");
        customCheck.setBounds(20, 310, 140, 20);
        customCheck.setSelected(bean.getUseCustom().getVal());
        customCheck.addItemListener(mIL);
        add(customCheck);
        
        verticalLabel = new JLabel();
        verticalLabel.setText("Vertical borders");
        verticalLabel.setBounds(20, 345, 120, 20);
        add(verticalLabel);
        verticalSlider = new JSliderPanel(0, 50, 0, 1);
        verticalSlider.setValue(bean.getVborderCustom().getVal());
        verticalSlider.setBounds(135, 345, 160, 20);
        verticalSlider.addChangeListener(mIL);
        add(verticalSlider);
        perc1Label = new JLabel();
        perc1Label.setText("%");
        perc1Label.setBounds(300, 345, 10, 20);
        add(perc1Label);
        
        horizontalLabel = new JLabel();
        horizontalLabel.setText("Horizontal borders");
        horizontalLabel.setBounds(20, 380, 120, 20);
        add(horizontalLabel);
        horizontalSlider = new JSliderPanel(0, 50, 0, 1);
        horizontalSlider.setValue(bean.getHborderCustom().getVal());
        horizontalSlider.setBounds(135, 380, 160, 20);
        horizontalSlider.addChangeListener(mIL);
        add(horizontalSlider);
        perc2Label = new JLabel();
        perc2Label.setText("%");
        perc2Label.setBounds(300, 380, 10, 20);
        add(perc2Label);
        
        checkComponentsEnablingConditions();
        computeSafeAreaLabel();
    }
    
    public void save() {
        bean.getSagVisible().setVal(visibleCheck.isSelected());
        bean.getPreset().setVal(sagCombo.getSelectedItem().toString());
        bean.getUseCustom().setVal(customCheck.isSelected());
        bean.getVborderCustom().setVal(verticalSlider.getFloatValue());
        bean.getHborderCustom().setVal(horizontalSlider.getFloatValue());
    }
    
    private void checkComponentsEnablingConditions() {
        boolean visible = visibleCheck.isSelected();
        boolean custom = customCheck.isSelected();
        sagCombo.setEnabled(visible && !custom);
        customCheck.setEnabled(visible);
        verticalSlider.setEnabled(visible && custom);
        horizontalSlider.setEnabled(visible && custom);
    }
    
    private void computeSafeAreaLabel() {
        int width = screenAreaLabel.getWidth();
        int height = screenAreaLabel.getHeight();
        float vB = getVBorders();
        float hB = getHBorders();
        
        int sagWidth = width-(int)(width * vB / 50);
        int sagHeight = height-(int)(height * hB / 50);
        int sagX = (width - sagWidth) / 2;
        int sagY = (height - sagHeight) / 2;
        
        sagCageLabel.setBounds(sagX, sagY, sagWidth, sagHeight);
    }
    
    private float getVBorders() {
        if (customCheck.isSelected())
            return verticalSlider.getFloatValue();
        else
            try {
                return CtrlWorkspace.getInstance().getSagBorders(sagCombo.getSelectedItem().toString())[1];
            } catch (MVException ex) {
                return verticalSlider.getFloatValue();
            }
    }
    
    private float getHBorders() {
        if (customCheck.isSelected())
            return horizontalSlider.getFloatValue();
        else
            try {
                return CtrlWorkspace.getInstance().getSagBorders(sagCombo.getSelectedItem().toString())[0];
            } catch (MVException ex) {
                return horizontalSlider.getFloatValue();
            }
    }
    
    private class MyItemListener implements ItemListener, ChangeListener {

        public void itemStateChanged(ItemEvent e) {
            checkComponentsEnablingConditions();
            computeSafeAreaLabel();
        }

        public void stateChanged(ChangeEvent e) {
            computeSafeAreaLabel();
        }
    }
}