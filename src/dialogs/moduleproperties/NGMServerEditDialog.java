package dialogs.moduleproperties;

import bean.NgmServer;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutFocusTraversalPolicy;

/**
 *
 * @author Marco Ricci & Antonio Poggi
 */
public class NGMServerEditDialog extends JDialog {
    
    private NGMServerEditPanel ngmServerEditPanel;
    private int idModulo;
    private NgmServer ngmServer;
    
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;  
    
    private boolean editCase;
    private Ngm164ServerPanel pannelloPadre;
    
    public NGMServerEditDialog(Frame frame, int idModulo, NgmServer ngmServer, boolean edit, Ngm164ServerPanel pannelloPadre) {
        super(frame, true);
        setTitle(StyleInterface.getInstance().getDataXXNgm()+" Server Configuration");
        setResizable(false);
        setDefaultCloseOperation(0);
        setLocation(100, 100);
        setSize(380, 260);
        setPreferredSize(new Dimension(380, 260));
        
        editCase = edit;
        this.idModulo = idModulo;
        this.ngmServer = ngmServer;
        //ACCROCCO PER NON SCRIVERE UN FOCUS LISTENER DATA LA MIA DEPRESSIONE TOTALE DEL MOMENTO
        this.pannelloPadre = pannelloPadre;
        
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
        //cancelButton.addActionListener(buttonActionListener);
        cancelButton.setPreferredSize(new Dimension(100, 25));
        buttonsPanel.add(cancelButton);
        getContentPane().add(buttonsPanel, "South");
        
        ngmServerEditPanel = new NGMServerEditPanel(ngmServer);
        getContentPane().add(ngmServerEditPanel, "Center");
        //ngmServerEditPanel.getAliasField().setFocusable(true);
        //ngmServerEditPanel.getIpAddrField().requestFocusInWindow
        this.setFocusTraversalPolicy(new BackwardTraversalPolicy());
        setVisible(true);
        
        
    } 
    
    private class ButtonActionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent actionevent){
            Object obj = actionevent.getSource();
            if(obj == okButton){
                //ngmServerEditPanel.verifyFields();
                //if (okButton.hasFocus())
                 //   ngmServerEditPanel.verifyFields();
                        //if (okButton.hasFocus())
                            okAction();
            }
            //else if(obj == cancelButton)
            //    cancelAction();
        }
    }
    
    private void okAction() {
        try {
            ngmServerEditPanel.save();
            CtrlWorkspace.getInstance().saveNgm164ServerToMV(idModulo, ngmServer);
            pannelloPadre.reloadList();
            dispose(); 
        } catch (MVException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    private void cancelAction(){
        if(!editCase){
            try {
                CtrlWorkspace.getInstance().removeNgm164Server(idModulo, ngmServer.getId());
                pannelloPadre.reloadList();
            } catch (MVException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
            
        dispose();
    }
    
    private class BackwardTraversalPolicy extends LayoutFocusTraversalPolicy {

        
        

        @Override
        public Component getInitialComponent(Window window) {
            return ngmServerEditPanel.getIpAddrField();
        }

        @Override
        public Component getInitialComponent(JInternalFrame frame) {
            return ngmServerEditPanel.getIpAddrField();
        }

        
    }
}