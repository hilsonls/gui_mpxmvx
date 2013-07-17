
package controllori.actions;

import bean.FrontButton;
import controllori.Action;
import controllori.CtrlProtocol;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.MultiViewerPanel;

/**
 *
 * @author antonio
 */
public class UpdateLayout extends Action {

    public UpdateLayout(){
        this.actionStringId = "Update";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        //COMMITTO I CAMBIAMENTI
        CtrlProtocol.getInstance().commit(CtrlActions.getInstance().getIdModulo());
        FrontButton fb = CtrlProtocol.getInstance().queryFrontButton(CtrlActions.getInstance().getIdModulo());
        MultiViewerPanel.getInstance().updateFrontPanelLayout(fb.getVal());
        //AGGIORNO PrEvIeW
        CtrlActions.getInstance().reloadAllPreviewsFromTilesWorkspace();
    }

}
