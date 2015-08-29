
package controllori.actions;

import controllori.Action;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;

import java.awt.Frame;

import javax.swing.JOptionPane;

import dialogs.audiochannelnames.AudioChannelNamesDialog;

/**
 *
 * @author michael
 */
public class AudioChannelNames extends Action {

    public AudioChannelNames(){
        this.actionStringId = "AudioChannelNames";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        new AudioChannelNamesDialog(frame, CtrlActions.getInstance().getIdModulo());
    }

}
