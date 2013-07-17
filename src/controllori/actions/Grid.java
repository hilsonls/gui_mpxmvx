package controllori.actions;

import controllori.Action;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;

/**
 *
 * @author antonio
 */
public class Grid extends Action {

    public Grid() {
        this.actionStringId = "Grid";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {

        CtrlActions ctrlActions = CtrlActions.getInstance();
        if (ctrlActions.getTilesWorkspace().getSelectedObject() != null) {

            //aggiorno la tile
            ctrlActions.getTilesWorkspace().sizeObjectToGrid();

            //crea oggetto con chiamata al multiviewer
            ctrlActions.getTilesWorkspace().getSelectedObject().saveToBean();

            //aggiunge bean al punto giusto nel workspace
            CtrlWorkspace.getInstance().saveObjectToMV(ctrlActions.getIdModulo(), ctrlActions.getTilesWorkspace().getSelectedObject().getBean());



        }

    }
}
