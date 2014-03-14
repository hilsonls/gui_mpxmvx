package dialogs.moduleproperties;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import bean.AudioMonitor;
import bean.Aout;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JPanelBGGradient;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author Marco Ricci & Antonio Poggi
 */
public class AudioMonitorPanel extends JPanelBGGradient{
    private final int NUM_VIDEO_SOURCES = 64; 
    private static final int NUM_EMBEDDED_PAIRS = 8;
    private static final int NUM_EXTERNAL_PAIRS = 128;

    private MyItemListener mIL;

    private int numOutputs;
    
    private AudioMonitor bean;

    private JLabel inputSourceColumnLabel;
    private JLabel pairNumberLabel;
    private JLabel[] outputLabel;
    private JComboBox[] sourceCombo;
    private JComboBox[] pairCombo;
    
    private static String[] pairTable;
    
    public AudioMonitorPanel(AudioMonitor bean) throws MVException {
        setLayout(null);
        setBounds(1, 30, 400, 400);
      
        this.bean = bean;
        numOutputs = bean.getAoutCount();
        mIL = new MyItemListener();
        
        inputSourceColumnLabel = new JLabel("Input source");
        inputSourceColumnLabel.setBounds(160, 15, 80, 20);
        add(inputSourceColumnLabel);
        pairNumberLabel = new JLabel("Pair number");
        pairNumberLabel.setBounds(290, 15, 80, 20);
        add(pairNumberLabel);
        
        outputLabel = new JLabel[numOutputs];
        sourceCombo = new JComboBox[numOutputs];
        pairCombo = new JComboBox[numOutputs];

        for (int i=0; i<numOutputs; i++) {
            outputLabel[i] = new JLabel();
            outputLabel[i].setText("Stereo Output "+(i+1));
            outputLabel[i].setBounds(20, 20*((2*i)+2), 120, 20);
            add(outputLabel[i]);
            
            sourceCombo[i] = new JComboBox();
            sourceCombo[i].setBounds(150, 20*((2*i)+2), 120, 20);
            sourceCombo[i].addItemListener(mIL);
            add(sourceCombo[i]);
            
            pairCombo[i] = new JComboBox();
            pairCombo[i].setBounds(280, 20*((2*i)+2), 120, 20);
            add(pairCombo[i]);
        }
        
        createSourceComboContents();
        for (int i = 0; i < numOutputs; i++) {
            Aout audioOutput = bean.getAout(i);
            sourceCombo[audioOutput.getId()].setSelectedIndex(audioOutput.getSource());
            
            updatePairComboContents(audioOutput.getId());
            int selectedIndex = audioOutput.getPair() + 1;  // -1 = None, 0 = Pair 1+2, 1 = Pair 2+3 etc.
            if (selectedIndex < pairCombo[audioOutput.getId()].getItemCount()) {
                pairCombo[audioOutput.getId()].setSelectedIndex(selectedIndex);
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
                pairTable[i+1] = "Pair " + (i*2+1) + "+" + (i*2+2);
            }
        }
    }
    
    private void updatePairComboContents(int id) {
        buildPairTable();
        
        int itemCount = pairCombo[id].getItemCount();
        int expectedItemCount = sourceCombo[id].getSelectedIndex() == NUM_VIDEO_SOURCES ? NUM_EXTERNAL_PAIRS + 1 : NUM_EMBEDDED_PAIRS + 1;
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
    
    public void save() {
        for (int i=0; i<numOutputs; i++) {
            Aout audioOutput = bean.getAout(i);
            audioOutput.setSource(sourceCombo[audioOutput.getId()].getSelectedIndex());
            audioOutput.setPair(pairCombo[audioOutput.getId()].getSelectedIndex() - 1);
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
    
}
