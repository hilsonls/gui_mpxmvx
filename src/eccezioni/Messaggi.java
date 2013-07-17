/*
 * Messaggi.java
 *
*/

package eccezioni;

import java.util.HashMap;

/**
 *
 * @author Skykky Panda
 */
public class Messaggi {
   
    private HashMap eng;
    
    private static Messaggi instance = null;
    
    private Messaggi() {      
        
        eng = new HashMap();
        eng.put("FE","Fatal Error");
        eng.put("INA","Invalid Net Address");
        eng.put("RCE","Remote Communication Error");
        
        
    }
    
    //pattern Singleton
    public static Messaggi getInstance() {
      if(instance == null) {
         instance = new Messaggi();
      }
      return instance;
    }
    
    //return the msg
    public String getMsg(String key){
        return (String)eng.get(key);
    }
    
    
}
