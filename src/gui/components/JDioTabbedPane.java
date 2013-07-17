
package gui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 *
 * @author panda
 */
public class JDioTabbedPane extends JTabbedPane {

    public JDioSwitchInterface jdsi = new JDioSwitchInterface() {

        public boolean shouldSwitchTab() {
            return true;
        }
    };

    @Override
    public void setSelectedIndex(int index) {
        Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

// if no tabs are selected
// -OR- the current focus owner is me
// -OR- I request focus from another component and get it
// then proceed with the tab switch

        if (jdsi.shouldSwitchTab() && (getSelectedIndex() == -1 || comp == this || requestFocus(false))) {
            super.setSelectedIndex(index);
        }
    }

    public JDioTabbedPane() {
    }

    

    public JDioTabbedPane(boolean setUI) {
        if(setUI)
            setUI((TabbedPaneUIGradient) TabbedPaneUIGradient.createUI(this));
    }


    public void addTabSwitchHandler(JDioSwitchInterface jdsi){
        this.jdsi = jdsi;
    }


}
