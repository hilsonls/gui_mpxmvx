package dialogs.moduleproperties;

import bean.GpiOutNameTable;
import bean.GpiOutTaskTable;
import bean.Gpis;
import bean.Name;
import bean.OptionsList;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JPanelBGGradient;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author antonio, Epstein-Barr
 */
public class GPOAlarmsPanel extends JPanelBGGradient{

    private Gpis bean;

    private JLabel gpiNameTitle;
    private JLabel gpiTaskTitle;

    private JLabel[] gpiNameLabel;
    private JComboBox[] gpiTaskCombo;

    private GpiOutNameTable gpiOutNameTable;
    private GpiOutTaskTable gpiOutTaskTable;

    public GPOAlarmsPanel(Gpis bean, int idModulo) throws MVException{
        setLayout(null);
        setBounds(1, 30, 430, 400);

        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(null);

        this.bean = bean;

        gpiNameLabel = new JLabel[bean.getGpiInfo().getGpiNumOuts().getVal()];
        gpiTaskCombo = new JComboBox[bean.getGpiInfo().getGpiNumOuts().getVal()];
        gpiOutNameTable = CtrlWorkspace.getInstance().getGpiOutNameTable(bean.getGpiInfo().getGpiOptionTables().getGpiOutName(),idModulo);
        gpiOutTaskTable = CtrlWorkspace.getInstance().getGpiOutTaskTable(bean.getGpiInfo().getGpiOptionTables().getGpiOutTask(),idModulo);

        int y = 0;

        OptionsList optionsList = new OptionsList();
        for (int t = 0; t < gpiOutTaskTable.getGpiOutTaskNameCount(); t++){
            Name name = new Name();
            name.setVal(gpiOutTaskTable.getGpiOutTaskName(t).getVal());
            optionsList.addName(name);
        }


        for (int i = 0; i < bean.getGpiInfo().getGpiNumOuts().getVal(); i++){

            gpiNameLabel[i] = new JLabel();
            gpiNameLabel[i].setText(getStringNameFromIDName(bean.getGpiOut(i).getId()));
            gpiNameLabel[i].setBounds(10, 15+y, 140, 20);
            scrollPanel.add(gpiNameLabel[i]);

            gpiTaskCombo[i] = ComponentFactory.createComboBox(optionsList, bean.getGpiOut(i).getVal());
            gpiTaskCombo[i].setSelectedItem(getStringTaskFromIDTask(getIDTaskFromIDName(gpiOutNameTable.getGpiOutNameName(i).getIntval())));
            gpiTaskCombo[i].setBounds(160, 15+y, 250, 20);
            scrollPanel.add(gpiTaskCombo[i]);

            y+=30;
        }

        scrollPanel.setPreferredSize(new Dimension(410, 30*bean.getGpiInfo().getGpiNumOuts().getVal()+15));
        scrollPanel.setOpaque(false);
        scrollPanel.setBorder(null);

        JScrollPane scroll = new JScrollPane();
        scroll.setOpaque(false);
        scroll.setBounds(-1, 32, 430, 386);
        scroll.getViewport().add(scrollPanel);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);

        gpiNameTitle = new JLabel();
        gpiNameTitle.setText("GPO Output Name");
        gpiNameTitle.setBounds(10, 10, 150, 20);
        add(gpiNameTitle);

        gpiTaskTitle = new JLabel();
        gpiTaskTitle.setText("GPO Output Task");
        gpiTaskTitle.setBounds(160, 10, 150, 20);
        add(gpiTaskTitle);

        add(scroll);


    }

    public void save() {
        for (int i = 0; i < bean.getGpiInfo().getGpiNumOuts().getVal(); i++){
            bean.getGpiOut(i).setVal(gpiTaskCombo[i].getSelectedItem().toString());
            bean.getGpiOut(i).setIntval(getIntTaskFromStringTask(gpiTaskCombo[i].getSelectedItem().toString()));
        }
    }

    private String getStringNameFromIDName( int id){

        String name = null;

        for (int i = 0; i < gpiOutNameTable.getGpiOutNameNameCount(); i++){

            if (gpiOutNameTable.getGpiOutNameName(i).getIntval() == id)
                name = gpiOutNameTable.getGpiOutNameName(i).getVal();

        }

        return name;

    }

    private int getIDTaskFromIDName(int intval) {
        int idTask = -1;

        for (int i = 0; i < bean.getGpiOutCount(); i++){

            if (intval == bean.getGpiOut(i).getId()){
                idTask = bean.getGpiOut(i).getIntval();
                break;
            }

        }
        return idTask;
    }

    private String getStringTaskFromIDTask(int idTask){

        String task = null;

        for (int i = 0; i < gpiOutTaskTable.getGpiOutTaskNameCount(); i++){

            if (gpiOutTaskTable.getGpiOutTaskName(i).getIntval() == idTask)
                task = gpiOutTaskTable.getGpiOutTaskName(i).getVal();

        }

        return task;

    }

    private int getIntTaskFromStringTask(String task) {

        int idTask = -1;

        for (int i = 0; i < gpiOutTaskTable.getGpiOutTaskNameCount(); i++){

            if (gpiOutTaskTable.getGpiOutTaskName(i).getVal().equals(task)){
                idTask = gpiOutTaskTable.getGpiOutTaskName(i).getIntval();
                break;
            }

        }

        return idTask;
    }
 
}
