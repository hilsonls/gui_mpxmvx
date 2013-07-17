package gui.style;

import controllori.CtrlWorkspace;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 * Classe astratta per gli stili / skin dell'applicazione
 * 
 * @author mosconi
 */
public abstract class StyleInterface {
    
    private static StyleInterface instance = null;
    private static String company;
        
    //pattern Singleton
    public static StyleInterface getInstance() {
      if(instance == null) {
         company = CtrlWorkspace.getInstance().getModule(0).getProduct().getCompany();
         
         if (getCompany().equalsIgnoreCase("Chromatec"))
             instance = new ChromatecStyle();
         else if (getCompany().equalsIgnoreCase("Barco"))
             instance = new BarcoStyle();
         else if (getCompany().equalsIgnoreCase("Sierra"))
             instance = new SierraVideoStyle();
         else if (getCompany().equalsIgnoreCase("Snell"))
             instance = new SnellStyle();
         
      }
      return instance;
    }

    /**
     * @return the company
     */
    public static String getCompany() {
        return company;
    }
    
    
    public abstract Color getTileForegroundColor();
    
    public abstract Color getTileBorderSelectedColor ();
    public abstract Color getTileBorderUnselectedColor ();
    
    public abstract Color getGridColor ();
    
    public abstract Color getWorkspaceBackgroundColor ();
    public abstract Color getWorkspaceSkyColor();
    
    public abstract Color getTreeBackgroundColor();
    
    public abstract Color getJMenuTopColor();
    public abstract Color getJMenuBottomColor();
    
    public abstract Color getTabbedPaneBackgroundColor();
    public abstract Color getTabbedPaneContentAreaColor();
    public abstract Color getTabbedPaneSelectedColor();
    public abstract Color getTabbedPaneDarkShadowColor();
    public abstract Color getTabbedPaneFocusColor();
    public abstract Color getTabbedPaneForegroundColor();
    public abstract Color getTabbedPaneSkyTopColor();
    public abstract Color getTabbedPaneSkyBottomColor();
    public abstract Color getTabbedPaneBorderHighLightColor();
    public abstract Color getTabbedPaneHighlightColor();
    
    public abstract Color getPropertiesTabbedPaneBackgroundColor();
    
    public abstract Color getPanelBackgroundTopColor();
    public abstract Color getPanelBackgroundBottomColor();
    
    public abstract Color getButtonPanelBackgroundTopColor();
    public abstract Color getButtonPanelBackgroundBottomColor();
       
    
    
   //titoli frame
    public abstract String getFrameTitle();
    
    public abstract String getDataXXNgm();
            
   //immagini bytearray
    public abstract ImageIcon getLogo();
    public abstract ImageIcon getFavIcon();

    public Color getTileBackgroundColor(String itemType) {
        return (bgColors.get(itemType)==null)?Color.BLACK:bgColors.get(itemType);
    }

    protected HashMap<String, Color> bgColors;
}
