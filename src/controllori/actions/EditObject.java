
package controllori.actions;

import controllori.Action;
import dialogs.editobject.EditObjectDialog;
import eccezioni.MVException;
import gui.CtrlActions;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author panda
 */
public class EditObject extends Action {

    public EditObject(){
        this.actionStringId = "Edit";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        if(CtrlActions.getInstance().getTilesWorkspace().getSelectedObject() != null)
        {
            new EditObjectDialog(frame,CtrlActions.getInstance().getTilesWorkspace(), CtrlActions.getInstance().getIdModulo());
        }
    }

}
