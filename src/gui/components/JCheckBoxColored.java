package gui.components;

import java.awt.Color;

import javax.swing.Icon;

public class JCheckBoxColored extends JCheckBoxTransBG {

    public JCheckBoxColored() {
    }
    
    public JCheckBoxColored(Color defColor, Color selColor) {
        super();
        setIcon(defColor, selColor);
    }

    public JCheckBoxColored(String text, Color defColor, Color selColor) {
        super(text);
        setIcon(defColor, selColor);
    }

    private void setIcon(Color defColor, Color selColor) {
        Icon defIcon = new ColourCheckBoxIcon(defColor);
        Icon selIcon = new ColourCheckBoxIcon(selColor);
        setIcon(defIcon);
        setSelectedIcon(selIcon);
    }
}
