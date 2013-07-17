package dialogs.systime;

import bean.VitcSource;
import eccezioni.MVException;
import gui.ComponentFactory;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

class TimeVitcPanel extends JPanel {

    private JLabel sourceLabel;
    private JComboBox sourceCombo;

    private VitcSource bean;
    private int idModulo;

    public TimeVitcPanel(VitcSource bean,int idModulo) throws MVException {
        setLayout(null);
        this.bean = bean;
        this.idModulo = idModulo;

        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("VITC Source"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        
        sourceLabel = new JLabel();
        sourceLabel.setText("Source");
        sourceLabel.setBounds(40, 30, 60, 20);
        add(sourceLabel);
        sourceCombo = ComponentFactory.createComboBox(bean.getOptionsName(), bean.getVal());
        sourceCombo.setBounds(120, 30, 120, 20);
        add(sourceCombo);

        setOpaque(false);
    }
    
    public void save() {
        bean.setVal(sourceCombo.getSelectedItem().toString());
    }

    
}
