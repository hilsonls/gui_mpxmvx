/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.editobject;

import bean.Audio;
import bean.MeterSource;
import bean.AudioSequenceItem;
import bean.VidAudProperties;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.CtrlActions;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.JSliderPanel;
import gui.components.VGroupLayout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controllori.CtrlWorkspace;
import controllori.ProductType;

public class PropertiesAudioMeterPanel extends JPanelBGGradient{
    private Audio bean;
    private VidAudProperties vidAudPropBean;
    private PropertiesAudioPanel parentAudioPanel;
    
    private static final int NUM_METER_PAIRS = 8;
    private static final int NUM_EMBEDDED_PAIRS = 8;
    private static final int NUM_EXTERNAL_PAIRS = 128;

    private JLabel scaleLabel;
    private JComboBox scaleCombo;

    private JLabel scalePosLabel;
    private JComboBox scalePosCombo;
    
    private JPanel positionPanel;
    private JSliderPanel vposSlider;
    private JSliderPanel hposSlider;
    
    private JPanel sizePanel;
    private JSliderPanel vsizeSlider;
    private JSliderPanel widthSlider;
    
    private JPanel positionSizePanel;
    
    private JCheckBox multichannelCheck;
    private JCheckBox showRemainingPairsCheck;
    private JLabel numMultiPairsLabel;
    private JTextField numMultiPairsField;
    
    private JCheckBox splitRowsCheck;
    
    private JLabel sourcesLabel;
    private JLabel[] sourcePairLabel;
    private JComboBox[] sourcePairCombo;
    private static LinkedHashMap<String, Integer> sourcePairStoIMap;
    private static LinkedHashMap<Integer, String> sourcePairItoSMap;
    
    private JComboBox[] audioFormatCombo;
    private static LinkedHashMap<String, Integer> audioFormatStoIMap;
    private static LinkedHashMap<Integer, String> audioFormatItoSMap;

    private JLabel bottomRowLabel;
    private JCheckBox[] bottomRowCheck;
    
    private JPanel sourcesPanel;
    
    private JPanel tlPanel;

    private JLabel barLabel;
    private JComboBox barCombo;
    private JLabel overLabel;
    private JComboBox[] overCombo;
    private JLabel upperLabel;
    private JComboBox[] upperCombo;
    private JLabel lowerLabel;
    private JComboBox[] lowerCombo;
    private JLabel wrongLabel;
    private JComboBox[] wrongCombo;
    
    private JLabel labelsLabel;
    private JComboBox labelsCombo;
    private JCheckBox labelsRotateCheck;
    private JLabel colourLabel;
    private JComboBox colourCombo;
    
    private JCheckBox alarmCheck;
    private JCheckBox alarmBarFlashCheck;
    
    private JCheckBox transparentCheck;
    private JLabel transparentLabel;
    private JSliderPanel transparentSlider;
    
    private JCheckBox displayOutsideCheck;
    
    private JCheckBox autoFitCheck;
    
    private JSliderPanel intraPairSpacingSlider;
    private JSliderPanel interPairSpacingSlider;
    
    private boolean isAmProduct;
    
