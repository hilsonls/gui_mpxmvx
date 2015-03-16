package gui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.UIManager;

public class ColourCheckBoxIcon implements Icon {

    private Color color;
    private int width, height;
    
    public ColourCheckBoxIcon(Color iconColor) {
        color = iconColor;
        Icon icon = UIManager.getIcon("CheckBox.icon");
        width = icon.getIconWidth();
        height = icon.getIconHeight();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }

}
