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
public class MenuGroup{

    private static MenuGroup instance = null;
    private JMenu menuInstance = null;

    private JMenuItemBGGradient selectAllItem;
    private JMenuItemBGGradient unselectAllItem;
    private JSeparator groupSeparator;
    private JMenuItemBGGradient cutObjectsItem;
    private JMenuItemBGGradient pasteObjectsItem;
    private JMenuItemBGGradient moveObjectsToFrontItem;
    private JMenuItemBGGradient moveObjectsToBackItem;
    

    //pattern Singleton
    public static MenuGroup getInstance() {
      if(instance == null) {
         instance = new MenuGroup();
      }
      return instance;
    }

    public JMenu getMenu(){
        return menuInstance;
    }

    private MenuGroup (){


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

        menuInstance.setText("Group");
        selectAllItem.setText("Select all objects");
        unselectAllItem.setText("Unselect all objects");
        cutObjectsItem.setText("Cut objects");
        pasteObjectsItem.setText("Paste objects");
        moveObjectsToFrontItem.setText("Move objects to front");
        moveObjectsToBackItem.setText("Move objects to back");

    }

    private void setActionCommand() {
        selectAllItem.setActionCommand("SelectAll");
        unselectAllItem.setActionCommand("UnselectAll");
        cutObjectsItem.setActionCommand("GroupCut");
        pasteObjectsItem.setActionCommand("GroupPaste");
        moveObjectsToFrontItem.setActionCommand("GroupFront");
        moveObjectsToBackItem.setActionCommand("GroupBack");
    }

    private void setIcon() {
        GUIUtils utils = GUIUtils.getInstance();

        selectAllItem.setIcon(utils.getIcon("Select-All.gif"));
        unselectAllItem.setIcon(utils.getIcon("Unselect-All.gif"));
        cutObjectsItem.setIcon(utils.getIcon("cut.gif"));
        pasteObjectsItem.setIcon(utils.getIcon("paste.gif"));
        moveObjectsToFrontItem.setIcon(utils.getIcon("go-to-front.gif"));;
        moveObjectsToBackItem.setIcon(utils.getIcon("go-to-back.gif"));
    }

    private void setActionListener() {
        MyMenuActionListener listener = MyMenuActionListener.getInstance();

        selectAllItem.addActionListener(listener);
        unselectAllItem.addActionListener(listener);
        cutObjectsItem.addActionListener(listener);
        pasteObjectsItem.addActionListener(listener);
        moveObjectsToFrontItem.addActionListener(listener);
        moveObjectsToBackItem.addActionListener(listener);
    }

    private void constructItemMenu() {

        selectAllItem = new JMenuItemBGGradient();
        unselectAllItem = new JMenuItemBGGradient();
        groupSeparator = new JSeparator();
        cutObjectsItem = new JMenuItemBGGradient();
        pasteObjectsItem = new JMenuItemBGGradient();
        moveObjectsToFrontItem = new JMenuItemBGGradient();
        moveObjectsToBackItem = new JMenuItemBGGradient();

    }

    private void addMenuItems() {
        menuInstance.add(selectAllItem);
        menuInstance.add(unselectAllItem);
        menuInstance.add(groupSeparator);
        menuInstance.add(cutObjectsItem);
        menuInstance.add(pasteObjectsItem);
        menuInstance.add(moveObjectsToFrontItem);
        menuInstance.add(moveObjectsToBackItem);
    }

    public void updateMenu(){
        boolean isGroup = CtrlActions.getInstance().getTilesWorkspace().isGroup();
        cutObjectsItem.setEnabled(isGroup);
        pasteObjectsItem.setEnabled(isGroup);
        moveObjectsToFrontItem.setEnabled(isGroup);
        moveObjectsToBackItem.setEnabled(isGroup);
    }
   
}
