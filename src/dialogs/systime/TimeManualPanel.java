package dialogs.systime;

import bean.CurrTime;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.style.StyleInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TimeManualPanel extends JPanel {

    private JLabel timeLabel;
    private JTextField hourField;
    private JLabel colon1Label;
    private JTextField minuteField;
    private JLabel colon2Label;
    private JTextField secondField;

    private JLabel dateLabel;
    private JTextField dayField;
    private JLabel slash1Label;
    private JTextField monthField;
    private JLabel slash2Label;
    private JTextField yearField;
    
    private JButton getButton;
    private JButton setButton;
    
    private CurrTime bean;
    private int idModulo;

    public TimeManualPanel(CurrTime bean,int idModulo) {
        setLayout(null);
        this.bean = bean;
        this.idModulo = idModulo;

        setBorder(BorderFactory.createCompoundBorder((BorderFactory.createTitledBorder("Set Time")), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        
        timeLabel = new JLabel();
        timeLabel.setText("Time (hh:mm:ss)");
        timeLabel.setBounds(20, 35, 100, 20);
        add(timeLabel);
        hourField = ComponentFactory.createTextField(bean.getHour(), 0, 23, true);
        hourField.setBounds(145, 35, 25, 20);
        add(hourField);
        colon1Label = new JLabel();
        colon1Label.setText(":");
        colon1Label.setBounds(174, 35, 7, 20);
        add(colon1Label);
        minuteField = ComponentFactory.createTextField(bean.getMinute(), 0, 59, true);
        minuteField.setBounds(181, 35, 25, 20);
        add(minuteField);
        colon2Label = new JLabel();
        colon2Label.setText(":");
        colon2Label.setBounds(210, 35, 7, 20);
        add(colon2Label);
        secondField = ComponentFactory.createTextField(bean.getSecond(), 0, 59, true);
        secondField.setBounds(217, 35, 25, 20);
        add(secondField);
        
        dateLabel = new JLabel();
        dateLabel.setText("Date (dd/mm/yyyy)");
        dateLabel.setBounds(20, 75, 110, 20);
        add(dateLabel);
        dayField = ComponentFactory.createTextField(bean.getDay(), 1, 31, true);
        dayField.setBounds(145, 75, 25, 20);
        add(dayField);
        slash1Label = new JLabel();
        slash1Label.setText("/");
        slash1Label.setBounds(172, 75, 8, 20);
        add(slash1Label);
        monthField = ComponentFactory.createTextField(bean.getMonth(), 1, 12, true);
        monthField.setBounds(181, 75, 25, 20);
        add(monthField);
        slash2Label = new JLabel();
        slash2Label.setText("/");
        slash2Label.setBounds(207, 75, 8, 20);
        add(slash2Label);
        yearField = ComponentFactory.createTextField(bean.getYear(), 1970, 2038);
        yearField.setBounds(217, 75, 35, 20);
        add(yearField);
        
        ActionListener buttonActionListener = new ButtonActionListener();
        getButton = new JButton();
        getButton.setText("Get");
        getButton.setActionCommand("get");
        getButton.addActionListener(buttonActionListener);
        getButton.setBounds(64, 120, 60, 25);
        add(getButton);
        setButton = new JButton();
        setButton.setText("Set");
        setButton.setActionCommand("set");
        setButton.addActionListener(buttonActionListener);
        setButton.setBounds(144, 120, 60, 25);
        add(setButton);

        setOpaque(false);
    }

    private class ButtonActionListener implements ActionListener {

        public void actionPerformed(ActionEvent actionevent) {
            Object obj = actionevent.getSource();
            if (obj == getButton) {
                try {
                    bean = CtrlWorkspace.getInstance().loadCurrentTimeFromMV(idModulo);
                    hourField.setText(Integer.toString(bean.getHour()));
                    minuteField.setText(Integer.toString(bean.getMinute()));
                    secondField.setText(Integer.toString(bean.getSecond()));
                    dayField.setText(Integer.toString(bean.getDay()));
                    monthField.setText(Integer.toString(bean.getMonth()));
                    yearField.setText(Integer.toString(bean.getYear()));
                } catch (MVException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error has occurred while comunicating with " + StyleInterface.getInstance().getFrameTitle() + ".", "Cannot get system time", JOptionPane.ERROR_MESSAGE);
                }
            } else if (obj == setButton) {
                try {
                    bean.setHour(Integer.parseInt(hourField.getText()));
                    bean.setMinute(Integer.parseInt(minuteField.getText()));
                    bean.setSecond(Integer.parseInt(secondField.getText()));
                    bean.setDay(Integer.parseInt(dayField.getText()));
                    bean.setMonth(Integer.parseInt(monthField.getText()));
                    bean.setYear(Integer.parseInt(yearField.getText()));
                    CtrlWorkspace.getInstance().saveCurrentTimeToMV(idModulo);
                } catch (MVException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error has occurred while comunicating with " + StyleInterface.getInstance().getFrameTitle() + ".", "Cannot set system time", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
