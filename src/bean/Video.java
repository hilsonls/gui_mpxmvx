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
 * Class Video.
 * 
 * @version $Revision$ $Date$
 */
public class Video implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _videoPhysMapInfo.
     */
    private bean.VideoPhysMapInfo _videoPhysMapInfo;

    /**
     * Field _videoPhysIns.
     */
    private bean.VideoPhysIns _videoPhysIns;


      //----------------/
     //- Constructors -/
    //----------------/

    public Video() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'videoPhysIns'.
     * 
     * @return the value of field 'VideoPhysIns'.
     */
    public bean.VideoPhysIns getVideoPhysIns(
    ) {
        return this._videoPhysIns;
    }

    /**
     * Returns the value of field 'videoPhysMapInfo'.
     * 
     * @return the value of field 'VideoPhysMapInfo'.
     */
    public bean.VideoPhysMapInfo getVideoPhysMapInfo(
    ) {
        return this._videoPhysMapInfo;
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
     * Sets the value of field 'videoPhysIns'.
     * 
     * @param videoPhysIns the value of field 'videoPhysIns'.
     */
    public void setVideoPhysIns(
            final bean.VideoPhysIns videoPhysIns) {
        this._videoPhysIns = videoPhysIns;
    }

    /**
     * Sets the value of field 'videoPhysMapInfo'.
     * 
     * @param videoPhysMapInfo the value of field 'videoPhysMapInfo'
     */
    public void setVideoPhysMapInfo(
            final bean.VideoPhysMapInfo videoPhysMapInfo) {
        this._videoPhysMapInfo = videoPhysMapInfo;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Video
     */
    public static bean.Video unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Video) Unmarshaller.unmarshal(bean.Video.class, reader);
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
