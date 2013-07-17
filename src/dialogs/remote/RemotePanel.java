package dialogs.remote;

import bean.Mv;
import bean.Remote;
import bean.RemotesAvail;
import controllori.CtrlProtocol;
import eccezioni.MVException;
import gui.components.JPanelBGGradient;
import gui.components.MultiColumnJList;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Marco Ricci & Antonio Poggi
 */
public class RemotePanel extends JPanelBGGradient{
    private RemotesAvail remotes;
    private Frame frame;
    private int idModulo;   
    private MyItemListener mIL;
        
    private JLabel remoteLabel;
    private JList remoteList;
    private DefaultListModel remoteListModel;
    private JButton searchButton;
    private JButton configButton;
    
    private JLabel smvControlLabel;
    private JList smvControlList;
    private DefaultListModel smvControlListModel;
    private JButton smvEditButton;
    
    private JLabel smvControlModeLabel;
    private JRadioButton smvControlModeAllRadio;
    private JRadioButton smvControlModeIndividualRadio;
    private ButtonGroup smvControlModeGroup;    
            
    public RemotePanel(Frame frame, int idModulo) {
        setLayout(null);
        setBounds(1, 30, 500, 400);
        
        //this.bean = searchForRemotes();
        this.frame = frame;
        this.idModulo = idModulo;
        this.mIL = new MyItemListener();
    
        remoteLabel = new JLabel();
        remoteLabel.setText("Remotes Found");
        remoteLabel.setBounds(25, 20, 100, 20);
        add(remoteLabel);
        remoteList = new MultiColumnJList();
        remoteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        remoteList.getSelectionModel().addListSelectionListener(mIL);
        remoteList.setBorder(BorderFactory.createLoweredBevelBorder());
        remoteList.setBounds(20, 40, 220, 280);
        remoteList.setModel(searchForRemotes());
        JScrollPane sp = new JScrollPane();
        sp.setOpaque(true);
        sp.getViewport().add(remoteList);
        sp.setBounds(20, 40, 220, 280);
        add(sp);
        
        searchButton = new JButton();
        searchButton.setText("Search Again");
        searchButton.addActionListener(mIL);
        searchButton.setBounds(20, 330, 110, 20);
        add(searchButton);
        configButton = new JButton();
        configButton.setText("Configure");
        configButton.addActionListener(mIL);
        configButton.setEnabled(false);
        configButton.setBounds(140, 330, 100, 20);
        add(configButton);
        
        smvControlLabel = new JLabel();
        smvControlLabel.setText("SMVs to Control");
        smvControlLabel.setBounds(265, 20, 100, 20);
        add(smvControlLabel);
        smvControlList = new JList();
        smvControlList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        smvControlList.getSelectionModel().addListSelectionListener(mIL);
        smvControlList.setBorder(BorderFactory.createLoweredBevelBorder());
        smvControlList.setBounds(260, 40, 210, 280);
        JScrollPane sp1 = new JScrollPane();
        sp1.setOpaque(true);
        sp1.getViewport().add(smvControlList);
        sp1.setBounds(260, 40, 210, 280);
        add(sp1);
        
        
        smvEditButton = new JButton();
        smvEditButton.setText("Edit");
        smvEditButton.setEnabled(false);
        smvEditButton.addActionListener(mIL);
        smvEditButton.setBounds(315, 330, 100, 20);
        add(smvEditButton);
        
        smvControlModeLabel = new JLabel();
        smvControlModeLabel.setText("Control Mode:");
        smvControlModeLabel.setBounds(40, 370, 100, 20);
        add(smvControlModeLabel);
        smvControlModeAllRadio = new JRadioButton();
        smvControlModeAllRadio.setOpaque(false);
        smvControlModeAllRadio.setText("All SMVs together");
        smvControlModeAllRadio.setSelected(false);
        smvControlModeAllRadio.addItemListener(mIL);
        smvControlModeAllRadio.setBounds(80, 395, 180, 20);
        add(smvControlModeAllRadio);
        smvControlModeIndividualRadio = new JRadioButton();
        smvControlModeIndividualRadio.setOpaque(false);
        smvControlModeIndividualRadio.setText("Individual SMV Selection");
        smvControlModeIndividualRadio.setSelected(false);
        smvControlModeIndividualRadio.setBounds(80, 420, 180, 20);
        add(smvControlModeIndividualRadio);
        smvControlModeGroup = new ButtonGroup();
        smvControlModeGroup.add(smvControlModeAllRadio);
        smvControlModeGroup.add(smvControlModeIndividualRadio);
        refreshControlMode();
    }
    
    private void refreshControlMode() {
        
        if (remoteList.getSelectionModel().isSelectionEmpty()) {
            smvControlModeAllRadio.setSelected(false);
            smvControlModeAllRadio.setEnabled(false);
            smvControlModeIndividualRadio.setSelected(false);
            smvControlModeIndividualRadio.setEnabled(false);
            smvControlModeLabel.setEnabled(false);
            smvControlModeGroup.clearSelection();
        } else {
            smvControlModeAllRadio.setEnabled(true);
            smvControlModeIndividualRadio.setEnabled(true);
            smvControlModeLabel.setEnabled(true);
            boolean collectiveControl = remotes.getRemote(remoteList.getSelectionModel().getMinSelectionIndex()).getCollectiveMode().getVal();
            smvControlModeAllRadio.setSelected(collectiveControl);
            smvControlModeIndividualRadio.setSelected(!collectiveControl);
        }
    }
    
