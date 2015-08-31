package controllori;

import bean.AspectRatio;
import bean.AudioSetup;
import bean.AudioSources;
import bean.CurrTime;
import bean.GpiInNameTable;
import bean.GpiInTaskTable;
import bean.GpiOutNameTable;
import bean.GpiOutTaskTable;
import bean.LiveRead;
import bean.Module;
import bean.ModuleValid;
import bean.NgmServer;
import bean.NgmServers;
import bean.NtpServer;
import bean.NtpServers;
import bean.ObjectZOrder;
import bean.Objects;
import bean.ObjectsZOrder;
import bean.Oggetto;
import bean.Port;
import bean.SagName;
import bean.SagPresets;
import bean.Screen;
import bean.SnmpMgr;
import bean.SnmpMgrs;
import bean.Source;
import bean.SysTime;
import bean.Valid;
import bean.VideoCards;
import bean.Workspace;
import bean.SnellRouter;
import bean.SnellController;
import bean.Router;
import eccezioni.CloneBeanException;
import eccezioni.CompareBeanException;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.components.JIDStringNode;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JList;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 *
 * @author Dio, io e porco...
 */
public class CtrlWorkspace {
    private static final String BEAN_PACKAGE = "bean";
    
    private static CtrlWorkspace instance = null;
    
    private Workspace config;
    private LiveRead liveRead;
    private UndoBuffer currentItem;    
    
    private HashMap<String,float []> sagPresets;

    private GpiInNameTable gpiInNameTable;
    private GpiInTaskTable gpiInTaskTable;
    private GpiOutNameTable gpiOutNameTable;
    private GpiOutTaskTable gpiOutTaskTable;
    
    private CtrlWorkspace() {
    }
    
    public static boolean compare(Object bean1, Object bean2) throws CompareBeanException {
        //Se i parametri attuali non appartengono entrambi al package dei beans -> lancio eccezione CompareBeanException
        if (!bean1.getClass().getPackage().getName().equals(BEAN_PACKAGE) || !bean2.getClass().getPackage().getName().equals(BEAN_PACKAGE)) {
            throw new CompareBeanException();
        }
        
        //Se i parametri attuali sono istanze di classi diverse -> ritorno false
        if (!bean1.getClass().equals(bean2.getClass())) {
            return false;
        }
        
        try {
            StringWriter writer1 = new StringWriter();
            StringWriter writer2 = new StringWriter();
            
            Marshaller mars = new Marshaller(writer1);
            mars.setMarshalAsDocument(false);
            mars.marshal(bean1);
            
            mars.setWriter(writer2);
            mars.setMarshalAsDocument(false);
            mars.marshal(bean2);
            
            return writer1.toString().equals(writer2.toString());
        } catch (Exception ex) {
            throw new CompareBeanException(ex.getMessage());
        } 
        
    }
    
    public static Object clone(Object bean) throws CloneBeanException {
        if (!bean.getClass().getPackage().getName().equals(BEAN_PACKAGE)) {
            throw new CloneBeanException();
        }
        try {
            StringWriter writer = new StringWriter();
            
            Marshaller mars = new Marshaller(writer);
            mars.setMarshalAsDocument(false);
            mars.marshal(bean);
            
            StringReader reader = new StringReader(writer.toString());
            return Unmarshaller.unmarshal(bean.getClass(), reader);
        } catch (Exception ex) {
            throw new CloneBeanException(ex.getMessage());
        }     
    }
    
    public void initUndoBuffer() {
        Module modulo = getModule(0);
        currentItem = new UndoBuffer();
        try {
            currentItem.setObjects((Objects)clone(modulo.getObjects()));
            currentItem.setObjectsZOrder((ObjectsZOrder) clone(modulo.getObjectsZOrder()));
            currentItem.setModuleValid((ModuleValid)clone(modulo.getModuleValid()));
        } catch (CloneBeanException ex) {
            System.out.println("Error initializing undo buffer");
        }
    }
    
