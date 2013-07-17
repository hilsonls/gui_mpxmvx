
package controllori.actions;

import controllori.Action;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;

/**
 *
 * @author antonio
 */
public class Undo extends Action {

    public Undo(){
        this.actionStringId = "Undo";
        this.isLongOp = true;
    }

    @Override
    public void doAction() throws MVException {
        
        CtrlActions ctrlActions = CtrlActions.getInstance();
        if(CtrlWorkspace.getInstance().undo(ctrlActions.getIdModulo())){
                CtrlWorkspace.getInstance().saveObjectsToMV(ctrlActions.getIdModulo());
                CtrlWorkspace.getInstance().saveObjectsZOrderToMV(ctrlActions.getIdModulo());
                //ricarico tutti i tilesWorkspace
                ctrlActions.reloadAllTilesWorkspaces();
            }
    }

}
