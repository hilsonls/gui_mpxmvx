
package controllori.actions;

import controllori.Action;
import controllori.CtrlWorkspace;
import dialogs.source.SourcePropertiesDialog;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.TileObject;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class SourceProperties extends Action {

    public SourceProperties(){
        this.actionStringId = "Source";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        Frame frame = JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace());
        CtrlActions ctrlActions = CtrlActions.getInstance();
        String itemType = "";
        TileObject tileObject = ctrlActions.getTilesWorkspace().getSelectedObject();

        //TODO: metodo che dal nome della sorgente nel tileobject richiama la sorgente con l'id giusto
        if(tileObject != null)
            itemType = tileObject.getItemType();
        if(itemType.compareTo("Video") == 0 || itemType.compareTo("Audio") == 0)
        {
            //prendo la sorgente dell'oggetto selezionato
            String sorgente = tileObject.getBean().getObjectSequence().getVidAudProperties().getVidAudSource().getVal();
            int idSorgente = Integer.valueOf(sorgente.replaceAll("Source ","").trim());

            new SourcePropertiesDialog(frame,CtrlWorkspace.getInstance().getSource(ctrlActions.getIdModulo(), idSorgente), ctrlActions.getIdModulo());
            CtrlActions.getInstance().reloadAllTilesWorkspaces();
            //ctrlActions.getTilesWorkspace().repaintWorkspace();
        } else
        {

            JOptionPane.showMessageDialog(null,"The selected object has no source","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

}
