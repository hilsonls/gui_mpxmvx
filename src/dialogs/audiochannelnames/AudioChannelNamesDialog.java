package dialogs.audiochannelnames;

/**
 *
 * @author michael
 */

import eccezioni.MVException;
import gui.components.ChangeListenerColorHandled;
import gui.components.JDioTabbedPane;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import bean.AudioLabels;
import controllori.CtrlProtocol;

/**
 *
 * @author michael
 */
public class AudioChannelNamesDialog extends JDialog {
    
    private JTabbedPane tabbedPane;
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton cancelButton;
    
    private AudioLabels audioLabels;
    
    private AudioChannelNamesPanel channelNamesPanel[];
    
    private int idModulo;
    
    public AudioChannelNamesDialog(Frame frame, int idModulo) throws MVException {
        super(frame);
        
        //memorizzo l'id del modulo;
        this.idModulo = idModulo;
         
        setTitle("Audio Channel Names");
        setResizable(true);
        setModal(true);
        setDefaultCloseOperation(2);

        // Locate the dialog where the mouse is
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration());
        screenSize.width -= insets.right;
        screenSize.height -= insets.bottom;
        Dimension size = new Dimension(600, 600);
        Point location = MouseInfo.getPointerInfo().getLocation();
        if (location.x + size.width > screenSize.width) {
            location.x = screenSize.width - size.width;
        }
        if (location.y + size.height > screenSize.height) {
            location.y = screenSize.height - size.height;
            if (location.y < insets.top) {
                size.height += location.y;
                size.height -= insets.top;
                location.y = insets.top;
            }
        }
        setLocation(location);
        setSize(size);
        
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
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        cancelButton.setActionCommand("Cancel");
        cancelButton.addActionListener(buttonActionListener);
        cancelButton.setPreferredSize(new Dimension(100, 25));
        buttonsPanel.add(cancelButton);
        getContentPane().add(buttonsPanel, "South");
        
        audioLabels = CtrlProtocol.getInstance().queryAudioLabels(idModulo);
        
        int numGroups = audioLabels.getAudioLabelGroupCount();
        if (numGroups > 0) {
            channelNamesPanel = new AudioChannelNamesPanel[numGroups];
            tabbedPane = new JDioTabbedPane(true);
            tabbedPane.addChangeListener(new ChangeListenerColorHandled());
            for (int i = 0; i < numGroups; i++) {
                channelNamesPanel[i] = new AudioChannelNamesPanel(audioLabels.getAudioLabelGroup(i));
                tabbedPane.add(channelNamesPanel[i]);
                tabbedPane.setTitleAt(i, audioLabels.getAudioLabelGroup(i).getName());
            }
            tabbedPane.setSelectedComponent(channelNamesPanel[0]);
            getContentPane().add(tabbedPane, "Center");
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No channels available to label",
                    "Audio channel names", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
        
    } 
    
    private class ButtonActionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent actionevent){
            Object obj = actionevent.getSource();
            if(obj == okButton)
                okAction();
            else if (obj == cancelButton)
                cancelAction();
        }
    }
    
    private void okAction() {
        try {
            for (int i = 0; i < channelNamesPanel.length; i++)
                channelNamesPanel[i].save();
            CtrlProtocol.getInstance().saveAudioLabelsToMV(idModulo, audioLabels);
            dispose();
        } catch (MVException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelAction(){
        dispose();
    }
}