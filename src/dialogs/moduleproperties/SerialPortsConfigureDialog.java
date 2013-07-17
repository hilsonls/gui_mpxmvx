
package dialogs.moduleproperties;

import bean.Port;
import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.components.JPanelBGGradient;
import gui.style.StyleInterface;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author antonio
 */
public class SerialPortsConfigureDialog extends  JDialog{

    private SerialPortsConfigurePanel configPanel;
    private int idModulo;
    private Port port;

    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;

    private ProtocolsSerialPanel pannelloPadre;

    public SerialPortsConfigureDialog(Frame frame, int idModulo, Port port, ProtocolsSerialPanel pannelloPadre) throws MVException {

        super(frame, true);
        setTitle("Serial Port Configuration");
        setResizable(false);
        setDefaultCloseOperation(2);
        setLocation(100, 100);
        setSize(330, 300);

        this.idModulo = idModulo;
        this.port = port;
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
        cancelButton.addActionListener(buttonActionListener);
        cancelButton.setPreferredSize(new Dimension(100, 25));
        buttonsPanel.add(cancelButton);
        getContentPane().add(buttonsPanel, "South");

        configPanel  = new SerialPortsConfigurePanel(port);
        getContentPane().add(configPanel, "Center");
    }

    private class ButtonActionListener implements ActionListener{

        public void actionPerformed(ActionEvent actionevent){
            Object obj = actionevent.getSource();
            if(obj == okButton){
                okAction();
            }
            else if(obj == cancelButton)
                cancelAction();
        }
    }

    private void okAction() {
        try {
            configPanel.save();
            CtrlWorkspace.getInstance().savePortToMV(idModulo, port);
            pannelloPadre.reloadList();
            dispose();
        } catch (MVException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelAction(){
        dispose();
    }
}
