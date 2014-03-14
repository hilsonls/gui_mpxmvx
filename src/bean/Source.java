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
     * Field _alarms.
     */
    private bean.Alarms _alarms;

    /**
     * Field _audioAlarmSettings.
     */
    private bean.AudioAlarmSettings _audioAlarmSettings;

    /**
     * Field _audioDigitalRef.
     */
    private bean.AudioDigitalRef _audioDigitalRef;

    /**
     * Field _audio0dBRef.
     */
    private bean.Audio0dBRef _audio0dBRef;


      //----------------/
     //- Constructors -/
    //----------------/

    public Source() {
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
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'Id'.
     */
    public int getId(
    ) {
        return this._id;
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
