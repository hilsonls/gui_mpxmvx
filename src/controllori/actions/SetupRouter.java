package controllori.actions;

import controllori.Action;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;
import dialogs.router.RouterDialog;
import javax.swing.JOptionPane;
import java.awt.Frame;
import bean.Router;

public class SetupRouter extends Action {

    public SetupRouter() {
        this.actionStringId = "SetupRouter";
        this.isLongOp = false;
    }
    
    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        CtrlActions ctrlActions = CtrlActions.getInstance();
        Router r = CtrlWorkspace.getInstance().getRouter(CtrlActions.getInstance().getIdModulo(), -1);
        if (r != null)
            RouterDialog.OpenModeless(frame, ctrlActions.getIdModulo(), r);
    }
}
