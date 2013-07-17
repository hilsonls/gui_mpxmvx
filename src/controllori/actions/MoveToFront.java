
package controllori.actions;

import bean.ObjectsZOrder;
import controllori.Action;
import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.TileObject;

/**
 *
 * @author antonio
 */
public class MoveToFront extends Action {

    public MoveToFront(){
        this.actionStringId = "Front";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {

        CtrlActions ctrlActions = CtrlActions.getInstance();
        TileObject tileObject = ctrlActions.getTilesWorkspace().getSelectedObject();
        if (tileObject != null) {
            //crea objectsZOrder con chiamata al multiviewer
            ObjectsZOrder bean = CtrlProtocol.getInstance().moveToFront(tileObject.getBean());
            //aggiunge bean al punto giusto nel workspace
            CtrlWorkspace.getInstance().setObjectsZOrder(ctrlActions.getIdModulo(), bean);
        }
        ctrlActions.getTilesWorkspace().moveObjectToFront();

    }

}
