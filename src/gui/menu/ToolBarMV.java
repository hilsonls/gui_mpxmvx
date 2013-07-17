package gui.menu;

import controllori.CtrlWorkspace;
import gui.CtrlActions;
import gui.MultiViewerPopupMenu;
import gui.components.JMenuBGGradient;
import gui.components.JMenuItemBGGradient;
import gui.style.StyleInterface;
import gui.utils.GUIUtils;
import gui.utils.MyButtonActionListener;
import gui.utils.MyMenuActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

/**
 *
 * @author Antonio  Knight
 */
public class ToolBarMV{

    private static ToolBarMV instance = null;

    private JToolBar editBar;
    private JToolBar objectBar;
    private JToolBar groupBar;
    private JToolBar updateBar;
    private JToolBar layoutBar;
    private JToolBar logoBar;

    private JButton newButton;
    private JButton editButton;
    private JButton cutButton;
    private JButton copyButton;
    private JButton pasteButton;
    private JButton pasteNewButton;
    private JButton undoButton;
    private JButton redoButton;

    private JButton frontButton;
    private JButton backButton;
    private JButton gridButton;
    private JButton fullButton;

    private JButton selectAllButton;
    private JButton unselectAllButton;
    private JButton snapToGridButton;

    private JButton autoButton;
    private JButton updateButton;
    private JButton getButton;

    private JButton loadLayoutButton;
    private JButton saveLayoutButton;

    private JLabel logoLabel;

    private ImageIcon fixedOnIcon;
    private ImageIcon fixedOffIcon;
    private ImageIcon autoOffIcon;
    private ImageIcon autoOnIcon;

    //pattern Singleton
    public static ToolBarMV getInstance() {
      if(instance == null) {
         instance = new ToolBarMV();
      }
      return instance;
    }

    private ToolBarMV (){

        editBar = new JToolBar();
        objectBar = new JToolBar();
        groupBar = new JToolBar();
        updateBar = new JToolBar();
        layoutBar = new JToolBar();
        logoBar = new JToolBar();

        editBar.setFloatable(false);
        objectBar.setFloatable(false);
        groupBar.setFloatable(false);
        updateBar.setFloatable(false);
        layoutBar.setFloatable(false);
        logoBar.setFloatable(false);

        editBar.setBounds(340,200,400,40);
        objectBar.setBounds(340,200,400,40);
        groupBar.setBounds(340,200,400,40);
        updateBar.setBounds(340,200,400,40);
        layoutBar.setBounds(340,200,400,40);
        logoBar.setBounds(340,200,400,40);


        constructItemMenu();
        setToolTipText();
        setIcon();
        setActionCommand();
        setActionListener();
        addMenuItems();
        updateMenu();
        //Finezze
        
        newButton.setRequestFocusEnabled(false);
        editButton.setRequestFocusEnabled(false);
        cutButton.setRequestFocusEnabled(false);
        copyButton.setRequestFocusEnabled(false);
        pasteButton.setRequestFocusEnabled(false);
        pasteNewButton.setRequestFocusEnabled(false);
        frontButton.setRequestFocusEnabled(false);
        backButton.setRequestFocusEnabled(false);
        gridButton.setRequestFocusEnabled(false);
        fullButton.setRequestFocusEnabled(false);
        undoButton.setRequestFocusEnabled(false);
        redoButton.setRequestFocusEnabled(false);
        selectAllButton.setRequestFocusEnabled(false);
        unselectAllButton.setRequestFocusEnabled(false);
        snapToGridButton.setRequestFocusEnabled(false);
        updateButton.setRequestFocusEnabled(false);
        getButton.setRequestFocusEnabled(false);
        autoButton.setRequestFocusEnabled(false);
        loadLayoutButton.setRequestFocusEnabled(false);
        saveLayoutButton.setRequestFocusEnabled(false);
        logoLabel.setRequestFocusEnabled(false);

    }

