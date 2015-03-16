package dialogs.router;

import bean.Router;

import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import eccezioni.MVException;

public class RouterDialog extends JDialog {

    static private RouterDialog modelessInstance;
    private RouterPanel routerPanel;
    
    static public RouterDialog OpenModeless(Frame frame, int idModulo, Router bean) throws MVException {
        if (modelessInstance != null) {
            modelessInstance.requestFocus();
            return modelessInstance;
        } else {
            return new RouterDialog(frame, idModulo, bean);
        }
    }
    
    private RouterDialog(Frame frame, int idModulo, Router bean) throws MVException {
        super(frame);
        modelessInstance = this;
        
        addWindowListener(new DWindowListener());
        
        setTitle(bean.getLabel());
        setResizable(true);
        setModal(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(100, 100);
        setSize(630, 580);
        
        routerPanel = new RouterPanel(bean, idModulo);
        getContentPane().add(routerPanel, "Center");
        
        setVisible(true);
    }

    private class DWindowListener extends WindowAdapter {

        @Override
        public void windowClosed(WindowEvent e) {
            modelessInstance = null;
        }
        
    }

}
