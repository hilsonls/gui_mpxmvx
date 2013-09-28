package dialogs.moduleproperties;

import bean.SnellRouter;
import bean.SnellController;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.ChangeListenerColorHandled;
import gui.components.IpAddressTextField;
import gui.components.JCheckBoxTransBG;
import gui.components.JDioTabbedPane;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import controllori.CtrlWorkspace;

public class ProtocolsSnellPanel extends JPanelBGGradient{
    private SnellRouter bean;
    private int idModulo;
    private Frame frame;

    private JLabel controllerLabel;
    private JList<String> controllerList;
    private DefaultListModel<String> controllerListModel;
    private JButton newControllerButton;
    private JButton editControllerButton;
    private JButton deleteControllerButton;
    
    private JTabbedPane tabbedPane;

    private ProtocolsSnellMatrixPanel protSnellVideoPanel;
    private ProtocolsSnellMatrixPanel protSnellAudioPanel;
    private ProtocolsSnellMatrixPanel protSnellDataxxPanel;
    
    private JComboBox<Object> controllerCombo;
    
    private SnellController editedSnellController;

    private final String strDefaultController = "Serial Port";

    public ProtocolsSnellPanel(SnellRouter bean, int idModulo, Frame frame) throws MVException {
        setLayout(null);

        this.bean = bean;
        this.idModulo = idModulo;
        this.frame = frame;
        
        editedSnellController = null;
        
        controllerCombo = new JComboBox<Object>();  // gets options assigned in reloadControllerList method

        MyItemListener mIL = new MyItemListener();

        controllerLabel = new JLabel();
        controllerLabel.setText("Controllers");
        controllerLabel.setBounds(5, 5, 70, 20);
        add(controllerLabel);
        controllerList = new JList<String>();
        reloadControllerList();
        controllerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        controllerList.setBorder(BorderFactory.createLoweredBevelBorder());
        controllerList.getSelectionModel().addListSelectionListener(mIL);
        controllerList.setBounds(5, 25, 340, 90);
        JScrollPane controllerListScroll = new JScrollPane();
        controllerListScroll.setOpaque(true);
        controllerListScroll.getViewport().add(controllerList);
        controllerListScroll.setBounds(5, 25, 340, 90);
        add(controllerListScroll);
        
        newControllerButton = new JButton();
        newControllerButton.setText("New");
        newControllerButton.addActionListener(mIL);
        newControllerButton.setBounds(350, 30, 90, 20);
        add(newControllerButton);

        editControllerButton = new JButton();
        editControllerButton.setText("Edit");
        editControllerButton.addActionListener(mIL);
        editControllerButton.setBounds(350, 60, 90, 20);
        add(editControllerButton);

        deleteControllerButton = new JButton();
        deleteControllerButton.setText("Delete");
        deleteControllerButton.addActionListener(mIL);
        deleteControllerButton.setBounds(350, 90, 90, 20);
        add(deleteControllerButton);

        protSnellVideoPanel = new ProtocolsSnellMatrixPanel(bean.getSnellVideoMatrix(), controllerCombo);
        protSnellAudioPanel = new ProtocolsSnellMatrixPanel(bean.getSnellAudioMatrix(), controllerCombo);
        protSnellDataxxPanel = new ProtocolsSnellMatrixPanel(bean.getSnellDataxxMatrix(), controllerCombo);
        
        tabbedPane = new JDioTabbedPane();
        tabbedPane.setUI(new BasicTabbedPaneUI());
        tabbedPane.setBackground(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor());
        tabbedPane.addChangeListener(new ChangeListenerColorHandled(StyleInterface.getInstance().getPropertiesTabbedPaneBackgroundColor(), StyleInterface.getInstance().getTabbedPaneForegroundColor()));
        tabbedPane.setBounds(5, 120, 440, 375);
        tabbedPane.add(protSnellVideoPanel);
        tabbedPane.setTitleAt(0, "Video Router");
        tabbedPane.add(protSnellAudioPanel);
        tabbedPane.setTitleAt(1, "Ext Audio Router");
        tabbedPane.add(protSnellDataxxPanel);
        tabbedPane.setTitleAt(2, "Data-xx Router");
        tabbedPane.setSelectedComponent(protSnellVideoPanel);
        add(tabbedPane);

        updateEditDeleteEnabled();
    }

    public void save() {
        protSnellVideoPanel.save();
        protSnellDataxxPanel.save();
        protSnellAudioPanel.save();
        
    }

