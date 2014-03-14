/*
 * CtrlProtocol.java
 *
 */

package controllori;

import bean.AspectRatio;
import bean.AudioMonitor;
import bean.AudioOut;
import bean.AudioSetup;
import bean.AudioSources;
import bean.CurrTime;
import bean.FrontButton;
import bean.GpiInNameTable;
import bean.GpiInTaskTable;
import bean.GpiOutNameTable;
import bean.GpiOutTaskTable;
import bean.Gpis;
import bean.Layout;
import bean.LiveRead;
import bean.Module;
import bean.ModuleFilename;
import bean.ModuleValid;
import bean.Name;
import bean.Network;
import bean.NgmServer;
import bean.NtpServers;
import bean.Objects;
import bean.ObjectsZOrder;
import bean.Port;
import bean.Protocols;
import bean.Workspace;
import bean.Oggetto;
import bean.OptionsList;
import bean.Remote;
import bean.RemotesAvail;
import bean.SagPresets;
import bean.Screen;
import bean.SnmpMgr;
import bean.Source;
import bean.Sources;
import bean.SysTime;
import bean.Valid;
import bean.VideoCardModeOptions;
import bean.VideoCards;
import bean.SnellController;
import eccezioni.MVException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;


/**
 *
 * @author Skykky Panda
 */
public class CtrlProtocol {
    
    private String lastError ="";
    
    private static CtrlProtocol instance = null;
    
    private HashMap cache;
    //private Workspace config;
    
    
    private CtrlProtocol() {
        cache = new HashMap();       
    }
    
    //pattern Singleton
    public static CtrlProtocol getInstance() {
      if(instance == null) {
         instance = new CtrlProtocol();
      }
      return instance;
    }

    
    //TODO: portare dentro l'unmarshall  su opzione da parametro (se true ritorna Workspace altrimenti null)
    private BufferedReader sendRequest(String xmlRequest) throws MVException{
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        BufferedReader response = null;
       
        response = ctrlConnection.sendData(xmlRequest);
        //response = salvaSuFile(response, "lastResponse.xml");
                    
        return response;
    }

    public void renameLayout(String filename, int idModulo) throws MVException {
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><filename val=\""+escapeXML(filename)+"\" /></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
    }
    
    public void deleteLayout(String filename, int idModulo) throws MVException {
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><filename delete=\""+escapeXML(filename)+"\">filedelete</filename></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
    }

    public void quickSaveLayout(String idFrontPanelLayout, int idModulo) throws MVException {
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><frontButton val=\""+idFrontPanelLayout+"\" action=\"save\" /></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
    }

    public void quickLoadLayout(String idFrontPanelLayout, int idModulo) throws MVException {
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><frontButton val=\""+idFrontPanelLayout+"\" action=\"load\" /></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
    }

    public ModuleFilename saveLayout(String filename, int idModulo) throws MVException {
        ModuleFilename mf = null;
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><filename val=\""+escapeXML(filename)+"\">filesave</filename></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
        
        
        //response = this.salvaSuFile(response, "move.xml");
        try {
            Workspace works = Workspace.unmarshal(response);
            mf = works.getModule(0).getModuleFilename();
            
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Unmarshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        
        return mf;
    }
    
    public Module loadLayout(String filename, int idModulo) throws MVException {
        Module loadedModule = null;
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><filename val=\""+escapeXML(filename)+"\">fileload</filename></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
        
        
        //response = this.salvaSuFile(response, "move.xml");
        try {
            Workspace works = Workspace.unmarshal(response);
            loadedModule = works.getModule(0);
            
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Unmarshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        
        return loadedModule;
    }

    public NtpServers addNtpServerToMV(int idModulo, String serverName) throws MVException {
        BufferedReader xmlResponse = sendRequest("<workspace>"+
                                                    "<module id=\""+idModulo+"\">"+
                                                        "<sysTime>"+
                                                            "<ntpServers server=\""+escapeXML(serverName)+"\">"+
                                                                "new"+
                                                            "</ntpServers>"+
                                                        "</sysTime>"+
                                                    "</module>"+
                                                "</workspace>");
        try {
            Unmarshaller unm = new Unmarshaller(Workspace.class);
            unm.setValidation(false);
            Workspace works = (Workspace) unm.unmarshal(xmlResponse);
            return works.getModule(0).getSysTime().getNtpServers();
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }        
    }
    
    public void removeNtpServerFromMV(int idModulo, int ntpServerId) throws MVException {
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><sysTime><ntpServers><ntpServer id=\""+ntpServerId+"\">delete</ntpServer></ntpServers></sysTime></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
    }
    
    public void saveCurrentTimeToMV(int idModulo, CurrTime currTime) throws MVException {
        BufferedReader xmlResponse = null;
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\"><sysTime><syncMode val=\"Manual\"/>");
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(currTime);
            out.write("</sysTime></module></workspace>");
            xmlResponse = ctrlConnection.sendData(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }
    
    public void saveRemoteToMV(int idModulo, Remote remote) throws MVException{
        
        BufferedReader xmlResponse = null;
        Workspace config= null;
        
        //Marshaller.
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\"><remoteControl><remotesAvail><remote id=\""+remote.getId()+"\">");
            //modulo.getObjects().marshal(out);
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            if (remote.getDhcp().getVal()) {
                mars.marshal(remote.getDhcp());
            } else {
                mars.marshal(remote.getIpaddr());
                mars.marshal(remote.getNetmask());
                mars.marshal(remote.getGateway());
            }
            out.write("</remote></remotesAvail></remoteControl></module></workspace>");
            xmlResponse = sendRequest(out.toString());
            if(xmlResponse!=null){
                            
                config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);

                xmlResponse.close();
            }
                    
        
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }
    
