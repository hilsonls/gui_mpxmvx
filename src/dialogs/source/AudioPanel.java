

package dialogs.source;

import bean.AudioInput;
import bean.AudioPhase;
import bean.EmbeddedInput;
import bean.EmbeddedPhase;
import bean.NgmInput;
import bean.NgmPhase;
import bean.Source;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.JSliderPanel;
import gui.style.StyleInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class AudioPanel extends JPanelBGGradient{
        private Source bean;
        
        private JLabel audioModeLabel;
        private ButtonGroup audioModeButtonGroup;
        private JRadioButton embeddedRadio;
        private JRadioButton externalRadio;
        private JRadioButton ngmRadio;
        
        private JComboBox ngmServersCombo;
        
        private JLabel [] channelLabel;
        private JComboBox [] channelCombo;
        private JComboBox [] channelComboEmbedded;
        private JComboBox [] channelComboNgm;
        
        private JCheckBox phaseBarCheck1;
        private JComboBox phaseBarCombo1;
        private JComboBox phaseBarComboEmbedded1;
        private JComboBox phaseBarComboNgm1;
        
        
        private JCheckBox phaseBarCheck2;
        private JComboBox phaseBarCombo2;
        private JComboBox phaseBarComboEmbedded2;
        private JComboBox phaseBarComboNgm2;
        private JButton resetButton;
        
        private JLabel adReferenceLabel;
        private JSliderPanel adReferenceSlider;
        private JLabel dbfsLabel;
        
        private JLabel zeroDBReferenceLabel;
        private JSliderPanel zeroDBReferenceSlider;
        private JLabel dbLabel;
        
    class AudioPanelItemListener
        implements ItemListener
    {

        public void itemStateChanged(ItemEvent itemevent)
        {
            Object obj = itemevent.getSource();
            if(itemevent.getStateChange()==ItemEvent.SELECTED){
                if(obj == embeddedRadio){
                    try
                    {
                    setChannels(true,false,bean.getEmbeddedAvail().getVal());
                    ngmServersCombo.setEnabled(false);
                    }
                    catch(Exception exception) { }
                }
                else if(obj == ngmRadio){
                    try
                    {
                    setChannels(false,true,bean.getEmbeddedAvail().getVal());
                    ngmServersCombo.setEnabled(true);
                    }
                    catch(Exception exception) { }
                }
                else {
                    try
                    {
                    setChannels(false,false,bean.getEmbeddedAvail().getVal());
                    ngmServersCombo.setEnabled(false);
                    }
                    catch(Exception exception) { }
                }
            }   
        }

        AudioPanelItemListener()
        {
        }
    }
        
    class AudioPanelActionListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            Object obj = actionevent.getSource();
            if(obj == resetButton)
                resetAction();
  
        }

        AudioPanelActionListener()
        {
        }
    }
    
    public AudioPanel(Source bean) throws MVException {
        //setto dimensione panel
        setLayout(null);
        setBounds(1, 30, 430, 400);
        
        //setto action e item listeners;
        AudioPanelActionListener audioPanelActionListener = new AudioPanelActionListener();
        AudioPanelItemListener audioPanelItemListener = new AudioPanelItemListener();
        
        //associo bean e creo riferimenti a oggetti bean
        this.bean = bean;
        AudioInput [] audioInput = bean.getAudioInput();
        EmbeddedInput [] embeddedInput = null;
        NgmInput[] ngmInput = bean.getNgmInput();
        AudioPhase [] audioPhase = bean.getAudioPhase();
        EmbeddedPhase [] embeddedPhase = null;
        NgmPhase[] ngmPhase = bean.getNgmPhase();
        
        //logica implementativa di condizioni del menu
        //capisco se embedded è premuto;
        boolean embedded = bean.getEmbedded().getVal();
        boolean ngmEmbedded = bean.getNgm().getVal();
        boolean embeddedEnabled = bean.getEmbeddedAvail().getVal();
        
        if(embeddedEnabled){
            embeddedInput = bean.getSourceSequence().getEmbeddedInput();
            embeddedPhase = bean.getSourceSequence().getEmbeddedPhase();
        }
        
        
        
        if(embeddedEnabled){
            channelComboEmbedded = new JComboBox[16];

        }
        //oggetti interfaccia utente
        
        audioModeLabel = new JLabel("AudioMode");
        audioModeLabel.setBounds(15, 5, 100, 20);
        add(audioModeLabel);
        embeddedRadio = new JRadioButton();
        embeddedRadio.setOpaque(false);
        embeddedRadio.setText("Embedded");
        embeddedRadio.setBounds(15, 25, 100, 20);
        embeddedRadio.addItemListener(audioPanelItemListener);
        add(embeddedRadio);
        externalRadio = new JRadioButton();
        externalRadio.setOpaque(false);
        externalRadio.setText("External");
        externalRadio.setBounds(155, 25, 100, 20);
        externalRadio.addItemListener(audioPanelItemListener);
        add(externalRadio);
        ngmRadio = new JRadioButton();
        ngmRadio.setOpaque(false);
        ngmRadio.setText(StyleInterface.getInstance().getDataXXNgm());
        ngmRadio.setBounds(295, 25, 100, 20);
        ngmRadio.addItemListener(audioPanelItemListener);
        add(ngmRadio);
        audioModeButtonGroup = new ButtonGroup();
        audioModeButtonGroup.add(embeddedRadio);
        audioModeButtonGroup.add(externalRadio);
        audioModeButtonGroup.add(ngmRadio);
        
        ngmServersCombo = ComponentFactory.createComboBox(bean.getNgmName().getOptionsName(), bean.getNgmName().getVal(), false);
        ngmServersCombo.setBounds(275, 45, 135, 20);
        ngmServersCombo.setEnabled(false);
        add(ngmServersCombo);
        
        if(bean.getEmbeddedAvail().getVal()==false){
            embeddedRadio.setEnabled(false);
        }
        
        if(bean.getEmbedded().getVal()==true){
            embeddedRadio.setSelected(true);
        }
        else if(bean.getNgm().getVal()==true){
            ngmRadio.setSelected(true);
            ngmServersCombo.setEnabled(true);
        }
        else{
            externalRadio.setSelected(true);
        }
        
        
        
        channelLabel = new JLabel[16];
        channelCombo = new JComboBox[16];
        channelComboNgm = new  JComboBox[16];
        
        int x = 15; int y = 80; int width = 70; int height = 20;
        
        //for dei canali
        for(int i=0; i<8; i++){
            channelLabel[i*2] = new JLabel();
            channelLabel[i*2].setText("Channel "+(i*2+1));
            channelLabel[i*2].setBounds(x, y, width, height);
            add(channelLabel[i*2]);
            
            x+= 70;
               
            channelCombo[i*2] = ComponentFactory.createComboBox(audioInput[i*2].getOptionsName(), audioInput[i*2].getVal());  
            channelCombo[i*2].setBounds(x, y, width, height);
            add(channelCombo[i*2]);
            channelComboNgm[i*2] = ComponentFactory.createComboBox(ngmInput[i*2].getOptionsName(), ngmInput[i*2].getVal());  
            channelComboNgm[i*2].setBounds(x, y, width, height);
            add(channelComboNgm[i*2]);
            if(embeddedEnabled){
                channelComboEmbedded[i*2] = ComponentFactory.createComboBox(embeddedInput[i*2].getOptionsName(), embeddedInput[i*2].getVal());  
                channelComboEmbedded[i*2].setBounds(x, y, width+50, height);
                add(channelComboEmbedded[i*2]);
            }    
                //visualizza il combobox corretto (se embedded, ngm o external)
                if(embedded){
                    if(embeddedEnabled)
                    channelComboEmbedded[i*2].setVisible(true);
                    channelComboNgm[i*2].setVisible(false);
                    channelCombo[i*2].setVisible(false);
                    }
                else if(ngmEmbedded){
                    if(embeddedEnabled)
                    channelComboEmbedded[i*2].setVisible(false);
                    channelComboNgm[i*2].setVisible(true);
                    channelCombo[i*2].setVisible(false);
                }
                else {
                    if(embeddedEnabled)
                    channelComboEmbedded[i*2].setVisible(false);
                    channelComboNgm[i*2].setVisible(false);
                    channelCombo[i*2].setVisible(true);
                }
            
            
            
            x+= 130;
            
            channelLabel[i*2+1] = new JLabel();
            channelLabel[i*2+1].setText("Channel "+(i*2+2));
            channelLabel[i*2+1].setBounds(x, y, width, height);
            add(channelLabel[i*2+1]);
            
            x+= 70;
            
            channelCombo[i*2+1] = ComponentFactory.createComboBox(audioInput[i*2+1].getOptionsName(), audioInput[i*2+1].getVal());  
            channelCombo[i*2+1].setBounds(x, y, width, height);
            add(channelCombo[i*2+1]);
            channelComboNgm[i*2+1] = ComponentFactory.createComboBox(ngmInput[i*2+1].getOptionsName(), ngmInput[i*2+1].getVal());  
            channelComboNgm[i*2+1].setBounds(x, y, width, height);
            add(channelComboNgm[i*2+1]);
            if(embeddedEnabled){
                channelComboEmbedded[i*2+1] = ComponentFactory.createComboBox(embeddedInput[i*2+1].getOptionsName(), embeddedInput[i*2+1].getVal());  
                channelComboEmbedded[i*2+1].setBounds(x, y, width+50, height);
                add(channelComboEmbedded[i*2+1]);
            }    
                //visualizza il combobox corretto (se embedded, ngm o external)
                if(embedded){
                    if(embeddedEnabled)
                    channelComboEmbedded[i*2+1].setVisible(true);
                    channelComboNgm[i*2+1].setVisible(false);
                    channelCombo[i*2+1].setVisible(false);
                    }
                else if(ngmEmbedded){
                    if(embeddedEnabled)
                    channelComboEmbedded[i*2+1].setVisible(false);
                    channelComboNgm[i*2+1].setVisible(true);
                    channelCombo[i*2+1].setVisible(false);
                }
                else {
                    if(embeddedEnabled)
                    channelComboEmbedded[i*2+1].setVisible(false);
                    channelComboNgm[i*2+1].setVisible(false);
                    channelCombo[i*2+1].setVisible(true);
                }
            
            
            x= 15;
            y+= 30;
            
        }
        
        
        y+=15;
        phaseBarCheck1 = new JCheckBoxTransBG();
        phaseBarCheck1.setText("Phase bar 1");
        phaseBarCheck1.setBounds(x,y,100,height);
        phaseBarCheck1.setSelected(bean.getShowPhase()[0].getVal());
        add(phaseBarCheck1);
        x+=100;
        phaseBarCombo1 = ComponentFactory.createComboBox(audioPhase[0].getOptionsName(),audioPhase[0].getVal());  
        phaseBarCombo1.setBounds(x,y,width,height);
        add(phaseBarCombo1);
        phaseBarComboNgm1 = ComponentFactory.createComboBox(ngmPhase[0].getOptionsName(),ngmPhase[0].getVal());
        phaseBarComboNgm1.setBounds(x,y,width,height);
        add(phaseBarComboNgm1);
        if(embeddedEnabled){
            phaseBarComboEmbedded1 = ComponentFactory.createComboBox(embeddedPhase[0].getOptionsName(),embeddedPhase[0].getVal());
            phaseBarComboEmbedded1.setBounds(x,y,width+70,height);
            add(phaseBarComboEmbedded1);
        }
            //visualizza il combobox corretto (se embedded, ngm o external)
                if(embedded){
                    if(embeddedEnabled)
                    phaseBarComboEmbedded1.setVisible(true);
                    phaseBarComboNgm1.setVisible(false);
                    phaseBarCombo1.setVisible(false);
                    }
                else if(ngmEmbedded){
                    if(embeddedEnabled)
                    phaseBarComboEmbedded1.setVisible(false);
                    phaseBarComboNgm1.setVisible(true);
                    phaseBarCombo1.setVisible(false);
                }
                else {
                    if(embeddedEnabled)
                    phaseBarComboEmbedded1.setVisible(false);
                    phaseBarComboNgm1.setVisible(false);
                    phaseBarCombo1.setVisible(true);
                }
            
        
        x+=160;
//        embeddedCheck = new JCheckBoxTransBG();
//        embeddedCheck.setText("Embedded");
//        embeddedCheck.setBounds(x,y,100,height);
         //TODO: verificare se embedded viene automaticamente passata deselezionato nel caso sia disabilitato
//        embeddedCheck.setEnabled(bean.getEmbeddedAvail().getVal());
//        embeddedCheck.setSelected(bean.getEmbedded().getVal());
//        embeddedCheck.addItemListener(audioPanelItemListener);
//        add(embeddedCheck);
        
        x=15;
        y+=30;
        phaseBarCheck2 = new JCheckBoxTransBG();
        phaseBarCheck2.setText("Phase bar 2");
        phaseBarCheck2.setBounds(x,y,100,height);
        phaseBarCheck2.setSelected(bean.getShowPhase()[1].getVal());
        add(phaseBarCheck2);
        x+=100;
        phaseBarCombo2 = ComponentFactory.createComboBox(audioPhase[1].getOptionsName(), audioPhase[1].getVal());  
        phaseBarCombo2.setBounds(x,y,width,height);
        add(phaseBarCombo2);
        phaseBarComboNgm2 = ComponentFactory.createComboBox(ngmPhase[1].getOptionsName(),ngmPhase[1].getVal());
        phaseBarComboNgm2.setBounds(x,y,width,height);
        add(phaseBarComboNgm2);
        if(embeddedEnabled){
            phaseBarComboEmbedded2 = ComponentFactory.createComboBox(embeddedPhase[1].getOptionsName(),embeddedPhase[1].getVal());
            phaseBarComboEmbedded2.setBounds(x,y,width+70,height);
            add(phaseBarComboEmbedded2);
        }
            //visualizza il combobox corretto (se embedded, ngm o external)
                if(embedded){
                    if(embeddedEnabled)
                    phaseBarComboEmbedded2.setVisible(true);
                    phaseBarComboNgm2.setVisible(false);
                    phaseBarCombo2.setVisible(false);
                    }
                else if(ngmEmbedded){
                    if(embeddedEnabled)
                    phaseBarComboEmbedded2.setVisible(false);
                    phaseBarComboNgm2.setVisible(true);
                    phaseBarCombo2.setVisible(false);
                }
                else {
                    if(embeddedEnabled)
                    phaseBarComboEmbedded2.setVisible(false);
                    phaseBarComboNgm2.setVisible(false);
                    phaseBarCombo2.setVisible(true);
                }
        
        x+=160;
        resetButton = new JButton();
        resetButton.setText("Reset");
        resetButton.setBounds(x,y, 80, height);
        resetButton.addActionListener(audioPanelActionListener);
        add(resetButton);
        
        x=15;
        y+=45;
        adReferenceLabel = new JLabel("A/D Reference");
        adReferenceLabel.setBounds(x,y,100,height);
        add(adReferenceLabel);
        x+=110;
        adReferenceSlider = new JSliderPanel(bean.getAudioDigitalRef().getMin(), bean.getAudioDigitalRef().getMax(), bean.getAudioDigitalRef().getVal());
        adReferenceSlider.setBounds(x,y,190,height);
        add(adReferenceSlider);
        x+=200;
        dbfsLabel = new JLabel("dBfs");
        dbfsLabel.setBounds(x, y, 50, height);
        add(dbfsLabel);
        
        x=15;
        y+=30;
        zeroDBReferenceLabel = new JLabel("0dB Reference");
        zeroDBReferenceLabel.setBounds(x,y,100,height);
        add(zeroDBReferenceLabel);
        x+=110;
        zeroDBReferenceSlider = new JSliderPanel(bean.getAudio0dBRef().getMin(), bean.getAudio0dBRef().getMax(), bean.getAudio0dBRef().getVal());
        zeroDBReferenceSlider.setBounds(x,y,190,height);
        add(zeroDBReferenceSlider);
        x+=200;
        dbLabel = new JLabel("dBu");
        dbLabel.setBounds(x, y, 50, height);
        add(dbLabel);
       
    }
    
    public void save() {
        save(null);
    }
    
    public void save(Source bean) {
        if (bean==null)
            bean = this.bean;
        
        if(ngmServersCombo.getSelectedItem()!=null)
            bean.getNgmName().setVal(ngmServersCombo.getSelectedItem().toString());
        
        
        boolean embAval = false;
        if(bean.getEmbeddedAvail().getVal()==true)
            embAval = true;
        
            //if(embeddedCheck.isEnabled()){
                //for dei canali
             if(embAval)
                for(int i=0; i<bean.getSourceSequence().getEmbeddedInputCount(); i++){
                    bean.getSourceSequence().getEmbeddedInput(i).setVal(channelComboEmbedded[i].getSelectedItem().toString());
                    
                }
        
             for(int j=0; j<bean.getNgmInputCount(); j++){
                 bean.getNgmInput(j).setVal(channelComboNgm[j].getSelectedItem().toString());
             }
        
             if(embAval){
                bean.getSourceSequence().getEmbeddedPhase(0).setVal(phaseBarComboEmbedded1.getSelectedItem().toString());
                bean.getSourceSequence().getEmbeddedPhase(1).setVal(phaseBarComboEmbedded2.getSelectedItem().toString());
             }
                bean.getNgmPhase(0).setVal(phaseBarComboNgm1.getSelectedItem().toString());
                bean.getNgmPhase(1).setVal(phaseBarComboNgm2.getSelectedItem().toString());
        
            //}
        
        //for dei canali
        for(int i=0; i<bean.getAudioInputCount(); i++){
            bean.getAudioInput(i).setVal(channelCombo[i].getSelectedItem().toString());
        }
        bean.getAudioPhase(0).setVal(phaseBarCombo1.getSelectedItem().toString());
        bean.getAudioPhase(1).setVal(phaseBarCombo2.getSelectedItem().toString());
        
        bean.getShowPhase(0).setVal(phaseBarCheck1.isSelected());
        bean.getShowPhase(1).setVal(phaseBarCheck2.isSelected());
        
        if(bean.getEmbeddedAvail().getVal()==true){
            bean.getEmbedded().setVal(embeddedRadio.isSelected());
        }
            bean.getNgm().setVal(ngmRadio.isSelected());
        
        
        bean.getAudioDigitalRef().setVal(adReferenceSlider.getValue());
        bean.getAudio0dBRef().setVal(zeroDBReferenceSlider.getValue());
        
        
    }
    
    
    private void setChannels(boolean embedded, boolean ngmEmbedded, boolean embAval){
        
                
        //for dei canali
        for(int i=0; i<16; i++){          
            if(embedded){
                channelCombo[i].setVisible(false);
                if(embAval)
                channelComboEmbedded[i].setVisible(true);
                channelComboNgm[i].setVisible(false);
            }
            else if(ngmEmbedded){
                channelCombo[i].setVisible(false);
                if(embAval)
                channelComboEmbedded[i].setVisible(false);
                channelComboNgm[i].setVisible(true);
            }
            else{
                channelCombo[i].setVisible(true);
                if(embAval)
                channelComboEmbedded[i].setVisible(false);
                channelComboNgm[i].setVisible(false);
            }
        }
        if(embedded){
            phaseBarCombo1.setVisible(false);
            if(embAval)
            phaseBarComboEmbedded1.setVisible(true);
            phaseBarComboNgm1.setVisible(false);
            phaseBarCombo2.setVisible(false);
            if(embAval)
            phaseBarComboEmbedded2.setVisible(true);
            phaseBarComboNgm2.setVisible(false);
        }
        else if(ngmEmbedded){
            phaseBarCombo1.setVisible(false);
            if(embAval)
            phaseBarComboEmbedded1.setVisible(false);
            phaseBarComboNgm1.setVisible(true);
            phaseBarCombo2.setVisible(false);
            if(embAval)
            phaseBarComboEmbedded2.setVisible(false);
            phaseBarComboNgm2.setVisible(true);
        
        }
        else{
            phaseBarCombo1.setVisible(true);
            if(embAval)
            phaseBarComboEmbedded1.setVisible(false);
            phaseBarComboNgm1.setVisible(false);
            phaseBarCombo2.setVisible(true);
            if(embAval)
            phaseBarComboEmbedded2.setVisible(false);
            phaseBarComboNgm2.setVisible(false);
        }
    }
    
    private void resetAction(){
        
        for(int i = 0; i < 16; i++)
            {
                if(embeddedRadio.isSelected()){
                    channelComboEmbedded[i].setSelectedIndex(0);
                    channelComboEmbedded[i].repaint();
                }
                if(ngmRadio.isSelected()){
                    channelComboNgm[i].setSelectedIndex(0);
                    channelComboNgm[i].repaint();
                }
                else{
                    channelCombo[i].setSelectedIndex(0);
                    channelCombo[i].repaint();
                }
            }

       phaseBarCheck1.setSelected(false);
       phaseBarCheck2.setSelected(false);
       if(embeddedRadio.isSelected()){
            phaseBarComboEmbedded1.setSelectedIndex(0);
            phaseBarComboEmbedded1.repaint();
            phaseBarComboEmbedded2.setSelectedIndex(0);
            phaseBarComboEmbedded2.repaint();           
       }
       else if(ngmRadio.isSelected()){
            phaseBarComboNgm1.setSelectedIndex(0);
            phaseBarComboNgm1.repaint();
            phaseBarComboNgm2.setSelectedIndex(0);
            phaseBarComboNgm2.repaint();
       }
       else{
            phaseBarCombo1.setSelectedIndex(0);
            phaseBarCombo1.repaint();
            phaseBarCombo2.setSelectedIndex(0);
            phaseBarCombo2.repaint();
       }
    }
}
