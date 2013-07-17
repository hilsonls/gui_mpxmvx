package gui;


import gui.utils.MyTreeMouseListener;
import gui.utils.MyTreeRenderer;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.components.JFrontLayoutPanel;
import gui.components.JIDStringNode;
import gui.components.JSplashFrame;
import gui.menu.MenuGrid;
import gui.menu.MenuGroup;
import gui.menu.MenuHelp;
import gui.menu.MenuLayout;
import gui.menu.MenuModule;
import gui.menu.MenuObject;
import gui.menu.PopupMenuMV;
import gui.menu.ToolBarMV;
import gui.utils.MyComponentAdapter;
import gui.style.StyleInterface;
import gui.utils.GUIUtils;
import java.awt.*;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ToolTipManager;
import javax.swing.tree.*;

/**
 * Classe che gestisce la  GUI menu toolbars e managementtree
 * 
 * @author antonio e marco
 */
public class MultiViewerPanel extends JFrame {

    private static MultiViewerPanel instance = null;

    private JSplitPane centerPanel;
    private JSplitPane leftPanel;
    private JSplitPane rightPanel;
    private JSplitPane infoPanel;
    private JSplitPane treeAndLayoutPanel;
    private JPanel bottomPanel;
    private JPanel topPanel;
    private JPanel iconsPanel;
    private JFrontLayoutPanel frontLayoutPanel;

    private Container containerPanel;

    private DefaultTreeModel treeModel;
    private JScrollPane treeScrollPane;
    public JTree managementTree;

    private JToolBar screenBar;
    public JToggleButton[] screenButton;

    private JLabel stateLabel;
    private JLabel infoLabel;

    //fa ridere ma devo mettere qui sta cazzo di variabile del tree che tiene traccia della sorgente selezionata
    public int idSorgenteSelezionato;
    public JIDStringNode nodoSelezionato;


    //pattern Singleton
    public static MultiViewerPanel getInstance() {
      if(instance == null) {
         instance = new MultiViewerPanel();
      }
      return instance;
    }



