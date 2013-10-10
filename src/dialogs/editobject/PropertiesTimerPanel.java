package dialogs.editobject;

import bean.TimerProperties;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Group;
import javax.swing.border.TitledBorder;

/**
 *
 * @author panda
 */
public class PropertiesTimerPanel extends JPanelBGGradient {
    // GPI Pause / Resume modes
    private static final int GPI_PR_MODE_DISABLED = 0;
    private static final int GPI_PR_MODE_SEPARATE = 1;
    private static final int GPI_PR_MODE_HILO = 2;
    private static final int GPI_PR_MODE_TOGGLE = 3;
    
    private static final String strStartLabelTod = "Start at (hh:mm:ss)";
    private static final String strStartLabelGpi = "Reset to (hh:mm:ss)";
    
    private static final String strPauseLabelP = "Pause GPI";
    private static final String strPauseLabelPR = "Pause/Resume GPI";
    
    private static final String strCountdownTod = "Countdown (show the time remaining before start)";
    private static final String strCountdownGpi = "Countdown first";
    
    private static final String strStartHoursHelpTod = "Time of day to start the timer (hours)";
    private static final String strStartHoursHelpGpi = "Value that timer is reset to by the reset GPI (hours)";

    private static final String strStartMinuteHelpTod = "Time of day to start the timer (minutes)";
    private static final String strStartMinuteHelpGpi = "Value that timer is reset to by the reset GPI (minutes)";

    private static final String strStartSecondHelpTod = "Time of day to start the timer (seconds)";
    private static final String strStartSecondHelpGpi = "Value that timer is reset to by the reset GPI (seconds)";

    private static final String strStopHourHelp = "Time of day to stop the timer (hours)";
    private static final String strStopMinuteHelp = "Time of day to stop the timer (minutes)";
    private static final String strStopSecondHelp = "Time of day to stop the timer (seconds)";


    private TimerProperties bean;
    private JComboBox fontCombo;
    private JComboBox foregroundCombo;
    private JComboBox backgroundCombo;
    private JRadioButton timeOfDayRadio;
    private JRadioButton gpiRadio;
    private JCheckBox gpiPrModeEnabledCheck;
    private JRadioButton gpiPrModeSeparateRadio;
    private JRadioButton gpiPrModehiloRadio;
    private JRadioButton gpiPrModetoggleRadio;
    private ButtonGroup bgTimerMode;
    private ButtonGroup bgGpiMode;
    private JLabel gpiSourcesLabel;
    private JLabel gpiStartLabel;
    private JLabel gpiPauseLabel;
    private JLabel gpiResumeLabel;
    private JComboBox gpiStartCombo;
    private JComboBox gpiPauseCombo;
    private JComboBox gpiResumeCombo;
    private JCheckBox countdownCheck;
    private JCheckBox framesCheck;
    private JComboBox fontSizeCombo;
    private JComboBox transitionCombo;
    private JComboBox destinationCombo;
    private JLabel startLabel;
    private JTextField hStartField;
    private JTextField mStartField;
    private JTextField sStartField;
    private JLabel stopLabel;
    private JTextField hStopField;
    private JTextField mStopField;
    private JTextField sStopField;
    
    private MyItemListener mIL;

    public PropertiesTimerPanel(TimerProperties bean) throws MVException {
        this.bean = bean;

        mIL = new MyItemListener();

        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        layout.add(createTimerModePanel());
        layout.add(createGpiConfigurationPanel());
        layout.add(createStartStopPanel());
        layout.add(createMiscPanel());

        checkComponentEnablingConditions();

    }

