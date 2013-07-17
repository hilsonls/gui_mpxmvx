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
 * Class VidAudProperties.
 * 
 * @version $Revision$ $Date$
 */
public class VidAudProperties implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _vidAudSource.
     */
    private bean.VidAudSource _vidAudSource;

    /**
     * Field _audio.
     */
    private bean.Audio _audio;

    /**
     * Field _error.
     */
    private bean.Error _error;


      //----------------/
     //- Constructors -/
    //----------------/

    public VidAudProperties() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'audio'.
     * 
     * @return the value of field 'Audio'.
     */
    public bean.Audio getAudio(
    ) {
        return this._audio;
    }

    /**
     * Returns the value of field 'error'.
     * 
     * @return the value of field 'Error'.
     */
    public bean.Error getError(
    ) {
        return this._error;
    }

    /**
     * Returns the value of field 'vidAudSource'.
     * 
     * @return the value of field 'VidAudSource'.
     */
    public bean.VidAudSource getVidAudSource(
    ) {
        return this._vidAudSource;
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
     * Sets the value of field 'audio'.
     * 
     * @param audio the value of field 'audio'.
     */
    public void setAudio(
            final bean.Audio audio) {
        this._audio = audio;
    }

    /**
     * Sets the value of field 'error'.
     * 
     * @param error the value of field 'error'.
     */
    public void setError(
            final bean.Error error) {
        this._error = error;
    }

    /**
     * Sets the value of field 'vidAudSource'.
     * 
     * @param vidAudSource the value of field 'vidAudSource'.
     */
    public void setVidAudSource(
            final bean.VidAudSource vidAudSource) {
        this._vidAudSource = vidAudSource;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.VidAudProperties
     */
    public static bean.VidAudProperties unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.VidAudProperties) Unmarshaller.unmarshal(bean.VidAudProperties.class, reader);
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
