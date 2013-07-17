package dialogs.moduleproperties;

import bean.AudioOut;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JPanelBGGradient;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author Marco Ricci & Antonio Poggi
 */
public class AudioOutputPanel extends JPanelBGGradient{
    //private static final int OUTPUTS = 8;
    
    private AudioOut bean;
    private int outsNum;
    
    private JScrollPane scroll;
    
    private JLabel sourceLabel;
    private JLabel channelLabel;
    
    private JLabel[] outputLabel;
    private JComboBox[] sourceCombo;
    private JComboBox[] channelCombo;
            
    public AudioOutputPanel(AudioOut bean) throws MVException {
        setLayout(null);
        setBounds(1, 30, 400, 400);
      
        this.bean = bean;
        this.outsNum = bean.getOutputCount();
        
        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(null);
        
        outputLabel = new JLabel[outsNum];
        sourceCombo = new JComboBox[outsNum];
        channelCombo = new JComboBox[outsNum];
        
        int i;
        for (i=0; i<outsNum; i++) {
            outputLabel[i] = new JLabel();
            outputLabel[i].setText("Output "+(i+1));
            outputLabel[i].setBounds(20, 16*(2*i)+8, 80, 20);
            scrollPanel.add(outputLabel[i]);
            
            sourceCombo[i] = ComponentFactory.createComboBox(bean.getOutputInfo().getOptionTables().getSource(), bean.getOutput(i).getOutputSource().getVal());
            sourceCombo[i].setBounds(100, 16*(2*i)+8, 120, 20);
            scrollPanel.add(sourceCombo[i]);
            
            channelCombo[i] = ComponentFactory.createComboBox(bean.getOutputInfo().getOptionTables().getChannel(), bean.getOutput(i).getChannel().getVal());
            channelCombo[i].setBounds(240, 16*(2*i)+8, 120, 20);
            scrollPanel.add(channelCombo[i]);
            
        }
        
        scrollPanel.setPreferredSize(new Dimension(370, 32*i+8));
        scrollPanel.setOpaque(false);
        scrollPanel.setBorder(null);
        
        scroll = new JScrollPane();
        scroll.setOpaque(false);
        scroll.setBounds(-1, 32, 390, 386);
        scroll.getViewport().add(scrollPanel);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        
        sourceLabel = new JLabel();
        sourceLabel.setText("Source");
        sourceLabel.setBounds(130, 10, 80, 20);
        add(sourceLabel);
        
        channelLabel = new JLabel();
        channelLabel.setText("Channel");
        channelLabel.setBounds(265, 10, 80, 20);
        add(channelLabel);

        add(scroll);
    }
    
    public void save() {
        for (int i=0; i<outsNum; i++) {
            bean.getOutput(i).getOutputSource().setVal(sourceCombo[i].getSelectedItem().toString());
            bean.getOutput(i).getChannel().setVal(channelCombo[i].getSelectedItem().toString());
        }
    }
}