    private JPanel createTimerModePanel() {
        JPanel panel = new JPanel();
        VGroupLayout layout = new VGroupLayout(panel);
        panel.setLayout(layout);
        panel.setBorder(new TitledBorder("Timer Mode"));
        panel.setOpaque(false);
        
        timeOfDayRadio = new JRadioButton("Start at a certain time of day");
        timeOfDayRadio.setSelected(!bean.getTriggerGpi().getVal());
        timeOfDayRadio.addItemListener(mIL);
        timeOfDayRadio.setOpaque(false);

        gpiRadio = new JRadioButton("Control with GPIs");
        gpiRadio.setSelected(bean.getTriggerGpi().getVal());
        gpiRadio.addItemListener(mIL);
        gpiRadio.setOpaque(false);

        countdownCheck = new JCheckBoxTransBG();
        // text is set later
        countdownCheck.setSelected(bean.getCountDown().getVal());

        framesCheck = new JCheckBoxTransBG();
        framesCheck.setText("Show frames");
        framesCheck.setSelected(bean.getShowFrames().getVal());
        framesCheck.setToolTipText("Display as HH:MM:SS:FF");
        
        layout.add(timeOfDayRadio);
        layout.add(gpiRadio);
        layout.add(countdownCheck);
        layout.add(framesCheck);

        bgTimerMode = new ButtonGroup();
        bgTimerMode.add(timeOfDayRadio);
        bgTimerMode.add(gpiRadio);
        
        return panel;
    }

    private JPanel createGpiConfigurationPanel() throws MVException {
        JPanel panel = new JPanel();
        VGroupLayout layout = new VGroupLayout(panel);
        panel.setLayout(layout);
        panel.setBorder(new TitledBorder("GPI Setup"));
        panel.setOpaque(false);
        
        int mode = bean.getGpiSource().getMode();
        
        gpiPrModeEnabledCheck = new JCheckBoxTransBG("Enable Pause and Resume GPIs using:");
        gpiPrModeEnabledCheck.setSelected(mode != GPI_PR_MODE_DISABLED);
        gpiPrModeEnabledCheck.addItemListener(mIL);
        
        gpiPrModeSeparateRadio = new JRadioButton("Two GPIs");
        gpiPrModeSeparateRadio.setSelected(mode == GPI_PR_MODE_SEPARATE);
        gpiPrModeSeparateRadio.addItemListener(mIL);
        gpiPrModeSeparateRadio.setOpaque(false);

        gpiPrModehiloRadio = new JRadioButton("One GPI, active=pause, inactive=resume");
        gpiPrModehiloRadio.setSelected(mode == GPI_PR_MODE_HILO);
        gpiPrModehiloRadio.addItemListener(mIL);
        gpiPrModehiloRadio.setOpaque(false);

        gpiPrModetoggleRadio = new JRadioButton("One GPI, alternating between pause and resume");
        gpiPrModetoggleRadio.setSelected(mode == GPI_PR_MODE_TOGGLE);
        gpiPrModetoggleRadio.addItemListener(mIL);
        gpiPrModetoggleRadio.setOpaque(false);

        bgGpiMode = new ButtonGroup();
        bgGpiMode.add(gpiPrModeSeparateRadio);
        bgGpiMode.add(gpiPrModehiloRadio);
        bgGpiMode.add(gpiPrModetoggleRadio);

        // Start, pause and resume combo boxes
        gpiSourcesLabel = new JLabel("GPI Sources:");
        gpiStartLabel = new JLabel("Reset GPI");
        gpiStartCombo = ComponentFactory.createComboBox(bean.getGpiSource().getOptionsName(), bean.getGpiSource().getVal());
        gpiStartCombo.setEnabled(bean.getTriggerGpi().getVal());
        
        gpiPauseLabel = new JLabel(strPauseLabelP);
        gpiPauseCombo = ComponentFactory.createComboBox(bean.getGpiSource().getOptionsName(), bean.getGpiSource().getGpip());
        gpiPauseCombo.setEnabled(bean.getTriggerGpi().getVal());

        gpiResumeLabel = new JLabel("Resume GPI");
        gpiResumeCombo = ComponentFactory.createComboBox(bean.getGpiSource().getOptionsName(), bean.getGpiSource().getGpir());
        gpiResumeCombo.setEnabled(bean.getTriggerGpi().getVal());
        
        layout.add(gpiPrModeEnabledCheck);
        layout.addIndent(gpiPrModeSeparateRadio);
        layout.addIndent(gpiPrModehiloRadio);
        layout.addIndent(gpiPrModetoggleRadio);
        layout.add(gpiSourcesLabel);
        layout.addGridIndent(new Component[][] {
                {gpiStartLabel, gpiStartCombo},
                {gpiPauseLabel, gpiPauseCombo},
                {gpiResumeLabel, gpiResumeCombo}
        });
        
        return panel;
    }