    public void saveRemotesAvailableToMV(int idModulo, RemotesAvail remotes) throws MVException{
        
        BufferedReader xmlResponse = null;
        Workspace config= null;
        
        //Marshaller.
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\"><remoteControl>");
            //modulo.getObjects().marshal(out);
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(remotes);
            out.write("</remoteControl></module></workspace>");
            xmlResponse = sendRequest(out.toString());
            if(xmlResponse!=null){
                            
                config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);

                xmlResponse.close();
            }
                    
        
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }
    
    public RemotesAvail loadRemotesAvailableFromMV(int idModulo) throws MVException {
        RemotesAvail remotes = null;
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><remoteControl><remotesAvail>query</remotesAvail></remoteControl></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
                
        //response = this.salvaSuFile(response, "move.xml");
        try {
            Workspace works = Workspace.unmarshal(response);
            remotes = works.getModule(0).getRemoteControl().getRemotesAvail();
            
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Unmarshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        
        return remotes;
    }
    
    public void cutOggetto(Oggetto bean) throws MVException{
        String xmlRequest;
        xmlRequest = "<workspace><module id=\"0\"><objects><object id=\""+bean.getId()+"\">delete</object></objects></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
    }
    
    public ObjectsZOrder moveToFront(Oggetto bean) throws MVException{
        ObjectsZOrder objectsZOrder = null;
        String xmlRequest;
        xmlRequest = "<workspace><module id=\"0\"><objectsZOrder><objectZOrder id=\""+bean.getId()+"\" pos=\"front\"/></objectsZOrder></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
        
        
        //response = this.salvaSuFile(response, "move.xml");
        try {
            Workspace works = Workspace.unmarshal(response);
            objectsZOrder = works.getModule(0).getObjectsZOrder();
            
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Unmarshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        
        return objectsZOrder;
    }
    
    public ObjectsZOrder moveToBack(Oggetto bean) throws MVException{
        ObjectsZOrder objectsZOrder = null;
        String xmlRequest;
        xmlRequest = "<workspace><module id=\"0\"><objectsZOrder><objectZOrder id=\""+bean.getId()+"\" pos=\"back\"/></objectsZOrder></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
        
        
        //response = this.salvaSuFile(response, "move.xml");
        try {
            Workspace works = Workspace.unmarshal(response);
            objectsZOrder = works.getModule(0).getObjectsZOrder();
            
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Unmarshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        
        return objectsZOrder;
    }
    
    public Oggetto nuovoOggetto(int idScreen) throws MVException{
        
        Oggetto delCazzo = null;
        String xmlRequest;
        xmlRequest = "<workspace><module id=\"0\"><objects screen=\""+idScreen+"\">new</objects></module></workspace>";


        BufferedReader response = sendRequest(xmlRequest);
        
        try {
            Workspace conf = Workspace.unmarshal(response);
            delCazzo = conf.getModule(0).getObjects().getOggetto(0);

            } catch (MarshalException ex) {
                ex.printStackTrace();
                throw new MVException("Unmarshal error");
            } catch (ValidationException ex) {
                ex.printStackTrace();
                throw new MVException("Xml validation error");
            }
       

        return delCazzo;
    /*
    FileReader fread = null;
    try {
    Object cazzo = new Object();
    fread = new FileReader("response.xml");
    Workspace conf = Workspace.unmarshal(fread);
    return conf.getModule(0).getObjects().getOggetto(0);
    } catch (MarshalException ex) {
    Logger.getLogger(CtrlProtocol.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ValidationException ex) {
    Logger.getLogger(CtrlProtocol.class.getName()).log(Level.SEVERE, null, ex);
    } catch (FileNotFoundException ex) {
    Logger.getLogger(CtrlProtocol.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
    try {
    fread.close();
    } catch (IOException ex) {
    Logger.getLogger(CtrlProtocol.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    return null;*/

    /*
    FileReader fread = null;
    try {
    Object cazzo = new Object();
    fread = new FileReader("response.xml");
    Workspace conf = Workspace.unmarshal(fread);
    return conf.getModule(0).getObjects().getOggetto(0);
    } catch (MarshalException ex) {
    Logger.getLogger(CtrlProtocol.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ValidationException ex) {
    Logger.getLogger(CtrlProtocol.class.getName()).log(Level.SEVERE, null, ex);
    } catch (FileNotFoundException ex) {
    Logger.getLogger(CtrlProtocol.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
    try {
    fread.close();
    } catch (IOException ex) {
    Logger.getLogger(CtrlProtocol.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    return null;*/
    }
    
    private void salvaSuFile(Writer br, String nomeFile){
        
        FileWriter fstream;
        
        try {
            fstream = new FileWriter(nomeFile);
            
            BufferedWriter out = new BufferedWriter(fstream);
            
            out.write(br.toString());
            
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        
    }
    
    private BufferedReader salvaSuFile(BufferedReader br, String nomeFile){
        
        FileWriter fstream;
        String NEW_LINE = System.getProperty("line.separator");
        try {
            fstream = new FileWriter(nomeFile);
            
            BufferedWriter out = new BufferedWriter(fstream);
            String line;
            while ((line = br.readLine()) != null) {
                out.write(line+NEW_LINE);
            } 
            out.close();
            br = new BufferedReader(new FileReader(nomeFile));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        
        return br;
        
    }
    
    public void commit(int idModulo)throws MVException{
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\">commit</module></workspace>";


        BufferedReader response = sendRequest(xmlRequest);
          
    }
    
    public void halt(int idModulo)throws MVException{
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\">halt</module></workspace>";


        BufferedReader response = sendRequest(xmlRequest);
          
    }
    
    public void reboot(int idModulo)throws MVException{
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\">reboot</module></workspace>";


        BufferedReader response = sendRequest(xmlRequest);
          
    }
        
    public void reset(int idModulo)throws MVException{
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\">reset</module></workspace>";


        BufferedReader response = sendRequest(xmlRequest);
          
    }
    
    
    public Workspace read(int idModulo)throws MVException{
               
        
        BufferedReader xmlResponse = null;
        Workspace config= null;
        
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        
        xmlResponse = ctrlConnection.sendData("<workspace><module id=\""+idModulo+"\">read</module></workspace>");
        //this.salvaSuFile(xmlResponse, "readGetLayout.xml");
        
        
        if(xmlResponse!=null){
            try {

                config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);
                       
                xmlResponse.close();
                               
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new MVException("I/O exception");
            } catch (MarshalException ex) {
                ex.printStackTrace();
                throw new MVException("Unmarshal error");
            } catch (ValidationException ex) {
                ex.printStackTrace();
                throw new MVException("Xml validation error");
            }
        }
       
        return config;
    }
    
    public void saveModuleLayoutToMV(int idModulo, Layout layout) throws MVException {
        BufferedReader xmlResponse = null;
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\">");
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(layout);
            out.write("</module></workspace>");
            xmlResponse = ctrlConnection.sendData(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }
    
    public void saveSourceToMV(int idModulo, Source source) throws MVException{
        BufferedReader xmlResponse = null;
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        //Marshaller.
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\"><sources>");
            //modulo.getObjects().marshal(out);
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(source);
            out.write("</sources></module></workspace>");
            xmlResponse = ctrlConnection.sendData(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }
    
    public void saveAudioSourcesToMv(int idModulo, AudioSources source) throws MVException {
        BufferedReader xmlResponse = null;
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        //Marshaller.
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\"><audioSources>");
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(source);
            out.write("</audioSources></module></workspace>");
            xmlResponse = ctrlConnection.sendData(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }
    
    public void saveSourcesUsernameToMV(int idModulo, Sources sources) throws MVException{
        BufferedReader xmlResponse = null;
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        //Marshaller.
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\"><sources>");
            
            for (int i = 0; i < sources.getSourceCount(); i++) {
                Source source = sources.getSource(i);
                out.write("<source id=\""+source.getId()+"\"><username val=\""+escapeXML(source.getUsername().getVal())+"\"/></source>");
            }
            
            out.write("</sources></module></workspace>");
            
            xmlResponse = ctrlConnection.sendData(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } 
    }
    
    public void saveSourcesToMV(int idModulo, Sources sources) throws MVException{
        BufferedReader xmlResponse = null;
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        //Marshaller.
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\">");
            //modulo.getObjects().marshal(out);
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(sources);
            out.write("</module></workspace>");
            xmlResponse = ctrlConnection.sendData(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        //this.salvaSuFile(out, "comandoOggetti.xml");
        //this.salvaSuFile(xmlResponse, "rispostaOggetti.xml");
    }
    
    public Workspace saveObjectToMV(int idModulo, Oggetto oggetto) throws MVException{
        
        BufferedReader xmlResponse = null;
        Workspace config= null;
        
        //Marshaller.
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\"><objects>");
            //modulo.getObjects().marshal(out);
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(oggetto);
            out.write("</objects></module></workspace>");
            xmlResponse = sendRequest(out.toString());
            if(xmlResponse!=null){
                            
                config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);

                xmlResponse.close();
            }
                   
        
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        return config;
    }
    
    public void saveSourceAssignedToObjectToMV(int idModulo, Oggetto oggetto) throws MVException{
        
        
        Workspace config= null;
        
        //Marshaller.
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\"><objects>");
            
            //modulo.getObjects().marshal(out);
       
            out.write("<object id=\""+oggetto.getId()+"\"><vidAudProperties><source val=\""+oggetto.getObjectSequence().getVidAudProperties().getVidAudSource().getVal()+"\"/></vidAudProperties></object>");
                    
            
            out.write("</objects></module></workspace>");
            sendRequest(out.toString());
            
                    
        
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        }
        
    }
    
    public void saveObjectsToMV(Module modulo) throws MVException{
        BufferedReader xmlResponse = null;
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        //Marshaller.
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+modulo.getId()+"\">");
            //modulo.getObjects().marshal(out);
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(modulo.getObjects());
            out.write("</module></workspace>");
            xmlResponse = ctrlConnection.sendData(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        //this.salvaSuFile(out, "comandoOggetti.xml");
        //this.salvaSuFile(xmlResponse, "rispostaOggetti.xml");
    }
    
    public void saveObjectsZOrderToMV(Module modulo) throws MVException{
        BufferedReader xmlResponse = null;
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        //Marshaller.
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+modulo.getId()+"\">");
            //modulo.getObjects().marshal(out);
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(modulo.getObjectsZOrder());
            out.write("</module></workspace>");
            xmlResponse = ctrlConnection.sendData(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        //this.salvaSuFile(out, "comandoOggetti.xml");
        //this.salvaSuFile(xmlResponse, "rispostaOggetti.xml");
    }    
    
    public void saveConfigurationToMV(Workspace config) throws MVException{
       
        BufferedReader xmlResponse = null;
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        //Marshaller.
        Writer out = new StringWriter();
        try {
            config.marshal(out);
            xmlResponse = ctrlConnection.sendData(out.toString());
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        
        //this.salvaSuFile(xmlResponse, "risposta.xml");
    }
    
    public void saveVideoCardsToMV(int idModulo, VideoCards videoCards) throws MVException {
        BufferedReader xmlResponse = null;
        
        //Marshaller.
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\">");
            //modulo.getObjects().marshal(out);
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(videoCards);
            out.write("</module></workspace>");
            xmlResponse = sendRequest(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }
    
    public SysTime loadSysTimeFromMV(int idModulo) throws MVException {
        SysTime sysTime = null;
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><sysTime>query</sysTime></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
                
        //response = this.salvaSuFile(response, "move.xml");
        try {
            Workspace works = Workspace.unmarshal(response);
            sysTime = works.getModule(0).getSysTime();
            
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Unmarshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        
        return sysTime;
    }
    
    public void saveSysTimeToMV(int idModulo, SysTime sysTime) throws MVException {
        BufferedReader xmlResponse = null;

        CurrTime currTime = sysTime.getCurrTime();
        sysTime.setCurrTime(null);
        //Marshaller.
        Writer out = new StringWriter();
        try {
            /*StringWriter writer = new StringWriter();
            Marshaller mars1 = new Marshaller(writer);
            mars1.setMarshalAsDocument(false);
            mars1.marshal(sysTime);
            System.out.print(writer.toString());*/

            out.write("<workspace><module id=\""+idModulo+"\">");
            //modulo.getObjects().marshal(out);
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(sysTime);
            out.write("</module></workspace>");
            xmlResponse = sendRequest(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        } finally {
            sysTime.setCurrTime(currTime);
        }
    }
    
    public Screen saveScreenToMV(int idModulo, Screen bean) throws MVException {
        BufferedReader xmlResponse = null;
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\">");
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(bean);
            out.write("</module></workspace>");
            xmlResponse = sendRequest(out.toString());
            //xmlResponse = salvaSuFile(xmlResponse, "screenResponse.xml");
            Workspace config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);
            xmlResponse.close();
            return config.getModule(idModulo).getScreen();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }
    
    //bug #141  i gpiOut vengono gestiti come i gpiIn, quindi stanno dentro GPIS
//    public void saveGPOAlarmOutToMV(int idModulo, AlarmOut alarmOut) throws MVException {
//        BufferedReader xmlResponse = null;
//        Writer out = new StringWriter();
//        try {
//            out.write("<workspace><module id=\""+idModulo+"\">");
//            Marshaller mars = new Marshaller(out);
//            mars.setMarshalAsDocument(false);
//            mars.marshal(alarmOut);
//            out.write("</module></workspace>");
//            xmlResponse = sendRequest(out.toString());
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            throw new MVException("I/O exception");
//        } catch (MarshalException ex) {
//            ex.printStackTrace();
//            throw new MVException("Marshal error");
//        } catch (ValidationException ex) {
//            ex.printStackTrace();
//            throw new MVException("Xml validation error");
//        }
//    }
    
    public void saveAudioMonitorToMV(int idModulo, AudioMonitor audioMonitor) throws MVException {
        BufferedReader xmlResponse = null;
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\">");
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(audioMonitor);
            out.write("</module></workspace>");
            xmlResponse = sendRequest(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }

    public void saveAudioSetupToMV(int idModulo, AudioSetup audioSetup) throws MVException {
        BufferedReader xmlResponse = null;
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\">");
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(audioSetup);
            out.write("</module></workspace>");
            xmlResponse = sendRequest(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }
    
    public void saveAudioOutputToMV(int idModulo, AudioOut audioOutput) throws MVException {
        BufferedReader xmlResponse = null;
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\">");
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(audioOutput);
            out.write("</module></workspace>");
            xmlResponse = sendRequest(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }

    public void commitNetworkSettings(int idModulo) throws MVException {
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><network>commit</network></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
    }
    
    public void saveNetworkToMV(int idModulo, Network network) throws MVException {
        BufferedReader xmlResponse = null;
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\">");
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(network);
            out.write("</module></workspace>");
            xmlResponse = sendRequest(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }

    public NgmServer newNgm164Server(int idModulo) throws MVException {
        BufferedReader xmlResponse = null;
        Writer out = new StringWriter();
        Workspace config = null;
        try {
            out.write("<workspace><module id=\""+idModulo+"\"><ngmServers>new</ngmServers></module></workspace>");
            xmlResponse = sendRequest(out.toString());
            
            if(xmlResponse!=null){
                config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);
                xmlResponse.close();
            }
         
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        
        return config.getModule(0).getNgmServers().getNgmServer(0);
    }    
    
    public void removeNgmServer(int idModulo, int ngm164ServerId) throws MVException {
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><ngmServers><ngmServer id=\""+ngm164ServerId+"\">delete</ngmServer></ngmServers></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
    }
    
    public NgmServer saveNgm164ServerToMV(int idModulo, NgmServer ngmServer) throws MVException {
        BufferedReader xmlResponse = sendRequest("<workspace>"+
                                                    "<module id=\""+idModulo+"\">"+
                                                        "<ngmServers>"+
                                                            "<ngmServer id=\""+ngmServer.getId()+"\">"+
                                                                "<alias val=\""+escapeXML(ngmServer.getAlias().getVal())+"\"/>"+
                                                                "<ipaddr val=\""+ngmServer.getIpaddr().getVal()+"\"/>"+
                                                            "</ngmServer>"+
                                                        "</ngmServers>"+
                                                    "</module>"+
                                                "</workspace>");
        try {
            Unmarshaller unm = new Unmarshaller(Workspace.class);
            unm.setValidation(false);
            Workspace works = (Workspace) unm.unmarshal(xmlResponse);
            return works.getModule(0).getNgmServers().getNgmServer(0);
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }

    public SnellController newSnellController(int idModulo) throws MVException {
        BufferedReader xmlResponse = null;
        Writer out = new StringWriter();
        Workspace config = null;
        try {
            out.write("<workspace><module id=\""+idModulo+"\"><protocols><snellRouter><controller>new</controller></snellRouter></protocols></module></workspace>");
            xmlResponse = sendRequest(out.toString());
            
            if(xmlResponse!=null){
                config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);
                xmlResponse.close();
            }
         
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        
        return config.getModule(0).getProtocols().getSnellRouter().getSnellController(0);
    }    

    public void removeSnellController(int idModulo, int controllerId) throws MVException {
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><protocols><snellRouter><controller id=\""+controllerId+"\">delete</controller></snellRouter></protocols></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
    }

    public SnellController saveSnellControllerToMV(int idModulo, SnellController snellController) throws MVException {
        BufferedReader xmlResponse = sendRequest("<workspace>"+
                                                    "<module id=\""+idModulo+"\">"+
                                                        "<protocols>"+
                                                            "<snellRouter>"+
                                                                "<controller id=\""+snellController.getId()+"\""+
                                                                    " name=\""+snellController.getName()+"\""+
                                                                    " ipaddr1=\""+snellController.getIpaddr1()+"\""+
                                                                    " port1=\""+snellController.getPort1()+"\""+
                                                                    " ipaddr2=\""+snellController.getIpaddr2()+"\""+
                                                                    " port2=\""+snellController.getPort2()+"\""+
                                                                "/>"+
                                                            "</snellRouter>"+
                                                        "</protocols>"+
                                                    "</module>"+
                                                "</workspace>");
        try {
            Unmarshaller unm = new Unmarshaller(Workspace.class);
            unm.setValidation(false);
            Workspace works = (Workspace) unm.unmarshal(xmlResponse);
            return works.getModule(0).getProtocols().getSnellRouter().getSnellController(0);
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }

    public CurrTime loadCurrentTimeFromMV(int idModulo) throws MVException {
        BufferedReader xmlResponse = null;
        Workspace config= null;
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        xmlResponse = ctrlConnection.sendData("<workspace><module id=\""+idModulo+"\"><sysTime><currTime>query</currTime></sysTime></module></workspace>");
        if (xmlResponse!=null){
            try {
                config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);
                xmlResponse.close();
            } catch (IOException ex) {
                throw new MVException("I/O Exception");
            } catch (MarshalException ex) {
                throw new MVException("Unmarshall error");
            } catch (ValidationException ex) {
                throw new MVException("Xml validation error");
            }
        }
        return config.getModule(idModulo).getSysTime().getCurrTime();
    }
    
    public VideoCardModeOptions loadVideoCardModeOptionsFromMV(int idModulo, int idCard) throws MVException {
        BufferedReader xmlResponse = null;
        Workspace config= null;
        
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        
        xmlResponse = ctrlConnection.sendData("<workspace><module id=\""+idModulo+"\"><videoCards><card id=\""+idCard+"\"><videoCardModeOptions>query</videoCardModeOptions></card></videoCards></module></workspace>");
                
        //xmlResponse = this.salvaSuFile(xmlResponse, "oggetti.xml");
        
        if(xmlResponse!=null){
            try {

                
                config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);

                xmlResponse.close();
             
                
            } catch (IOException ex) {
                throw new MVException("I/O exception");
            } catch (MarshalException ex) {
                
                ex.printStackTrace();
                throw new MVException("Unmarshall error");
                
            } catch (ValidationException ex) {
                throw new MVException("Xml validation error");
            }
        }
                    
        return config.getModule(0).getVideoCards().getCard(0).getVideoCardModeOptions();
    }
    
    public Sources loadSourcesFromMV(int idModulo) throws MVException
    {
        
        
        BufferedReader xmlResponse = null;
        Workspace config= null;
        
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        
        xmlResponse = ctrlConnection.sendData("<workspace><module id=\""+idModulo+"\"><sources>query</sources></module></workspace>");
                
        //xmlResponse = this.salvaSuFile(xmlResponse, "oggetti.xml");
        
        if(xmlResponse!=null){
            try {

                
                config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);

                xmlResponse.close();
             
                
            } catch (IOException ex) {
                throw new MVException("I/O Exception");
            } catch (MarshalException ex) {
                
                ex.printStackTrace();
                throw new MVException("Unmarshall error");
                
            } catch (ValidationException ex) {
                throw new MVException("Xml validation error");
            }
        }
                    
        return config.getModule(idModulo).getSources();
    }
    
    
    public Objects loadObjectsFromMV(int idModulo) throws MVException
    {
        
        
        BufferedReader xmlResponse = null;
        Workspace config= null;
        
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        
        xmlResponse = ctrlConnection.sendData("<workspace><module id=\""+idModulo+"\"><objects>query</objects></module></workspace>");
                
        //xmlResponse = this.salvaSuFile(xmlResponse, "oggetti.xml");
        
        if(xmlResponse!=null){
            try {

                
                config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);

                xmlResponse.close();
             
                
            } catch (IOException ex) {
                throw new MVException("I/O Exception");
            } catch (MarshalException ex) {
                
                ex.printStackTrace();
                throw new MVException("Unmarshall error");
                
            } catch (ValidationException ex) {
                throw new MVException("Xml validation error");
            }
        }
                    
        return config.getModule(idModulo).getObjects();
    }
    
    public ObjectsZOrder loadObjectsZOrderFromMV(int idModulo) throws MVException
    {
        
        
        BufferedReader xmlResponse = null;
        Workspace config= null;
        
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        
        xmlResponse = ctrlConnection.sendData("<workspace><module id=\""+idModulo+"\"><objectsZOrder>query</objectsZOrder></module></workspace>");
                
        if(xmlResponse!=null){
            try {

                
                config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);

                xmlResponse.close();
             
                
            } catch (IOException ex) {
                throw new MVException("I/O Exception");
            } catch (MarshalException ex) {
                
                ex.printStackTrace();
                throw new MVException("Unmarshall error");
                
            } catch (ValidationException ex) {
                throw new MVException("Xml validation error");
            }
        }
                    
        return config.getModule(idModulo).getObjectsZOrder();
    }
    
    public Workspace loadConfigurationFromMV() throws MVException
    {
        
        
        BufferedReader xmlResponse = null;
        Workspace config= null;
        
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        
        xmlResponse = ctrlConnection.sendData("<workspace>query</workspace>");
        //this.salvaSuFile(xmlResponse, "configurazioneIniziale.xml");
        
        /*FileWriter fstream;
        String NEW_LINE = System.getProperty("line.separator");
        try {
            fstream = new FileWriter("response.xml");
            BufferedWriter out = new BufferedWriter(fstream);
            String line;
            while ((line = xmlResponse.readLine()) != null) {
                out.write(line+NEW_LINE);
            } 
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        try {
            xmlResponse = new BufferedReader(new FileReader("response.xml"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        */
        System.out.println("Start parsing");
        long millis = System.currentTimeMillis();
        if(xmlResponse!=null){
            try {

                //this.salvaSuFile(xmlResponse, "merrore.xml");
                config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);
                       
                xmlResponse.close();
               
                /*
                try {
                    fstream = new FileWriter("marshal.xml");
                    BufferedWriter out = new BufferedWriter(fstream);
                    config.getModule(1).getObjects().getOggetto(0).getUsername().setVal("PortoDio");
                    config.getModule(1).getObjects().getOggetto(0).marshal(fstream);
                    fstream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
*/
                
            } catch (IOException ex) {
                throw new MVException("I/O Exception");
            } catch (MarshalException ex) {
                
                ex.printStackTrace();
                throw new MVException("Unmarshall error");
                
            } catch (ValidationException ex) {
                throw new MVException("Xml validation error");
            }
        }
        System.out.println("End parsing");
        System.out.println("Time elapsed: "+((System.currentTimeMillis()-millis))+"ms");
        
        return config;
    }
   
    public VideoCards loadVideoCardsFromMV(int idModulo) throws MVException
    {
        
        
        BufferedReader xmlResponse = null;
        Workspace config= null;
        
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        
        xmlResponse = ctrlConnection.sendData("<workspace><module id=\""+idModulo+"\"><videoCards>query</videoCards></module></workspace>");
                
        if(xmlResponse!=null){
            try {

                
                config = (Workspace) Unmarshaller.unmarshal(Workspace.class, xmlResponse);

                xmlResponse.close();
             
                
            } catch (IOException ex) {
                throw new MVException("I/O Exception");
            } catch (MarshalException ex) {
                
                ex.printStackTrace();
                throw new MVException("Unmarshall error");
                
            } catch (ValidationException ex) {
                throw new MVException("Xml validation error");
            }
        }
                    
        return config.getModule(0).getVideoCards();
    }
    
    /*public boolean sendCommand(String xmlCommand) {
        
        boolean ret = false;
        BufferedReader xmlResponse = null;
        
        
        CtrlConnection ctrlConnection = CtrlConnection.getInstance();
        try {
            //MyGlassPane.getInstance().setVisible(true);    
            xmlResponse = ctrlConnection.sendData(xmlCommand);
            
            xmlResponse.close();
            //MyGlassPane.getInstance().setVisible(false);
            
        } catch (IOException ex) {
            Logger.getLogger(CtrlProtocol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MVException ex) {
            this.setLastError(ex.getMessage());
            //MyGlassPane.getInstance().setVisible(false);
            return ret;   
        }
        
        //System.out.println(xmlResponse);
        
        /*if(xmlResponse!=null){
            //Parse risposta
            XMLElement documento = new XMLElement();
            XMLElement errorCode = new XMLElement();
            XMLElement errorMsg  = new XMLElement();
            
            documento.parseString(xmlResponse);
            
            Enumeration lista = documento.enumerateChildren();
            
            while (lista.hasMoreElements()) {
                XMLElement temp = (XMLElement)lista.nextElement();
                if(temp.getName().equals("errorCode"))
                   errorCode = temp;
                else
                   errorMsg = temp;
            }
            
            if((!errorCode.getContent().equals("0"))&&(!errorCode.getContent().equals("-1"))){
             
                this.setLastError(errorMsg.getContent());
                return ret;
            }
            
            
        }*/
   /*         
        ret = true;
                    
        return ret;
    }*/

    public OptionsList queryOptionName(String optionName) throws MVException{
        return queryOptionName(optionName, true);
    }
    
    public OptionsList queryOptionName(String optionName, boolean useCache) throws MVException{
        OptionsList listaValori = null; 
                      
        if (useCache) {
            listaValori = (OptionsList)cache.get(optionName);
            if(listaValori!=null)
                return listaValori;
        }
        
        String xmlRequest;
        xmlRequest = "<workspace><module id=\"0\"><"+optionName+">queryas_optionsList</"+optionName+"></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
        try {
            Workspace works = Workspace.unmarshal(response);
            listaValori = works.getModule(0).getOptionsList();
        } catch (MarshalException ex) {
            System.out.println("Marshall Exception in queryOptionName: "+optionName);
            System.out.println("Request sent: "+xmlRequest);
            //ex.printStackTrace();
        } catch (ValidationException ex) {
            System.out.println("Validation Exception in queryOptionName: "+optionName);
            System.out.println("Request sent: "+xmlRequest);
            //ex.printStackTrace();
        }
        //per evitare errori di nullPointer...
        if (listaValori==null){
            listaValori = new OptionsList();
            Name nome = new Name();
            nome.setVal("query failed: "+optionName);
            listaValori.addName(nome);
        }
        else{
            cache.put(optionName, listaValori);
        }
        
        return listaValori;
    }

    public LiveRead queryLiveRead(int idModulo) throws MVException {
        LiveRead ret = null;
        String xmlRequest;
        xmlRequest = "<liveRead><module id=\""+idModulo+"\"><objects>query</objects><objectsZOrder>query</objectsZOrder></module></liveRead>";
        BufferedReader response = sendRequest(xmlRequest);

        try {
            //salvaSuFile(response, "liveread.xml");
            ret = LiveRead.unmarshal(response);

        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Unmarshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }

        return ret;
    }

    public FrontButton queryFrontButton(int idModulo) throws MVException {
        FrontButton frontButton = null;
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><frontButton>query</frontButton></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);

        try {
            Workspace works = Workspace.unmarshal(response);
            frontButton = works.getModule(0).getFrontButton();

        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Unmarshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }

        return frontButton;
    }
    
    public ModuleValid queryValidModule(int idModulo) throws MVException {
        ModuleValid valid = null;
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><valid>query</valid></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
        
        try {
            Workspace works = Workspace.unmarshal(response);
            valid = works.getModule(0).getModuleValid();
            
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Unmarshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        
        return valid;
    }
    
    public Valid queryValidObject(int idOggetto, int idModulo) throws MVException {
        Valid valid = null;
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><objects><object id=\""+idOggetto+"\"><valid>query</valid></object></objects></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
        
        try {
            Unmarshaller unm = new Unmarshaller(Workspace.class);
            unm.setValidation(false);
            Workspace works = (Workspace) unm.unmarshal(response);
            valid = works.getModule(0).getObjects().getOggetto(0).getValid();
            
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Unmarshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        
        return valid;
    }

    public AspectRatio queryAspectRatio(int idOggetto, int idModulo) throws MVException {
        AspectRatio aspectRatio = null;
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><objects><object id=\""+idOggetto+"\"><aspectRatio>query</aspectRatio></object></objects></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
        //this.salvaSuFile(response, "aspectRatio.xml");
        try {
            Unmarshaller unm = new Unmarshaller(Workspace.class);
            unm.setValidation(false);
            Workspace works = (Workspace) unm.unmarshal(response);
            aspectRatio = works.getModule(0).getObjects().getOggetto(0).getAspectRatio();

        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Unmarshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }

        return aspectRatio;
    }
    
    public SagPresets querySagPresets() throws MVException {
        SagPresets sagPresets = null;
        String xmlRequest;
        xmlRequest = "<workspace><module id=\"0\"><sagTable>queryas_sagPresets</sagTable></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
        
        try {
            Workspace works = Workspace.unmarshal(response);
            sagPresets = works.getModule(0).getSagPresets();
            
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Unmarshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
        
        return sagPresets;
    }

    public GpiInNameTable queryGpiInNameTable(String optionName, int idModulo) throws MVException{
        GpiInNameTable listaValori = null;


        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><"+optionName+">queryas_gpiInNameTable</"+optionName+"></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
        try {
            //salvaSuFile(response, "EBV.xml");
            Workspace works = Workspace.unmarshal(response);
            listaValori = works.getModule(idModulo).getGpiInNameTable();
        } catch (MarshalException ex) {
            System.out.println("Marshall Exception in queryOptionName: "+optionName);
            System.out.println("Request sent: "+xmlRequest);
            //ex.printStackTrace();
        } catch (ValidationException ex) {
            System.out.println("Validation Exception in queryOptionName: "+optionName);
            System.out.println("Request sent: "+xmlRequest);
            //ex.printStackTrace();
        }

        return listaValori;
    }

    public GpiInTaskTable queryGpiInTaskTable(String optionName, int idModulo) throws MVException{
        GpiInTaskTable listaValori = null;


        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><"+optionName+">queryas_gpiInTaskTable</"+optionName+"></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
        try {
            Workspace works = Workspace.unmarshal(response);
            listaValori = works.getModule(idModulo).getGpiInTaskTable();
        } catch (MarshalException ex) {
            System.out.println("Marshall Exception in queryOptionName: "+optionName);
            System.out.println("Request sent: "+xmlRequest);
            //ex.printStackTrace();
        } catch (ValidationException ex) {
            System.out.println("Validation Exception in queryOptionName: "+optionName);
            System.out.println("Request sent: "+xmlRequest);
            //ex.printStackTrace();
        }

        return listaValori;
    }

    public GpiOutNameTable queryGpiOutNameTable(String optionName, int idModulo) throws MVException{
        GpiOutNameTable listaValori = null;


        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><"+optionName+">queryas_gpiOutNameTable</"+optionName+"></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
        try {
            //salvaSuFile(response, "EBV.xml");
            Workspace works = Workspace.unmarshal(response);
            listaValori = works.getModule(idModulo).getGpiOutNameTable();
        } catch (MarshalException ex) {
            System.out.println("Marshall Exception in queryOptionName: "+optionName);
            System.out.println("Request sent: "+xmlRequest);
            //ex.printStackTrace();
        } catch (ValidationException ex) {
            System.out.println("Validation Exception in queryOptionName: "+optionName);
            System.out.println("Request sent: "+xmlRequest);
            //ex.printStackTrace();
        }

        return listaValori;
    }

    public GpiOutTaskTable queryGpiOutTaskTable(String optionName, int idModulo) throws MVException{
        GpiOutTaskTable listaValori = null;


        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><"+optionName+">queryas_gpiOutTaskTable</"+optionName+"></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
        try {
            Workspace works = Workspace.unmarshal(response);
            listaValori = works.getModule(idModulo).getGpiOutTaskTable();
        } catch (MarshalException ex) {
            System.out.println("Marshall Exception in queryOptionName: "+optionName);
            System.out.println("Request sent: "+xmlRequest);
            //ex.printStackTrace();
        } catch (ValidationException ex) {
            System.out.println("Validation Exception in queryOptionName: "+optionName);
            System.out.println("Request sent: "+xmlRequest);
            //ex.printStackTrace();
        }

        return listaValori;
    }


    public SnmpMgr addSnmpMgr(int idModulo, String snmpMgrIp) throws MVException {
        SnmpMgr newSnmpMgr = null;
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><network><snmpMgrs><snmpMgr val=\""+snmpMgrIp+"\"/></snmpMgrs></network></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);

        try {
            Unmarshaller unm = new Unmarshaller(Workspace.class);
            unm.setValidation(false);
            Workspace works = (Workspace) unm.unmarshal(response);
            newSnmpMgr = works.getModule(0).getNetwork().getSnmpMgrs().getSnmpMgr(0); //Uso indici senza verificarne l'esistenza quindi intercetto ArrayIndexOutOfBoundException
            
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Unmarshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        } catch (ArrayIndexOutOfBoundsException ex) {
            //Questa eccezione si verifica se nella risposta del mv non è presente il tag module o il tag SnmpMgr
            ex.printStackTrace();
            throw new MVException("An error has occurred while creating new SNMP Server entry");
        }
        
        return newSnmpMgr;
    }
    
    public void removeSnmpMgr(int idModulo, int snmpMgrId) throws MVException {
        String xmlRequest;
        xmlRequest = "<workspace><module id=\""+idModulo+"\"><network><snmpMgrs><snmpMgr id=\""+snmpMgrId+"\" val=\"\"/></snmpMgrs></network></module></workspace>";
        BufferedReader response = sendRequest(xmlRequest);
    }
    
    public String getLastError() {
        return lastError;
    }

    public void setLastError(String lastError) {
        this.lastError = lastError;
    }
    
    public String escapeXML(String aText) {
        final StringBuilder result = new StringBuilder();
        final StringCharacterIterator iterator = new StringCharacterIterator(aText);
        char character =  iterator.current();
        while (character != CharacterIterator.DONE ){
            if (character == '<') {
                result.append("&lt;");
            } else if (character == '>') {
                result.append("&gt;");
            } else if (character == '\"') {
                result.append("&quot;");
            } else if (character == '\'') {
                result.append("&#039;");
            } else if (character == '&') {
                result.append("&amp;");
            } else {
                //the char is not a special one
                //add it to the result as is
                result.append(character);
            }
            character = iterator.next();
        }
        return result.toString();
    }

    public void savePortToMV(int idModulo, Port port) throws MVException{
        BufferedReader xmlResponse = null;
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\"><protocols><ports>");
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(port);
            out.write("</ports></protocols></module></workspace>");
            xmlResponse = sendRequest(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }

    public void saveProtocolsToMV(int idModulo, Protocols protocols)  throws MVException {
        BufferedReader xmlResponse = null;
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\">");
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(protocols);
            out.write("</module></workspace>");
            xmlResponse = sendRequest(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }

    public void saveGPIsToMV(int idModulo, Gpis gpis) throws MVException {
        BufferedReader xmlResponse = null;
        Writer out = new StringWriter();
        try {
            out.write("<workspace><module id=\""+idModulo+"\">");
            Marshaller mars = new Marshaller(out);
            mars.setMarshalAsDocument(false);
            mars.marshal(gpis);
            out.write("</module></workspace>");
            xmlResponse = sendRequest(out.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new MVException("I/O exception");
        } catch (MarshalException ex) {
            ex.printStackTrace();
            throw new MVException("Marshal error");
        } catch (ValidationException ex) {
            ex.printStackTrace();
            throw new MVException("Xml validation error");
        }
    }

    
}
