package gui;

import bean.LiveRead;
import bean.Objects;
import bean.ObjectsZOrder;
import eccezioni.ActionNotFoundException;
import eccezioni.MVException;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.Position;
import bean.Oggetto;
import controllori.ActionSet;
import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import dialogs.source.SourcePropertiesDialog;
import gui.components.JIDStringNode;
import gui.style.StyleInterface;
import javax.swing.tree.TreePath;

public class CtrlActions {

    public int numScreens;
    private int currentScreen;
    private TilesWorkspace[] tilesWorkspace;
    private TilesWorkspace[] previewWorkspace;
    
    private int idModulo = 0;

    private boolean copyDone;
    public Oggetto oggettoToCopy;

    private boolean autoUpdate;

    private static CtrlActions instance = null;
    
    //pattern Singleton
    public static CtrlActions getInstance() {
      if(instance == null) {
         instance = new CtrlActions();
      }
      return instance;
    }


    private CtrlActions()
    {
        
        numScreens = CtrlWorkspace.getInstance().getModule(0).getScreen().getNumScreens().getVal();
        //Panda ti denuncio.
        if (numScreens > 2)
            numScreens = 2;
        tilesWorkspace = new TilesWorkspace[numScreens];
        previewWorkspace = new TilesWorkspace[numScreens];
        
        autoUpdate = false;
        copyDone = false;
    }

    public void prepare() throws MVException {
        for (int i=0; i<numScreens; i++) {
            tilesWorkspace[i].proporzioniWorkspace();
            previewWorkspace[i].proporzioniWorkspace();
            this.fillTilesWorkspace(i);
        }
    }





    public void processAction(String actionCommand) {
        try {
            ActionSet.getInstance().getAction(actionCommand).execute();
            CtrlActions.getInstance().getTilesWorkspace().requestFocusInWindow();
        } catch (ActionNotFoundException ex) {
            ex.printStackTrace();
            CtrlActions.getInstance().getTilesWorkspace().requestFocusInWindow();
        }
    }

    public void updateSelectionTree() {
        JTree managementTree = MultiViewerPanel.getInstance().getTreeObjects();
        if (getTilesWorkspace().getSelectedObject() != null) {
            int id = getTilesWorkspace().getSelectedObject().getId();
            JIDStringNode nodoRoot = (JIDStringNode) managementTree.getModel().getRoot();
            JIDStringNode nodoSelected = ((JIDStringNode)nodoRoot.getFirstChild()).getChildNodeByID(id);

            if (nodoSelected != null) {
                managementTree.setSelectionPath(new TreePath(nodoSelected.getPath()));
            }
            
            //SORGENTI GESTISCO IL COLORE
           
            Oggetto bean = getTilesWorkspace().getSelectedObject().getBean();
            if (bean.getType().getVal().equals("Video") || bean.getType().getVal().equals("Audio")) {
                String sorgenteSelezionata = getTilesWorkspace().getSelectedObject().getBean().getObjectSequence().getVidAudProperties().getVidAudSource().getVal();
                String[] split = sorgenteSelezionata.split(" ");
                id = Integer.parseInt(split[1]);
                nodoSelected = ((JIDStringNode) nodoRoot.getChildAt(1)).getChildNodeByID(id);

                if (nodoSelected != null) {
                    nodoSelected.setStatus(JIDStringNode.SELECTED);
                }
            }
        } else {
            managementTree.clearSelection();
        }         
    }
    
    public void updateTree() {
        JTree managementTree = MultiViewerPanel.getInstance().getTreeObjects();
        TreePath srcPath = managementTree.getNextMatch("Sources", 0, Position.Bias.Forward);
        
        boolean objExp = managementTree.isExpanded(0);
        boolean srcExp = managementTree.isExpanded(srcPath);
        managementTree.setModel(CtrlWorkspace.getInstance().getTreeModel(idModulo));
        if(objExp)
            managementTree.expandRow(0);
        if(srcExp)
            managementTree.expandPath(managementTree.getNextMatch("Sources", 0, Position.Bias.Forward));
    }
    
    public void updateGUI() {
        MultiViewerPanel.getInstance().updateGUI();
    }


