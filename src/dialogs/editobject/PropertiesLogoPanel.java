package dialogs.editobject;

import java.awt.Component;

import eccezioni.MVException;
import bean.LogoProperties;
import gui.ComponentFactory;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;

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
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        this.bean = bean;
        
        fileNameLabel = new JLabel("Logo file name");
        fileNameCombo = ComponentFactory.createComboBox(bean.getLogoFilename().getOptionsName(), bean.getLogoFilename().getVal());
        
        layout.addRow(new Component[] {fileNameLabel, fileNameCombo});
    }

    public void save() {
        if (fileNameCombo.getSelectedItem() != null) {
            bean.getLogoFilename().setVal(fileNameCombo.getSelectedItem().toString());
        }
    }
}
