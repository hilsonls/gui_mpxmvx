package controllori.actions;

import controllori.Action;
import controllori.ActionSet;
import eccezioni.ActionNotFoundException;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.TileObject;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antonio
 */
public class GroupBack extends Action {

    public GroupBack() {
        this.actionStringId = "GroupBack";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        CtrlActions ctrlActions = CtrlActions.getInstance();
        Vector itemsVector = ctrlActions.getTilesWorkspace().tileObjects;
        Vector groupItemsVector = ctrlActions.getTilesWorkspace().groupObjects;
        TileObject selectedObject = ctrlActions.getTilesWorkspace().getSelectedObject();

        Vector groupVector = new Vector();
        for (int i = 0; i < itemsVector.size(); i++) {
            TileObject tileObject = (TileObject) itemsVector.elementAt(i);
            if (groupItemsVector.contains(tileObject)) {
                groupVector.addElement(tileObject);
            }
        }

        for (int j = 0; j < groupVector.size(); j++) {
            try {
                ctrlActions.getTilesWorkspace().setSelectedObject((TileObject) groupVector.elementAt(j));
                ActionSet.getInstance().getAction("Back").doAction();
            } catch (ActionNotFoundException ex) {
                Logger.getLogger(GroupBack.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



        ctrlActions.getTilesWorkspace().setSelectedObject(selectedObject);
    }
}