    public boolean commitUndo(int idModulo){
        Module modulo = getModule(idModulo);
        boolean undoObjects;
        boolean undoZOrder;
        boolean undoValid;
        
        try {
            undoObjects = !compare(currentItem.getObjects(), modulo.getObjects());
        } catch (CompareBeanException ex) {
            undoObjects = false;
        }
        
        try {
            undoZOrder = !compare(currentItem.getObjectsZOrder(), modulo.getObjectsZOrder());
        } catch (CompareBeanException ex) {
            undoZOrder = false;
        }
        
        try {
            undoValid = !compare(currentItem.getModuleValid(), modulo.getModuleValid());
        } catch (CompareBeanException ex) {
            undoValid = false;
        }
        
        if (undoObjects || undoZOrder || undoValid) {
            UndoBuffer undoItem = new UndoBuffer();
            if (undoObjects) {
                Objects objs = null;
                try {
                    objs = (Objects)clone(modulo.getObjects());
                } catch (CloneBeanException cbe) {
                }
                undoItem.setObjects(objs);
            }
            if (undoZOrder) {
                ObjectsZOrder zOrder = null;
                try {
                    zOrder = (ObjectsZOrder)clone(modulo.getObjectsZOrder());
                } catch (CloneBeanException cbe) {
                }
                undoItem.setObjectsZOrder(zOrder);
            }
            if (undoValid) {
                ModuleValid moduleValid = null;
                try {
                    moduleValid = (ModuleValid)clone(modulo.getModuleValid());
                } catch (CloneBeanException cbe) {
                }
                undoItem.setModuleValid(moduleValid);
            }
            
            if (currentItem != null) {
                currentItem.add(undoItem);
            }
            currentItem = undoItem;
        }
        
        return undoObjects || undoZOrder || undoValid;
    }
    
    public void rollback(int idModulo){
        Objects objs = null;
        try {
            objs = (Objects)clone(currentItem.getObjects());
        } catch (CloneBeanException cbe) {
        }
        
        ObjectsZOrder zOrder = null;
        try {
            zOrder = (ObjectsZOrder)clone(currentItem.getObjectsZOrder());
        } catch (CloneBeanException cbe) {
        }
        
        ModuleValid moduleValid = null;
        try {
            moduleValid = (ModuleValid)clone(currentItem.getModuleValid());
        } catch (CloneBeanException cbe) {
        }
        
        setObjectsZOrder(idModulo,zOrder);
        setObjects(idModulo,objs);
        setModuleValid(idModulo, moduleValid);
    }
    
    public boolean canUndo() {
        return !currentItem.isFirst();
    }
    
    public boolean canRedo() {
        return !currentItem.isLast();
    }

    public boolean undo(int idModulo) {
        if (!canUndo())
            return false;
        
        Module modulo = getModule(idModulo);
        UndoBuffer undoItem = currentItem.getPrevious();
        
        try{
            clearWorkspace(idModulo);
        } catch (MVException mve) {
            return false;
        }
        
        Objects objs = null;
        try {
            objs = (Objects)clone(undoItem.getObjects());
        } catch (CloneBeanException cbe) {
            return false;
        }
        modulo.setObjects(objs);

        ObjectsZOrder zOrder = null;
        try {
            zOrder = (ObjectsZOrder)clone(undoItem.getObjectsZOrder());
        } catch (CloneBeanException cbe) {
            return false;
        }
        
        modulo.setObjectsZOrder(zOrder);
        currentItem = undoItem;
        return true;
    }
    
    public boolean redo(int idModulo) {
        if (!canRedo())
            return false;
        
        Module modulo = getModule(idModulo);
        UndoBuffer undoItem = currentItem.getNext();
        
        try{
            clearWorkspace(idModulo);
        } catch (MVException mve) {
            return false;
        }
        
        Objects objs = null;
        try {
            objs = (Objects)clone(undoItem.getObjects());
        } catch (CloneBeanException cbe) {
            return false;
        }
        modulo.setObjects(objs);

        ObjectsZOrder zOrder = null;
        try {
            zOrder = (ObjectsZOrder)clone(undoItem.getObjectsZOrder());
        } catch (CloneBeanException cbe) {
            return false;
        }
        
        modulo.setObjectsZOrder(zOrder);
        currentItem = undoItem;
        return true;
    }
    
    public void newLayout(int idModulo) throws MVException {
        CtrlProtocol.getInstance().renameLayout("", idModulo);
        
        Module modulo = getModule(idModulo);
        modulo.getModuleFilename().setVal("");
        
        clearWorkspace(idModulo);
        initUndoBuffer();
    }
    
    /* 
     * pulisce il workspace del client e del server
     */
    
    private void clearWorkspace(int idModulo) throws MVException {
        Module modulo = getModule(idModulo);
        
        Iterator it = modulo.getObjects().iterateOggetto();
        while (it.hasNext()) {
            CtrlProtocol.getInstance().cutOggetto((Oggetto)it.next());
        } 
        
        modulo.setObjects(new Objects());
        modulo.setObjectsZOrder(new ObjectsZOrder());
    }

    public void deleteLayout(int idModulo, String filename) throws MVException {
        CtrlProtocol.getInstance().deleteLayout(filename, idModulo);
    }
    
