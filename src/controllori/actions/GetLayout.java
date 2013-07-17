
package controllori.actions;

import controllori.Action;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;

/**
 *
 * @author antonio
 */
public class GetLayout extends Action {

    public GetLayout(){
        this.actionStringId = "Get";
        this.isLongOp = true;
    }

    @Override
    public void doAction() throws MVException {
        if (CtrlWorkspace.getInstance() == null) {
            System.out.print("Unable to connect");
            System.exit(-1);
            //TODO: gestire problema di connessione
        }

        //faccio il read degli elementi a schermo
        CtrlWorkspace.getInstance().getLayoutFromMV(CtrlActions.getInstance().getIdModulo());

        CtrlActions.getInstance().reloadAllLayoutsAndPreviews();
    }

}
