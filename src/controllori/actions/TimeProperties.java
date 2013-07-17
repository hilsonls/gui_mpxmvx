
package controllori.actions;

import controllori.Action;
import dialogs.systime.TimeDialog;
import eccezioni.MVException;
import gui.CtrlActions;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class TimeProperties extends Action {

    public TimeProperties(){
        this.actionStringId = "Time";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        new TimeDialog(frame, CtrlActions.getInstance().getIdModulo());
    }

}
