

package dialogs.source;

import bean.AnalogueThreshold;
import bean.AudioAlarmSettings;
import bean.Chan;
import bean.Pair;
import bean.Threshold;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.JSliderPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class AudioAlarmsPanel extends JPanelBGGradient{
    private static final String AC_AUDIO_LOSS = "AudioLoss";
    private static final String AC_AUDIO_OVER = "AudioOver";
    private static final String AC_PHASE = "Phase";
    private static final String AC_CARRIER_LOSS = "CarrierLoss";
    
    private AudioAlarmSettings audioAlarmSettings;
    
    private int numChannels;
    
    private JLabel lossThresholdLabel;
    private JSliderPanel lossThresholdSlider;
    private JLabel lossThresholdUnitsLabel;

    private JLabel overThresholdLabel;
    private JSliderPanel overThresholdSlider;
    private JLabel overThresholdUnitsLabel;
        
    private JLabel antiphaseThresholdLabel;
    private JSliderPanel antiphaseThresholdSlider;
    private JLabel antiphaseThresholdUnitsLabel;
    
    private JLabel enableAlarmsLabel;

    private JLabel audioLossLabel;
    private JLabel audioOverLabel;
    private JLabel phaseLabel;
    private JLabel carrierLossLabel;
    
    private JCheckBox[] audioLossCheck;
    private JCheckBox[] audioOverCheck;
    private JCheckBox[] phaseCheck;
    private JCheckBox[] carrierLossCheck;
    private JPanel checkPanel;
    private JScrollPane checkScrollPane;
    
    private JButton allAudioLossButton;
    private JButton allAudioOverButton;
    private JButton allPhaseButton;
    private JButton allCarrierLossButton;
    
    private int adReference;
        
    private class AudioAlarmsPanelActionListener implements ActionListener,
            ChangeListener {
        private boolean allAudioLoss;
        private boolean allAudioOver;
        private boolean allPhase;
        private boolean allCarrierLoss;
        
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if (ae.getActionCommand().equals(AC_AUDIO_LOSS)) {
                for (int i = 0; i < numChannels; i++) {
                    audioLossCheck[i].setSelected(allAudioLoss);
                }
                allAudioLoss = !allAudioLoss;
            } else if (ae.getActionCommand().equals(AC_AUDIO_OVER)) {
                for (int i = 0; i < numChannels; i++) {
                    audioOverCheck[i].setSelected(allAudioOver);
                }
                allAudioOver = !allAudioOver;
            } else if (ae.getActionCommand().equals(AC_PHASE)) {
                for (int i = 0; i < numChannels / 2; i++) {
                    phaseCheck[i].setSelected(allPhase);
                }
                allPhase = !allPhase;
            } else if (ae.getActionCommand().equals(AC_CARRIER_LOSS)) {
                for (int i = 0; i < numChannels / 2; i++) {
                    carrierLossCheck[i].setSelected(allCarrierLoss);
                }
                allCarrierLoss = !allCarrierLoss;
            }
        }
        
        @Override
        public void stateChanged(ChangeEvent e) {
            Object obj = e.getSource();
            if (obj == lossThresholdSlider) {
                updateLossThresholdDigitalLabel();
            } else if (obj == overThresholdSlider) {
                updateOverThresholdDigitalLabel();
            }
        }

        AudioAlarmsPanelActionListener() {
            allAudioLoss = true;
            allAudioOver = true;
            allPhase = true;
            allCarrierLoss = true;
        }
    }
    
    public AudioAlarmsPanel(AudioAlarmSettings audioAlarmSettings) {
        //setto dimensione panel
        setLayout(null);
        setBounds(1, 30, 430, 460);
        
        //setto action e item listeners;
        AudioAlarmsPanelActionListener audioPanelActionListener = new AudioAlarmsPanelActionListener();
          
        //associo bean e creo riferimenti a oggetti bean
        this.audioAlarmSettings = audioAlarmSettings;
        AnalogueThreshold lossAnlgThreshold =  audioAlarmSettings.getAudioLossAlarm().getAnalogueThreshold();
        AnalogueThreshold overAnlgThreshold =  audioAlarmSettings.getAudioOverAlarm().getAnalogueThreshold();
        Threshold phaseThreshold = audioAlarmSettings.getPhaseAlarm().getThreshold();
        Chan[] chanLoss = audioAlarmSettings.getAudioLossAlarm().getChan();
        Chan[] chanOver = audioAlarmSettings.getAudioOverAlarm().getChan();
        Pair[] pairPhase = audioAlarmSettings.getPhaseAlarm().getPair();
        Pair[] pairCarrier = audioAlarmSettings.getCarrierLossAlarm().getPair();
        //logica implementativa di condizioni del menu
        
        numChannels = chanLoss.length;
        
        //oggetti interfaccia utente
        lossThresholdLabel = new JLabel("Audio Loss Threshold");
        lossThresholdLabel.setBounds(20,20,130,20);
        add(lossThresholdLabel);
        lossThresholdSlider = new JSliderPanel(audioAlarmSettings.getAudioLossAlarm().getAnalogueThreshold().getMin(), audioAlarmSettings.getAudioLossAlarm().getAnalogueThreshold().getMax(), audioAlarmSettings.getAudioLossAlarm().getAnalogueThreshold().getVal());
        lossThresholdSlider.setBounds(170, 20, 145, 20);
        lossThresholdSlider.addChangeListener(audioPanelActionListener);
        add(lossThresholdSlider);
        lossThresholdUnitsLabel = new JLabel();
        lossThresholdUnitsLabel.setBounds(320,20,100,20);
        add(lossThresholdUnitsLabel);
        
        overThresholdLabel = new JLabel("Audio Over Threshold");
        overThresholdLabel.setBounds(20,50,130,20);
        add(overThresholdLabel);
        overThresholdSlider = new JSliderPanel(audioAlarmSettings.getAudioOverAlarm().getAnalogueThreshold().getMin(),audioAlarmSettings.getAudioOverAlarm().getAnalogueThreshold().getMax(), audioAlarmSettings.getAudioOverAlarm().getAnalogueThreshold().getVal());
        overThresholdSlider.setBounds(170, 50, 145, 20);
        overThresholdSlider.addChangeListener(audioPanelActionListener);
        add(overThresholdSlider);
        overThresholdUnitsLabel = new JLabel();
        overThresholdUnitsLabel.setBounds(320,50,100,20);
        add(overThresholdUnitsLabel);
        
        antiphaseThresholdLabel = new JLabel("Antiphase Threshold");
        antiphaseThresholdLabel.setBounds(20,80,130,20);
        add(antiphaseThresholdLabel);
        antiphaseThresholdSlider = new JSliderPanel(audioAlarmSettings.getPhaseAlarm().getThreshold().getMin(), audioAlarmSettings.getPhaseAlarm().getThreshold().getMax(), audioAlarmSettings.getPhaseAlarm().getThreshold().getVal());
        antiphaseThresholdSlider.setBounds(170,80,145,20);
        add(antiphaseThresholdSlider);
        antiphaseThresholdUnitsLabel = new JLabel("degrees");
        antiphaseThresholdUnitsLabel.setBounds(320,80,100,20);
        add(antiphaseThresholdUnitsLabel);
        
        enableAlarmsLabel = new JLabel("Enable Alarms");
        enableAlarmsLabel.setFont(new Font("Arial",Font.BOLD,12));
        enableAlarmsLabel.setBounds(70,120,300,20);
        enableAlarmsLabel.setHorizontalAlignment(JLabel.CENTER);
        add(enableAlarmsLabel);
        
        audioLossLabel = new JLabel("Audio Loss");
        audioLossLabel.setBounds(70,140,80,20);
        audioLossLabel.setHorizontalAlignment(JLabel.CENTER);
        add(audioLossLabel);
        audioOverLabel = new JLabel("Audio Over");
        audioOverLabel.setBounds(140,140,80,20);
        audioOverLabel.setHorizontalAlignment(JLabel.CENTER);
        add(audioOverLabel);
        phaseLabel = new JLabel("Phase");
        phaseLabel.setBounds(210,140,80,20);
        phaseLabel.setHorizontalAlignment(JLabel.CENTER);
        add(phaseLabel);
        carrierLossLabel = new JLabel("Carrier Loss");
        carrierLossLabel.setBounds(280,140,80,20);
        carrierLossLabel.setHorizontalAlignment(JLabel.CENTER);
        add(carrierLossLabel);
        
        // Panel containing the checkboxes for enabling alarms. A separate
        // panel is used so that it can be wrapped in a JScrollPane if necessary
        // (when there are more than 16 channels to display).
        int y = 0;
        checkPanel = new JPanel();
        checkPanel.setLayout(null);
        checkPanel.setOpaque(false);
        //ciclo per i canali mosconi
        audioLossCheck = new JCheckBox[numChannels];
        audioOverCheck = new JCheckBox[numChannels];
        phaseCheck = new JCheckBox[numChannels/2];
        carrierLossCheck = new JCheckBox[numChannels/2];
        
        for (int i=0; i<numChannels; i++){
            JLabel label = new JLabel((i % 2 == 0 ? "Left " : "Right ") + Integer.toString(i / 2 + 1));
            label.setHorizontalAlignment(JLabel.RIGHT);
            label.setBounds(20,y,60,17);
            checkPanel.add(label);
            
            audioLossCheck[i] = new JCheckBoxTransBG();
            audioLossCheck[i].setBounds(85,y,17,17);
            audioLossCheck[i].setSelected(chanLoss[i].getVal());
            checkPanel.add(audioLossCheck[i]);
            
            audioOverCheck[i] = new JCheckBoxTransBG();
            audioOverCheck[i].setBounds(155,y,17,17);
            audioOverCheck[i].setSelected(chanOver[i].getVal());
            checkPanel.add(audioOverCheck[i]);
            
            if(i%2 == 0){
                phaseCheck[i/2] = new JCheckBoxTransBG();
                phaseCheck[i/2].setBounds(225,y+8,17,17);
                phaseCheck[i/2].setSelected(pairPhase[i/2].getVal());
                checkPanel.add(phaseCheck[i/2]);
                
                carrierLossCheck[i/2] = new JCheckBoxTransBG();
                carrierLossCheck[i/2].setBounds(295,y+8,17,17);
                carrierLossCheck[i/2].setSelected(pairCarrier[i/2].getVal());
                checkPanel.add(carrierLossCheck[i/2]);
            }
            
            y+=17;
        }
        
        // Wrap the alarm enable pane in a JScrollPane if necessary
        if (numChannels <= 16) {
            checkPanel.setBounds(15, 160, 380, 280);
            add(checkPanel);
        } else {
            checkPanel.setBounds(0, 0, 330, 280);
            Dimension d = new Dimension(330, y);
            checkPanel.setPreferredSize(d);
            
            checkScrollPane = new JScrollPane(checkPanel);
            checkScrollPane.setOpaque(false);
            checkScrollPane.setBounds(15, 160, 380, 280);
            add(checkScrollPane);
        }
        
        allAudioLossButton = new JButton("All");
        allAudioLossButton.setBounds(80,440,50,20);
        allAudioLossButton.setActionCommand(AC_AUDIO_LOSS);
        allAudioLossButton.addActionListener(audioPanelActionListener);
        add(allAudioLossButton);
        
        allAudioOverButton = new JButton("All");
        allAudioOverButton.setBounds(150,440,50,20);
        allAudioOverButton.setActionCommand(AC_AUDIO_OVER);
        allAudioOverButton.addActionListener(audioPanelActionListener);
        add(allAudioOverButton);
        
        allPhaseButton = new JButton("All");
        allPhaseButton.setBounds(220,440,50,20);
        allPhaseButton.setActionCommand(AC_PHASE);
        allPhaseButton.addActionListener(audioPanelActionListener);
        add(allPhaseButton);
        
        allCarrierLossButton = new JButton("All");
        allCarrierLossButton.setBounds(290,440,50,20);
        allCarrierLossButton.setActionCommand(AC_CARRIER_LOSS);
        allCarrierLossButton.addActionListener(audioPanelActionListener);
        add(allCarrierLossButton);
        
    }
    
    public void save() {
        save(null);
    }
    
    public void save(AudioAlarmSettings audioAlarmSettings) {
        if (audioAlarmSettings==null) {
            audioAlarmSettings = this.audioAlarmSettings;
        }
        
        AnalogueThreshold lossAnlgThreshold =  audioAlarmSettings.getAudioLossAlarm().getAnalogueThreshold();
        AnalogueThreshold overAnlgThreshold =  audioAlarmSettings.getAudioOverAlarm().getAnalogueThreshold();
        Threshold phaseThreshold = audioAlarmSettings.getPhaseAlarm().getThreshold();
        Chan[] chanLoss = audioAlarmSettings.getAudioLossAlarm().getChan();
        Chan[] chanOver = audioAlarmSettings.getAudioOverAlarm().getChan();
        Pair[] pairPhase = audioAlarmSettings.getPhaseAlarm().getPair();
        Pair[] pairCarrier = audioAlarmSettings.getCarrierLossAlarm().getPair();
        //logica implementativa di condizioni del menu
       
        
        //oggetti interfaccia utente
        lossAnlgThreshold.setVal(lossThresholdSlider.getValue());
        overAnlgThreshold.setVal(overThresholdSlider.getValue());
        phaseThreshold.setVal(antiphaseThresholdSlider.getValue());
        
        //ciclo per i canali mosconi
        for (int i=0; i<numChannels; i++){
            chanLoss[i].setVal(audioLossCheck[i].isSelected());
            chanOver[i].setVal(audioOverCheck[i].isSelected());
            
            if(i%2 == 0){
                pairPhase[i/2].setVal(phaseCheck[i/2].isSelected());
                pairCarrier[i/2].setVal(carrierLossCheck[i/2].isSelected());
            }
        }
    }
    
    public void setAdReference(int ref) {
        adReference = ref;
        updateLossThresholdDigitalLabel();
        updateOverThresholdDigitalLabel();
    }
    
    private void updateLossThresholdDigitalLabel() {
        int digitalThresh = lossThresholdSlider.getValue() + adReference;
        lossThresholdUnitsLabel.setText("dB  (" + Integer.toString(digitalThresh) + "dBfs" + ")");
    }

    private void updateOverThresholdDigitalLabel() {
        int digitalThresh = overThresholdSlider.getValue() + adReference;
        overThresholdUnitsLabel.setText("dB  (" + Integer.toString(digitalThresh) + "dBfs" + ")");
    }

    public void setEnableAlarmsLabel(final String s) {
        enableAlarmsLabel.setText(s);
    }
}
