package dialogs.moduleproperties;

import bean.Screen;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.CtrlActions;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author Marco Ricci & Antonio Poggi
 */
public class ScreenPanel extends JPanelBGGradient{
    
    private Screen bean;
    
    private JLabel resolutionLabel;
    private JComboBox resolutionCombo;
    
    private JLabel aspectLabel;
    private JComboBox aspectCombo;
    
    private JCheckBox genlockCheck;
    
    
    public int oldHres;
    public int oldVres;
    
    
    public ScreenPanel(Screen bean, int idModulo) throws MVException {
        setLayout(null);
        setBounds(1, 30, 400, 400);
        
        this.bean = bean;
              
        resolutionLabel = new JLabel();
        resolutionLabel.setText("Resolution");
        resolutionLabel.setBounds(20, 20, 80, 20);
        add(resolutionLabel);
        resolutionCombo = ComponentFactory.createComboBox(bean.getResolution().getOptionsName(), bean.getResolution().getVal());
        resolutionCombo.setBounds(120, 20, 300, 20);
        add(resolutionCombo);
        oldHres =  bean.getResolution().getHres();
        oldVres =  bean.getResolution().getVres();
        
        
        
        aspectLabel = new JLabel();
        aspectLabel.setText("Aspect ratio");
        aspectLabel.setBounds(20, 60, 80, 20);
        add(aspectLabel);
        aspectCombo = ComponentFactory.createComboBox(bean.getModuleScreenAspectRatio().getOptionsName(), bean.getModuleScreenAspectRatio().getVal());
        aspectCombo.setBounds(120, 60, 180, 20);
        add(aspectCombo);
        
        genlockCheck = new JCheckBoxTransBG();
        genlockCheck.setText("Genlock");
        genlockCheck.setBounds(20, 100, 180, 20);
        genlockCheck.setSelected(bean.getGenlock().getVal());
        add(genlockCheck);
    }
    
    public void save() {
   
        bean.getResolution().setVal(resolutionCombo.getSelectedItem().toString());
        bean.getModuleScreenAspectRatio().setVal(aspectCombo.getSelectedItem().toString());
        bean.getGenlock().setVal(genlockCheck.isSelected());
    }
}
