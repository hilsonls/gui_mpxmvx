package dialogs.audiochannelnames;

import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import bean.AudioLabelGroup;

/**
 *
 * @author michael
 */
public class AudioChannelNamesPanel extends JPanelBGGradient{

    private AudioLabelGroup bean;
    private int numLabels;
    
    private JLabel[] channelNumberLabel;
    private JTextField[] channelNameField;
    
    public AudioChannelNamesPanel(AudioLabelGroup bean) throws MVException{
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
      
        this.bean = bean;
        this.numLabels = bean.getLabelCount();
        
        JPanel scrollPanel = new JPanel();
        VGroupLayout scrollLayout = new VGroupLayout(scrollPanel);
        scrollPanel.setLayout(scrollLayout);
        
        channelNumberLabel = new JLabel[numLabels];
        channelNameField = new JTextField[numLabels];
        
        for (int i = 0; i < numLabels; i++) {
            channelNumberLabel[i] = new JLabel();
            channelNumberLabel[i].setText("Channel " + (i + 1));
            channelNameField[i] = ComponentFactory.createTextField(bean.getLabel(i).getName(), 40);
            scrollLayout.addRow(new Component[] {channelNumberLabel[i], channelNameField[i]});
        }
        
        scrollPanel.setOpaque(false);
        scrollPanel.setBorder(null);
        
        JScrollPane scroll = new JScrollPane();
        scroll.setOpaque(false);
        scroll.getViewport().add(scrollPanel);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        
        layout.add(scroll);
    }
    
    public void save() {
        for (int i = 0; i < numLabels; i++) {
            bean.getLabel(i).setName(channelNameField[i].getText());
        }
    }
}
