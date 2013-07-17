
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
public class LoadLayout extends Action {

    public LoadLayout(){
        this.actionStringId = "Load";
        this.isLongOp = true;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        new LayoutDialog(frame, CtrlActions.getInstance().getIdModulo(), LayoutDialog.LOAD);
    }

}