    private void setToolTipText(){

        newButton.setToolTipText("New object");
        editButton.setToolTipText("Edit object");
        cutButton.setToolTipText("Cut object");
        copyButton.setToolTipText("Copy object");
        pasteButton.setToolTipText("Paste object");
        pasteNewButton.setToolTipText("Paste new object");
        undoButton.setToolTipText("Undo object");
        redoButton.setToolTipText("Redo object");
        frontButton.setToolTipText("Move object to front");
        backButton.setToolTipText("Move object to back");
        gridButton.setToolTipText("Size object to grid");
        fullButton.setToolTipText("Size object to screen");
        selectAllButton.setToolTipText("Select all objects");
        unselectAllButton.setToolTipText("Unselect all objects");
        snapToGridButton.setToolTipText("Snap to grid");
        autoButton.setToolTipText("Auto update");
        updateButton.setToolTipText("Update layout");
        getButton.setToolTipText("Get layout");
        loadLayoutButton.setToolTipText("Load layout");
        saveLayoutButton.setToolTipText("Save layout");

        autoOffIcon = GUIUtils.getInstance().getIcon("auto.gif");
        autoOnIcon = GUIUtils.getInstance().getIcon("auto-selected.gif");
        fixedOffIcon = GUIUtils.getInstance().getIcon("fix.gif");
        fixedOnIcon = GUIUtils.getInstance().getIcon("fix-selected.gif");

    }

    private void setActionCommand() {
        newButton.setActionCommand("Add");
        editButton.setActionCommand("Edit");
        cutButton.setActionCommand("Cut");
        copyButton.setActionCommand("Copy");
        pasteButton.setActionCommand("Paste");
        pasteNewButton.setActionCommand("PasteNew");
        frontButton.setActionCommand("Front");
        backButton.setActionCommand("Back");
        gridButton.setActionCommand("Grid");
        fullButton.setActionCommand("Screen");
        undoButton.setActionCommand("Undo");
        redoButton.setActionCommand("Redo");
        selectAllButton.setActionCommand("SelectAll");
        unselectAllButton.setActionCommand("UnselectAll");
        snapToGridButton.setActionCommand("Fix");
        autoButton.setActionCommand("Auto");
        updateButton.setActionCommand("Update");
        getButton.setActionCommand("Get");
        loadLayoutButton.setActionCommand("Load");
        saveLayoutButton.setActionCommand("Save");
    }

    private void setIcon() {
        GUIUtils utils = GUIUtils.getInstance();

        newButton.setIcon(utils.getIcon("new-object.gif"));
        editButton.setIcon(utils.getIcon("edit.gif"));
        cutButton.setIcon(utils.getIcon("cut.gif"));
        copyButton.setIcon(utils.getIcon("copy.gif"));
        pasteButton.setIcon(utils.getIcon("paste.gif"));
        pasteNewButton.setIcon(utils.getIcon("paste-new.gif"));
        undoButton.setIcon(utils.getIcon("undo.gif"));
        redoButton.setIcon(utils.getIcon("redo.gif"));
        frontButton.setIcon(utils.getIcon("go-to-front.gif"));
        backButton.setIcon(utils.getIcon("go-to-back.gif"));
        fullButton.setIcon(utils.getIcon("screen.gif"));
        gridButton.setIcon(utils.getIcon("grid.gif"));
        selectAllButton.setIcon(utils.getIcon("Select-All.gif"));
        unselectAllButton.setIcon(utils.getIcon("Unselect-All.gif"));
        updateButton.setIcon(utils.getIcon("update.gif"));
        getButton.setIcon(utils.getIcon("get.gif"));
        loadLayoutButton.setIcon(utils.getIcon("Load.gif"));
        saveLayoutButton.setIcon(utils.getIcon("Save.gif"));


        
    }

    private void setActionListener() {
        MyButtonActionListener listener = MyButtonActionListener.getInstance();
        
        newButton.addActionListener(listener);
        editButton.addActionListener(listener);
        cutButton.addActionListener(listener);
        pasteButton.addActionListener(listener);
        pasteNewButton.addActionListener(listener);
        undoButton.addActionListener(listener);
        redoButton.addActionListener(listener);
        fullButton.addActionListener(listener);
        gridButton.addActionListener(listener);
        snapToGridButton.addActionListener(listener);
        selectAllButton.addActionListener(listener);
        unselectAllButton.addActionListener(listener);
        frontButton.addActionListener(listener);
        backButton.addActionListener(listener);
        autoButton.addActionListener(listener);
        getButton.addActionListener(listener);
        updateButton.addActionListener(listener);
        loadLayoutButton.addActionListener(listener);
        saveLayoutButton.addActionListener(listener);
        copyButton.addActionListener(listener);
    }

