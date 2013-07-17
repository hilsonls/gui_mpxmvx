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
 * Class VideoPhysMapInfo.
 * 
 * @version $Revision$ $Date$
 */
public class VideoPhysMapInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _videoPhysMapInfoNumIns.
     */
    private bean.VideoPhysMapInfoNumIns _videoPhysMapInfoNumIns;

    /**
     * Field _videoPhysMapInfoNumOuts.
     */
    private bean.VideoPhysMapInfoNumOuts _videoPhysMapInfoNumOuts;

    /**
     * Field _videoPhysMapInfoNumLvls.
     */
    private bean.VideoPhysMapInfoNumLvls _videoPhysMapInfoNumLvls;

    /**
     * Field _numMats.
     */
    private bean.NumMats _numMats;

    /**
     * Field _numDass.
     */
    private bean.NumDass _numDass;


      //----------------/
     //- Constructors -/
    //----------------/

    public VideoPhysMapInfo() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'numDass'.
     * 
     * @return the value of field 'NumDass'.
     */
    public bean.NumDass getNumDass(
    ) {
        return this._numDass;
    }

    /**
     * Returns the value of field 'numMats'.
     * 
     * @return the value of field 'NumMats'.
     */
    public bean.NumMats getNumMats(
    ) {
        return this._numMats;
    }

    /**
     * Returns the value of field 'videoPhysMapInfoNumIns'.
     * 
     * @return the value of field 'VideoPhysMapInfoNumIns'.
     */
    public bean.VideoPhysMapInfoNumIns getVideoPhysMapInfoNumIns(
    ) {
        return this._videoPhysMapInfoNumIns;
    }

    /**
     * Returns the value of field 'videoPhysMapInfoNumLvls'.
     * 
     * @return the value of field 'VideoPhysMapInfoNumLvls'.
     */
    public bean.VideoPhysMapInfoNumLvls getVideoPhysMapInfoNumLvls(
    ) {
        return this._videoPhysMapInfoNumLvls;
    }

    /**
     * Returns the value of field 'videoPhysMapInfoNumOuts'.
     * 
     * @return the value of field 'VideoPhysMapInfoNumOuts'.
     */
    public bean.VideoPhysMapInfoNumOuts getVideoPhysMapInfoNumOuts(
    ) {
        return this._videoPhysMapInfoNumOuts;
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
     * Sets the value of field 'numDass'.
     * 
     * @param numDass the value of field 'numDass'.
     */
    public void setNumDass(
            final bean.NumDass numDass) {
        this._numDass = numDass;
    }

    /**
     * Sets the value of field 'numMats'.
     * 
     * @param numMats the value of field 'numMats'.
     */
    public void setNumMats(
            final bean.NumMats numMats) {
        this._numMats = numMats;
    }

    /**
     * Sets the value of field 'videoPhysMapInfoNumIns'.
     * 
     * @param videoPhysMapInfoNumIns the value of field
     * 'videoPhysMapInfoNumIns'.
     */
    public void setVideoPhysMapInfoNumIns(
            final bean.VideoPhysMapInfoNumIns videoPhysMapInfoNumIns) {
        this._videoPhysMapInfoNumIns = videoPhysMapInfoNumIns;
    }

    /**
     * Sets the value of field 'videoPhysMapInfoNumLvls'.
     * 
     * @param videoPhysMapInfoNumLvls the value of field
     * 'videoPhysMapInfoNumLvls'.
     */
    public void setVideoPhysMapInfoNumLvls(
            final bean.VideoPhysMapInfoNumLvls videoPhysMapInfoNumLvls) {
        this._videoPhysMapInfoNumLvls = videoPhysMapInfoNumLvls;
    }

    /**
     * Sets the value of field 'videoPhysMapInfoNumOuts'.
     * 
     * @param videoPhysMapInfoNumOuts the value of field
     * 'videoPhysMapInfoNumOuts'.
     */
    public void setVideoPhysMapInfoNumOuts(
            final bean.VideoPhysMapInfoNumOuts videoPhysMapInfoNumOuts) {
        this._videoPhysMapInfoNumOuts = videoPhysMapInfoNumOuts;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.VideoPhysMapInfo
     */
    public static bean.VideoPhysMapInfo unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.VideoPhysMapInfo) Unmarshaller.unmarshal(bean.VideoPhysMapInfo.class, reader);
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
