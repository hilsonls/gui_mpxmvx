package dialogs.moduleproperties;

import bean.Sources;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JPanelBGGradient;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author antonio
 */
public class SourcePanel extends JPanelBGGradient{

    private Sources bean;
    private int sourcesNum;
    
    private JLabel sourceIdLabel;
    private JLabel sourceNameLabel;
    private JLabel[] sourceLabel;
    private JTextField[] sourceNameField;
    
    public SourcePanel(Sources bean) throws MVException{
        setLayout(null);
        setBounds(1, 30, 400, 400);
      
        this.bean = bean;
        this.sourcesNum = bean.getSourceCount();
        
        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(null);
        
        sourceLabel = new JLabel[sourcesNum];
        sourceNameField = new JTextField[sourcesNum];
        
        int i;
        for (i=0; i<sourcesNum; i++) {
            sourceLabel[i] = new JLabel();
            sourceLabel[i].setText("Source "+(i+1));
            sourceLabel[i].setBounds(20, 12*(2*i)+6, 100, 20);
            scrollPanel.add(sourceLabel[i]);
            
            sourceNameField[i] = ComponentFactory.createTextField(bean.getSource(i).getUsername().getVal(), 40);
            sourceNameField[i].setBounds(120, 12*(2*i)+6, 240, 20);
            scrollPanel.add(sourceNameField[i]);
            
        }
        
        scrollPanel.setPreferredSize(new Dimension(370, 24*i+6));
        scrollPanel.setOpaque(false);
        scrollPanel.setBorder(null);
        
        JScrollPane scroll = new JScrollPane();
        scroll.setOpaque(false);
        scroll.setBounds(-1, 32, 390, 386);
        scroll.getViewport().add(scrollPanel);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        
        sourceIdLabel = new JLabel();
        sourceIdLabel.setText("Source ID");
        sourceIdLabel.setBounds(30, 10, 100, 20);
        add(sourceIdLabel);
        
        sourceNameLabel = new JLabel();
        sourceNameLabel.setText("Source Name");
        sourceNameLabel.setBounds(190, 10, 100, 20);
        add(sourceNameLabel);
        
        add(scroll);
    }
    
    public void save() {
        for (int i=0; i< sourcesNum; i++) {
            bean.getSource(i).getUsername().setVal(sourceNameField[i].getText());
        }
    }
}
