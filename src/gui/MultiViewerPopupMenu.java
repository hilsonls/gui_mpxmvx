/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import gui.style.StyleInterface;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Antonio
 */
public class MultiViewerPopupMenu extends JPopupMenu {
    
    private Color topColor;
    private Color bottomColor;
    
    public MultiViewerPopupMenu() {
        super();
        topColor = StyleInterface.getInstance().getJMenuTopColor();
        bottomColor = StyleInterface.getInstance().getJMenuBottomColor();
    }

    @Override
    public void paintComponent(Graphics g) {
   
    if ( !isOpaque( ) )
    {
        super.paintComponent( g );
        return;
    }
 
    Graphics2D g2d = (Graphics2D)g;
    
    int w = getWidth( );
    int h = getHeight( );
        
                // Paint a gradient from top to bottom
        GradientPaint gp = new GradientPaint(
                0, 0, topColor,
                0, h, bottomColor);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);

        setOpaque(false);
        super.paintComponent(g);
        setOpaque(true);
    }
    
    
    
}
