
package controllori.actions;

import controllori.Action;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.MultiViewerPanel;
import gui.TileObject;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class AssignSource extends Action {

    public AssignSource(){
        this.actionStringId = "AssignSource";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        String itemType = "";
        CtrlActions ctrlActions = CtrlActions.getInstance();
        TileObject tileObject = ctrlActions.getTilesWorkspace().getSelectedObject();

        //TODO: metodo che dal nome della sorgente nel tileobject richiama la sorgente con l'id giusto
        if (tileObject != null) {
            itemType = tileObject.getItemType();
            if (itemType.compareTo("Video") == 0 || itemType.compareTo("Audio") == 0) {
                //setta l'id nel bean
                ctrlActions.getTilesWorkspace().getSelectedObject().getBean().getObjectSequence().getVidAudProperties().getVidAudSource().setVal("Source " + MultiViewerPanel.getInstance().idSorgenteSelezionato + " ");
                //manda al server le modifiche
                CtrlWorkspace.getInstance().saveSourceAssignedToObjectToMV(ctrlActions.getIdModulo(), ctrlActions.getTilesWorkspace().getSelectedObject().getBean());
            //CtrlWorkspace.getInstance().checkInvalidObjectsFromMV(idModulo);
            } else {

                JOptionPane.showMessageDialog(null, "The selected object has no source", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
