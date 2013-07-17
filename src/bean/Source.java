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
 * Class Source.
 * 
 * @version $Revision$ $Date$
 */
public class Source implements java.io.Serializable {


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
     * Field _username.
     */
    private bean.Username _username;

    /**
     * Field _type.
     */
    private bean.Type _type;

    /**
     * Field _embedded.
     */
    private bean.Embedded _embedded;

    /**
     * Field _embeddedAvail.
     */
    private bean.EmbeddedAvail _embeddedAvail;

    /**
     * Field _ngm.
     */
    private bean.Ngm _ngm;

    /**
     * Field _ngmName.
     */
    private bean.NgmName _ngmName;

    /**
     * Field _audioDigitalRef.
     */
    private bean.AudioDigitalRef _audioDigitalRef;

    /**
     * Field _audio0dBRef.
     */
    private bean.Audio0dBRef _audio0dBRef;

    /**
     * Field _alarms.
     */
    private bean.Alarms _alarms;

    /**
     * Field _audioAlarmSettings.
     */
    private bean.AudioAlarmSettings _audioAlarmSettings;

    /**
     * Field _showPhaseList.
     */
    private java.util.List _showPhaseList;

    /**
     * Field _audioInputList.
     */
    private java.util.List _audioInputList;

    /**
     * Field _audioPhaseList.
     */
    private java.util.List _audioPhaseList;

    /**
     * Field _ngmInputList.
     */
    private java.util.List _ngmInputList;

    /**
     * Field _ngmPhaseList.
     */
    private java.util.List _ngmPhaseList;

    /**
     * Field _sourceSequence.
     */
    private bean.SourceSequence _sourceSequence;


      //----------------/
     //- Constructors -/
    //----------------/

    public Source() {
        super();
        this._showPhaseList = new java.util.ArrayList();
        this._audioInputList = new java.util.ArrayList();
        this._audioPhaseList = new java.util.ArrayList();
        this._ngmInputList = new java.util.ArrayList();
        this._ngmPhaseList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAudioInput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAudioInput(
            final bean.AudioInput vAudioInput)
    throws java.lang.IndexOutOfBoundsException {
        this._audioInputList.add(vAudioInput);
    }

    /**
     * 
     * 
     * @param index
     * @param vAudioInput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAudioInput(
            final int index,
            final bean.AudioInput vAudioInput)
    throws java.lang.IndexOutOfBoundsException {
        this._audioInputList.add(index, vAudioInput);
    }

    /**
     * 
     * 
     * @param vAudioPhase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAudioPhase(
            final bean.AudioPhase vAudioPhase)
    throws java.lang.IndexOutOfBoundsException {
        this._audioPhaseList.add(vAudioPhase);
    }

    /**
     * 
     * 
     * @param index
     * @param vAudioPhase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAudioPhase(
            final int index,
            final bean.AudioPhase vAudioPhase)
    throws java.lang.IndexOutOfBoundsException {
        this._audioPhaseList.add(index, vAudioPhase);
    }

    /**
     * 
     * 
     * @param vNgmInput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNgmInput(
            final bean.NgmInput vNgmInput)
    throws java.lang.IndexOutOfBoundsException {
        this._ngmInputList.add(vNgmInput);
    }

    /**
     * 
     * 
     * @param index
     * @param vNgmInput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNgmInput(
            final int index,
            final bean.NgmInput vNgmInput)
    throws java.lang.IndexOutOfBoundsException {
        this._ngmInputList.add(index, vNgmInput);
    }

    /**
     * 
     * 
     * @param vNgmPhase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNgmPhase(
            final bean.NgmPhase vNgmPhase)
    throws java.lang.IndexOutOfBoundsException {
        this._ngmPhaseList.add(vNgmPhase);
    }

    /**
     * 
     * 
     * @param index
     * @param vNgmPhase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNgmPhase(
            final int index,
            final bean.NgmPhase vNgmPhase)
    throws java.lang.IndexOutOfBoundsException {
        this._ngmPhaseList.add(index, vNgmPhase);
    }

    /**
     * 
     * 
     * @param vShowPhase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addShowPhase(
            final bean.ShowPhase vShowPhase)
    throws java.lang.IndexOutOfBoundsException {
        this._showPhaseList.add(vShowPhase);
    }

    /**
     * 
     * 
     * @param index
     * @param vShowPhase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addShowPhase(
            final int index,
            final bean.ShowPhase vShowPhase)
    throws java.lang.IndexOutOfBoundsException {
        this._showPhaseList.add(index, vShowPhase);
    }

    /**
     */
    public void deleteId(
    ) {
        this._has_id= false;
    }

    /**
     * Method enumerateAudioInput.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateAudioInput(
    ) {
        return java.util.Collections.enumeration(this._audioInputList);
    }

    /**
     * Method enumerateAudioPhase.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateAudioPhase(
    ) {
        return java.util.Collections.enumeration(this._audioPhaseList);
    }

    /**
     * Method enumerateNgmInput.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateNgmInput(
    ) {
        return java.util.Collections.enumeration(this._ngmInputList);
    }

    /**
     * Method enumerateNgmPhase.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateNgmPhase(
    ) {
        return java.util.Collections.enumeration(this._ngmPhaseList);
    }

    /**
     * Method enumerateShowPhase.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateShowPhase(
    ) {
        return java.util.Collections.enumeration(this._showPhaseList);
    }

    /**
     * Returns the value of field 'alarms'.
     * 
     * @return the value of field 'Alarms'.
     */
    public bean.Alarms getAlarms(
    ) {
        return this._alarms;
    }

    /**
     * Returns the value of field 'audio0dBRef'.
     * 
     * @return the value of field 'Audio0dBRef'.
     */
    public bean.Audio0dBRef getAudio0dBRef(
    ) {
        return this._audio0dBRef;
    }

    /**
     * Returns the value of field 'audioAlarmSettings'.
     * 
     * @return the value of field 'AudioAlarmSettings'.
     */
    public bean.AudioAlarmSettings getAudioAlarmSettings(
    ) {
        return this._audioAlarmSettings;
    }

    /**
     * Returns the value of field 'audioDigitalRef'.
     * 
     * @return the value of field 'AudioDigitalRef'.
     */
    public bean.AudioDigitalRef getAudioDigitalRef(
    ) {
        return this._audioDigitalRef;
    }

    /**
     * Method getAudioInput.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.AudioInput at the given index
     */
    public bean.AudioInput getAudioInput(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._audioInputList.size()) {
            throw new IndexOutOfBoundsException("getAudioInput: Index value '" + index + "' not in range [0.." + (this._audioInputList.size() - 1) + "]");
        }
        
        return (bean.AudioInput) _audioInputList.get(index);
    }