    public void saveLayout(int idModulo, String filename) throws MVException {
        CtrlProtocol controllore = CtrlProtocol.getInstance();
        config.getModule(idModulo).setModuleFilename(controllore.saveLayout(filename, idModulo));
    }
    
    public void loadLayout(int idModulo, String filename) throws MVException {
        CtrlProtocol controllore = CtrlProtocol.getInstance();
        config.setModule(idModulo, controllore.loadLayout(filename, idModulo));
        initUndoBuffer();
    }
    
    public void loadSourcesFromMV(int idModulo) throws MVException{
        CtrlProtocol controllore = CtrlProtocol.getInstance();
        this.getModule(idModulo).setSources(controllore.loadSourcesFromMV(idModulo));
    }
    
    public void loadObjectsFromMV(int idModulo) throws MVException{
        CtrlProtocol controllore = CtrlProtocol.getInstance();
        this.getModule(idModulo).setObjects(controllore.loadObjectsFromMV(idModulo));
    }
    
    public void loadObjectsZOrderFromMV(int idModulo) throws MVException{
        CtrlProtocol controllore = CtrlProtocol.getInstance();
        this.getModule(idModulo).setObjectsZOrder(controllore.loadObjectsZOrderFromMV(idModulo));
    }
    
    public Module getModule(int idModulo) {
        Iterator it = config.iterateModule();
        while (it.hasNext()) {
            Module mod = (Module)it.next();
            if (mod.getId()==idModulo)
                return mod;
        }
        return null;
    }
    
    public Module getLiveReadModule(int idModulo) {
        Iterator it = liveRead.iterateModule();
        while (it.hasNext()) {
            Module mod = (Module)it.next();
            if (mod.getId()==idModulo)
                return mod;
        }
        return null;
    }
    
    public Oggetto getLiveReadOggetto(int idModulo, int idOggetto) {
        Module module = getLiveReadModule(idModulo);
        Iterator it = module.getObjects().iterateOggetto();
        while (it.hasNext()) {
            Oggetto obj = (Oggetto)it.next();
            if (obj.getId()==idOggetto)
                return obj;
        }
        return null;
    }

    public Oggetto getOggetto(int idModulo, int idOggetto) {
        Module module = this.getModule(idModulo);
        Iterator it = module.getObjects().iterateOggetto();
        while (it.hasNext()) {
            Oggetto obj = (Oggetto)it.next();
            if (obj.getId()==idOggetto)
                return obj;
        }
        return null;
    }


    
    public int getIdOggettoBySource(int idModulo, int idSource){
        Module module = this.getModule(idModulo);
        Iterator it = module.getObjects().iterateOggetto();
        while (it.hasNext()) {
            Oggetto obj = (Oggetto)it.next();
            String sourcestr = obj.getObjectSequence().getVidAudProperties().getVidAudSource().getVal();
            int idSorgente = Integer.valueOf(sourcestr.replaceAll("Source ","").trim());
            if (idSorgente==idSource)
                return obj.getId();
        }
        return -1;
    }
    
    public TreeModel getTreeModel(int idModulo){
        
        JIDStringNode root = null;
        JIDStringNode oggetti = null;
        JIDStringNode oggetto = null;
        JIDStringNode sorgenti = null;
        JIDStringNode layouts = null;
        
        //String [] oggVecStr = null;
        
    
        root = new JIDStringNode("-_-");
        oggetti = new JIDStringNode("Objects");
        if (CtrlWorkspace.getInstance().getProductType(idModulo) != ProductType.ProductTypeAM)
            sorgenti = new JIDStringNode("Sources");
        layouts = new JIDStringNode("Layouts");
        
        
        root.add(oggetti);
        if (sorgenti != null)
            root.add(sorgenti);
        root.add(layouts);

        Iterator iter = this.getModule(idModulo).getObjects().iterateOggetto();
        ArrayList sourceOccupati = new ArrayList();
        
        while (iter.hasNext()){
            Oggetto current = (Oggetto)iter.next();
            oggetto = new JIDStringNode(current.getId(),"Object "+current.getId()+" ("+current.getUsername().getVal()+")");
            oggetti.add(oggetto);
            if (current.getType().getVal().equals("Video") || current.getType().getVal().equals("Audio"))
                sourceOccupati.add(current.getObjectSequence().getVidAudProperties().getVidAudSource().getVal());
        }
        
        if (sorgenti != null) {
            iter = this.getModule(idModulo).getSources().iterateSource();
            while (iter.hasNext()){
                //sorgente = tipo + username + numero
                Source src = (Source)iter.next();
                String sorgente = "["+src.getType().getVal()+"] "+ ((src.getUsername().getVal().equals(""))?"Source "+src.getId():src.getUsername().getVal()+" ("+src.getId()+")");
                int status = 0;
                if (sourceOccupati.contains("Source "+src.getId()+" "))
                    status = 1;
                oggetto = new JIDStringNode(src.getId(),sorgente, status);
                sorgenti.add(oggetto);
            }
        }
        
        try {
            //fa schifo però è per fare prima
            JList filenameList = ComponentFactory.createList(config.getModule(idModulo).getModuleFilename().getOptionsName(), config.getModule(idModulo).getModuleFilename().getVal(), true);
            for ( int l = 0; l < filenameList.getModel().getSize(); l++){
                String testo = filenameList.getModel().getElementAt(l).toString();
                int status = 0;
                
                if(config.getModule(idModulo).getModuleFilename().getVal().equals(testo)){
                    //System.out.println(config.getModule(idModulo).getModuleFilename().getVal() + "--" +testo);
                    status = 2;
                }
                oggetto = new JIDStringNode(l,testo,status);
                layouts.add(oggetto);
            }
        } catch (MVException ex) {

        }

        DefaultTreeModel dm = new DefaultTreeModel(root);
        
        
        return dm;
    
    }
    
