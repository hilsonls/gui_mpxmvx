package gui.components;

import javax.swing.Icon;
import javax.swing.JLabel;

public class JLabelVertical extends JLabel {

    public JLabelVertical() {
        setUI(new VerticalLabelUI(false));
    }

    public JLabelVertical(String text) {
        super(text);
        setUI(new VerticalLabelUI(false));
        setVerticalAlignment(CENTER);
    }

    public JLabelVertical(Icon image) {
        super(image);
        setUI(new VerticalLabelUI(false));
    }

    public JLabelVertical(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        setUI(new VerticalLabelUI(false));
    }

    public JLabelVertical(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
        setUI(new VerticalLabelUI(false));
    }

    public JLabelVertical(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        setUI(new VerticalLabelUI(false));
    }
    
    public void setClockwise(boolean b) {
        ((VerticalLabelUI) getUI()).setClockwise(b);
    }

}
