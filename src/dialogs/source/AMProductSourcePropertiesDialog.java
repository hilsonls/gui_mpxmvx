package dialogs.source;

import eccezioni.MVException;
import gui.CtrlActions;
import gui.TilesWorkspace;
import gui.components.ChangeListenerColorHandled;
import gui.components.JDioTabbedPane;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;

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

import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;

import java.awt.event.ActionListener;

import bean.AudioSources;
import bean.Source;

public class AMProductSourcePropertiesDialog extends JDialog {

    private Source vsBean;
    private AudioSources asBean;
    private int idModulo;
    
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;
    
    private AudioPanel audioPanel;
    private AlarmPanel alarmPanel;

    private JTabbedPane tabbedPane;

    public AMProductSourcePropertiesDialog(Frame frame, Source vsBean,
            AudioSources asBean, int idModulo) throws MVException {
        super(frame);
        
        this.vsBean = vsBean;
        this.asBean = asBean;
        this.idModulo = idModulo;

        ButtonActionListener buttonActionListener = new ButtonActionListener();
    
        setTitle("Audio settings and alarms");
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

        audioPanel = new AudioPanel(asBean.getAudio0dBRef(),
                asBean.getAudioDigitalRef(), asBean.getAudioAlarmSettings());
        alarmPanel = new AlarmPanel(vsBean);
        
        tabbedPane = new JDioTabbedPane(true);
        tabbedPane.addChangeListener(new ChangeListenerColorHandled());
        tabbedPane.setBounds(1, 1, 400, 480);
        //Aggiungo i vari panel al tabbedPane
        tabbedPane.add(audioPanel);
        tabbedPane.add(alarmPanel);
        
        tabbedPane.setSelectedComponent(alarmPanel);
        tabbedPane.setTitleAt(0, "References and channel alarms");
        tabbedPane.setTitleAt(1, "Alarm configuration");
        
        getContentPane().add(tabbedPane, "Center");
        setVisible(true);
    }

    private class ButtonActionListener implements ActionListener
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            Object obj = actionevent.getSource();
            if (obj == okButton)
                okAction();
            else
            
            if (obj == cancelButton)
                cancelAction();
           
        }
    }
    
    private void okAction() {
        
        try {
            audioPanel.save();
            alarmPanel.save();
            
            CtrlProtocol.getInstance().saveSourceToMV(idModulo, vsBean);
            CtrlProtocol.getInstance().saveAudioSourcesToMv(idModulo, asBean);

            //query aspectRatio
            int idOggettoAssociato = CtrlWorkspace.getInstance().getIdOggettoBySource(idModulo, vsBean.getId());
            CtrlWorkspace.getInstance().loadObjectAspectRatio(idModulo, idOggettoAssociato);
            TilesWorkspace tilesWorkspace = CtrlActions.getInstance().getTilesWorkspace();
            tilesWorkspace.loadTilesFromBean();
            tilesWorkspace.applyZOrder();
            tilesWorkspace.requestFocusInWindow();
            tilesWorkspace.repaint();
            dispose();
        } catch (MVException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    private void cancelAction(){
        dispose();
    }
}
