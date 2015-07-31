package dialogs.moduleproperties;

import java.util.ArrayList;

import eccezioni.MVException;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;

/**
 * @author Michael
 */
public class AudioMonitorPanelCollection extends JPanelBGGradient {
    
    private VGroupLayout layout;
    
    private ArrayList<AudioOutputPanelGeneric> panel;
    
    public AudioMonitorPanelCollection(int idModulo) throws MVException {
        layout = new VGroupLayout(this);
        setLayout(layout);
        
        panel = new ArrayList<AudioOutputPanelGeneric>();
    }
    
    public void add(AudioOutputPanelGeneric audioPanel) {
        panel.add(audioPanel);
        layout.add(audioPanel);
    }
    
    public void save() {
        for (AudioOutputPanelGeneric p : panel)
            p.save();
    }
}
