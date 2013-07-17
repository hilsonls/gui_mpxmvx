package dialogs.editobject;

import eccezioni.MVException;
import bean.LogoProperties;
import gui.ComponentFactory;
import gui.components.JPanelBGGradient;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author panda
 */
public class PropertiesLogoPanel extends JPanelBGGradient{
    
    private LogoProperties bean;
    
    private JLabel fileNameLabel;
    private JComboBox fileNameCombo;
    
    public PropertiesLogoPanel(LogoProperties bean) throws MVException {
        setLayout(null);
        this.bean = bean;
        
        fileNameLabel = new JLabel();
        fileNameLabel.setText("File name");
        fileNameLabel.setBounds(20, 20, 80, 20);
        add(fileNameLabel);
        fileNameCombo = ComponentFactory.createComboBox(bean.getLogoFilename().getOptionsName(), bean.getLogoFilename().getVal());
        fileNameCombo.setBounds(120, 20, 170, 20);
        add(fileNameCombo);
    }

    public void save() {
        if (fileNameCombo.getSelectedItem() != null) {
            bean.getLogoFilename().setVal(fileNameCombo.getSelectedItem().toString());
        }
    }
}
