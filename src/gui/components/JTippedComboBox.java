
package gui.components;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import javax.swing.JComboBox;

/**
 *
 * @author germano mosconi
 */
public class JTippedComboBox extends JComboBox {
    
    public JTippedComboBox(Vector listaValori) {
        super(listaValori);
        addItemListener(new JTippedPanelItemListener());
        if(getSelectedItem()!=null)
            setToolTipText(getSelectedItem().toString());
    }
    
    private class JTippedPanelItemListener
        implements ItemListener
    {

        public void itemStateChanged(ItemEvent itemevent)
        {
            JComboBox oggetto = (JComboBox)itemevent.getSource();
            if(oggetto.getSelectedItem()!=null)
                oggetto.setToolTipText(oggetto.getSelectedItem().toString());
        }

        JTippedPanelItemListener()
        {
        }
    }
}
