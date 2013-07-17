/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.systime;

import bean.SysTimeTimezone;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JPanelBGGradient;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author panda
 */
public class TimezonePanel extends JPanelBGGradient {
   
    private JLabel timezoneLabel;
    private JComboBox timezoneCombo;
    
    private SysTimeTimezone bean;
    
    public TimezonePanel(SysTimeTimezone bean) throws MVException {
        setLayout(null);
        this.bean = bean;
        
        timezoneLabel = new JLabel();
        timezoneLabel.setText("Timezone");
        timezoneLabel.setBounds(35, 40, 80, 20);
        add(timezoneLabel);
        timezoneCombo = ComponentFactory.createComboBox(bean.getOptionsName(), bean.getVal());
        timezoneCombo.setBounds(100, 40, 170, 20);
        add(timezoneCombo);
    }
    
    public void save() {
        bean.setVal(timezoneCombo.getSelectedItem().toString());
    }
}
