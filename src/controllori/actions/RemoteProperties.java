
package controllori.actions;

import controllori.Action;
import dialogs.remote.RemoteDialog;
import eccezioni.MVException;
import gui.CtrlActions;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class RemoteProperties extends Action {

    public RemoteProperties(){
        this.actionStringId = "Remote";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        new RemoteDialog(frame, CtrlActions.getInstance().getIdModulo());
    }

}
