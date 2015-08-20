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
 * Class Audio.
 * 
 * @version $Revision$ $Date$
 */
public class Audio implements java.io.Serializable {


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
     * Field _multichan.
     */
    private bean.Multichan _multichan;

    /**
     * Field _numPairs.
     */
    private bean.NumPairs _numPairs;

    /**
     * Field _xpos.
     */
    private bean.Xpos _xpos;

    /**
     * Field _ypos.
     */
    private bean.Ypos _ypos;

    /**
     * Field _width.
     */
    private bean.Width _width;

    /**
     * Field _height.
     */
    private bean.Height _height;

    /**
     * Field _intraPairSpace.
     */
    private bean.IntraPairSpace _intraPairSpace;

    /**
     * Field _interPairSpace.
     */
    private bean.InterPairSpace _interPairSpace;

    /**
     * Field _scale.
     */
    private bean.Scale _scale;

    /**
     * Field _scalePosition.
     */
    private bean.ScalePosition _scalePosition;

    /**
     * Field _meterSource.
     */
    private bean.MeterSource _meterSource;

    /**
     * Field _labelType.
     */
    private bean.LabelType _labelType;

    /**
     * Field _labelColour.
     */
    private bean.LabelColour _labelColour;

    /**
     * Field _labelRotate.
     */
    private bean.LabelRotate _labelRotate;

    /**
     * Field _alarmIndicators.
     */
    private bean.AlarmIndicators _alarmIndicators;

    /**
     * Field _alarmBarFlash.
     */
    private bean.AlarmBarFlash _alarmBarFlash;

    /**
     * Field _transparent.
     */
    private bean.Transparent _transparent;

    /**
     * Field _transparentLevel.
     */
    private bean.TransparentLevel _transparentLevel;

    /**
     * Field _outsideVideo.
     */
    private bean.OutsideVideo _outsideVideo;

    /**
     * Field _visible.
     */
    private bean.Visible _visible;

    /**
     * Field _splitBars.
     */
    private bean.SplitBars _splitBars;

    /**
     * Field _audioSequenceList.
     */
    private java.util.List _audioSequenceList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Audio() {
        super();
        this._audioSequenceList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAudioSequence
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAudioSequence(
            final bean.AudioSequence vAudioSequence)
    throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this._audioSequenceList.size() >= 16) {
            throw new IndexOutOfBoundsException("addAudioSequence has a maximum of 16");
        }
        
