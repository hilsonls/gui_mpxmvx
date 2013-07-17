package gui.menu;

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
public class MenuLayout{

    private static MenuLayout instance = null;
    private JMenu menuInstance = null;

    private JMenuItemBGGradient newLayoutItem;
    private JMenuItemBGGradient loadLayoutItem;
    private JMenuItemBGGradient saveLayoutItem;
    private JMenuItemBGGradient saveAsLayoutItem;
    private JMenuItemBGGradient deleteLayoutItem;
    private JSeparator layoutSeparator;
    private JMenuItemBGGradient setupLayoutItem;
    

    //pattern Singleton
    public static MenuLayout getInstance() {
      if(instance == null) {
         instance = new MenuLayout();
      }
      return instance;
    }

    public JMenu getMenu(){
        return menuInstance;
    }

    private MenuLayout (){


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

        menuInstance.setText("Layout");
        newLayoutItem.setText("New layout");
        loadLayoutItem.setText("Load layout");
        saveLayoutItem.setText("Save layout");
        saveAsLayoutItem.setText("Save layout as");
        deleteLayoutItem.setText("Delete layout");
        setupLayoutItem.setText("Setup layout");

    }

    private void setActionCommand() {
        newLayoutItem.setActionCommand("New");
        loadLayoutItem.setActionCommand("Load");
        saveLayoutItem.setActionCommand("Save");
        saveAsLayoutItem.setActionCommand("SaveAs");
        deleteLayoutItem.setActionCommand("Delete");
        setupLayoutItem.setActionCommand("Layout");
    }

    private void setIcon() {
        GUIUtils utils = GUIUtils.getInstance();

        newLayoutItem.setIcon(utils.getIcon("newlay.gif"));
        loadLayoutItem.setIcon(utils.getIcon("Load.gif"));
        saveLayoutItem.setIcon(utils.getIcon("Save.gif"));
        saveAsLayoutItem.setIcon(utils.getIcon("Save-as.gif"));
        deleteLayoutItem.setIcon(utils.getIcon("Delete.gif"));
        setupLayoutItem.setIcon(utils.getIcon("setup-layout.gif"));
    }

    private void setActionListener() {
        MyMenuActionListener listener = MyMenuActionListener.getInstance();

        newLayoutItem.addActionListener(listener);
        loadLayoutItem.addActionListener(listener);
        saveLayoutItem.addActionListener(listener);
        saveAsLayoutItem.addActionListener(listener);
        deleteLayoutItem.addActionListener(listener);
        setupLayoutItem.addActionListener(listener);
    }

    private void constructItemMenu() {

        newLayoutItem = new JMenuItemBGGradient();
        loadLayoutItem = new JMenuItemBGGradient();
        saveLayoutItem = new JMenuItemBGGradient();
        saveAsLayoutItem = new JMenuItemBGGradient();
        deleteLayoutItem = new JMenuItemBGGradient();
        layoutSeparator = new JSeparator();
        setupLayoutItem = new JMenuItemBGGradient();

    }

    private void addMenuItems() {
        menuInstance.add(newLayoutItem);
        menuInstance.add(loadLayoutItem);
        menuInstance.add(saveLayoutItem);
        menuInstance.add(saveAsLayoutItem);
        menuInstance.add(deleteLayoutItem);
        menuInstance.add(layoutSeparator);
        menuInstance.add(setupLayoutItem);
    }

   
}
