
package controllori.actions;

import controllori.Action;
import controllori.CtrlProtocol;
import eccezioni.MVException;
import gui.CtrlActions;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class ResetModule extends Action {

    public ResetModule(){
        this.actionStringId = "Reset";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        int selection = JOptionPane.showConfirmDialog(frame, "Are you sure you want to reset the module?" , "Reset", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                switch (selection) {
                    case JOptionPane.YES_OPTION:
                            CtrlProtocol.getInstance().reset(CtrlActions.getInstance().getIdModulo());
                            break;
                }

    }

}
