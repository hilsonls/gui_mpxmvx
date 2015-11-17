package dialogs.moduleproperties;

import bean.Tab;
import bean.Tsl;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Michael
 */
public class ProtocolsTslPanel extends JPanelBGGradient{

    private Tsl bean;
    private int idModulo;
    private Frame frame;

    private JPanelBGGradient ipPanel;
    private JCheckBoxTransBG ipCheck;
    private JLabel ipPortLabel;
    private JTextField ipPortText;
    
    private JPanelBGGradient addrPanel;
    private JRadioButton addrModeSourceNumberRadio;
    private JRadioButton addrModeSourceNameRadio;
    private JCheckBoxTransBG addrOffsetCheck;
    private JLabel addrOffsetLabel;
    private JTextField addrOffsetText;
    private JRadioButton addrModeCustomRadio;
    private ButtonGroup addrModeButtonGroup;
    private JLabel addrExampleLabel[];
    
    private AddrMatrixPanel addrMatrixPanel;
    
    private boolean readyToUpdate;
    
    private MyItemListener mIL;
    
    public ProtocolsTslPanel(Tsl bean , int idModulo, Frame frame) {
        readyToUpdate = false;
        
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);

        this.bean = bean;
        this.idModulo = idModulo;
        this.frame = frame;
        
        mIL = new MyItemListener();
        
        ipPanel = new JPanelBGGradient();
        ipPanel.setOpaque(false);
        VGroupLayout ipLayout = new VGroupLayout(ipPanel);
        ipPanel.setLayout(ipLayout);
        ipPanel.setBorder(new TitledBorder("TSL over IP"));

        ipCheck = new JCheckBoxTransBG("Enable UDP/IP");
        ipCheck.setSelected(bean.getIp());
        ipCheck.addItemListener(mIL);
        ipPortLabel = new JLabel("UDP Port");
        ipPortText = ComponentFactory.createTextField(bean.getPort(), 1, 65535);
        ipLayout.add(ipCheck);
        ipLayout.addRow(new Component[] {ipPortLabel, ipPortText});
        layout.add(ipPanel);
        
        addrPanel = new JPanelBGGradient();
        addrPanel.setOpaque(false);
        VGroupLayout addrLayout = new VGroupLayout(addrPanel);
        addrPanel.setLayout(addrLayout);
        addrPanel.setBorder(new TitledBorder("TSL addressing"));
        
        addrModeSourceNumberRadio = new JRadioButton("Use input number as the address");
        addrModeSourceNumberRadio.setOpaque(false);
        addrModeSourceNumberRadio.addItemListener(mIL);
        addrModeSourceNameRadio = new JRadioButton("Use source name as the address");
        addrModeSourceNameRadio.setOpaque(false);
        addrModeSourceNameRadio.addItemListener(mIL);
        addrModeCustomRadio = new JRadioButton("Use custom addressing");
        addrModeCustomRadio.setOpaque(false);
        addrModeCustomRadio.addItemListener(mIL);
        addrModeButtonGroup = new ButtonGroup();
        addrModeButtonGroup.add(addrModeSourceNumberRadio);
        addrModeButtonGroup.add(addrModeSourceNameRadio);
        addrModeButtonGroup.add(addrModeCustomRadio);
        addrOffsetCheck = new JCheckBoxTransBG("Apply offset to the address");
        addrOffsetCheck.addItemListener(mIL);
        addrOffsetCheck.setSelected(bean.getAddrOffset() != 0);
        addrOffsetLabel = new JLabel("Offset");
        addrOffsetText = ComponentFactory.createTextField(bean.getAddrOffset(), -65536, 65536);
        addrOffsetText.getDocument().addDocumentListener(new AddrOffsetDocumentListener());
        addrExampleLabel = new JLabel[2];
        addrExampleLabel[0] = new JLabel();
        addrExampleLabel[1] = new JLabel();
        addrLayout.add(addrModeSourceNumberRadio);
        addrLayout.add(addrModeSourceNameRadio);
        addrLayout.add(addrModeCustomRadio);
        addrLayout.addRow(new Component[] {addrOffsetCheck, addrOffsetLabel, addrOffsetText});
        addrLayout.add(addrExampleLabel[0]);
        addrLayout.add(addrExampleLabel[1]);
        addrModeSourceNumberRadio.setSelected(bean.getAddrMode() == 0);
        addrModeSourceNameRadio.setSelected(bean.getAddrMode() == 1);
        addrModeCustomRadio.setSelected(bean.getAddrMode() != 0 && bean.getAddrMode() != 1);
        layout.add(addrPanel);
        
