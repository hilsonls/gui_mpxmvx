package gui.menu;

import gui.components.JMenuBGGradient;
import gui.components.JMenuBarBGGradient;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author antonio
 */
public class MenuBarGUIGenerator {

    private static JMenuBarBGGradient menuBar;
    private static MenuBarGUIGenerator instance;

    
    //pattern Singleton
    public static MenuBarGUIGenerator getInstance() {
      if(instance == null) {
         menuBar = new JMenuBarBGGradient();
         instance = new MenuBarGUIGenerator();
      }
      return instance;
    }

    private MenuBarGUIGenerator(){
        
        menuBar.add(MenuModule.getInstance().getMenu());
        menuBar.add(MenuLayout.getInstance().getMenu());
        menuBar.add(MenuGroup.getInstance().getMenu());
        menuBar.add(MenuObject.getInstance().getMenu());
        menuBar.add(MenuGrid.getInstance().getMenu());
        menuBar.add(MenuHelp.getInstance().getMenu());

    }

    public JMenuBar getMenuBar(){
        return menuBar;
    }

    public void test(){
        menuBar.add(new JMenu("FAC"));
    }
}
