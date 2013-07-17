/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllori;

import eccezioni.MVException;
import gui.CtrlActions;
import gui.MultiViewerPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author panda
 */
public abstract class Action {
    protected boolean isLongOp;
    protected String actionStringId;

    public String getActionStringId() {
        return actionStringId;
    }
    
    public void execute() {
        CtrlActions ctrlActions = CtrlActions.getInstance();
        

            if (isLongOp) {
                ((JFrame) JOptionPane.getFrameForComponent(ctrlActions.getTilesWorkspace())).getGlassPane().setVisible(true);
                SwingWorker worker = new SwingWorker<Void, Void>() {

                    public Void doInBackground() {
                        serveAction();
                        return null;
                    }

                    @Override
                    public void done() {
                        ((JFrame) JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace())).getGlassPane().setVisible(false);
                    }
                };
                worker.execute();
            } else {
                serveAction();
            }


    }

    private void serveAction() {
        CtrlActions ctrlActions = CtrlActions.getInstance();
        MultiViewerPanel.getInstance().freeze(true);
        try {
            doAction();
                //se non premo undo o redo
            if (actionStringId.compareTo("Undo") != 0 && actionStringId.compareTo("Redo") != 0) {
                CtrlWorkspace.getInstance().commitUndo(CtrlActions.getInstance().getIdModulo());
            }

            //MultiViewerPanel.getInstance().updateUndoRedo();
            ctrlActions.setLayoutTitle();
            //if (comando.compareTo("Undo") == 0 || comando.compareTo("Redo") == 0 || comando.compareTo("New") == 0 || comando.compareTo("Load") == 0 || comando.compareTo("LoadAll") == 0 || comando.compareTo("LoadObj") == 0 || comando.compareTo("Module") == 0 || comando.compareTo("Layout") == 0 || comando.compareTo("Edit") == 0 || comando.compareTo("Add") == 0 || comando.compareTo("Cut") == 0 || comando.compareTo("CutAll") == 0 || comando.compareTo("Paste") == 0 || comando.compareTo("PasteNew") == 0 || comando.compareTo("PasteAll") == 0 || comando.compareTo("Hide") == 0 || comando.compareTo("HideAll") == 0 || comando.compareTo("Front") == 0 || comando.compareTo("FrontAll") == 0 || comando.compareTo("Back") == 0 || comando.compareTo("BackAll") == 0 || comando.compareTo("Fit") == 0 || comando.compareTo("Center") == 0 || comando.compareTo("Grid") == 0 || comando.compareTo("Save") == 0 || comando.compareTo("SaveAs") == 0 || comando.compareTo("Full") == 0) {
            ctrlActions.autoUpdate();
            //}
            MultiViewerPanel.getInstance().freeze(false);
            ctrlActions.updateTree();
            ctrlActions.updateSelectionTree();
            ctrlActions.getTilesWorkspace().updateStateLabel();
        } catch (MVException mvEx) {
            MultiViewerPanel.getInstance().freeze(false);
            JOptionPane.showMessageDialog(null, mvEx.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            CtrlWorkspace.getInstance().rollback(ctrlActions.getIdModulo());
            ctrlActions.getTilesWorkspace().loadTilesFromBean();
        }

    }

    public abstract void doAction() throws MVException;
}