    public void autoUpdate() throws MVException {

        if (isAutoUpdate()) {
            try {
                ActionSet.getInstance().getAction("Update").doAction();
            } catch (ActionNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
   
    public void setupSourceByJTree(Frame frame, int idSource) throws MVException {
        new SourcePropertiesDialog(frame,CtrlWorkspace.getInstance().getSource(idModulo, idSource), idModulo);
        getTilesWorkspace().repaint();
    }

    public void setLayoutTitle() {
        String filenameLayout = CtrlWorkspace.getInstance().getModule(idModulo).getModuleFilename().getVal();
        if(filenameLayout.equals(""))
            filenameLayout = "Untitled Layout";
        ((JFrame)JOptionPane.getFrameForComponent(getTilesWorkspace())).setTitle(StyleInterface.getInstance().getFrameTitle() +"  - "+filenameLayout+" -");
    }

    
   
   
   
    private void fillTilesWorkspace(int screenIndex) throws MVException {
        if (CtrlWorkspace.getInstance() == null) {
            System.out.print("Unable to connect to multiviewer");
            System.exit(-1);
            //TODO: gestire problema di connessione
        }
        Objects objs = CtrlWorkspace.getInstance().getObjects(idModulo, screenIndex);
        tilesWorkspace[screenIndex].loadTilesFromBean(objs);
        //ORDINO il vettore degli item per rispettare lo ZOrder
       
        ObjectsZOrder objz = CtrlWorkspace.getInstance().getObjectsZOrder(idModulo, screenIndex);
        tilesWorkspace[screenIndex].applyZOrder(objz);

        objs = CtrlWorkspace.getInstance().getLiveReadObjects(idModulo, screenIndex);
        objz = CtrlWorkspace.getInstance().getLiveReadObjectsZOrder(idModulo, screenIndex);
        previewWorkspace[screenIndex].setScreenObjects(objs);
        previewWorkspace[screenIndex].loadTilesFromBean();
        previewWorkspace[screenIndex].applyZOrder(objz);
        
    }

    
    
    public void reloadAllLayoutsAndPreviews() {
        for (int i=0; i<numScreens; i++) {
            Objects objs = CtrlWorkspace.getInstance().getObjects(idModulo, i);            
            tilesWorkspace[i].loadTilesFromBean(objs);
        //ORDINO il vettore degli item per rispettare lo ZOrder
        //TODO: ottimizzare il tilesworkspace quando aggiunge elementi per non ordinare successivamenteCtrlWorkspace.getInstance().getObjectsZOrder(idModulo)
            tilesWorkspace[i].applyZOrder(CtrlWorkspace.getInstance().getObjectsZOrder(idModulo, i));
 
            previewWorkspace[i].setScreenObjects(objs);
            previewWorkspace[i].loadTilesFromBean();
            previewWorkspace[i].applyZOrder();
        }
    }
    
    public void reloadAllTilesWorkspaces() {
        for (int i=0; i<numScreens; i++) {
            Objects objs = CtrlWorkspace.getInstance().getObjects(idModulo, i);            
            tilesWorkspace[i].loadTilesFromBean(objs);
            //ORDINO il vettore degli item per rispettare lo ZOrder
            //TODO: ottimizzare il tilesworkspace quando aggiunge elementi per non ordinare successivamenteCtrlWorkspace.getInstance().getObjectsZOrder(idModulo)
            tilesWorkspace[i].applyZOrder(CtrlWorkspace.getInstance().getObjectsZOrder(idModulo, i));
        }
    }
    
    public void reloadAllPreviews() {
        for (int i=0; i<numScreens; i++) {
            Objects objs = CtrlWorkspace.getInstance().getLiveReadObjects(idModulo, i);
            ObjectsZOrder objz = CtrlWorkspace.getInstance().getLiveReadObjectsZOrder(idModulo, i);
        
            previewWorkspace[i].setScreenObjects(objs);
            previewWorkspace[i].loadTilesFromBean();
            previewWorkspace[i].applyZOrder(objz);
        }
    }

    public void reloadAllPreviewsFromTilesWorkspace() {
        for (int i=0; i<numScreens; i++) {
            CtrlWorkspace.getInstance().copyConfigToLiveReadObjects();
            Objects objs = CtrlWorkspace.getInstance().getLiveReadObjects(idModulo, i);
            ObjectsZOrder objz = CtrlWorkspace.getInstance().getLiveReadObjectsZOrder(idModulo, i);

            previewWorkspace[i].setScreenObjects(objs);
            previewWorkspace[i].loadTilesFromBean();
            previewWorkspace[i].applyZOrder(objz);
        }
    }

    
    public int getIdModulo() {
        return idModulo;
    }
    
    public boolean isCopyDone() {
        return copyDone;
    }

    public void setCopyDone(boolean copyDone) {
        this.copyDone = copyDone;
    }
    
    public TilesWorkspace getTilesWorkspace() {
        return tilesWorkspace[currentScreen];
    }
    
    public TilesWorkspace getTilesWorkspace(int index) {
        return tilesWorkspace[index];
    }

    public void setTilesWorkspace(TilesWorkspace tilesWorkspace, int screenIndex) {
        this.tilesWorkspace[screenIndex] = tilesWorkspace;
    }

    public TilesWorkspace getPreviewWorkspace() {
        return previewWorkspace[currentScreen];
    }

    public TilesWorkspace getPreviewWorkspace(int index) {
        return previewWorkspace[index];
    }
    
    public void setPreviewWorkspace(TilesWorkspace previewWorkspace, int screenIndex) {
        this.previewWorkspace[screenIndex] = previewWorkspace;
    }

    public int getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(int currentScreen) {
        this.currentScreen = currentScreen;
    }

    /**
     * @return the autoUpdate
     */
    public boolean isAutoUpdate() {
        return autoUpdate;
    }

    /**
     * @param autoUpdate the autoUpdate to set
     */
    public void toggleAutoUpdate() {
        autoUpdate = !autoUpdate;
    }
}