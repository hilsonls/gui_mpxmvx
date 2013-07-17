package controllori.actions;

import controllori.Action;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;

/**
 *
 * @author antonio
 */
public class Screen extends Action {

    public Screen() {
        this.actionStringId = "Screen";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {

        CtrlActions ctrlActions = CtrlActions.getInstance();
        if(ctrlActions.getTilesWorkspace().getSelectedObject()!=null){

                //aggiorno la tile
                ctrlActions.getTilesWorkspace().sizeObjectToScreen();

                //crea oggetto con chiamata al multiviewer
                ctrlActions.getTilesWorkspace().getSelectedObject().saveToBean();

                //aggiunge bean al punto giusto nel workspace
                CtrlWorkspace.getInstance().saveObjectToMV(ctrlActions.getIdModulo(), ctrlActions.getTilesWorkspace().getSelectedObject().getBean());


                return;

             }

    }
}
