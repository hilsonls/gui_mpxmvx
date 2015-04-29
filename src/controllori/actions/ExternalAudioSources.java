
package controllori.actions;

import controllori.Action;
import controllori.CtrlWorkspace;
import controllori.ProductType;
import dialogs.source.AMProductSourcePropertiesDialog;
import dialogs.source.AudioSourcePropertiesDialog;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.TileObject;

import java.awt.Frame;

import javax.swing.JOptionPane;

/**
 *
 * @author michael
 */
public class ExternalAudioSources extends Action {

    public ExternalAudioSources(){
        this.actionStringId = "ExternalAudioSources";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        CtrlActions ctrlActions = CtrlActions.getInstance();
        int idModulo = ctrlActions.getIdModulo();
        if (CtrlWorkspace.getInstance().getProductType(idModulo) == ProductType.ProductTypeAM)
            new AMProductSourcePropertiesDialog(frame,
                    CtrlWorkspace.getInstance().getModule(idModulo).getSources().getSource(0),
                    CtrlWorkspace.getInstance().getAudioSources(idModulo),
                    idModulo);
        else
            new AudioSourcePropertiesDialog(frame, idModulo,
                    CtrlWorkspace.getInstance().getAudioSources(idModulo));
    }

}
