package dialogs.editobject;

import bean.ClockProperties;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author panda
 */
public class PropertiesClockPanel extends JPanelBGGradient {
    private ClockProperties bean;

    private JCheckBox digitalCheck;
    
    private JCheckBox h24Check;
    
    private JCheckBox timezoneCheck;
    private JComboBox timezoneCombo;

    private JLabel offsetLabel;
    private JComboBox offsetCombo;

    private JLabel foregroundLabel;
    private JComboBox foregroundCombo;
    
    private JLabel backgroundLabel;
    private JComboBox backgroundCombo;

    private JCheckBox displayDateCheck;

    private JLabel dateFormatLabel;
    private JComboBox dateFormatCombo;


    public PropertiesClockPanel(ClockProperties bean) throws MVException {
        MyItemListener mIL = new MyItemListener();
        
        setLayout(null);
        
        this.bean = bean;
        
        digitalCheck = new JCheckBoxTransBG();
        digitalCheck.setText("Digital");
        digitalCheck.setSelected(bean.getDigital().getVal());
        digitalCheck.setBounds(20, 20, 80, 20);
        digitalCheck.addItemListener(mIL);
        add(digitalCheck);
        
        h24Check = new JCheckBoxTransBG();
        h24Check.setText("24 hours");
        h24Check.setSelected(bean.getHour24time().getVal());
        h24Check.setBounds(20, 55, 100, 20);
        //h24Check.addItemListener(mIL);
        add(h24Check);
        
        timezoneCheck = new JCheckBoxTransBG();
        timezoneCheck.setText("Timezone");
        timezoneCheck.setBounds(20, 90, 90, 20);
        timezoneCheck.setSelected(bean.getTimezoneEnabled().getVal());
        timezoneCheck.addItemListener(mIL);
        add(timezoneCheck);
        timezoneCombo = ComponentFactory.createComboBox(bean.getTimezone().getOptionsName(), bean.getTimezone().getVal());
        timezoneCombo.setBounds(120, 90, 180, 20);
        add(timezoneCombo);
        
        offsetLabel = new JLabel();
        offsetLabel.setText("Offset (hours)");
        offsetLabel.setBounds(20, 125, 100, 20);
        add(offsetLabel);
        offsetCombo = ComponentFactory.createComboBox(bean.getOffset().getOptionsName(), bean.getOffset().getVal());
        offsetCombo.setBounds(120, 125, 180, 20);
        add(offsetCombo);
        
        foregroundLabel = new JLabel();
        foregroundLabel.setText("Foreground");
        foregroundLabel.setBounds(20, 160, 80, 20);
        add(foregroundLabel);
        foregroundCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());
        foregroundCombo.setBounds(120, 160, 180, 20);
        add(foregroundCombo);
        
        backgroundLabel = new JLabel();
        backgroundLabel.setText("Background");
        backgroundLabel.setBounds(20, 195, 80, 20);
        add(backgroundLabel);
        backgroundCombo = ComponentFactory.createComboBox(bean.getBkcolour().getOptionsName(), bean.getBkcolour().getVal());
        backgroundCombo.setBounds(120, 195, 180, 20);
        add(backgroundCombo);

        displayDateCheck = new JCheckBoxTransBG();
        displayDateCheck.setText("Display Date");
        displayDateCheck.setSelected(bean.getDisplayDate().getVal());
        displayDateCheck.setBounds(20, 230, 120, 20);
        //displayDateCheck.addItemListener(mIL);
        add(displayDateCheck);

        dateFormatLabel = new JLabel();
        dateFormatLabel.setText("Date Format");
        dateFormatLabel.setBounds(20, 260, 100, 20);
        add(dateFormatLabel);
        dateFormatCombo = ComponentFactory.createComboBox(bean.getDateFormat().getOptionsName(), bean.getDateFormat().getVal());
        dateFormatCombo.setBounds(120, 260, 180, 20);
        add(dateFormatCombo);
        
    }
    
    public void save() {
        bean.getDigital().setVal(digitalCheck.isSelected());
        bean.getHour24time().setVal(h24Check.isSelected());
        bean.getTimezoneEnabled().setVal(timezoneCheck.isSelected());
        bean.getTimezone().setVal(timezoneCombo.getSelectedItem().toString());
        bean.getOffset().setVal(offsetCombo.getSelectedItem().toString());
        bean.getColour().setVal(foregroundCombo.getSelectedItem().toString());
        bean.getBkcolour().setVal(backgroundCombo.getSelectedItem().toString());
        bean.getDisplayDate().setVal(displayDateCheck.isSelected());
        bean.getDateFormat().setVal(dateFormatCombo.getSelectedItem().toString());
    }
    
    private void checkComponentEnablingConditions() {
        h24Check.setSelected(h24Check.isSelected() && digitalCheck.isSelected());
        h24Check.setEnabled(digitalCheck.isSelected());
        timezoneCombo.setEnabled(timezoneCheck.isSelected());
    }
    
    private class MyItemListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            checkComponentEnablingConditions();
        }
        
    }
    
}