/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.editobject;

import bean.Audio;
import bean.AudioSequenceItem;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.JSliderPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author panda
 */
public class PropertiesAudioPanel extends JPanelBGGradient{
    private Audio bean;
    
    private JLabel widthLabel;
    private JSliderPanel widthSlider;
    
    private JLabel scaleLabel;
    private JComboBox scaleCombo;
    
    private JLabel scalePosLabel;
    private JComboBox scalePosCombo;
    
    private JLabel barLabel;
    private JComboBox barCombo;
    private JLabel overLabel;
    private JComboBox[] overCombo;
    
    private JLabel upperLabel;
    private JComboBox[] upperCombo;
    
    private JLabel lowerLabel;
    private JComboBox[] lowerCombo;
    
    private JLabel labelsLabel;
    private JComboBox labelsCombo;
    private JLabel colourLabel;
    private JComboBox colourCombo;
    
    private JCheckBox alarmCheck;
    
    private JCheckBox transparentCheck;
    
    private JLabel transparentLabel;
    private JSliderPanel transparentSlider;
    
    private JCheckBox displayCheck;
    
    private JCheckBox visibleCheck;
    
    private JCheckBox splitBarsCheck;
    
   
    public PropertiesAudioPanel(Audio bean) throws MVException {
        setLayout(null);
        
        this.bean = bean;
        
        widthLabel = new JLabel();
        widthLabel.setText("Width");
        widthLabel.setBounds(20, 20, 60, 20);
        add(widthLabel);
        widthSlider = new JSliderPanel(bean.getWidth().getMin(), bean.getWidth().getMax(), bean.getWidth().getVal());
        widthSlider.setBounds(100, 20, 200, 20);
        add(widthSlider);
    
        scaleLabel = new JLabel();
        scaleLabel.setText("Scale");
        scaleLabel.setBounds(20, 55, 60, 20);
        add(scaleLabel);
        scaleCombo = ComponentFactory.createComboBox(bean.getScale().getOptionsName(), bean.getScale().getVal());
        scaleCombo.setBounds(100, 55, 200, 20);
        add(scaleCombo);
    
        scalePosLabel = new JLabel();
        scalePosLabel.setText("Scale Label Position");
        scalePosLabel.setBounds(20, 90, 140, 20);
        add(scalePosLabel);
        scalePosCombo = ComponentFactory.createComboBox(bean.getScalePosition().getOptionsName(), bean.getScalePosition().getVal());
        scalePosCombo.setBounds(180, 90, 120, 20);
        add(scalePosCombo);
        
        barLabel = new JLabel();
        barLabel.setText("Bar Colours");
        barLabel.setBounds(20, 125, 75, 20);
        add(barLabel);
        barCombo = createBarsCombo();
        barCombo.setBounds(100, 125, 65, 20);
        add(barCombo);
        overLabel = new JLabel();
        overLabel.setText("Over");
        overLabel.setBounds(180, 125, 40, 20);
        add(overLabel);
        overCombo = new JComboBox[16];
        for (int i = 0; i < 16; i++) {
            AudioSequenceItem asi = bean.getAudioSequence(0).getAudioSequenceItem(i);
            overCombo[i] = ComponentFactory.createComboBox(asi.getBarColourOver().getOptionsName(), asi.getBarColourOver().getVal());
            overCombo[i].setBounds(220, 125, 80, 20);
            overCombo[i].setVisible(false);
            add(overCombo[i]);
        }
        overCombo[0].setVisible(true);
        
    
        upperLabel = new JLabel();
        upperLabel.setText("Upper");
        upperLabel.setBounds(180, 160, 50, 20);
        add(upperLabel);
        upperCombo = new JComboBox[16];
        for (int i = 0; i < 16; i++) {
            AudioSequenceItem asi = bean.getAudioSequence(0).getAudioSequenceItem(i);
            upperCombo[i] = ComponentFactory.createComboBox(asi.getBarColourUpper().getOptionsName(), asi.getBarColourUpper().getVal());
            upperCombo[i].setBounds(220, 160, 80, 20);
            upperCombo[i].setVisible(false);
            add(upperCombo[i]);
        }
        upperCombo[0].setVisible(true);
    
        lowerLabel = new JLabel();
        lowerLabel.setText("Lower");
        lowerLabel.setBounds(180, 195, 50, 20);
        add(lowerLabel);
        lowerCombo = new JComboBox[16];
        for (int i = 0; i < 16; i++) {
            AudioSequenceItem asi = bean.getAudioSequence(0).getAudioSequenceItem(i);
            lowerCombo[i] = ComponentFactory.createComboBox(asi.getBarColourLower().getOptionsName(), asi.getBarColourLower().getVal());
            lowerCombo[i].setBounds(220, 195, 80, 20);
            lowerCombo[i].setVisible(false);
            add(lowerCombo[i]);
        }
        lowerCombo[0].setVisible(true);
    
        labelsLabel = new JLabel();
        labelsLabel.setText("Labels");
        labelsLabel.setBounds(20, 230, 55, 20);
        add(labelsLabel);
        labelsCombo = ComponentFactory.createComboBox(bean.getLabelType().getOptionsName(), bean.getLabelType().getVal());
        labelsCombo.setBounds(70, 230, 80, 20);
        add(labelsCombo);
        colourLabel = new JLabel();
        colourLabel.setText("Colour");
        colourLabel.setBounds(170, 230, 55, 20);
        add(colourLabel);
        colourCombo = ComponentFactory.createComboBox(bean.getLabelColour().getOptionsName(), bean.getLabelColour().getVal());
        colourCombo.setBounds(220, 230, 80, 20);
        add(colourCombo);
    
        alarmCheck = new JCheckBoxTransBG();
        alarmCheck.setText("Alarm Indicators");
        alarmCheck.setSelected(bean.getAlarmIndicators().getVal());
        alarmCheck.setBounds(20, 265, 180, 20);
        add(alarmCheck);
    
        transparentCheck = new JCheckBoxTransBG();
        transparentCheck.setText("Transparent on Video");
        transparentCheck.setSelected(bean.getTransparent().getVal());
        transparentCheck.setBounds(20, 295, 180, 20);
        add(transparentCheck);
    
        transparentLabel = new JLabel();
        transparentLabel.setText("Transparency Level");
        transparentLabel.setBounds(20, 325, 140, 20);
        add(transparentLabel);
        transparentSlider = new JSliderPanel(bean.getTransparentLevel().getMin(), bean.getTransparentLevel().getMax(), bean.getTransparentLevel().getVal());
        transparentSlider.setBounds(160, 325, 140, 20);
        add(transparentSlider);
    
        displayCheck = new JCheckBoxTransBG();
        displayCheck.setText("Display outside of picture");
        displayCheck.setSelected(bean.getOutsideVideo().getVal());
        displayCheck.setBounds(20, 355, 200, 20);
        add(displayCheck);
        
        visibleCheck = new JCheckBoxTransBG();
        visibleCheck.setText("Visible");
        visibleCheck.setSelected(bean.getVisible().getVal());
        visibleCheck.setBounds(20, 380, 120, 20);
        add(visibleCheck);
        
        splitBarsCheck = new JCheckBoxTransBG();
        splitBarsCheck.setText("Split Bars");
        splitBarsCheck.setSelected(bean.getSplitBars().getVal());
        splitBarsCheck.setBounds(160, 380, 200, 20);
        add(splitBarsCheck);
    }
    
