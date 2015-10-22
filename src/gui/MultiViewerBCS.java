package gui;

import gui.components.JSplashFrame;
import controllori.CtrlWorkspace;
import controllori.MultiviewerEventQueue;
import gui.menu.MenuBarGUIGenerator;
import gui.style.StyleInterface;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * Main class
 *
 * @author antonio
 */
public class MultiViewerBCS {

    public static void main(String args[]) {
        try {
            root = new URL("http://" + args[0] + "/");
        } catch (MalformedURLException ex) {
            System.out.print("WRONG IP... RETRY");
            System.exit(-1);
        }

        Font font = new Font("Lucida", Font.BOLD, 14);
        URL splashURL1;
        URL splashURL2;

        try {
            splashURL1 = new URL(root.toString() + "splash.png");

        } catch (MalformedURLException ex) {
            System.out.println("Splash icon: malformed URL");
            splashURL1 = null;
        }

        try {
            splashURL2 = new URL(root.toString() + "splash.jpg");

        } catch (MalformedURLException ex) {
            System.out.println("Splash icon: malformed URL");
            splashURL2 = null;
        }
        JFrame splash = JSplashFrame.getJSplashFrame(null, font, splashURL1, splashURL2);

        if (CtrlWorkspace.getInstance() == null) {
            System.out.print("Unable to connect to server; Second retry\n");
            if (CtrlWorkspace.getInstance() == null) {
                System.out.print("Unable to connect to server. Application will exit");
                System.exit(-1);
            }
        }

        //splash.setVisible(false);
        //splash.dispose();

        uiManager();

        JFrame mainFrame = new JFrame();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration());
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setDefaultCloseOperation(3);
        mainFrame.setLocation(insets.left, insets.top);
        mainFrame.setSize(new Dimension(dimension.width - (insets.left + insets.right), dimension.height - (insets.top + insets.bottom)));


        mainFrame.setTitle(StyleInterface.getInstance().getFrameTitle());

        //E' un po' loffio.
        MultiviewerEventQueue.getInstance();

        MultiViewerPanel.getInstance().createGUI(mainFrame.getContentPane());
        mainFrame.setJMenuBar((JMenuBar) MenuBarGUIGenerator.getInstance().getMenuBar());
        mainFrame.repaint();
        mainFrame.getJMenuBar().setEnabled(true);
        mainFrame.getJMenuBar().setVisible(true);
        mainFrame.setIconImage(StyleInterface.getInstance().getFavIcon().getImage());


        mainFrame.setEnabled(true);
        mainFrame.setVisible(true);
        splash.setVisible(false);
        splash.dispose();

        CtrlActions.getInstance().getTilesWorkspace().requestFocusInWindow();

    }

    public static void uiManager() {

        UIManager.put("ToolTip.background", new Color(193, 193, 193));
        UIManager.put("ToolTip.foreground", Color.black);
        //UIManager.put ("TabbedPane.tabsOpaque",	false);
        Border border = BorderFactory.createLineBorder(new Color(124, 124, 124));
        UIManager.put("ToolTip.border", border);
        UIManager.put("TabbedPane.background", StyleInterface.getInstance().getTabbedPaneBackgroundColor());
        UIManager.put("TabbedPane.contentAreaColor", StyleInterface.getInstance().getTabbedPaneContentAreaColor());
        UIManager.put("TabbedPane.selected", StyleInterface.getInstance().getTabbedPaneSelectedColor());
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(1, 1, 1, 1));
        UIManager.put("TabbedPane.darkShadow", StyleInterface.getInstance().getTabbedPaneDarkShadowColor());
        UIManager.put("TabbedPane.focus", StyleInterface.getInstance().getTabbedPaneFocusColor());
        UIManager.put("TabbedPane.foreground", StyleInterface.getInstance().getTabbedPaneForegroundColor());
        //UIManager.put("TabbedPane.selectedForeground",  new Color(51, 51, 51));
        //UIManager.put("TabbedPane.unselectedForeground",  new Color(255, 0, 0));
        //UIManager.put("TabbedPane.unselectedTabBackground",  new Color(255, 51, 51));
        UIManager.put("TabbedPane.borderHighlightColor", StyleInterface.getInstance().getTabbedPaneBorderHighLightColor());
        //UIManager.put("TabbedPane.borderHightlightColor",  new Color(253, 253, 253));
        UIManager.put("TabbedPane.highlight", StyleInterface.getInstance().getTabbedPaneHighlightColor());

        UIManager.put("ToggleButton.background", new Color(153, 153, 153));

        Font font = new Font("Arial", Font.BOLD, 11);
        UIManager.put("RadioButtonMenuItem.font", font);
        UIManager.put("CheckBoxMenuItem.font", font);
        UIManager.put("PasswordField.font", font);
        UIManager.put("Button.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("TabbedPane.font", font);
        UIManager.put("Menu.font", font);
        UIManager.put("CheckBox.font", font);
        UIManager.put("Tree.font", font);
        UIManager.put("RadioButton.font", font);
        UIManager.put("List.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("TextPane.font", font);
        UIManager.put("MenuItem.font", font);
        UIManager.put("Label.font", font);
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception exception) {
            font = new Font("Arial", Font.BOLD, 11);
            UIManager.put("RadioButtonMenuItem.font", font);
            UIManager.put("CheckBoxMenuItem.font", font);
            UIManager.put("PasswordField.font", font);
            UIManager.put("Button.font", font);
            UIManager.put("TextField.font", font);
            UIManager.put("TextArea.font", font);
            UIManager.put("TabbedPane.font", font);
            UIManager.put("Menu.font", font);
            UIManager.put("CheckBox.font", font);
            UIManager.put("Tree.font", font);
            UIManager.put("RadioButton.font", font);
            UIManager.put("List.font", font);
            UIManager.put("ComboBox.font", font);
            UIManager.put("TextPane.font", font);
            UIManager.put("MenuItem.font", font);
            UIManager.put("Label.font", font);
        }
    }

    public static URL getRoot() {
        return root;
    }
    public static URL root;
    MultiViewerPanel panel;
}
