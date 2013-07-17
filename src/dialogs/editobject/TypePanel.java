package dialogs.editobject;

import bean.Oggetto;
import bean.Position;
import dialogs.editobject.EditObjectDialog.TypeListener;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.TilesWorkspace;
import gui.components.JPanelBGGradient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Er Principe da'a Marana
 */
public class TypePanel extends JPanelBGGradient{
        private Oggetto bean;
        private AspectListener aL;
        
        private JLabel typeLabel;
        private JComboBox typeCombo;
            
        private JLabel nameLabel;
        private JTextField nameField;
        
        private JLabel xLabel;
        private JTextField xField;
            
        private JLabel yLabel;
        private JTextField yField;
            
        private JLabel widthLabel;
        private JTextField widthField;
            
        private JLabel heightLabel;
        private JTextField heightField;

        private JLabel aspectLabel;
        private JComboBox aspectCombo;
        
        
     

       
        
    public TypePanel(Oggetto bean) throws MVException {
        
        setLayout(null);
        
        this.bean = bean;
        aL = new AspectListener();
        
        typeLabel = new JLabel();
        typeLabel.setText("Type");
        typeLabel.setBounds(20, 20, 80, 20);
        add(typeLabel);
        typeCombo = ComponentFactory.createComboBox(bean.getType().getOptionsName(), bean.getType().getVal() );
        typeCombo.setBounds(120, 20, 170, 20);
        add(typeCombo);
            
        nameLabel = new JLabel();
        nameLabel.setText("Name");
        nameLabel.setBounds(20, 60, 80, 20);
        add(nameLabel);
        nameField = ComponentFactory.createTextField(bean.getUsername().getVal(), 40);
        nameField.setBounds(120, 60, 170, 20);
        add(nameField);
        
        Position pos = bean.getPosition();
        xLabel = new JLabel();
        xLabel.setText("X ");
        xLabel.setBounds(20, 100, 40, 20);
        add(xLabel);
        xField = ComponentFactory.createTextField(pos.getX().getVal());
        xField.setBounds(80, 100, 50, 20);
        add(xField);
        yLabel = new JLabel();
        yLabel.setText("Y");
        yLabel.setBounds(180, 100, 40, 20);
        add(yLabel);
        yField = ComponentFactory.createTextField(pos.getY().getVal());
        yField.setBounds(240, 100, 50, 20);
        add(yField);
        
        widthLabel = new JLabel();
        widthLabel.setText("Width");
        widthLabel.setBounds(20, 140, 40, 20);
        add(widthLabel);
        widthField = ComponentFactory.createTextField(pos.getWidth().getVal(), pos.getWidth().getMin(), pos.getWidth().getMax());
        widthField.setBounds(80, 140, 50, 20);
        widthField.addActionListener(aL);
        widthField.addFocusListener(aL);
        add(widthField);
        //TODO: vedi Multiviewer-UI-Description, sezione 7.1.1.3 (pag.35), paragrafo Behaviour
        heightLabel = new JLabel();
        heightLabel.setText("Height");
        heightLabel.setBounds(180, 140, 50, 20);
        add(heightLabel);
        heightField = ComponentFactory.createTextField(pos.getHeight().getVal(), pos.getHeight().getMin(), pos.getHeight().getMax());
        heightField.setBounds(240, 140, 50, 20);
        add(heightField);

        aspectLabel = new JLabel();
        aspectLabel.setText("Aspect Ratio");
        aspectLabel.setBounds(20, 180, 80, 20);
        add(aspectLabel);
        aspectCombo = ComponentFactory.createComboBox(bean.getAspectRatio().getOptionsName(), bean.getAspectRatio().getVal());  
        aspectCombo.setBounds(120, 180, 170, 20);
        aspectCombo.addItemListener(aL);
        add(aspectCombo);
        
        updateHeight();
    }
    
    public void save() {
        try {
            bean.getType().setVal(typeCombo.getSelectedItem().toString());
        } catch(NullPointerException npe) {
            
        }
        bean.getUsername().setVal(nameField.getText());
        bean.getPosition().getX().setVal(Integer.parseInt(xField.getText()));
        bean.getPosition().getY().setVal(Integer.parseInt(yField.getText()));
        bean.getPosition().getHeight().setVal(Integer.parseInt(heightField.getText()));
        bean.getPosition().getWidth().setVal(Integer.parseInt(widthField.getText()));
        bean.getAspectRatio().setVal(aspectCombo.getSelectedItem().toString());
    }
    
    public void setTypeListener(TypeListener tL) {
        typeCombo.addActionListener(tL);
        typeCombo.setSelectedItem(typeCombo.getSelectedItem());
    } 
    
    private void updateHeight()
    {
        
        String s = aspectCombo.getSelectedItem().toString();
        heightField.setEnabled("None".equals(s));
        heightLabel.setEnabled("None".equals(s));
        
        int width = Integer.parseInt(widthField.getText());
        int height=0;
        if (s.startsWith("4:3")) {
            height = (((width*76800)/4)*3)/76800;
            if (height<TilesWorkspace.MIN_TILE_SIZE) {
                height = TilesWorkspace.MIN_TILE_SIZE;
                width = (((height*76800)/3)*4)/76800;
                widthField.setText(""+width);
            }
            heightField.setText(""+height);
        } else if (s.startsWith("16:9")) {
            height = (((width*76800)/16)*9)/76800;
            if (height<TilesWorkspace.MIN_TILE_SIZE) {
                height = TilesWorkspace.MIN_TILE_SIZE;
                width = (((height*76800)/9)*16)/76800;
                widthField.setText(""+width);
            }
            heightField.setText(""+height);
        }
    }
    
    class AspectListener implements ItemListener, ActionListener, FocusListener
    {

        public void itemStateChanged(ItemEvent itemevent)
        {
            updateHeight();
        }

        public void actionPerformed(ActionEvent actionevent)
        {
            updateHeight();
        }

        public void focusLost(FocusEvent focusevent)
        {
            updateHeight();
        }

        public void focusGained(FocusEvent focusevent)
        {
            updateHeight();
        }

        AspectListener()
        {
        }
    }

}
