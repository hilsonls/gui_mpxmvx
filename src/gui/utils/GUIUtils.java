package gui.utils;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author antonio
 */
public class GUIUtils {

    private static String path = "icons\\";

    private static GUIUtils instance = null;

    //pattern Singleton
    public static GUIUtils getInstance() {
      if(instance == null) {
         instance = new GUIUtils();
      }
      return instance;
    }

    private GUIUtils(){
    }

    //TODO: VERIFICARE METODO
    public ImageIcon getIcon(String iconName)
    {
        ImageIcon imageicon = null;
        try
        {
            String icon = path + iconName;
            URL url = getClass().getResource("/icons/" + iconName);
            if(url != null)
                imageicon = new ImageIcon(url);
            else if(icon.startsWith("file:///"))
                imageicon = new ImageIcon(icon.substring(8));
            else if(icon.startsWith("http://"))
                imageicon = new ImageIcon(new URL(icon));
            else imageicon = new ImageIcon(icon);
        }
        catch(Exception ex)
        {
            imageicon = new ImageIcon();
        }
        return imageicon;
    }
}