    private void newControllerButton() {
        try{
            editedSnellController = CtrlWorkspace.getInstance().newSnellController(idModulo);
            controllerListModel.addElement(editedSnellController.getName());
            controllerList.setSelectedIndex(controllerListModel.size()-1);
            new SnellControllerEditDialog(frame, idModulo, editedSnellController, false, this);
            editedSnellController = null;
        } catch (MVException mve) {
            JOptionPane.showMessageDialog(null, "An error has occurred while adding a snell router controller.", "Operation aborted", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void editControllerButton() {
        int selectedIndex = controllerList.getSelectedIndex();
        
        if (selectedIndex >= 0) {
            editedSnellController = bean.getSnellController(selectedIndex);
            new SnellControllerEditDialog(frame, idModulo, editedSnellController, true, this);
            editedSnellController = null;
        }
    }
    
    private void deleteControllerButton() {
        int selectedIndex = controllerList.getSelectedIndex();
        
        if (selectedIndex >= 0) {
            try {
                SnellController controller = bean.getSnellController(selectedIndex);

                int choice = JOptionPane.showConfirmDialog(null, "Delete controller \"" + controller.getName() + "\"?", "Delete controller", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    CtrlWorkspace.getInstance().removeSnellController(idModulo, controller.getId());
                    controllerListModel.remove(selectedIndex);
                    if (controllerListModel.size() > 0) {
                        if (selectedIndex > 0) {
                            selectedIndex--;
                        }
                        controllerList.setSelectedIndex(selectedIndex);
                    }
                }
            } catch (MVException mve) {
                JOptionPane.showMessageDialog(null, "An error has occurred while deleting selected Snell controller", "Operation aborted", JOptionPane.ERROR_MESSAGE);
            }
            reloadControllerCombo();
        }
    }

    private class MyItemListener implements ActionListener, ListSelectionListener {

        public void actionPerformed(ActionEvent ae) {
            Object obj = ae.getSource();
            if (obj == newControllerButton) {
            	newControllerButton();
            } else if (obj == editControllerButton) {
                editControllerButton();
            } else if (obj == deleteControllerButton) {
                deleteControllerButton();
            } else if (obj == controllerList) {
                updateEditDeleteEnabled();
            }
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            updateEditDeleteEnabled();
        }

    }
    
    public void reloadControllerList (){
        controllerListModel = new DefaultListModel<String>();
        Iterator<SnellController> it = bean.iterateSnellController();
        while (it.hasNext()) {
            SnellController controller = it.next();
            String s;
            s = controller.getName() + ": "
                    + controller.getIpaddr1() + ":" + Integer.toString(controller.getPort1());
            String sip2 = controller.getIpaddr2();
            if (!sip2.equals("0.0.0.0") && !sip2.isEmpty()) {
                s = s + "; " + sip2 + ":" + Integer.toString(controller.getPort2());
            }
            controllerListModel.addElement(s);
        }
        controllerList.setModel(controllerListModel);
        reloadControllerCombo();
    }
    
    private void reloadControllerCombo() {
        boolean isChildUpdateNeeded = (protSnellVideoPanel != null);
        JComboBox<Object> origCombo = new JComboBox<Object>();
        
        /*
         * Create a copy of current combo so that changed names can be updated
         * in the controller column afterwards
         */
        if (isChildUpdateNeeded) {
            for (int i = 0; i < controllerCombo.getItemCount(); i++) {
                origCombo.addItem(controllerCombo.getItemAt(i));
            }
        }
        
        /*
         * Rebuild the combo contents
         */
        controllerCombo.removeAllItems();
        Iterator<SnellController> it = bean.iterateSnellController();
        while (it.hasNext()) {
            SnellController controller = it.next();
            controllerCombo.addItem(makeComboItem(controller.getId(), controller.getName()));
        }
        controllerCombo.addItem(makeComboItem(-1, strDefaultController));

        /*
         * Update any changed names in the controller column
         */
        if (isChildUpdateNeeded) {
            for (int i = 0; i < origCombo.getItemCount() 
                    && i < controllerCombo.getItemCount(); i++) {
                String s1 = origCombo.getItemAt(i).toString();
                boolean update = true;
                for (int j = 0; j < controllerCombo.getItemCount(); j++) {
                    String s = controllerCombo.getItemAt(j).toString();
                    if (s1.equals(s)) {
                        update = false;
                        break;
                    }
                }
                
                if (update) {
                    String s2;
                    if (origCombo.getItemCount() <= controllerCombo.getItemCount()) {
                        s2 = controllerCombo.getItemAt(i).toString();
                    } else {
                        s2 = strDefaultController;
                    }
                    protSnellVideoPanel.updateControllerName(s1, s2);
                    protSnellAudioPanel.updateControllerName(s1, s2);
                    protSnellDataxxPanel.updateControllerName(s1, s2);
                }
            }
            
            for (int i = controllerCombo.getItemCount(); i < origCombo.getItemCount(); i++) {
                String s = origCombo.getItemAt(i).toString();
                protSnellVideoPanel.updateControllerName(s, strDefaultController);
                protSnellAudioPanel.updateControllerName(s, strDefaultController);
                protSnellDataxxPanel.updateControllerName(s, strDefaultController);
            }
        }
    }
    
    private Object makeComboItem(final int id, final String item) {
        return new Object() {
            @Override
            public String toString() {
                return item;
            }
            
            @Override
            public int hashCode() {
                return id;
            }
        };
    }
    
    private void updateEditDeleteEnabled() {
        boolean en = controllerList.getSelectedIndex() >= 0 ? true : false;
        editControllerButton.setEnabled(en);
        deleteControllerButton.setEnabled(en);
    }
    
    /**
     * Verify that a controller's name is valid
     * @param name          proposed name of the controller
     * @throws MVException if name is not valid
     * This checks the name given against all existing controller names to
     * confirm there are no duplicates 
     */
    public void verifyControllerName(final String name) throws MVException {
        Iterator<SnellController> it = bean.iterateSnellController();
        while (it.hasNext()) {
            SnellController controller = it.next();
            if (controller != editedSnellController) {
                if (controller.getName().equals(name)) {
                    throw new MVException("Controller with name \"" + name + "\" already exists");
                }
            }
        }
   }
}