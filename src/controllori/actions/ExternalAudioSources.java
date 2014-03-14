
package controllori.actions;

import controllori.Action;
import controllori.CtrlWorkspace;
import dialogs.source.AudioSourcePropertiesDialog;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.TileObject;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author michael
 */
public class ExternalAudioSources extends Action {

    public ExternalAudioSources(){
        this.actionStringId = "ExternalAudioSources";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        CtrlActions ctrlActions = CtrlActions.getInstance();
        new AudioSourcePropertiesDialog(frame, ctrlActions.getIdModulo(), CtrlWorkspace.getInstance().getAudioSources(CtrlActions.getInstance().getIdModulo()));
    }

}
