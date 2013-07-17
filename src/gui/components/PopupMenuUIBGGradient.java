/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.components;

import gui.style.StyleInterface;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.plaf.PopupMenuUI;
import javax.swing.plaf.basic.BasicPopupMenuUI;

/**
 *
 * @author antonio
 */
public class PopupMenuUIBGGradient extends BasicPopupMenuUI{

    
    private Color topColor = StyleInterface.getInstance().getJMenuTopColor();
    private Color bottomColor = StyleInterface.getInstance().getJMenuBottomColor();
    
    
    @Override
    public void paint(Graphics g, JComponent c) {
        
        if ( !c.isOpaque( ) )
        {
            super.paint( g,c );
            return;
        }
        
        
        Graphics2D g2d = (Graphics2D)g;
    
        int w = c.getWidth( );
        int h = c.getHeight( );
        
                // Paint a gradient from top to bottom
        GradientPaint gp = new GradientPaint(
                0, 0, topColor,
                0, h, bottomColor);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);

        c.setOpaque(false);
        super.paint(g,c);
        c.setOpaque(true);
    
    }

    
    
    @Override
    public boolean isPopupTrigger(MouseEvent e) 
		{
		   return super.isPopupTrigger(e);
		}
		
    @Override
		public Popup getPopup(JPopupMenu popup, int x, int y) {
			PopupFactory popupFactory = PopupFactory.getSharedInstance();
			
			return popupFactory.getPopup(popup.getInvoker(), popup, x, y);
		}
}
