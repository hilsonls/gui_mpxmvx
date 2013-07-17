/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllori;

import eccezioni.MVException;
import gui.MultiViewerBCS;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antonio
 */
public class testCastor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            MultiViewerBCS.root = new URL("http://151.32.140.133:8080/");

            CtrlProtocol controllore = CtrlProtocol.getInstance();
            controllore.loadConfigurationFromMV();
        } catch (MVException ex) {
            Logger.getLogger(testCastor.class.getName()).log(Level.SEVERE, null, ex);

        } catch (MalformedURLException ex) {
            Logger.getLogger(testCastor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
