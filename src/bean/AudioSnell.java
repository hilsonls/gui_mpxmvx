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
 * Class AudioSnell.
 * 
 * @version $Revision$ $Date$
 */
public class AudioSnell implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _audioPhysMapInfo.
     */
    private bean.AudioPhysMapInfo _audioPhysMapInfo;

    /**
     * Field _audioPhysIns.
     */
    private bean.AudioPhysIns _audioPhysIns;


      //----------------/
     //- Constructors -/
    //----------------/

    public AudioSnell() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'audioPhysIns'.
     * 
     * @return the value of field 'AudioPhysIns'.
     */
    public bean.AudioPhysIns getAudioPhysIns(
    ) {
        return this._audioPhysIns;
    }

    /**
     * Returns the value of field 'audioPhysMapInfo'.
     * 
     * @return the value of field 'AudioPhysMapInfo'.
     */
    public bean.AudioPhysMapInfo getAudioPhysMapInfo(
    ) {
        return this._audioPhysMapInfo;
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
     * Sets the value of field 'audioPhysIns'.
     * 
     * @param audioPhysIns the value of field 'audioPhysIns'.
     */
    public void setAudioPhysIns(
            final bean.AudioPhysIns audioPhysIns) {
        this._audioPhysIns = audioPhysIns;
    }

    /**
     * Sets the value of field 'audioPhysMapInfo'.
     * 
     * @param audioPhysMapInfo the value of field 'audioPhysMapInfo'
     */
    public void setAudioPhysMapInfo(
            final bean.AudioPhysMapInfo audioPhysMapInfo) {
        this._audioPhysMapInfo = audioPhysMapInfo;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.AudioSnell
     */
    public static bean.AudioSnell unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.AudioSnell) Unmarshaller.unmarshal(bean.AudioSnell.class, reader);
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