    private JComboBox createBarsCombo() {
        JComboBox nuovo = new JComboBox();
        for (int i = 1; i <= 16; i++) {
            nuovo.addItem("Bar " + i);
        }
        nuovo.addActionListener(new BarSelectionListener());
        return nuovo;
    }
    
    public void save() {
        bean.getWidth().setVal(widthSlider.getValue());
        bean.getScale().setVal(scaleCombo.getSelectedItem().toString());
        bean.getScalePosition().setVal(scalePosCombo.getSelectedItem().toString());
        
        for (int i = 0; i < 16; i++) {
            AudioSequenceItem asi = bean.getAudioSequence(0).getAudioSequenceItem(i);
            asi.getBarColourOver().setVal(overCombo[i].getSelectedItem().toString());
            asi.getBarColourUpper().setVal(upperCombo[i].getSelectedItem().toString());
            asi.getBarColourLower().setVal(lowerCombo[i].getSelectedItem().toString());
        }
        
        bean.getLabelType().setVal(labelsCombo.getSelectedItem().toString());
        bean.getLabelColour().setVal(colourCombo.getSelectedItem().toString());
        bean.getAlarmIndicators().setVal(alarmCheck.isSelected());
        bean.getTransparent().setVal(transparentCheck.isSelected());
        bean.getTransparentLevel().setVal(transparentSlider.getValue());
        bean.getOutsideVideo().setVal(displayCheck.isSelected());
        bean.getVisible().setVal(visibleCheck.isSelected());
        bean.getSplitBars().setVal(splitBarsCheck.isSelected());
        
    }
    
    public class BarSelectionListener implements ActionListener {
        private int selectedIndex;
        
        public BarSelectionListener() {
            selectedIndex = 0;
        }
        
        public void actionPerformed(ActionEvent e) {
            JComboBox jcb = (JComboBox)e.getSource();
            int index = jcb.getSelectedIndex();
            if (index != selectedIndex) {
                overCombo[selectedIndex].setVisible(false);
                upperCombo[selectedIndex].setVisible(false);
                lowerCombo[selectedIndex].setVisible(false);
                
                overCombo[index].setVisible(true);
                upperCombo[index].setVisible(true);
                lowerCombo[index].setVisible(true);
                
                selectedIndex = index;
            }
        }
    }
}
