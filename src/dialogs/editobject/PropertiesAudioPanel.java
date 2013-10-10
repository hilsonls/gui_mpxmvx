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
import gui.components.VGroupLayout;

import java.awt.Component;
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
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        
        this.bean = bean;
        
        visibleCheck = new JCheckBoxTransBG("Display audio meter");
        visibleCheck.setSelected(bean.getVisible().getVal());
        
        widthLabel = new JLabel("Meter bars width");
        widthSlider = new JSliderPanel(bean.getWidth().getMin(), bean.getWidth().getMax(), bean.getWidth().getVal());
    
        scaleLabel = new JLabel("Scale type");
        scaleCombo = ComponentFactory.createComboBox(bean.getScale().getOptionsName(), bean.getScale().getVal());
    
        scalePosLabel = new JLabel("Scale label position");
        scalePosCombo = ComponentFactory.createComboBox(bean.getScalePosition().getOptionsName(), bean.getScalePosition().getVal());
        
        barLabel = new JLabel("Bar colours");
        barCombo = createBarsCombo();
        overLabel = new JLabel("Over");
        overCombo = new JComboBox[16];
        for (int i = 0; i < 16; i++) {
            AudioSequenceItem asi = bean.getAudioSequence(0).getAudioSequenceItem(i);
            overCombo[i] = ComponentFactory.createComboBox(asi.getBarColourOver().getOptionsName(), asi.getBarColourOver().getVal());
            overCombo[i].setVisible(false);
        }
        overCombo[0].setVisible(true);
        
    
        upperLabel = new JLabel("Upper");
        upperCombo = new JComboBox[16];
        for (int i = 0; i < 16; i++) {
            AudioSequenceItem asi = bean.getAudioSequence(0).getAudioSequenceItem(i);
            upperCombo[i] = ComponentFactory.createComboBox(asi.getBarColourUpper().getOptionsName(), asi.getBarColourUpper().getVal());
            upperCombo[i].setVisible(false);
        }
        upperCombo[0].setVisible(true);
    
        lowerLabel = new JLabel("Lower");
        lowerCombo = new JComboBox[16];
        for (int i = 0; i < 16; i++) {
            AudioSequenceItem asi = bean.getAudioSequence(0).getAudioSequenceItem(i);
            lowerCombo[i] = ComponentFactory.createComboBox(asi.getBarColourLower().getOptionsName(), asi.getBarColourLower().getVal());
            lowerCombo[i].setVisible(false);
        }
        lowerCombo[0].setVisible(true);
    
        labelsLabel = new JLabel("Labels");
        labelsCombo = ComponentFactory.createComboBox(bean.getLabelType().getOptionsName(), bean.getLabelType().getVal());
        colourLabel = new JLabel("Colour");
        colourCombo = ComponentFactory.createComboBox(bean.getLabelColour().getOptionsName(), bean.getLabelColour().getVal());
    
        alarmCheck = new JCheckBoxTransBG("Show alarm indicators");
        alarmCheck.setSelected(bean.getAlarmIndicators().getVal());
    
        transparentCheck = new JCheckBoxTransBG("Transparent on video");
        transparentCheck.setSelected(bean.getTransparent().getVal());
    
        transparentLabel = new JLabel("Transparency level");
        transparentSlider = new JSliderPanel(bean.getTransparentLevel().getMin(), bean.getTransparentLevel().getMax(), bean.getTransparentLevel().getVal());
    
        displayCheck = new JCheckBoxTransBG("Display outside of picture");
        displayCheck.setSelected(bean.getOutsideVideo().getVal());
        
        splitBarsCheck = new JCheckBoxTransBG("Split meter into 2 groups placed left and right");
        splitBarsCheck.setSelected(bean.getSplitBars().getVal());
        
        layout.add(visibleCheck);
        layout.addGap();
        layout.addRow(new Component[] {widthLabel, widthSlider});
        layout.addGap();
        layout.addRow(new Component[] {scaleLabel, scaleCombo});
        layout.addRow(new Component[] {scalePosLabel, scalePosCombo});
        layout.addGap();
        layout.addGrid(new Component[][] {
                {barLabel, barCombo, overLabel, overCombo[0], overCombo[1], overCombo[2], overCombo[3], overCombo[4], overCombo[5], overCombo[6], overCombo[7], overCombo[8], overCombo[9], overCombo[10], overCombo[11], overCombo[12], overCombo[13], overCombo[14], overCombo[15]},
                {new JLabel(""), new JLabel(""), upperLabel, upperCombo[0], upperCombo[1], upperCombo[2], upperCombo[3], upperCombo[4], upperCombo[5], upperCombo[6], upperCombo[7], upperCombo[8], upperCombo[9], upperCombo[10], upperCombo[11], upperCombo[12], upperCombo[13], upperCombo[14], upperCombo[15]},
                {new JLabel(""), new JLabel(""), lowerLabel, lowerCombo[0], lowerCombo[1], lowerCombo[2], lowerCombo[3], lowerCombo[4], lowerCombo[5], lowerCombo[6], lowerCombo[7], lowerCombo[8], lowerCombo[9], lowerCombo[10], lowerCombo[11], lowerCombo[12], lowerCombo[13], lowerCombo[14], lowerCombo[15]},
        });
        layout.addGap();
        layout.addRow(new Component[] {labelsLabel, labelsCombo, colourLabel, colourCombo});
        layout.addGap();
        layout.add(alarmCheck);
        layout.add(transparentCheck);
        layout.addRow(new Component[] {transparentLabel, transparentSlider});
        layout.add(displayCheck);
        layout.add(splitBarsCheck);
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
