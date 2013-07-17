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
 * Class AudioPhysMapInfo.
 * 
 * @version $Revision$ $Date$
 */
public class AudioPhysMapInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _audioPhysMapInfoNumIns.
     */
    private bean.AudioPhysMapInfoNumIns _audioPhysMapInfoNumIns;

    /**
     * Field _audioPhysMapInfoNumOuts.
     */
    private bean.AudioPhysMapInfoNumOuts _audioPhysMapInfoNumOuts;

    /**
     * Field _audioPhysMapInfoNumLvls.
     */
    private bean.AudioPhysMapInfoNumLvls _audioPhysMapInfoNumLvls;

    /**
     * Field _audioPhysMapInfoNumMats.
     */
    private bean.AudioPhysMapInfoNumMats _audioPhysMapInfoNumMats;

    /**
     * Field _audioPhysMapInfoNumDass.
     */
    private bean.AudioPhysMapInfoNumDass _audioPhysMapInfoNumDass;


      //----------------/
     //- Constructors -/
    //----------------/

    public AudioPhysMapInfo() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'audioPhysMapInfoNumDass'.
     * 
     * @return the value of field 'AudioPhysMapInfoNumDass'.
     */
    public bean.AudioPhysMapInfoNumDass getAudioPhysMapInfoNumDass(
    ) {
        return this._audioPhysMapInfoNumDass;
    }

    /**
     * Returns the value of field 'audioPhysMapInfoNumIns'.
     * 
     * @return the value of field 'AudioPhysMapInfoNumIns'.
     */
    public bean.AudioPhysMapInfoNumIns getAudioPhysMapInfoNumIns(
    ) {
        return this._audioPhysMapInfoNumIns;
    }

    /**
     * Returns the value of field 'audioPhysMapInfoNumLvls'.
     * 
     * @return the value of field 'AudioPhysMapInfoNumLvls'.
     */
    public bean.AudioPhysMapInfoNumLvls getAudioPhysMapInfoNumLvls(
    ) {
        return this._audioPhysMapInfoNumLvls;
    }

    /**
     * Returns the value of field 'audioPhysMapInfoNumMats'.
     * 
     * @return the value of field 'AudioPhysMapInfoNumMats'.
     */
    public bean.AudioPhysMapInfoNumMats getAudioPhysMapInfoNumMats(
    ) {
        return this._audioPhysMapInfoNumMats;
    }

    /**
     * Returns the value of field 'audioPhysMapInfoNumOuts'.
     * 
     * @return the value of field 'AudioPhysMapInfoNumOuts'.
     */
    public bean.AudioPhysMapInfoNumOuts getAudioPhysMapInfoNumOuts(
    ) {
        return this._audioPhysMapInfoNumOuts;
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
     * Sets the value of field 'audioPhysMapInfoNumDass'.
     * 
     * @param audioPhysMapInfoNumDass the value of field
     * 'audioPhysMapInfoNumDass'.
     */
    public void setAudioPhysMapInfoNumDass(
            final bean.AudioPhysMapInfoNumDass audioPhysMapInfoNumDass) {
        this._audioPhysMapInfoNumDass = audioPhysMapInfoNumDass;
    }

    /**
     * Sets the value of field 'audioPhysMapInfoNumIns'.
     * 
     * @param audioPhysMapInfoNumIns the value of field
     * 'audioPhysMapInfoNumIns'.
     */
    public void setAudioPhysMapInfoNumIns(
            final bean.AudioPhysMapInfoNumIns audioPhysMapInfoNumIns) {
        this._audioPhysMapInfoNumIns = audioPhysMapInfoNumIns;
    }

    /**
     * Sets the value of field 'audioPhysMapInfoNumLvls'.
     * 
     * @param audioPhysMapInfoNumLvls the value of field
     * 'audioPhysMapInfoNumLvls'.
     */
    public void setAudioPhysMapInfoNumLvls(
            final bean.AudioPhysMapInfoNumLvls audioPhysMapInfoNumLvls) {
        this._audioPhysMapInfoNumLvls = audioPhysMapInfoNumLvls;
    }

    /**
     * Sets the value of field 'audioPhysMapInfoNumMats'.
     * 
     * @param audioPhysMapInfoNumMats the value of field
     * 'audioPhysMapInfoNumMats'.
     */
    public void setAudioPhysMapInfoNumMats(
            final bean.AudioPhysMapInfoNumMats audioPhysMapInfoNumMats) {
        this._audioPhysMapInfoNumMats = audioPhysMapInfoNumMats;
    }

    /**
     * Sets the value of field 'audioPhysMapInfoNumOuts'.
     * 
     * @param audioPhysMapInfoNumOuts the value of field
     * 'audioPhysMapInfoNumOuts'.
     */
    public void setAudioPhysMapInfoNumOuts(
            final bean.AudioPhysMapInfoNumOuts audioPhysMapInfoNumOuts) {
        this._audioPhysMapInfoNumOuts = audioPhysMapInfoNumOuts;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.AudioPhysMapInfo
     */
    public static bean.AudioPhysMapInfo unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.AudioPhysMapInfo) Unmarshaller.unmarshal(bean.AudioPhysMapInfo.class, reader);
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
