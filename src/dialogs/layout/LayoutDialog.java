package dialogs.layout;

import bean.Layout;
import bean.ModuleFilename;
import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author panda
 */
public class LayoutDialog extends JDialog {
    public static final int NEW = 1;
    public static final int LOAD = 2;
    public static final int SAVE = 3;
    public static final int SAVE_AS = 4;
    public static final int DELETE = 5;
    public static final int SETUP = 6;
    
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;
    
    private FilenamePanel filenamePanel;
    private SetupLayoutPanel setupLayoutPanel;
    
    //ctrlActions per ricaricare tutti i tilesworkspace
    private CtrlActions ctrlActions;
    //idModulo per sapere di quale modulo fa parte l'oggetto in questione
    private int idModulo;
    
    private int opType;
    
    private Layout bean;
    
    public LayoutDialog(Frame frame, int idModulo, int opType) throws MVException {
        super(frame);
        
        //memorizzo il tileWorkspace e l'id del modulo;
        this.ctrlActions = CtrlActions.getInstance();
        this.idModulo = idModulo;
        this.opType = opType;
        
        ModuleFilename filename = CtrlWorkspace.getInstance().getModule(idModulo).getModuleFilename();
        bean = CtrlWorkspace.getInstance().getModule(idModulo).getLayout();
        
        //MANDRAKATA
        okButton = new JButton();
        filenamePanel = new FilenamePanel(filename, okButton);
        setupLayoutPanel = new SetupLayoutPanel(bean);
        
        boolean toShow = true;
        
        switch (opType) {
            case NEW:
                setTitle("");
                int selection = JOptionPane.showConfirmDialog(frame, "Do you want to save current layout?" , "New layout", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                switch (selection) {
                    case JOptionPane.CANCEL_OPTION:
                        toShow = false;
                        break;
                        
                    case JOptionPane.YES_OPTION:
                        if (filenamePanel.isFilenameInList()) {
                            newOkAction();
                            toShow = false;
                        } else {
                            setTitle("Save layout as");
                            add(filenamePanel);
                        }
                        break;
                        
                    case JOptionPane.NO_OPTION:
                        CtrlWorkspace.getInstance().newLayout(idModulo);
                        ctrlActions.reloadAllTilesWorkspaces();
                        toShow = false;
                        break;

                    default: toShow=false;
                        break;
                }
                break;
            
            case LOAD:
                setTitle("Load layout");
                add(filenamePanel);
                break;
            
            case SAVE:
                if (filename.getVal() != null && !filename.getVal().equals("") && !containsInvalidChar(filename.getVal())) { //Se il layout non ha nome allora non posso fare save ma devo fare save_as
                    saveAsOkAction();
                    toShow = false;
                    break;
                }
            
            case SAVE_AS:
                setTitle("Save layout as");
                add(filenamePanel);
                break;
            
            case DELETE:
                setTitle("Delete layout");
                add(filenamePanel);
                break;
                
            case SETUP:
                setTitle("Layout properties");
                add(setupLayoutPanel);
                break;

            
        }
        setResizable(false);
        setModal(true);
        setDefaultCloseOperation(2);
        setLocation(100, 100);
        setSize(320, 400);
        
        ButtonActionListener buttonActionListener = new ButtonActionListener();
        
        buttonsPanel = new JPanelBGGradient(StyleInterface.getInstance().getButtonPanelBackgroundTopColor(), StyleInterface.getInstance().getButtonPanelBackgroundBottomColor(),true);
        buttonsPanel.setLayout(new FlowLayout(1, 10, 10));
        buttonsPanel.setPreferredSize(new Dimension(40, 40));
        
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
        
        //Se per l'operazione non è necessario presentare a schermo questo dialog
        //non posso fare dispose() dentro al costruttore quindi, per evitare che resti 
        //erroneamente aperto questo dialog, evito di renderlo visibile.
        //Da verificare se in tal caso il dialog resti inutilmente caricato in memoria per tutta la durata 
        //dell'esecuzione del programma.
        setVisible(toShow);
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
        switch (opType) {
            case NEW:
                newOkAction();
                break;
            
            case LOAD:
                loadOkAction();
                break;
            
            case SAVE:
            case SAVE_AS:
                saveAsOkAction();
                break;
            
            case DELETE:
                deleteOkAction();
                break;
                
            case SETUP:
                setupOkAction();
                break;
        }
    }
    
    private void cancelAction(){
        
        dispose();
    
    }
    
    private void newOkAction() {
        String filename = filenamePanel.getFilename();
        
        if (filename == null || filename.equals("") || containsInvalidChar(filename)) {
            JOptionPane.showMessageDialog(null, "Please insert a valid filename to save. A filename cannot contain \\ / : * ? \" < > |","Invalid filename",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        try {
            CtrlWorkspace.getInstance().saveLayout(idModulo, filenamePanel.getFilename());
            CtrlWorkspace.getInstance().newLayout(idModulo);
            ctrlActions.reloadAllTilesWorkspaces();
        } catch (MVException mve) {
            JOptionPane.showMessageDialog(null, "An error has occurred while saving layout file. Layout may not be saved","Save layout error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        dispose();
    }
    
    private void deleteOkAction() {
        if (!filenamePanel.isFilenameInList()) {
            JOptionPane.showMessageDialog(null, "Please select a valid filename to delete!","File not found",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            CtrlWorkspace.getInstance().deleteLayout(idModulo, filenamePanel.getFilename());
        } catch (MVException mve) {
            JOptionPane.showMessageDialog(null, "An error has occurred while deleting layout file. Layout may not be deleted","Delete layout error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        dispose();
    }
    
    private void loadOkAction() {
        if (!filenamePanel.isFilenameInList()) {
            JOptionPane.showMessageDialog(null, "Please select a valid filename to load!","File not found",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        //Cursor myPointer= Toolkit.getDefaultToolkit().createCustomCursor(layout.handler.getIcon("waitCursor.gif").getImage(), new Point(0,0), "Blah");
        //setCursor(myPointer);
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            CtrlWorkspace.getInstance().loadLayout(idModulo, filenamePanel.getFilename());
        } catch (MVException mve) {
            JOptionPane.showMessageDialog(null, "An error has occurred while loading layout file.","Load layout aborted",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ctrlActions.reloadAllTilesWorkspaces();
        dispose();
    }
    
    private void saveAsOkAction() {
        String filename = filenamePanel.getFilename();
        
        if (filename == null || filename.equals("") || containsInvalidChar(filename)) {
            JOptionPane.showMessageDialog(null, "Please insert a valid filename to save. A filename cannot contain \\ / : * ? \" < > |","Invalid filename",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            CtrlWorkspace.getInstance().saveLayout(idModulo, filenamePanel.getFilename());
        } catch (MVException mve) {
            JOptionPane.showMessageDialog(null, "An error has occurred while saving layout file. Layout may not be saved","Save layout error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        dispose();
    }
    
    private void setupOkAction() {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            //AGGIORNO I BEAN dei panels
            setupLayoutPanel.save();
            
            CtrlProtocol.getInstance().saveModuleLayoutToMV(idModulo, bean);
                       
            dispose();
            
            
        } catch (MVException ex) {
            //TODO:  fare panel.undo()  oppure avvertire l'utente di ricaricare la configurazione del multiviewer
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    private boolean containsInvalidChar(String filename) {
        final StringCharacterIterator iterator = new StringCharacterIterator(filename);
        char c =  iterator.current();
        while (c != CharacterIterator.DONE ){
            if (c=='\\' || c=='/' || c==':' || c=='*' || c=='?' || c=='"' || c=='<' || c=='>' || c=='|') {
                return true;
            }
            c = iterator.next();
        }
        return false;
    }

}
