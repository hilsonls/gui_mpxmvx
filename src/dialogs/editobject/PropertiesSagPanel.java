package dialogs.editobject;

import bean.Sag;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.JSliderPanel;
import gui.components.VGroupLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class PropertiesSagPanel extends JPanelBGGradient{
    private Sag bean;

    private JPanel sagImagePanel;
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
        
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        
        this.bean = bean;
        
        sagImagePanel = new JPanel();
        sagImagePanel.setLayout(null);
        sagImagePanel.setOpaque(false);
        sagImagePanel.setSize(280, 200);
        sagImagePanel.setMinimumSize(sagImagePanel.getSize());
        sagImagePanel.setPreferredSize(sagImagePanel.getSize());
        sagImagePanel.setMaximumSize(sagImagePanel.getSize());
        
        screenAreaLabel = new JLabel("");
        screenAreaLabel.setBounds(0, 0, 280, 200);
        screenAreaLabel.setBackground(Color.BLUE);
        screenAreaLabel.setOpaque(true);
        sagImagePanel.add(screenAreaLabel);
        sagCageLabel = new JLabel("");
        sagCageLabel.setBounds(60, 60, 160, 80);
        sagCageLabel.setBackground(Color.GRAY);
        sagCageLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
        sagCageLabel.setOpaque(true);
        screenAreaLabel.add(sagCageLabel);
        
        visibleCheck = new JCheckBoxTransBG("Visible");
        visibleCheck.setSelected(bean.getSagVisible().getVal());
        visibleCheck.addItemListener(mIL);
        
        sagLabel = new JLabel("Safe Area Cage");
        sagCombo = ComponentFactory.createComboBox(bean.getPreset().getOptionsName(), bean.getPreset().getVal());
        sagCombo.addItemListener(mIL);
        
        customCheck = new JCheckBoxTransBG("Setup Custom Cage");
        customCheck.setSelected(bean.getUseCustom().getVal());
        customCheck.addItemListener(mIL);
        
        Dimension prefSize;
        
        verticalLabel = new JLabel("Vertical borders");
        verticalSlider = new JSliderPanel(0, 50, 0, 1);
        verticalSlider.setValue(bean.getVborderCustom().getVal());
        verticalSlider.addChangeListener(mIL);
        prefSize = verticalSlider.getPreferredSize();
        prefSize.width = 50;
        verticalSlider.setPreferredSize(prefSize);
        perc1Label = new JLabel("%");
        
        horizontalLabel = new JLabel("Horizontal borders");
        horizontalSlider = new JSliderPanel(0, 50, 0, 1);
        horizontalSlider.setValue(bean.getHborderCustom().getVal());
        horizontalSlider.addChangeListener(mIL);
        prefSize = horizontalSlider.getPreferredSize();
        prefSize.width = 50;
        horizontalSlider.setPreferredSize(prefSize);
        perc2Label = new JLabel("%");

        layout.add(sagImagePanel);
        layout.add(visibleCheck);
        layout.addRow(new Component[] {sagLabel, sagCombo});
        layout.addGap();
        layout.add(customCheck);
        layout.addGridIndent(new Component[][] {
                {verticalLabel, verticalSlider, perc1Label},
                {horizontalLabel, horizontalSlider, perc2Label}
        });
        
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