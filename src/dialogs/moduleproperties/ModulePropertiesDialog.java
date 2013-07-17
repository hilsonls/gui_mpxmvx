package dialogs.moduleproperties;

/**
 *
 * @author Marco Ricci & Antonio Poggi
 */

import bean.Screen;
import bean.VideoCards;
import bean.AudioMonitor;
import bean.AudioOut;
import bean.Gpis;
import bean.Network;
import bean.NgmServers;
import bean.Objects;
import bean.Protocols;
import bean.Sources;
import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import eccezioni.CloneBeanException;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.components.ChangeListenerColorHandled;
import gui.components.JDioTabbedPane;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;
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
 * @author panda
 */
public class ModulePropertiesDialog extends JDialog {
    public static final int TILE_TYPE_VIDEO = 1;
    public static final int TILE_TYPE_AUDIO = 2;
    public static final int TILE_TYPE_OTHER = 3;
    
    private JTabbedPane tabbedPane;
    
    private BoardsPanel boardsPanel;
    private ScreenPanel screenPanel;
    private SourcePanel sourcePanel;
    private AudioMonitorPanel audioMonitorPanel;
    private AudioOutputPanel audioOutputPanel;
    private GPIsPanel gpisPanel;
    private NetworkPanel networkPanel;
    private Ngm164ServerPanel ngm164ServerPanel;
    private ProtocolsPanel protocolsPanel;
    
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;
    
    //idModulo per sapere di quale modulo fa parte l'oggetto in questione
    private int idModulo;
    
    private VideoCards videoCards;
    private Screen  screen;
    private Sources sources;
    private AudioMonitor audioMonitor;
    private AudioOut audioOut;
    private Gpis gpis;
    private Network network;
    private NgmServers ngmServers;
    private Protocols protocols;
    private CtrlActions ctrlActions;
    
