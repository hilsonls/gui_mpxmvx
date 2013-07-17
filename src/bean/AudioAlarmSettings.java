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
 * Class AudioAlarmSettings.
 * 
 * @version $Revision$ $Date$
 */
public class AudioAlarmSettings implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _useAudioAlarmSettings.
     */
    private bean.UseAudioAlarmSettings _useAudioAlarmSettings;

    /**
     * Field _audioLossAlarm.
     */
    private bean.AudioLossAlarm _audioLossAlarm;

    /**
     * Field _audioOverAlarm.
     */
    private bean.AudioOverAlarm _audioOverAlarm;

    /**
     * Field _phaseAlarm.
     */
    private bean.PhaseAlarm _phaseAlarm;

    /**
     * Field _carrierLossAlarm.
     */
    private bean.CarrierLossAlarm _carrierLossAlarm;


      //----------------/
     //- Constructors -/
    //----------------/

    public AudioAlarmSettings() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'audioLossAlarm'.
     * 
     * @return the value of field 'AudioLossAlarm'.
     */
    public bean.AudioLossAlarm getAudioLossAlarm(
    ) {
        return this._audioLossAlarm;
    }

    /**
     * Returns the value of field 'audioOverAlarm'.
     * 
     * @return the value of field 'AudioOverAlarm'.
     */
    public bean.AudioOverAlarm getAudioOverAlarm(
    ) {
        return this._audioOverAlarm;
    }

    /**
     * Returns the value of field 'carrierLossAlarm'.
     * 
     * @return the value of field 'CarrierLossAlarm'.
     */
    public bean.CarrierLossAlarm getCarrierLossAlarm(
    ) {
        return this._carrierLossAlarm;
    }

    /**
     * Returns the value of field 'phaseAlarm'.
     * 
     * @return the value of field 'PhaseAlarm'.
     */
    public bean.PhaseAlarm getPhaseAlarm(
    ) {
        return this._phaseAlarm;
    }

    /**
     * Returns the value of field 'useAudioAlarmSettings'.
     * 
     * @return the value of field 'UseAudioAlarmSettings'.
     */
    public bean.UseAudioAlarmSettings getUseAudioAlarmSettings(
    ) {
        return this._useAudioAlarmSettings;
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
     * Sets the value of field 'audioLossAlarm'.
     * 
     * @param audioLossAlarm the value of field 'audioLossAlarm'.
     */
    public void setAudioLossAlarm(
            final bean.AudioLossAlarm audioLossAlarm) {
        this._audioLossAlarm = audioLossAlarm;
    }

    /**
     * Sets the value of field 'audioOverAlarm'.
     * 
     * @param audioOverAlarm the value of field 'audioOverAlarm'.
     */
    public void setAudioOverAlarm(
            final bean.AudioOverAlarm audioOverAlarm) {
        this._audioOverAlarm = audioOverAlarm;
    }

    /**
     * Sets the value of field 'carrierLossAlarm'.
     * 
     * @param carrierLossAlarm the value of field 'carrierLossAlarm'
     */
    public void setCarrierLossAlarm(
            final bean.CarrierLossAlarm carrierLossAlarm) {
        this._carrierLossAlarm = carrierLossAlarm;
    }

    /**
     * Sets the value of field 'phaseAlarm'.
     * 
     * @param phaseAlarm the value of field 'phaseAlarm'.
     */
    public void setPhaseAlarm(
            final bean.PhaseAlarm phaseAlarm) {
        this._phaseAlarm = phaseAlarm;
    }

    /**
     * Sets the value of field 'useAudioAlarmSettings'.
     * 
     * @param useAudioAlarmSettings the value of field
     * 'useAudioAlarmSettings'.
     */
    public void setUseAudioAlarmSettings(
            final bean.UseAudioAlarmSettings useAudioAlarmSettings) {
        this._useAudioAlarmSettings = useAudioAlarmSettings;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.AudioAlarmSettings
     */
    public static bean.AudioAlarmSettings unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.AudioAlarmSettings) Unmarshaller.unmarshal(bean.AudioAlarmSettings.class, reader);
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
