package dialogs.moduleproperties;

import bean.AudioSnell;
import bean.SnellAudioIn;
import gui.components.JDioSwitchInterface;
import gui.components.JDioTabbedPane;
import gui.components.JPanelBGGradient;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Antonio
 */
public class ProtocolsSnellAudioPanel extends JPanelBGGradient {

    AudioSnell bean;

    JLabel routerLabel;
    JTable routerTable;
    MyTableModel tableModel;
    JLabel infoLabel;
    JButton allButton;
    private boolean copied = false;
    private int copiedValue = 0;

    ProtocolsSnellAudioPanel(AudioSnell bean) {
        setLayout(null);
        setBounds(1, 30, 430, 400);

        this.bean = bean;
        MyItemListener mIL = new MyItemListener();



        routerLabel = new JLabel();
        routerLabel.setText("Connections from Router to Multiviewer");
        routerLabel.setBounds(50, 10, 300, 20);
        add(routerLabel);

        tableModel = new MyTableModel();
        routerTable = new JTable(tableModel);
        routerTable.getTableHeader().setReorderingAllowed(false);
        //settaggi per scroll
        routerTable.setPreferredScrollableViewportSize(new Dimension(300, 300));
        routerTable.setFillsViewportHeight(true);
        //larghezza celle
        routerTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        routerTable.getColumnModel().getColumn(1).setPreferredWidth(65);
        routerTable.getColumnModel().getColumn(2).setPreferredWidth(70);
        routerTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        routerTable.getColumnModel().getColumn(4).setPreferredWidth(85);
        routerTable.getColumnModel().getColumn(5).setPreferredWidth(75);
        //settaggi modalità di selezione
        routerTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        routerTable.setRowSelectionAllowed(true);
        routerTable.setColumnSelectionAllowed(true);
        //imposto custom editor per alcune colonne
        routerTable.getColumnModel().getColumn(1).setCellEditor(new BoundedIntegerCellEditor(bean.getAudioPhysMapInfo().getAudioPhysMapInfoNumMats().getMin(),bean.getAudioPhysMapInfo().getAudioPhysMapInfoNumMats().getMax()));
        routerTable.getColumnModel().getColumn(2).setCellEditor(new BoundedIntegerCellEditor(bean.getAudioPhysMapInfo().getAudioPhysMapInfoNumLvls().getMin(),bean.getAudioPhysMapInfo().getAudioPhysMapInfoNumLvls().getMax()));
        routerTable.getColumnModel().getColumn(3).setCellEditor(new BoundedIntegerCellEditor(bean.getAudioPhysMapInfo().getAudioPhysMapInfoNumOuts().getMin(),bean.getAudioPhysMapInfo().getAudioPhysMapInfoNumOuts().getMax()));
        routerTable.getColumnModel().getColumn(4).setCellEditor(new BoundedIntegerCellEditor(bean.getAudioPhysMapInfo().getAudioPhysMapInfoNumDass().getMin(),bean.getAudioPhysMapInfo().getAudioPhysMapInfoNumDass().getMax()));
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

        routerTable.addMouseListener(new MouseAdapter() {

            private void maybeShowPopup(MouseEvent e, boolean showDeviceAttributes) {
                if (e.isPopupTrigger() && isEnabled()) {
                    Point p = new Point(e.getX(), e.getY());
                    int row = routerTable.rowAtPoint(p);
                    int col = routerTable.columnAtPoint(p);

                    int mrow = routerTable.convertRowIndexToModel(row);
                    int mcol = routerTable.convertColumnIndexToModel(col);

                    if (row >= 0 && row < routerTable.getRowCount()) {

                        JPopupMenu contextMenu = createContextMenu(mrow, mcol);

                        if (contextMenu != null && contextMenu.getComponentCount() > 0) {
                            //routerTable.changeSelection(mrow, mcol, false, false);
                            contextMenu.show(routerTable, p.x, p.y);

                        }
                    }
                }
            }

            public void mousePressed(MouseEvent e) {
                maybeShowPopup(e, false);
            }

            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e, true);
            }
        });
        JScrollPane scrollPane = new JScrollPane(routerTable);
        scrollPane.setBounds(5, 35, 425, 280);
        add(scrollPane);

        infoLabel = new JLabel("");
        infoLabel.setForeground(Color.red);
        //infoLabel.setFont(infoLabel.getFont().deriveFont((float)11));
        infoLabel.setBounds(5, 315, 330, 30);
        add(infoLabel);
        allButton = new JButton();
        allButton.setText("All");
        allButton.addActionListener(mIL);
        allButton.setBounds(322, 315, 100, 37);
        allButton.setText((tableModel.checkAllCheckbox())?"<html><center>Connect<br>All</center></html>":"<html><center>Disconnect<br>All</center></html>");
        add(allButton);

        hackTabbedPane();
    }

    private JPopupMenu createContextMenu(final int rowIndex, final int colIndex) {
        JPopupMenu contextMenu = new JPopupMenu();


//        JLabel titleMenu = new JLabel();
//        titleMenu.setText("Menu");
////        titleMenu.setIcon(ConfiguratoreSARAGUI.devicesIconsMap.get(((Categories) getModel().getValueAt(rowIndex, 0)).getId()));
////        titleMenu.setIconTextGap(8);
////        titleMenu.setFont(getFont().deriveFont(Font.BOLD));
//
//        contextMenu.add(titleMenu);
//        contextMenu.add(new JPopupMenu.Separator());

        JMenuItem menuItemAction = new JMenuItem();
        menuItemAction.setText("Copy");
        menuItemAction.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Integer idDevice = (Integer) routerTable.getModel().getValueAt(rowIndex, colIndex);
                copiedValue = idDevice;
                //System.out.println("Copied: "+copiedValue);
                copied = true;
                routerTable.changeSelection(rowIndex, colIndex, false, false);
                //JOptionPane.showMessageDialog(null, "DELETED " + idDevice + " DEVICE");
                }
        });
        JMenuItem menuItemAction2 = new JMenuItem();
        menuItemAction2.setText("Paste value "+copiedValue);
        menuItemAction2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Get the min and max ranges of selected cells
                int rowIndexStart = routerTable.getSelectedRow();
                int rowIndexEnd = routerTable.getSelectionModel().getMaxSelectionIndex();
                int colIndexStart = routerTable.getSelectedColumn();
                int colIndexEnd = routerTable.getColumnModel().getSelectionModel().getMaxSelectionIndex();

                // Check each cell in the range
                for (int r = rowIndexStart; r <= rowIndexEnd; r++) {
                    for (int c = colIndexStart; c <= colIndexEnd; c++) {
                        if (routerTable.isCellSelected(r, c)) {

                            if (((BoundedIntegerCellEditor) routerTable.getColumnModel().getColumn(c).getCellEditor()).checkValue(String.valueOf(copiedValue), false)) {
                                routerTable.getModel().setValueAt(copiedValue, r, c);
                            } else {
                                infoLabel.setText(((BoundedIntegerCellEditor) routerTable.getColumnModel().getColumn(colIndex).getCellEditor()).message);
                                break;
                            }
                        }
                    }
                }



                //System.out.println("Pasted: "+copiedValue);
                //JOptionPane.showMessageDialog(null, "DELETED " + idDevice + " DEVICE");
                }
        });


