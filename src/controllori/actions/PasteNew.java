
package controllori.actions;

import controllori.Action;
import controllori.ActionSet;
import controllori.CtrlWorkspace;
import eccezioni.ActionNotFoundException;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.MultiViewerPanel;
import gui.TileObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class PasteNew extends Action {

    public PasteNew(){
        this.actionStringId = "PasteNew";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        
        CtrlActions ctrlActions = CtrlActions.getInstance();
        if (ctrlActions.isCopyDone()) {
            try {
                ActionSet.getInstance().getAction("Add").doAction();
                ActionSet.getInstance().getAction("Paste").doAction();

            } catch (ActionNotFoundException ex) {
                ex.printStackTrace();
            }
            }
    }

}
