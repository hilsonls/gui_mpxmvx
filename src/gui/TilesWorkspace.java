package gui;

import bean.AspectRatio;
import bean.Objects;
import bean.ObjectsZOrder;
import dialogs.timercontrol.TimerControlDialog;
import eccezioni.ActionNotFoundException;
import eccezioni.CloneBeanException;
import eccezioni.MVException;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;

import javax.swing.*;

import bean.Oggetto;
import controllori.ActionSet;
import controllori.CtrlWorkspace;
import gui.menu.PopupMenuMV;
import gui.style.StyleInterface;
import gui.utils.GUIUtils;
import gui.workspace.ResizeWorkspaceListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TilesWorkspace extends JPanel {

    public static final int MIN_TILE_SIZE = 32;

    private static int RESIZE_ANCHOR_PX = 5;

//  sistema di conversione delle coordinate per utilizzare le dimensioni di oggetti virtuali
    public static double VIRTUALIZER = 1080000D;

    //status bar
    private JLabel stateLabel;
    private JLabel infoLabel;
    public CtrlActions ctrlActions;
    //Vettori di oggetti a schermo
    public Vector tileObjects;
    public Vector groupObjects;
    private Vector childrenObjects;
    private TileObject selectedObject;
    
    //effettiva dimensione in pixel del componente
    private int widthWorkspace;
    private int heightWorkspace;
    private int MvHres;
    private int MvVres;
    //griglia righe per colonne
    private int gridNumColumns;
    private int gridNumRows;
    //wall su cui vengono piazzati gli oggetti (workspace - sky)
    private int wallStartX;
    private int wallStartY;
    private int wallWidth;
    private int wallHeight;
    //oggetti che si incollano alla  griglia
    boolean snapToGrid;
    long snapGap;
    //true se selezionate più oggetti
    //private boolean group;
    //indica se è il preview
    boolean preview;
    //indica se si può utilizzare il workspace
    boolean enabled;
    //indica se sto facendo doppio click per editare l'oggetto
    boolean dblClick;
    //indica se è stato premuto il ctrl e quindi è in atto una selezione
    boolean groupSelecting;
    //indica se si sta facendo un movimento di più oggetti
    boolean movegroup;
    //indica l'azione di movimento dell'oggetto
    boolean moving;
    //indica l'azione di resize dell'oggetto
    boolean resizing;
    //indica il punto in cui è stato cliccato il mouse per iniziare l'azione
    boolean left;
    boolean horizontal;
    boolean top;
    boolean vertical;

    //indica la distanza fra (0,0) della tile e il punto in cui ho cliccato nella tile
    int dX_TileOrigin;
    int dY_TileOrigin;
    //inizio e fine coordinate azione
    int actionX1;
    int actionX2;
    int actionY1;
    int actionY2;
    TilesWorkspaceMouseAdapter TWMA;
    TilesWorkspaceMouseMotionAdapter TWMMA;
    private Image image;
    private Graphics graphics;
    //indica la pressione del tasto ctrl
    private boolean ctrlPress;
    //per il parenting
    private boolean childrenCalculated = false;
    private MultiViewerPopupMenu popupMenu;
    private Objects screenObjects;
    private int idScreen;

    private boolean tileHit;

    public TileObject getSelectedObject() {
        if (tileObjects.size() <= 0) {
            return null;
        }
        if (selectedObject == null) {
            return (TileObject) tileObjects.elementAt(tileObjects.size() - 1);
        } else {
            return selectedObject;
        }
    }

    public void setSelectedObject(TileObject selectedObject) {
        if (tileObjects.indexOf(selectedObject) < 0) {
            this.selectedObject = null;
        } else {
            this.selectedObject = selectedObject;
        }

        //escamotage per aggiornare albero
        ctrlActions.updateTree();
        ctrlActions.updateSelectionTree();
        updateStateLabel();
        repaint();
    }

    //seleziona  l'oggetto a schermo in base all'id passato
    public void setSelectedObject(int id) {

        for (int j = 0; j < tileObjects.size(); j++) {
            TileObject tileObject = (TileObject) tileObjects.elementAt(j);

            //Se l'id del tileObject è uguale all'id
            if (tileObject.getId() == id) {
                //selezione l'oggetto
                setSelectedObject(tileObject);

                break;
            }

        }




    }

    public void setScreenObjects(Objects screenObjects) {
        try {
            Objects objss = (Objects) CtrlWorkspace.clone(screenObjects);
            this.screenObjects = objss;

        } catch (CloneBeanException cbe) {
        }

    }

    /**
     * @return the MvHres
     */
    public int getMvHres() {
        return MvHres;
    }

    /**
     * @param MvHres the MvHres to set
     */
    public void setMvHres(int MvHres) {
        this.MvHres = MvHres;
    }

    /**
     * @return the MvVres
     */
    public int getMvVres() {
        return MvVres;
    }

    /**
     * @param MvVres the MvVres to set
     */
    public void setMvVres(int MvVres) {
        this.MvVres = MvVres;
    }


    class TilesWorkspaceMouseMotionAdapter extends MouseMotionAdapter {

        @Override
        public void mouseDragged(MouseEvent mouseevent) {
            if (enabled && (mouseevent.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) == MouseEvent.BUTTON1_DOWN_MASK) {

                TilesWorkspace tilesWorkspace = (TilesWorkspace) mouseevent.getSource();
                tilesWorkspace.updateMouseAction(mouseevent.getX(), mouseevent.getY());
                handleParentObjects();
            }
        }

        @Override
        public void mouseMoved(MouseEvent mouseevent) {

            if (preview) {
                return;
            }

            //se sto con  il ctrl premuto allora setto il cursore con la croce
            if (ctrlPress) {
                setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            int x = mouseevent.getX();
            int y = mouseevent.getY();



            for (int i = tileObjects.size() - 1; i >= 0; i--) {


                TileObject tileObject = (TileObject) tileObjects.elementAt(i);
                long x1 = virtualToPCScreenX(tileObject.getX());
                long y1 = virtualToPCScreenY(tileObject.getY());
                long x2 = virtualToPCScreenX(tileObject.getX() + tileObject.getWidth());
                long y2 = virtualToPCScreenY(tileObject.getY() + tileObject.getHeight());

                if ((long) x >= x1 && (long) x <= x2 && (long) y >= y1 && (long) y <= y2) {
                    boolean nEdge = y1 <= (long) y && (long) y < y1 + 5L;
                    boolean sEdge = y2 - 5L < (long) y && (long) y <= y2;
                    boolean wEdge = x1 <= (long) x && (long) x < x1 + 5L;
                    boolean eEdge = x2 - 5L < (long) x && (long) x <= x2;

                    //quando è 4:3 o 16:9 si può ridimensionare solo dal bordo destro e sinistro
                    nEdge = nEdge && tileObject.getAspectRatio().equals("None");
                    sEdge = sEdge && tileObject.getAspectRatio().equals("None");
                    //wEdge = wEdge && tileObject.getAspectRatio().equals("None");

                    if (nEdge && eEdge) {
                        setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
                    } else if (nEdge && wEdge) {
                        setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                    } else if (sEdge && eEdge) {
                        setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
                    } else if (sEdge && wEdge) {
                        setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
                    } else if (nEdge) {
                        setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
                    } else if (sEdge) {
                        setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
                    } else if (wEdge) {
                        setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
                    } else if (eEdge) {
                        setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
                    }

                    break;
                }

            }
        }

        TilesWorkspaceMouseMotionAdapter() {
        }
    }

    class TilesWorkspaceMouseAdapter extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            CtrlActions.getInstance().getTilesWorkspace().requestFocusInWindow();
        }



        @Override
        public void mousePressed(MouseEvent mouseevent) {
            childrenObjects = new Vector();

            //se è la preview o è freezzato ritorna
            if (preview || !enabled) {
                return;
            }

            //se clicco il tasto destro (forse) apro il popup menu
            if (mouseevent.isPopupTrigger()) {
                int x = mouseevent.getX();
                int y = mouseevent.getY();
                ((TilesWorkspace) mouseevent.getSource()).beginMouseAction(x, y);
                showPopupMenu(x, y);
                return;
            }


            int x = mouseevent.getX();
            int y = mouseevent.getY();
            mouseX = x;
            mouseY = y;

            dblClick = mouseevent.getClickCount() > 1;
            ((TilesWorkspace) mouseevent.getSource()).beginMouseAction(x, y);

            if (dblClick && !ctrlPress) {
                CtrlActions.getInstance().processAction("Edit");
            }
        }

        @Override
        public void mouseReleased(MouseEvent mouseevent) {
            childrenCalculated = false;

            if (preview || !enabled) {
                return;
            }

            if (mouseevent.isPopupTrigger()) {
                showPopupMenu(mouseevent.getX(), mouseevent.getY());
                return;
            }
            //se clicco e rilascio nello stesso punto non devo fare alcuna azione
            if (mouseevent.getX() == mouseX && mouseevent.getY() == mouseY) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            //se ho usato il primo pulsante allora è un azione di raggruppamento, movimento o ridimensionamento
            if (mouseevent.getButton() == MouseEvent.BUTTON1) {

                ((TilesWorkspace) mouseevent.getSource()).endMouseAction();
                if (ctrlPress) {
                    setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                }
                //stateLabel.setText("TASTO ?! "+ mouseevent.paramString());

            }

        }

        TilesWorkspaceMouseAdapter() {
        }
        private int mouseX;
        private int mouseY;
    }

    class ModifiersKeyListener implements KeyListener {

        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                ctrlPress = true;
            }
        }

        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                ctrlPress = false;
            } else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                try {
                    ActionSet.getInstance().getAction("Cut").execute();
                } catch (ActionNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public TilesWorkspace(JLabel stateLabel, JLabel infoLabel, int idScreen) {
        this.ctrlActions = CtrlActions.getInstance();
        this.stateLabel = stateLabel;
        this.infoLabel = infoLabel;
        this.idScreen = idScreen;
        this.preview = false;
        this.enabled = false;
        this.groupSelecting = false;
        this.snapGap = 30000;
        this.snapToGrid = false;
        this.gridNumColumns = 4;
        this.gridNumRows = 4;

        this.MvHres = CtrlWorkspace.getInstance().getModule(0).getScreen().getResolution().getHres();
        this.MvVres = CtrlWorkspace.getInstance().getModule(0).getScreen().getResolution().getVres();
        this.widthWorkspace = 0;
        this.heightWorkspace = 0;

        this.selectedObject = null;
        this.tileObjects = new Vector();
        this.groupObjects = new Vector();
        this.childrenObjects = new Vector();

        setFocusable(true);
        addKeyListener(new ModifiersKeyListener());
        addComponentListener(new ResizeWorkspaceListener(this));

        TWMMA = new TilesWorkspaceMouseMotionAdapter();
        addMouseMotionListener(TWMMA);
        TWMA = new TilesWorkspaceMouseAdapter();
        addMouseListener(TWMA);
//        addFocusListener(new FocusListener() {
//
//            public void focusGained(FocusEvent e) {
//                //requestFocusInWindow();
//            }
//
//            public void focusLost(FocusEvent e) {
//                requestFocusInWindow();
//            }
//        });

        proporzioniWorkspace();
        updateStateLabel();

        repaint();
    }

    public void showPopupMenu(int x, int y) {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        ctrlPress = false;
        choosePopupMenu(tileHit);
        popupMenu.show(TilesWorkspace.this, x, y);
    }

    public void choosePopupMenu(boolean tileHit) {
        if (this.popupMenu != null) {
            remove(this.popupMenu);
        }
        if (tileHit) {
            popupMenu = PopupMenuMV.getInstance().getPopupMenu(getSelectedObject());
        } else {
            popupMenu = PopupMenuMV.getInstance().getPopupScreenMenu();
        }
        add(this.popupMenu);
    }


    public void proporzioniWorkspace() {

        //setto le proporzioni del workspace su cui sono posizionati gli oggetti
        int propH = (widthWorkspace * getMvVres()) / getMvHres();
        int propV = (heightWorkspace * getMvHres()) / getMvVres();

        if (propH <= heightWorkspace) {
            wallStartX = 0;
            wallStartY = (heightWorkspace - propH) / 2;
            wallWidth = widthWorkspace;
            wallHeight = propH;
        } else {
            wallStartX = (widthWorkspace - propV) / 2;
            wallStartY = 0;
            wallWidth = propV;
            wallHeight = heightWorkspace;
        }

        repaint();
    }

    public void updateStateLabel() {
        if (stateLabel == null) {
            return;
        }
        //stateLabel
        String validMsg = CtrlWorkspace.getInstance().getModule(ctrlActions.getIdModulo()).getModuleValid().getInvalidMsg();
        if (validMsg.equals("")) {
            validMsg = "Valid Workspace";
            stateLabel.setForeground(Color.BLACK);
            stateLabel.setIcon(GUIUtils.getInstance().getIcon("valid.png"));
        } else {
            stateLabel.setForeground(Color.RED);
            stateLabel.setIcon(GUIUtils.getInstance().getIcon("Error.png"));
        }
        stateLabel.setText(validMsg);

        //infoLabel
        TileObject selObj = getSelectedObject();
        String infoText = "";

        if (selObj != null)
            infoText = String.format(" Position: %4d , %4d  -  Size: %4d , %4d", virtualToMVScreenX(selObj.getX()) ,virtualToMVScreenY(selObj.getY()),virtualToMVScreenX(selObj.getWidth()),virtualToMVScreenY(selObj.getHeight()));
        infoLabel.setText(infoText);
    }

    public void setEnabledEdit(boolean flag) {
        enabled = flag;
    }

    public void addTileObject(TileObject tileObject) {
        tileObjects.addElement(tileObject);
        setSelectedObject(tileObject);
    }

    public void addTileObject(Oggetto bean) {
        addTileObject(new TileObject(this, bean));

    }

    public void removeTileObject() {
        TileObject tileObject = getSelectedObject();
        Vector childsToRemove = new Vector();
        if (tileObject != null) {
            for (int i = 0; i < tileObjects.size(); i++) {
                TileObject childObject = (TileObject) tileObjects.elementAt(i);
                if (getParent(childObject.getParentId()) == tileObject) {
                    childsToRemove.add(childObject);
                    
                }
            }
            //TODO: chiedere a Michael se vanno tolti i figli imparentati
            //da aggiustare perchè con il loadfrombean ricarica i figli non eliminati dai beans
            //tileObjects.removeAll(childsToRemove);
            //groupObjects.removeAll(childsToRemove);

            tileObjects.removeElement(tileObject);
            groupObjects.removeElement(tileObject);
        }
    }

    public void fitObjectOntoGrid() {
        long x1, x2 , y1, y2;
        TileObject tileObject = getSelectedObject();
        if (tileObject != null) {
            x1 = gridLeftNearestX(tileObject.getX());
            y1 = gridUpNearestY(tileObject.getY());
            x2 = gridRightNearestX(tileObject.getX() + tileObject.getWidth());
            y2 = gridDownNearestY(tileObject.getY() + tileObject.getHeight());
            tileObject.setX(x1);
            tileObject.setY(y1);
            tileObject.setWidth(x2 - x1);
            tileObject.setHeight(y2 - y1);
            tileObject.updateAspectRatio();
            repaint();
        }
    }

 

    public void sizeObjectToScreen() {
        TileObject tileObject = getSelectedObject();
        if (tileObject != null) {
            tileObject.setX(0);
            tileObject.setY(0);
            tileObject.setWidth((int) VIRTUALIZER);
            tileObject.setHeight((int) VIRTUALIZER);
            tileObject.updateAspectRatio();
            repaint();
        }
    }

    public void sizeObjectToGrid() {
        TileObject tileObject = getSelectedObject();
        if (tileObject != null) {
            tileObject.setWidth(gridVirtualX(1));
            tileObject.setHeight(gridVirtualY(1));
            tileObject.updateAspectRatio();
            repaint();
        }
    }

    public void moveObjectToBack() {
        TileObject tileObject = getSelectedObject();
        if (tileObject != null) {
            tileObjects.removeElement(tileObject);
            tileObjects.insertElementAt(tileObject, 0);
            repaint();
        }
    }

    public void moveObjectToFront() {
        TileObject tileObject = getSelectedObject();
        if (tileObject != null) {
            tileObjects.removeElement(tileObject);
            tileObjects.addElement(tileObject);
            repaint();
        }
    }

    public void selectAll() {
        groupObjects.removeAllElements();
        groupObjects.addAll(tileObjects);
        repaint();
    }

    public void unselectAll() {
        groupObjects.removeAllElements();
        repaint();
    }

    public void addTileObjectToGroup(TileObject tileObject) {
        if (groupObjects.contains(tileObject)) {
            groupObjects.removeElement(tileObject);
        } else {
            groupObjects.addElement(tileObject);
        }
    }


    public boolean isGroup() {
        return !groupObjects.isEmpty();
    }

    public void toggleSnapToGrid() {
        snapToGrid = !snapToGrid;
    }

    public boolean isSnapToGrid() {
        return snapToGrid;
    }

    public void setGrid(int rows, int columns) {
        gridNumRows = rows;
        gridNumColumns = columns;
        repaint();
    }

    public void setPreview(boolean preview) {
        this.preview = preview;
    }





    public void moveTileObject(TileObject tileObject, int x, int y) {
        if (snapToGrid) {
            tileObject.setX(gridLeftNearestX(pcScreenToVirtualX(x)));
            tileObject.setY(gridUpNearestY(pcScreenToVirtualY(y)));
        } else {
            tileObject.setX(pcScreenToVirtualX(x) + (long)dX_TileOrigin);
            tileObject.setY(pcScreenToVirtualY(y) + (long)dY_TileOrigin);
        }

        //SE ESCO DAL WALL
        if (tileObject.getX() < 0) {
            tileObject.setX(0);
        }
        if (tileObject.getY() < 0) {
            tileObject.setY(0);
        }
        if ((double) (tileObject.getX() + tileObject.getWidth()) > VIRTUALIZER) {
            tileObject.setX((int) (VIRTUALIZER - (double)tileObject.getWidth()));
        }
        if ((double) (tileObject.getY() + tileObject.getHeight()) > VIRTUALIZER) {
            tileObject.setY((int) (VIRTUALIZER - (double)tileObject.getHeight()));
        }
    }

    public void moveGroupObjects(int mouseX, int mouseY) {
        if (snapToGrid) {
            long xGrid = gridLeftNearestX(pcScreenToVirtualX(mouseX));
            long yGrid = gridUpNearestY(pcScreenToVirtualY(mouseY));
            mouseX = (int)(xGrid - getSelectedObject().getX());
            mouseY = (int)(yGrid - getSelectedObject().getY());

        }
        else{
            mouseX = (int)( pcScreenToVirtualX(mouseX) - pcScreenToVirtualX(actionX1));
            mouseY = (int)( pcScreenToVirtualY(mouseY) - pcScreenToVirtualY(actionY1));
        }

        for (int i = 0; i < groupObjects.size(); i++) {
            TileObject tileObject = (TileObject) groupObjects.elementAt(i);
            long x2 = tileObject.getX() + mouseX;
            long y2 = tileObject.getY() + mouseY;
            if (x2 < 0L || y2 < 0L || (double) (x2 + tileObject.getWidth()) > VIRTUALIZER || (double) (y2 + tileObject.getHeight()) > VIRTUALIZER) {
                return;
            }
        }
        for (int i = 0; i < groupObjects.size(); i++) {
            TileObject tileObject = (TileObject) groupObjects.elementAt(i);
            tileObject.setX(tileObject.getX() + mouseX);
            tileObject.setY(tileObject.getY() + mouseY);
        }

    }

    private void beginMouseAction(int mouseX, int mouseY) {

        tileHit = false;
        moving = false;
        resizing = false;

        for (int i = tileObjects.size() - 1; i >= 0; i--) {
            TileObject tileObject = (TileObject) tileObjects.elementAt(i);
            long x1 = virtualToPCScreenX(tileObject.getX());
            long y1 = virtualToPCScreenY(tileObject.getY());
            long x2 = virtualToPCScreenX(tileObject.getX() + tileObject.getWidth());
            long y2 = virtualToPCScreenY(tileObject.getY() + tileObject.getHeight());
            if (mouseX >= x1 && mouseX <= x2 && mouseY >= y1 && mouseY <= y2) {
                tileHit = true;
                moving =  mouseX >= x1 + RESIZE_ANCHOR_PX &&
                            mouseX <= x2 - RESIZE_ANCHOR_PX &&
                            mouseY >= y1 + RESIZE_ANCHOR_PX &&
                            mouseY <= y2 - RESIZE_ANCHOR_PX;
                resizing = !moving;

                actionX1 = mouseX;
                actionY1 = mouseY;



                setSelectedObject(tileObject);

                //gestione gruppi
                movegroup = groupObjects.contains(tileObject);
                if (isGroup() && !ctrlPress && !movegroup) {
                    groupObjects.removeAllElements();
                    //aggiorno le icone che schifo!!!
                    MultiViewerPanel.getInstance().updateGUI();
                }
                else if (ctrlPress) {

                        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                        addTileObjectToGroup(getSelectedObject());
                        //aggiorno le icone che schifooooo
                        MultiViewerPanel.getInstance().updateGUI();
                }
                

                dX_TileOrigin = (int) (tileObject.getX() - pcScreenToVirtualX(mouseX));
                dY_TileOrigin = (int) (tileObject.getY() - pcScreenToVirtualY(mouseY));
                left = mouseX < x1 + RESIZE_ANCHOR_PX;
                top = mouseY < y1 + RESIZE_ANCHOR_PX && tileObject.getAspectRatio().equals("None");
                horizontal = left || mouseX > x2 - RESIZE_ANCHOR_PX;
                vertical = top || mouseY > y2 - RESIZE_ANCHOR_PX && tileObject.getAspectRatio().equals("None");


                break;
            }
        }

        if(!tileHit){
            if (ctrlPress) {
                //STO DISEGNANDO UNA SELEZIONE
                groupSelecting = true;
                actionX1 = mouseX;
                actionY1 = mouseY;
                //aggiorno le icone.. che schifo..
                MultiViewerPanel.getInstance().updateGUI();

            }
        }



        if (moving) {
            setCursor(new Cursor(Cursor.MOVE_CURSOR));
        } else if (resizing) {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        updateStateLabel();
    }



    private void updateMouseAction(int mouseX, int mouseY) {
        if (groupSelecting) {
            actionX2 = mouseX;
            actionY2 = mouseY;
            repaint();
            return;
        }
        //DA CASSARE
        if (ctrlPress) {
            //System.out.println("SE ENTRI ME NE VADO ADESSO");
            return;
        }

        TileObject tileObject = getSelectedObject();
        if (tileObject != null) {
            if (moving) {
                handleMoving(mouseX, mouseY, tileObject);
            } else if (resizing) {
                handleResizing(mouseX, mouseY, tileObject);
            }
            updateStateLabel();
            repaint();
        }
    }

    private void endMouseAction() {
        if (groupSelecting) {
            
            long x1 = pcScreenToVirtualX((actionX1 <= actionX2)? actionX1: actionX2);
            long x2 = pcScreenToVirtualX((actionX1 <= actionX2)? actionX2: actionX1);
            long y1 = pcScreenToVirtualY((actionY1 <= actionY2)? actionY1: actionY2);
            long y2 = pcScreenToVirtualY((actionY1 <= actionY2)? actionY2: actionY1);
            
            
            for (int i = 0; i < tileObjects.size(); i++) {
                TileObject tileObject = (TileObject) tileObjects.elementAt(i);
                if (tileObject.getX() + tileObject.getWidth() >= x1 && tileObject.getY() + tileObject.getHeight() >= y1 && tileObject.getX() <= x2 && tileObject.getY() <= y2) {
                    addTileObjectToGroup(tileObject);
                }
            }

            groupSelecting = false;
            if (ctrlPress) {
                setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            } else {
                setCursor(Cursor.getDefaultCursor());
            }
            repaint();
            return;
        }
        if (dblClick) {
            return;
        }

        if (ctrlPress) {
            setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            return;
        } else {
            setCursor(Cursor.getDefaultCursor());
        }

        Vector objectsToSend = new Vector();

        if (isGroup()) {
            objectsToSend = groupObjects;
            objectsToSend = union(objectsToSend, childrenObjects);

        } else if (getSelectedObject() != null) {
            objectsToSend.add(getSelectedObject());
            objectsToSend = union(objectsToSend, childrenObjects);
        }

        try {
            for (int pd = 0; pd < objectsToSend.size(); pd++) {
                TileObject tileObject = (TileObject) objectsToSend.get(pd);
                
                // Adjusting the tile size can result in slight adjustments in
                // extLeft, extRight etc. Record the original values so we can
                // check to see if the tile needs adjusting after it has been
                // sent to the MV. If any ext sizes have changed and the
                // tile dimensions are locked to the video aspect ratio then
                // the tile will need another size adjustment (its
                // updateAspectRatio function called). This again will need
                // to be sent to the MV, which in turn could possibly result
                // in another change to ext sizes. This process needs to be
                // repeated until no further changes occur to ext sizes. Limited
                // to 5 attempts below, but is unlikely to ever be more than
                // 3 attempts.
                boolean tryAgain = true;
                for (int tries = 0; tries < 5 && tryAgain; tries++) {
                    tryAgain = false;
                    
                    AspectRatio arBean = tileObject.getBean().getAspectRatio();
                    int extLeft = arBean.getExtLeft();
                    int extRight = arBean.getExtRight();
                    int extTop = arBean.getExtTop();
                    int extBottom = arBean.getExtBottom();
                    
                    tileObject.saveToBean();
                    CtrlWorkspace.getInstance().saveObjectToMV(ctrlActions.getIdModulo(), tileObject.getBean());
                    
                    AspectRatio arNewBean = tileObject.getBean().getAspectRatio();
                    if (arNewBean.getExtLeft() != extLeft
                            || arNewBean.getExtRight() != extRight
                            || arNewBean.getExtTop() != extTop
                            || arNewBean.getExtBottom() != extBottom) {
                        tileObject.reloadExtSizesFromBean();
                        if (tileObject.isLockedToVideoAspectRatio()) { 
                            tileObject.updateAspectRatio();
                            tryAgain = true;
                        }
                    }
                }
            }
            CtrlWorkspace.getInstance().commitUndo(ctrlActions.getIdModulo());
            MultiViewerPanel.getInstance().updateUndoRedo();
            ctrlActions.autoUpdate();
            repaint();
            
        } catch (MVException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            CtrlWorkspace.getInstance().rollback(ctrlActions.getIdModulo());
            loadTilesFromBean();
        }

    }

    private void handleMoving(int mouseX, int mouseY, TileObject tileObject) {
        if (movegroup) {
            moveGroupObjects(mouseX, mouseY);
        } else {
            moveTileObject(tileObject, mouseX, mouseY);
        }
        actionX1 = mouseX;
        actionY1 = mouseY;
    }

    //ZIPPERO  a schermo sulla tile due dimensioni oppure dimensione dell extx e exty con sfondo diverso

    //e altri bugs
    private void handleResizing(int mouseX, int mouseY, TileObject tileObject) {
        long x1 = tileObject.getX();
        long y1 = tileObject.getY();
        long width = tileObject.getWidth();
        long height = tileObject.getHeight();
        long x2 = x1 + width;
        long y2 = y1 + height;
        long virtualMouseX = pcScreenToVirtualX(mouseX);
        long virtualMouseY = pcScreenToVirtualY(mouseY);


        
        if (horizontal) {
            if (left) {
                width += x1 - virtualMouseX;
                x1 = virtualMouseX;
                if (width < 0) {
                    width = 0;
                }
                //RIGHT
            } else {
                width = virtualMouseX - x1;
                if (width < 0) {
                    width = 0;
                }
                x2 = x1 + width;
            }
        }
        if (vertical) {
            if (top) {
                height += y1 - virtualMouseY;
                if (height < 0) {
                    height = 0;
                }
                y1 = virtualMouseY;
                //BOTTOM
            } else {
                height = virtualMouseY - y1;
                if (height < 0) {
                    height = 0;
                }
                y2 = y1 + height;
            }
        }
        
        //CONTROLLO FUORIUSCITA
        if (x1 < 0) {
            width += x1;
            x1 = 0;
        }
        if (y1 < 0) {
            height += y1;
            y1 = 0;
        }

        if (snapToGrid) {
            if (horizontal) {
                if (left) {
                    long nearLeftDistance = gridLeftNearestX(x1) - x1;
                    long nearRightDistance = gridRightNearestX(x1) - x1;
                    long nearDistance = Math.abs(nearLeftDistance) <= nearRightDistance ? nearLeftDistance : nearRightDistance;
                    if (Math.abs(nearDistance) < snapGap) {
                        x1 += nearDistance;
                    }
                } else {
                    long nearLeftDistance = gridLeftNearestX(x2) - x2;
                    long nearRightDistance = gridRightNearestX(x2) - x2;
                    long nearDistance = Math.abs(nearLeftDistance) <= nearRightDistance ? nearLeftDistance : nearRightDistance;
                    if (Math.abs(nearDistance) < snapGap) {
                        x2 += nearDistance;
                    }
                }
            }

            if (vertical) {
                if (top) {
                    long nearUpDistance = gridUpNearestY(y1) - y1;
                    long nearDownDistance = gridDownNearestY(y1) - y1;
                    long nearDistance = Math.abs(nearUpDistance) <= nearDownDistance ? nearUpDistance : nearDownDistance;
                    if (Math.abs(nearDistance) < snapGap) {
                        y1 += nearDistance;
                    }
                } else {
                    long nearUpDistance = gridUpNearestY(y2) - y2;
                    long nearDownDistance = gridDownNearestY(y2) - y2;
                    long nearDistance = Math.abs(nearUpDistance) <= nearDownDistance ? nearUpDistance : nearDownDistance;
                    if (Math.abs(nearDistance) < snapGap) {
                        y2 += nearDistance;
                    }
                }
            }

            width = x2 - x1;
            height = y2 - y1;
        }


        if ((double) (y1 + height) > VIRTUALIZER) {
            height = (int) (VIRTUALIZER - (double) y1);
        }
        if ((double) (x1 + width) > VIRTUALIZER) {
            width = (int) (VIRTUALIZER - (double) x1);
        }
        if (virtualToMVScreenY(height) < MIN_TILE_SIZE) {
            height = (int) mvScreenToVirtualY(MIN_TILE_SIZE);
        }
        if (virtualToMVScreenX(width) < MIN_TILE_SIZE) {
            width = (int) mvScreenToVirtualX(MIN_TILE_SIZE);
        }

        if (vertical && top && y1 + height != y2) {
            y1 = y2 - height;
        }
        if (horizontal && left && x1 + width != x2) {
            x1 = x2 - width;
        }
        
        
        
        //GESTIONE ASPECT RATIO
        if (tileObject.isLockedToVideoAspectRatio()) {
            if (tileObject.getVideoAspectRatio().width > 0) {
                Dimension vidar = tileObject.getVideoAspectRatio();
                long virtualVideoH = mvScreenToVirtualY((virtualToMVScreenX(width - tileObject.getExtX()) * vidar.height) / vidar.width);
                long virtualH = virtualVideoH + tileObject.getExtY();
                if ((double) (y1 + virtualH) > VIRTUALIZER) {
                    virtualH = (long) (VIRTUALIZER - (double) y1);
                    virtualVideoH = virtualH - tileObject.getExtY();
                    long virtualVideoW = mvScreenToVirtualX((virtualToMVScreenY(virtualVideoH) * vidar.width) / vidar.height);
                    width = virtualVideoW + tileObject.getExtX();
                    if(left)
                        x1 = x2 - width;
                }
                if (virtualToMVScreenY(virtualH) < MIN_TILE_SIZE) {
                    width = (int) mvScreenToVirtualX((virtualToMVScreenY(mvScreenToVirtualY(MIN_TILE_SIZE)) * vidar.height) / vidar.width);
                    if(left)
                        x1 = x2 - width;
                }
            }
        } else if (tileObject.getTileAspectRatio().width > 0) {
            Dimension tilear = tileObject.getTileAspectRatio();
            long virtualH = mvScreenToVirtualY((virtualToMVScreenX(width) * tilear.height) / tilear.width);
            if ((double) (y1 + virtualH) > VIRTUALIZER) {
                width = (int) mvScreenToVirtualX((virtualToMVScreenY((long) (VIRTUALIZER - (double) y1)) * tilear.width) / tilear.height);
                if(left)
                    x1 = x2 - width;
            }
            if (virtualToMVScreenY(virtualH) < MIN_TILE_SIZE) {
                width = (int) mvScreenToVirtualX((virtualToMVScreenY(mvScreenToVirtualY(MIN_TILE_SIZE)) * tilear.height) / tilear.width);
                if(left)
                    x1 = x2 - width;
            }
        }
        
        //AGGIORNO TILEOBJECT
        tileObject.setX(x1);
        tileObject.setY(y1);
        tileObject.setWidth(width);
        tileObject.setHeight(height);
        tileObject.updateAspectRatio();
    }



    public void handleParentObjects() {

        for (int i = 0; i < tileObjects.size(); i++) {
            TileObject tileObject = (TileObject) tileObjects.elementAt(i);

            for (int j = 0; j < tileObjects.size(); j++) {
                if (i == j) {
                    continue;
                }
                TileObject figlioObject = (TileObject) tileObjects.elementAt(j);
                if (figlioObject.getParentId() != tileObject.getId()) {
                    continue;
                }

                if (figlioObject.isParentLockRatio()) {
                    figlioObject.setWidth((int) ((double) tileObject.getWidth() * figlioObject.getParentLockRatioX()));
                    figlioObject.setHeight((int) ((double) tileObject.getHeight() * figlioObject.getParentLockRatioY()));
                }

                switch (figlioObject.getParentAnchorId()) {
                    case 0:
                        figlioObject.setX(tileObject.getX());
                        figlioObject.setY(tileObject.getY());
                        break;
                    case 1:
                        figlioObject.setX(tileObject.getX() + (tileObject.getWidth() - figlioObject.getWidth()) / 2L);
                        figlioObject.setY(tileObject.getY());
                        break;
                    case 2:
                        figlioObject.setX((tileObject.getX() + tileObject.getWidth()) - figlioObject.getWidth());
                        figlioObject.setY(tileObject.getY());
                        break;
                    case 3:
                        figlioObject.setX(tileObject.getX());
                        figlioObject.setY(tileObject.getY() + (tileObject.getHeight() - figlioObject.getHeight()) / 2L);
                        break;
                    case 4:
                        figlioObject.setX(tileObject.getX() + (tileObject.getWidth() - figlioObject.getWidth()) / 2L);
                        figlioObject.setY(tileObject.getY() + (tileObject.getHeight() - figlioObject.getHeight()) / 2L);
                        break;
                    case 5:
                        figlioObject.setX((tileObject.getX() + tileObject.getWidth()) - figlioObject.getWidth());
                        figlioObject.setY(tileObject.getY() + (tileObject.getHeight() - figlioObject.getHeight()) / 2L);
                        break;
                    case 6:
                        figlioObject.setX(tileObject.getX());
                        figlioObject.setY((tileObject.getY() + tileObject.getHeight()) - figlioObject.getHeight());
                        break;
                    case 7:
                        figlioObject.setX(tileObject.getX() + (tileObject.getWidth() - figlioObject.getWidth()) / 2L);
                        figlioObject.setY((tileObject.getY() + tileObject.getHeight()) - figlioObject.getHeight());
                        break;
                    case 8:
                        figlioObject.setX((tileObject.getX() + tileObject.getWidth()) - figlioObject.getWidth());
                        figlioObject.setY((tileObject.getY() + tileObject.getHeight()) - figlioObject.getHeight());
                        break;
                }

                figlioObject.setX(figlioObject.getX() + mvScreenToVirtualX(figlioObject.getOffsetX()) - mvScreenToVirtualX(0L));
                figlioObject.setY(figlioObject.getY() + mvScreenToVirtualY(figlioObject.getOffsetY()) - mvScreenToVirtualY(0L));

            }

        }

        if (!childrenCalculated) {
            Vector figli = new Vector();
            if (isGroup()) {
                figli = getChildren(groupObjects);
            } else {
                figli = getChildren(getSelectedObject());
            }
            childrenObjects = figli;
            childrenCalculated = true;
        }


    }

    @Override
    public void paint(Graphics g) {

        //System.out.println("Paint called millis: "+System.currentTimeMillis());

        // inizializza il buffer video
        if (widthWorkspace != getWidth() || heightWorkspace != getHeight() || graphics == null) {
            widthWorkspace = getWidth();
            heightWorkspace = getHeight();
            image = createImage(widthWorkspace, heightWorkspace);
            graphics = image.getGraphics();
        }
        graphics.clearRect(0, 0, widthWorkspace, heightWorkspace);

        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);


        //disegna lo sfondo
        //sfondo sopra e sotto le tiles
        graphics.setColor(StyleInterface.getInstance().getWorkspaceSkyColor());
        graphics.fillRect(0, 0, widthWorkspace, heightWorkspace);

        //sfondo del workspace
        graphics.setColor(StyleInterface.getInstance().getWorkspaceBackgroundColor());
        graphics.fillRect((int) virtualToPCScreenX(0L), (int) virtualToPCScreenY(0L), (int) ((virtualToPCScreenX((int) VIRTUALIZER - 1) - virtualToPCScreenX(0L)) + 1L), (int) ((virtualToPCScreenY((int) VIRTUALIZER - 1) - virtualToPCScreenY(0L)) + 1L));

        if (!preview) {
            //colore griglia
            graphics.setColor(StyleInterface.getInstance().getGridColor());
            for (int i = 1; i < getGridNumColumns(); i++) {
                long l = virtualToPCScreenX(gridVirtualX(i));
                graphics.drawLine((int) l, (int) virtualToPCScreenY(gridVirtualY(0)), (int) l, (int) virtualToPCScreenY(gridVirtualY(getGridNumRows())));
            }

            for (int j = 1; j < getGridNumRows(); j++) {
                long l1 = virtualToPCScreenY(gridVirtualY(j));
                graphics.drawLine((int) virtualToPCScreenX(gridVirtualX(0)), (int) l1, (int) virtualToPCScreenX(gridVirtualX(getGridNumColumns())), (int) l1);
            }

        }
        //colore griglia
        graphics.setColor(StyleInterface.getInstance().getGridColor());//new Color(127,127,127));
        graphics.drawRect((int) virtualToPCScreenX(0L), (int) virtualToPCScreenY(0L), (int) ((virtualToPCScreenX((int) VIRTUALIZER - 1) - virtualToPCScreenX(0L)) + 1L), (int) ((virtualToPCScreenY((int) VIRTUALIZER - 1) - virtualToPCScreenY(0L)) + 1L));
        graphics.drawRect(0, 0, widthWorkspace - 1, heightWorkspace - 1);



        //disegna gli oggetti
        TileObject selectedObj = getSelectedObject();
        for (int i = 0; i < tileObjects.size(); i++) {
            TileObject currentObj = (TileObject) tileObjects.elementAt(i);
            //nella preview non sono visualizzati gli oggetti None
            if (preview && currentObj.getItemType().compareTo("None") == 0) {
                continue;
            }

            boolean isGroupMember = isGroup() && (groupObjects.contains(currentObj));
            boolean isSelected = !preview && currentObj == selectedObj;
            //disegna gli oggetti
            currentObj.draw(graphics2d, preview, isSelected, isGroupMember, ctrlActions.getCurrentScreen());
        }

        //nel workspace disegna i bordi nascosti e il quadratino di selezione
        if (!preview) {
            for (int j = 0; j < tileObjects.size(); j++) {
                TileObject currentObj = (TileObject) tileObjects.elementAt(j);
                boolean isGroupMember = isGroup() && (groupObjects.contains(currentObj));
                boolean isSelected = !preview && currentObj == selectedObj;

                currentObj.drawHiddenStuff(graphics2d, preview, isSelected, isGroupMember);
            }

        }


        //disegna il rettangolo di selezione
        if (groupSelecting) {
            int x1;
            int y1;
            int x2;
            int y2;
            x1 = (actionX1 <= actionX2) ? actionX1 : actionX2;
            x2 = (actionX1 <= actionX2) ? actionX2 : actionX1;
            y1 = (actionY1 <= actionY2) ? actionY1 : actionY2;
            y2 = (actionY1 <= actionY2) ? actionY2 : actionY1;
            graphics.setColor(Color.white);
            graphics.drawRect(x1, y1, x2 - x1, y2 - y1);
        }

        //disegna il buffer video
        g.drawImage(image, 0, 0, this);
        //this.requestFocusInWindow();
    }

    public TileObject getParent(int parentId) {
        if (parentId == -1) {
            return null;
        }
        for (int i = tileObjects.size() - 1; i >= 0; i--) {
            TileObject tileObject = (TileObject) tileObjects.elementAt(i);
            if (tileObject.getId() == parentId) {
                return tileObject;
            }
        }

        return null;
    }

    /*
     * 
     *aggiorna i bean degli oggetti grafici tileObject 
     */
    public void saveTilesToBean() {
        //il previewer ha tileObject senza bean
        if (!preview) {
            for (int j = 0; j < tileObjects.size(); j++) {
                TileObject tileObject = (TileObject) tileObjects.elementAt(j);
                tileObject.saveToBean();

            }
        }
    }

    public void loadTilesFromBean() {
        if (preview && screenObjects != null) {
            loadTilesFromBean(screenObjects);
        } else {
            loadTilesFromBean(CtrlWorkspace.getInstance().getObjects(ctrlActions.getIdModulo(), idScreen));
        }

    }

    private HashMap<String, TimerControlDialog> getTilesWithTimerControl() {
        HashMap<String, TimerControlDialog> res = new HashMap<String, TimerControlDialog>();
        for (int j = 0; j < tileObjects.size(); j++) {
            TileObject tileObject = (TileObject) tileObjects.elementAt(j);
            TimerControlDialog dialog = tileObject.getTimerControlDialog();
            if (dialog != null)
                res.put(tileObject.getItemName(), dialog);
        }
        return res;
    }

    private void setTilesWithTimerControl(HashMap<String, TimerControlDialog> map) {
        for (int j = 0; j < tileObjects.size(); j++) {
            TileObject tileObject = (TileObject) tileObjects.elementAt(j);
            TimerControlDialog dialog = map.get(tileObject.getItemName());
            if (dialog != null)
                tileObject.setTimerControlDialog(dialog);
        }
    }

    public void loadTilesFromBean(Objects objs) {
        //Tengo traccia dell'id dell'oggetto selezionato
        int id = -1;
        if (getSelectedObject() != null) {
            id = getSelectedObject().getId();
        }

        HashMap<String, TimerControlDialog> tilesWithTimerControl = getTilesWithTimerControl();
        
        //CANCELLO ELEMENTI A SCHERMO
        tileObjects.removeAllElements();

        if (objs != null) {
            Iterator iteratoreDiSalsicce = objs.iterateOggetto();
            while (iteratoreDiSalsicce.hasNext()) {
                addTileObject((Oggetto) iteratoreDiSalsicce.next());
            }
        }
        
        setTilesWithTimerControl(tilesWithTimerControl);

        if (id != -1) {
            setSelectedObject(id);
        } else {
            repaint();
        }
    }

    private ObjectsZOrder normalizzaZOrder(ObjectsZOrder beanOriginal) {

        ObjectsZOrder bean = new ObjectsZOrder();
        try {
            bean = (ObjectsZOrder) CtrlWorkspace.clone(beanOriginal);
        } catch (CloneBeanException ex) {
            //sticazzi
        }

        int numObjz = bean.getObjectZOrderCount();

        for (int i = 0; i < numObjz; i++) {

            int minPos = Integer.MAX_VALUE;
            int minPosIndex = -1;

            for (int j = 0; j < numObjz; j++) {
                if (bean.getObjectZOrder()[j].getPos() <= minPos && bean.getObjectZOrder()[j].getPos() >= i) {
                    minPos = bean.getObjectZOrder()[j].getPos();
                    minPosIndex = j;
                }
            }

            bean.getObjectZOrder()[minPosIndex].setPos(i);
        }

        return bean;
    }

    public void applyZOrder() {
        applyZOrder(CtrlWorkspace.getInstance().getObjectsZOrder(ctrlActions.getIdModulo(), idScreen));
    }

    public void applyZOrder(ObjectsZOrder bean) {

        //Normalizzo objectsZOrder

        bean = normalizzaZOrder(bean);


        TileObject[] itemsOrdinate = new TileObject[bean.getObjectZOrderCount()];

        for (int j = 0; j < tileObjects.size(); j++) {
            TileObject tileObject = (TileObject) tileObjects.elementAt(j);

            for (int k = 0; k < bean.getObjectZOrderCount(); k++) {
                //Se l'id del tileObject è uguale all'id dell'oggetto del bean ObjectZOrder
                if (bean.getObjectZOrder()[k].getId() == tileObject.getId()) {
                    //aggiunge l'item alla posizione giusta
                    itemsOrdinate[(bean.getObjectZOrderCount() - 1) - bean.getObjectZOrder()[k].getPos()] = tileObject;
                    break;
                }
            }
        }
        List myList = Arrays.asList(itemsOrdinate);
        ArrayList da = new ArrayList(myList);
        tileObjects = new Vector(da);
        repaint();



    }

    public Vector union(Vector a, Vector b) {
        Vector res = new Vector();
        for (int i = 0; i < a.size(); i++) {
            Object aobj = a.elementAt(i);
            if (res.contains(aobj)) {
            } else {
                res.add(aobj);
            }
        }
        for (int j = 0; j < b.size(); j++) {
            Object bobj = b.elementAt(j);
            if (res.contains(bobj)) {
            } else {
                res.add(bobj);
            }
        }
        return res;
    }

    public static Vector intersection(final Vector v1, final Vector v2) {
        Vector res = new Vector();
        for (int i = 0; i < v1.size(); i++) {
            Object obj = v1.elementAt(i);
            if (v2.contains(obj)) {
                res.add(obj);
            }
        }
        return res;
    }

    public Vector getChildren(TileObject padre) {
        Vector padri = new Vector();
        padri.add(padre);
        return getChildren(padri);
    }

    public Vector getChildren(Vector padri) {

        Vector figli = new Vector();

        for (int i = 0; i < padri.size(); i++) {

            TileObject padre = (TileObject) padri.elementAt(i);

            for (int j = 0; j < tileObjects.size(); j++) {

                TileObject figlio = (TileObject) tileObjects.elementAt(j);

                if (figlio == padre) {
                    continue;
                }

                if (figlio.getParentId() == padre.getId()) {
                    figli.add(figlio);
                }
            }

        }

        return figli;
    }

    public void handleResize() {
        widthWorkspace = getWidth();
        heightWorkspace = getHeight();
        proporzioniWorkspace();
        ctrlActions.updateGUI();
        repaint();
    }


    //GRIGLIA

    public int getGridNumColumns() {
        return gridNumColumns;
    }

    public int getGridNumRows() {
        return gridNumRows;
    }

    /**
     *
     * @param numColumns il numero di colonna
     * @return l'ascissa dell'inizio della colonna in sistema virtuale
     */
    public long gridVirtualX(int numColumns) {
        return (long) ((numColumns * VIRTUALIZER) / gridNumColumns);
    }
    /**
     *
     * @param numColumns il numero di colonna
     * @return l'ordinata dell'inizio della colonna in sistema virtuale
     */
    public long gridVirtualY(int numRows) {
        return (long) (( numRows * VIRTUALIZER) / gridNumRows);
    }


    public long gridLeftNearestX(long pointX) {
        long ret = 0;
        for (int i = getGridNumColumns(); i >= 0; i--) {
            if (gridVirtualX(i) <= pointX) {
                ret = gridVirtualX(i);
                break;
            }
        }
        return ret;
    }


    public long gridRightNearestX(long pointX) {
        long ret = Math.round(VIRTUALIZER);
        for (int i = 0; i <= getGridNumColumns(); i++) {
            if (gridVirtualX(i) >= pointX) {
                ret = gridVirtualX(i);
                break;
            }
        }
        return ret;
    }



    public long gridUpNearestY(long pointY) {
        long ret = 0;
        for (int i = getGridNumRows(); i >= 0; i--) {
            if (gridVirtualY(i) <= pointY) {
                ret = gridVirtualY(i);
                break;
            }
        }
        return ret;
    }



    public long gridDownNearestY(long pointY) {
        long ret = Math.round(VIRTUALIZER);
        for (int i = 0; i <= getGridNumRows(); i++) {
            if (gridVirtualY(i) >= pointY) {
                ret = gridVirtualY(i);
                break;
            }
        }
        return ret;
    }

    /**
 *
 * @param pointX l'ascissa di un punto del tilesWorkspace
 * @return la rappresentazione virtuale di pointX
 */
    public long pcScreenToVirtualX(long pointX) {
        return Math.round(((pointX - wallStartX) * VIRTUALIZER) / wallWidth);
    }
/**
 *
 * @param pointY la ordinata di un punto del tilesWorkspace
 * @return la rappresentazione virtuale di pointY
 */
    public long pcScreenToVirtualY(long pointY) {
        return Math.round(((pointY - wallStartY) * VIRTUALIZER) / wallHeight);
    }

    /**
     *
     * @param pointX ascissa di un punto sullo schermo del Mv-XX
     * @return la rappresentazione virtuale di pointX
     */
    public long mvScreenToVirtualX(long pointX) {
        return Math.round((pointX * VIRTUALIZER) / getMvHres());
    }
    /**
     *
     * @param pointY ordinata di un punto sullo schermo del Mv-XX
     * @return la rappresentazione virtuale di pointY
     */
    public long mvScreenToVirtualY(long pointY) {
        return Math.round((pointY * VIRTUALIZER) / getMvVres());
    }


//E QUESTI SO IL CONTRARIO DI SOPRA CAZZO
    public long virtualToPCScreenX(long pointX) {
        return Math.round( wallStartX + (pointX * wallWidth) / VIRTUALIZER);
    }

    public long virtualToPCScreenY(long pointY) {
        return Math.round( wallStartY + (pointY * wallHeight) / VIRTUALIZER);
    }


    public long virtualToMVScreenX(long pointX) {
        return Math.round((double) (pointX * (long) getMvHres()) / VIRTUALIZER);
    }

    public long virtualToMVScreenY(long pointY) {
        return Math.round((double) (pointY * (long) getMvVres()) / VIRTUALIZER);
    }
    
    public void addTimerControl(TileObject obj, TimerControlDialog tcd) {
        for (int j = 0; j < tileObjects.size(); j++) {
            TileObject tileObject = (TileObject) tileObjects.elementAt(j);
            if (obj == tileObject) {
                obj.setTimerControlDialog(tcd);
                break;
            }
        }
    }
    
    public void removeTimerControl(TimerControlDialog tcd) {
        for (int j = 0; j < tileObjects.size(); j++) {
            TileObject tileObject = (TileObject) tileObjects.elementAt(j);
            if (tileObject.getTimerControlDialog() == tcd) {
                tileObject.setTimerControlDialog(null);
            }
        }
    }

    public boolean isTimerControlValid(TimerControlDialog tcd) {
        boolean valid = false;
        for (int j = 0; j < tileObjects.size(); j++) {
            TileObject tileObject = (TileObject) tileObjects.elementAt(j);
            if (tileObject.getTimerControlDialog() == tcd
                    && tileObject.getBean().getType().getVal().compareTo("Timer") == 0
                    && tileObject.getBean().getObjectSequence().getTimerProperties().getTriggerGpi().getVal()) {
                valid = true;
                break;
            }
        }
        
        return valid;
    }
    
    public int getTimerControlTileId(TimerControlDialog tcd) {
        int id = -1;
        for (int j = 0; j < tileObjects.size(); j++) {
            TileObject tileObject = (TileObject) tileObjects.elementAt(j);
            if (tileObject.getTimerControlDialog() == tcd) {
                id = tileObject.getId();
                break;
            }
        }
        
        return id;
    }

    public TileObject getTimerControlTileObject(TimerControlDialog tcd) {
        TileObject obj = null;
        for (int j = 0; j < tileObjects.size(); j++) {
            TileObject tileObject = (TileObject) tileObjects.elementAt(j);
            if (tileObject.getTimerControlDialog() == tcd) {
                obj = tileObject;
                break;
            }
        }
        
        return obj;
    }

}
