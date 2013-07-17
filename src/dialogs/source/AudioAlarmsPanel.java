

package dialogs.source;

import bean.AnalogueThreshold;
import bean.AudioAlarmSettings;
import bean.Chan;
import bean.DigitalThreshold;
import bean.Pair;
import bean.Source;
import bean.Threshold;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;


public class AudioAlarmsPanel extends JPanelBGGradient{
        private static final String AC_AUDIO_LOSS = "AudioLoss";
        private static final String AC_AUDIO_OVER = "AudioOver";
        private static final String AC_PHASE = "Phase";
        private static final String AC_CARRIER_LOSS = "CarrierLoss";
        
        private Source bean;
        
        private JLabel lossThresholdLabel;
        private JLabel lossAnalogueLabel;
        private JComboBox lossAnalogueCombo;
        private JLabel lossDigitalLabel;
        private JComboBox lossDigitalCombo;
                
        private JLabel overThresholdLabel;
        private JLabel overAnalogueLabel;
        private JComboBox overAnalogueCombo;
        private JLabel overDigitalLabel;
        private JComboBox overDigitalCombo;
            
        private JLabel antiphaseThresholdLabel;
        private JComboBox antiphaseThresholdCombo;
        
        private JLabel enableAlarmsLabel;
        
        
        private JLabel audioLossLabel;
        private JLabel audioOverLabel;
        private JLabel phaseLabel;
        private JLabel carrierLossLabel;
        
        private JCheckBox[] audioLossCheck;
        private JCheckBox[] audioOverCheck;
        private JCheckBox[] phaseCheck;
        private JCheckBox[] carrierLossCheck;
        
        private JButton allAudioLossButton;
        private JButton allAudioOverButton;
        private JButton allPhaseButton;
        private JButton allCarrierLossButton;
        
                
   
        
    private class AudioAlarmsPanelActionListener implements ActionListener {
        private boolean allAudioLoss;
        private boolean allAudioOver;
        private boolean allPhase;
        private boolean allCarrierLoss;
        
        public void actionPerformed(ActionEvent ae)
        {
            if (ae.getActionCommand().equals(AC_AUDIO_LOSS)) {
                for (int i = 0; i < 16; i++) {
                    audioLossCheck[i].setSelected(allAudioLoss);
                }
                allAudioLoss = !allAudioLoss;
            } else if (ae.getActionCommand().equals(AC_AUDIO_OVER)) {
                for (int i = 0; i < 16; i++) {
                    audioOverCheck[i].setSelected(allAudioOver);
                }
                allAudioOver = !allAudioOver;
            } else if (ae.getActionCommand().equals(AC_PHASE)) {
                for (int i = 0; i < 8; i++) {
                    phaseCheck[i].setSelected(allPhase);
                }
                allPhase = !allPhase;
            } else if (ae.getActionCommand().equals(AC_CARRIER_LOSS)) {
                for (int i = 0; i < 8; i++) {
                    carrierLossCheck[i].setSelected(allCarrierLoss);
                }
                allCarrierLoss = !allCarrierLoss;
            }
        }

        AudioAlarmsPanelActionListener() {
            allAudioLoss = true;
            allAudioOver = true;
            allPhase = true;
            allCarrierLoss = true;
        }
    }
    