        this._audioSequenceList.add(vAudioSequence);
    }

    /**
     * 
     * 
     * @param index
     * @param vAudioSequence
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAudioSequence(
            final int index,
            final bean.AudioSequence vAudioSequence)
    throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this._audioSequenceList.size() >= 16) {
            throw new IndexOutOfBoundsException("addAudioSequence has a maximum of 16");
        }
        
        this._audioSequenceList.add(index, vAudioSequence);
    }

    /**
     */
    public void deleteId(
    ) {
        this._has_id= false;
    }

    /**
     * Method enumerateAudioSequence.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateAudioSequence(
    ) {
        return java.util.Collections.enumeration(this._audioSequenceList);
    }

    /**
     * Returns the value of field 'alarmBarFlash'.
     * 
     * @return the value of field 'AlarmBarFlash'.
     */
    public bean.AlarmBarFlash getAlarmBarFlash(
    ) {
        return this._alarmBarFlash;
    }

    /**
     * Returns the value of field 'alarmIndicators'.
     * 
     * @return the value of field 'AlarmIndicators'.
     */
    public bean.AlarmIndicators getAlarmIndicators(
    ) {
        return this._alarmIndicators;
    }

    /**
     * Method getAudioSequence.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.AudioSequence at the given inde
     */
    public bean.AudioSequence getAudioSequence(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._audioSequenceList.size()) {
            throw new IndexOutOfBoundsException("getAudioSequence: Index value '" + index + "' not in range [0.." + (this._audioSequenceList.size() - 1) + "]");
        }
        
        return (bean.AudioSequence) _audioSequenceList.get(index);
    }

    /**
     * Method getAudioSequence.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.AudioSequence[] getAudioSequence(
    ) {
        bean.AudioSequence[] array = new bean.AudioSequence[0];
        return (bean.AudioSequence[]) this._audioSequenceList.toArray(array);
    }

    /**
     * Method getAudioSequenceCount.
     * 
     * @return the size of this collection
     */
    public int getAudioSequenceCount(
    ) {
        return this._audioSequenceList.size();
    }

    /**
     * Returns the value of field 'height'.
     * 
     * @return the value of field 'Height'.
     */
    public bean.Height getHeight(
    ) {
        return this._height;
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
     * Returns the value of field 'interPairSpace'.
     * 
     * @return the value of field 'InterPairSpace'.
     */
    public bean.InterPairSpace getInterPairSpace(
    ) {
        return this._interPairSpace;
    }

    /**
     * Returns the value of field 'intraPairSpace'.
     * 
     * @return the value of field 'IntraPairSpace'.
     */
    public bean.IntraPairSpace getIntraPairSpace(
    ) {
        return this._intraPairSpace;
    }

    /**
     * Returns the value of field 'labelColour'.
     * 
     * @return the value of field 'LabelColour'.
     */
    public bean.LabelColour getLabelColour(
    ) {
        return this._labelColour;
    }

    /**
     * Returns the value of field 'labelRotate'.
     * 
     * @return the value of field 'LabelRotate'.
     */
    public bean.LabelRotate getLabelRotate(
    ) {
        return this._labelRotate;
    }

    /**
     * Returns the value of field 'labelType'.
     * 
     * @return the value of field 'LabelType'.
     */
    public bean.LabelType getLabelType(
    ) {
        return this._labelType;
    }

    /**
     * Returns the value of field 'meterSource'.
     * 
     * @return the value of field 'MeterSource'.
     */
    public bean.MeterSource getMeterSource(
    ) {
        return this._meterSource;
    }

    /**
     * Returns the value of field 'multichan'.
     * 
     * @return the value of field 'Multichan'.
     */
    public bean.Multichan getMultichan(
    ) {
        return this._multichan;
    }

    /**
     * Returns the value of field 'numPairs'.
     * 
     * @return the value of field 'NumPairs'.
     */
    public bean.NumPairs getNumPairs(
    ) {
        return this._numPairs;
    }

    /**
     * Returns the value of field 'outsideVideo'.
     * 
     * @return the value of field 'OutsideVideo'.
     */
    public bean.OutsideVideo getOutsideVideo(
    ) {
        return this._outsideVideo;
    }

    /**
     * Returns the value of field 'scale'.
     * 
     * @return the value of field 'Scale'.
     */
    public bean.Scale getScale(
    ) {
        return this._scale;
    }

    /**
     * Returns the value of field 'scalePosition'.
     * 
     * @return the value of field 'ScalePosition'.
     */
    public bean.ScalePosition getScalePosition(
    ) {
        return this._scalePosition;
    }

    /**
     * Returns the value of field 'splitBars'.
     * 
     * @return the value of field 'SplitBars'.
     */
    public bean.SplitBars getSplitBars(
    ) {
        return this._splitBars;
    }

    /**
     * Returns the value of field 'transparent'.
     * 
     * @return the value of field 'Transparent'.
     */
    public bean.Transparent getTransparent(
    ) {
        return this._transparent;
    }

    /**
     * Returns the value of field 'transparentLevel'.
     * 
     * @return the value of field 'TransparentLevel'.
     */
    public bean.TransparentLevel getTransparentLevel(
    ) {
        return this._transparentLevel;
    }

    /**
     * Returns the value of field 'visible'.
     * 
     * @return the value of field 'Visible'.
     */
    public bean.Visible getVisible(
    ) {
        return this._visible;
    }

    /**
     * Returns the value of field 'width'.
     * 
     * @return the value of field 'Width'.
     */
    public bean.Width getWidth(
    ) {
        return this._width;
    }

    /**
     * Returns the value of field 'xpos'.
     * 
     * @return the value of field 'Xpos'.
     */
    public bean.Xpos getXpos(
    ) {
        return this._xpos;
    }

    /**
     * Returns the value of field 'ypos'.
     * 
     * @return the value of field 'Ypos'.
     */
    public bean.Ypos getYpos(
    ) {
        return this._ypos;
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
     * Method iterateAudioSequence.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateAudioSequence(
    ) {
        return this._audioSequenceList.iterator();
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
    public void removeAllAudioSequence(
    ) {
        this._audioSequenceList.clear();
    }

    /**
     * Method removeAudioSequence.
     * 
     * @param vAudioSequence
     * @return true if the object was removed from the collection.
     */
    public boolean removeAudioSequence(
            final bean.AudioSequence vAudioSequence) {
        boolean removed = _audioSequenceList.remove(vAudioSequence);
        return removed;
    }

    /**
     * Method removeAudioSequenceAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.AudioSequence removeAudioSequenceAt(
            final int index) {
        java.lang.Object obj = this._audioSequenceList.remove(index);
        return (bean.AudioSequence) obj;
    }

    /**
     * Sets the value of field 'alarmBarFlash'.
     * 
     * @param alarmBarFlash the value of field 'alarmBarFlash'.
     */
    public void setAlarmBarFlash(
            final bean.AlarmBarFlash alarmBarFlash) {
        this._alarmBarFlash = alarmBarFlash;
    }

    /**
     * Sets the value of field 'alarmIndicators'.
     * 
     * @param alarmIndicators the value of field 'alarmIndicators'.
     */
    public void setAlarmIndicators(
            final bean.AlarmIndicators alarmIndicators) {
        this._alarmIndicators = alarmIndicators;
    }

    /**
     * 
     * 
     * @param index
     * @param vAudioSequence
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAudioSequence(
            final int index,
            final bean.AudioSequence vAudioSequence)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._audioSequenceList.size()) {
            throw new IndexOutOfBoundsException("setAudioSequence: Index value '" + index + "' not in range [0.." + (this._audioSequenceList.size() - 1) + "]");
        }
        
        this._audioSequenceList.set(index, vAudioSequence);
    }

    /**
     * 
     * 
     * @param vAudioSequenceArray
     */
    public void setAudioSequence(
            final bean.AudioSequence[] vAudioSequenceArray) {
        //-- copy array
        _audioSequenceList.clear();
        
        for (int i = 0; i < vAudioSequenceArray.length; i++) {
                this._audioSequenceList.add(vAudioSequenceArray[i]);
        }
    }

    /**
     * Sets the value of field 'height'.
     * 
     * @param height the value of field 'height'.
     */
    public void setHeight(
            final bean.Height height) {
        this._height = height;
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
     * Sets the value of field 'interPairSpace'.
     * 
     * @param interPairSpace the value of field 'interPairSpace'.
     */
    public void setInterPairSpace(
            final bean.InterPairSpace interPairSpace) {
        this._interPairSpace = interPairSpace;
    }

    /**
     * Sets the value of field 'intraPairSpace'.
     * 
     * @param intraPairSpace the value of field 'intraPairSpace'.
     */
    public void setIntraPairSpace(
            final bean.IntraPairSpace intraPairSpace) {
        this._intraPairSpace = intraPairSpace;
    }

    /**
     * Sets the value of field 'labelColour'.
     * 
     * @param labelColour the value of field 'labelColour'.
     */
    public void setLabelColour(
            final bean.LabelColour labelColour) {
        this._labelColour = labelColour;
    }

    /**
     * Sets the value of field 'labelRotate'.
     * 
     * @param labelRotate the value of field 'labelRotate'.
     */
    public void setLabelRotate(
            final bean.LabelRotate labelRotate) {
        this._labelRotate = labelRotate;
    }

    /**
     * Sets the value of field 'labelType'.
     * 
     * @param labelType the value of field 'labelType'.
     */
    public void setLabelType(
            final bean.LabelType labelType) {
        this._labelType = labelType;
    }

    /**
     * Sets the value of field 'meterSource'.
     * 
     * @param meterSource the value of field 'meterSource'.
     */
    public void setMeterSource(
            final bean.MeterSource meterSource) {
        this._meterSource = meterSource;
    }

    /**
     * Sets the value of field 'multichan'.
     * 
     * @param multichan the value of field 'multichan'.
     */
    public void setMultichan(
            final bean.Multichan multichan) {
        this._multichan = multichan;
    }

    /**
     * Sets the value of field 'numPairs'.
     * 
     * @param numPairs the value of field 'numPairs'.
     */
    public void setNumPairs(
            final bean.NumPairs numPairs) {
        this._numPairs = numPairs;
    }

    /**
     * Sets the value of field 'outsideVideo'.
     * 
     * @param outsideVideo the value of field 'outsideVideo'.
     */
    public void setOutsideVideo(
            final bean.OutsideVideo outsideVideo) {
        this._outsideVideo = outsideVideo;
    }

    /**
     * Sets the value of field 'scale'.
     * 
     * @param scale the value of field 'scale'.
     */
    public void setScale(
            final bean.Scale scale) {
        this._scale = scale;
    }

    /**
     * Sets the value of field 'scalePosition'.
     * 
     * @param scalePosition the value of field 'scalePosition'.
     */
    public void setScalePosition(
            final bean.ScalePosition scalePosition) {
        this._scalePosition = scalePosition;
    }

    /**
     * Sets the value of field 'splitBars'.
     * 
     * @param splitBars the value of field 'splitBars'.
     */
    public void setSplitBars(
            final bean.SplitBars splitBars) {
        this._splitBars = splitBars;
    }

    /**
     * Sets the value of field 'transparent'.
     * 
     * @param transparent the value of field 'transparent'.
     */
    public void setTransparent(
            final bean.Transparent transparent) {
        this._transparent = transparent;
    }

    /**
     * Sets the value of field 'transparentLevel'.
     * 
     * @param transparentLevel the value of field 'transparentLevel'
     */
    public void setTransparentLevel(
            final bean.TransparentLevel transparentLevel) {
        this._transparentLevel = transparentLevel;
    }

    /**
     * Sets the value of field 'visible'.
     * 
     * @param visible the value of field 'visible'.
     */
    public void setVisible(
            final bean.Visible visible) {
        this._visible = visible;
    }

    /**
     * Sets the value of field 'width'.
     * 
     * @param width the value of field 'width'.
     */
    public void setWidth(
            final bean.Width width) {
        this._width = width;
    }

    /**
     * Sets the value of field 'xpos'.
     * 
     * @param xpos the value of field 'xpos'.
     */
    public void setXpos(
            final bean.Xpos xpos) {
        this._xpos = xpos;
    }

    /**
     * Sets the value of field 'ypos'.
     * 
     * @param ypos the value of field 'ypos'.
     */
    public void setYpos(
            final bean.Ypos ypos) {
        this._ypos = ypos;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Audio
     */
    public static bean.Audio unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Audio) Unmarshaller.unmarshal(bean.Audio.class, reader);
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
