
package controllori.actions;

import controllori.Action;
import dialogs.about.LogFilesDialog;
import eccezioni.MVException;
import gui.CtrlActions;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author michael
 */
public class Logging extends Action {

    public Logging(){
        this.actionStringId = "Logging";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        new LogFilesDialog(frame, CtrlActions.getInstance().getIdModulo());
    }

}
