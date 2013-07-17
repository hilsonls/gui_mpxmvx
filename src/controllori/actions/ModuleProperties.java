
package controllori.actions;

import controllori.Action;
import dialogs.moduleproperties.ModulePropertiesDialog;
import eccezioni.MVException;
import gui.CtrlActions;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class ModuleProperties extends Action {

    public ModuleProperties(){
        this.actionStringId = "Module";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        new ModulePropertiesDialog(frame, CtrlActions.getInstance().getIdModulo());
    }

}
