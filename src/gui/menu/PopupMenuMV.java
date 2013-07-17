package gui.menu;

import gui.CtrlActions;
import gui.MultiViewerPopupMenu;
import gui.components.JMenuBGGradient;
import gui.components.JMenuItemBGGradient;
import gui.utils.GUIUtils;
import gui.utils.MyMenuActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

/**
 *
 * @author Antonio  Knight
 */
public class PopupMenuMV{

    private static PopupMenuMV instance = null;
    private MultiViewerPopupMenu popupMenuInstance = null;
    private MultiViewerPopupMenu popupScreenMenuInstance = null;

    private JMenuItemBGGradient moveToFrontItemPU;
    private JMenuItemBGGradient moveToBackItemPU;
    private JMenuItemBGGradient copyObjectItemPU;
    private JMenuItemBGGradient pasteObjectItemPU;
    private JMenuItemBGGradient pasteNewObjectItemPU;
    private JMenuItemBGGradient pasteNewObjectItemPUS;
    private JMenuItemBGGradient fitObjectItemPU;
    private JMenuItemBGGradient sizeObjectToScreenItemPU;
    private JMenuItemBGGradient sizeObjectToGridItemPU;
    private JMenuItemBGGradient newObjectItemPU;
    private JMenuItemBGGradient newObjectItemPUS;
    private JMenuItemBGGradient editObjectItemPU;
    private JMenuItemBGGradient cutObjectItemPU;
    private JMenuItemBGGradient setupLayoutItemPUS;

   
    //pattern Singleton
    public static PopupMenuMV getInstance() {
      if(instance == null) {
         instance = new PopupMenuMV();
      }
      return instance;
    }

    public MultiViewerPopupMenu getPopupMenu(){
        return popupMenuInstance;
    }

    public MultiViewerPopupMenu getPopupScreenMenu(){
        return popupScreenMenuInstance;
    }

    private PopupMenuMV (){

        popupMenuInstance = new MultiViewerPopupMenu();
        popupScreenMenuInstance = new MultiViewerPopupMenu();
        constructItemMenu();
        setText();
        setIcon();
        setActionCommand();
        setActionListener();
        addMenuItems();
        //Finezze
        newObjectItemPU.setOpaque(false);
        editObjectItemPU.setOpaque(false);
        cutObjectItemPU.setOpaque(false);
        copyObjectItemPU.setOpaque(false);
        pasteObjectItemPU.setOpaque(false);
        pasteNewObjectItemPU.setOpaque(false);
        moveToFrontItemPU.setOpaque(false);
        moveToBackItemPU.setOpaque(false);
        fitObjectItemPU.setOpaque(false);
        sizeObjectToGridItemPU.setOpaque(false);
        sizeObjectToScreenItemPU.setOpaque(false);
        newObjectItemPUS.setOpaque(false);
        pasteNewObjectItemPUS.setOpaque(false);
        setupLayoutItemPUS.setOpaque(false);

    }

    private void setText(){

        newObjectItemPU.setText("New object");
        editObjectItemPU.setText("Edit object");
        cutObjectItemPU.setText("Cut object");
        copyObjectItemPU.setText("Copy object");
        pasteObjectItemPU.setText("Paste object");
        pasteNewObjectItemPU.setText("Paste new object");
        moveToFrontItemPU.setText("Move object to front");
        moveToBackItemPU.setText("Move object to back");
        fitObjectItemPU.setText("Fit object onto grid");
        sizeObjectToGridItemPU.setText("Size object to grid");
        sizeObjectToScreenItemPU.setText("Size object to screen");
        newObjectItemPUS.setText("New object");
        pasteNewObjectItemPUS.setText("Paste new object");
        setupLayoutItemPUS.setText("Setup layout");

    }

    private void setActionCommand() {
        newObjectItemPU.setActionCommand("Add");
        editObjectItemPU.setActionCommand("Edit");
        cutObjectItemPU.setActionCommand("Cut");
        copyObjectItemPU.setActionCommand("Copy");
        pasteObjectItemPU.setActionCommand("Paste");
        pasteNewObjectItemPU.setActionCommand("PasteNew");
        moveToFrontItemPU.setActionCommand("Front");
        moveToBackItemPU.setActionCommand("Back");
        fitObjectItemPU.setActionCommand("Fit");
        sizeObjectToGridItemPU.setActionCommand("Grid");
        sizeObjectToScreenItemPU.setActionCommand("Screen");
        newObjectItemPUS.setActionCommand("Add");
        pasteNewObjectItemPUS.setActionCommand("PasteNew");
        setupLayoutItemPUS.setActionCommand("Layout");
    }

