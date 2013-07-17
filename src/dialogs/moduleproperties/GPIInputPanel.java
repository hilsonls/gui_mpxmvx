package dialogs.moduleproperties;

import bean.GpiInNameTable;
import bean.GpiInTaskTable;
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
public class GPIInputPanel extends JPanelBGGradient{

    private Gpis bean;

    private JLabel gpiNameTitle;
    private JLabel gpiTaskTitle;

    private JLabel[] gpiNameLabel;
    private JComboBox[] gpiTaskCombo;

    private GpiInNameTable gpiInNameTable;
    private GpiInTaskTable gpiInTaskTable;

    public GPIInputPanel(Gpis bean, int idModulo) throws MVException{
        setLayout(null);
        setBounds(1, 30, 430, 400);

        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(null);

        this.bean = bean;

        gpiNameLabel = new JLabel[bean.getGpiInfo().getNumIns().getVal()];
        gpiTaskCombo = new JComboBox[bean.getGpiInfo().getNumIns().getVal()];
        gpiInNameTable = CtrlWorkspace.getInstance().getGpiInNameTable(bean.getGpiInfo().getGpiOptionTables().getGpiInName(),idModulo);
        gpiInTaskTable = CtrlWorkspace.getInstance().getGpiInTaskTable(bean.getGpiInfo().getGpiOptionTables().getGpiInTask(),idModulo);

        int y = 0;

        OptionsList optionsList = new OptionsList();
        for (int t = 0; t < gpiInTaskTable.getGpiInTaskNameCount(); t++){
            Name name = new Name();
            name.setVal(gpiInTaskTable.getGpiInTaskName(t).getVal());
            optionsList.addName(name);
        }


        for (int i = 0; i < bean.getGpiInfo().getNumIns().getVal(); i++){

            gpiNameLabel[i] = new JLabel();
            gpiNameLabel[i].setText(getStringNameFromIDName(bean.getGpiIn(i).getId()));
            gpiNameLabel[i].setBounds(10, 15+y, 140, 20);
            scrollPanel.add(gpiNameLabel[i]);

            gpiTaskCombo[i] = ComponentFactory.createComboBox(optionsList, bean.getGpiIn(i).getVal());
            gpiTaskCombo[i].setSelectedItem(getStringTaskFromIDTask(getIDTaskFromIDName(gpiInNameTable.getGpiInNameName(i).getIntval())));
            gpiTaskCombo[i].setBounds(160, 15+y, 250, 20);
            scrollPanel.add(gpiTaskCombo[i]);

            y+=30;
        }

        scrollPanel.setPreferredSize(new Dimension(410, 30*bean.getGpiInfo().getNumIns().getVal()+15));
        scrollPanel.setOpaque(false);
        scrollPanel.setBorder(null);

        JScrollPane scroll = new JScrollPane();
        scroll.setOpaque(false);
        scroll.setBounds(-1, 32, 430, 386);
        scroll.getViewport().add(scrollPanel);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);

        gpiNameTitle = new JLabel();
        gpiNameTitle.setText("GPI Input Name");
        gpiNameTitle.setBounds(10, 10, 150, 20);
        add(gpiNameTitle);

        gpiTaskTitle = new JLabel();
        gpiTaskTitle.setText("GPI Input Task");
        gpiTaskTitle.setBounds(160, 10, 150, 20);
        add(gpiTaskTitle);

        add(scroll);


    }

    public void save() {
        for (int i = 0; i < bean.getGpiInfo().getNumIns().getVal(); i++){
            bean.getGpiIn(i).setVal(gpiTaskCombo[i].getSelectedItem().toString());
            bean.getGpiIn(i).setIntval(getIntTaskFromStringTask(gpiTaskCombo[i].getSelectedItem().toString()));
        }
    }

    private String getStringNameFromIDName( int id){

        String name = null;

        for (int i = 0; i < gpiInNameTable.getGpiInNameNameCount(); i++){

            if (gpiInNameTable.getGpiInNameName(i).getIntval() == id)
                name = gpiInNameTable.getGpiInNameName(i).getVal();

        }

        return name;

    }

    private int getIDTaskFromIDName(int intval) {
        int idTask = -1;

        for (int i = 0; i < bean.getGpiInCount(); i++){

            if (intval == bean.getGpiIn(i).getId()){
                idTask = bean.getGpiIn(i).getIntval();
                break;
            }

        }
        return idTask;
    }

    private String getStringTaskFromIDTask(int idTask){

        String task = null;

        for (int i = 0; i < gpiInTaskTable.getGpiInTaskNameCount(); i++){

            if (gpiInTaskTable.getGpiInTaskName(i).getIntval() == idTask)
                task = gpiInTaskTable.getGpiInTaskName(i).getVal();

        }

        return task;

    }

    private int getIntTaskFromStringTask(String task) {

        int idTask = -1;

        for (int i = 0; i < gpiInTaskTable.getGpiInTaskNameCount(); i++){

            if (gpiInTaskTable.getGpiInTaskName(i).getVal().equals(task)){
                idTask = gpiInTaskTable.getGpiInTaskName(i).getIntval();
                break;
            }

        }

        return idTask;
    }
 
}
