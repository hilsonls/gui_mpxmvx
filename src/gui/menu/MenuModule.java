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
public class MenuModule{

    private static MenuModule instance = null;
    private JMenu menuInstance = null;
    
    private JCheckBoxMenuItem autoUpdateItem;
    private JMenuItemBGGradient updateLayoutItem;
    private JMenuItemBGGradient getLayoutItem;
    private JSeparator moduleSeparator1;
    private JMenuItemBGGradient setupModuleItem;
    private JMenuItemBGGradient setupSourceItem;
    private JMenuItemBGGradient setupExternalAudioSourceItem;
    private JMenuItemBGGradient audioSetupItem;
    private JSeparator moduleSeparator2;
    private JMenuItemBGGradient setupRemotesItem;
    private JMenuItemBGGradient setTimeItem;
    private JSeparator moduleSeparator3;
    private JMenuItemBGGradient haltModuleItem;
    private JMenuItemBGGradient rebootModuleItem;
    private JMenuItemBGGradient resetModuleItem;

    //pattern Singleton
    public static MenuModule getInstance() {
      if(instance == null) {
         instance = new MenuModule();
      }
      return instance;
    }

    public JMenu getMenu(){
        return menuInstance;
    }

    private MenuModule (){


        menuInstance = new JMenuBGGradient();
        constructItemMenu();
        setText();
        setIcon();
        setActionCommand();
        setActionListener();
        addMenuItems();
        //Finezze
        autoUpdateItem.setOpaque(false);



    }

    private void setText(){

        menuInstance.setText("Module");
        autoUpdateItem.setText("Auto update");
        updateLayoutItem.setText("Update layout");
        getLayoutItem.setText("Get layout");
        haltModuleItem.setText("Halt module");
        rebootModuleItem.setText("Reboot module");
        resetModuleItem.setText("Reset module");
        setupModuleItem.setText("Setup module");
        setupRemotesItem.setText("Setup remotes");
        setTimeItem.setText("Set Time");
        setupSourceItem.setText("Setup selected video source");
        setupExternalAudioSourceItem.setText("Setup external audio sources");
        audioSetupItem.setText("Setup audio meter properties");

    }

    private void setActionCommand() {
        autoUpdateItem.setActionCommand("Auto");
        updateLayoutItem.setActionCommand("Update");
        getLayoutItem.setActionCommand("Get");
        haltModuleItem.setActionCommand("Halt");
        rebootModuleItem.setActionCommand("Reboot");
        resetModuleItem.setActionCommand("Reset");
        setupModuleItem.setActionCommand("Module");
        setupRemotesItem.setActionCommand("Remote");
        setTimeItem.setActionCommand("Time");
        setupSourceItem.setActionCommand("Source");
        setupExternalAudioSourceItem.setActionCommand("ExternalAudioSources");
        audioSetupItem.setActionCommand("AudioSetup");
    }

    private void setIcon() {
        GUIUtils utils = GUIUtils.getInstance();

        autoUpdateItem.setIcon(utils.getIcon("auto.gif"));
        updateLayoutItem.setIcon(utils.getIcon("update.gif"));
        getLayoutItem.setIcon(utils.getIcon("get.gif"));
        setupModuleItem.setIcon(utils.getIcon("setup-module.gif"));
        setupRemotesItem.setIcon(utils.getIcon("empty.gif"));
        setTimeItem.setIcon(utils.getIcon("empty.gif"));
        setupSourceItem.setIcon(utils.getIcon("setup-source.gif"));
        setupExternalAudioSourceItem.setIcon(utils.getIcon("setup-source.gif"));
        audioSetupItem.setIcon(utils.getIcon("empty.gif"));
    }

    private void setActionListener() {
        MyMenuActionListener listener = MyMenuActionListener.getInstance();

        autoUpdateItem.addActionListener(listener);
        updateLayoutItem.addActionListener(listener);
        getLayoutItem.addActionListener(listener);
        haltModuleItem.addActionListener(listener);
        rebootModuleItem.addActionListener(listener);
        resetModuleItem.addActionListener(listener);
        setupModuleItem.addActionListener(listener);
        setupRemotesItem.addActionListener(listener);
        setTimeItem.addActionListener(listener);
        setupSourceItem.addActionListener(listener);
        setupExternalAudioSourceItem.addActionListener(listener);
        audioSetupItem.addActionListener(listener);
    }

    private void constructItemMenu() {

        autoUpdateItem = new JCheckBoxMenuItem();
        updateLayoutItem = new JMenuItemBGGradient();
        getLayoutItem = new JMenuItemBGGradient();
        moduleSeparator1 = new JSeparator();
        setupModuleItem = new JMenuItemBGGradient();
        setupSourceItem = new JMenuItemBGGradient();
        setupExternalAudioSourceItem = new JMenuItemBGGradient();
        moduleSeparator2 = new JSeparator();
        setupRemotesItem = new JMenuItemBGGradient();
        setTimeItem = new JMenuItemBGGradient();
        moduleSeparator3 = new JSeparator();
        haltModuleItem = new JMenuItemBGGradient();
        rebootModuleItem = new JMenuItemBGGradient();
        resetModuleItem = new JMenuItemBGGradient();
        audioSetupItem = new JMenuItemBGGradient();

    }

    private void addMenuItems() {
        menuInstance.add(autoUpdateItem);
        menuInstance.add(updateLayoutItem);
        menuInstance.add(getLayoutItem);
        menuInstance.add(moduleSeparator1);
        menuInstance.add(setupModuleItem);
        menuInstance.add(setupSourceItem);
        menuInstance.add(setupExternalAudioSourceItem);
        menuInstance.add(audioSetupItem);
        menuInstance.add(moduleSeparator2);
        menuInstance.add(setupRemotesItem);
        menuInstance.add(setTimeItem);
        menuInstance.add(moduleSeparator3);
        menuInstance.add(haltModuleItem);
        menuInstance.add(rebootModuleItem);
        menuInstance.add(resetModuleItem);
    }

    public void updateMenu(){
        autoUpdateItem.setSelected(CtrlActions.getInstance().isAutoUpdate());
    }
   
}
