package dialogs.moduleproperties;

import bean.Port;
import bean.Ports;
import eccezioni.MVException;
import gui.components.JPanelBGGradient;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Antonio Mononucleotico
 */
public class ProtocolsSerialPanel extends JPanelBGGradient{

    private Ports bean;
    private int idModulo;
    private Frame frame;

    private JLabel serialPortsLabel;
    private JList serialPortsList;
    private DefaultListModel serialPortsListModel;

    private JButton configureButton;


    public ProtocolsSerialPanel(Ports bean , int idModulo, Frame frame) {

        setLayout(null);
        setBounds(1, 30, 400, 400);

        this.bean = bean;
        this.idModulo = idModulo;
        this.frame = frame;
        MyItemListener mIL = new MyItemListener();

        serialPortsLabel = new JLabel();
        serialPortsLabel.setText("Serial Ports");
        serialPortsLabel.setBounds(20, 20, 100, 20);
        add(serialPortsLabel);

        serialPortsList = new JList();
        reloadList();

        serialPortsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (bean.getPortCount()>0)
            serialPortsList.setSelectedIndex(0);
        serialPortsList.setBorder(BorderFactory.createLoweredBevelBorder());
        serialPortsList.getSelectionModel().addListSelectionListener(mIL);
        serialPortsList.setBounds(15, 45, 300, 200);
        JScrollPane sp = new JScrollPane();
        sp.setOpaque(true);
        sp.getViewport().add(serialPortsList);
        sp.setBounds(15, 45, 350, 200);
        add(sp);
       


        configureButton = new JButton();
        configureButton.setText("Configure");
        configureButton.addActionListener(mIL);
        configureButton.setBounds(145, 260, 90, 20);
        add(configureButton);



    }

    public void save() {
    }


    private void configureButton() throws MVException {
        int selectedIndex = serialPortsList.getSelectedIndex();

        if (selectedIndex > -1) {
            Port port = bean.getPort(selectedIndex);

            SerialPortsConfigureDialog configDialog = new SerialPortsConfigureDialog(frame, idModulo, port, this);
            configDialog.setLocationRelativeTo(ProtocolsSerialPanel.this);
            configDialog.setVisible(true);
            //new NGMServerEditDialog(frame, idModulo, ngmServer, true, this);
        }
    }

    private class MyItemListener implements ActionListener, ListSelectionListener {

        public void actionPerformed(ActionEvent ae) {
            Object obj = ae.getSource();
            if (obj == configureButton)
                try {
                configureButton();
            } catch (MVException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }

        }

        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            if (lsm.isSelectionEmpty()) {
                configureButton.setEnabled(false);
            } else {
                configureButton.setEnabled(true);
            }
        }
    }

    public void reloadList (){
        serialPortsListModel = new DefaultListModel();
        Iterator it = bean.iteratePort();
        while (it.hasNext()) {
            Port port = (Port)it.next();
            String portString = "Port ";
            portString += port.getId();
            portString += " - " + port.getProtocol().getVal();
            portString += " - " + port.getBaud().getVal();
            portString += "," + port.getParity().getVal().charAt(0);
            portString += "," + port.getBits().getVal();
            portString += "," + port.getStop().getVal();
            if (port.getController() != null) {
                if (port.getController().getVal() >= 0)
                    portString += " (Controlled by card in slot "
                            + port.getController().getVal() + ")";
            }
            serialPortsListModel.addElement(portString);
        }
        serialPortsList.setModel(serialPortsListModel);
    }
}
