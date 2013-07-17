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
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 *
 * @author Antonio
 */
public class TabbedPaneUIGradient extends BasicTabbedPaneUI

{



  public static ComponentUI createUI(JComponent c) {

    return new TabbedPaneUIGradient();

  }

  



  public void update(Graphics g, JComponent c) {

      
      
      if (c instanceof JTabbedPane) {

          JTabbedPane tp = (JTabbedPane)c;
          int quantiTab = tp.getTabCount();
          if(quantiTab>0){
          Graphics2D g2d = (Graphics2D) g;

          int w = c.getWidth();
          int h = c.getHeight();

          // Paint a gradient from top to bottom
          GradientPaint gp = new GradientPaint(
                  0, 0, StyleInterface.getInstance().getTabbedPaneSkyTopColor(),
                  0, (quantiTab>5)?34:18, StyleInterface.getInstance().getTabbedPaneSkyBottomColor());

          g2d.setPaint(gp);
          g2d.fillRect(0, 0, w, h);


          paint(g, c);
          }


  }}




}
