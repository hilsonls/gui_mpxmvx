/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import controllori.CtrlWorkspace;
import dialogs.editobject.EditObjectDialog;
import dialogs.source.SourcePropertiesDialog;
import gui.MultiViewerBCS;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Antonio
 */
public class testDialog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      
            MultiViewerBCS.root = new URL("http://localhost/");
            CtrlWorkspace ctrlWorkspace = CtrlWorkspace.getInstance();
            JFrame jframe = new JFrame();
            jframe.setDefaultCloseOperation(3);
            //jframe.add(new AudioPanel(ctrlWorkspace.getSource(0, 0)));
            //new EditObjectDialog(jframe,ctrlWorkspace.getObjects(0).getOggetto(0));
            new SourcePropertiesDialog(jframe,ctrlWorkspace.getSource(0, 1),0);
            jframe.setBounds(100, 100, 500, 600);
            jframe.repaint();
            jframe.setEnabled(true);
            jframe.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
