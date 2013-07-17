

package gui;


import bean.OptionsList;
import controllori.CtrlProtocol;
import eccezioni.MVException;
import gui.components.BoundedIntTextField;
import gui.components.DocumentSizeFilter;
import gui.components.JTippedComboBox;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author Maria
 */
public class ComponentFactory {
    
    //TIE
    /**
     * costruttore privato così marco non rompe il cazzo che questa classe non istanzia oggetti
     */
    private ComponentFactory(){
        
    }
    
    /**
     * 
     * @param optionName il nome della lista dei valori
     * @param val il valore da selezionare
     * @param useCache se utilizzare la cache
     * @return crea il combobox con la cache
     * @throws eccezioni.MVException
     */
    public static JComboBox createComboBox(String optionName, String val) throws MVException{
        return createComboBox(optionName, val, true);
    }
    
    /**
     * 
     * @param optionName il nome della lista dei valori
     * @param val il valore da selezionare
     * @return jComboBox il combobox
     */
    public static JComboBox createComboBox(String optionName, String val, boolean useCache) throws MVException{
        JTippedComboBox comboBonzo = null;
        OptionsList optionsList = null;
        
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        optionsList = ctrlProtocol.queryOptionName(optionName, useCache);
        //TODO se è null cojone...
        
        int count = optionsList.getNameCount();
        Vector<String> listaValori = new Vector(count);
        int index = -1;
        
        for(int i=0; i<count; i++){
           String opzione = optionsList.getName(i).getVal();
           if(opzione.equals(val))
               index = i;
           listaValori.add(opzione);
        }
          
        comboBonzo = new JTippedComboBox(listaValori);
        comboBonzo.setSelectedIndex(index);
        
        return comboBonzo;
    }
    
    public static JComboBox createComboBox(OptionsList optionsList, String val) {
        JTippedComboBox comboBonzo = null;
                
        int count = optionsList.getNameCount();
        Vector<String> listaValori = new Vector(count);
        int index = -1;
        
        for(int i=0; i<count; i++){
           String opzione = optionsList.getName(i).getVal();
           if(opzione.equals(val))
               index = i;
           listaValori.add(opzione);
        }
          
        comboBonzo = new JTippedComboBox(listaValori);
        comboBonzo.setSelectedIndex(index);
        
        return comboBonzo;
    }

    /**
     *
     * @param value
     * @param min
     * @param max
     * @return crea un combobox con valori  che vanno da min a max
     */
    public static JComboBox createComboBox(int val, int min, int max){

        return createComboBox(val, min, max, "");
    }

    public static JComboBox createComboBox(int val, int min, int max, String suffix){
        JTippedComboBox comboBonzo = null;

        int count = max - min + 1;
        Vector<String> listaValori = new Vector(count);
        int index = -1;

        for(int i=0; i<= max-min; i++){
           int opzione = min + i;
           if(opzione==val)
               index = i;
           listaValori.add(Integer.toString(opzione)+suffix);
        }

        comboBonzo = new JTippedComboBox(listaValori);
        comboBonzo.setSelectedIndex(index);

        return comboBonzo;
    }
    
    public static JTextField createTextField(int value, int min, int max) {
        return new BoundedIntTextField(value, min, max);
    }

    public static JTextField createTextField(int value, int min, int max, boolean leadZero) {
        return new BoundedIntTextField(value, min, max, leadZero);
    }

     public static JTextField createTextField(int value) {
        return new BoundedIntTextField(value);
    }
    
    public static JTextField createTextField(String value, int maxlength){
        JTextField nuovo = new JTextField(value);
        AbstractDocument abDoc = (AbstractDocument)nuovo.getDocument();
        abDoc.setDocumentFilter(new DocumentSizeFilter(maxlength));
        return nuovo;
    }
    
    //Questo metodo è attualmente usato solo per creare la lista dei filename usati nei LyoutDialogs
    //Nei lyout dialogs l'utente può modificare l'elenco dei files, quindi nel fare le query ai relativi optionsName
    //è opportuno disattivare la cache, altrimenti la lista dei files non cambia mai.
    //Qualora si renda necessario usare questo metodo per creare altre liste in abbinamento al meccanismo di caching, 
    //sarà opportuno rifattorizzare. F F F FATTO
    public static JList createList(String optionName, String val, boolean useCache) throws MVException{
        JList nuovaLista = null;
        OptionsList optionsList = null;
        
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        optionsList = ctrlProtocol.queryOptionName(optionName, useCache);//la chiamata a queryOptionsName senza usare la cache
        //TODO se è null cojone...
        //System.out.println("Query \""+optionName+"\" has returned "+optionsList.getNameCount()+" elements");
        
        int count = optionsList.getNameCount();
        Vector<String> listaValori = new Vector(count);
        int index = -1;
        
        for(int i=0; i<count; i++){
           String opzione = optionsList.getName(i).getVal();
           if(opzione.equals(val))
               index = i;
           listaValori.add(opzione);
        }
          
        nuovaLista = new JList(listaValori);
        nuovaLista.setSelectedIndex(index);
        
        return nuovaLista;
    }

    public static JList createList(String optionName, String val) throws MVException{
        return createList (optionName, val, false);
    }
}