    private JPanel createStartStopPanel() {
        JPanel panel = new JPanel();
        VGroupLayout layout = new VGroupLayout(panel);
        panel.setLayout(layout);
        panel.setOpaque(false);
        
        int [] fields = secToHourMinSec(bean.getStartTime().getVal());

        startLabel = new JLabel(strStartLabelTod);
        hStartField = ComponentFactory.createTextField(fields[0], 0, 23);
        mStartField = ComponentFactory.createTextField(fields[1], 0, 59);
        sStartField = ComponentFactory.createTextField(fields[2], 0, 59);

        fields = secToHourMinSec(bean.getStopTime().getVal());

        stopLabel = new JLabel("Stop at (hh:mm:ss)");
        hStopField = ComponentFactory.createTextField(fields[0], 0, 23);
        hStopField.setToolTipText(strStopHourHelp);
        mStopField = ComponentFactory.createTextField(fields[1], 0, 59);
        mStopField.setToolTipText(strStopMinuteHelp);
        sStopField = ComponentFactory.createTextField(fields[2], 0, 59);
        sStopField.setToolTipText(strStopSecondHelp);
        
        layout.addGrid(new Component[][] {
                {startLabel, hStartField, new JLabel(":"), mStartField, new JLabel(":"), sStartField},
                {stopLabel, hStopField, new JLabel(":"), mStopField, new JLabel(":"), sStopField}
        });
        
        return panel;
    }

    private JPanel createMiscPanel() throws MVException {
        JPanel panel = new JPanel();
        VGroupLayout layout = new VGroupLayout(panel);
        panel.setLayout(layout);
        panel.setOpaque(false);
        
        fontCombo = ComponentFactory.createComboBox(bean.getFont().getOptionsName(), bean.getFont().getVal());
        fontSizeCombo = ComponentFactory.createComboBox(bean.getFontSize().getOptionsName(), bean.getFontSize().getVal());
        foregroundCombo = ComponentFactory.createComboBox(bean.getFgColour().getOptionsName(), bean.getFgColour().getVal());
        foregroundCombo.setToolTipText("Text colour when counting down or waiting to start");
        transitionCombo = ComponentFactory.createComboBox(bean.getTransColour().getOptionsName(), bean.getTransColour().getVal());
        transitionCombo.setToolTipText("Text colour during the last 10 seconds of countdown");
        destinationCombo = ComponentFactory.createComboBox(bean.getDestColour().getOptionsName(), bean.getDestColour().getVal());
        destinationCombo.setToolTipText("Text colour when counting up");
        backgroundCombo = ComponentFactory.createComboBox(bean.getBgColour().getOptionsName(), bean.getBgColour().getVal());
        
        layout.addGrid(new Component[][] {
            {new JLabel("Font"), fontCombo},
            {new JLabel("Font Size"), fontSizeCombo},
            {new JLabel("Countdown Colour"), foregroundCombo},
            {new JLabel("Transition Colour"), transitionCombo},
            {new JLabel("Destination Colour"), destinationCombo},
            {new JLabel("Background Colour"), backgroundCombo}
        });
        
        return panel;
    }

