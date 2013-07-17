
package controllori.actions;

import controllori.Action;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.MultiViewerPanel;

/**
 *
 * @author antonio
 */
public class LoadLayoutFromTree extends Action {

    public LoadLayoutFromTree(){
        this.actionStringId = "LoadLayout";
        this.isLongOp = true;
    }

    @Override
    public void doAction() throws MVException {
        CtrlWorkspace.getInstance().loadLayout(CtrlActions.getInstance().getIdModulo(),  MultiViewerPanel.getInstance().nodoSelezionato.getValue());
        CtrlActions.getInstance().reloadAllTilesWorkspaces();
        CtrlActions.getInstance().setLayoutTitle();
    }

}
