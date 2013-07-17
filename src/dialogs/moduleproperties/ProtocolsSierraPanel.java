package dialogs.moduleproperties;

import bean.InSierra;
import bean.SierraRouter;
import gui.ComponentFactory;
import gui.components.IpAddressTextField;
import gui.components.JCheckBoxTransBG;
import gui.components.JDioSwitchInterface;
import gui.components.JDioTabbedPane;
import gui.components.JPanelBGGradient;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author panda
 */
public class ProtocolsSierraPanel extends JPanelBGGradient {

    SierraRouter bean;
    JCheckBox enabledCheck;
    JLabel ipAddrLabel;
    JTextField ipAddrField;
    JLabel portLabel;
    JTextField portField;
    JLabel routerLabel;
    JTable routerTable;
    MyTableModel tableModel;
    JLabel infoLabel;
    JButton allButton;

    ProtocolsSierraPanel(SierraRouter bean) {
        setLayout(null);
        setBounds(1, 30, 400, 400);

        this.bean = bean;
        MyItemListener mIL = new MyItemListener();

        enabledCheck = new JCheckBoxTransBG();
        enabledCheck.setText("Enabled");
        enabledCheck.setSelected(bean.getEnabled().getVal());
        enabledCheck.addItemListener(mIL);
        enabledCheck.setBounds(10, 20, 80, 20);
        add(enabledCheck);
        ipAddrLabel = new JLabel();
        ipAddrLabel.setText("IP Address");
        ipAddrLabel.setBounds(100, 20, 70, 20);
        add(ipAddrLabel);
        ipAddrField = new IpAddressTextField(false);
        ipAddrField.setText(bean.getIpaddr().getVal());
        ipAddrField.setBounds(170, 20, 110, 20);
        add(ipAddrField);
        portLabel = new JLabel();
        portLabel.setText("Port");
        portLabel.setBounds(290, 20, 30, 20);
        add(portLabel);
        portField = ComponentFactory.createTextField(bean.getTcpPort().getVal(), bean.getTcpPort().getMin(), bean.getTcpPort().getMax());
        portField.setBounds(320, 20, 45, 20);
        add(portField);

        routerLabel = new JLabel();
        routerLabel.setText("Physical connections from Router to Multiviewer");
        routerLabel.setBounds(50, 60, 320, 20);
        add(routerLabel);

        tableModel = new MyTableModel();
        routerTable = new JTable(tableModel);
        routerTable.getTableHeader().setReorderingAllowed(false);
        //settaggi per scroll
        routerTable.setPreferredScrollableViewportSize(new Dimension(300, 300));
        routerTable.setFillsViewportHeight(true);
        //larghezza celle
        routerTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        routerTable.getColumnModel().getColumn(1).setPreferredWidth(95);
        routerTable.getColumnModel().getColumn(2).setPreferredWidth(95);
        routerTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        //settaggi modalità di selezione
        routerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        routerTable.setRowSelectionAllowed(false);
        routerTable.setColumnSelectionAllowed(false);
        //imposto custom editor per alcune colonne
        routerTable.getColumnModel().getColumn(1).setCellEditor(new BoundedIntegerCellEditor(bean.getPhysMapInfo().getNumOuts().getVal()));
        routerTable.getColumnModel().getColumn(2).setCellEditor(new BoundedIntegerCellEditor(bean.getPhysMapInfo().getNumLvls().getVal()));
        routerTable.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
            }

