

package gui.components;

import gui.MultiViewerPopupMenu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;

/**
 *
 * @author Antonio
 */
public class JMenuBGGradient extends JMenu {
    
   
    
    public JMenuBGGradient() {
        super();
        this.setComponentPopupMenu(new JPopupMenuBGGradient());
        setOpaque(false);
        getPopupMenu().setUI(new PopupMenuUIBGGradient());
    }

 
    
    
}
