
package controllori.actions;

import bean.Oggetto;
import controllori.Action;
import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import controllori.ProductType;
import eccezioni.CloneBeanException;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.TileObject;

/**
 *
 * @author antonio
 */
public class Add extends Action {

    public Add(){
        this.actionStringId = "Add";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
   
        CtrlActions ctrlActions = CtrlActions.getInstance();
        //crea oggetto con chiamata al multiviewer
        Oggetto bean = CtrlProtocol.getInstance().nuovoOggetto(ctrlActions.getCurrentScreen());
        //query al multiviewer per recuperare i nuovi ZOrder
        CtrlWorkspace.getInstance().loadObjectsZOrderFromMV(ctrlActions.getIdModulo());
        //aggiunge bean al punto giusto nel workspace
        CtrlWorkspace.getInstance().addObject(ctrlActions.getIdModulo(), bean);

        // Set initial object type to suit the product
        if (CtrlWorkspace.getInstance().getProductType(ctrlActions.getIdModulo()) == ProductType.ProductTypeAM)
            bean.getType().setVal("Audio");
        else
            bean.getType().setVal("Video");
        CtrlWorkspace.getInstance().saveObjectToMV(ctrlActions.getIdModulo(), bean);

        ctrlActions.getTilesWorkspace().addTileObject(bean);

    }

}
