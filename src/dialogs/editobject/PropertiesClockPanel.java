package dialogs.editobject;

import bean.ClockProperties;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;

import java.awt.Component;
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
    
    private JLabel missingSourceColourLabel;
    private JComboBox missingSourceColourCombo;
    
    private JLabel backgroundLabel;
    private JComboBox backgroundCombo;

    private JCheckBox displayDateCheck;

    private JLabel dateFormatLabel;
    private JComboBox dateFormatCombo;


    public PropertiesClockPanel(ClockProperties bean) throws MVException {
        MyItemListener mIL = new MyItemListener();
        
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        
        this.bean = bean;
        
        digitalCheck = new JCheckBoxTransBG("Digital");
        digitalCheck.setSelected(bean.getDigital().getVal());
        digitalCheck.addItemListener(mIL);
        
        h24Check = new JCheckBoxTransBG("24 hours");
        h24Check.setSelected(bean.getHour24time().getVal());
        
        timezoneCheck = new JCheckBoxTransBG("Timezone");
        timezoneCheck.setSelected(bean.getTimezoneEnabled().getVal());
        timezoneCheck.addItemListener(mIL);
        timezoneCombo = ComponentFactory.createComboBox(bean.getTimezone().getOptionsName(), bean.getTimezone().getVal());
        
        offsetLabel = new JLabel("Offset (hours)");
        offsetCombo = ComponentFactory.createComboBox(bean.getOffset().getOptionsName(), bean.getOffset().getVal());
        
        foregroundLabel = new JLabel("Foreground colour");
        foregroundCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());
        
        missingSourceColourLabel = new JLabel("Missing clock source colour");
        missingSourceColourLabel.setToolTipText("Foreground colour when clock source is missing");
        if (bean.getMissingSourceColour() == null)
            missingSourceColourCombo = ComponentFactory.createComboBox(bean.getColour().getOptionsName(), bean.getColour().getVal());
        else
            missingSourceColourCombo = ComponentFactory.createComboBox(bean.getMissingSourceColour().getOptionsName(), bean.getMissingSourceColour().getVal());
        missingSourceColourCombo.setToolTipText("Foreground colour when clock source is missing");
        
        backgroundLabel = new JLabel("Background colour");
        backgroundCombo = ComponentFactory.createComboBox(bean.getBkcolour().getOptionsName(), bean.getBkcolour().getVal());

        displayDateCheck = new JCheckBoxTransBG("Display Date");
        displayDateCheck.setSelected(bean.getDisplayDate().getVal());

        dateFormatLabel = new JLabel("Date Format");
        dateFormatCombo = ComponentFactory.createComboBox(bean.getDateFormat().getOptionsName(), bean.getDateFormat().getVal());
        
        layout.add(digitalCheck);
        layout.add(h24Check);
        layout.addGrid(new Component[][] {
                {timezoneCheck, timezoneCombo},
                {offsetLabel, offsetCombo},
                {foregroundLabel, foregroundCombo},
                {missingSourceColourLabel, missingSourceColourCombo},
                {backgroundLabel, backgroundCombo},
        });
        layout.add(displayDateCheck);
        layout.addRow(new Component[] {dateFormatLabel, dateFormatCombo});
        
        checkComponentEnablingConditions();
    }
    
    public void save() {
        bean.getDigital().setVal(digitalCheck.isSelected());
        bean.getHour24time().setVal(h24Check.isSelected());
        bean.getTimezoneEnabled().setVal(timezoneCheck.isSelected());
        bean.getTimezone().setVal(timezoneCombo.getSelectedItem().toString());
        bean.getOffset().setVal(offsetCombo.getSelectedItem().toString());
        bean.getColour().setVal(foregroundCombo.getSelectedItem().toString());
        if (bean.getMissingSourceColour() != null)
            bean.getMissingSourceColour().setVal(missingSourceColourCombo.getSelectedItem().toString());
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