package gui.utils;

import gui.*;
import bean.Oggetto;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.components.JIDStringNode;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.tree.TreePath;

public class MyTreeMouseListener implements MouseListener {

    private int id;
    private boolean isOggettoCliccato;
    private boolean isSourceCliccato;
    private boolean isLayoutCliccato;
    private JIDStringNode nodo;

    MultiViewerPanel outer;

    public MyTreeMouseListener(MultiViewerPanel outer) {
        super();
        this.outer = outer;
    }

    public void mouseClicked(MouseEvent e) {
        CtrlActions ctrlActions = CtrlActions.getInstance();
        if (isOggettoCliccato) {
            //MultiviewerEventQueue ha causato il commento della riga sottostante
            //if (e.getClickCount() == 1) {
            setSelectedObject();
            // }
            if (e.getClickCount() > 1) {
                ctrlActions.processAction("Edit");
            }
        } else if (isSourceCliccato) {
            if (e.getClickCount() == 1) {
                if (nodo.getStatus() == JIDStringNode.FREE) {
                    outer.idSorgenteSelezionato = id;
                    ctrlActions.processAction("AssignSource");
                } else if (nodo.getStatus() == JIDStringNode.USED) {
                    id = CtrlWorkspace.getInstance().getIdOggettoBySource(CtrlActions.getInstance().getIdModulo(), id);
                    setSelectedObject();
                }
                
            } else if (e.getClickCount() > 1) {
                try {
                    if ((ctrlActions != null) && (id != -1)) {
                        ctrlActions.setupSourceByJTree(JOptionPane.getFrameForComponent(ctrlActions.getTilesWorkspace()), id);
                    }
                } catch (MVException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (isLayoutCliccato) {
            if ((ctrlActions != null) && (id != -1)) {
                int selection = JOptionPane.showConfirmDialog(null, "Do you want to load the layout?", "Load layout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                switch (selection) {
                    case JOptionPane.YES_OPTION:
                        ctrlActions.processAction("LoadLayout");
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        //prendo le coordinate di click
        int selRow = outer.managementTree.getRowForLocation(e.getX(), e.getY());
        //prendo il path selezionato
        TreePath selPath = outer.managementTree.getPathForLocation(e.getX(), e.getY());
        if (selRow != -1) {
            if (selPath.getPathComponent(1).toString().equals("Objects")) {
                isOggettoCliccato = true;
                isSourceCliccato = false;
                isLayoutCliccato = false;
                outer.managementTree.setSelectionPath(selPath);
                id = ((JIDStringNode) selPath.getLastPathComponent()).getId();
                if (id == -1) {
                    isOggettoCliccato = false;
                    isSourceCliccato = false;
                    isLayoutCliccato = false;
                }
            } else if (selPath.getPathComponent(1).toString().equals("Sources")) {
                isOggettoCliccato = false;
                isSourceCliccato = true;
                isLayoutCliccato = false;
                outer.managementTree.setSelectionPath(selPath);
                nodo = (JIDStringNode) selPath.getLastPathComponent();
                id = nodo.getId();
                if (id == -1) {
                    isOggettoCliccato = false;
                    isSourceCliccato = false;
                    isLayoutCliccato = false;
                    return;
                }
                   //isOggettoCliccato = true;
                    //isSourceCliccato = false;
                    //isLayoutCliccato = false;
                
            } else if (selPath.getPathComponent(1).toString().equals("Layouts")) {
                isOggettoCliccato = false;
                isSourceCliccato = false;
                isLayoutCliccato = true;
                outer.managementTree.setSelectionPath(selPath);
                id = ((JIDStringNode) selPath.getLastPathComponent()).getId();
                outer.nodoSelezionato = (JIDStringNode) selPath.getLastPathComponent();
                if (id == -1) {
                    isOggettoCliccato = false;
                    isSourceCliccato = false;
                    isLayoutCliccato = false;
                }
            } else {
                isOggettoCliccato = false;
                isSourceCliccato = false;
                isLayoutCliccato = false;
                id = -1;
            }
        } else {
            isOggettoCliccato = false;
            isSourceCliccato = false;
            isLayoutCliccato = false;
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    private void setSelectedObject(){
        Oggetto oggetto = CtrlWorkspace.getInstance().getOggetto(CtrlActions.getInstance().getIdModulo(), id);
        int idSchermo = oggetto.getObjectScreen().getVal();
        if (idSchermo != CtrlActions.getInstance().getCurrentScreen()) {
            outer.screenButton[idSchermo].doClick();
        }
        CtrlActions.getInstance().getTilesWorkspace().setSelectedObject(id);
    }
}