    public PropertiesAudioMeterPanel(PropertiesAudioPanel parentAudioPanel, Audio bean) throws MVException {
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        
        this.bean = bean;
        this.parentAudioPanel = parentAudioPanel;
        this.vidAudPropBean = parentAudioPanel.getVidAudPropBean();
        
        isAmProduct = (CtrlWorkspace.getInstance().getProductType(CtrlActions.getInstance().getIdModulo()) == ProductType.ProductTypeAM);

        scaleLabel = new JLabel("Scale type");
        scaleCombo = ComponentFactory.createComboBox(bean.getScale().getOptionsName(), bean.getScale().getVal());
        
        scalePosLabel = new JLabel("Scale label position");
        scalePosCombo = ComponentFactory.createComboBox(bean.getScalePosition().getOptionsName(), bean.getScalePosition().getVal());
        
        autoFitCheck = new JCheckBoxTransBG("Auto fit");
        autoFitCheck.setSelected(vidAudPropBean.isAutoFitAudioMeters());
        autoFitCheck.addItemListener(new AutoFitCheckListener());
        
        vposSlider = new JSliderPanel(bean.getYpos().getMin(), bean.getYpos().getMax(), bean.getYpos().getVal());
        vposSlider.setOrientation(SwingConstants.VERTICAL);
        vposSlider.getSlider().setInverted(true);
        Dimension d = vposSlider.getSlider().getPreferredSize();
        d.height = 100;
        vposSlider.getSlider().setPreferredSize(d);
        
        hposSlider = new JSliderPanel(bean.getXpos().getMin(), bean.getXpos().getMax(), bean.getXpos().getVal());
        d = hposSlider.getSlider().getPreferredSize();
        d.width = 100;
        hposSlider.setPreferredSize(d);

        positionPanel = new JPanel();
        VGroupLayout positionLayout = new VGroupLayout(positionPanel);
        positionPanel.setLayout(positionLayout);
        positionPanel.setBorder(new TitledBorder("Position"));
        positionPanel.setOpaque(false);
        positionLayout.add(vposSlider);
        positionLayout.add(hposSlider);

        vsizeSlider = new JSliderPanel(bean.getHeight().getMin(), bean.getHeight().getMax(), bean.getHeight().getVal());
        vsizeSlider.setOrientation(SwingConstants.VERTICAL);
        d = vsizeSlider.getSlider().getPreferredSize();
        d.height = 100;
        vsizeSlider.getSlider().setPreferredSize(d);

        widthSlider = new JSliderPanel(bean.getWidth().getMin(), bean.getWidth().getMax(), bean.getWidth().getVal());
        d = widthSlider.getSlider().getPreferredSize();
        d.width = 100;
        widthSlider.getSlider().setPreferredSize(d);

        sizePanel = new JPanel();
        VGroupLayout sizeLayout = new VGroupLayout(sizePanel);
        sizePanel.setLayout(sizeLayout);
        sizePanel.setBorder(new TitledBorder("Size"));
        sizePanel.setOpaque(false);
        sizeLayout.add(vsizeSlider);
        sizeLayout.add(widthSlider);
        
        if (bean.getIntraPairSpace() != null) {
            intraPairSpacingSlider = new JSliderPanel(bean.getIntraPairSpace().getMin(), bean.getIntraPairSpace().getMax(), bean.getIntraPairSpace().getVal());
            d = intraPairSpacingSlider.getSlider().getPreferredSize();
            d.width = 50;
            intraPairSpacingSlider.getSlider().setPreferredSize(d);
            intraPairSpacingSlider.addChangeListener(new IntraPairSpacingListener());
        }
        
        if (bean.getInterPairSpace() != null) {
            interPairSpacingSlider = new JSliderPanel(bean.getInterPairSpace().getMin(), bean.getInterPairSpace().getMax(), bean.getInterPairSpace().getVal());
            d = interPairSpacingSlider.getSlider().getPreferredSize();
            d.width = 50;
            interPairSpacingSlider.getSlider().setPreferredSize(d);
            interPairSpacingSlider.addChangeListener(new InterPairSpacingListener());
        }
        
        positionSizePanel = new JPanel();
        VGroupLayout positionSizeLayout = new VGroupLayout(positionSizePanel);
        positionSizePanel.setLayout(positionSizeLayout);
        positionSizePanel.setOpaque(false);
        positionSizeLayout.add(autoFitCheck);
        positionSizeLayout.add(positionPanel);
        positionSizeLayout.add(sizePanel);
        if (intraPairSpacingSlider != null)
            positionSizeLayout.addRow(new Component[] {new JLabel("Intra-pair spacing"), intraPairSpacingSlider});
        if (interPairSpacingSlider != null)
            positionSizeLayout.addRow(new Component[] {new JLabel("Inter-pair spacing"), interPairSpacingSlider});
        
        if (bean.getMultichan() != null) {
            multichannelCheck = new JCheckBox("Multi-channel metering");
            multichannelCheck.setOpaque(false);
            multichannelCheck.setSelected(bean.getMultichan().getVal());
            multichannelCheck.addItemListener(new MultichannelListener());
        }
        
        splitRowsCheck = new JCheckBox("Use 2 rows of bars");
        splitRowsCheck.setOpaque(false);
        splitRowsCheck.setSelected(bean.getSplitBars().getVal());
        splitRowsCheck.addItemListener(new Use2RowsListener());
        
        sourcesLabel = new JLabel("Audio sources:");
        sourcePairLabel = new JLabel[NUM_METER_PAIRS];
        sourcePairCombo = new JComboBox[NUM_METER_PAIRS];
        audioFormatCombo = new JComboBox[NUM_METER_PAIRS];
        bottomRowLabel = new JLabel("2nd row");
        bottomRowCheck = new JCheckBox[NUM_METER_PAIRS];
        for (int i = 0; i < NUM_METER_PAIRS; i++) {
            sourcePairLabel[i] = new JLabel("Pair " + (i+1));
            bottomRowCheck[i] = new JCheckBox();
            bottomRowCheck[i].setOpaque(false);
            bottomRowCheck[i].setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        bottomRowCheck[0].setSelected(bean.getMeterSource().getR1() != 0);
        bottomRowCheck[1].setSelected(bean.getMeterSource().getR2() != 0);
        bottomRowCheck[2].setSelected(bean.getMeterSource().getR3() != 0);
        bottomRowCheck[3].setSelected(bean.getMeterSource().getR4() != 0);
        bottomRowCheck[4].setSelected(bean.getMeterSource().getR5() != 0);
        bottomRowCheck[5].setSelected(bean.getMeterSource().getR6() != 0);
        bottomRowCheck[6].setSelected(bean.getMeterSource().getR7() != 0);
        bottomRowCheck[7].setSelected(bean.getMeterSource().getR8() != 0);
        createSourcePairCombos();
        createAudioTypeCombos();
        
        sourcesPanel = new JPanel();
        VGroupLayout sourcesPanelLayout = new VGroupLayout(sourcesPanel);
        sourcesPanel.setLayout(sourcesPanelLayout);
        sourcesPanel.setOpaque(false);
        sourcesPanel.setBorder(new TitledBorder("Meter layout"));
        if (multichannelCheck != null)
            sourcesPanelLayout.add(multichannelCheck);
        sourcesPanelLayout.add(splitRowsCheck);
        sourcesPanelLayout.addGrid(new Component[][] {
                {new JLabel(""), new JLabel("Audio source"), new JLabel("Audio format"), bottomRowLabel},
                {sourcePairLabel[0], sourcePairCombo[0], audioFormatCombo[0], bottomRowCheck[0]},
                {sourcePairLabel[1], sourcePairCombo[1], audioFormatCombo[1], bottomRowCheck[1]},
                {sourcePairLabel[2], sourcePairCombo[2], audioFormatCombo[2], bottomRowCheck[2]},
                {sourcePairLabel[3], sourcePairCombo[3], audioFormatCombo[3], bottomRowCheck[3]},
                {sourcePairLabel[4], sourcePairCombo[4], audioFormatCombo[4], bottomRowCheck[4]},
                {sourcePairLabel[5], sourcePairCombo[5], audioFormatCombo[5], bottomRowCheck[5]},
                {sourcePairLabel[6], sourcePairCombo[6], audioFormatCombo[6], bottomRowCheck[6]},
                {sourcePairLabel[7], sourcePairCombo[7], audioFormatCombo[7], bottomRowCheck[7]}
        });
        if (multichannelCheck != null) {
            showRemainingPairsCheck = new JCheckBox("Show all remaining pairs");
            showRemainingPairsCheck.setOpaque(false);
            showRemainingPairsCheck.setSelected(bean.getNumPairs().getVal() < 0);
            showRemainingPairsCheck.addItemListener(new ShowRemainingPairsListener());
            numMultiPairsLabel = new JLabel("Number of pairs");
            
            // -ve value of numPairs means show all remaining pairs
            // The value to use when show all remaining pairs gets unticked is
            // the -ve of this
            int numPairs = bean.getNumPairs().getVal();
            if (numPairs < 0)
                numPairs = -numPairs;
            numMultiPairsField = ComponentFactory.createTextField(numPairs);
            sourcesPanelLayout.add(showRemainingPairsCheck);
            sourcesPanelLayout.addRow(new Component[] {numMultiPairsLabel, numMultiPairsField});
            checkMultichannelEnablingConditions();
            checkShowRemainingPairsConditions();
        }
        
        tlPanel = new JPanel();
        VGroupLayout tlLayout = new VGroupLayout(tlPanel);
        tlPanel.setLayout(tlLayout);
        tlPanel.setOpaque(false);
        tlLayout.addRow(new Component[] {scaleLabel, scaleCombo, scalePosLabel, scalePosCombo});
        tlLayout.add(sourcesPanel);
        
        barLabel = new JLabel("Bar colours:");
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

        wrongLabel = new JLabel("Wrong format");
        wrongCombo = new JComboBox[16];
        for (int i = 0; i < 16; i++) {
            AudioSequenceItem asi = bean.getAudioSequence(0).getAudioSequenceItem(i);
            wrongCombo[i] = ComponentFactory.createComboBox(asi.getBarColourWrong().getOptionsName(), asi.getBarColourWrong().getVal());
            wrongCombo[i].setVisible(false);
        }
        wrongCombo[0].setVisible(true);

        labelsLabel = new JLabel("Bar labels");
        labelsCombo = ComponentFactory.createComboBox(bean.getLabelType().getOptionsName(), bean.getLabelType().getVal());
        if (bean.getLabelRotate() != null) {
            labelsRotateCheck = new JCheckBoxTransBG("Rotate text");
            labelsRotateCheck.setSelected(bean.getLabelRotate().getVal());
        }
        colourLabel = new JLabel("Colour");
        colourCombo = ComponentFactory.createComboBox(bean.getLabelColour().getOptionsName(), bean.getLabelColour().getVal());
    
        alarmCheck = new JCheckBoxTransBG("Show alarm indicators");
        alarmCheck.setSelected(bean.getAlarmIndicators().getVal());
        
        alarmBarFlashCheck = new JCheckBoxTransBG("Flash bars when an audio alarm is present");
        alarmBarFlashCheck.setSelected(bean.getAlarmBarFlash().getVal());
    
        transparentCheck = new JCheckBoxTransBG("Transparent on video");
        transparentCheck.setSelected(bean.getTransparent().getVal());
    
        transparentLabel = new JLabel("Fade level");
        transparentSlider = new JSliderPanel(bean.getTransparentLevel().getMin(), bean.getTransparentLevel().getMax(), bean.getTransparentLevel().getVal());
    
        displayOutsideCheck = new JCheckBoxTransBG("Display outside of picture");
        displayOutsideCheck.setSelected(bean.getOutsideVideo().getVal());
        
        layout.addRow(new Component[] {tlPanel, positionSizePanel});
        layout.add(barLabel);
        layout.addRow(new Component[] {
                barCombo, overLabel, overCombo[0], overCombo[1], overCombo[2], overCombo[3], overCombo[4], overCombo[5], overCombo[6], overCombo[7], overCombo[8], overCombo[9], overCombo[10], overCombo[11], overCombo[12], overCombo[13], overCombo[14], overCombo[15],
                upperLabel, upperCombo[0], upperCombo[1], upperCombo[2], upperCombo[3], upperCombo[4], upperCombo[5], upperCombo[6], upperCombo[7], upperCombo[8], upperCombo[9], upperCombo[10], upperCombo[11], upperCombo[12], upperCombo[13], upperCombo[14], upperCombo[15],
                lowerLabel, lowerCombo[0], lowerCombo[1], lowerCombo[2], lowerCombo[3], lowerCombo[4], lowerCombo[5], lowerCombo[6], lowerCombo[7], lowerCombo[8], lowerCombo[9], lowerCombo[10], lowerCombo[11], lowerCombo[12], lowerCombo[13], lowerCombo[14], lowerCombo[15],
                wrongLabel, wrongCombo[0], wrongCombo[1], wrongCombo[2], wrongCombo[3], wrongCombo[4], wrongCombo[5], wrongCombo[6], wrongCombo[7], wrongCombo[8], wrongCombo[9], wrongCombo[10], wrongCombo[11], wrongCombo[12], wrongCombo[13], wrongCombo[14], wrongCombo[15]
        });
        layout.addGap();
        Component labelRow[];
        if (labelsRotateCheck != null)
            labelRow = new Component[] {labelsLabel, labelsCombo, labelsRotateCheck, colourLabel, colourCombo};
        else
            labelRow = new Component[] {labelsLabel, labelsCombo, colourLabel, colourCombo};
        layout.addRow(labelRow);
        layout.addGap();
        layout.add(alarmCheck);
        layout.add(alarmBarFlashCheck);
        layout.addRow(new Component[] {transparentCheck, new JLabel(""), transparentLabel, transparentSlider});
        layout.add(displayOutsideCheck);
        
        check2ndRowEnablingConditions();
        checkAudioFitConditions();
        checkInterPairSpacing();
    }
    
    private JComboBox createBarsCombo() {
        JComboBox nuovo = new JComboBox();
        for (int i = 1; i <= 16; i++) {
            nuovo.addItem("Bar " + i);
        }
        nuovo.addActionListener(new BarSelectionListener());
        return nuovo;
    }
    
    private void buildSourcePairTable() {
        if (sourcePairItoSMap == null) {
            sourcePairItoSMap = new LinkedHashMap<Integer, String>();
            sourcePairStoIMap = new LinkedHashMap<String, Integer>();
            
            sourcePairItoSMap.put(-1, "None");
            
            if (!isAmProduct) {
                for (int i = 0; i < NUM_EMBEDDED_PAIRS; i++) {
                    sourcePairItoSMap.put(i, "Embedded " + (i*2+1) + "+" + (i*2+2));
                }
                for (int i = 0; i < NUM_EXTERNAL_PAIRS; i++) {
                    sourcePairItoSMap.put(i + NUM_EMBEDDED_PAIRS, "External " + (i*2+1) + "+" + (i*2+2));
                }
            } else {
                for (int i = 0; i < NUM_EXTERNAL_PAIRS; i++) {
                    sourcePairItoSMap.put(i + NUM_EMBEDDED_PAIRS, "Channel " + (i*2+1) + "+" + (i*2+2));
                }
            }
            
            Iterator<Entry<Integer, String>> it = sourcePairItoSMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, String> entry = it.next();
                sourcePairStoIMap.put(entry.getValue(), entry.getKey());
            }
            
        }
    }
    