    public void replaceOggetto(int idModulo, Oggetto source, Oggetto dest){
        Oggetto [] vetOggetti = config.getModule(idModulo).getObjects().getOggetto();
        for (int i=0; i < vetOggetti.length;  i++){
            if(vetOggetti[i].equals(dest)){
                config.getModule(idModulo).getObjects().setOggetto(i, source);
                break;
            }
        }
    }
    
    private Objects getObjects(int idModulo){
        Module mod = getModule(idModulo);
        assert mod!=null;
        return mod.getObjects();
    }
    
    public Objects getObjects(int idModulo, int screen) {
        Objects objs = new Objects();
        
        Module mod = getModule(idModulo);
        assert mod!=null;
             
        Iterator it = mod.getObjects().iterateOggetto();
        while (it.hasNext()) {
            Oggetto current = (Oggetto)it.next();
            if (current.getObjectScreen().getVal()==screen || (current.getType().getVal().equals("Video") && current.getObjectSequence().getVideoProperties().getDisplayOnAllScreens().getVal()))
                objs.addOggetto(current);
        }
        return objs;
    }
   
    public ObjectsZOrder getObjectsZOrder(int idModulo, int idScreen) {

        ObjectsZOrder oggetZorder = new ObjectsZOrder();

        Module mod = getModule(idModulo);
        if (mod == null) {
            return null;
        }

        Iterator it = mod.getObjectsZOrder().iterateObjectZOrder();
        while (it.hasNext()) {
            ObjectZOrder current = (ObjectZOrder)it.next();
            if ( this.getOggetto(idModulo, current.getId()).getObjectScreen().getVal() == idScreen 
                    || (this.getOggetto(idModulo, current.getId()).getType().getVal().equals("Video") && this.getOggetto(idModulo, current.getId()).getObjectSequence().getVideoProperties().getDisplayOnAllScreens().getVal()))
                oggetZorder.addObjectZOrder(current);
        }


        return oggetZorder;
    }

    public Objects getLiveReadObjects(int idModulo, int screen) {
        Objects objs = new Objects();

        Module mod = getLiveReadModule(idModulo);
        assert mod!=null;

        Iterator it = mod.getObjects().iterateOggetto();
        while (it.hasNext()) {
            Oggetto current = (Oggetto)it.next();
            if (current.getObjectScreen().getVal()==screen || (current.getType().getVal().equals("Video") && current.getObjectSequence().getVideoProperties().getDisplayOnAllScreens().getVal()))
                objs.addOggetto(current);
        }
        return objs;
    }

    public ObjectsZOrder getLiveReadObjectsZOrder(int idModulo, int idScreen) {

        ObjectsZOrder oggetZorder = new ObjectsZOrder();

        Module mod = getLiveReadModule(idModulo);
        if (mod == null) {
            return null;
        }

        Iterator it = mod.getObjectsZOrder().iterateObjectZOrder();
        while (it.hasNext()) {
            ObjectZOrder current = (ObjectZOrder)it.next();
            if ( this.getLiveReadOggetto(idModulo, current.getId()).getObjectScreen().getVal() == idScreen
                    || (this.getLiveReadOggetto(idModulo, current.getId()).getType().getVal().equals("Video") && this.getLiveReadOggetto(idModulo, current.getId()).getObjectSequence().getVideoProperties().getDisplayOnAllScreens().getVal()))
                oggetZorder.addObjectZOrder(current);
        }


        return oggetZorder;
    }

