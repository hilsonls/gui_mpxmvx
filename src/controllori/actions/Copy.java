
package controllori.actions;

import bean.Oggetto;
import controllori.Action;
import controllori.CtrlWorkspace;
import eccezioni.CloneBeanException;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.TileObject;

/**
 *
 * @author antonio
 */
public class Copy extends Action {

    public Copy(){
        this.actionStringId = "Copy";
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
                } catch (CloneBeanException ex) {
                    throw new MVException("Unable to copy");
                }
            }
    }

}
