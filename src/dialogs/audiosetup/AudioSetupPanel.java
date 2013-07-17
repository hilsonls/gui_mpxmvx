package dialogs.audiosetup;

import bean.AudioSetup;
import bean.Mv;
import bean.Name;
import bean.OptionsList;
import bean.Remote;
import bean.ScaleTransition;
import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import dialogs.remote.IpAddressCustomDialog;
import dialogs.remote.NetworkConfigDialog;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JPanelBGGradient;
import gui.components.JSliderPanel;
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
import javax.swing.JComboBox;
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
public class AudioSetupPanel extends JPanelBGGradient{
    
    private AudioSetup audioSetup;
    private Frame frame;
    private int idModulo;   
    private MyItemListener mIL;
    private int numScales;
        
    private JLabel audioScaleLabel;
    private JComboBox audioScaleCombo;

    private JLabel upperExtentLabel;
    private JLabel zone1Label;
    private JComboBox[] upperBoundaryCombo;
    private JLabel zone2Label;
    private JComboBox[] lowerBoundaryCombo;
    private JLabel zone3Label;
    private JLabel lowerExtentLabel;

    private JButton defaultButton;

            
    public AudioSetupPanel(Frame frame, int idModulo, AudioSetup audioSetup) {
        setLayout(null);
        setBounds(1, 30, 350, 350);
        
        this.audioSetup = audioSetup;
        this.frame = frame;
        this.idModulo = idModulo;
        this.mIL = new MyItemListener();

        numScales = audioSetup.getScaleTransitionCount();
    
        audioScaleLabel = new JLabel();
        audioScaleLabel.setText("Audio scale");
        audioScaleLabel.setBounds(60, 20, 100, 20);
        add(audioScaleLabel);
        OptionsList audioScaleEntries = new OptionsList();
        Iterator it = audioSetup.iterateScaleTransition();
        String defaultEntry = numScales>0?audioSetup.getScaleTransition(0).getTransitionScale().getVal():"";
        upperBoundaryCombo = new JComboBox[numScales];
        lowerBoundaryCombo = new JComboBox[numScales];
        int index = 0;
        while (it.hasNext()) {
            ScaleTransition st = (ScaleTransition) it.next();
            Name name = new Name();
            name.setVal(st.getTransitionScale().getVal());
            audioScaleEntries.addName(name);
            
            upperBoundaryCombo[index] = ComponentFactory.createComboBox(st.getUpperNormal().getVal(), st.getUpperNormal().getMin(), st.getUpperNormal().getMax(), " "+st.getUnits().getVal());
            upperBoundaryCombo[index].setBounds(160, 100, 100, 20);
            upperBoundaryCombo[index].setVisible(((index==0)?true:false));
            add(upperBoundaryCombo[index]);
            lowerBoundaryCombo[index] = ComponentFactory.createComboBox(st.getLowerNormal().getVal(), st.getLowerNormal().getMin(), st.getLowerNormal().getMax()," "+st.getUnits().getVal());
            lowerBoundaryCombo[index].setBounds(160, 140, 100, 20);
            lowerBoundaryCombo[index].setVisible(((index==0)?true:false));
            add(lowerBoundaryCombo[index]);
            index++;
        }
        audioScaleCombo = ComponentFactory.createComboBox(audioScaleEntries, defaultEntry);
        audioScaleCombo.setBounds(160, 20, 140, 20);
        audioScaleCombo.addItemListener(mIL);
        add(audioScaleCombo);


        upperExtentLabel = new JLabel();
        upperExtentLabel.setBounds(160, 60, 100, 20);
        add(upperExtentLabel);
        zone1Label = new JLabel();
        zone1Label.setText("  Over level region");
        zone1Label.setBounds(20, 80, 140, 20);
        add(zone1Label);
        zone2Label = new JLabel();
        zone2Label.setText("Upper level region");
        zone2Label.setBounds(20, 120, 140, 20);
        add(zone2Label);
        zone3Label = new JLabel();
        zone3Label.setText("Lower level region");
        zone3Label.setBounds(20, 160, 140, 20);
        add(zone3Label);
        lowerExtentLabel = new JLabel();
        lowerExtentLabel.setBounds(160, 180, 100, 20);
        add(lowerExtentLabel);
        defaultButton = new JButton("Default");
        defaultButton.setBounds(160, 220, 100, 20);
        defaultButton.addActionListener(mIL);
        add(defaultButton);
        audioScaleCombo.setSelectedIndex(1);
        audioScaleCombo.setSelectedIndex(0);

    }
    
    public void save() throws MVException {
        for (int i = 0; i < audioSetup.getScaleTransitionCount(); i++) {
            String val = upperBoundaryCombo[i].getSelectedItem().toString();
            val = val.substring(0, val.indexOf(" "));
            audioSetup.getScaleTransition(i).getUpperNormal().setVal(Integer.parseInt(val));
            val = lowerBoundaryCombo[i].getSelectedItem().toString();
            val = val.substring(0, val.indexOf(" "));
            audioSetup.getScaleTransition(i).getLowerNormal().setVal(Integer.parseInt(val));
        }
    }
    
    private class MyItemListener implements ItemListener, ActionListener {

        public void itemStateChanged(ItemEvent ie) {
            int indiceArrayVisibile = audioScaleCombo.getSelectedIndex();
            for (int i = 0; i < numScales; i++){
                upperBoundaryCombo[i].setVisible(((i==indiceArrayVisibile)?true:false));
                lowerBoundaryCombo[i].setVisible(((i==indiceArrayVisibile)?true:false));
            }
            //LABEL
            upperExtentLabel.setText(audioSetup.getScaleTransition(indiceArrayVisibile).getUpperExtent().getVal() + " " + audioSetup.getScaleTransition(indiceArrayVisibile).getUnits().getVal());
            lowerExtentLabel.setText(audioSetup.getScaleTransition(indiceArrayVisibile).getLowerExtent().getVal() + " " + audioSetup.getScaleTransition(indiceArrayVisibile).getUnits().getVal());
        }

        public void actionPerformed(ActionEvent ae) {
            Object obj = ae.getSource();
            if (obj == defaultButton) {
                int choice = JOptionPane.showConfirmDialog(null, "If you confirm this operation all the unsaved changes made until now will be discarded", "Are you sure you want to reset to default values?", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    //Ripristinare default
                    int i = audioScaleCombo.getSelectedIndex();
                    upperBoundaryCombo[i].setSelectedItem(audioSetup.getScaleTransition(i).getUpperNormal().getDefault()+" "+audioSetup.getScaleTransition(i).getUnits().getVal());
                    lowerBoundaryCombo[i].setSelectedItem(audioSetup.getScaleTransition(i).getLowerNormal().getDefault()+" "+audioSetup.getScaleTransition(i).getUnits().getVal());
                    
                }
            }
        }


    }
}