            public void focusLost(FocusEvent e) {
                TableCellEditor tce = routerTable.getCellEditor();
                if (tce != null) {
                    if (!routerTable.getCellEditor().stopCellEditing()) {
                        //hackTabbedPane(false);
                        routerTable.requestFocusInWindow();
                    }
                }

            }
        });
        JScrollPane scrollPane = new JScrollPane(routerTable);
        scrollPane.setBounds(25, 85, 360, 280);
        add(scrollPane);

        infoLabel = new JLabel("");
        infoLabel.setForeground(Color.red);
        //infoLabel.setFont(infoLabel.getFont().deriveFont((float)11));
        infoLabel.setBounds(10, 365, 260, 30);
        add(infoLabel);
        allButton = new JButton();
        allButton.setText("All");
        allButton.addActionListener(mIL);
        allButton.setBounds(290, 370, 70, 20);
        add(allButton);

        hackTabbedPane();
        checkComponentEnablingConditions();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        hackTabbedPane();
    }



    void save() {
        bean.getEnabled().setVal(enabledCheck.isSelected());
        bean.getIpaddr().setVal(ipAddrField.getText());
        bean.getTcpPort().setVal(Integer.parseInt(portField.getText()));
        tableModel.save();
    }

    private void checkComponentEnablingConditions() {
        boolean enabled = enabledCheck.isSelected();
        ipAddrField.setEnabled(enabled);
        portField.setEnabled(enabled);
        //routerTable.setEnabled(enabled);
        //allButton.setEnabled(enabled);
    }

    private void hackTabbedPane() {
        Container cont = this.getParent();
        while (cont != null) {
            if (cont instanceof JDioTabbedPane) {
                JDioTabbedPane jdtp = (JDioTabbedPane) cont;
                jdtp.addTabSwitchHandler(new MyTabSwitchHandler());
            }
            cont = cont.getParent();
        }
    }

    private class MyItemListener implements ItemListener, ActionListener {

        public void itemStateChanged(ItemEvent ie) {
            checkComponentEnablingConditions();
        }

        public void actionPerformed(ActionEvent ae) {
            Object obj = ae.getSource();
            if (obj == allButton) {
                tableModel.switchAllCheckbox();
            }
        }
    }

    private class MyTableModel extends AbstractTableModel {

        Object[][] data;
        String[] columnHeaders = {"MV Input", "Router Output", "Router Level", "Connected"};
        int maxIns;

        public MyTableModel() {
            maxIns = bean.getPhysMapInfo().getNumInsSierra().getVal();
            data = new Object[maxIns][4];
            Iterator it = bean.getPhysIns().iterateInSierra();
            for (int i = 0; i < maxIns && it.hasNext(); i++) {
                InSierra in = (InSierra) it.next();
                data[i][0] = new Integer(in.getId());
                data[i][1] = new Integer(in.getOut());
                data[i][2] = new Integer(in.getLvl());
                data[i][3] = new Boolean(in.getEn());
            }
        }

        public int getColumnCount() {
            return columnHeaders.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnHeaders[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public Class getColumnClass(int c) {
            //System.out.println("column "+c+": "+getValueAt(0, c).getClass().toString());
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 1) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }

        public void switchAllCheckbox() {
            boolean isAllTrue = true;

            for (int i = 0; i < data.length && isAllTrue; i++) {
                isAllTrue = isAllTrue && (Boolean) data[i][3];
            }

            for (int i = 0; i < data.length; i++) {
                data[i][3] = new Boolean(!isAllTrue);
            }

            fireTableDataChanged();
        }

        private void save() {
            bean.getPhysIns().removeAllInSierra();
            for (int i = 0; i < maxIns; i++) {
                InSierra in = new InSierra();
                in.setId(((Integer) data[i][0]).intValue());
                in.setOut(((Integer) data[i][1]).intValue());
                in.setLvl(((Integer) data[i][2]).intValue());
                in.setEn(((Boolean) data[i][3]).booleanValue());
                bean.getPhysIns().addInSierra(in);
            }
        }
    }

    private class BoundedIntegerCellEditor extends DefaultCellEditor {

        Integer value;
        int maxVal;
        String message;

        public BoundedIntegerCellEditor(int maxVal) {
            super(new JTextField());
            //getComponent().setName("Table.editor");
            ((JTextField) getComponent()).setHorizontalAlignment(JTextField.RIGHT);

//            ((JTextField)getComponent()).setInputVerifier(new InputVerifier() {
//
//                @Override
//                public boolean verify(JComponent input) {
//                    if (checkValue(((JTextField)input).getText())) {
//                        return true;
//                    } else {
//                        input.setBorder(new LineBorder(Color.red));
//                        Toolkit.getDefaultToolkit().beep();
//
//                        //Pop up the message dialog.
//                        JOptionPane.showMessageDialog(null, //no owner frame
//                                                  message, //text to display
//                                                  "Invalid Value", //title
//                                                  JOptionPane.WARNING_MESSAGE);
//
//                        return false;
//                    }
//                }
//            });
            this.maxVal = maxVal;
        }

        public boolean stopCellEditing() {

            String s = (String) super.getCellEditorValue();
//            value = Integer.parseInt(s);
//            if (1==1) return super.stopCellEditing();
            // Here we are dealing with the case where a user
            // has deleted the string value in a cell, possibly
            // after a failed validation. Return null, so that
            // they have the option to replace the value with
            // null or use escape to restore the original.
            // For Strings, return "" for backward compatibility.
	    /*if ("".equals(s)) {
            if (constructor.getDeclaringClass() == String.class) {
            value = s;
            }
            super.stopCellEditing();
            }*/

            if (checkValue(s)) {
                //hackTabbedPane(true);
                value = Integer.parseInt(s);
                infoLabel.setText("");
                return super.stopCellEditing();
            } else {
                //hackTabbedPane(false);
                ((JComponent) getComponent()).setBorder(new LineBorder(Color.red));

                Toolkit.getDefaultToolkit().beep();

//                //Pop up the message dialog.
//                JOptionPane.showMessageDialog(null, //no owner frame
//                                          message, //text to display
//                                          "Invalid Value", //title
//                                          JOptionPane.WARNING_MESSAGE);
                infoLabel.setText(message);
                return false;
            }
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected,
                int row, int column) {
            this.value = null;
            ((JComponent) getComponent()).setBorder(new LineBorder(Color.black));
            return super.getTableCellEditorComponent(table, value, isSelected, row, column);
        }

        public Object getCellEditorValue() {
            return value;
        }

        private boolean checkValue(String strValue) {
            int intValue;
            //Parse the value.
            try {
                intValue = Integer.parseInt(strValue);
            } catch (NumberFormatException nfe) {
                message = "<html>Please insert an integer value <br>or press esc to restore previous value</html>";
                return false;
            }

            //Value was invalid.
            if ((intValue < 1) || (intValue > maxVal)) {
                if (intValue < 1) {
                    message = "<html>Please insert an integer value greater than 0 <br>or press esc to restore previous value<html>";
                } else { //amount is greater than MAX_AMOUNT
                    message = "<html>Please insert an integer value lower than " + (maxVal + 1) + " <br>or press esc to restore previous value</html>";
                }
                return false;
            }

            message = "";
            return true;
        }
    }

    class MyTabSwitchHandler implements JDioSwitchInterface{

        public boolean shouldSwitchTab() {
            TableCellEditor tce =  routerTable.getCellEditor();
            if ( tce != null ){
                return tce.stopCellEditing();
            }
            else
                return true;
//            return false;
        }

    }

}
