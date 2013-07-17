

package dialogs.about;

import bean.OptionsList;
import controllori.CtrlProtocol;
import eccezioni.MVException;
import gui.MultiViewerBCS;
import java.awt.Component;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;


public class AboutPanel extends JPanel{
        
        private JList infoTable;
        
        
    class AlarmPanelCellRenderer
        extends DefaultListCellRenderer
    {

        @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	return super.getListCellRendererComponent(list, value, index, false, false);
}
  
    }    
    
    public AboutPanel(int idModulo) throws MVException {
        //setto dimensione panel
        setLayout(null);
        setBounds(1, 30, 400, 400);
        
        OptionsList optionsList = CtrlProtocol.getInstance().queryOptionName("about", false);
        int count = optionsList.getNameCount();
        Vector<String> listaValori = new Vector(count+1);
        //listaValori.add("BCS Applet Version 1.1");
        listaValori.add("BCS Applet Version "+MultiViewerBCS.class.getPackage().getImplementationVersion());
        for(int i=0; i<count; i++){
           String opzione = optionsList.getName(i).getVal();
           listaValori.add(opzione);
        }
        
        

        
        infoTable = new JList(listaValori);
        infoTable.setBounds(0,0,300,300);
        infoTable.setFixedCellHeight(12);
        //oggetti interfaccia utente
        JScrollPane scroll  = new JScrollPane(infoTable);
        scroll = new JScrollPane();
        scroll.setOpaque(true);
        add(scroll);
        scroll.setBounds(10, 10, 300, 300);
        
       
        infoTable.setBorder((BevelBorder)BorderFactory.createBevelBorder(0));
        scroll.getViewport().add(infoTable);
        infoTable.setBounds(0, 0, 300, 300);
        infoTable.setCellRenderer(new AlarmPanelCellRenderer());
        
        add(scroll);


    }
}
