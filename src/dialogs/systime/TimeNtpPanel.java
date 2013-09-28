package dialogs.systime;

import bean.SysTime;
import bean.NtpServer;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class TimeNtpPanel extends JPanel {

    private SysTime bean;
    private int idModulo;
    private Frame frame;
    
    private JList ntpServerList;
    private DefaultListModel ntpServerListModel;
    
    private JButton addButton;
    private JButton deleteButton;

    public TimeNtpPanel(SysTime bean, int idModulo, Frame frame) {
        setLayout(null);
        this.bean = bean;
        this.idModulo = idModulo;
        this.frame = frame;
        MyItemListener mIL = new MyItemListener();
        
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("NTP Servers"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        ntpServerList = new JList();
        reloadList();
        
        ntpServerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (bean.getNtpServers().getNtpServerCount()>0)
            ntpServerList.setSelectedIndex(0);
        ntpServerList.setBorder(BorderFactory.createLoweredBevelBorder());
        ntpServerList.getSelectionModel().addListSelectionListener(mIL);
        ntpServerList.setBounds(15, 30, 160, 135);
        JScrollPane sp = new JScrollPane();
        sp.setOpaque(true);
        sp.getViewport().add(ntpServerList);
        sp.setBounds(15, 30, 160, 135);
        add(sp);
        
        addButton = new JButton();
        addButton.setText("Add");
        addButton.addActionListener(mIL);
        addButton.setBounds(185, 65, 70, 25);
        add(addButton);
        deleteButton = new JButton();
        deleteButton.setText("Delete");
        deleteButton.addActionListener(mIL);
        deleteButton.setBounds(185, 100, 70, 25);
        add(deleteButton);
        
        setOpaque(false);
    }
    
    public void reloadList (){
        ntpServerListModel = new DefaultListModel();
        Iterator it = bean.getNtpServers().iterateNtpServer();
        while (it.hasNext()) {
            NtpServer ntpServer = (NtpServer)it.next();
            ntpServerListModel.addElement(ntpServer.getVal());
        }
        ntpServerList.setModel(ntpServerListModel);
    }
    
    private void addButton() {
        new NtpServerAddDialog(frame, idModulo);
        reloadList();
    }
    
    private void deleteButton() {
        int selectedIndex = ntpServerList.getSelectedIndex();
        
        if (selectedIndex > -1) {
            try {
                CtrlWorkspace.getInstance().removeNtpServerFromMV(idModulo, bean.getNtpServers().getNtpServer(selectedIndex).getId());
                ntpServerListModel.remove(selectedIndex);
                if (ntpServerListModel.size()>0) {
                    if (selectedIndex>0) {
                        selectedIndex--;
                    }
                    ntpServerList.setSelectedIndex(selectedIndex);
                } else {
                    
                }
            } catch (MVException mve) {
                JOptionPane.showMessageDialog(null, "An error has occurred while deleting selected NTP Server entry", "Operation aborted", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class MyItemListener implements ActionListener, ListSelectionListener {

        public void actionPerformed(ActionEvent ae) {
            Object obj = ae.getSource();
            if (obj == addButton) {
                addButton();
            } else if (obj == deleteButton) {
                deleteButton();
            }
        }

        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            if (lsm.isSelectionEmpty()) {
                deleteButton.setEnabled(false);
            } else {
                deleteButton.setEnabled(true);
            }
        }
    }
}