    private void setIcon() {
        GUIUtils utils = GUIUtils.getInstance();

        moveToFrontItemPU.setIcon(utils.getIcon("go-to-front.gif"));
        moveToBackItemPU.setIcon(utils.getIcon("go-to-back.gif"));
        copyObjectItemPU.setIcon(utils.getIcon("copy.gif"));
        pasteObjectItemPU.setIcon(utils.getIcon("paste.gif"));
        pasteNewObjectItemPU.setIcon(utils.getIcon("paste-new.gif"));
        pasteNewObjectItemPUS.setIcon(utils.getIcon("paste-new.gif"));
        fitObjectItemPU.setIcon(utils.getIcon("fit.gif"));
        sizeObjectToScreenItemPU.setIcon(utils.getIcon("screen.gif"));
        sizeObjectToGridItemPU.setIcon(utils.getIcon("grid.gif"));
        newObjectItemPU.setIcon(utils.getIcon("new-object.gif"));
        newObjectItemPUS.setIcon(utils.getIcon("new-object.gif"));
        editObjectItemPU.setIcon(utils.getIcon("edit.gif"));
        cutObjectItemPU.setIcon(utils.getIcon("cut.gif"));
        setupLayoutItemPUS.setIcon(utils.getIcon("setup-layout.gif"));
    }

    private void setActionListener() {
        MyMenuActionListener listener = MyMenuActionListener.getInstance();

        moveToFrontItemPU.addActionListener(listener);
        moveToBackItemPU.addActionListener(listener);
        copyObjectItemPU.addActionListener(listener);
        pasteObjectItemPU.addActionListener(listener);
        pasteNewObjectItemPU.addActionListener(listener);
        pasteNewObjectItemPUS.addActionListener(listener);
        fitObjectItemPU.addActionListener(listener);
        sizeObjectToScreenItemPU.addActionListener(listener);
        sizeObjectToGridItemPU.addActionListener(listener);
        newObjectItemPU.addActionListener(listener);
        newObjectItemPUS.addActionListener(listener);
        editObjectItemPU.addActionListener(listener);
        cutObjectItemPU.addActionListener(listener);
        setupLayoutItemPUS.addActionListener(listener);
    }

    private void constructItemMenu() {

        moveToFrontItemPU = new JMenuItemBGGradient();
    moveToBackItemPU = new JMenuItemBGGradient();
    copyObjectItemPU = new JMenuItemBGGradient();
    pasteObjectItemPU = new  JMenuItemBGGradient();
    pasteNewObjectItemPU = new JMenuItemBGGradient();
    pasteNewObjectItemPUS = new JMenuItemBGGradient();
    fitObjectItemPU = new JMenuItemBGGradient();
    sizeObjectToScreenItemPU = new JMenuItemBGGradient();
    sizeObjectToGridItemPU = new JMenuItemBGGradient();
    newObjectItemPU = new JMenuItemBGGradient();
    newObjectItemPUS = new JMenuItemBGGradient();
    editObjectItemPU = new JMenuItemBGGradient();
    cutObjectItemPU = new JMenuItemBGGradient();
    setupLayoutItemPUS = new JMenuItemBGGradient();

    }

    private void addMenuItems() {
        popupMenuInstance.add(newObjectItemPU);
        popupMenuInstance.add(editObjectItemPU);
        popupMenuInstance.add(cutObjectItemPU);
        popupMenuInstance.add(new JPopupMenu.Separator());
        popupMenuInstance.add(copyObjectItemPU);
        popupMenuInstance.add(pasteObjectItemPU);
        popupMenuInstance.add(pasteNewObjectItemPU);
        popupMenuInstance.add(new JPopupMenu.Separator());
        popupMenuInstance.add(moveToFrontItemPU);
        popupMenuInstance.add(moveToBackItemPU);
        popupMenuInstance.add(fitObjectItemPU);
        popupMenuInstance.add(sizeObjectToGridItemPU);
        popupMenuInstance.add(sizeObjectToScreenItemPU);

        popupScreenMenuInstance.add(newObjectItemPUS);
        popupScreenMenuInstance.add(pasteNewObjectItemPUS);
        popupScreenMenuInstance.add(new JPopupMenu.Separator());
        popupScreenMenuInstance.add(setupLayoutItemPUS);
    }

    public void updateMenu(){

        pasteNewObjectItemPU.setEnabled(CtrlActions.getInstance().isCopyDone());
        pasteObjectItemPU.setEnabled(CtrlActions.getInstance().isCopyDone());
        pasteNewObjectItemPUS.setEnabled(CtrlActions.getInstance().isCopyDone());
    }
   
}
