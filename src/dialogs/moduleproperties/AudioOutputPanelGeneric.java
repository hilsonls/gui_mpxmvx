package dialogs.moduleproperties;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controllori.CtrlWorkspace;
import controllori.ProductType;
import eccezioni.MVException;
import gui.components.JPanelBGGradient;

public abstract class AudioOutputPanelGeneric extends JPanelBGGradient {
    private final int NUM_VIDEO_SOURCES = 64;
    private static final int NUM_EMBEDDED_PAIRS = 8;
    private static final int NUM_EXTERNAL_PAIRS = 128;

    private MyItemListener mIL;

    protected int numOutputs;

    private JLabel inputSourceColumnLabel;
    private JLabel pairNumberLabel;
    private JLabel[] outputLabel;
    protected JComboBox[] sourceCombo;
    protected JComboBox[] pairCombo;
    private JScrollPane scroll;
    
    private static String[] pairTable;
    
    private boolean isAudioMeterProduct;

    protected void init(int idModulo) throws MVException {
        setLayout(null);
        setBounds(1, 30, 400, 400);
        
        isAudioMeterProduct = (CtrlWorkspace.getInstance().getProductType(idModulo) == ProductType.ProductTypeAM);
        
        numOutputs = getAoutCount();
        mIL = new MyItemListener();
        
        int inputSourceColumnX = 100;
        int pairNumberColumnX = inputSourceColumnX;
        if (!isAudioMeterProduct)
            pairNumberColumnX += 140;
        int scrollPanelWidth = pairNumberColumnX + 120;

        inputSourceColumnLabel = new JLabel("Input source");
        inputSourceColumnLabel.setBounds(inputSourceColumnX + 10, 15, 80, 20);
        if (!isAudioMeterProduct)
            add(inputSourceColumnLabel);
        pairNumberLabel = new JLabel("Pair number");
        pairNumberLabel.setBounds(pairNumberColumnX + 10, 15, 80, 20);
        add(pairNumberLabel);

        outputLabel = new JLabel[numOutputs];
        sourceCombo = new JComboBox[numOutputs];
        pairCombo = new JComboBox[numOutputs];

        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(null);

        for (int i=0; i<numOutputs; i++) {
            outputLabel[i] = new JLabel();
            outputLabel[i].setText("Output "+(2*i+1)+"+"+(2*i+2));
            outputLabel[i].setBounds(20, 16*2*i+8, 80, 20);
            scrollPanel.add(outputLabel[i]);
            
            sourceCombo[i] = new JComboBox();
            sourceCombo[i].setBounds(inputSourceColumnX, 16*2*i+8, 120, 20);
            sourceCombo[i].addItemListener(mIL);
            if (!isAudioMeterProduct)
                scrollPanel.add(sourceCombo[i]);
            
            pairCombo[i] = new JComboBox();
            pairCombo[i].setBounds(pairNumberColumnX, 16*2*i+8, 120, 20);
            scrollPanel.add(pairCombo[i]);
        }
        
        scrollPanel.setPreferredSize(new Dimension(scrollPanelWidth, 32*numOutputs+8));
        scrollPanel.setOpaque(false);
        scrollPanel.setBorder(null);

        scroll = new JScrollPane();
        scroll.setOpaque(false);
        scroll.setBounds(-1, 32, scrollPanelWidth + 20, 386);
        scroll.getViewport().add(scrollPanel);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        
        add(scroll);
        
        createSourceComboContents();
        for (int i = 0; i < numOutputs; i++) {
            int aoutId = getAoutId(i);
            int aoutSource = getAoutSource(i);
            
            if (isAudioMeterProduct)
                sourceCombo[aoutId].setSelectedItem("External Audio");
            else
                sourceCombo[aoutId].setSelectedIndex(aoutSource);
            updatePairComboContents(aoutId);
            int selectedIndex = getAoutPair(i) + 1;  // -1 = None, 0 = Pair 1+2, 1 = Pair 2+3 etc.
            if (selectedIndex < pairCombo[aoutId].getItemCount()) {
                pairCombo[aoutId].setSelectedIndex(selectedIndex);
            }
        }
    }
    
    private void createSourceComboContents() {
        for (int i = 0; i < numOutputs; i++) {
            for (int j = 0; j < NUM_VIDEO_SOURCES; j++) {
                sourceCombo[i].addItem("Source " + (j+1));
            }
            sourceCombo[i].addItem("External Audio");
        }
    }
    
    private void buildPairTable() {
        if (pairTable == null) {
            pairTable = new String[NUM_EXTERNAL_PAIRS + 1];
            pairTable[0] = "None";
            for (int i = 0; i < NUM_EXTERNAL_PAIRS; i++) {
                pairTable[i+1] = "Channel " + (i*2+1) + "+" + (i*2+2);
            }
        }
    }
    
    private void updatePairComboContents(int id) {
        buildPairTable();
        
        int itemCount = pairCombo[id].getItemCount();
        int expectedItemCount = sourceCombo[id].getSelectedItem().toString().equals("External Audio") ? NUM_EXTERNAL_PAIRS + 1 : NUM_EMBEDDED_PAIRS + 1;
        if (itemCount != expectedItemCount) {
            int origItemSelected = pairCombo[id].getSelectedIndex();
            pairCombo[id].removeAllItems();
            for (int i = 0; i < expectedItemCount; i++) {
                pairCombo[id].addItem(pairTable[i]);
            }
            if (0 <= origItemSelected && origItemSelected < expectedItemCount) {
                pairCombo[id].setSelectedIndex(origItemSelected);
            }
        }
    }
    
    private class MyItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent ie) {
            Object item = ie.getSource();
            for (int i = 0; i < numOutputs; i++) {
                if (item == sourceCombo[i]) {
                    updatePairComboContents(i);
                    break;
                }
            }
        }
    }

    public abstract void save();

    protected abstract int getAoutCount();
    
    protected abstract int getAoutId(int i);

    protected abstract int getAoutSource(int i);
    
    protected abstract int getAoutPair(int i);
}
