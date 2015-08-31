
package controllori.actions;

import controllori.Action;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.TileObject;
import gui.TilesWorkspace;

import java.awt.Frame;

import javax.swing.JOptionPane;

import dialogs.timercontrol.TimerControlDialog;

/**
 *
 * @author michael
 */
public class OpenTimerControl extends Action {

    public OpenTimerControl(){
        this.actionStringId = "OpenTimerControl";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        TilesWorkspace tilesWorkspace = CtrlActions.getInstance().getTilesWorkspace();
        Frame frame = JOptionPane.getFrameForComponent(tilesWorkspace);
        TileObject tile = tilesWorkspace.getSelectedObject();
        if (tile != null) {
            TimerControlDialog dialog = tile.getTimerControlDialog();
            if (dialog != null)
                dialog.requestFocus();
            else if (tile.getBean().getType().getVal().compareTo("Timer") == 0)
                new TimerControlDialog(frame, tilesWorkspace, CtrlActions.getInstance().getIdModulo());
        }
    }

}