    /**
     * Method getAudioInput.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.AudioInput[] getAudioInput(
    ) {
        bean.AudioInput[] array = new bean.AudioInput[0];
        return (bean.AudioInput[]) this._audioInputList.toArray(array);
    }

    /**
     * Method getAudioInputCount.
     * 
     * @return the size of this collection
     */
    public int getAudioInputCount(
    ) {
        return this._audioInputList.size();
    }

    /**
     * Method getAudioPhase.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.AudioPhase at the given index
     */
    public bean.AudioPhase getAudioPhase(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._audioPhaseList.size()) {
            throw new IndexOutOfBoundsException("getAudioPhase: Index value '" + index + "' not in range [0.." + (this._audioPhaseList.size() - 1) + "]");
        }
        
        return (bean.AudioPhase) _audioPhaseList.get(index);
    }

    /**
     * Method getAudioPhase.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.AudioPhase[] getAudioPhase(
    ) {
        bean.AudioPhase[] array = new bean.AudioPhase[0];
        return (bean.AudioPhase[]) this._audioPhaseList.toArray(array);
    }

    /**
     * Method getAudioPhaseCount.
     * 
     * @return the size of this collection
     */
    public int getAudioPhaseCount(
    ) {
        return this._audioPhaseList.size();
    }

    /**
     * Returns the value of field 'embedded'.
     * 
     * @return the value of field 'Embedded'.
     */
    public bean.Embedded getEmbedded(
    ) {
        return this._embedded;
    }

    /**
     * Returns the value of field 'embeddedAvail'.
     * 
     * @return the value of field 'EmbeddedAvail'.
     */
    public bean.EmbeddedAvail getEmbeddedAvail(
    ) {
        return this._embeddedAvail;
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
     * Returns the value of field 'ngm'.
     * 
     * @return the value of field 'Ngm'.
     */
    public bean.Ngm getNgm(
    ) {
        return this._ngm;
    }

    /**
     * Method getNgmInput.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.NgmInput at the given index
     */
    public bean.NgmInput getNgmInput(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ngmInputList.size()) {
            throw new IndexOutOfBoundsException("getNgmInput: Index value '" + index + "' not in range [0.." + (this._ngmInputList.size() - 1) + "]");
        }
        
        return (bean.NgmInput) _ngmInputList.get(index);
    }

    /**
     * Method getNgmInput.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.NgmInput[] getNgmInput(
    ) {
        bean.NgmInput[] array = new bean.NgmInput[0];
        return (bean.NgmInput[]) this._ngmInputList.toArray(array);
    }

    /**
     * Method getNgmInputCount.
     * 
     * @return the size of this collection
     */
    public int getNgmInputCount(
    ) {
        return this._ngmInputList.size();
    }

    /**
     * Returns the value of field 'ngmName'.
     * 
     * @return the value of field 'NgmName'.
     */
    public bean.NgmName getNgmName(
    ) {
        return this._ngmName;
    }

    /**
     * Method getNgmPhase.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.NgmPhase at the given index
     */
    public bean.NgmPhase getNgmPhase(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ngmPhaseList.size()) {
            throw new IndexOutOfBoundsException("getNgmPhase: Index value '" + index + "' not in range [0.." + (this._ngmPhaseList.size() - 1) + "]");
        }
        
        return (bean.NgmPhase) _ngmPhaseList.get(index);
    }

    /**
     * Method getNgmPhase.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.NgmPhase[] getNgmPhase(
    ) {
        bean.NgmPhase[] array = new bean.NgmPhase[0];
        return (bean.NgmPhase[]) this._ngmPhaseList.toArray(array);
    }

    /**
     * Method getNgmPhaseCount.
     * 
     * @return the size of this collection
     */
    public int getNgmPhaseCount(
    ) {
        return this._ngmPhaseList.size();
    }

    /**
     * Method getShowPhase.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.ShowPhase at the given index
     */
    public bean.ShowPhase getShowPhase(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._showPhaseList.size()) {
            throw new IndexOutOfBoundsException("getShowPhase: Index value '" + index + "' not in range [0.." + (this._showPhaseList.size() - 1) + "]");
        }
        
        return (bean.ShowPhase) _showPhaseList.get(index);
    }

    /**
     * Method getShowPhase.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.ShowPhase[] getShowPhase(
    ) {
        bean.ShowPhase[] array = new bean.ShowPhase[0];
        return (bean.ShowPhase[]) this._showPhaseList.toArray(array);
    }

    /**
     * Method getShowPhaseCount.
     * 
     * @return the size of this collection
     */
    public int getShowPhaseCount(
    ) {
        return this._showPhaseList.size();
    }

    /**
     * Returns the value of field 'sourceSequence'.
     * 
     * @return the value of field 'SourceSequence'.
     */
    public bean.SourceSequence getSourceSequence(
    ) {
        return this._sourceSequence;
    }

    /**
     * Returns the value of field 'type'.
     * 
     * @return the value of field 'Type'.
     */
    public bean.Type getType(
    ) {
        return this._type;
    }

    /**
     * Returns the value of field 'username'.
     * 
     * @return the value of field 'Username'.
     */
    public bean.Username getUsername(
    ) {
        return this._username;
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
     * Method iterateAudioInput.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateAudioInput(
    ) {
        return this._audioInputList.iterator();
    }

    /**
     * Method iterateAudioPhase.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateAudioPhase(
    ) {
        return this._audioPhaseList.iterator();
    }

    /**
     * Method iterateNgmInput.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateNgmInput(
    ) {
        return this._ngmInputList.iterator();
    }

    /**
     * Method iterateNgmPhase.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateNgmPhase(
    ) {
        return this._ngmPhaseList.iterator();
    }

    /**
     * Method iterateShowPhase.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateShowPhase(
    ) {
        return this._showPhaseList.iterator();
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
     */
    public void removeAllAudioInput(
    ) {
        this._audioInputList.clear();
    }

    /**
     */
    public void removeAllAudioPhase(
    ) {
        this._audioPhaseList.clear();
    }

    /**
     */
    public void removeAllNgmInput(
    ) {
        this._ngmInputList.clear();
    }

    /**
     */
    public void removeAllNgmPhase(
    ) {
        this._ngmPhaseList.clear();
    }

    /**
     */
    public void removeAllShowPhase(
    ) {
        this._showPhaseList.clear();
    }

    /**
     * Method removeAudioInput.
     * 
     * @param vAudioInput
     * @return true if the object was removed from the collection.
     */
    public boolean removeAudioInput(
            final bean.AudioInput vAudioInput) {
        boolean removed = _audioInputList.remove(vAudioInput);
        return removed;
    }

    /**
     * Method removeAudioInputAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.AudioInput removeAudioInputAt(
            final int index) {
        java.lang.Object obj = this._audioInputList.remove(index);
        return (bean.AudioInput) obj;
    }

    /**
     * Method removeAudioPhase.
     * 
     * @param vAudioPhase
     * @return true if the object was removed from the collection.
     */
    public boolean removeAudioPhase(
            final bean.AudioPhase vAudioPhase) {
        boolean removed = _audioPhaseList.remove(vAudioPhase);
        return removed;
    }

    /**
     * Method removeAudioPhaseAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.AudioPhase removeAudioPhaseAt(
            final int index) {
        java.lang.Object obj = this._audioPhaseList.remove(index);
        return (bean.AudioPhase) obj;
    }

    /**
     * Method removeNgmInput.
     * 
     * @param vNgmInput
     * @return true if the object was removed from the collection.
     */
    public boolean removeNgmInput(
            final bean.NgmInput vNgmInput) {
        boolean removed = _ngmInputList.remove(vNgmInput);
        return removed;
    }

    /**
     * Method removeNgmInputAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.NgmInput removeNgmInputAt(
            final int index) {
        java.lang.Object obj = this._ngmInputList.remove(index);
        return (bean.NgmInput) obj;
    }

    /**
     * Method removeNgmPhase.
     * 
     * @param vNgmPhase
     * @return true if the object was removed from the collection.
     */
    public boolean removeNgmPhase(
            final bean.NgmPhase vNgmPhase) {
        boolean removed = _ngmPhaseList.remove(vNgmPhase);
        return removed;
    }

    /**
     * Method removeNgmPhaseAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.NgmPhase removeNgmPhaseAt(
            final int index) {
        java.lang.Object obj = this._ngmPhaseList.remove(index);
        return (bean.NgmPhase) obj;
    }

    /**
     * Method removeShowPhase.
     * 
     * @param vShowPhase
     * @return true if the object was removed from the collection.
     */
    public boolean removeShowPhase(
            final bean.ShowPhase vShowPhase) {
        boolean removed = _showPhaseList.remove(vShowPhase);
        return removed;
    }

    /**
     * Method removeShowPhaseAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.ShowPhase removeShowPhaseAt(
            final int index) {
        java.lang.Object obj = this._showPhaseList.remove(index);
        return (bean.ShowPhase) obj;
    }

    /**
     * Sets the value of field 'alarms'.
     * 
     * @param alarms the value of field 'alarms'.
     */
    public void setAlarms(
            final bean.Alarms alarms) {
        this._alarms = alarms;
    }

    /**
     * Sets the value of field 'audio0dBRef'.
     * 
     * @param audio0dBRef the value of field 'audio0dBRef'.
     */
    public void setAudio0dBRef(
            final bean.Audio0dBRef audio0dBRef) {
        this._audio0dBRef = audio0dBRef;
    }

    /**
     * Sets the value of field 'audioAlarmSettings'.
     * 
     * @param audioAlarmSettings the value of field
     * 'audioAlarmSettings'.
     */
    public void setAudioAlarmSettings(
            final bean.AudioAlarmSettings audioAlarmSettings) {
        this._audioAlarmSettings = audioAlarmSettings;
    }

    /**
     * Sets the value of field 'audioDigitalRef'.
     * 
     * @param audioDigitalRef the value of field 'audioDigitalRef'.
     */
    public void setAudioDigitalRef(
            final bean.AudioDigitalRef audioDigitalRef) {
        this._audioDigitalRef = audioDigitalRef;
    }

    /**
     * 
     * 
     * @param index
     * @param vAudioInput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAudioInput(
            final int index,
            final bean.AudioInput vAudioInput)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._audioInputList.size()) {
            throw new IndexOutOfBoundsException("setAudioInput: Index value '" + index + "' not in range [0.." + (this._audioInputList.size() - 1) + "]");
        }
        
        this._audioInputList.set(index, vAudioInput);
    }

    /**
     * 
     * 
     * @param vAudioInputArray
     */
    public void setAudioInput(
            final bean.AudioInput[] vAudioInputArray) {
        //-- copy array
        _audioInputList.clear();
        
        for (int i = 0; i < vAudioInputArray.length; i++) {
                this._audioInputList.add(vAudioInputArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vAudioPhase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAudioPhase(
            final int index,
            final bean.AudioPhase vAudioPhase)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._audioPhaseList.size()) {
            throw new IndexOutOfBoundsException("setAudioPhase: Index value '" + index + "' not in range [0.." + (this._audioPhaseList.size() - 1) + "]");
        }
        
        this._audioPhaseList.set(index, vAudioPhase);
    }

    /**
     * 
     * 
     * @param vAudioPhaseArray
     */
    public void setAudioPhase(
            final bean.AudioPhase[] vAudioPhaseArray) {
        //-- copy array
        _audioPhaseList.clear();
        
        for (int i = 0; i < vAudioPhaseArray.length; i++) {
                this._audioPhaseList.add(vAudioPhaseArray[i]);
        }
    }

    /**
     * Sets the value of field 'embedded'.
     * 
     * @param embedded the value of field 'embedded'.
     */
    public void setEmbedded(
            final bean.Embedded embedded) {
        this._embedded = embedded;
    }

    /**
     * Sets the value of field 'embeddedAvail'.
     * 
     * @param embeddedAvail the value of field 'embeddedAvail'.
     */
    public void setEmbeddedAvail(
            final bean.EmbeddedAvail embeddedAvail) {
        this._embeddedAvail = embeddedAvail;
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
     * Sets the value of field 'ngm'.
     * 
     * @param ngm the value of field 'ngm'.
     */
    public void setNgm(
            final bean.Ngm ngm) {
        this._ngm = ngm;
    }

    /**
     * 
     * 
     * @param index
     * @param vNgmInput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setNgmInput(
            final int index,
            final bean.NgmInput vNgmInput)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ngmInputList.size()) {
            throw new IndexOutOfBoundsException("setNgmInput: Index value '" + index + "' not in range [0.." + (this._ngmInputList.size() - 1) + "]");
        }
        
        this._ngmInputList.set(index, vNgmInput);
    }

    /**
     * 
     * 
     * @param vNgmInputArray
     */
    public void setNgmInput(
            final bean.NgmInput[] vNgmInputArray) {
        //-- copy array
        _ngmInputList.clear();
        
        for (int i = 0; i < vNgmInputArray.length; i++) {
                this._ngmInputList.add(vNgmInputArray[i]);
        }
    }

    /**
     * Sets the value of field 'ngmName'.
     * 
     * @param ngmName the value of field 'ngmName'.
     */
    public void setNgmName(
            final bean.NgmName ngmName) {
        this._ngmName = ngmName;
    }

    /**
     * 
     * 
     * @param index
     * @param vNgmPhase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setNgmPhase(
            final int index,
            final bean.NgmPhase vNgmPhase)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ngmPhaseList.size()) {
            throw new IndexOutOfBoundsException("setNgmPhase: Index value '" + index + "' not in range [0.." + (this._ngmPhaseList.size() - 1) + "]");
        }
        
        this._ngmPhaseList.set(index, vNgmPhase);
    }

    /**
     * 
     * 
     * @param vNgmPhaseArray
     */
    public void setNgmPhase(
            final bean.NgmPhase[] vNgmPhaseArray) {
        //-- copy array
        _ngmPhaseList.clear();
        
        for (int i = 0; i < vNgmPhaseArray.length; i++) {
                this._ngmPhaseList.add(vNgmPhaseArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vShowPhase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setShowPhase(
            final int index,
            final bean.ShowPhase vShowPhase)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._showPhaseList.size()) {
            throw new IndexOutOfBoundsException("setShowPhase: Index value '" + index + "' not in range [0.." + (this._showPhaseList.size() - 1) + "]");
        }
        
        this._showPhaseList.set(index, vShowPhase);
    }

    /**
     * 
     * 
     * @param vShowPhaseArray
     */
    public void setShowPhase(
            final bean.ShowPhase[] vShowPhaseArray) {
        //-- copy array
        _showPhaseList.clear();
        
        for (int i = 0; i < vShowPhaseArray.length; i++) {
                this._showPhaseList.add(vShowPhaseArray[i]);
        }
    }

    /**
     * Sets the value of field 'sourceSequence'.
     * 
     * @param sourceSequence the value of field 'sourceSequence'.
     */
    public void setSourceSequence(
            final bean.SourceSequence sourceSequence) {
        this._sourceSequence = sourceSequence;
    }

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(
            final bean.Type type) {
        this._type = type;
    }

    /**
     * Sets the value of field 'username'.
     * 
     * @param username the value of field 'username'.
     */
    public void setUsername(
            final bean.Username username) {
        this._username = username;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Source
     */
    public static bean.Source unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Source) Unmarshaller.unmarshal(bean.Source.class, reader);
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