    private void createSourcePairCombos() {
        buildSourcePairTable();

        Set<String> items = sourcePairStoIMap.keySet();

        for (int i = 0; i < NUM_METER_PAIRS; i++) {
            sourcePairCombo[i] = new JComboBox();
            Iterator<String> it = items.iterator();
            while (it.hasNext()) {
                sourcePairCombo[i].addItem(it.next());
            }
        }
        
        String[] item;
        item = new String[NUM_METER_PAIRS];
        item[0] = sourcePairItoSMap.get(bean.getMeterSource().getP1());
        item[1] = sourcePairItoSMap.get(bean.getMeterSource().getP2());
        item[2] = sourcePairItoSMap.get(bean.getMeterSource().getP3());
        item[3] = sourcePairItoSMap.get(bean.getMeterSource().getP4());
        item[4] = sourcePairItoSMap.get(bean.getMeterSource().getP5());
        item[5] = sourcePairItoSMap.get(bean.getMeterSource().getP6());
        item[6] = sourcePairItoSMap.get(bean.getMeterSource().getP7());
        item[7] = sourcePairItoSMap.get(bean.getMeterSource().getP8());
        
        for (int i = 0; i < NUM_METER_PAIRS; i++) {
            if (item[i] == null) {
                sourcePairCombo[i].setSelectedIndex(0);
            } else {
                sourcePairCombo[i].setSelectedItem(item[i]);
            }
        }
    }

