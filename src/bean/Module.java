/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.2</a>, using an XML
 * Schema.
 * $Id$
 */

package bean;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Module.
 * 
 * @version $Revision$ $Date$
 */
public class Module implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id.
     */
    private int _id;

    /**
     * keeps track of state for field: _id
     */
    private boolean _has_id;

    /**
     * Field _videoCards.
     */
    private bean.VideoCards _videoCards;

    /**
     * Field _sources.
     */
    private bean.Sources _sources;

    /**
     * Field _audioSources.
     */
    private bean.AudioSources _audioSources;

    /**
     * Field _objects.
     */
    private bean.Objects _objects;

    /**
     * Field _objectsZOrder.
     */
    private bean.ObjectsZOrder _objectsZOrder;

    /**
     * Field _optionsList.
     */
    private bean.OptionsList _optionsList;

    /**
     * Field _moduleFilename.
     */
    private bean.ModuleFilename _moduleFilename;

    /**
     * Field _layout.
     */
    private bean.Layout _layout;

    /**
     * Field _moduleValid.
     */
    private bean.ModuleValid _moduleValid;

    /**
     * Field _screen.
     */
    private bean.Screen _screen;

    /**
     * Field _audioMonitor.
     */
    private bean.AudioMonitor _audioMonitor;

    /**
     * Field _audioOut.
     */
    private bean.AudioOut _audioOut;

    /**
     * Field _network.
     */
    private bean.Network _network;

    /**
     * Field _ngmServers.
     */
    private bean.NgmServers _ngmServers;

    /**
     * Field _remoteControl.
     */
    private bean.RemoteControl _remoteControl;

    /**
     * Field _product.
     */
    private bean.Product _product;

    /**
     * Field _sysTime.
     */
    private bean.SysTime _sysTime;

    /**
     * Field _sagPresets.
     */
    private bean.SagPresets _sagPresets;

    /**
     * Field _protocols.
     */
    private bean.Protocols _protocols;

    /**
     * Field _gpis.
     */
    private bean.Gpis _gpis;

    /**
     * Field _gpiInNameTable.
     */
    private bean.GpiInNameTable _gpiInNameTable;

    /**
     * Field _gpiInTaskTable.
     */
    private bean.GpiInTaskTable _gpiInTaskTable;

    /**
     * Field _gpiOutNameTable.
     */
    private bean.GpiOutNameTable _gpiOutNameTable;

    /**
     * Field _gpiOutTaskTable.
     */
    private bean.GpiOutTaskTable _gpiOutTaskTable;

    /**
     * Field _audioSetup.
     */
    private bean.AudioSetup _audioSetup;

    /**
     * Field _frontButton.
     */
    private bean.FrontButton _frontButton;


      //----------------/
     //- Constructors -/
    //----------------/

    public Module() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteId(
    ) {
        this._has_id= false;
    }

    /**
     * Returns the value of field 'audioMonitor'.
     * 
     * @return the value of field 'AudioMonitor'.
     */
    public bean.AudioMonitor getAudioMonitor(
    ) {
        return this._audioMonitor;
    }

    /**
     * Returns the value of field 'audioOut'.
     * 
     * @return the value of field 'AudioOut'.
     */
    public bean.AudioOut getAudioOut(
    ) {
        return this._audioOut;
    }

    /**
     * Returns the value of field 'audioSetup'.
     * 
     * @return the value of field 'AudioSetup'.
     */
    public bean.AudioSetup getAudioSetup(
    ) {
        return this._audioSetup;
    }

    /**
     * Returns the value of field 'audioSources'.
     * 
     * @return the value of field 'AudioSources'.
     */
    public bean.AudioSources getAudioSources(
    ) {
        return this._audioSources;
    }

    /**
     * Returns the value of field 'frontButton'.
     * 
     * @return the value of field 'FrontButton'.
     */
    public bean.FrontButton getFrontButton(
    ) {
        return this._frontButton;
    }

    /**
     * Returns the value of field 'gpiInNameTable'.
     * 
     * @return the value of field 'GpiInNameTable'.
     */
    public bean.GpiInNameTable getGpiInNameTable(
    ) {
        return this._gpiInNameTable;
    }

    /**
     * Returns the value of field 'gpiInTaskTable'.
     * 
     * @return the value of field 'GpiInTaskTable'.
     */
    public bean.GpiInTaskTable getGpiInTaskTable(
    ) {
        return this._gpiInTaskTable;
    }

    /**
     * Returns the value of field 'gpiOutNameTable'.
     * 
     * @return the value of field 'GpiOutNameTable'.
     */
    public bean.GpiOutNameTable getGpiOutNameTable(
    ) {
        return this._gpiOutNameTable;
    }

    /**
     * Returns the value of field 'gpiOutTaskTable'.
     * 
     * @return the value of field 'GpiOutTaskTable'.
     */
    public bean.GpiOutTaskTable getGpiOutTaskTable(
    ) {
        return this._gpiOutTaskTable;
    }

    /**
     * Returns the value of field 'gpis'.
     * 
     * @return the value of field 'Gpis'.
     */
    public bean.Gpis getGpis(
    ) {
        return this._gpis;
    }

    /**
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'Id'.
     */
    public int getId(
    ) {
        return this._id;
    }

    /**
     * Returns the value of field 'layout'.
     * 
     * @return the value of field 'Layout'.
     */
    public bean.Layout getLayout(
    ) {
        return this._layout;
    }

    /**
     * Returns the value of field 'moduleFilename'.
     * 
     * @return the value of field 'ModuleFilename'.
     */
    public bean.ModuleFilename getModuleFilename(
    ) {
        return this._moduleFilename;
    }

    /**
     * Returns the value of field 'moduleValid'.
     * 
     * @return the value of field 'ModuleValid'.
     */
    public bean.ModuleValid getModuleValid(
    ) {
        return this._moduleValid;
    }

    /**
     * Returns the value of field 'network'.
     * 
     * @return the value of field 'Network'.
     */
    public bean.Network getNetwork(
    ) {
        return this._network;
    }

    /**
     * Returns the value of field 'ngmServers'.
     * 
     * @return the value of field 'NgmServers'.
     */
    public bean.NgmServers getNgmServers(
    ) {
        return this._ngmServers;
    }

    /**
     * Returns the value of field 'objects'.
     * 
     * @return the value of field 'Objects'.
     */
    public bean.Objects getObjects(
    ) {
        return this._objects;
    }

    /**
     * Returns the value of field 'objectsZOrder'.
     * 
     * @return the value of field 'ObjectsZOrder'.
     */
    public bean.ObjectsZOrder getObjectsZOrder(
    ) {
        return this._objectsZOrder;
    }

    /**
     * Returns the value of field 'optionsList'.
     * 
     * @return the value of field 'OptionsList'.
     */
    public bean.OptionsList getOptionsList(
    ) {
        return this._optionsList;
    }

    /**
     * Returns the value of field 'product'.
     * 
     * @return the value of field 'Product'.
     */
    public bean.Product getProduct(
    ) {
        return this._product;
    }

    /**
     * Returns the value of field 'protocols'.
     * 
     * @return the value of field 'Protocols'.
     */
    public bean.Protocols getProtocols(
    ) {
        return this._protocols;
    }

    /**
     * Returns the value of field 'remoteControl'.
     * 
     * @return the value of field 'RemoteControl'.
     */
    public bean.RemoteControl getRemoteControl(
    ) {
        return this._remoteControl;
    }

    /**
     * Returns the value of field 'sagPresets'.
     * 
     * @return the value of field 'SagPresets'.
     */
    public bean.SagPresets getSagPresets(
    ) {
        return this._sagPresets;
    }

    /**
     * Returns the value of field 'screen'.
     * 
     * @return the value of field 'Screen'.
     */
    public bean.Screen getScreen(
    ) {
        return this._screen;
    }

    /**
     * Returns the value of field 'sources'.
     * 
     * @return the value of field 'Sources'.
     */
    public bean.Sources getSources(
    ) {
        return this._sources;
    }

    /**
     * Returns the value of field 'sysTime'.
     * 
     * @return the value of field 'SysTime'.
     */
    public bean.SysTime getSysTime(
    ) {
        return this._sysTime;
    }

    /**
     * Returns the value of field 'videoCards'.
     * 
     * @return the value of field 'VideoCards'.
     */
    public bean.VideoCards getVideoCards(
    ) {
        return this._videoCards;
    }

    /**
     * Method hasId.
     * 
     * @return true if at least one Id has been added
     */
    public boolean hasId(
    ) {
        return this._has_id;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'audioMonitor'.
     * 
     * @param audioMonitor the value of field 'audioMonitor'.
     */
    public void setAudioMonitor(
            final bean.AudioMonitor audioMonitor) {
        this._audioMonitor = audioMonitor;
    }

    /**
     * Sets the value of field 'audioOut'.
     * 
     * @param audioOut the value of field 'audioOut'.
     */
    public void setAudioOut(
            final bean.AudioOut audioOut) {
        this._audioOut = audioOut;
    }

    /**
     * Sets the value of field 'audioSetup'.
     * 
     * @param audioSetup the value of field 'audioSetup'.
     */
    public void setAudioSetup(
            final bean.AudioSetup audioSetup) {
        this._audioSetup = audioSetup;
    }

    /**
     * Sets the value of field 'audioSources'.
     * 
     * @param audioSources the value of field 'audioSources'.
     */
    public void setAudioSources(
            final bean.AudioSources audioSources) {
        this._audioSources = audioSources;
    }

    /**
     * Sets the value of field 'frontButton'.
     * 
     * @param frontButton the value of field 'frontButton'.
     */
    public void setFrontButton(
            final bean.FrontButton frontButton) {
        this._frontButton = frontButton;
    }

    /**
     * Sets the value of field 'gpiInNameTable'.
     * 
     * @param gpiInNameTable the value of field 'gpiInNameTable'.
     */
    public void setGpiInNameTable(
            final bean.GpiInNameTable gpiInNameTable) {
        this._gpiInNameTable = gpiInNameTable;
    }

    /**
     * Sets the value of field 'gpiInTaskTable'.
     * 
     * @param gpiInTaskTable the value of field 'gpiInTaskTable'.
     */
    public void setGpiInTaskTable(
            final bean.GpiInTaskTable gpiInTaskTable) {
        this._gpiInTaskTable = gpiInTaskTable;
    }

    /**
     * Sets the value of field 'gpiOutNameTable'.
     * 
     * @param gpiOutNameTable the value of field 'gpiOutNameTable'.
     */
    public void setGpiOutNameTable(
            final bean.GpiOutNameTable gpiOutNameTable) {
        this._gpiOutNameTable = gpiOutNameTable;
    }

    /**
     * Sets the value of field 'gpiOutTaskTable'.
     * 
     * @param gpiOutTaskTable the value of field 'gpiOutTaskTable'.
     */
    public void setGpiOutTaskTable(
            final bean.GpiOutTaskTable gpiOutTaskTable) {
        this._gpiOutTaskTable = gpiOutTaskTable;
    }

    /**
     * Sets the value of field 'gpis'.
     * 
     * @param gpis the value of field 'gpis'.
     */
    public void setGpis(
            final bean.Gpis gpis) {
        this._gpis = gpis;
    }

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(
            final int id) {
        this._id = id;
        this._has_id = true;
    }

    /**
     * Sets the value of field 'layout'.
     * 
     * @param layout the value of field 'layout'.
     */
    public void setLayout(
            final bean.Layout layout) {
        this._layout = layout;
    }

    /**
     * Sets the value of field 'moduleFilename'.
     * 
     * @param moduleFilename the value of field 'moduleFilename'.
     */
    public void setModuleFilename(
            final bean.ModuleFilename moduleFilename) {
        this._moduleFilename = moduleFilename;
    }

    /**
     * Sets the value of field 'moduleValid'.
     * 
     * @param moduleValid the value of field 'moduleValid'.
     */
    public void setModuleValid(
            final bean.ModuleValid moduleValid) {
        this._moduleValid = moduleValid;
    }

    /**
     * Sets the value of field 'network'.
     * 
     * @param network the value of field 'network'.
     */
    public void setNetwork(
            final bean.Network network) {
        this._network = network;
    }

    /**
     * Sets the value of field 'ngmServers'.
     * 
     * @param ngmServers the value of field 'ngmServers'.
     */
    public void setNgmServers(
            final bean.NgmServers ngmServers) {
        this._ngmServers = ngmServers;
    }

    /**
     * Sets the value of field 'objects'.
     * 
     * @param objects the value of field 'objects'.
     */
    public void setObjects(
            final bean.Objects objects) {
        this._objects = objects;
    }

    /**
     * Sets the value of field 'objectsZOrder'.
     * 
     * @param objectsZOrder the value of field 'objectsZOrder'.
     */
    public void setObjectsZOrder(
            final bean.ObjectsZOrder objectsZOrder) {
        this._objectsZOrder = objectsZOrder;
    }

    /**
     * Sets the value of field 'optionsList'.
     * 
     * @param optionsList the value of field 'optionsList'.
     */
    public void setOptionsList(
            final bean.OptionsList optionsList) {
        this._optionsList = optionsList;
    }

    /**
     * Sets the value of field 'product'.
     * 
     * @param product the value of field 'product'.
     */
    public void setProduct(
            final bean.Product product) {
        this._product = product;
    }

    /**
     * Sets the value of field 'protocols'.
     * 
     * @param protocols the value of field 'protocols'.
     */
    public void setProtocols(
            final bean.Protocols protocols) {
        this._protocols = protocols;
    }

    /**
     * Sets the value of field 'remoteControl'.
     * 
     * @param remoteControl the value of field 'remoteControl'.
     */
    public void setRemoteControl(
            final bean.RemoteControl remoteControl) {
        this._remoteControl = remoteControl;
    }

    /**
     * Sets the value of field 'sagPresets'.
     * 
     * @param sagPresets the value of field 'sagPresets'.
     */
    public void setSagPresets(
            final bean.SagPresets sagPresets) {
        this._sagPresets = sagPresets;
    }

    /**
     * Sets the value of field 'screen'.
     * 
     * @param screen the value of field 'screen'.
     */
    public void setScreen(
            final bean.Screen screen) {
        this._screen = screen;
    }

    /**
     * Sets the value of field 'sources'.
     * 
     * @param sources the value of field 'sources'.
     */
    public void setSources(
            final bean.Sources sources) {
        this._sources = sources;
    }

    /**
     * Sets the value of field 'sysTime'.
     * 
     * @param sysTime the value of field 'sysTime'.
     */
    public void setSysTime(
            final bean.SysTime sysTime) {
        this._sysTime = sysTime;
    }

    /**
     * Sets the value of field 'videoCards'.
     * 
     * @param videoCards the value of field 'videoCards'.
     */
    public void setVideoCards(
            final bean.VideoCards videoCards) {
        this._videoCards = videoCards;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Module
     */
    public static bean.Module unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Module) Unmarshaller.unmarshal(bean.Module.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
