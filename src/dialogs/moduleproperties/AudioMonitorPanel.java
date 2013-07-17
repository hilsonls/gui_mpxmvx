package dialogs.moduleproperties;

import bean.AudioMonitor;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JPanelBGGradient;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * @author Marco Ricci & Antonio Poggi
 */
public class AudioMonitorPanel extends JPanelBGGradient{
    private static final int OUTPUTS = 8;
    
    private AudioMonitor bean;
    
    private JLabel[] outputLabel;
    private JComboBox[] outputCombo1;
    private JComboBox[] outputCombo2;
            
    public AudioMonitorPanel(AudioMonitor bean) throws MVException {
        setLayout(null);
        setBounds(1, 30, 400, 400);
      
        this.bean = bean;
        
        outputLabel = new JLabel[OUTPUTS];
        outputCombo1 = new JComboBox[OUTPUTS];
        outputCombo2 = new JComboBox[OUTPUTS];
        
        for (int i=0; i<OUTPUTS; i++) {
            outputLabel[i] = new JLabel();
            outputLabel[i].setText("Output "+(i+1));
            outputLabel[i].setBounds(20, 20*((2*i)+1), 80, 20);
            add(outputLabel[i]);
            
            outputCombo1[i] = ComponentFactory.createComboBox(bean.getOutput(i).getOutputSource().getOptionsName(), bean.getOutput(i).getOutputSource().getVal());
            outputCombo1[i].setBounds(100, 20*((2*i)+1), 120, 20);
            add(outputCombo1[i]);
            
            outputCombo2[i] = ComponentFactory.createComboBox(bean.getOutput(i).getChannel().getOptionsName(), bean.getOutput(i).getChannel().getVal());
            outputCombo2[i].setBounds(240, 20*((2*i)+1), 120, 20);
            add(outputCombo2[i]);
            
        }
    }
    
    public void save() {
        for (int i=0; i<OUTPUTS; i++) {
            bean.getOutput(i).getOutputSource().setVal(outputCombo1[i].getSelectedItem().toString());
            bean.getOutput(i).getChannel().setVal(outputCombo2[i].getSelectedItem().toString());
        }
    }
}
