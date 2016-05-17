package dialogs.source;

import bean.Source;
import controllori.CtrlWorkspace;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

/**
 * 
 * @author antonio
 * @version 1.0
 */

public class CopySourcePanel extends JPanelBGGradient{
    
        private Source [] sources;
    
        private Source bean;
        private int idModulo;
        
        private JLabel settingsLabel;
        protected JCheckBox audioCheck;
        protected JCheckBox alarmCheck;
        private JCheckBox overscanCheck;
        
        private JButton selectAllButton;
        private JButton selectNoneButton;
        
        private JButton copyToButton;
        
        
        private JLabel sourcesLabel;
        private JScrollPane sourcePane;
        private JList sourceList;

    public void setActionListenerSetupAudioAlarmsButton(ActionListener buttonActionListener){
        copyToButton.addActionListener(buttonActionListener);
    }

    private class ButtonActionListener implements ActionListener
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            if(actionevent.getActionCommand().equals("selectAll")){
                selectAllSources();
            }
            else if(actionevent.getActionCommand().equals("selectNone")){
                selectNoneSources();
            }
        }

    }
    
        

        
    

    
    public CopySourcePanel(Source bean, int idModulo) {
        //setto dimensione panel
        setLayout(null);
        setBounds(1, 30, 430, 400);
        
        //setto action e item listeners;
        ButtonActionListener buttonActionListener = new ButtonActionListener();
        sourceList = new JList();
            
        //associo bean e creo riferimenti a oggetti bean
        this.bean = bean;
        this.idModulo = idModulo;
        sources = CtrlWorkspace.getInstance().getModule(idModulo).getSources().getSource();
              
        //logica implementativa di condizioni del menu
        int numSource = sources.length;
        
        //oggetti interfaccia utente
        settingsLabel = new JLabel("Settings");
        settingsLabel.setFont(new Font("Arial",Font.BOLD,11));
        settingsLabel.setBounds(30,25,80,20);
        add(settingsLabel);
        
        audioCheck = new JCheckBoxTransBG();
        audioCheck.setText("Audio");
        audioCheck.setBounds(30, 50, 100, 20);
        audioCheck.setSelected(false);
        add(audioCheck);        
        
        alarmCheck = new JCheckBoxTransBG();
        alarmCheck.setText("Alarm");
        alarmCheck.setBounds(30, 80, 100, 20);
        alarmCheck.setSelected(false);
        add(alarmCheck);
        
        if (bean.getOverscanRect() != null) {
            overscanCheck = new JCheckBoxTransBG();
            overscanCheck.setText("Overscan");
            overscanCheck.setBounds(30, 110, 100, 20);
            overscanCheck.setSelected(false);
            add(overscanCheck);
        }
        
        selectAllButton = new JButton("Select All");
        selectAllButton.setActionCommand("selectAll");
        selectAllButton.setBounds(30, 140, 100, 20);
        selectAllButton.addActionListener(buttonActionListener);
        add(selectAllButton);
        
        selectNoneButton = new JButton("Select None");
        selectNoneButton.setActionCommand("selectNone");
        selectNoneButton.setBounds(30, 170, 100, 20);
        selectNoneButton.addActionListener(buttonActionListener);
        add(selectNoneButton);
        
        copyToButton = new JButton("Copy To");
        copyToButton.setActionCommand("copySources");
        copyToButton.setBounds(30, 240, 100, 20);
        add(copyToButton);
        
        sourcesLabel = new JLabel("Sources");
        sourcesLabel.setFont(new Font("Arial",Font.BOLD,11));
        sourcesLabel.setBounds(170,25,80,20);
        add(sourcesLabel);
        
        sourcePane = new JScrollPane();
        sourcePane.setOpaque(true);
        add(sourcePane);
        sourcePane.setBounds(170, 50, 210, 300);
        
        DefaultListModel sourceModel = new DefaultListModel();
        for (int i = 0; i < numSource; i++){
            sourceModel.addElement(new String("["+sources[i].getType().getVal()+"] "+ ((sources[i].getUsername().getVal().equals(""))?"Source "+sources[i].getId():sources[i].getUsername().getVal()+" ("+sources[i].getId()+")")));
        }
        sourceList.setModel(sourceModel);
        sourceList.setSelectedIndex(0);
        sourceList.setBorder((BevelBorder)BorderFactory.createBevelBorder(0));
        sourcePane.getViewport().add(sourceList);
        sourceList.setBounds(0, 0, 210, 300);
       
            
    }
    
    public void save() {
        
       //inutile perchè la copia è effettuata e mandata nel momento in cui è premuto il pulsante copy to
        
    }
   
    
    private void selectAllSources(){
        int ai[] = new int[60];
        for(int i = 0; i < ai.length; i++)
           ai[i] = i;
        this.sourceList.setSelectedIndices(ai);
    }
    
    private void selectNoneSources(){
        this.sourceList.setSelectedIndices(new int[0]);
    }
   
    public int[] getSelectedSources(){
        return this.sourceList.getSelectedIndices();
    }
    
    public boolean isOverscanSelected() {
        if (overscanCheck != null)
            return overscanCheck.isSelected();
        return false;
    }
}
