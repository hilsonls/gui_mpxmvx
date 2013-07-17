package controllori.actions;

import controllori.Action;
import controllori.ActionSet;
import eccezioni.ActionNotFoundException;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.TileObject;
import java.util.Vector;

/**
 *
 * @author antonio
 */
public class GroupPaste extends Action {

    public GroupPaste() {
        this.actionStringId = "GroupPaste";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        CtrlActions ctrlActions = CtrlActions.getInstance();
        Vector groupItemsVector = ctrlActions.getTilesWorkspace().groupObjects;
        TileObject selectedObject = ctrlActions.getTilesWorkspace().getSelectedObject();

        for (int i = 0; i < groupItemsVector.size(); i++) {
            try {
                ctrlActions.getTilesWorkspace().setSelectedObject((TileObject) groupItemsVector.elementAt(i));
                ActionSet.getInstance().getAction("Paste").doAction();
            } catch (ActionNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        ctrlActions.getTilesWorkspace().setSelectedObject(selectedObject);
    }
}
