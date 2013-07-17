package gui.utils;

import gui.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MyButtonActionListener implements ActionListener {

    private static MyButtonActionListener instance = null;

    //pattern Singleton
    public static MyButtonActionListener getInstance() {
      if(instance == null) {
         instance = new MyButtonActionListener();
      }
      return instance;
    }

    public void actionPerformed(ActionEvent actionevent) {
        JButton jbutton = (JButton) actionevent.getSource();
        CtrlActions.getInstance().processAction(jbutton.getActionCommand());
    }
    

    private MyButtonActionListener() {
        super();
    
    }
}