    public Source getSource(int idModulo, int idSource) {
        Module mod = getModule(idModulo);
        if (mod==null)
            return null;
                     
        Iterator it = mod.getSources().iterateSource();
        while (it.hasNext()) {
            Source src = (Source)it.next();
            if (src.getId()==idSource)
                return src;
        }
        return null;
    }
    
    public VideoCards getVideoCards(int idModulo) {
        Module mod = getModule(idModulo);
        if (mod==null)
            return null;
        
        return mod.getVideoCards();
    }

    public AudioSetup getAudioSetup(int idModulo) {
        Module mod = getModule(idModulo);
        if (mod==null)
            return null;

        return mod.getAudioSetup();
    }
    
    public AudioSources getAudioSources(int idModulo) {
        Module mod = getModule(idModulo);
        if (mod==null) {
            return null;
        }
        return mod.getAudioSources();
    }
    
    public Router getRouter(int idModulo, int idRouter) {
        Module mod = getModule(idModulo);
        if (mod == null)
            return null;
        if (idRouter < 0)
            if (mod.getRouters().getRouterCount() == 0)
                return null;
            else
                return mod.getRouters().getRouter(0);
        for (int i = 0; i < mod.getRouters().getRouterCount(); i++)
            if (mod.getRouters().getRouter(i).getId() == idRouter)
                return mod.getRouters().getRouter(i);
        return null;
    }
    
    public boolean areAnyRoutersAvail(int idModulo) {
        Module mod = getModule(idModulo);
        if (mod == null)
            return false;
        return (mod.getRouters().getRouterCount() > 0);
    }
    
    public String getProductTypeCode(int idModulo) {
        Module mod = getModule(idModulo);
        if (mod == null)
            return "MV";
        String type = mod.getProduct().getType();
        if (type == null)
            return "MV";
        return type;
    }
    
    public ProductType getProductType(int idModulo) {
        String pt = getProductTypeCode(idModulo);
        if (pt.equals("AM"))
            return ProductType.ProductTypeAM;
        return ProductType.ProductTypeMV;
    }

    public void loadConfigFromMV() throws MVException {
        //try {
        CtrlProtocol controllore = CtrlProtocol.getInstance();
        config = controllore.loadConfigurationFromMV();
    // } catch (MVException ex) {


    //System.exit(0);
    //Logger.getLogger(testCastor.class.getName()).log(Level.SEVERE, null, ex);
    //}
    }

    public void getLayoutFromMV(int idModulo) throws MVException {
    
        CtrlProtocol controllore = CtrlProtocol.getInstance();
        config = controllore.read(idModulo);
    
    }
    
    public void loadInvalidFromMV(int idModulo) throws MVException{
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        Iterator it = this.getObjects(idModulo).iterateOggetto();
        while (it.hasNext()) {
            Oggetto obj = (Oggetto)it.next();
            obj.setValid(ctrlProtocol.queryValidObject(obj.getId(), idModulo));
        }
        this.getModule(idModulo).setModuleValid(ctrlProtocol.queryValidModule(idModulo));
    }
    
    //controlla  se oggetti invalidi  sono divenuti validi
    public void checkInvalidObjectsFromMV(int idModulo) throws MVException{
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        Iterator it = this.getObjects(idModulo).iterateOggetto();
        while (it.hasNext()) {
            Oggetto obj = (Oggetto)it.next();
            if(!obj.getValid().getVal())
                obj.setValid(ctrlProtocol.queryValidObject(obj.getId(), idModulo));
        }
        this.getModule(idModulo).setModuleValid(ctrlProtocol.queryValidModule(idModulo));
    }

    public void loadObjectAspectRatio(int idModulo, int idOggetto) {
        try {
            AspectRatio ar = CtrlProtocol.getInstance().queryAspectRatio(idOggetto, idModulo);
            //SSSSecco. Per extx exty
            getOggetto(idModulo, idOggetto).setAspectRatio(ar);

        } catch (MVException ex) {
            ex.printStackTrace();
        }

    }
    
    public void saveObjectToMV(int idModulo, Oggetto bean) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        Workspace workspace = ctrlProtocol.saveObjectToMV(idModulo, bean);
        //SSSSecco. Per extx exty
        bean.setAspectRatio(workspace.getModule(0).getObjects().getOggetto(0).getAspectRatio());
        Valid validoMV = workspace.getModule(0).getObjects().getOggetto(0).getValid();

