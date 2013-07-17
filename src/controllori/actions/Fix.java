package controllori.actions;

import controllori.Action;
import eccezioni.MVException;
import gui.CtrlActions;

/**
 *
 * @author antonio
 */
public class Fix extends Action {

    public Fix() {
        this.actionStringId = "Fix";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {

        CtrlActions ctrlActions = CtrlActions.getInstance();
        ctrlActions.getTilesWorkspace().toggleSnapToGrid();
        ctrlActions.updateGUI();
    }
}
