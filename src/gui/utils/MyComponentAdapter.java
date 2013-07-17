

package gui.utils;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author antonio
 */
public class MyComponentAdapter extends ComponentAdapter {

    @Override
    public void componentResized(ComponentEvent componentevent) {
        if (resized) {
            return;
        } else {
            splitPanel.setResizeWeight(resizeWeight);
            splitPanel.setDividerLocation(dividerLocation);
            resized = true;
            return;
        }
    }
    private boolean resized;
    private double resizeWeight;
    private double dividerLocation;
    private JSplitPane splitPanel;


    public MyComponentAdapter (JSplitPane panel, double resizeWeight,  double dividerLocation) {
        this.splitPanel = panel;
        this.resizeWeight = resizeWeight;
        this.dividerLocation = dividerLocation;
        this.resized = false;
    }
}
