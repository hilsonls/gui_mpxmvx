package controllori.actions;

import controllori.Action;
import eccezioni.MVException;
import gui.CtrlActions;

/**
 *
 * @author antonio
 */
public class Grid3x3 extends Action {

    public Grid3x3() {
        this.actionStringId = "3x3";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {

        CtrlActions ctrlActions = CtrlActions.getInstance();
        ctrlActions.getTilesWorkspace().setGrid(3, 3);
    }
}
