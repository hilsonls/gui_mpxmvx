/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.layout;

import bean.ModuleFilename;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JPanelBGGradient;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author panda
 */
public class FilenamePanel extends JPanelBGGradient{
    private JLabel filenameLabel;
    private JTextField filenameField;
    
    private JScrollPane filenameListScroll;
    private JList filenameList;
    
    private boolean mutex;
    private JButton okButton;
    
    public FilenamePanel(ModuleFilename bean, JButton okButton) throws MVException {
        setLayout(null);
        mutex = false;
        this.okButton = okButton;
        filenameLabel = new JLabel();
        filenameLabel.setText("Filename");
        filenameLabel.setBounds(20, 20, 80, 20);
        add(filenameLabel);
        filenameField = ComponentFactory.createTextField(bean.getVal(), 40);
        filenameField.setBounds(120, 20, 170, 20);
        filenameField.getDocument().addDocumentListener(new FilenameDocumentListener());
        add(filenameField);
        
        filenameList = ComponentFactory.createList(bean.getOptionsName(), bean.getVal());
        filenameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        filenameList.addListSelectionListener(new FilenameSelectionListener());
        filenameList.addMouseListener(new FilenameMouseListener());
        filenameListScroll = new JScrollPane(filenameList);
        filenameListScroll.setBounds(20, 60, 270, 250);
        add(filenameListScroll);
    }
    
    public Boolean isFilenameInList() {
        String testo = filenameField.getText();
        if (testo == null || testo.equals("")) {
            return false;
        }
        
        int num = filenameList.getModel().getSize();
        for (int i=0; i<num; i++) {
            if (filenameList.getModel().getElementAt(i).toString().equals(testo)) {
                return true;
            }
        }
        return false;
    }
    
    public String getFilename() {
        return filenameField.getText();
    }
    
    private void tryToSelect() {
        String testo = filenameField.getText();
        ListModel lm = filenameList.getModel();
        if (testo == null || testo.equals("")) {
            filenameList.getSelectionModel().clearSelection();
        }
        
        int num = lm.getSize();
        for (int i=0; i<num; i++) {
            if (lm.getElementAt(i).toString().equals(testo)) {
                filenameList.setSelectedIndex(i);
                filenameList.ensureIndexIsVisible(i); //TODO: questo funziona solo se uso un JViewport invece che JScrollPane
                return;
            }
        }

        filenameList.getSelectionModel().clearSelection();
    }
    
    public class FilenameSelectionListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent lse) {
            if (!mutex && filenameList.getSelectedIndex() != -1) {
                mutex = true;
                filenameField.setText(filenameList.getSelectedValue().toString());
                mutex = false;
            }
        }
    }
    
    public class FilenameDocumentListener implements DocumentListener {

        public void insertUpdate(DocumentEvent e) {
            if (!mutex) {
                mutex = true;
                tryToSelect();
                mutex = false;
            }
        }

        public void removeUpdate(DocumentEvent e) {
            if (!mutex) {
                mutex = true;
                tryToSelect();
                mutex = false;
            }
        }

        public void changedUpdate(DocumentEvent e) {
        }        
    }

    public class FilenameMouseListener implements MouseListener {

        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount()==2){
                okButton.doClick();
            }
        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {
            
        }

        public void mouseExited(MouseEvent e) {
            
        }

    }
}
