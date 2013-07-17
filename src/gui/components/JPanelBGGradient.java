
package gui.components;

import gui.style.StyleInterface;
import gui.style.StyleInterface;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Antonio
 */
public class JPanelBGGradient extends JPanel{

    private Color topColor;
    private Color bottomColor;
    private boolean vistaStyle;

    public JPanelBGGradient (){
        topColor= StyleInterface.getInstance().getPanelBackgroundTopColor();
        bottomColor = StyleInterface.getInstance().getPanelBackgroundBottomColor();
        this.vistaStyle = false;
    }

    public JPanelBGGradient (Color topColor, Color bottomColor){
        this.topColor = topColor;
        this.bottomColor = bottomColor;
        this.vistaStyle = false;
    }

    public JPanelBGGradient (Color topColor, Color bottomColor, boolean vistaStyle){
        this.topColor = topColor;
        this.bottomColor = bottomColor;
        this.vistaStyle = true;
    }

    @Override
    protected void paintComponent( Graphics g ) 
{
    if ( !isOpaque( ) )
    {
        super.paintComponent( g );
        return;
    }
 
    Graphics2D g2d = (Graphics2D)g;
    
    int w = getWidth( );
    int h = getHeight( );

    if(vistaStyle){
        int rgbGap = 0;
        Color topMidColor ;
        Color botMidColor;
        rgbGap = Math.abs(topColor.getRed() -  bottomColor.getRed()) / 3;
        if(topColor.getRed() > bottomColor.getRed()){
            int rgb = topColor.getRed() - rgbGap;
            topMidColor = new Color(rgb,rgb,rgb);
                rgb -= rgbGap;
                botMidColor = new Color(rgb, rgb, rgb);
            } else {
                int rgb = bottomColor.getRed() - rgbGap;
                botMidColor = new Color(rgb, rgb, rgb);
                rgb -= rgbGap;
                topMidColor = new Color(rgb, rgb, rgb);
            }

            // Paint a gradient from top to bottom
            GradientPaint gp = new GradientPaint(
                    0, 0, topColor,
                    0, h/2, topMidColor);

            g2d.setPaint(gp);
            g2d.fillRect(0, 0, w, h/2);

            int min = Math.min(topColor.getRed(), bottomColor.getRed());
            int lineRgb = min + Math.abs(topColor.getRed() - bottomColor.getRed()) / 2;
            g.setColor(new Color(lineRgb,lineRgb,lineRgb));
            g.drawLine(0, h/2, w, h/2);

            gp = new GradientPaint(0,h/2+1, botMidColor, 0,h, bottomColor );
            g2d.setPaint(gp);
            g2d.fillRect(0, h/2+1, w, h);

            setOpaque(false);
            super.paintComponent(g);
            setOpaque(true);

    }
    else


    {
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

}