    public ModulePropertiesDialog(Frame frame, int idModulo) throws MVException {
        super(frame);
        this.ctrlActions = CtrlActions.getInstance();
        //memorizzo l'id del modulo;
        this.idModulo = idModulo;
        
        this.videoCards = CtrlWorkspace.getInstance().getVideoCards(idModulo);
        this.screen = CtrlWorkspace.getInstance().getModule(idModulo).getScreen();
        this.sources = CtrlWorkspace.getInstance().getModule(idModulo).getSources();
        this.audioMonitor = CtrlWorkspace.getInstance().getModule(idModulo).getAudioMonitor();
        this.audioOut = CtrlWorkspace.getInstance().getModule(idModulo).getAudioOut();
        this.gpis  = CtrlWorkspace.getInstance().getModule(idModulo).getGpis();
        this.network = CtrlWorkspace.getInstance().getModule(idModulo).getNetwork();
        this.ngmServers = CtrlWorkspace.getInstance().getModule(idModulo).getNgmServers();
        this.protocols = CtrlWorkspace.getInstance().getModule(idModulo).getProtocols();
        
        setTitle("Module Properties ("+idModulo+")");
        setResizable(false);
        setModal(true);
        setDefaultCloseOperation(2);
        setLocation(100, 100);
        setSize(460, 550);
        
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
        
        boardsPanel = new BoardsPanel(videoCards, idModulo);
        screenPanel = new ScreenPanel(screen, idModulo);
        sourcePanel = new SourcePanel(sources);
        audioMonitorPanel = new AudioMonitorPanel(audioMonitor);
        audioOutputPanel = new AudioOutputPanel(audioOut);
        gpisPanel = new GPIsPanel(gpis, idModulo);
        networkPanel = new NetworkPanel(network, idModulo, frame);
        ngm164ServerPanel = new Ngm164ServerPanel(ngmServers, idModulo, frame);
        protocolsPanel = new ProtocolsPanel(protocols, idModulo, frame);

        
        
        tabbedPane = new JDioTabbedPane(true);
        tabbedPane.addChangeListener(new ChangeListenerColorHandled());
        //tabbedPane.setBounds(1, 1, 340, 450);
        //Aggiungo i vari panel al tabbedPane
        tabbedPane.add(boardsPanel);
        tabbedPane.add(screenPanel);
        tabbedPane.add(sourcePanel);
        tabbedPane.add(audioMonitorPanel);
        tabbedPane.add(audioOutputPanel);
        tabbedPane.add(gpisPanel);
        tabbedPane.add(networkPanel);
        tabbedPane.add(ngm164ServerPanel);
        tabbedPane.add(protocolsPanel);
        
        tabbedPane.setSelectedComponent(boardsPanel);
        tabbedPane.setTitleAt(0, "Boards");
        tabbedPane.setTitleAt(1, "Screen");
        tabbedPane.setTitleAt(2, "Sources");
        tabbedPane.setTitleAt(3, "Audio Monitors");
        tabbedPane.setTitleAt(4, "Audio Outputs");
        tabbedPane.setTitleAt(5, "GPIs");
        tabbedPane.setTitleAt(6, "Network");
        tabbedPane.setTitleAt(7, StyleInterface.getInstance().getDataXXNgm());
        tabbedPane.setTitleAt(8, "Protocols");
        
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
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            //AGGIORNO I BEAN dei panels
            boardsPanel.save();
            screenPanel.save();
            sourcePanel.save();
            audioMonitorPanel.save();
            audioOutputPanel.save();
            gpisPanel.save();
            networkPanel.save();
            protocolsPanel.save();
            
            //OPERAZIONI RELATIVE AL SOURCE PANEL
            CtrlWorkspace.getInstance().saveSourcesUsernameToMV(idModulo);
            
            //OPERAZIONI RELATIVE AL BOARDS PANEL
            CtrlProtocol.getInstance().saveVideoCardsToMV(idModulo, videoCards);
            //Ricarico le sorgenti aggiornate
            CtrlWorkspace.getInstance().loadSourcesFromMV(idModulo);
            
            //OPERAZIONI RELATIVE AL SCREENPANEL
            CtrlWorkspace.getInstance().saveScreenToMV(idModulo);
            //aggiorno la risoluzione se è cambiata
            int h = CtrlWorkspace.getInstance().getModule(ctrlActions.getIdModulo()).getScreen().getResolution().getHres();
            int v = CtrlWorkspace.getInstance().getModule(ctrlActions.getIdModulo()).getScreen().getResolution().getVres();
            if (screenPanel.oldHres != h  ||  screenPanel.oldVres != v){
                 ctrlActions.getTilesWorkspace().setMvHres(h);
                 ctrlActions.getTilesWorkspace().setMvVres(v);
                 ctrlActions.getTilesWorkspace().proporzioniWorkspace();
                 ctrlActions.getPreviewWorkspace().setMvHres(h);
                 ctrlActions.getPreviewWorkspace().setMvVres(v);
                 ctrlActions.getPreviewWorkspace().proporzioniWorkspace();
                 
                 CtrlWorkspace.getInstance().loadObjectsFromMV(idModulo);
                             
                 
                 
        
                 
                 ctrlActions.getTilesWorkspace().loadTilesFromBean();
                 ctrlActions.getTilesWorkspace().applyZOrder();
                 
                 //handler.viewer.loadTilesFromBean();
                 //handler.viewer.applyZOrder();
        
            }
            
            
            //OPERAZIONI RELATIVE ALL'AUDIOMONITOR
            CtrlWorkspace.getInstance().saveAudioMonitorToMV(idModulo);
            //OPERAZIONI RELATIVE AI GPIS
            CtrlWorkspace.getInstance().saveGPIsToMV(idModulo);
            
            //OPERAZIONI RELATIVE ALL'AUDIOOUTPUT
            CtrlWorkspace.getInstance().saveAudioOutputToMV(idModulo);
            
            //OPERAZIONI RELATIVE AL GPOPANEL
            //bug #141  i gpiOut vengono gestiti come i gpiIn, quindi stanno dentro GPIS
//            CtrlWorkspace.getInstance().saveGPOAlarmOutToMV(idModulo);
            
            //OPERAZIONI RELATIVE AL NETWORK PANEL
            CtrlWorkspace.getInstance().saveNetworkToMV(idModulo, false);

            //OPERAZIONI RELATIVE AL PROTOCOLS PANEL
            CtrlWorkspace.getInstance().saveProtocolsToMV(idModulo);
            
            dispose();
           
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            
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
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    private void cancelAction(){
        
        dispose();
    
    }
}