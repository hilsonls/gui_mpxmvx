
package controllori.actions;

import controllori.Action;
import dialogs.layout.LayoutDialog;
import eccezioni.MVException;
import gui.CtrlActions;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class DeleteLayout extends Action {

    public DeleteLayout(){
        this.actionStringId = "Delete";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        new LayoutDialog(frame, CtrlActions.getInstance().getIdModulo(), LayoutDialog.DELETE);
    }

}
