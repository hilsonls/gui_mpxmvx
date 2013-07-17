/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs.layout;

import bean.Layout;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author panda
 */
public class SetupLayoutPanel extends JPanelBGGradient{
    private Layout bean;

    private JLabel backgroundLabel;
    private JComboBox backgroundCombo;

    private JCheckBox bitmapCheck;
    private JComboBox bitmapCombo;
    
    private JLabel styleLabel;
    private JComboBox styleCombo;

    public SetupLayoutPanel(Layout bean) throws MVException {
        MyItemListener mIL = new MyItemListener();
        
        setLayout(null);
        
        this.bean = bean;
        
        backgroundLabel = new JLabel();
        backgroundLabel.setText("Background");
        backgroundLabel.setBounds(20, 30, 80, 20);
        add(backgroundLabel);
        backgroundCombo = ComponentFactory.createComboBox(bean.getBkgnd().getColour().getOptionsName(), bean.getBkgnd().getColour().getVal());
        backgroundCombo.setBounds(120, 30, 180, 20);
        add(backgroundCombo);
        
        bitmapCheck = new JCheckBoxTransBG();
        bitmapCheck.setText("Bitmap");
        bitmapCheck.setBounds(20, 80, 80, 20);
        bitmapCheck.setSelected(bean.getBkgnd().getUseBitmap().getVal());
        bitmapCheck.addItemListener(mIL);
        add(bitmapCheck);
        bitmapCombo = ComponentFactory.createComboBox(bean.getBkgnd().getBitmapFile().getOptionsName(), bean.getBkgnd().getBitmapFile().getVal());
        bitmapCombo.setBounds(120, 80, 180, 20);
        bitmapCombo.setEnabled(bitmapCheck.isSelected());
        add(bitmapCombo);
        
        styleLabel = new JLabel();
        styleLabel.setText("Style");
        styleLabel.setBounds(20, 130, 80, 20);
        add(styleLabel);
        styleCombo = ComponentFactory.createComboBox(bean.getBkgnd().getStyle().getOptionsName(), bean.getBkgnd().getStyle().getVal());
        styleCombo.setBounds(120, 130, 180, 20);
        add(styleCombo);
    }
    
    public void save() {
        bean.getBkgnd().getColour().setVal(backgroundCombo.getSelectedItem().toString());
        
        bean.getBkgnd().getUseBitmap().setVal(bitmapCheck.isSelected());
        try {
            bean.getBkgnd().getBitmapFile().setVal(bitmapCombo.getSelectedItem().toString());
        } catch (NullPointerException npe) {
            
        }
        
        bean.getBkgnd().getStyle().setVal(styleCombo.getSelectedItem().toString());
    }
     
    private void checkComponentEnablingConditions() {
        bitmapCombo.setEnabled(bitmapCheck.isSelected());
        
        //controlli per evitare che si possa selezionare il check quando non ci sono elementi nella lista
        //e che sia sempre selezionato un elemento della lista quando il check è selezionato
        if (bitmapCheck.isSelected()) {
            if (bitmapCombo.getModel().getSize() == 0) {
                bitmapCheck.setSelected(false);
            } else if (bitmapCombo.getSelectedIndex() == -1) {
                bitmapCombo.setSelectedIndex(0);
            }
        }
    }
    
    private class MyItemListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            checkComponentEnablingConditions();
        }
        
    }
}
