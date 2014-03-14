package dialogs.source;

import bean.Source;
import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.TilesWorkspace;
import gui.components.ChangeListenerColorHandled;
import gui.components.JDioTabbedPane;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author dio
 */
public class SourcePropertiesDialog extends JDialog {
    
    
    private Source bean;
    
    private JTabbedPane tabbedPane;
        
    private AudioPanel audioPanel;
    private AlarmPanel alarmPanel;
    private CopySourcePanel copySourcePanel;
    
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;

    //idModulo per sapere di quale modulo fa parte l'oggetto in questione
    private int idModulo;
    
    private class ButtonActionListener implements ActionListener
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            if(actionevent.getActionCommand().equals("copySources")){
                copySources();
            }
            Object obj = actionevent.getSource();
            if(obj == okButton)
                okAction();
            else
            
            if(obj == cancelButton)
                cancelAction();
           
        }
    }
    
    public SourcePropertiesDialog(Frame frame, Source bean, int idModulo) throws MVException {
        super(frame);

        
        this.bean = bean;
        this.idModulo = idModulo;
        
        ButtonActionListener buttonActionListener = new ButtonActionListener();
        
        setTitle("Source Properties  (ID: "+bean.getId()+" ::: Username: "+bean.getUsername().getVal()+" )");
        setResizable(false);
        setModal(true);
        setDefaultCloseOperation(2);
        setLocation(100, 100);
        setSize(430, 630);
        
        
        buttonsPanel = new JPanelBGGradient(StyleInterface.getInstance().getButtonPanelBackgroundTopColor(), StyleInterface.getInstance().getButtonPanelBackgroundBottomColor(),true);
        buttonsPanel.setLayout(new FlowLayout(1, 10, 10));
        buttonsPanel.setPreferredSize(new Dimension(40, 40));
        okButton = new JButton();
        okButton.setText("OK");
        okButton.setActionCommand("OK");
        okButton.setPreferredSize(new Dimension(100, 25));
        okButton.addActionListener(buttonActionListener);
        this.getRootPane().setDefaultButton(okButton);
        buttonsPanel.add(okButton);
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        cancelButton.setActionCommand("Cancel");
        cancelButton.setPreferredSize(new Dimension(100, 25));
        cancelButton.addActionListener(buttonActionListener);
        buttonsPanel.add(cancelButton);
        getContentPane().add(buttonsPanel, "South");
        
       
        audioPanel = new AudioPanel(bean.getAudio0dBRef(), bean.getAudioDigitalRef(), bean.getAudioAlarmSettings());
        alarmPanel = new AlarmPanel(bean);
        copySourcePanel = new CopySourcePanel(bean, idModulo);
        copySourcePanel.setActionListenerSetupAudioAlarmsButton(buttonActionListener);
        
        tabbedPane = new JDioTabbedPane(true);
        tabbedPane.addChangeListener(new ChangeListenerColorHandled());
        tabbedPane.setBounds(1, 1, 400, 480);
        //Aggiungo i vari panel al tabbedPane
        tabbedPane.add(audioPanel);
        tabbedPane.add(alarmPanel);
        tabbedPane.add(copySourcePanel);
                
        tabbedPane.setSelectedComponent(alarmPanel);
        tabbedPane.setTitleAt(0, "Audio");
        tabbedPane.setTitleAt(1, "Alarm");
        tabbedPane.setTitleAt(2, "Copy");
        
        getContentPane().add(tabbedPane, "Center");
        setVisible(true);
    }

    private void okAction() {
        
        try {
            //AGGIORNO I BEAN dei panels
            audioPanel.save();
            alarmPanel.save();
            copySourcePanel.save();
            
            //UPLOADO IL PORCO XML A H
            
            CtrlProtocol.getInstance().saveSourceToMV(idModulo, bean);

            //query aspectRatio
            int idOggettoAssociato = CtrlWorkspace.getInstance().getIdOggettoBySource(idModulo, bean.getId());
            CtrlWorkspace.getInstance().loadObjectAspectRatio(idModulo, idOggettoAssociato);
            TilesWorkspace tilesWorkspace = CtrlActions.getInstance().getTilesWorkspace();
            tilesWorkspace.loadTilesFromBean();
            tilesWorkspace.applyZOrder();
            tilesWorkspace.requestFocusInWindow();
            tilesWorkspace.repaint();
            dispose();
            
        } catch (MVException ex) {
            //TODO: effettuare l'undo sul bean
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    private void cancelAction(){
        
        dispose();
    
    }
    
    private Source getSourceBean(int i)
    {
        if(i < 0)
            return null;
        else
            return CtrlWorkspace.getInstance().getModule(idModulo).getSources().getSource(i);
    }
    
    private void copySources(){
        int[] selSources = copySourcePanel.getSelectedSources();
        boolean alarmCheck = copySourcePanel.alarmCheck.isSelected();
        boolean audioCheck = copySourcePanel.audioCheck.isSelected();
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.okButton.setEnabled(false);
        this.cancelButton.setEnabled(false);
        for(int i = 0; i < selSources.length; i++){
            Source beanToCopy = getSourceBean(selSources[i]);
            if(alarmCheck) {
                alarmPanel.save(beanToCopy);
            }
            if(audioCheck){
                audioPanel.save(beanToCopy.getAudio0dBRef(), beanToCopy.getAudioDigitalRef(), beanToCopy.getAudioAlarmSettings());
            }
            try {
                if(alarmCheck || audioCheck)
                    CtrlProtocol.getInstance().saveSourceToMV(idModulo, beanToCopy);
            } catch (MVException ex) {
                //TODO: effettuare l'undo sul bean
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                this.okButton.setEnabled(true);
                this.cancelButton.setEnabled(true);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            
        }
        this.okButton.setEnabled(true);
        this.cancelButton.setEnabled(true);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
