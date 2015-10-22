package dialogs.about;

/**
 *
 * @author Marco Ricci & Antonio Poggi
 */

import eccezioni.MVException;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author panda
 */
public class AboutDialog extends JDialog {
    
    private AboutPanel aboutPanel;
    
    private JPanel buttonsPanel;
    
    private JButton okButton;
   
    private int idModulo;
    
    
    public AboutDialog(Frame frame, int idModulo) throws MVException {
        super(frame);
        
        //memorizzo l'id del modulo;
        this.idModulo = idModulo;
        
         
        setTitle("About");
        setResizable(true);
        setModal(true);
        setDefaultCloseOperation(2);
        setLocation(100, 100);
        setSize(330, 400);
        
        ButtonActionListener buttonActionListener = new ButtonActionListener();
        
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(1, 10, 10));
        buttonsPanel.setPreferredSize(new Dimension(40, 40));
        okButton = new JButton();
        okButton.setText("OK");
        okButton.setActionCommand("OK");
        okButton.addActionListener(buttonActionListener);
        okButton.setPreferredSize(new Dimension(100, 25));
        this.getRootPane().setDefaultButton(okButton);
        buttonsPanel.add(okButton);
        
        getContentPane().add(buttonsPanel, "South");
        
        aboutPanel = new AboutPanel(idModulo);
                
        getContentPane().add(aboutPanel, "Center");
        setVisible(true);
    } 
    
    private class ButtonActionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent actionevent){
            Object obj = actionevent.getSource();
            if(obj == okButton)
                okAction();
        }
    }
    
    private void okAction() {
        
                 
            dispose();
                 
           
    }
    

}