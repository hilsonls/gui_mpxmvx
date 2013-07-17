package controllori.actions;

import controllori.Action;
import eccezioni.MVException;
import gui.CtrlActions;

/**
 *
 * @author antonio
 */
public class Grid5x5 extends Action {

    public Grid5x5() {
        this.actionStringId = "5x5";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {

        CtrlActions ctrlActions = CtrlActions.getInstance();
        ctrlActions.getTilesWorkspace().setGrid(5, 5);
    }
}
