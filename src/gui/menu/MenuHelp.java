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
public class MenuHelp{

    private static MenuHelp instance = null;
    private JMenu menuInstance = null;
    
    private JMenuItemBGGradient aboutItem;

    //pattern Singleton
    public static MenuHelp getInstance() {
      if(instance == null) {
         instance = new MenuHelp();
      }
      return instance;
    }

    public JMenu getMenu(){
        return menuInstance;
    }

    private MenuHelp (){


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

        menuInstance.setText("Help");
        aboutItem.setText("About");
        

    }

    private void setActionCommand() {
        aboutItem.setActionCommand("About");
        
    }

    private void setIcon() {
        GUIUtils utils = GUIUtils.getInstance();

    }

    private void setActionListener() {
        MyMenuActionListener listener = MyMenuActionListener.getInstance();

        aboutItem.addActionListener(listener);
        
    }

    private void constructItemMenu() {

        
        aboutItem = new JMenuItemBGGradient();

    }

    private void addMenuItems() {
        menuInstance.add(aboutItem);
        
    }

   
   
}
