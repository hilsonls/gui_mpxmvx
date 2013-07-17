package dialogs.systime;

/**
 *
 * @author Marco Ricci & Antonio Poggi
 */
import bean.SysTime;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;
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

/**
 *
 * @author panda
 */
public class TimeDialog extends JDialog {
    
    private JTabbedPane tabbedPane;
    
    private TimePanel timePanel;
    private TimezonePanel timezonePanel;
    
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;
    
    private SysTime sysTime;
    
    private int idModulo;
    
    public TimeDialog(Frame frame, int idModulo) throws MVException {
        super(frame);
        
        this.sysTime = CtrlWorkspace.getInstance().loadSysTimeFromMV(idModulo);
        
        setTitle("Set time");
        setResizable(false);
        setModal(true);
        setDefaultCloseOperation(2);
        setLocation(100, 100);
        setSize(310, 355);
        
        ButtonActionListener buttonActionListener = new ButtonActionListener();
        
        buttonsPanel = new JPanelBGGradient(StyleInterface.getInstance().getButtonPanelBackgroundTopColor(), StyleInterface.getInstance().getButtonPanelBackgroundBottomColor(),true);
        buttonsPanel.setLayout(new FlowLayout(1, 10, 10));
        buttonsPanel.setPreferredSize(new Dimension(40, 40));
        okButton = new JButton();
        okButton.setText("OK");
        okButton.setActionCommand("OK");
        okButton.addActionListener(buttonActionListener);
        okButton.setPreferredSize(new Dimension(100, 25));
        this.getRootPane().setDefaultButton(okButton);
        buttonsPanel.add(okButton);
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        cancelButton.setActionCommand("Cancel");
        cancelButton.addActionListener(buttonActionListener);
        cancelButton.setPreferredSize(new Dimension(100, 25));
        buttonsPanel.add(cancelButton);
        getContentPane().add(buttonsPanel, "South");
        
        timePanel = new TimePanel(sysTime, idModulo, frame);
        timezonePanel = new TimezonePanel(sysTime.getSysTimeTimezone());
        
        tabbedPane = new JDioTabbedPane(true);
        tabbedPane.addChangeListener(new ChangeListenerColorHandled());
        //tabbedPane.setBounds(1, 1, 340, 450);
        //Aggiungo i vari panel al tabbedPane
        tabbedPane.add(timePanel);
        tabbedPane.add(timezonePanel);
        
        tabbedPane.setSelectedComponent(timePanel);
        tabbedPane.setTitleAt(0, "Time");
        tabbedPane.setTitleAt(1, "Timezone");
        
        getContentPane().add(tabbedPane, "Center");
        setVisible(true);
    } 
    
    private class ButtonActionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent actionevent){
            Object obj = actionevent.getSource();
            if(obj == okButton)
                okAction();
            else if(obj == cancelButton)
                cancelAction();
        }
    }
    
    private void okAction() {
        
        try {
            //AGGIORNO I BEAN dei panels
            timePanel.save();
            timezonePanel.save();
            
            CtrlWorkspace.getInstance().saveSysTimeToMV(idModulo);
            
            dispose();
           
            
            
        } catch (MVException ex) {
            //TODO:  fare panel.undo()  oppure avvertire l'utente di ricaricare la configurazione del multiviewer
            //Panda dice: Qui bisognerebbe avvertire l'utente che c'è stato un errore di comunicazione che non ha 
            //  reso possibile salvare le modifiche apportate e dare la possibilità di scegliere se: 
            //      1. lasciare il client inconsistente col Multiviewer, senza chiudere il dialog in modo da dare
            //          possibilità all'utente di provare nuovamente cliccando su ok, o se cliccare cancel per 
            //          annullare le modifiche.
            //      2. Ricaricare la configurazione dal multiviewer
            //
            //      QUI CI DOBBIAMO RAGIONARE BENE PERCHE' CI SONO MOLTI POTENZIALI PROBLEMI
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    private void cancelAction(){
        
        dispose();
    
    }
}