        addrMatrixPanel = new AddrMatrixPanel();
        layout.add(addrMatrixPanel);
        
        readyToUpdate = true;
        updateVisibility();
    }

    public void save() {
        int port;
        int addrOffs;
        
        try {
            port = Integer.parseInt(ipPortText.getText());
        } catch (NumberFormatException ex) {
            port = 0;
        }
        
        try {
            addrOffs = Integer.parseInt(addrOffsetText.getText());
        } catch (NumberFormatException ex) {
            addrOffs = 0;
        }
        
        bean.setIp(ipCheck.isSelected());
        bean.setPort(port);
        bean.setAddrMode(addrModeSourceNumberRadio.isSelected() ? 0 :
            addrModeSourceNameRadio.isSelected() ? 1 : 2);
        bean.setAddrOffset(addrOffsetCheck.isSelected() ? addrOffs : 0);
        addrMatrixPanel.save();
    }

    private void updateVisibility()
    {
        if (!readyToUpdate)
            return;
        
        boolean isIp = ipCheck.isSelected();
        boolean useCustom = addrModeCustomRadio.isSelected();
        boolean isOffset = addrOffsetCheck.isSelected();

        ipPortLabel.setEnabled(isIp);
        ipPortText.setEnabled(isIp);
        
        addrOffsetCheck.setVisible(!useCustom);
        addrOffsetLabel.setVisible(!useCustom);
        addrOffsetText.setVisible(!useCustom);
        addrOffsetLabel.setEnabled(!useCustom && isOffset);
        addrOffsetText.setEnabled(!useCustom && isOffset);
        addrExampleLabel[0].setVisible(!useCustom);
        addrExampleLabel[1].setVisible(!useCustom);
        addrMatrixPanel.setVisible(useCustom);
        if (!useCustom)
            updateExampleOffset();
    }
    
    private void updateExampleOffset()
    {
        if (!readyToUpdate)
            return;

        int tslAddr;
        int videoInput = 1;
        if (addrOffsetCheck.isSelected()) {
            try {
                tslAddr = Integer.parseInt(addrOffsetText.getText());
            } catch (NumberFormatException ex) {
                tslAddr = 0;
            }
        } else {
            tslAddr = 0;
        }
        if (tslAddr < 0) {
            videoInput += -tslAddr;
            tslAddr = 0;
        }
        
        String s0;
        String s1;
        
        if (addrModeSourceNameRadio.isSelected()) {
            s0 = "<html><i>TSL address " + tslAddr + " changes UMDs with sources containing \"UMD" + videoInput + "\" in their name,</html>";
            s1 = "<html><i>TSL address " + (tslAddr+1) + " changes UMDs with sources containing \"UMD" + (videoInput+1) + "\" in their name etc...</html>";
        } else {
            s0 = "<html><i>TSL address " + tslAddr + " changes UMDs on video input " + videoInput + ",</html>";
            s1 = "<html><i>TSL address " + (tslAddr+1) + " changes UMDs on video input " + (videoInput+1) + " etc...</html>";
        }
        addrExampleLabel[0].setText(s0);
        addrExampleLabel[1].setText(s1);
    }
    
    private class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            updateVisibility();
        }
    }

    private class AddrOffsetDocumentListener implements DocumentListener {

        @Override
        public void changedUpdate(DocumentEvent arg0) {
            updateExampleOffset();
        }

        @Override
        public void insertUpdate(DocumentEvent arg0) {
            updateExampleOffset();
        }

        @Override
        public void removeUpdate(DocumentEvent arg0) {
            updateExampleOffset();
        }
    }
    
    private class AddrMatrixPanel extends JPanelBGGradient {
        private static final int COL_MV_INPUT = 0;
        private static final int COL_TSL_ADDR = 1;
        private static final int NUM_COLS = 2;
        
        private MyTableModel tableModel;
        private JTable addressTable;
        private JLabel infoLabel;
        
        AddrMatrixPanel() {
            VGroupLayout layout = new VGroupLayout(this);
            setLayout(layout);
            
            tableModel = new MyTableModel();
            addressTable = new JTable(tableModel);
            addressTable.getTableHeader().setReorderingAllowed(false);
            addressTable.setFillsViewportHeight(true);
            addressTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            addressTable.setRowSelectionAllowed(true);
            addressTable.setColumnSelectionAllowed(true);
            addressTable.getColumnModel().getColumn(COL_TSL_ADDR).setCellEditor(new BoundedIntegerCellEditor(-1, 126));
            addressTable.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent arg0) {
                }

                @Override
                public void focusLost(FocusEvent arg0) {
                    TableCellEditor tce = addressTable.getCellEditor();
                    if (tce != null) {
                        if (!addressTable.getCellEditor().stopCellEditing()) {
                            addressTable.requestFocusInWindow();
                        }
                    }
                }
                
            });
            
            JScrollPane scrollPane = new JScrollPane(addressTable);
            layout.add(scrollPane);
            
            infoLabel = new JLabel();
            restoreDefaultInfoLabel();
            layout.add(infoLabel);
        }
        
        private void save() {
            tableModel.save();
        }
        
        private void restoreDefaultInfoLabel() {
            infoLabel.setText("<html><span style=\"color:#000000\">TSL address range: 0 to 126, or -1 for none</span></html>");
        }
        
        private class MyTableModel extends AbstractTableModel {
            Object[][] sourceAddrTab;
            String[] columnHeader = {
                    "<html><center>Video Input</center></html>",
                    "<html><center>TSL Address</center></html>",
            };
            
            public MyTableModel() {
                int maxIns = bean.getTabCount();
                sourceAddrTab = new Object[maxIns][NUM_COLS];
                Iterator it = bean.iterateTab();
                for (int i = 0; i < maxIns && it.hasNext(); i++) {
                    Tab in = (Tab) it.next();
                    sourceAddrTab[i][COL_MV_INPUT] = new Integer(in.getSrc() + 1);
                    sourceAddrTab[i][COL_TSL_ADDR] = new Integer(in.getAddr());
                }
            }
            
            private void save() {
                int maxIns = bean.getTabCount();
                Iterator it = bean.iterateTab();
                for (int i = 0; i < maxIns && it.hasNext(); i++) {
                    Tab in = (Tab) it.next();
                    in.setAddr(((Integer)sourceAddrTab[i][COL_TSL_ADDR]).intValue());
                    sourceAddrTab[i][COL_TSL_ADDR] = new Integer(in.getAddr());
                }
            }
            
            @Override
            public int getColumnCount() {
                return NUM_COLS;
            }
            
            @Override
            public String getColumnName(int col) {
                return columnHeader[col];
            }

            @Override
            public int getRowCount() {
                return sourceAddrTab.length;
            }

            @Override
            public Object getValueAt(int row, int col) {
                return sourceAddrTab[row][col];
            }
            
            @Override
            public boolean isCellEditable(int row, int col) {
                return (col != COL_MV_INPUT);
            }
            
            @Override
            public void setValueAt(Object value, int row, int col) {
                sourceAddrTab[row][col] = value;
                fireTableCellUpdated(row, col);
            }
            
        }
        
        private class BoundedIntegerCellEditor extends DefaultCellEditor {

            Integer value;
            int maxVal;
            int minVal;
            String message;

            public BoundedIntegerCellEditor(int minVal, int maxVal) {
                super(new JTextField());

                ((JTextField) getComponent()).setHorizontalAlignment(JTextField.RIGHT);
                this.maxVal = maxVal;
                this.minVal = minVal;
            }

            public boolean stopCellEditing() {

                String s = (String) super.getCellEditorValue();
                // Here we are dealing with the case where a user
                // has deleted the string value in a cell, possibly
                // after a failed validation. Return null, so that
                // they have the option to replace the value with
                // null or use escape to restore the original.
                // For Strings, return "" for backward compatibility.
                if (checkValue(s, true)) {
                    value = Integer.parseInt(s);
                    restoreDefaultInfoLabel();
                    return super.stopCellEditing();
                } else {
                    ((JComponent) getComponent()).setBorder(new LineBorder(Color.red));
                    Toolkit.getDefaultToolkit().beep();
                    if (message.length() == 0)
                        restoreDefaultInfoLabel();
                    else
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
                    message = "<html><span style=\"color:#FF0000\">Please insert an integer value <br>or press esc to restore previous value</span></html>";
                    return false;
                }

                //Value was invalid.
                if ((intValue < minVal) || (intValue > maxVal)) {
                    if (intValue < minVal || intValue > maxVal) {
                        message = "<html><span style=\"color:#FF0000\">Range: " + minVal + " to " + (maxVal) + ((esc) ? " <br>or press esc to restore previous value</span><html>" : "");
                    }
                    return false;
                }

                message = "";
                return true;
            }
        }
        
    }
}
