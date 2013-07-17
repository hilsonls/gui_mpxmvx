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
 * Class ObjectSequence.
 * 
 * @version $Revision$ $Date$
 */
public class ObjectSequence implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _vidAudProperties.
     */
    private bean.VidAudProperties _vidAudProperties;

    /**
     * Field _videoProperties.
     */
    private bean.VideoProperties _videoProperties;

    /**
     * Field _textProperties.
     */
    private bean.TextProperties _textProperties;

    /**
     * Field _umdProperties.
     */
    private java.lang.Object _umdProperties;

    /**
     * Field _tallyProperties.
     */
    private java.lang.Object _tallyProperties;

    /**
     * Field _logoProperties.
     */
    private bean.LogoProperties _logoProperties;

    /**
     * Field _clockProperties.
     */
    private bean.ClockProperties _clockProperties;

    /**
     * Field _timerProperties.
     */
    private bean.TimerProperties _timerProperties;


      //----------------/
     //- Constructors -/
    //----------------/

    public ObjectSequence() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'clockProperties'.
     * 
     * @return the value of field 'ClockProperties'.
     */
    public bean.ClockProperties getClockProperties(
    ) {
        return this._clockProperties;
    }

    /**
     * Returns the value of field 'logoProperties'.
     * 
     * @return the value of field 'LogoProperties'.
     */
    public bean.LogoProperties getLogoProperties(
    ) {
        return this._logoProperties;
    }

    /**
     * Returns the value of field 'tallyProperties'.
     * 
     * @return the value of field 'TallyProperties'.
     */
    public java.lang.Object getTallyProperties(
    ) {
        return this._tallyProperties;
    }

    /**
     * Returns the value of field 'textProperties'.
     * 
     * @return the value of field 'TextProperties'.
     */
    public bean.TextProperties getTextProperties(
    ) {
        return this._textProperties;
    }

    /**
     * Returns the value of field 'timerProperties'.
     * 
     * @return the value of field 'TimerProperties'.
     */
    public bean.TimerProperties getTimerProperties(
    ) {
        return this._timerProperties;
    }

    /**
     * Returns the value of field 'umdProperties'.
     * 
     * @return the value of field 'UmdProperties'.
     */
    public java.lang.Object getUmdProperties(
    ) {
        return this._umdProperties;
    }

    /**
     * Returns the value of field 'vidAudProperties'.
     * 
     * @return the value of field 'VidAudProperties'.
     */
    public bean.VidAudProperties getVidAudProperties(
    ) {
        return this._vidAudProperties;
    }

    /**
     * Returns the value of field 'videoProperties'.
     * 
     * @return the value of field 'VideoProperties'.
     */
    public bean.VideoProperties getVideoProperties(
    ) {
        return this._videoProperties;
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
     * Sets the value of field 'clockProperties'.
     * 
     * @param clockProperties the value of field 'clockProperties'.
     */
    public void setClockProperties(
            final bean.ClockProperties clockProperties) {
        this._clockProperties = clockProperties;
    }

    /**
     * Sets the value of field 'logoProperties'.
     * 
     * @param logoProperties the value of field 'logoProperties'.
     */
    public void setLogoProperties(
            final bean.LogoProperties logoProperties) {
        this._logoProperties = logoProperties;
    }

    /**
     * Sets the value of field 'tallyProperties'.
     * 
     * @param tallyProperties the value of field 'tallyProperties'.
     */
    public void setTallyProperties(
            final java.lang.Object tallyProperties) {
        this._tallyProperties = tallyProperties;
    }

    /**
     * Sets the value of field 'textProperties'.
     * 
     * @param textProperties the value of field 'textProperties'.
     */
    public void setTextProperties(
            final bean.TextProperties textProperties) {
        this._textProperties = textProperties;
    }

    /**
     * Sets the value of field 'timerProperties'.
     * 
     * @param timerProperties the value of field 'timerProperties'.
     */
    public void setTimerProperties(
            final bean.TimerProperties timerProperties) {
        this._timerProperties = timerProperties;
    }

    /**
     * Sets the value of field 'umdProperties'.
     * 
     * @param umdProperties the value of field 'umdProperties'.
     */
    public void setUmdProperties(
            final java.lang.Object umdProperties) {
        this._umdProperties = umdProperties;
    }

    /**
     * Sets the value of field 'vidAudProperties'.
     * 
     * @param vidAudProperties the value of field 'vidAudProperties'
     */
    public void setVidAudProperties(
            final bean.VidAudProperties vidAudProperties) {
        this._vidAudProperties = vidAudProperties;
    }

    /**
     * Sets the value of field 'videoProperties'.
     * 
     * @param videoProperties the value of field 'videoProperties'.
     */
    public void setVideoProperties(
            final bean.VideoProperties videoProperties) {
        this._videoProperties = videoProperties;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.ObjectSequence
     */
    public static bean.ObjectSequence unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.ObjectSequence) Unmarshaller.unmarshal(bean.ObjectSequence.class, reader);
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
