
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
public class HaltModule extends Action {

    public HaltModule(){
        this.actionStringId = "Halt";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        int selection = JOptionPane.showConfirmDialog(frame, "Are you sure you want to halt the module?" , "Halt", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                switch (selection) {
                    case JOptionPane.YES_OPTION:
                            CtrlProtocol.getInstance().halt(CtrlActions.getInstance().getIdModulo());
                            break;
                }

    }

}
