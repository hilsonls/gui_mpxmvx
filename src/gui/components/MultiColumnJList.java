/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.components;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author panda
 */
public class MultiColumnJList extends JList {
    
    public MultiColumnJList() {
        super();
        setCellRenderer(new MyCellRenderer());
    }
    
    static class MyCellRenderer extends JPanel implements ListCellRenderer{
        JLabel left, right;
        
        MyCellRenderer() {
            setLayout(new GridLayout(1, 2));
            left = new JLabel();
            right = new JLabel();
            left.setOpaque(true);
            right.setOpaque(true);
            add(left);
            add(right);
        }

        public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus){
            String leftData = ((String[])value)[0];
            String rightData = ((String[])value)[1];
            left.setText(leftData);
            right.setText(rightData);
            if(isSelected){
                left.setBackground(list.getSelectionBackground());
                left.setForeground(list.getSelectionForeground());
                right.setBackground(list.getSelectionBackground());
                right.setForeground(list.getSelectionForeground());
            } else {
                left.setBackground(list.getBackground());
                left.setForeground(list.getForeground());
                right.setBackground(list.getBackground());
                right.setForeground(list.getForeground());
            }
            setEnabled(list.isEnabled());
            setFont(list.getFont());
            return this;
        }
    }
}