        if (!validoMV.getVal() || this.getOggetto(idModulo, bean.getId()).getValid().getVal()!=validoMV.getVal())
            loadInvalidFromMV(idModulo);
    }
    
    public void saveSourceAssignedToObjectToMV(int idModulo, Oggetto bean) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveSourceAssignedToObjectToMV(idModulo, bean);
        
    }
    
    public void saveSourceToMV(int idModulo, Source bean) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveSourceToMV(idModulo, bean);
    }
    
    public void saveSourcesUsernameToMV(int idModulo) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveSourcesUsernameToMV(idModulo, getModule(idModulo).getSources());
    }
    
    public void saveObjectsToMV(int idModulo) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveObjectsToMV(this.getModule(idModulo));
    }
    
    public void saveObjectsZOrderToMV(int idModulo) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveObjectsZOrderToMV(this.getModule(idModulo));
    }

    public void saveConfigToMV() throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveConfigurationToMV(config);
    }
    
    public void saveAudioMonitorToMV(int idModulo) throws MVException{
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveAudioMonitorToMV(idModulo, this.getModule(idModulo).getAudioMonitor());
    }
    
    public void saveEmbeddedAudioMonitorToMV(int idModulo) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveEmbeddedAudioMonitorToMV(idModulo, this.getModule(idModulo).getEmbAudioOut());
    }

    public void saveAudioSetupToMV(int idModulo) throws MVException{
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveAudioSetupToMV(idModulo, this.getModule(idModulo).getAudioSetup());
    }

    public void saveAudioOutputToMV(int idModulo) throws MVException{
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveAudioOutputToMV(idModulo, this.getModule(idModulo).getAudioOut());
    }

    //bug #141  i gpiOut vengono gestiti come i gpiIn, quindi stanno dentro GPIS
