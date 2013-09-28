package dialogs.moduleproperties;

import bean.NgmServer;
import bean.NgmServers;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Marco Ricci & Antonio Poggi
 */
public class Ngm164ServerPanel extends JPanelBGGradient{
    private NgmServers bean;
    private int idModulo;
    private Frame frame;
    
    private JLabel ngm164Label;
    private JList ngm164List;
    private DefaultListModel ngm164ListModel;
    
    private JButton newButton;
    private JButton editButton;
    private JButton deleteButton;
            
    public Ngm164ServerPanel(NgmServers bean, int idModulo, Frame frame) {
        setLayout(null);
        setBounds(1, 30, 400, 400);
        
        this.bean = bean;
        this.idModulo = idModulo;
        this.frame = frame;
        MyItemListener mIL = new MyItemListener();
    
        ngm164Label = new JLabel();
        ngm164Label.setText(StyleInterface.getInstance().getDataXXNgm());
        ngm164Label.setBounds(20, 20, 100, 20);
        add(ngm164Label);
        
        ngm164List = new JList();
        reloadList();
        
        ngm164List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (bean.getNgmServerCount()>0)
            ngm164List.setSelectedIndex(0);
        ngm164List.setBorder(BorderFactory.createLoweredBevelBorder());
        ngm164List.getSelectionModel().addListSelectionListener(mIL);
        ngm164List.setBounds(15, 45, 300, 300);
        JScrollPane sp = new JScrollPane();
        sp.setOpaque(true);
        sp.getViewport().add(ngm164List);
        sp.setBounds(15, 45, 300, 300);
        add(sp);
        
        newButton = new JButton();
        newButton.setText("New");
        newButton.addActionListener(mIL);
        newButton.setBounds(15, 360, 90, 20);
        add(newButton);
        editButton = new JButton();
        editButton.setText("Edit");
        editButton.addActionListener(mIL);
        editButton.setBounds(120, 360, 90, 20);
        add(editButton);
        deleteButton = new JButton();
        deleteButton.setText("Delete");
        deleteButton.addActionListener(mIL);
        deleteButton.setBounds(225, 360, 90, 20);
        add(deleteButton);
        
    }
    
    public void save() {
    }
    
    
    private void editButton() {
        int selectedIndex = ngm164List.getSelectedIndex();
        
        if (selectedIndex > -1) {
            NgmServer ngmServer = bean.getNgmServer(selectedIndex);
            new NGMServerEditDialog(frame, idModulo, ngmServer, true, this);
        }
    }
    
    private void newButton() {
        try{
            NgmServer newNgmServer = CtrlWorkspace.getInstance().newNgm164Server(idModulo);
            ngm164ListModel.addElement(newNgmServer.getAlias().getVal());
            ngm164List.setSelectedIndex(ngm164ListModel.size()-1);
            new NGMServerEditDialog(frame, idModulo, newNgmServer, false, this);
            //ipAddrField.setText(newNgmServer.getIpaddr().getVal());
            //nameField.setText(newNgmServer.getAlias().getVal());
        } catch (MVException mve) {
            JOptionPane.showMessageDialog(null, "An error has occurred while adding "+StyleInterface.getInstance().getDataXXNgm()+" server entry", "Operation aborted", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void deleteButton() {
        int selectedIndex = ngm164List.getSelectedIndex();
        
        if (selectedIndex > -1) {
            try {
                CtrlWorkspace.getInstance().removeNgm164Server(idModulo, bean.getNgmServer(selectedIndex).getId());
                ngm164ListModel.remove(selectedIndex);
                if (ngm164ListModel.size()>0) {
                    if (selectedIndex>0) {
                        selectedIndex--;
                    }
                    ngm164List.setSelectedIndex(selectedIndex);
                    //ipAddrField.setText(bean.getNgmServer(selectedIndex).getIpaddr().getVal());
                    //nameField.setText(bean.getNgmServer(selectedIndex).getAlias().getVal());
                } else {
                    //ipAddrField.setText("");
                    //nameField.setText("");
                }
            } catch (MVException mve) {
                JOptionPane.showMessageDialog(null, "An error has occurred while deleting selected "+StyleInterface.getInstance().getDataXXNgm()+" server entry", "Operation aborted", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class MyItemListener implements ActionListener, ListSelectionListener {

        public void actionPerformed(ActionEvent ae) {
            Object obj = ae.getSource();
            if (obj == editButton)
                editButton();
            else if (obj == newButton) {
                newButton();
            } else if (obj == deleteButton) {
                deleteButton();
            }
        }

        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            if (lsm.isSelectionEmpty()) {
                deleteButton.setEnabled(false);
                editButton.setEnabled(false);
            } else {
                deleteButton.setEnabled(true);
                editButton.setEnabled(true);
            }
        }
    }
    
    public void reloadList (){
        ngm164ListModel = new DefaultListModel();
        Iterator it = bean.iterateNgmServer();
        while (it.hasNext()) {
            NgmServer ngmServer = (NgmServer)it.next();
            ngm164ListModel.addElement(ngmServer.getAlias().getVal());
        }
        ngm164List.setModel(ngm164ListModel);
    }
    
}