    public AudioAlarmsPanel(Source bean) {
        //setto dimensione panel
        setLayout(null);
        setBounds(1, 30, 430, 460);
        
        //setto action e item listeners;
        AudioAlarmsPanelActionListener audioPanelActionListener = new AudioAlarmsPanelActionListener();
          
        //associo bean e creo riferimenti a oggetti bean
        this.bean = bean;
        AudioAlarmSettings audioAlarmSettings = bean.getAudioAlarmSettings();
        AnalogueThreshold lossAnlgThreshold =  audioAlarmSettings.getAudioLossAlarm().getAnalogueThreshold();
        DigitalThreshold lossDigThreshold = audioAlarmSettings.getAudioLossAlarm().getDigitalThreshold();
        AnalogueThreshold overAnlgThreshold =  audioAlarmSettings.getAudioOverAlarm().getAnalogueThreshold();
        DigitalThreshold overDigThreshold = audioAlarmSettings.getAudioOverAlarm().getDigitalThreshold();
        Threshold phaseThreshold = audioAlarmSettings.getPhaseAlarm().getThreshold();
        Chan[] chanLoss = audioAlarmSettings.getAudioLossAlarm().getChan();
        Chan[] chanOver = audioAlarmSettings.getAudioOverAlarm().getChan();
        Pair[] pairPhase = audioAlarmSettings.getPhaseAlarm().getPair();
        Pair[] pairCarrier = audioAlarmSettings.getCarrierLossAlarm().getPair();
        //logica implementativa di condizioni del menu
       
        
        //oggetti interfaccia utente
        lossThresholdLabel = new JLabel("Audio Loss Threshold");
        lossThresholdLabel.setBounds(20,20,130,20);
        add(lossThresholdLabel);
        lossAnalogueLabel = new JLabel("Analogue");
        lossAnalogueLabel.setBounds(165,20,55,20);
        add(lossAnalogueLabel);
        lossAnalogueCombo = this.createComboThreshold(lossAnlgThreshold.getVal(), lossAnlgThreshold.getMin(), lossAnlgThreshold.getMax(), "dB");
        lossAnalogueCombo.setBounds(225, 20, 70, 20);
        add(lossAnalogueCombo);
        lossDigitalLabel = new JLabel("Digital");
        lossDigitalLabel.setBounds(315,20,40,20);
        add(lossDigitalLabel);
        lossDigitalCombo = this.createComboThreshold(lossDigThreshold.getVal(), lossDigThreshold.getMin(), lossDigThreshold.getMax(), "dBfs");
        lossDigitalCombo.setBounds(357, 20, 80, 20);
        add(lossDigitalCombo);
        
        overThresholdLabel = new JLabel("Audio Over Threshold");
        overThresholdLabel.setBounds(20,50,130,20);
        add(overThresholdLabel);
        overAnalogueLabel = new JLabel("Analogue");
        overAnalogueLabel.setBounds(165,50,55,20);
        add(overAnalogueLabel);
        overAnalogueCombo = this.createComboThreshold(overAnlgThreshold.getVal(), overAnlgThreshold.getMin(), overAnlgThreshold.getMax(), "dB");
        overAnalogueCombo.setBounds(225, 50, 70, 20);
        add(overAnalogueCombo);
        overDigitalLabel = new JLabel("Digital");
        overDigitalLabel.setBounds(315,50,40,20);
        add(overDigitalLabel);
        overDigitalCombo = this.createComboThreshold(overDigThreshold.getVal(), overDigThreshold.getMin(), overDigThreshold.getMax(), "dBfs");
        overDigitalCombo.setBounds(357, 50, 80, 20);
        add(overDigitalCombo);
        
        antiphaseThresholdLabel = new JLabel("Antiphase Threshold");
        antiphaseThresholdLabel.setBounds(100,80,120,20);
        add(antiphaseThresholdLabel);
        antiphaseThresholdCombo = this.createComboThreshold(phaseThreshold.getVal(), phaseThreshold.getMin(), phaseThreshold.getMax(), "");
        antiphaseThresholdCombo.setBounds(225,80,70,20);
        add(antiphaseThresholdCombo);
        
        enableAlarmsLabel = new JLabel("Enable Alarms");
        enableAlarmsLabel.setFont(new Font("Arial",Font.BOLD,12));
        enableAlarmsLabel.setBounds(200,120,100,20);
        add(enableAlarmsLabel);
       
        audioLossLabel = new JLabel("Audio Loss");
        audioLossLabel.setBounds(100,145,80,20);
        audioLossLabel.setHorizontalAlignment(JLabel.CENTER);
        add(audioLossLabel);
        audioOverLabel = new JLabel("Audio Over");
        audioOverLabel.setBounds(170,145,80,20);
        audioOverLabel.setHorizontalAlignment(JLabel.CENTER);
        add(audioOverLabel);
        phaseLabel = new JLabel("Phase");
        phaseLabel.setBounds(240,145,80,20);
        phaseLabel.setHorizontalAlignment(JLabel.CENTER);
        add(phaseLabel);
        carrierLossLabel = new JLabel("Carrier Loss");
        carrierLossLabel.setBounds(310,145,80,20);
        carrierLossLabel.setHorizontalAlignment(JLabel.CENTER);
        add(carrierLossLabel);
        
        int y = 165;
        //ciclo per i canali mosconi
        audioLossCheck = new JCheckBox[16];
        audioOverCheck = new JCheckBox[16];
        phaseCheck = new JCheckBox[8];
        carrierLossCheck = new JCheckBox[8];
        
        for (int i=0; i<16; i++){
            JLabel label = new JLabel("Channel "+Integer.toString(i+1));
            label.setBounds(30,y,80,17);
            add(label);
            
            audioLossCheck[i] = new JCheckBoxTransBG();
            audioLossCheck[i].setBounds(125,y,17,17);
            audioLossCheck[i].setSelected(chanLoss[i].getVal());
            add(audioLossCheck[i]);
            
            audioOverCheck[i] = new JCheckBoxTransBG();
            audioOverCheck[i].setBounds(195,y,17,17);
            audioOverCheck[i].setSelected(chanOver[i].getVal());
            add(audioOverCheck[i]);
            
            if(i%2 == 0){
                phaseCheck[i/2] = new JCheckBoxTransBG();
                phaseCheck[i/2].setBounds(265,y+8,17,17);
                phaseCheck[i/2].setSelected(pairPhase[i/2].getVal());
                add(phaseCheck[i/2]);
                
                carrierLossCheck[i/2] = new JCheckBoxTransBG();
                carrierLossCheck[i/2].setBounds(335,y+8,17,17);
                carrierLossCheck[i/2].setSelected(pairCarrier[i/2].getVal());
                add(carrierLossCheck[i/2]);
            }
            
            y+=17;
        }
        
        allAudioLossButton = new JButton("All");
        allAudioLossButton.setBounds(110,440,50,20);
        allAudioLossButton.setActionCommand(AC_AUDIO_LOSS);
        allAudioLossButton.addActionListener(audioPanelActionListener);
        add(allAudioLossButton);
        
        allAudioOverButton = new JButton("All");
        allAudioOverButton.setBounds(180,440,50,20);
        allAudioOverButton.setActionCommand(AC_AUDIO_OVER);
        allAudioOverButton.addActionListener(audioPanelActionListener);
        add(allAudioOverButton);
        
        allPhaseButton = new JButton("All");
        allPhaseButton.setBounds(250,440,50,20);
        allPhaseButton.setActionCommand(AC_PHASE);
        allPhaseButton.addActionListener(audioPanelActionListener);
        add(allPhaseButton);
        
        allCarrierLossButton = new JButton("All");
        allCarrierLossButton.setBounds(320,440,50,20);
        allCarrierLossButton.setActionCommand(AC_CARRIER_LOSS);
        allCarrierLossButton.addActionListener(audioPanelActionListener);
        add(allCarrierLossButton);
        
    }
    