    private void constructItemMenu() {

        newButton = new JButton();
        editButton = new JButton();
        cutButton = new JButton();
        copyButton = new JButton();
        pasteButton = new JButton();
        pasteNewButton = new JButton();
        undoButton = new JButton();
        redoButton = new JButton();
        frontButton = new JButton();
        backButton = new JButton();
        gridButton = new JButton();
        fullButton = new JButton();
        selectAllButton = new JButton();
        unselectAllButton = new JButton();
        snapToGridButton = new JButton();
        autoButton = new JButton();
        updateButton = new JButton();
        getButton = new JButton();
        loadLayoutButton = new JButton();
        saveLayoutButton = new JButton();
        logoLabel = new JLabel(StyleInterface.getInstance().getLogo());
    }

    private void addMenuItems() {
        editBar.add(newButton);
        editBar.add(editButton);
        editBar.add(cutButton);
        editBar.add(copyButton);
        editBar.add(pasteButton);
        editBar.add(pasteNewButton);
        editBar.add(new JToolBar.Separator());
        editBar.add(undoButton);
        editBar.add(redoButton);

        objectBar.add(frontButton);
        objectBar.add(backButton);
        objectBar.add(gridButton);
        objectBar.add(fullButton);

        groupBar.add(selectAllButton);
        groupBar.add(unselectAllButton);
        groupBar.add(new JToolBar.Separator());
        groupBar.add(snapToGridButton);

        updateBar.add(autoButton);
        updateBar.add(updateButton);
        updateBar.add(getButton);

        layoutBar.add(loadLayoutButton);
        layoutBar.add(saveLayoutButton);

        logoBar.add(logoLabel);

    }

    public void updateMenu(){
        snapToGridButton.setIcon(CtrlActions.getInstance().getTilesWorkspace().isSnapToGrid() ? ((javax.swing.Icon) (fixedOnIcon)) : ((javax.swing.Icon) (fixedOffIcon)));
        autoButton.setIcon(CtrlActions.getInstance().isAutoUpdate() ? ((javax.swing.Icon) (autoOnIcon)) : ((javax.swing.Icon) (autoOffIcon)));
        undoButton.setEnabled(CtrlWorkspace.getInstance().canUndo());
        redoButton.setEnabled(CtrlWorkspace.getInstance().canRedo());
        pasteButton.setEnabled(CtrlActions.getInstance().isCopyDone());
        pasteNewButton.setEnabled(CtrlActions.getInstance().isCopyDone());
    }

        /**
     * @return the editBar
     */
    public JToolBar getEditBar() {
        return editBar;
    }

        /**
     * @return the objectBar
     */
    public JToolBar getObjectBar() {
        return objectBar;
    }

    /**
     * @return the groupBar
     */
    public JToolBar getGroupBar() {
        return groupBar;
    }

    /**
     * @return the updateBar
     */
    public JToolBar getUpdateBar() {
        return updateBar;
    }

    /**
     * @return the layoutBar
     */
    public JToolBar getLayoutBar() {
        return layoutBar;
    }

    /**
     * @return the logoBar
     */
    public JToolBar getLogoBar() {
        return logoBar;
    }

    public void freeze(boolean enabled) {

        newButton.setEnabled(enabled);
        editButton.setEnabled(enabled);
        cutButton.setEnabled(enabled);
        copyButton.setEnabled(enabled);
        pasteButton.setEnabled(enabled && CtrlActions.getInstance().isCopyDone());
        pasteNewButton.setEnabled(enabled && CtrlActions.getInstance().isCopyDone());
        frontButton.setEnabled(enabled);
        backButton.setEnabled(enabled);
        gridButton.setEnabled(enabled);
        fullButton.setEnabled(enabled);
        undoButton.setEnabled(enabled && CtrlWorkspace.getInstance().canUndo());
        redoButton.setEnabled(enabled && CtrlWorkspace.getInstance().canRedo());
        selectAllButton.setEnabled(enabled);
        unselectAllButton.setEnabled(enabled);
        snapToGridButton.setEnabled(enabled);
        updateButton.setEnabled(enabled);
        getButton.setEnabled(enabled);
        autoButton.setEnabled(enabled);
        loadLayoutButton.setEnabled(enabled);
        saveLayoutButton.setEnabled(enabled);
        logoLabel.setEnabled(enabled);
    }
   
}
