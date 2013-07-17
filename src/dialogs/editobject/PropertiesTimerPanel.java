package dialogs.editobject;

import bean.TimerProperties;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author panda
 */
public class PropertiesTimerPanel extends JPanelBGGradient {

    private TimerProperties bean;
    private JLabel fontLabel;
    private JComboBox fontCombo;
    private JLabel foregroundLabel;
    private JComboBox foregroundCombo;
    private JLabel backgroundLabel;
    private JComboBox backgroundCombo;
    private JPanel triggerModePanel;
    private JRadioButton timeOfDayRadio;
    private JRadioButton gpiRadio;
    private ButtonGroup bg;
    private JComboBox gpiSourceCombo;
    private JCheckBox countdownCheck;
    private JCheckBox framesCheck;
    private JLabel fontSizeLabel;
    private JComboBox fontSizeCombo;
    private JLabel transitionLabel;
    private JComboBox transitionCombo;
    private JLabel destinationLabel;
    private JComboBox destinationCombo;
    private JLabel startLabel;
    private final JLabel stopLabel;
    private final JLabel hLabel;
    private final JLabel mLabel;
    private final JLabel sLabel;
    private final JLabel h1Label;
    private final JLabel m1Label;
    private final JLabel s1Label;
    private JTextField hStartField;
    private JTextField mStartField;
    private JTextField sStartField;
    private JTextField hStopField;
    private JTextField mStopField;
    private JTextField sStopField;

    public PropertiesTimerPanel(TimerProperties bean) throws MVException {
        MyItemListener mIL = new MyItemListener();

        setLayout(null);

        this.bean = bean;

        triggerModePanel = new JPanelBGGradient();
        triggerModePanel.setLayout(null);
        triggerModePanel.setBounds(10, 10, 300, 80);
        triggerModePanel.setBorder(new TitledBorder("Trigger Mode"));
        add(triggerModePanel);

        timeOfDayRadio = new JRadioButton("Time Of day");
        timeOfDayRadio.setBounds(10, 20, 120, 20);
        timeOfDayRadio.setSelected(!bean.getTriggerGpi().getVal());
        timeOfDayRadio.addItemListener(mIL);
        timeOfDayRadio.setOpaque(false);
        triggerModePanel.add(timeOfDayRadio);

        gpiRadio = new JRadioButton("GPI Input");
        gpiRadio.setBounds(10, 40, 110, 20);
        gpiRadio.setSelected(bean.getTriggerGpi().getVal());
        gpiRadio.addItemListener(mIL);
        gpiRadio.setOpaque(false);
        triggerModePanel.add(gpiRadio);

        bg = new ButtonGroup();
        bg.add(timeOfDayRadio);
        bg.add(gpiRadio);

        gpiSourceCombo = ComponentFactory.createComboBox(bean.getGpiSource().getOptionsName(), bean.getGpiSource().getVal());
        gpiSourceCombo.setBounds(120, 40, 160, 20);
        gpiSourceCombo.setEnabled(bean.getTriggerGpi().getVal());
        triggerModePanel.add(gpiSourceCombo);


        startLabel = new JLabel();
        startLabel.setText("Start at");
        startLabel.setBounds(20, 95, 70, 20);
        add(startLabel);

        int [] fields = secToHourMinSec(bean.getStartTime().getVal());


        hStartField = ComponentFactory.createTextField(fields[0], 0, 23);
        hStartField.setBounds(100, 95, 30, 20);
        add(hStartField);
        hLabel = new JLabel();
        hLabel.setText("H");
        hLabel.setBounds(130, 95, 15, 20);
        add(hLabel);

        mStartField = ComponentFactory.createTextField(fields[1], 0, 59);
        mStartField.setBounds(160, 95, 30, 20);
        add(mStartField);
        mLabel = new JLabel();
        mLabel.setText("M");
        mLabel.setBounds(190, 95, 15, 20);
        add(mLabel);

        sStartField = ComponentFactory.createTextField(fields[2], 0, 59);
        sStartField.setBounds(220, 95, 30, 20);
        add(sStartField);
        sLabel = new JLabel();
        sLabel.setText("S");
        sLabel.setBounds(250, 95, 15, 20);
        add(sLabel);


        fields = secToHourMinSec(bean.getStopTime().getVal());

        stopLabel = new JLabel();
        stopLabel.setText("Stop at");
        stopLabel.setBounds(20, 120, 70, 20);
        add(stopLabel);

        hStopField = ComponentFactory.createTextField(fields[0], 0, 23);
        hStopField.setBounds(100, 120, 30, 20);
        add(hStopField);
        h1Label = new JLabel();
        h1Label.setText("H");
        h1Label.setBounds(130, 120, 15, 20);
        add(h1Label);

        mStopField = ComponentFactory.createTextField(fields[1], 0, 59);
        mStopField.setBounds(160, 120, 30, 20);
        add(mStopField);
        m1Label = new JLabel();
        m1Label.setText("M");
        m1Label.setBounds(190, 120, 15, 20);
        add(m1Label);

        sStopField = ComponentFactory.createTextField(fields[2], 0, 59);
        sStopField.setBounds(220, 120, 30, 20);
        add(sStopField);
        s1Label = new JLabel();
        s1Label.setText("S");
        s1Label.setBounds(250, 120, 15, 20);
        add(s1Label);



        countdownCheck = new JCheckBoxTransBG();
        countdownCheck.setText("Countdown");
        countdownCheck.setSelected(bean.getCountDown().getVal());
        countdownCheck.setBounds(20, 150, 120, 20);
        //countdownCheck.addItemListener(mIL);
        add(countdownCheck);


        framesCheck = new JCheckBoxTransBG();
        framesCheck.setText("Frames");
        framesCheck.setSelected(bean.getShowFrames().getVal());
        framesCheck.setBounds(140, 150, 100, 20);
        //countdownCheck.addItemListener(mIL);
        add(framesCheck);


        fontLabel = new JLabel();
        fontLabel.setText("Font");
        fontLabel.setBounds(20, 180, 70, 20);
        add(fontLabel);
        fontCombo = ComponentFactory.createComboBox(bean.getFont().getOptionsName(), bean.getFont().getVal());
        fontCombo.setBounds(70, 180, 230, 20);
        fontCombo.setFont(fontCombo.getFont().deriveFont((float) 9));
        add(fontCombo);

        fontSizeLabel = new JLabel();
        fontSizeLabel.setText("Font Size");
        fontSizeLabel.setBounds(20, 210, 80, 20);
        add(fontSizeLabel);
        fontSizeCombo = ComponentFactory.createComboBox(bean.getFontSize().getOptionsName(), bean.getFontSize().getVal());
        fontSizeCombo.setBounds(120, 210, 60, 20);
        add(fontSizeCombo);


        foregroundLabel = new JLabel();
        foregroundLabel.setText("Foreground");
        foregroundLabel.setBounds(20, 240, 80, 20);
        add(foregroundLabel);
        foregroundCombo = ComponentFactory.createComboBox(bean.getFgColour().getOptionsName(), bean.getFgColour().getVal());
        foregroundCombo.setBounds(120, 240, 180, 20);
        add(foregroundCombo);

        transitionLabel = new JLabel();
        transitionLabel.setText("Transition");
        transitionLabel.setBounds(20, 270, 80, 20);
        add(transitionLabel);
        transitionCombo = ComponentFactory.createComboBox(bean.getTransColour().getOptionsName(), bean.getTransColour().getVal());
        transitionCombo.setBounds(120, 270, 180, 20);
        add(transitionCombo);

        destinationLabel = new JLabel();
        destinationLabel.setText("Destination");
        destinationLabel.setBounds(20, 300, 80, 20);
        add(destinationLabel);
        destinationCombo = ComponentFactory.createComboBox(bean.getDestColour().getOptionsName(), bean.getDestColour().getVal());
        destinationCombo.setBounds(120, 300, 180, 20);
        add(destinationCombo);

        backgroundLabel = new JLabel();
        backgroundLabel.setText("Background");
        backgroundLabel.setBounds(20, 330, 80, 20);
        add(backgroundLabel);
        backgroundCombo = ComponentFactory.createComboBox(bean.getBgColour().getOptionsName(), bean.getBgColour().getVal());
        backgroundCombo.setBounds(120, 330, 180, 20);
        add(backgroundCombo);

        checkComponentEnablingConditions();

    }