    private ListModel searchForRemotes() {
        //Eventuale caricamento del glasspane con la clessidra
        remoteListModel = new DefaultListModel();
        
        try {
            remotes = CtrlProtocol.getInstance().loadRemotesAvailableFromMV(idModulo);
            Iterator it = remotes.iterateRemote();
            while (it.hasNext()) {
                Remote remote = (Remote)it.next();
                String[] str = {remote.getIpaddr().getVal(), remote.getMac().getVal()};
                remoteListModel.addElement(str);
            }
        } catch (MVException mve) {
            
        }
        return remoteListModel;
    }

    private ListModel createSmvListModel() {
        return createSmvListModel(remoteList.getSelectionModel().getMinSelectionIndex());
    }
    
    private ListModel createSmvListModel(int selectedIndex) {
        smvControlListModel = new DefaultListModel();
        
        if (selectedIndex != -1) {
            Iterator mvIt = remotes.getRemote(selectedIndex).getMvs().iterateMv();
            while (mvIt.hasNext()) {
                Mv mv = (Mv)mvIt.next();
                smvControlListModel.addElement((mv.getId()+1)+") "+mv.getVal());
            }
        }
        
        return smvControlListModel;
    }
    
    public void save() throws MVException {
        try {
            CtrlProtocol.getInstance().saveRemotesAvailableToMV(idModulo, remotes);
        }
        catch ( MVException ex ){
            //BUG 115
            if (ex.getMessage().equals("Marshal error"))
                return;
        }
    }
    
    private class MyItemListener implements ItemListener, ActionListener, ListSelectionListener {

        public void itemStateChanged(ItemEvent ie) {
            if (ie.getItem() == smvControlModeAllRadio && !remoteList.getSelectionModel().isSelectionEmpty()) {
                remotes.getRemote(remoteList.getSelectionModel().getMinSelectionIndex()).getCollectiveMode().setVal(ie.getStateChange()==ItemEvent.SELECTED);
            }
        }

        public void actionPerformed(ActionEvent ae) {
            Object obj = ae.getSource();
            if (obj == searchButton) {
                int choice = JOptionPane.showConfirmDialog(null, "If you confirm this operation all the unsaved changes made until now will be discarded", "Are you sure you want to search for network remote SMVs?", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    remoteList.setModel(searchForRemotes());
                    smvControlList.setModel(createSmvListModel(-1));
                    refreshControlMode();
                }
            } else if (obj == configButton) {
                Remote remoto = remotes.getRemote(remoteList.getSelectionModel().getMinSelectionIndex());
                NetworkConfigDialog netConfigDialog = new NetworkConfigDialog(frame, remoto, idModulo);
                netConfigDialog.setLocationRelativeTo(RemotePanel.this);
                netConfigDialog.setVisible(true);
                if (!remoto.getDhcp().getVal()) {
                    String[] str = {remoto.getIpaddr().getVal(), remoto.getMac().getVal()};
                    remoteListModel.setElementAt(str, remoteList.getSelectionModel().getMinSelectionIndex());
                }
                
            } else if (obj == smvEditButton) {
                int remoteSelIndex = remoteList.getSelectionModel().getMinSelectionIndex();
                int smvSelIndex = smvControlList.getSelectionModel().getMinSelectionIndex();
                IpAddressCustomDialog ipAddrCD = new IpAddressCustomDialog(frame, "Edit SMV ip address", "Insert an ip address", remotes.getRemote(remoteSelIndex).getMvs().getMv(smvSelIndex).getVal());
                ipAddrCD.pack();
                ipAddrCD.setLocationRelativeTo(RemotePanel.this);
                ipAddrCD.setVisible(true);

                String ipAddr = ipAddrCD.getValidatedText();

                if (ipAddr!=null) {
                    remotes.getRemote(remoteSelIndex).getMvs().getMv(smvSelIndex).setVal(ipAddr);
                    smvControlList.setModel(createSmvListModel());
                    smvControlList.getSelectionModel().setSelectionInterval(smvSelIndex, smvSelIndex);
                }
            }
        }
        
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            
            if (lsm.getValueIsAdjusting()) return;
            
            if (remoteList.getSelectionModel() == lsm) {
                configButton.setEnabled(!lsm.isSelectionEmpty());
                if (!lsm.isSelectionEmpty()) {
                    smvControlList.setModel(createSmvListModel(lsm.getMinSelectionIndex()));
                    refreshControlMode();
                }
            } else if (smvControlList.getSelectionModel() == lsm) {
                smvEditButton.setEnabled(!lsm.isSelectionEmpty());
            }
        }
    }
}
