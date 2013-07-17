
package controllori.actions;

import bean.Oggetto;
import controllori.Action;
import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import eccezioni.CloneBeanException;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.TileObject;

/**
 *
 * @author antonio
 */
public class Cut extends Action {

    public Cut(){
        this.actionStringId = "Cut";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        
        CtrlActions ctrlActions = CtrlActions.getInstance();
        TileObject tileObject = ctrlActions.getTilesWorkspace().getSelectedObject();
            if(tileObject != null)
            {
                try {
                    ctrlActions.oggettoToCopy = (Oggetto) CtrlWorkspace.clone(tileObject.getBean());
                    ctrlActions.setCopyDone(true);

                    CtrlProtocol.getInstance().cutOggetto(tileObject.getBean());
                    //query al multiviewer per recuperare i nuovi ZOrder
                    CtrlWorkspace.getInstance().loadObjectsZOrderFromMV(ctrlActions.getIdModulo());

                    CtrlWorkspace.getInstance().cutObject(ctrlActions.getIdModulo(), tileObject.getBean());

                    ctrlActions.getTilesWorkspace().removeTileObject();
                    ctrlActions.getTilesWorkspace().loadTilesFromBean();
                    ctrlActions.getTilesWorkspace().applyZOrder();

                } catch (CloneBeanException ex) {
                    throw new MVException("Unable to copy");
                }
            }



    }

}
