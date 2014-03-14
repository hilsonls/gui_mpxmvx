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
 * Class AudioSources.
 * 
 * @version $Revision$ $Date$
 */
public class AudioSources implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _audioDigitalRef.
     */
    private bean.AudioDigitalRef _audioDigitalRef;

    /**
     * Field _audio0dBRef.
     */
    private bean.Audio0dBRef _audio0dBRef;

    /**
     * Field _audioAlarmSettings.
     */
    private bean.AudioAlarmSettings _audioAlarmSettings;


      //----------------/
     //- Constructors -/
    //----------------/

    public AudioSources() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

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
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.AudioSources
     */
    public static bean.AudioSources unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.AudioSources) Unmarshaller.unmarshal(bean.AudioSources.class, reader);
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
