package controllori.actions;

import controllori.Action;
import eccezioni.MVException;
import gui.CtrlActions;

/**
 *
 * @author antonio
 */
public class AutoUpdate extends Action {

    public AutoUpdate() {
        this.actionStringId = "Auto";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {

        CtrlActions ctrlActions = CtrlActions.getInstance();
        ctrlActions.toggleAutoUpdate();
        ctrlActions.updateGUI();
    }
}
