

package dialogs.source;

import bean.Audio0dBRef;
import bean.AudioAlarmSettings;
import bean.AudioDigitalRef;
import eccezioni.MVException;
import gui.components.JPanelBGGradient;
import gui.components.JSliderPanel;

import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class AudioPanel extends JPanelBGGradient{
    private Audio0dBRef audio0dBRef;
    private AudioDigitalRef audioDigitalRef;
    private AudioAlarmSettings audioAlarmSettings;
    
    private JLabel adReferenceLabel;
    private JSliderPanel adReferenceSlider;
    private JLabel dbfsLabel;

    private JLabel anlgReferenceLabel;
    private JSliderPanel anlgReferenceSlider;
    private JLabel dbuLabel;

    private AudioAlarmsPanel audioAlarmsPanel;
        
    private class AudioPanelChangeListener implements ChangeListener {
        
        @Override
        public void stateChanged(ChangeEvent e) {
            Object obj = e.getSource();
            if (obj == adReferenceSlider) {
                if (audioAlarmsPanel != null) {
                    audioAlarmsPanel.setAdReference(adReferenceSlider.getValue());
                }
            }
        }
    }
    
    public AudioPanel(Audio0dBRef audio0dBRef, AudioDigitalRef audioDigitalRef, AudioAlarmSettings audioAlarmSettings) throws MVException {
        //setto dimensione panel
        setLayout(null);
        setBounds(1, 30, 430, 400);
        
        //setto action e item listeners;
        AudioPanelChangeListener audioPanelChangeListener = new AudioPanelChangeListener();
        
        //associo bean e creo riferimenti a oggetti bean
        this.audio0dBRef = audio0dBRef;
        this.audioDigitalRef = audioDigitalRef;
        this.audioAlarmSettings = audioAlarmSettings;
        
        //oggetti interfaccia utente
        
        int x = 15; int y = 20; int width = 70; int height = 20;
        
        adReferenceLabel = new JLabel("Digital Audio Reference");
        adReferenceLabel.setBounds(x,y,170,height);
        add(adReferenceLabel);
        x+=180;
        adReferenceSlider = new JSliderPanel(audioDigitalRef.getMin(), audioDigitalRef.getMax(), audioDigitalRef.getVal());
        adReferenceSlider.setBounds(x,y,155,height);
        adReferenceSlider.addChangeListener(audioPanelChangeListener);
        add(adReferenceSlider);
        x+=160;
        dbfsLabel = new JLabel("dBfs");
        dbfsLabel.setBounds(x, y, 50, height);
        add(dbfsLabel);

        x = 15;
        y += 30;
        anlgReferenceLabel = new JLabel("Analogue Audio Reference");
        anlgReferenceLabel.setBounds(x,y,170,height);
        add(anlgReferenceLabel);
        x+=180;
        anlgReferenceSlider = new JSliderPanel(audio0dBRef.getMin(), audio0dBRef.getMax(), audio0dBRef.getVal());
        anlgReferenceSlider.setBounds(x,y,155,height);
        anlgReferenceSlider.addChangeListener(audioPanelChangeListener);
        add(anlgReferenceSlider);
        x+=160;
        dbuLabel = new JLabel("dBu");
        dbuLabel.setBounds(x, y, 50, height);
        add(dbuLabel);

        y += 30;
        audioAlarmsPanel = new AudioAlarmsPanel(audioAlarmSettings);
        audioAlarmsPanel.setBorder(new TitledBorder("Alarms"));
        Rectangle r = audioAlarmsPanel.getBounds();
        r.x = 5;
        r.y = y;
        r.width = 410;
        audioAlarmsPanel.setBounds(r);
        audioAlarmsPanel.setAdReference(adReferenceSlider.getValue());
        add(audioAlarmsPanel);
        y += r.height;
       
    }
    
    public void save() {
        save(null, null, null);
    }
    
    public void save(Audio0dBRef audio0dBRef, AudioDigitalRef audioDigitalRef, AudioAlarmSettings audioAlarmSettings) {
        if (audio0dBRef==null) {
            audio0dBRef = this.audio0dBRef;
        }
        if (audioDigitalRef==null) {
            audioDigitalRef = this.audioDigitalRef;
        }
        if (audioAlarmSettings==null) {
            audioAlarmSettings = this.audioAlarmSettings;
        }
        
        audioDigitalRef.setVal(adReferenceSlider.getValue());
        audio0dBRef.setVal(anlgReferenceSlider.getValue());
        audioAlarmsPanel.save(audioAlarmSettings);
    }
}
