package dialogs.source;

import bean.AudioSources;
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
public class AudioSourcePropertiesDialog extends JDialog {
    
    private AudioSources bean;
    
    private AudioPanel audioPanel;
    
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;

    //idModulo per sapere di quale modulo fa parte l'oggetto in questione
    private int idModulo;
    
    private class ButtonActionListener implements ActionListener
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            Object obj = actionevent.getSource();
            if(obj == okButton)
                okAction();
            else
            
            if(obj == cancelButton)
                cancelAction();
        }
    }
    
    public AudioSourcePropertiesDialog(Frame frame, int idModulo, AudioSources bean) throws MVException {
        super(frame);
        
        this.bean = bean;
        this.idModulo = idModulo;
        
        ButtonActionListener buttonActionListener = new ButtonActionListener();
        
        setTitle("External Audio Source Properties");
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
        add(audioPanel);
        
        setVisible(true);
    }

    private void okAction() {
        
        try {
            //AGGIORNO I BEAN dei panels
            audioPanel.save();
            
            //UPLOADO IL PORCO XML A H
            
            CtrlProtocol.getInstance().saveAudioSourcesToMv(idModulo, bean);
            
            dispose();

        } catch (MVException ex) {
            //TODO: effettuare l'undo sul bean
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    private void cancelAction(){
        
        dispose();
    
    }
}
