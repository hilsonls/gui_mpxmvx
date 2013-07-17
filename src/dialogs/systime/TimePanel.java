package dialogs.systime;

import bean.SysTime;
import eccezioni.MVException;
import gui.components.JPanelBGGradient;
import gui.components.JTippedComboBox;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author panda
 */
public class TimePanel extends JPanelBGGradient {
    private JLabel modeLabel;
    private JComboBox modeCombo;

    private TimeManualPanel manualPanel;
    private TimeNtpPanel ntpPanel;
    private TimeVitcPanel vitcPanel;
    
    private SysTime bean;
    private int idModulo;
    
    public TimePanel(SysTime sysTime, int idModulo, Frame frame) throws MVException {
        setLayout(null);
        this.bean = sysTime;
        this.idModulo = idModulo;
        
        modeLabel = new JLabel();
        modeLabel.setText("Mode");
        modeLabel.setBounds(50, 30, 50, 20);
        add(modeLabel);
        Vector<String> listaValori = new Vector(4);
        listaValori.add("Manual");
        listaValori.add("NTP");
        listaValori.add("LTC");
        listaValori.add("VITC");
        modeCombo = new JTippedComboBox(listaValori);
        modeCombo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JComboBox jcb = (JComboBox)e.getSource();
                String selected = (String)jcb.getSelectedItem();
                if (selected.equals("Manual")) {
                    manualPanel.setVisible(true);
                    ntpPanel.setVisible(false);
                    vitcPanel.setVisible(false);
                } else if (selected.equals("NTP")) {
                    manualPanel.setVisible(false);
                    ntpPanel.setVisible(true);
                    vitcPanel.setVisible(false);
                } else if (selected.equals("VITC")) {
                    manualPanel.setVisible(false);
                    ntpPanel.setVisible(false);
                    vitcPanel.setVisible(true);
                } else {
                    manualPanel.setVisible(false);
                    ntpPanel.setVisible(false);
                    vitcPanel.setVisible(false);
                }
            }
        });
        modeCombo.setBounds(100, 30, 150, 20);
        add(modeCombo);
        
        manualPanel = new TimeManualPanel(bean.getCurrTime(), idModulo);
        manualPanel.setBounds(15, 70, 270, 180);
        add(manualPanel);
        
        ntpPanel = new TimeNtpPanel(bean, idModulo, frame);
        ntpPanel.setBounds(15, 70, 270, 180);
        add(ntpPanel);
        
        vitcPanel = new TimeVitcPanel(bean.getVitcSource(), idModulo);
        vitcPanel.setBounds(15, 70, 270, 180);
        add(vitcPanel);
        
        modeCombo.setSelectedItem(bean.getSyncMode().getVal());
    }
    
    public void save() {
        bean.getSyncMode().setVal(modeCombo.getSelectedItem().toString());
        vitcPanel.save();
    }
}
