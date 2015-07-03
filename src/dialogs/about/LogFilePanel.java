

package dialogs.about;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import eccezioni.MVException;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;
import bean.LogFile;

public class LogFilePanel extends JPanelBGGradient{
    
    private JTextArea textBox;
    private JScrollPane textScroll;

    public LogFilePanel(LogFile logFile) throws MVException {
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        
        textBox = new JTextArea(logFile.getLogContent());
        textScroll = new JScrollPane(textBox);
        textScroll.setOpaque(true);
        
        layout.add(textScroll);
    }
}