    public void save() {
        save(null);
    }
    
    public void save(Source bean) {
        if (bean==null)
            bean = this.bean;
        
        AudioAlarmSettings audioAlarmSettings = bean.getAudioAlarmSettings();
        AnalogueThreshold lossAnlgThreshold =  audioAlarmSettings.getAudioLossAlarm().getAnalogueThreshold();
        DigitalThreshold lossDigThreshold = audioAlarmSettings.getAudioLossAlarm().getDigitalThreshold();
        AnalogueThreshold overAnlgThreshold =  audioAlarmSettings.getAudioOverAlarm().getAnalogueThreshold();
        DigitalThreshold overDigThreshold = audioAlarmSettings.getAudioOverAlarm().getDigitalThreshold();
        Threshold phaseThreshold = audioAlarmSettings.getPhaseAlarm().getThreshold();
        Chan[] chanLoss = audioAlarmSettings.getAudioLossAlarm().getChan();
        Chan[] chanOver = audioAlarmSettings.getAudioOverAlarm().getChan();
        Pair[] pairPhase = audioAlarmSettings.getPhaseAlarm().getPair();
        Pair[] pairCarrier = audioAlarmSettings.getCarrierLossAlarm().getPair();
        //logica implementativa di condizioni del menu
       
        
        //oggetti interfaccia utente
        lossAnlgThreshold.setVal(lossAnlgThreshold.getMin() + lossAnalogueCombo.getSelectedIndex());
        lossDigThreshold.setVal(lossDigThreshold.getMin() + lossDigitalCombo.getSelectedIndex());
        overAnlgThreshold.setVal(overAnlgThreshold.getMin() + overAnalogueCombo.getSelectedIndex());
        overDigThreshold.setVal(overDigThreshold.getMin() + overDigitalCombo.getSelectedIndex());
        phaseThreshold.setVal(phaseThreshold.getMin() + antiphaseThresholdCombo.getSelectedIndex());
        
        //ciclo per i canali mosconi
        for (int i=0; i<16; i++){
            chanLoss[i].setVal(audioLossCheck[i].isSelected());
            chanOver[i].setVal(audioOverCheck[i].isSelected());
            
            if(i%2 == 0){
                pairPhase[i/2].setVal(phaseCheck[i/2].isSelected());
                pairCarrier[i/2].setVal(carrierLossCheck[i/2].isSelected());
            }
        }
    }
    
    
   
    
   
    
    private JComboBox createComboThreshold(int value, int min, int max, String label){
        
        JComboBox comboBocs;
        Vector listaElementi = new Vector();        
        for (int i = min; i <= max; i++){
            listaElementi.addElement(Integer.toString(i)+" "+label);
        }
        comboBocs = new JComboBox(listaElementi);
        comboBocs.setSelectedItem(Integer.toString(value)+" "+label);
        return comboBocs;
    }
            
}
