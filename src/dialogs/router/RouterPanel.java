package dialogs.router;

import bean.Router;
import gui.components.JCheckBoxTransBG;
import gui.components.JCheckBoxColored;
import gui.components.JLabelVertical;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;
import eccezioni.MVException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

import controllori.CtrlWorkspace;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RouterPanel extends JPanelBGGradient {

    private Router bean;
    
    private JCheckBox[][] xpCheck;
    private ButtonGroup[] xpOutButtonGroup;
    private XpOutButtonGroupListener xpOutButtonGroupListener[];
    private JButton map1to1Button;
    private JButton mapIn1ToAllButton;
    private JCheckBox useAssignCheck;
    private JButton assignButton;
    private JButton refreshButton;

    private int numOuts;
    private int numIns;
    private int idModulo;

    public RouterPanel(Router bean, int idModulo) throws MVException {
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        
        this.bean = bean;
        this.idModulo = idModulo;

        numOuts = bean.getNumOuts();
        numIns = bean.getNumIns();

        Font labelFont = new Font("Arial", Font.BOLD, 14);
        JLabel label;
        
        label = new JLabel("OUTPUTS", JLabel.CENTER);
        label.setFont(labelFont);
        layout.add(label);
        
        label = new JLabelVertical("INPUTS");
        label.setFont(labelFont);
        layout.addRow(new Component[] 
                {label, createMatrixPanel(), createAssignPanel()},
                GroupLayout.Alignment.CENTER);
        
        map1to1Button = new JButton("Map 1:1");
        map1to1Button.addActionListener(new Map1to1ButtonAction());
        mapIn1ToAllButton = new JButton("Map input 1 to all outputs");
        mapIn1ToAllButton.addActionListener(new mapIn1ToAllButton());
        layout.addRow(new Component[]
                {new JLabel("Quick Map:"), map1to1Button, mapIn1ToAllButton});
    }
    
    /**
     * Create the panel with all the matrix check boxes and input / output
     * names at the side / top.
     * @return  Panel created
     */
    private JPanel createMatrixPanel() {
        createMatrixCheckBoxes();
        createOutButtonGroups();
        
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        VGroupLayout layout = new VGroupLayout(panel);
        panel.setLayout(layout);
        Component xpCheckComponent[][] = new Component[numIns + 1][numOuts + 1];
        
        // xpCheckComponent[row = 0][1..numOuts] is output labels
        xpCheckComponent[0][0] = new JLabel("");
        for (int i = 0; i < numOuts; i++) {
            String text;
            boolean en = false;
            try {
                text = bean.getOut(i).getPhysName();
                en = bean.getOut(i).getRen();
            } catch (java.lang.Exception ex) {
                text = "Out " + (i + 1);
            }
            JLabelVertical label = new JLabelVertical(text);
            label.setClockwise(true);
            label.setEnabled(en);
            xpCheckComponent[0][i + 1] = label;
        }
        
        // xpCheckComponent[1..numIns][0] is input labels
        for (int i = 0; i < numIns; i++) {
            String text;
            boolean en = false;
            try {
                text = bean.getIn(i).getPhysName();
                en = bean.getIn(i).getRen();
            } catch (java.lang.Exception ex) {
                text = "In " + (i + 1);
            }
            JLabel label = new JLabel(text);
            label.setEnabled(en);
            xpCheckComponent[i + 1][0] = label;
        }
        
        // xpCheckComponent[1..numIns][1..numOuts] is xpCheck[0..numOuts-1][0..numIns-1]
        for (int i = 0; i < numOuts; i++) {
            for (int j = 0; j < numIns; j++) {
                xpCheckComponent[j + 1][i + 1] = xpCheck[i][j];
            }
        }
        layout.addGrid(xpCheckComponent, Alignment.CENTER, Alignment.CENTER);
        
        return panel;
    }
    
    private JPanel createAssignPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        VGroupLayout layout = new VGroupLayout(panel);
        panel.setLayout(layout);
        
        useAssignCheck = new JCheckBoxTransBG("Use assign");
        useAssignCheck.setToolTipText("Only apply changes when Assign is pressed");
        assignButton = new JButton("Assign");
        assignButton.setToolTipText("Apply changes");
        refreshButton = new JButton("Refresh");
        refreshButton.setToolTipText("Get current router mapping");
        useAssignCheck.addItemListener(new UseAssignButtonListener());
        useAssignCheck.setSelected(false);
        assignButton.setEnabled(false);
        assignButton.addActionListener(new AssignButtonAction());
        refreshButton.addActionListener(new RefreshButtonAction());
        layout.add(useAssignCheck);
        layout.add(assignButton);
        layout.add(refreshButton);
        
        Dimension d = panel.getMaximumSize();
        d.width = 200;
        panel.setMaximumSize(d);
        
        return panel;
    }

    /**
     * Create the matrix check boxes in xpCheck[numOuts][numIns]
     */
    private void createMatrixCheckBoxes() {
        xpCheck = new JCheckBox[numOuts][numIns];

        for (int i = 0; i < numOuts; i++) {
            for (int j = 0; j < numIns; j++) {
                if (bean.getIn(j).getRen() && bean.getOut(i).getRen())
                    xpCheck[i][j] = new JCheckBoxTransBG();
                else
                    xpCheck[i][j] = new JCheckBoxColored(Color.LIGHT_GRAY, Color.DARK_GRAY);
            }
        }
        
        updateMatrixCheckboxes();
    }
    
    private void updateMatrixCheckboxes() {
        for (int i = 0; i < numOuts; i++) {
            int j = bean.getOut(i).getIn();
            if (0 <= j && j < numIns)
                xpCheck[i][j].setSelected(true);
        }
    }
    
    /**
     * Create the button groups in xpOutGroup[numOuts], adding the relevant
     * columns of check boxes to each group
     */
    private void createOutButtonGroups() {
        xpOutButtonGroup = new ButtonGroup[numOuts];
        xpOutButtonGroupListener = new XpOutButtonGroupListener[numOuts];
        
        for (int i = 0; i < numOuts; i++) {
            xpOutButtonGroup[i] = new ButtonGroup();
            xpOutButtonGroupListener[i] = new XpOutButtonGroupListener(i);
            for (int j = 0; j < numIns; j++) {
                xpOutButtonGroup[i].add(xpCheck[i][j]);
                xpCheck[i][j].addItemListener(xpOutButtonGroupListener[i]);
            }
        }
    }
    
    private void saveOutSource(int out, int in) throws MVException {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        CtrlWorkspace.getInstance().saveRouterOut(idModulo, bean.getId(), out, in);
        bean.getOut(out).setIn(in);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    private void saveAllOuts() {
        for (int i = 0; i < numOuts; i++) {
            for (int j = 0; j < numIns; j++) {
                if (xpCheck[i][j].isSelected()) {
                    try {
                        saveOutSource(i, j);
                    } catch (MVException ex) {
                        // TODO
                    }
                    break;
                }
            }
        }
    }
    
    /**
     * Read the matrix xp assignments and update the checkboxes accordingly
     */
    private void loadMatrixMapping() {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            Router r = CtrlWorkspace.getInstance().loadRouter(idModulo, bean.getId());
            if (r != null) {
                bean = r;
                updateMatrixCheckboxes();
            }
        } catch (MVException ex) {
                // TODO
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private class XpOutButtonGroupListener implements ItemListener {
        
        private int outGroup;
        
        XpOutButtonGroupListener(int i) {
            super();
            outGroup = i;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (!useAssignCheck.isSelected() && e.getStateChange() == ItemEvent.SELECTED) {
                for (int i = 0; i < numIns; i++) {
                    if (xpCheck[outGroup][i].isSelected()) {
                        try {
                            saveOutSource(outGroup, i);
                        } catch (MVException ex) {
                            // TODO
                        }
                        break;
                    }
                }
            }
            
        }
    }
    
    private class UseAssignButtonListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            assignButton.setEnabled(useAssignCheck.isSelected());
        }
    }
    
    private class AssignButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            saveAllOuts();
        }
    }
    
    private class RefreshButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            loadMatrixMapping();
        }
    }
    
    private class Map1to1ButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < numOuts; i++) {
                xpCheck[i][i % numIns].setSelected(true);
            }
        }
    }
    
    private class mapIn1ToAllButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < numOuts; i++) {
                xpCheck[i][0].setSelected(true);
            }
        }
    }
    
}
