package gui.menu;

import gui.CtrlActions;
import gui.components.JMenuBGGradient;
import gui.components.JMenuItemBGGradient;
import gui.utils.GUIUtils;
import gui.utils.MyMenuActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

/**
 *
 * @author Antonio  Knight
 */
public class MenuGrid{

    private static MenuGrid instance = null;
    private JMenu menuInstance = null;

    private JCheckBoxMenuItem fixedMovementItem;
    private JSeparator gridSeparator;
    private JRadioButtonMenuItem grid3Item;
    private JRadioButtonMenuItem grid4Item;
    private JRadioButtonMenuItem grid5Item;
    private JRadioButtonMenuItem grid6Item;

    //pattern Singleton
    public static MenuGrid getInstance() {
      if(instance == null) {
         instance = new MenuGrid();
      }
      return instance;
    }

    public JMenu getMenu(){
        return menuInstance;
    }

    private MenuGrid (){


        menuInstance = new JMenuBGGradient();
        constructItemMenu();
        setText();
        setIcon();
        setActionCommand();
        setActionListener();
        addMenuItems();
        //Finezze
        fixedMovementItem.setOpaque(false);
        grid3Item.setOpaque(false);
        grid4Item.setOpaque(false);
        grid5Item.setOpaque(false);
        grid6Item.setOpaque(false);

        ButtonGroup buttonGroupGrid = new ButtonGroup();
        buttonGroupGrid.add(grid3Item);
        buttonGroupGrid.add(grid4Item);
        buttonGroupGrid.add(grid5Item);
        buttonGroupGrid.add(grid6Item);
        grid4Item.setSelected(true);

    }

    private void setText(){

        menuInstance.setText("Grid");
        fixedMovementItem.setText("Snap to Grid");
        grid3Item.setText("3 x 3 grid");
        grid4Item.setText("4 x 4 grid");
        grid5Item.setText("5 x 5 grid");
        grid6Item.setText("6 x 6 grid");

    }

    private void setActionCommand() {
        fixedMovementItem.setActionCommand("Fix");
        grid3Item.setActionCommand("3x3");
        grid4Item.setActionCommand("4x4");
        grid5Item.setActionCommand("5x5");
        grid6Item.setActionCommand("6x6");
    }

    private void setIcon() {
        GUIUtils utils = GUIUtils.getInstance();

        fixedMovementItem.setIcon(utils.getIcon("fix.gif"));
        grid3Item.setIcon(utils.getIcon("empty24.gif"));
        grid4Item.setIcon(utils.getIcon("empty24.gif"));
        grid5Item.setIcon(utils.getIcon("empty24.gif"));
        grid6Item.setIcon(utils.getIcon("empty24.gif"));
    }

    private void setActionListener() {
        MyMenuActionListener listener = MyMenuActionListener.getInstance();

        fixedMovementItem.addActionListener(listener);
        grid3Item.addActionListener(listener);
        grid4Item.addActionListener(listener);
        grid5Item.addActionListener(listener);
        grid6Item.addActionListener(listener);
    }

    private void constructItemMenu() {

        fixedMovementItem = new JCheckBoxMenuItem();
        gridSeparator = new JSeparator();
        grid3Item = new JRadioButtonMenuItem();
        grid4Item = new JRadioButtonMenuItem();
        grid5Item = new JRadioButtonMenuItem();
        grid6Item = new JRadioButtonMenuItem();

    }

    private void addMenuItems() {
        menuInstance.add(fixedMovementItem);
        menuInstance.add(gridSeparator);
        menuInstance.add(grid3Item);
        menuInstance.add(grid4Item);
        menuInstance.add(grid5Item);
        menuInstance.add(grid6Item);
    }

    public void updateMenu(){
        fixedMovementItem.setSelected(CtrlActions.getInstance().getTilesWorkspace().isSnapToGrid());
    }


    public void switchGrid(int gridSize) {
        switch (gridSize) {
                case 3 : grid3Item.setSelected(true); break;
                case 4 : grid4Item.setSelected(true); break;
                case 5 : grid5Item.setSelected(true); break;
                case 6 : grid6Item.setSelected(true); break;
        }
    }
   
}
