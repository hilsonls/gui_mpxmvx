package controllori;

import eccezioni.MVException;
import gui.MultiViewerBCS;
import eccezioni.Messaggi;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/*
 * CtrlConnection.java
 *
 * Created on 25 agosto 2007, 18.36
 *
 */

/**
 *
 * @author Skykky, Panda
 */


public class CtrlConnection {
    
    private URL root;
    private URL mvUrl;
    
    private static CtrlConnection instance = null;
    
    private CtrlConnection() {
        
        root = MultiViewerBCS.getRoot();
     
        try {
           // if(root.toString().startsWith("file"))
                //root = new URL("http://23.252.55.174/");   //localhost/appletulation/
            System.out.print("\nConnecting to "+root.toString());
            mvUrl = new URL(root.toString() + "MvEgi.egi");
            
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    //pattern Singleton
    public static CtrlConnection getInstance() {
      if(instance == null) {
         instance = new CtrlConnection();
      }
      return instance;
    }
    
    
    public BufferedReader sendData(String xmlCommand) throws MVException{
        
        BufferedReader in = null;
        Messaggi msg = Messaggi.getInstance();
        
        try {
       
            //System.out.println("Start connection 1");
            HttpURLConnection conn = (HttpURLConnection)mvUrl.openConnection();
            //System.out.println("Start connection 2");
            conn.setDoOutput(true);
            //System.out.println("Start connection 3");
            conn.setUseCaches(false);
            //System.out.println("Start connection 4");
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            //PrintWriter out = new PrintWriter(conn.getOutputStream());
            //System.out.println("Start connection 5");
            out.write(xmlCommand);
            //System.out.println("Start connection 6");
            out.close();
            //System.out.println("Start connection 7");
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            //System.out.println("Start connection 8");
            /*String inputLine;
            //System.out.println("Start connection 9");
            String xmlResponse = "";
            //System.out.println("Start connection 10");
            
            StringBuffer strBuff = new StringBuffer();
            String s = in.readLine();
            while(s !=null) {
                    strBuff.append(s);
                    s = in.readLine();
            }
            //System.out.println("Start connection 11");    
            in.close();
            //System.out.println("Start connection 12");
            
            //System.out.println(xmlResponse);
            
            //AmxxData config = AmxxData.parse(xmlResponse);
            
            ret = strBuff.toString();
            */
            return in;
            
        } catch (MalformedURLException ex) {
            throw new MVException(msg.getMsg("INA"));
        } catch (IOException ex) {
            throw new MVException(msg.getMsg("RCE"));
        }
        
    
        
    }
}


 