    public void save() {
        bean.getBgColour().setVal(backgroundCombo.getSelectedItem().toString());
        bean.getCountDown().setVal(countdownCheck.isSelected());
        bean.getDestColour().setVal(destinationCombo.getSelectedItem().toString());
        bean.getFgColour().setVal(foregroundCombo.getSelectedItem().toString());
        bean.getFont().setVal(fontCombo.getSelectedItem().toString());
        bean.getFontSize().setVal(fontSizeCombo.getSelectedItem().toString());
        bean.getGpiSource().setVal(gpiSourceCombo.getSelectedItem().toString());
        bean.getShowFrames().setVal(framesCheck.isSelected());
        bean.getStartTime().setVal(HourMinSecToSecs(new int[]{Integer.valueOf(hStartField.getText()),Integer.valueOf(mStartField.getText()),Integer.valueOf(sStartField.getText())}));
        bean.getStopTime().setVal(HourMinSecToSecs(new int[]{Integer.valueOf(hStopField.getText()),Integer.valueOf(mStopField.getText()),Integer.valueOf(sStopField.getText())}));
        bean.getTransColour().setVal(transitionCombo.getSelectedItem().toString());
        bean.getTriggerGpi().setVal(gpiRadio.isSelected());


    }

    private void checkComponentEnablingConditions() {

        gpiSourceCombo.setEnabled(gpiRadio.isSelected());
        stopLabel.setEnabled(!gpiRadio.isSelected());
        hStopField.setEnabled(!gpiRadio.isSelected());
        mStopField.setEnabled(!gpiRadio.isSelected());
        sStopField.setEnabled(!gpiRadio.isSelected());

    }

    private class MyItemListener implements ItemListener {

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
