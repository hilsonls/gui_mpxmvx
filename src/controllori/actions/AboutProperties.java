
package controllori.actions;

import controllori.Action;
import dialogs.about.AboutDialog;
import eccezioni.MVException;
import gui.CtrlActions;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class AboutProperties extends Action {

    public AboutProperties(){
        this.actionStringId = "About";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        new AboutDialog(frame, CtrlActions.getInstance().getIdModulo());
    }

}
