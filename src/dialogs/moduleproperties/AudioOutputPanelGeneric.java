package dialogs.moduleproperties;

import java.awt.Component;
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
import gui.components.VGroupLayout;

public abstract class AudioOutputPanelGeneric extends JPanelBGGradient {
    private final int NUM_VIDEO_SOURCES = 64;
    private static final int NUM_EMBEDDED_PAIRS = 8;
    private static final int NUM_EXTERNAL_PAIRS = 128;

    private MyItemListener mIL;

    protected int numOutputs;

    protected JComboBox[] sourceCombo;
    protected JComboBox[] pairCombo;
    private JScrollPane scroll;
    
    private static String[] pairTable;
    
    private boolean isAudioMeterProduct;

    protected void init(int idModulo) throws MVException {
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        
        isAudioMeterProduct = (CtrlWorkspace.getInstance().getProductType(idModulo) == ProductType.ProductTypeAM);
        
        numOutputs = getAoutCount();
        mIL = new MyItemListener();
        
        Component grid[][];
        int pairColumn;
        
        if (isAudioMeterProduct) {
            grid = new Component[numOutputs + 1][2];
            pairColumn = 1;
        } else {
            grid = new Component[numOutputs + 1][3];
            pairColumn = 2;
        }
        
        grid[0][0] = new JLabel("");
        if (!isAudioMeterProduct)
            grid[0][1] = new JLabel("Input source");
        grid[0][pairColumn] = new JLabel("Pair number");
        
        sourceCombo = new JComboBox[numOutputs];
        pairCombo = new JComboBox[numOutputs];

        JPanel scrollPanel = new JPanel();
        VGroupLayout scrollLayout = new VGroupLayout(scrollPanel);
        scrollPanel.setLayout(scrollLayout);

        for (int i=0; i<numOutputs; i++) {
            JLabel outputLabel = new JLabel();
            outputLabel.setText("Output "+(2*i+1)+"+"+(2*i+2));
            grid[i + 1][0] = outputLabel;
            
            sourceCombo[i] = new JComboBox();
            sourceCombo[i].addItemListener(mIL);
            if (!isAudioMeterProduct)
                grid[i + 1][1] = sourceCombo[i];
            
            pairCombo[i] = new JComboBox();
            grid[i + 1][pairColumn] = pairCombo[i];
        }
        
        scrollLayout.addGrid(grid);
        scrollPanel.setOpaque(false);
        scrollPanel.setBorder(null);

        scroll = new JScrollPane();
        scroll.setOpaque(false);
        scroll.getViewport().add(scrollPanel);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        
        layout.add(scroll);
        
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
