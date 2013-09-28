package dialogs.moduleproperties;

import bean.SnellController;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutFocusTraversalPolicy;

/**
*
* @author Michael Gardiner
*/
public class SnellControllerEditDialog extends JDialog {

    private SnellControllerEditPanel snellControllerEditPanel;
    private int idModulo;
    private SnellController snellController;
    
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;  

    private boolean editCase;
    private ProtocolsSnellPanel parentPanel;

    public SnellControllerEditDialog(Frame frame, int idModulo, SnellController snellController, boolean edit, ProtocolsSnellPanel parentPanel) {
        super(frame, true);
        setTitle("Snell Controller Configuration");
        setResizable(false);
        setLocation(100, 100);
        
        editCase = edit;
        this.idModulo = idModulo;
        this.snellController = snellController;
        this.parentPanel = parentPanel;
        
        ButtonActionListener buttonActionListener = new ButtonActionListener();
        
        buttonsPanel = new JPanelBGGradient(StyleInterface.getInstance().getButtonPanelBackgroundTopColor(), StyleInterface.getInstance().getButtonPanelBackgroundBottomColor(),true);
        buttonsPanel.setLayout(new FlowLayout(1, 10, 10));
        buttonsPanel.setPreferredSize(new Dimension(40, 40));
        okButton = new JButton();
        okButton.setText("OK");
        okButton.setActionCommand("OK");
        okButton.addActionListener(buttonActionListener);
        okButton.setPreferredSize(new Dimension(100, 25));
        this.getRootPane().setDefaultButton(okButton);
        buttonsPanel.add(okButton);
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        cancelButton.setActionCommand("Cancel");
        cancelButton.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                
            }

            public void mousePressed(MouseEvent e) {
                cancelAction();
            }

            public void mouseReleased(MouseEvent e) {
                
            }

            public void mouseEntered(MouseEvent e) {
                
            }

            public void mouseExited(MouseEvent e) {
                
            }
        });
        
        //Handle window closing correctly.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                cancelAction();
            }
        });

        snellControllerEditPanel = new SnellControllerEditPanel(snellController);
        
        Rectangle rb = snellControllerEditPanel.getBounds();
        Insets frameInsets = frame.getInsets();
        setSize(frameInsets.left + frameInsets.right + rb.x + rb.width,
                frameInsets.top + frameInsets.bottom + rb.y + rb.height + buttonsPanel.getHeight());
        setPreferredSize(new Dimension(getSize().width, getSize().height));

        //cancelButton.addActionListener(buttonActionListener);
        cancelButton.setPreferredSize(new Dimension(100, 25));
        buttonsPanel.add(cancelButton);
        getContentPane().add(buttonsPanel, "South");
        
        getContentPane().add(snellControllerEditPanel, "Center");
        this.setFocusTraversalPolicy(new BackwardTraversalPolicy());
        setVisible(true);
    } 

    private class ButtonActionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent actionevent){
            Object obj = actionevent.getSource();
            if(obj == okButton){
            	okAction();
            }
        }
    }

    private void okAction() {
        try {
            verifyName(snellControllerEditPanel.getNameField().getText());
            snellControllerEditPanel.save();
            CtrlWorkspace.getInstance().saveSnellControllerToMV(idModulo, snellController);
            parentPanel.reloadControllerList();
            dispose(); 
        } catch (MVException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }   
    }

    private void cancelAction(){
        if(!editCase){
            try {
                CtrlWorkspace.getInstance().removeSnellController(idModulo, snellController.getId());
                parentPanel.reloadControllerList();
            } catch (MVException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
            
        dispose();
    }

    /**
     * Verify that the name is valid and not a duplicate of another controller
     * @param name  proposed name of the controller
     * @throws MVException if name is not valid
     */
    private void verifyName(final String name) throws MVException {
        parentPanel.verifyControllerName(name);
    }

    private class BackwardTraversalPolicy extends LayoutFocusTraversalPolicy {

        
        

        @Override
        public Component getInitialComponent(Window window) {
            return snellControllerEditPanel.getNameField();
        }

        @Override
        public Component getInitialComponent(JInternalFrame frame) {
            return snellControllerEditPanel.getNameField();
        }

        
    }
    
}