    public void save() {
        bean.getBgColour().setVal(backgroundCombo.getSelectedItem().toString());
        bean.getCountDown().setVal(countdownCheck.isSelected());
        bean.getDestColour().setVal(destinationCombo.getSelectedItem().toString());
        bean.getFgColour().setVal(foregroundCombo.getSelectedItem().toString());
        bean.getFont().setVal(fontCombo.getSelectedItem().toString());
        bean.getFontSize().setVal(fontSizeCombo.getSelectedItem().toString());
        bean.getGpiSource().setVal(gpiStartCombo.getSelectedItem().toString());
        bean.getGpiSource().setMode(gpiPrModeEnabledCheck.isSelected() ? 
            (gpiPrModehiloRadio.isSelected() ? GPI_PR_MODE_HILO :
            gpiPrModetoggleRadio.isSelected() ? GPI_PR_MODE_TOGGLE : 
            GPI_PR_MODE_SEPARATE) : GPI_PR_MODE_DISABLED);
        bean.getGpiSource().setGpip(gpiPauseCombo.getSelectedItem().toString());
        bean.getGpiSource().setGpir(gpiResumeCombo.getSelectedItem().toString());
        bean.getShowFrames().setVal(framesCheck.isSelected());
        bean.getStartTime().setVal(HourMinSecToSecs(new int[]{Integer.valueOf(hStartField.getText()),Integer.valueOf(mStartField.getText()),Integer.valueOf(sStartField.getText())}));
        bean.getStopTime().setVal(HourMinSecToSecs(new int[]{Integer.valueOf(hStopField.getText()),Integer.valueOf(mStopField.getText()),Integer.valueOf(sStopField.getText())}));
        bean.getTransColour().setVal(transitionCombo.getSelectedItem().toString());
        bean.getTriggerGpi().setVal(gpiRadio.isSelected());
    }

    private void checkComponentEnablingConditions() {
        countdownCheck.setText(gpiRadio.isSelected() ? strCountdownGpi : strCountdownTod);
        gpiPrModeEnabledCheck.setEnabled(gpiRadio.isSelected());
        gpiPrModeSeparateRadio.setEnabled(gpiRadio.isSelected() && gpiPrModeEnabledCheck.isSelected());
        gpiPrModehiloRadio.setEnabled(gpiRadio.isSelected() && gpiPrModeEnabledCheck.isSelected());
        gpiPrModetoggleRadio.setEnabled(gpiRadio.isSelected() && gpiPrModeEnabledCheck.isSelected());
        gpiSourcesLabel.setEnabled(gpiRadio.isSelected());
        gpiStartLabel.setEnabled(gpiRadio.isSelected());
        gpiStartCombo.setEnabled(gpiRadio.isSelected());
        gpiPauseLabel.setEnabled(gpiRadio.isSelected() && gpiPrModeEnabledCheck.isSelected());
        gpiPauseLabel.setText(gpiPrModeSeparateRadio.isSelected() ? strPauseLabelP : strPauseLabelPR);
        gpiPauseCombo.setEnabled(gpiRadio.isSelected() && gpiPrModeEnabledCheck.isSelected());
        gpiResumeLabel.setEnabled(gpiRadio.isSelected() && gpiPrModeEnabledCheck.isSelected() && gpiPrModeSeparateRadio.isSelected());
        gpiResumeCombo.setEnabled(gpiRadio.isSelected() && gpiPrModeEnabledCheck.isSelected() && gpiPrModeSeparateRadio.isSelected());
        startLabel.setText(gpiRadio.isSelected() ? strStartLabelGpi : strStartLabelTod);
        hStartField.setToolTipText(gpiRadio.isSelected() ? strStartHoursHelpGpi : strStartHoursHelpTod);
        mStartField.setToolTipText(gpiRadio.isSelected() ? strStartMinuteHelpGpi : strStartMinuteHelpTod);
        sStartField.setToolTipText(gpiRadio.isSelected() ? strStartSecondHelpGpi : strStartSecondHelpTod);
        stopLabel.setEnabled(!gpiRadio.isSelected());
        hStopField.setEnabled(!gpiRadio.isSelected());
        mStopField.setEnabled(!gpiRadio.isSelected());
        sStopField.setEnabled(!gpiRadio.isSelected());
    }
    
    private class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            checkComponentEnablingConditions();
        }

    }

    private int[] secToHourMinSec(int secs) {
        int[] fields = new int[]{0, 0, 0};
        int hours = secs / 3600;
        int minutes = secs / 60 - hours * 60 ;
        int seconds = secs % 60;
        fields[0] = hours;
        fields[1] = minutes;
        fields[2] = seconds;
        return fields;
    }

    private int HourMinSecToSecs(int[] fields) {
        int secs = 0;
        secs += fields[0] * 3600;
        secs += fields[1] * 60;
        secs += fields[2];
        return secs;
    }
}
