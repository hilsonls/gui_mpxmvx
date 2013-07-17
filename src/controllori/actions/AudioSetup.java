
package controllori.actions;

import controllori.Action;
import controllori.CtrlWorkspace;
import dialogs.audiosetup.AudioSetupDialog;
import dialogs.moduleproperties.ModulePropertiesDialog;
import eccezioni.MVException;
import gui.CtrlActions;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class AudioSetup extends Action {

    public AudioSetup(){
        this.actionStringId = "AudioSetup";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        new AudioSetupDialog(frame, CtrlActions.getInstance().getIdModulo(), CtrlWorkspace.getInstance().getAudioSetup(CtrlActions.getInstance().getIdModulo()));
    }

}
