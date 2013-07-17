
package controllori.actions;

import bean.Oggetto;
import bean.Parent;
import bean.VidAudSource;
import bean.X;
import bean.Y;
import controllori.Action;
import controllori.CtrlWorkspace;
import eccezioni.CloneBeanException;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.TileObject;

/**
 *
 * @author antonio
 */
public class Paste extends Action {

    public Paste(){
        this.actionStringId = "Paste";
        this.isLongOp = false;
    }

    @Override
    public void doAction() throws MVException {
        
        CtrlActions ctrlActions = CtrlActions.getInstance();
        TileObject tileObject = ctrlActions.getTilesWorkspace().getSelectedObject();
            if(tileObject != null && ctrlActions.isCopyDone())
            {
                Oggetto oggettoSource;
                try {
                    oggettoSource = (Oggetto) CtrlWorkspace.clone(ctrlActions.oggettoToCopy);
                    oggettoSource.setId(tileObject.getId());
                    oggettoSource.getObjectSequence().getVidAudProperties().setVidAudSource((VidAudSource)CtrlWorkspace.clone(tileObject.getBean().getObjectSequence().getVidAudProperties().getVidAudSource()));
                    oggettoSource.setParent((Parent)CtrlWorkspace.clone(tileObject.getBean().getParent()));
                    oggettoSource.getPosition().setX((X)CtrlWorkspace.clone(tileObject.getBean().getPosition().getX()));
                    oggettoSource.getPosition().setY((Y)CtrlWorkspace.clone(tileObject.getBean().getPosition().getY()));
                    oggettoSource.getObjectScreen().setVal(tileObject.getBean().getObjectScreen().getVal());

                } catch (CloneBeanException ex) {
                    throw new MVException("Unable to paste");
                }

                Oggetto oggettoToPaste = tileObject.getBean();

                CtrlWorkspace.getInstance().replaceOggetto(ctrlActions.getIdModulo(), oggettoSource, oggettoToPaste);

                tileObject.loadFromBean(oggettoSource);

                CtrlWorkspace.getInstance().saveObjectToMV(ctrlActions.getIdModulo(), tileObject.getBean());

                //tileObject.updateAspect();

                ctrlActions.getTilesWorkspace().repaint();
            }
    }

}
