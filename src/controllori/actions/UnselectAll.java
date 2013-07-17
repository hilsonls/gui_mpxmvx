package controllori.actions;

import controllori.Action;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;

/**
 *
 * @author antonio
 */
public class UnselectAll extends Action {

    public UnselectAll() {
        this.actionStringId = "UnselectAll";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {

        CtrlActions ctrlActions = CtrlActions.getInstance();
        ctrlActions.getTilesWorkspace().unselectAll();
    }
}