    private MultiViewerPanel() {
        containerPanel = new JPanel();
        
        iconsPanel = new JPanel();
        topPanel = new JPanel();
        frontLayoutPanel = new JFrontLayoutPanel();
        frontLayoutPanel.setPreferredSize(new Dimension(150, 110));
        frontLayoutPanel.setMinimumSize(new Dimension(150 ,110));
        leftPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        infoPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        treeAndLayoutPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        centerPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        rightPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        bottomPanel = new JPanel();
        
        treeModel = new DefaultTreeModel(new DefaultMutableTreeNode("Objects"));
        treeScrollPane = new JScrollPane();
        managementTree = new JTree();
                
        screenBar = new JToolBar();
        stateLabel = new JLabel();
        infoLabel = new JLabel();
        infoLabel.setFont(new Font("Lucida", Font.BOLD , 10));
        
        ButtonGroup gruppoScreen = new ButtonGroup();
        
        screenButton = new JToggleButton[CtrlActions.getInstance().numScreens];
        for (int i=0; i<CtrlActions.getInstance().numScreens;i++) {
            screenButton[i] = new JToggleButton();
            screenButton[i].setSize(32,32);
            screenButton[i].setPreferredSize(new Dimension(32,32));
            screenButton[i].addItemListener(new ItemListener() {
                
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange()==ItemEvent.SELECTED) {
                        for (int i=0; i<CtrlActions.getInstance().numScreens; i++) {
                            if (e.getItemSelectable()==screenButton[i]) {
                                switchScreen(i);
                            }
                        }
                    }
                }

                
            });
            gruppoScreen.add(screenButton[i]);
        }
        gruppoScreen.setSelected(screenButton[0].getModel(), true);
        
        
        
    }

    public void createGUI(Container container) {
        try {
            CtrlActions ctrlActions = CtrlActions.getInstance();
            ((JPanel)containerPanel).setPreferredSize(new Dimension(800, 600));
            containerPanel.setLayout(new BorderLayout());
            JScrollPane jScrollpane = new JScrollPane();
            jScrollpane.getViewport().add(containerPanel);
            container.add(jScrollpane, "Center");

            for (int i=0; i<ctrlActions.numScreens;i++) {
                ctrlActions.setTilesWorkspace(new TilesWorkspace(stateLabel, infoLabel, i), i);
                ctrlActions.setPreviewWorkspace(new TilesWorkspace(null, null, i), i);
                ctrlActions.getTilesWorkspace().setPreferredSize(new Dimension(800, 600));
                ctrlActions.getPreviewWorkspace().setPreferredSize(new Dimension(300, 200));
            }


            //bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));
            bottomPanel.setLayout(new BorderLayout());
            bottomPanel.setPreferredSize(new Dimension(100, 20));
            bottomPanel.add(stateLabel);
            if (ctrlActions.numScreens > 1)
                bottomPanel.add(screenBar,BorderLayout.LINE_END);

            infoPanel.setPreferredSize(new Dimension(200,300));
            infoPanel.setDividerSize(3);
            infoPanel.setResizeWeight(1D);
            infoPanel.setTopComponent(ctrlActions.getPreviewWorkspace());
            JPanel infoPanel2 = new JPanel();
            infoPanel2.setLayout(new BorderLayout());
            infoPanel2.setPreferredSize(new Dimension(100,20));
            infoPanel2.add(infoLabel);
            infoPanel.setBottomComponent(infoPanel2);

            treeAndLayoutPanel.setPreferredSize(new Dimension(200,300));
            treeAndLayoutPanel.setDividerSize(3);
            treeAndLayoutPanel.setResizeWeight(1D);
            treeAndLayoutPanel.setTopComponent(treeScrollPane);
            treeAndLayoutPanel.setBottomComponent(frontLayoutPanel);
            treeAndLayoutPanel.setEnabled(false);


            leftPanel.setPreferredSize(new Dimension(200, 400));
            leftPanel.setMinimumSize(new Dimension(100, 100));
            leftPanel.setDividerSize(5);

            leftPanel.setTopComponent(treeAndLayoutPanel);




            leftPanel.setBottomComponent(infoPanel);

            leftPanel.addComponentListener(new MyComponentAdapter(leftPanel, 0.72D, 0.72D));

            rightPanel.setResizeWeight(1D);
            rightPanel.setDividerSize(3);

            rightPanel.setTopComponent(ctrlActions.getTilesWorkspace());
            rightPanel.setBottomComponent(bottomPanel);


            centerPanel.setDividerSize(5);
            centerPanel.setLeftComponent(leftPanel);
            centerPanel.setRightComponent(rightPanel);

            centerPanel.addComponentListener(new MyComponentAdapter(centerPanel, 0.2D, 0.2D));
            //ZIPPERO


            iconsPanel.setPreferredSize(new Dimension(100, 58));
            iconsPanel.setLayout(new FlowLayout(0));
            iconsPanel.addComponentListener(new ComponentListener() {

                public void componentResized(ComponentEvent e) {
                    int width = e.getComponent().getWidth();
                    Dimension dim = ((FlowLayout)iconsPanel.getLayout()).minimumLayoutSize(iconsPanel);
                    if (width < dim.width - 4)
                        topPanel.setPreferredSize(new Dimension(topPanel.getWidth(), dim.height*2));
                    else
                        topPanel.setPreferredSize(new Dimension(topPanel.getWidth(), dim.height));
                    //topPanel.setPreferredSize(new Dimension(topPanel.getWidth(), height));
                    
                }

                public void componentMoved(ComponentEvent e) {

                }

                public void componentShown(ComponentEvent e) {

                }

                public void componentHidden(ComponentEvent e) {

                }
            });

            topPanel.setLayout(new BorderLayout());
            topPanel.add(iconsPanel,BorderLayout.CENTER);
            getContentPane().add(topPanel, "North");
            getContentPane().add(centerPanel, "Center");


/*            updateBar.setBounds(240, 60, 432, 36);
            objectBar.setBounds(240, 108, 432, 36);
            editBar.setBounds(240, 156, 432, 36);
            groupBar.setBounds(240, 204, 437, 40);
            layoutBar.setBounds(240, 204, 437, 40);*/

            if (ctrlActions.numScreens > 1){
                screenBar.setOpaque(false);
                screenBar.setFloatable(false);
                screenBar.setPreferredSize(new Dimension(120, 36));
                screenBar.setSize(120,36);
                JLabel videoOutputLabel = new JLabel("<HTML>Video<br>Output</HTML>");
                videoOutputLabel.setOpaque(false);
                screenBar.add(videoOutputLabel);
                for (int i=0; i<ctrlActions.numScreens;i++) {
                    screenBar.add(screenButton[i]);
                }
            }


            managementTree.setBackground(StyleInterface.getInstance().getTreeBackgroundColor());
            managementTree.setRootVisible(false);
            managementTree.setModel(treeModel);
            treeScrollPane.getViewport().add(managementTree);
            treeScrollPane.setOpaque(true);


            for (int i=0; i<ctrlActions.numScreens;i++) {
                screenButton[i].setIcon(GUIUtils.getInstance().getIcon("screen"+(i+1)+"off.gif"));
                screenButton[i].setToolTipText("Switch to video output "+(i+1));
            }

            iconsPanel.add(ToolBarMV.getInstance().getEditBar());
            iconsPanel.add(ToolBarMV.getInstance().getObjectBar());
            iconsPanel.add(ToolBarMV.getInstance().getGroupBar());
            iconsPanel.add(ToolBarMV.getInstance().getUpdateBar());
            iconsPanel.add(ToolBarMV.getInstance().getLayoutBar());

            topPanel.add(ToolBarMV.getInstance().getLogoBar(),BorderLayout.LINE_END);

            for (int porcogiuda = 0; porcogiuda < ctrlActions.numScreens ; porcogiuda++){
                TilesWorkspace layoutWorkspace = ctrlActions.getTilesWorkspace(porcogiuda);
                layoutWorkspace.setEnabledEdit(true);
                layoutWorkspace.setEnabled(true);
                layoutWorkspace.setPreview(false);
                TilesWorkspace viewerWorkspace = ctrlActions.getPreviewWorkspace(porcogiuda);
                viewerWorkspace.setEnabledEdit(false);
                viewerWorkspace.setEnabled(false);
                viewerWorkspace.setPreview(true);
            }

            managementTree.setModel(CtrlWorkspace.getInstance().getTreeModel(ctrlActions.getIdModulo()));
            managementTree.expandPath(managementTree.getPathForRow(0));
            managementTree.addMouseListener(new MyTreeMouseListener(this));
            managementTree.setCellRenderer(new MyTreeRenderer(GUIUtils.getInstance().getIcon("objicon.gif"), GUIUtils.getInstance().getIcon("sourceicon.gif"), GUIUtils.getInstance().getIcon("layouticon.gif"), this));

            ToolTipManager.sharedInstance().registerComponent(managementTree);
            ToolTipManager.sharedInstance().setDismissDelay(1000);
            ToolTipManager.sharedInstance().setInitialDelay(400);
            ToolTipManager.sharedInstance().setReshowDelay(400);

            ctrlActions.prepare();
            ctrlActions.setLayoutTitle();
            updateGUI();

            ((JFrame)JOptionPane.getFrameForComponent(ctrlActions.getTilesWorkspace())).setGlassPane(JSplashFrame.getJSplashPanel(null, null, GUIUtils.getInstance().getIcon("splash.gif")));
        } catch (MVException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void freeze(boolean freezing) {

        boolean enabled = !freezing;

        MenuModule.getInstance().getMenu().setEnabled(enabled);
        MenuLayout.getInstance().getMenu().setEnabled(enabled);
        MenuObject.getInstance().getMenu().setEnabled(enabled);
        MenuGrid.getInstance().getMenu().setEnabled(enabled);
        MenuGroup.getInstance().getMenu().setEnabled(enabled);
        MenuHelp.getInstance().getMenu().setEnabled(enabled);

        ToolBarMV.getInstance().freeze(enabled);

        managementTree.setEnabled(enabled);
        CtrlActions.getInstance().getTilesWorkspace().setEnabledEdit(enabled);

        MenuModule.getInstance().updateMenu();
        MenuGroup.getInstance().updateMenu();
        MenuObject.getInstance().updateMenu();
        MenuGrid.getInstance().updateMenu();
        PopupMenuMV.getInstance().updateMenu();
    }
  


    public void updateGUI() {
        // System.out.println("AZZO");
        
        MenuModule.getInstance().updateMenu();
        MenuGroup.getInstance().updateMenu();
        MenuObject.getInstance().updateMenu();
        MenuGrid.getInstance().updateMenu();
        ToolBarMV.getInstance().updateMenu();
        updateUndoRedo();
        updatePaste();
    }

    public void updateUndoRedo() {
        ToolBarMV.getInstance().updateMenu();
    }
    

    public void updatePaste(){
        
            MenuObject.getInstance().updateMenu();
            PopupMenuMV.getInstance().updateMenu();
            ToolBarMV.getInstance().updateMenu();
            
            
    }



    
    
    public JTree getTreeObjects() {
        return this.managementTree;
    }
    

    
    private void switchScreen(int i) {
        CtrlActions ctrlActions = CtrlActions.getInstance();
        ctrlActions.setCurrentScreen(i);
        int divLoc = rightPanel.getDividerLocation();
        //int lastDivLoc = rightPanel.getLastDividerLocation();
        rightPanel.setTopComponent(ctrlActions.getTilesWorkspace());
        rightPanel.setDividerLocation(divLoc);
        //rightPanel.setLastDividerLocation(lastDivLoc);

        divLoc = leftPanel.getDividerLocation();
        //lastDivLoc = leftPanel.getLastDividerLocation();
        leftPanel.setBottomComponent(ctrlActions.getPreviewWorkspace());
        leftPanel.setDividerLocation(divLoc);
        
        // il  controllo != null è fatto per assicurarsi che non sia la prima volta in cui è eseguito il metodo
        if (ctrlActions.getTilesWorkspace() != null){
            ctrlActions.getTilesWorkspace().loadTilesFromBean();
            ctrlActions.getTilesWorkspace().applyZOrder();
            //AGGIORNO GRID MENU
            int gridSize = ctrlActions.getTilesWorkspace().getGridNumColumns();
            MenuGrid.getInstance().switchGrid(gridSize);
            ctrlActions.getTilesWorkspace().requestFocusInWindow();
        }
        //leftPanel.setLastDividerLocation(lastDivLoc);
        
        
        
        return;
    }

    @Override
    public Container getContentPane() {
        return containerPanel;
    }

    public void updateFrontPanelLayout(int idLayout) {
        frontLayoutPanel.selectButtonLayout(idLayout);
    }
    
    

}
