package controllori.actions;

import controllori.Action;
import eccezioni.MVException;
import gui.CtrlActions;

/**
 *
 * @author antonio
 */
public class Grid4x4 extends Action {

    public Grid4x4() {
        this.actionStringId = "4x4";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {

        CtrlActions ctrlActions = CtrlActions.getInstance();
        ctrlActions.getTilesWorkspace().setGrid(4, 4);
    }
}