//    public void saveGPOAlarmOutToMV(int idModulo) throws MVException{
//        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
//        ctrlProtocol.saveGPOAlarmOutToMV(idModulo, this.getModule(idModulo).getAlarmOut());
//    }
        
    /*
     * invia le proprietà modules.screen al multiviewer, legge lo screen ritornato dal multiviewer, e lo setta nel modulo
     */
    public void saveScreenToMV(int idModulo) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        Screen scr = ctrlProtocol.saveScreenToMV(idModulo, getModule(idModulo).getScreen());
        getModule(idModulo).setScreen(scr);
    }
    
    public SysTime loadSysTimeFromMV(int idModulo) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        SysTime sysTime = ctrlProtocol.loadSysTimeFromMV(idModulo);
        getModule(idModulo).setSysTime(sysTime);
        return sysTime;
    }
    
    public void saveSysTimeToMV(int idModulo) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveSysTimeToMV(idModulo, getModule(idModulo).getSysTime());
    }
    
    public void saveCurrentTimeToMV(int idModulo) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveCurrentTimeToMV(idModulo, getModule(idModulo).getSysTime().getCurrTime());
    }
    
    public CurrTime loadCurrentTimeFromMV(int idModulo) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        CurrTime currTime = ctrlProtocol.loadCurrentTimeFromMV(idModulo);
        getModule(idModulo).getSysTime().setCurrTime(currTime);
        return currTime;
    }
    
    public void addNtpServerToMV(int idModulo, NtpServer bean) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        NtpServers ntpServers = ctrlProtocol.addNtpServerToMV(idModulo, bean.getVal());
        getModule(idModulo).getSysTime().setNtpServers(ntpServers);
    }
    
    public void removeNtpServerFromMV(int idModulo, int ntpServerId) throws MVException {
        NtpServers ntpServers  = this.getModule(idModulo).getSysTime().getNtpServers();
        NtpServer toRemove = null;
        
        for (int i = 0; i < ntpServers.getNtpServerCount() && toRemove == null ; i++) {
            if (ntpServers.getNtpServer(i).getId()==ntpServerId) {
                toRemove = ntpServers.getNtpServer(i);
            }
        }
        
        if (toRemove == null) 
            throw new MVException("NTP Server not found in list");
        
        CtrlProtocol.getInstance().removeNtpServerFromMV(idModulo, ntpServerId);
        ntpServers.removeNtpServer(toRemove);
    }
    
    public static synchronized CtrlWorkspace getInstance() {
        if (instance == null) {
            try {
                instance = new CtrlWorkspace();
                instance.loadConfigFromMV();
                instance.loadLiveReadFromMV(0);
                instance.initUndoBuffer();
            } catch (MVException ex) {
                ex.printStackTrace();
                instance = null;
                return null;
            }
        }


        return instance;
    }

    //aggiunge oggetto al workspace 
    
    
    public void addObject(int idModulo, Oggetto bean) {
        this.getModule(idModulo).getObjects().addOggetto(bean);
    }

    //toglie un oggetto dal workspace
    public void cutObject(int idModulo, Oggetto bean) throws MVException {
        this.getModule(idModulo).getObjects().removeOggetto(bean);
        //check se ho risolto una situazione di  non validità del modulo
        if(!this.getModule(idModulo).getModuleValid().getVal())
            checkInvalidObjectsFromMV(idModulo);
    }
    
    //setta l'objectsZOrder che contiene l'ordine di visualizzazione degli oggetti
    public void setObjectsZOrder(int idModulo, ObjectsZOrder bean){
        this.getModule(idModulo).setObjectsZOrder(bean);
    }
    
    /*Invia il comando per aggiungere il nuovo server snmp al MultiViewer e lo aggiunge anche alla configurazione locale
     * 
     *N.B.: Nella lista dei server snmp ogni record è identificato da un id univoco gestito dal multiviewer,
     *  quindi nella configurazione locale inserisco l'oggetto SnmpMgr che il Multiviewer mi restituirà corredato di id univoco
    */
    public void addSnmpMgr(int idModulo, String snmpMgrIp) throws MVException {
        SnmpMgr newSnmpMgr = CtrlProtocol.getInstance().addSnmpMgr(idModulo, snmpMgrIp);
        this.getModule(idModulo).getNetwork().getSnmpMgrs().addSnmpMgr(newSnmpMgr);
    }
    
    public void removeSnmpMgr(int idModulo, String snmpMgrIp) throws MVException {
        SnmpMgrs snmpMgrs  = this.getModule(idModulo).getNetwork().getSnmpMgrs();
        SnmpMgr toRemove = null;
        
        for (int i = 0; i < snmpMgrs.getSnmpMgrCount() && toRemove == null ; i++) {
            if (snmpMgrs.getSnmpMgr(i).getVal().equals(snmpMgrIp)) {
                toRemove = snmpMgrs.getSnmpMgr(i);
            }
        }
        
        if (toRemove == null) 
            throw new MVException("SNMP Server not found in list");
        
        CtrlProtocol.getInstance().removeSnmpMgr(idModulo, toRemove.getId());
        snmpMgrs.removeSnmpMgr(toRemove);
    }
    
    public NgmServer newNgm164Server(int idModulo) throws MVException {
        NgmServer newNgmServer = CtrlProtocol.getInstance().newNgm164Server(idModulo);
        if (newNgmServer.getAlias().getVal().equals("")) {
            newNgmServer.getAlias().setVal("audio-server-"+newNgmServer.getId());
            saveNgm164ServerToMV(idModulo, newNgmServer);
        }
        
        this.getModule(idModulo).getNgmServers().addNgmServer(newNgmServer);
        return newNgmServer;
    }
    
    public void removeNgm164Server(int idModulo, int ngmServerId) throws MVException {
        NgmServers ngmServers  = this.getModule(idModulo).getNgmServers();
        NgmServer toRemove = null;
        
        for (int i = 0; i < ngmServers.getNgmServerCount() && toRemove == null ; i++) {
            if (ngmServers.getNgmServer(i).getId()==ngmServerId) {
                toRemove = ngmServers.getNgmServer(i);
            }
        }
        
        if (toRemove == null) 
            throw new MVException("NGM-164 Server not found in list");
        
        CtrlProtocol.getInstance().removeNgmServer(idModulo, ngmServerId);
        ngmServers.removeNgmServer(toRemove);
    }
    
    public void saveNgm164ServerToMV (int idModulo, NgmServer ngmServer) throws MVException {
        NgmServer newNgmServer = CtrlProtocol.getInstance().saveNgm164ServerToMV(idModulo, ngmServer);
    }
    
    public void saveNetworkToMV(int idModulo, boolean commit) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveNetworkToMV(idModulo, this.getModule(idModulo).getNetwork());
        if (commit)
            ctrlProtocol.commitNetworkSettings(idModulo);
    }
    
    public SnellController newSnellController(int idModulo) throws MVException {
    	SnellController newSnellController = CtrlProtocol.getInstance().newSnellController(idModulo);
        
        this.getModule(idModulo).getProtocols().getSnellRouter().addSnellController(newSnellController);
        return newSnellController;
    }

    public void removeSnellController(int idModulo, int snellControllerId) throws MVException {
        SnellRouter snellRouter  = this.getModule(idModulo).getProtocols().getSnellRouter();
        SnellController toRemove = null;
        
        for (int i = 0; i < snellRouter.getSnellControllerCount() && toRemove == null ; i++) {
            if (snellRouter.getSnellController(i).getId()==snellControllerId) {
                toRemove = snellRouter.getSnellController(i);
            }
        }
        
        if (toRemove == null) 
            throw new MVException("Snell controller not found in list");
        
        CtrlProtocol.getInstance().removeSnellController(idModulo, snellControllerId);
        snellRouter.removeSnellController(toRemove);
    }

    public void saveSnellControllerToMV (int idModulo, SnellController snellController) throws MVException {
    	SnellController newSnellController = CtrlProtocol.getInstance().saveSnellControllerToMV(idModulo, snellController);
    }
    
    private void setObjects(int idModulo, Objects bean){
        this.getModule(idModulo).setObjects(bean);
    }
    
    private void setModuleValid(int idModulo, ModuleValid bean){
        this.getModule(idModulo).setModuleValid(bean);
    }
    
    public float [] getSagBorders(String key) throws MVException{
        if (sagPresets == null){
            
            SagPresets sp = CtrlProtocol.getInstance().querySagPresets();
            sagPresets = new HashMap<String, float []>();
            Iterator iterator =  sp.iterateSagName();
            while (iterator.hasNext()){
                SagName sagName = (SagName)iterator.next();
                sagPresets.put(sagName.getVal(), new float [] {sagName.getHborder(), sagName.getVborder()});
            }
            
        }
        return sagPresets.get(key);
    }

    public GpiInNameTable getGpiInNameTable (String optionName, int idModulo) throws MVException {
        //if (gpiInNameTable == null){
            gpiInNameTable = CtrlProtocol.getInstance().queryGpiInNameTable(optionName, idModulo);
        //}
        return gpiInNameTable;
    }

    public GpiInTaskTable getGpiInTaskTable (String optionName, int idModulo) throws MVException {
        //if (gpiInTaskTable == null){
            gpiInTaskTable = CtrlProtocol.getInstance().queryGpiInTaskTable(optionName, idModulo);
        //}
        return gpiInTaskTable;
    }

    public GpiOutNameTable getGpiOutNameTable (String optionName, int idModulo) throws MVException {
        //if (gpiInNameTable == null){
            gpiOutNameTable = CtrlProtocol.getInstance().queryGpiOutNameTable(optionName, idModulo);
        //}
        return gpiOutNameTable;
    }

    public GpiOutTaskTable getGpiOutTaskTable (String optionName, int idModulo) throws MVException {
        //if (gpiInTaskTable == null){
            gpiOutTaskTable = CtrlProtocol.getInstance().queryGpiOutTaskTable(optionName, idModulo);
        //}
        return gpiOutTaskTable;
    }

    public void saveProtocolsToMV(int idModulo) throws MVException{
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveProtocolsToMV(idModulo, this.getModule(idModulo).getProtocols());
    }

    public void savePortToMV(int idModulo, Port port) throws MVException {
        CtrlProtocol.getInstance().savePortToMV(idModulo, port);
    }

    public void saveGPIsToMV(int idModulo) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveGPIsToMV(idModulo, this.getModule(idModulo).getGpis());
    }

    public void loadLiveReadFromMV(int idModulo) throws MVException {
        CtrlProtocol controllore = CtrlProtocol.getInstance();
        liveRead = controllore.queryLiveRead(idModulo);
    }

    public void copyConfigToLiveReadObjects() {
        liveRead.removeAllModule();
        Iterator<Module> itModule = config.iterateModule();
        while (itModule.hasNext()) {
            Module module = itModule.next();
            Module newModule = new Module();
            newModule.setId(module.getId());
            newModule.setObjects(module.getObjects());
            newModule.setObjectsZOrder(module.getObjectsZOrder());
            liveRead.addModule(newModule);

        }
    }
    
    public void saveRouterOut(int idModulo, int idRouter, int out, int in) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.saveRouterOut(idModulo, idRouter, out, in);
    }
    
    public Router loadRouter(int idModulo, int idRouter) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        return ctrlProtocol.loadRouter(idModulo, idRouter);
    }
    
    public void sendTimerAction(int idModulo, int idTile, String strAction, String extraAttr) throws MVException {
        CtrlProtocol ctrlProtocol = CtrlProtocol.getInstance();
        ctrlProtocol.sendTimerAction(idModulo, idTile, strAction, extraAttr);
    }

//    public Source getSourceBySourceName(int idModulo, String sourceName) {
//
//        Iterator<Source> itSource = config.getModule(idModulo).getSources().iterateSource();
//        while (itSource.hasNext()){
//            Source src = itSource.next();
//            if(src.get)
//        }
//    }
}
