package gui.utils;

import gui.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class MyMenuActionListener implements ActionListener {

    private static MyMenuActionListener instance = null;

    //pattern Singleton
    public static MyMenuActionListener getInstance() {
      if(instance == null) {
         instance = new MyMenuActionListener();
      }
      return instance;
    }

    public void actionPerformed(ActionEvent actionevent) {
        JMenuItem menuItem = (JMenuItem) actionevent.getSource();
        CtrlActions.getInstance().processAction(menuItem.getActionCommand());
    }
    
    private MyMenuActionListener() {
        super();
    }

    
}