//        menuItemAction.setIcon(ConfiguratoreSARAMain.getApplication().getContext().getResourceMap().getIcon("del.png"));
//        menuItemAction.setIconTextGap(8);
//        menuItemAction.setFont(getFont().deriveFont(Font.BOLD));

        contextMenu.add(menuItemAction);
        if (copied) {
            contextMenu.add(menuItemAction2);
        }


        return contextMenu;
    }

    @Override
    public void addNotify() {
        super.addNotify();
        hackTabbedPane();
    }



    void save() {

        tableModel.save();
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

    private class MyItemListener implements ActionListener {


        public void actionPerformed(ActionEvent ae) {
            Object obj = ae.getSource();
            if (obj == allButton) {
                tableModel.switchAllCheckbox();
            }
        }
    }

    private class MyTableModel extends AbstractTableModel {

        Object[][] data;
        String[] columnHeaders = {"<html><center>MV<br>Input</center></html>", "<html><center>Matrix<br>Number</center></html>", "<html><center>Matrix<br>Level</center></html>", "<html><center>Router<br>Destination</center></html>", "<html><center>Destination<br>Association</center></html>","<html><center>Connected</center></html>"};
        int maxIns;

        public MyTableModel() {
            maxIns = bean.getAudioPhysMapInfo().getAudioPhysMapInfoNumIns().getVal();
            data = new Object[maxIns][6];
            Iterator it = bean.getAudioPhysIns().iterateSnellAudioIn();
            for (int i = 0; i < maxIns && it.hasNext(); i++) {
                SnellAudioIn in = (SnellAudioIn) it.next();
                data[i][0] = new Integer(in.getId());
                data[i][1] = new Integer(in.getMat());
                data[i][2] = new Integer(in.getLvl());
                data[i][3] = new Integer(in.getOut());
                data[i][4] = new Integer(in.getDass());
                data[i][5] = new Boolean(in.getEn());
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

        public boolean checkAllCheckbox(){
            boolean isAllTrue = true;

            for (int i = 0; i < data.length && isAllTrue; i++) {
                isAllTrue = isAllTrue && (Boolean) data[i][5];
            }
            return !isAllTrue;
        }

        public void switchAllCheckbox() {
            boolean isAllTrue = true;

            for (int i = 0; i < data.length && isAllTrue; i++) {
                isAllTrue = isAllTrue && (Boolean) data[i][5];
            }

            for (int i = 0; i < data.length; i++) {
                data[i][5] = new Boolean(!isAllTrue);
            }
            allButton.setText((isAllTrue)?"<html><center>Connect<br>All</center></html>":"<html><center>Disconnect<br>All</center></html>");
            fireTableDataChanged();
        }

        private void save() {
            bean.getAudioPhysIns().removeAllSnellAudioIn();
            for (int i = 0; i < maxIns; i++) {
                SnellAudioIn in = new SnellAudioIn();
                in.setId(((Integer) data[i][0]).intValue());
                in.setMat(((Integer) data[i][1]).intValue());
                in.setLvl(((Integer) data[i][2]).intValue());
                in.setOut(((Integer) data[i][3]).intValue());
                in.setDass(((Integer) data[i][4]).intValue());
                in.setEn(((Boolean) data[i][5]).booleanValue());
                bean.getAudioPhysIns().addSnellAudioIn(in);
            }
        }
    }

   private class BoundedIntegerCellEditor extends DefaultCellEditor {

        Integer value;
        int maxVal;
        int minVal;
        String message;

        public BoundedIntegerCellEditor(int minVal, int maxVal) {
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
            this.minVal = minVal;
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

            if (checkValue(s, true)) {
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

            Component c = super.getTableCellEditorComponent(table, value, isSelected, row, column);
            if (c instanceof JTextComponent) {
                JTextComponent jtc = (JTextComponent) c;
                jtc.requestFocus();
                jtc.selectAll();
            }
            return c;

        }

        public Object getCellEditorValue() {
            return value;
        }

        private boolean checkValue(String strValue, boolean esc) {
            int intValue;
            //Parse the value.
            try {
                intValue = Integer.parseInt(strValue);
            } catch (NumberFormatException nfe) {
                message = "<html>Please insert an integer value <br>or press esc to restore previous value</html>";
                return false;
            }

            //Value was invalid.
            if ((intValue < minVal) || (intValue > maxVal)) {
                if (intValue < minVal) {
                    message = "<html>Please insert an integer value greater than " + (minVal + 1) + ((esc) ? " <br>or press esc to restore previous value<html>" : "");
                } else { //amount is greater than MAX_AMOUNT
                    message = "<html>Please insert an integer value lower than " + (maxVal + 1) + ((esc) ? " <br>or press esc to restore previous value</html>" : "");
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
