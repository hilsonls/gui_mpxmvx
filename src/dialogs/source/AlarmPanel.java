

package dialogs.source;

import bean.Alarm;
import bean.Source;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class AlarmPanel extends JPanelBGGradient{
    private Source bean;
    
    private JScrollPane alarmPane;
    private JList alarmList;
    
    private JLabel selectAlarmLabel;
    private JLabel propertiesLabel;
    private JCheckBox[] enabledCheck;
    
    private JLabel alarmDelaySecondsLabel;
    private JTextField[] alarmDelaySecondsField;
            
    private JCheckBox[] automaticClearingCheck;
    private JLabel automaticDelayLabel;
    private JTextField[] automaticClearingDelayField;
    
    private JCheckBox[] loggingCheck;
    private JCheckBox[] showInObjectCheck;
    private JCheckBox[] showInAlarmListCheck;
    private JCheckBox[] sendSNMPCheck;
        
    class AlarmPanelCellRenderer
        implements ListCellRenderer
    {

        public Component getListCellRendererComponent(JList jlist, Object obj, int i, boolean isSelected, boolean hasFocus)
        {
            JLabel jlabel = new JLabel();
            String s = (String)obj;
            jlabel.setText(s);
            if(enabledCheck[i].isSelected())
                jlabel.setIcon(green);
            else
                jlabel.setIcon(red);
            jlabel.setIconTextGap(4);
            jlabel.setHorizontalAlignment(2);
            if(isSelected){
                jlabel.setForeground(Color.red);
            }
            return jlabel;
        }

        
        ImageIcon red;
        ImageIcon green;

        public AlarmPanelCellRenderer()
        {
            URL url = getClass().getResource("/icons/" + "redBullet.gif");
            if(url != null)
                red = new ImageIcon(url);
            else red = new ImageIcon("icons\\"+ "redBullet.gif");
            url = getClass().getResource("/icons/" + "greenBullet.gif");
            if(url != null)
                green = new ImageIcon(url); 
            else green = new ImageIcon("icons\\"+ "greenBullet.gif");
        }
    }    
        
        class AlarmPanelListListener
        implements ListSelectionListener
    {

        public void valueChanged(ListSelectionEvent listselectionevent)
        {
            try
            {
                 int i = alarmList.getSelectedIndex();
                 changePropertiesVisibility(lastIndex, i);
                 lastIndex = i;
                    
                 alarmList.repaint();
            }
            catch(Exception exception) { }
        }

        AlarmPanelListListener()
        {
            lastIndex = 0;
        }
        
        private int lastIndex;
    }
    
    class AlarmPanelItemListener
        implements ItemListener
    {

        public void itemStateChanged(ItemEvent itemevent)
        {
            
                try
                {
                    alarmList.repaint();
                    //int i = alarmList.getSelectedIndex();
                    //changePropertiesVisibility(lastIndex, i);
                    //lastIndex = i;
                    //source.alarms[i].active = enabledCheck.isSelected();
                    
                }
                catch(Exception exception1) { }
            
        }

        AlarmPanelItemListener()
        {
            
        }
        
        
    }
        
    
    
    //nasconde i parametri con lastindex e mostra i parametri con newIndex
    private void changePropertiesVisibility(int lastIndex, int newIndex){
        enabledCheck[lastIndex].setVisible(false);
        alarmDelaySecondsField[lastIndex].setVisible(false); 
        automaticClearingCheck[lastIndex].setVisible(false);
        automaticClearingDelayField[lastIndex].setVisible(false); 
        loggingCheck[lastIndex].setVisible(false); 
        showInObjectCheck[lastIndex].setVisible(false); 
        showInAlarmListCheck[lastIndex].setVisible(false); 
        sendSNMPCheck[lastIndex].setVisible(false);
        
        enabledCheck[newIndex].setVisible(true);
        alarmDelaySecondsField[newIndex].setVisible(true);
        automaticClearingCheck[newIndex].setVisible(true);
        automaticClearingDelayField[newIndex].setVisible(true);
        loggingCheck[newIndex].setVisible(true);
        showInObjectCheck[newIndex].setVisible(true);
        showInAlarmListCheck[newIndex].setVisible(true);
        sendSNMPCheck[newIndex].setVisible(true);
    }
    
    public AlarmPanel(Source bean) {
        //setto dimensione panel
        setLayout(null);
        setBounds(1, 30, 430, 400);
        
        //setto action e item listeners;
        AlarmPanelItemListener alarmPanelItemListener = new AlarmPanelItemListener();
        AlarmPanelListListener alarmlistlistener = new AlarmPanelListListener();
        alarmList = new JList();
        alarmList.addListSelectionListener(alarmlistlistener);
        alarmList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //associo bean e creo riferimenti a oggetti bean
        this.bean = bean;
        Alarm [] alarm = bean.getAlarms().getAlarm();
              
        //logica implementativa di condizioni del menu
        int numAlarms = alarm.length;
        
        //oggetti interfaccia utente
        
        
        selectAlarmLabel = new JLabel("Select alarm");
        selectAlarmLabel.setFont(new Font("Arial",Font.BOLD,11));
        selectAlarmLabel.setBounds(15,25,80,20);
        add(selectAlarmLabel);
        
        alarmPane = new JScrollPane();
        alarmPane.setOpaque(true);
        add(alarmPane);
        alarmPane.setBounds(10, 50, 210, 300);
        
        DefaultListModel alarmModel = new DefaultListModel();
        for (int i = 0; i < numAlarms; i++){
            alarmModel.addElement(new String(alarm[i].getTitle().getVal()));
        }
        alarmList.setModel(alarmModel);
        alarmList.setSelectedIndex(0);
        alarmList.setCellRenderer(new AlarmPanelCellRenderer());
        alarmList.setBorder((BevelBorder)BorderFactory.createBevelBorder(0));
        alarmPane.getViewport().add(alarmList);
        alarmList.setBounds(0, 0, 210, 300);
        
        propertiesLabel = new JLabel("Properties");
        propertiesLabel.setFont(new Font("Arial",Font.BOLD,11));
        propertiesLabel.setBounds(235,25,80,20);
        add(propertiesLabel);
        
        enabledCheck = new JCheckBox[numAlarms];
        alarmDelaySecondsField = new JTextField[numAlarms];
        automaticClearingCheck = new JCheckBox[numAlarms];
        automaticClearingDelayField = new JTextField[numAlarms];
        loggingCheck = new JCheckBox[numAlarms];
        showInObjectCheck = new JCheckBox[numAlarms];
        showInAlarmListCheck =  new JCheckBox[numAlarms];
        sendSNMPCheck = new JCheckBox[numAlarms];
        
        for (int i = 0; i < numAlarms; i++){
            enabledCheck[i] = new JCheckBoxTransBG();
            enabledCheck[i].setName(Integer.toString(i));
            enabledCheck[i].setText("Enabled");
            enabledCheck[i].setBounds(235, 50, 200, 20);
            enabledCheck[i].addItemListener(alarmPanelItemListener);
            enabledCheck[i].setVisible(false);
            enabledCheck[i].setSelected(alarm[i].getEnabled().getVal());
            add(enabledCheck[i]);
            
            alarmDelaySecondsField[i] = ComponentFactory.createTextField(alarm[i].getDelay().getVal(), alarm[i].getDelay().getMin(), alarm[i].getDelay().getMax());
            alarmDelaySecondsField[i].setBounds(335,80,75,20);
            alarmDelaySecondsField[i].setVisible(false);
            add(alarmDelaySecondsField[i]);
            
            automaticClearingCheck[i] = new JCheckBoxTransBG();
            automaticClearingCheck[i].setName(Integer.toString(i));
            automaticClearingCheck[i].setText("Automatic clearing");
            automaticClearingCheck[i].setBounds(235, 110, 150, 20);
            automaticClearingCheck[i].setVisible(false);
            automaticClearingCheck[i].setSelected(alarm[i].getAutoReset().getVal());
            add(automaticClearingCheck[i]);
            
            automaticClearingDelayField[i] = ComponentFactory.createTextField(alarm[i].getAutoResetDelay().getVal(), alarm[i].getAutoResetDelay().getMin(), alarm[i].getAutoResetDelay().getMax());
            automaticClearingDelayField[i].setBounds(335,140,75,20);
            automaticClearingDelayField[i].setVisible(false);
            add(automaticClearingDelayField[i]);
            
            loggingCheck[i] = new JCheckBoxTransBG();
            loggingCheck[i].setName(Integer.toString(i));
            loggingCheck[i].setText("Logging");
            loggingCheck[i].setBounds(235, 190, 150, 20);
            loggingCheck[i].setVisible(false);
            loggingCheck[i].setSelected(alarm[i].getLogging().getVal());
            //add(loggingCheck[i]);
            
            showInObjectCheck[i] = new JCheckBoxTransBG();
            showInObjectCheck[i].setName(Integer.toString(i));
            showInObjectCheck[i].setText("Show in objects");
            showInObjectCheck[i].setBounds(235, 220, 150, 20);
            showInObjectCheck[i].setVisible(false);
            showInObjectCheck[i].setSelected(alarm[i].getShowInObjects().getVal());
            add(showInObjectCheck[i]);
            
            showInAlarmListCheck[i] = new JCheckBoxTransBG();
            showInAlarmListCheck[i].setName(Integer.toString(i));
            showInAlarmListCheck[i].setText("Show in alarm list");
            showInAlarmListCheck[i].setBounds(235, 250, 150, 20);
            showInAlarmListCheck[i].setVisible(false);
            showInAlarmListCheck[i].setSelected(alarm[i].getShowInList().getVal());
            //add(showInAlarmListCheck[i]);
            
            sendSNMPCheck[i] = new JCheckBoxTransBG();
            sendSNMPCheck[i].setName(Integer.toString(i));
            sendSNMPCheck[i].setText("Send SNMP");
            sendSNMPCheck[i].setBounds(235, 280, 150, 20);
            sendSNMPCheck[i].setVisible(false);
            sendSNMPCheck[i].setSelected(alarm[i].getSnmp().getVal());
            add(sendSNMPCheck[i]);
           
        }
        //visualizzo le proprietà del primo allarme;
        enabledCheck[0].setVisible(true);
        alarmDelaySecondsField[0].setVisible(true);
        automaticClearingCheck[0].setVisible(true);
        automaticClearingDelayField[0].setVisible(true);
        loggingCheck[0].setVisible(true);
        showInObjectCheck[0].setVisible(true);
        showInAlarmListCheck[0].setVisible(true);
        sendSNMPCheck[0].setVisible(true);
        
        
        //label e altri oggetti non vettori
        alarmDelaySecondsLabel = new JLabel("Delay (seconds)");
        alarmDelaySecondsLabel.setBounds(235,80,90,20);
        add(alarmDelaySecondsLabel);
        
        automaticDelayLabel = new JLabel("Delay (seconds)");
        automaticDelayLabel.setBounds(235,140,90,20);
        add(automaticDelayLabel);
        
    }
    
    public void save() {
        save(null);
    }
    
    public void save(Source bean) {
        if (bean==null)
            bean = this.bean;
        
        Alarm [] alarm = bean.getAlarms().getAlarm();
        
        for (int i = 0; i < alarm.length; i++){
             alarm[i].getEnabled().setVal(enabledCheck[i].isSelected());
             alarm[i].getDelay().setVal(Integer.valueOf(alarmDelaySecondsField[i].getText()));
             alarm[i].getAutoReset().setVal(automaticClearingCheck[i].isSelected());
             alarm[i].getAutoResetDelay().setVal(Integer.valueOf(automaticClearingDelayField[i].getText()));
             alarm[i].getLogging().setVal(loggingCheck[i].isSelected());
             alarm[i].getShowInObjects().setVal(showInObjectCheck[i].isSelected());
             alarm[i].getShowInList().setVal(showInAlarmListCheck[i].isSelected());
             alarm[i].getSnmp().setVal(sendSNMPCheck[i].isSelected());
        }
    }
}