    private void buildAudioFormatTable() {
        if (audioFormatItoSMap == null) {
            audioFormatItoSMap = new LinkedHashMap<Integer, String>();
            audioFormatStoIMap = new LinkedHashMap<String, Integer>();
            
            audioFormatItoSMap.put(0, "Auto");
            audioFormatItoSMap.put(1, "PCM");
            audioFormatItoSMap.put(2, "Dolby E 5.1+2");
            audioFormatItoSMap.put(3, "Dolby E 5.1+1+1");
            audioFormatItoSMap.put(4, "Dolby E 4+4");
            audioFormatItoSMap.put(5, "Dolby E 4+2+2");
            audioFormatItoSMap.put(6, "Dolby E 4+2+1+1");
            audioFormatItoSMap.put(7, "Dolby E 4+1+1+1+1");
            audioFormatItoSMap.put(8, "Dolby E 2+2+2+2");
            audioFormatItoSMap.put(9, "Dolby E 2+2+2+1+1");
            audioFormatItoSMap.put(10, "Dolby E 2+2+1+1+1+1");
            audioFormatItoSMap.put(11, "Dolby E 2+1+1+1+1+1+1");
            audioFormatItoSMap.put(12, "Dolby E 1+1+1+1+1+1+1+1");
            audioFormatItoSMap.put(13, "Dolby E 5.1");
            audioFormatItoSMap.put(14, "Dolby E 4+2");
            audioFormatItoSMap.put(15, "Dolby E 4+1+1");
            audioFormatItoSMap.put(16, "Dolby E 2+2+2");
            audioFormatItoSMap.put(17, "Dolby E 2+2+1+1");
            audioFormatItoSMap.put(18, "Dolby E 2+1+1+1+1");
            audioFormatItoSMap.put(19, "Dolby E 1+1+1+1+1+1");
            audioFormatItoSMap.put(20, "Dolby E 4");
            audioFormatItoSMap.put(21, "Dolby E 2+2");
            audioFormatItoSMap.put(22, "Dolby E 2+1+1");
            audioFormatItoSMap.put(23, "Dolby E 1+1+1+1");
            audioFormatItoSMap.put(24, "Dolby E 7.1");
            audioFormatItoSMap.put(25, "Dolby E 7.1 Screen");
            
            Iterator<Entry<Integer, String>> it = audioFormatItoSMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, String> entry = it.next();
                audioFormatStoIMap.put(entry.getValue(), entry.getKey());
            }
            
        }
    }

    private void createAudioTypeCombos() {
        buildAudioFormatTable();
        
        Set<String> items = audioFormatStoIMap.keySet();

        for (int i = 0; i < NUM_EMBEDDED_PAIRS; i++) {
            audioFormatCombo[i] = new JComboBox();
            Iterator<String> it = items.iterator();
            while (it.hasNext()) {
                audioFormatCombo[i].addItem(it.next());
            }
        }
        
        String[] item;
        item = new String[NUM_EMBEDDED_PAIRS];
        item[0] = audioFormatItoSMap.get(bean.getMeterSource().getF1());
        item[1] = audioFormatItoSMap.get(bean.getMeterSource().getF2());
        item[2] = audioFormatItoSMap.get(bean.getMeterSource().getF3());
        item[3] = audioFormatItoSMap.get(bean.getMeterSource().getF4());
        item[4] = audioFormatItoSMap.get(bean.getMeterSource().getF5());
        item[5] = audioFormatItoSMap.get(bean.getMeterSource().getF6());
        item[6] = audioFormatItoSMap.get(bean.getMeterSource().getF7());
        item[7] = audioFormatItoSMap.get(bean.getMeterSource().getF8());
        
        for (int i = 0; i < NUM_EMBEDDED_PAIRS; i++) {
            if (item[i] == null) {
                audioFormatCombo[i].setSelectedIndex(0);
            } else {
                audioFormatCombo[i].setSelectedItem(item[i]);
            }
        }
    }
    
    public void save() {
        // TODO save components recently added
        bean.getXpos().setVal(hposSlider.getValue());
        bean.getYpos().setVal(vposSlider.getValue());
        bean.getWidth().setVal(widthSlider.getValue());
        bean.getHeight().setVal(vsizeSlider.getValue());
        if (intraPairSpacingSlider != null)
            bean.getIntraPairSpace().setVal(intraPairSpacingSlider.getValue());
        if (interPairSpacingSlider != null)
            bean.getInterPairSpace().setVal(interPairSpacingSlider.getValue());
        bean.getScale().setVal(scaleCombo.getSelectedItem().toString());
        bean.getScalePosition().setVal(scalePosCombo.getSelectedItem().toString());
        bean.getMeterSource().setP1(sourcePairStoIMap.get(sourcePairCombo[0].getSelectedItem()));
        bean.getMeterSource().setP2(sourcePairStoIMap.get(sourcePairCombo[1].getSelectedItem()));
        bean.getMeterSource().setP3(sourcePairStoIMap.get(sourcePairCombo[2].getSelectedItem()));
        bean.getMeterSource().setP4(sourcePairStoIMap.get(sourcePairCombo[3].getSelectedItem()));
        bean.getMeterSource().setP5(sourcePairStoIMap.get(sourcePairCombo[4].getSelectedItem()));
        bean.getMeterSource().setP6(sourcePairStoIMap.get(sourcePairCombo[5].getSelectedItem()));
        bean.getMeterSource().setP7(sourcePairStoIMap.get(sourcePairCombo[6].getSelectedItem()));
        bean.getMeterSource().setP8(sourcePairStoIMap.get(sourcePairCombo[7].getSelectedItem()));
        bean.getMeterSource().setF1(audioFormatStoIMap.get(audioFormatCombo[0].getSelectedItem()));
        bean.getMeterSource().setF2(audioFormatStoIMap.get(audioFormatCombo[1].getSelectedItem()));
        bean.getMeterSource().setF3(audioFormatStoIMap.get(audioFormatCombo[2].getSelectedItem()));
        bean.getMeterSource().setF4(audioFormatStoIMap.get(audioFormatCombo[3].getSelectedItem()));
        bean.getMeterSource().setF5(audioFormatStoIMap.get(audioFormatCombo[4].getSelectedItem()));
        bean.getMeterSource().setF6(audioFormatStoIMap.get(audioFormatCombo[5].getSelectedItem()));
        bean.getMeterSource().setF7(audioFormatStoIMap.get(audioFormatCombo[6].getSelectedItem()));
        bean.getMeterSource().setF8(audioFormatStoIMap.get(audioFormatCombo[7].getSelectedItem()));
        bean.getMeterSource().setR1(bottomRowCheck[0].isSelected() ? 1 : 0);
        bean.getMeterSource().setR2(bottomRowCheck[1].isSelected() ? 1 : 0);
        bean.getMeterSource().setR3(bottomRowCheck[2].isSelected() ? 1 : 0);
        bean.getMeterSource().setR4(bottomRowCheck[3].isSelected() ? 1 : 0);
        bean.getMeterSource().setR5(bottomRowCheck[4].isSelected() ? 1 : 0);
        bean.getMeterSource().setR6(bottomRowCheck[5].isSelected() ? 1 : 0);
        bean.getMeterSource().setR7(bottomRowCheck[6].isSelected() ? 1 : 0);
        bean.getMeterSource().setR8(bottomRowCheck[7].isSelected() ? 1 : 0);
        
        for (int i = 0; i < 16; i++) {
            AudioSequenceItem asi = bean.getAudioSequence(0).getAudioSequenceItem(i);
            asi.getBarColourOver().setVal(overCombo[i].getSelectedItem().toString());
            asi.getBarColourUpper().setVal(upperCombo[i].getSelectedItem().toString());
            asi.getBarColourLower().setVal(lowerCombo[i].getSelectedItem().toString());
            asi.getBarColourWrong().setVal(wrongCombo[i].getSelectedItem().toString());
        }
        
        bean.getLabelType().setVal(labelsCombo.getSelectedItem().toString());
        if (labelsRotateCheck != null)
            bean.getLabelRotate().setVal(labelsRotateCheck.isSelected());
        bean.getLabelColour().setVal(colourCombo.getSelectedItem().toString());
        bean.getAlarmIndicators().setVal(alarmCheck.isSelected());
        bean.getAlarmBarFlash().setVal(alarmBarFlashCheck.isSelected());
        bean.getTransparent().setVal(transparentCheck.isSelected());
        bean.getTransparentLevel().setVal(transparentSlider.getValue());
        bean.getOutsideVideo().setVal(displayOutsideCheck.isSelected());
        bean.getSplitBars().setVal(splitRowsCheck.isSelected());
        if (bean.getMultichan() != null) {
            bean.getMultichan().setVal(multichannelCheck.isSelected());
            boolean showRemainingPairs = showRemainingPairsCheck.isSelected();
            int numPairs = Integer.parseInt(numMultiPairsField.getText());
            if (numPairs == 0) {
                showRemainingPairs = true;
                numPairs = 32;
            } else if (numPairs < 0) {
                showRemainingPairs = true;
                numPairs = -numPairs;
            }

            if (showRemainingPairs)
                bean.getNumPairs().setVal(-numPairs);
            else
                bean.getNumPairs().setVal(numPairs);
        }
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
                wrongCombo[selectedIndex].setVisible(false);
                
                overCombo[index].setVisible(true);
                upperCombo[index].setVisible(true);
                lowerCombo[index].setVisible(true);
                wrongCombo[index].setVisible(true);
                
                selectedIndex = index;
            }
        }
    }
    
    private void check2ndRowEnablingConditions() {
        boolean en = splitRowsCheck.isSelected();
        for (int i = 0; i < NUM_METER_PAIRS; i++) {
            bottomRowCheck[i].setEnabled(en);
        }
        bottomRowLabel.setEnabled(en);
    }
    
    private class Use2RowsListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            check2ndRowEnablingConditions();
        }
    }
    
    private void checkMultichannelEnablingConditions() {
        boolean en = multichannelCheck.isSelected();
        
        bottomRowLabel.setVisible(!en);
        bottomRowCheck[0].setVisible(!en);
        for (int i = 1; i < NUM_METER_PAIRS; i++) {
            sourcePairLabel[i].setVisible(!en);
            sourcePairCombo[i].setVisible(!en);
            audioFormatCombo[i].setVisible(!en);
            bottomRowCheck[i].setVisible(!en);
            numMultiPairsLabel.setVisible(en);
            numMultiPairsField.setVisible(en);
            showRemainingPairsCheck.setVisible(en);
        }
    }
    
    private class MultichannelListener implements ItemListener {
        
        @Override
        public void itemStateChanged(ItemEvent e) {
            checkMultichannelEnablingConditions();
        }
    }
    
    private void checkShowRemainingPairsConditions() {
        boolean en = showRemainingPairsCheck.isSelected();
        
        numMultiPairsLabel.setEnabled(!en);
        numMultiPairsField.setEnabled(!en);
    }
    
    private class ShowRemainingPairsListener implements ItemListener {
        
        @Override
        public void itemStateChanged(ItemEvent e) {
            checkShowRemainingPairsConditions();
        }
    }
    
    private void checkAudioFitConditions() {
        boolean autoFit = autoFitCheck.isSelected();
        vposSlider.setEnabled(!autoFit);
        hposSlider.setEnabled(!autoFit);
        vsizeSlider.setEnabled(!autoFit);
        widthSlider.setEnabled(!autoFit);
    }
    
    private class AutoFitCheckListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            checkAudioFitConditions();
            parentAudioPanel.updateAutoFit(autoFitCheck.isSelected());
        }
    }
    
    private void checkInterPairSpacing() {
        if (intraPairSpacingSlider != null && interPairSpacingSlider != null) {
            int intra = intraPairSpacingSlider.getValue();
            int inter = interPairSpacingSlider.getValue();
            if (inter < intra)
                interPairSpacingSlider.setValue(intra);
        }
    }
    
    private class IntraPairSpacingListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent arg0) {
            checkInterPairSpacing();
        }
    }

    private void checkIntraPairSpacing() {
        if (intraPairSpacingSlider != null && interPairSpacingSlider != null) {
            int intra = intraPairSpacingSlider.getValue();
            int inter = interPairSpacingSlider.getValue();
            if (inter < intra)
                intraPairSpacingSlider.setValue(inter);
        }
    }

    private class InterPairSpacingListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent arg0) {
            checkIntraPairSpacing();
        }
    }

    public boolean isAutoFit() {
        return autoFitCheck.isSelected();
    }
    
    public void updateAutoFit(boolean b) {
        if (autoFitCheck.isSelected() != b)
            autoFitCheck.setSelected(b);
    }
}
