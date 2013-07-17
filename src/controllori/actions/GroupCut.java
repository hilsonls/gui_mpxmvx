
package controllori.actions;

import controllori.Action;
import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.TileObject;
import java.util.Vector;

/**
 *
 * @author antonio
 */
public class GroupCut extends Action {

    public GroupCut(){
        this.actionStringId = "GroupCut";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        CtrlActions ctrlActions = CtrlActions.getInstance();
        Vector groupItemsVector = new Vector(ctrlActions.getTilesWorkspace().groupObjects);
        TileObject selectedObject = ctrlActions.getTilesWorkspace().getSelectedObject();

        for(; groupItemsVector.size() > 0; groupItemsVector = new Vector(ctrlActions.getTilesWorkspace().groupObjects))
            {
                ctrlActions.getTilesWorkspace().setSelectedObject((TileObject)groupItemsVector.elementAt(0));
                TileObject tileObject = ctrlActions.getTilesWorkspace().getSelectedObject();
                if(tileObject != null){

                    CtrlProtocol.getInstance().cutOggetto(tileObject.getBean());


                    CtrlWorkspace.getInstance().cutObject(ctrlActions.getIdModulo(), tileObject.getBean());

                    ctrlActions.getTilesWorkspace().removeTileObject();

                }

            }
            //query al multiviewer per recuperare i nuovi ZOrder
            CtrlWorkspace.getInstance().loadObjectsZOrderFromMV(ctrlActions.getIdModulo());
            ctrlActions.getTilesWorkspace().loadTilesFromBean();
            ctrlActions.getTilesWorkspace().applyZOrder();
            ctrlActions.getTilesWorkspace().setSelectedObject(selectedObject);
    }

}
