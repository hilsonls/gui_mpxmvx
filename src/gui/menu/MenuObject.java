package gui.menu;

import gui.CtrlActions;
import gui.components.JMenuBGGradient;
import gui.components.JMenuItemBGGradient;
import gui.utils.GUIUtils;
import gui.utils.MyMenuActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;

/**
 *
 * @author Antonio  Knight
 */
public class MenuObject{

    private static MenuObject instance = null;
    private JMenu menuInstance = null;

    private JMenuItemBGGradient newObjectItem;
    private JMenuItemBGGradient editObjectItem;
    private JMenuItemBGGradient cutObjectItem;
    private JMenuItemBGGradient copyObjectItem;
    private JMenuItemBGGradient pasteObjectItem;
    private JMenuItemBGGradient pasteNewObjectItem;
    private JSeparator objectSeparator;
    private JMenuItemBGGradient moveToFrontItem;
    private JMenuItemBGGradient moveToBackItem;
    private JMenuItemBGGradient fitObjectOntoGridItem;
    private JMenuItemBGGradient sizeObjectToGridItem;
    private JMenuItemBGGradient sizeObjectToScreenItem;
    

    //pattern Singleton
    public static MenuObject getInstance() {
      if(instance == null) {
         instance = new MenuObject();
      }
      return instance;
    }

    public JMenu getMenu(){
        return menuInstance;
    }

    private MenuObject (){


        menuInstance = new JMenuBGGradient();
        constructItemMenu();
        setText();
        setIcon();
        setActionCommand();
        setActionListener();
        addMenuItems();
        //Finezze


    }

    private void setText(){

        menuInstance.setText("Object");
        newObjectItem.setText("New object");
        editObjectItem.setText("Edit object");
        cutObjectItem.setText("Cut object");
        copyObjectItem.setText("Copy object");
        pasteObjectItem.setText("Paste object");
        pasteNewObjectItem.setText("Paste new object");
        moveToFrontItem.setText("Move object to front");
        moveToBackItem.setText("Move object to back");
        fitObjectOntoGridItem.setText("Fit object onto grid");
        sizeObjectToGridItem.setText("Size object to grid");
        sizeObjectToScreenItem.setText("Size object to screen");

    }

    private void setActionCommand() {
        newObjectItem.setActionCommand("Add");
        editObjectItem.setActionCommand("Edit");
        cutObjectItem.setActionCommand("Cut");
        copyObjectItem.setActionCommand("Copy");
        pasteObjectItem.setActionCommand("Paste");
        pasteNewObjectItem.setActionCommand("PasteNew");
        moveToFrontItem.setActionCommand("Front");
        moveToBackItem.setActionCommand("Back");
        fitObjectOntoGridItem.setActionCommand("Fit");
        sizeObjectToGridItem.setActionCommand("Grid");
        sizeObjectToScreenItem.setActionCommand("Screen");
    }

    private void setIcon() {
        GUIUtils utils = GUIUtils.getInstance();

        newObjectItem.setIcon(utils.getIcon("new-object.gif"));
        editObjectItem.setIcon(utils.getIcon("edit.gif"));
        cutObjectItem.setIcon(utils.getIcon("cut.gif"));
        copyObjectItem.setIcon(utils.getIcon("copy.gif"));
        pasteObjectItem.setIcon(utils.getIcon("paste.gif"));
        pasteNewObjectItem.setIcon(utils.getIcon("paste-new.gif"));
        moveToFrontItem.setIcon(utils.getIcon("go-to-front.gif"));
        moveToBackItem.setIcon(utils.getIcon("go-to-back.gif"));
        fitObjectOntoGridItem.setIcon(utils.getIcon("fit.gif"));
        sizeObjectToGridItem.setIcon(utils.getIcon("grid.gif"));
        sizeObjectToScreenItem.setIcon(utils.getIcon("screen.gif"));
    }

    private void setActionListener() {
        MyMenuActionListener listener = MyMenuActionListener.getInstance();

        newObjectItem.addActionListener(listener);
        editObjectItem.addActionListener(listener);
        cutObjectItem.addActionListener(listener);
        copyObjectItem.addActionListener(listener);
        pasteObjectItem.addActionListener(listener);
        pasteNewObjectItem.addActionListener(listener);
        moveToFrontItem.addActionListener(listener);
        moveToBackItem.addActionListener(listener);
        fitObjectOntoGridItem.addActionListener(listener);
        sizeObjectToGridItem.addActionListener(listener);
        sizeObjectToScreenItem.addActionListener(listener);
    }

    private void constructItemMenu() {

        newObjectItem = new JMenuItemBGGradient();
        editObjectItem = new JMenuItemBGGradient();
        cutObjectItem = new JMenuItemBGGradient();
        copyObjectItem = new JMenuItemBGGradient();
        pasteObjectItem = new JMenuItemBGGradient();
        pasteNewObjectItem = new JMenuItemBGGradient();
        objectSeparator = new JSeparator();
        moveToFrontItem = new JMenuItemBGGradient();
        moveToBackItem = new JMenuItemBGGradient();
        fitObjectOntoGridItem = new JMenuItemBGGradient();
        sizeObjectToGridItem = new JMenuItemBGGradient();
        sizeObjectToScreenItem = new JMenuItemBGGradient();

    }

    private void addMenuItems() {
        menuInstance.add(newObjectItem);
        menuInstance.add(editObjectItem);
        menuInstance.add(cutObjectItem);
        menuInstance.add(copyObjectItem);
        menuInstance.add(pasteObjectItem);
        menuInstance.add(pasteNewObjectItem);
        menuInstance.add(objectSeparator);
        menuInstance.add(moveToFrontItem);
        menuInstance.add(moveToBackItem);
        menuInstance.add(fitObjectOntoGridItem);
        menuInstance.add(sizeObjectToGridItem);
        menuInstance.add(sizeObjectToScreenItem);
    }

    public void updateMenu(){
        pasteObjectItem.setEnabled(CtrlActions.getInstance().isCopyDone());
        pasteNewObjectItem.setEnabled(CtrlActions.getInstance().isCopyDone());
    }
   
}
