package dialogs.about;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import bean.LogFiles;
import controllori.CtrlProtocol;

/**
 *
 * @author michael
 */
public class LogFilesDialog extends JDialog {
    
    private JTabbedPane tabbedPane;
    private LogFilePanel logFilePanel[];
    private JPanel buttonsPanel;
    private JButton okButton;
    private JButton saveButton;
    private LogFiles logFiles;
    
    private int idModulo;
    
    public LogFilesDialog(Frame frame, int idModulo) throws MVException {
        super(frame);
        
        //memorizzo l'id del modulo;
        this.idModulo = idModulo;
         
        setTitle("Logging");
        setResizable(true);
        setModal(true);
        setDefaultCloseOperation(2);
        setLocation(100, 100);
        setSize(700, 700);
        
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
        saveButton = new JButton();
        saveButton.setText("Save All");
        saveButton.addActionListener(buttonActionListener);
        saveButton.setPreferredSize(new Dimension(100, 25));
        buttonsPanel.add(saveButton);
        
        getContentPane().add(buttonsPanel, "South");
        
        logFiles = CtrlProtocol.getInstance().queryLogFiles(0);
        
        if (logFiles.getLogFileCount() != 0) {
            logFilePanel = new LogFilePanel[logFiles.getLogFileCount()];
            tabbedPane = new JDioTabbedPane(true);
            tabbedPane.addChangeListener(new ChangeListenerColorHandled());
            for (int i = 0; i < logFiles.getLogFileCount(); i++) {
                logFilePanel[i] = new LogFilePanel(logFiles.getLogFile(i));
                tabbedPane.add(logFilePanel[i]);
                tabbedPane.setTitleAt(i, logFiles.getLogFile(i).getName());
            }
            tabbedPane.setSelectedComponent(logFilePanel[0]);
            getContentPane().add(tabbedPane, "Center");
        }
        
        setVisible(true);
    } 
    
    private class ButtonActionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent actionevent){
            Object obj = actionevent.getSource();
            if(obj == okButton)
                okAction();
            else if (obj == saveButton)
                saveLogsAction();
        }
    }
    
    private void okAction() {
            dispose();
    }

    private void saveLogsAction() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Log files", "log");
        fileChooser.setFileFilter(filter);
        fileChooser.setSelectedFile(new File("mv.log"));
        int res = fileChooser.showSaveDialog(null);
        
        if (res == JFileChooser.APPROVE_OPTION) {
            try {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                if (!file.exists())
                    file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i = 0; i < logFiles.getLogFileCount(); i++) {
                    bw.write("Log: " + logFiles.getLogFile(i).getName() + "\n");
                    bw.write(logFiles.getLogFile(i).getLogContent());
                }
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}