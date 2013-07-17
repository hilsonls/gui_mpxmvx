package controllori.actions;

import controllori.Action;
import eccezioni.MVException;
import gui.CtrlActions;

/**
 *
 * @author antonio
 */
public class Grid6x6 extends Action {

    public Grid6x6() {
        this.actionStringId = "6x6";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {

        CtrlActions ctrlActions = CtrlActions.getInstance();
        ctrlActions.getTilesWorkspace().setGrid(6, 6);
    }
}
