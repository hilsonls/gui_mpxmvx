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
 * Class DataxxPhysMapInfo.
 * 
 * @version $Revision$ $Date$
 */
public class DataxxPhysMapInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _dataxxPhysMapInfoNumIns.
     */
    private bean.DataxxPhysMapInfoNumIns _dataxxPhysMapInfoNumIns;

    /**
     * Field _dataxxPhysMapInfoNumOuts.
     */
    private bean.DataxxPhysMapInfoNumOuts _dataxxPhysMapInfoNumOuts;

    /**
     * Field _dataxxPhysMapInfoNumLvls.
     */
    private bean.DataxxPhysMapInfoNumLvls _dataxxPhysMapInfoNumLvls;

    /**
     * Field _dataxxPhysMapInfoNumMats.
     */
    private bean.DataxxPhysMapInfoNumMats _dataxxPhysMapInfoNumMats;

    /**
     * Field _dataxxPhysMapInfoNumDass.
     */
    private bean.DataxxPhysMapInfoNumDass _dataxxPhysMapInfoNumDass;


      //----------------/
     //- Constructors -/
    //----------------/

    public DataxxPhysMapInfo() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'dataxxPhysMapInfoNumDass'.
     * 
     * @return the value of field 'DataxxPhysMapInfoNumDass'.
     */
    public bean.DataxxPhysMapInfoNumDass getDataxxPhysMapInfoNumDass(
    ) {
        return this._dataxxPhysMapInfoNumDass;
    }

    /**
     * Returns the value of field 'dataxxPhysMapInfoNumIns'.
     * 
     * @return the value of field 'DataxxPhysMapInfoNumIns'.
     */
    public bean.DataxxPhysMapInfoNumIns getDataxxPhysMapInfoNumIns(
    ) {
        return this._dataxxPhysMapInfoNumIns;
    }

    /**
     * Returns the value of field 'dataxxPhysMapInfoNumLvls'.
     * 
     * @return the value of field 'DataxxPhysMapInfoNumLvls'.
     */
    public bean.DataxxPhysMapInfoNumLvls getDataxxPhysMapInfoNumLvls(
    ) {
        return this._dataxxPhysMapInfoNumLvls;
    }

    /**
     * Returns the value of field 'dataxxPhysMapInfoNumMats'.
     * 
     * @return the value of field 'DataxxPhysMapInfoNumMats'.
     */
    public bean.DataxxPhysMapInfoNumMats getDataxxPhysMapInfoNumMats(
    ) {
        return this._dataxxPhysMapInfoNumMats;
    }

    /**
     * Returns the value of field 'dataxxPhysMapInfoNumOuts'.
     * 
     * @return the value of field 'DataxxPhysMapInfoNumOuts'.
     */
    public bean.DataxxPhysMapInfoNumOuts getDataxxPhysMapInfoNumOuts(
    ) {
        return this._dataxxPhysMapInfoNumOuts;
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
     * Sets the value of field 'dataxxPhysMapInfoNumDass'.
     * 
     * @param dataxxPhysMapInfoNumDass the value of field
     * 'dataxxPhysMapInfoNumDass'.
     */
    public void setDataxxPhysMapInfoNumDass(
            final bean.DataxxPhysMapInfoNumDass dataxxPhysMapInfoNumDass) {
        this._dataxxPhysMapInfoNumDass = dataxxPhysMapInfoNumDass;
    }

    /**
     * Sets the value of field 'dataxxPhysMapInfoNumIns'.
     * 
     * @param dataxxPhysMapInfoNumIns the value of field
     * 'dataxxPhysMapInfoNumIns'.
     */
    public void setDataxxPhysMapInfoNumIns(
            final bean.DataxxPhysMapInfoNumIns dataxxPhysMapInfoNumIns) {
        this._dataxxPhysMapInfoNumIns = dataxxPhysMapInfoNumIns;
    }

    /**
     * Sets the value of field 'dataxxPhysMapInfoNumLvls'.
     * 
     * @param dataxxPhysMapInfoNumLvls the value of field
     * 'dataxxPhysMapInfoNumLvls'.
     */
    public void setDataxxPhysMapInfoNumLvls(
            final bean.DataxxPhysMapInfoNumLvls dataxxPhysMapInfoNumLvls) {
        this._dataxxPhysMapInfoNumLvls = dataxxPhysMapInfoNumLvls;
    }

    /**
     * Sets the value of field 'dataxxPhysMapInfoNumMats'.
     * 
     * @param dataxxPhysMapInfoNumMats the value of field
     * 'dataxxPhysMapInfoNumMats'.
     */
    public void setDataxxPhysMapInfoNumMats(
            final bean.DataxxPhysMapInfoNumMats dataxxPhysMapInfoNumMats) {
        this._dataxxPhysMapInfoNumMats = dataxxPhysMapInfoNumMats;
    }

    /**
     * Sets the value of field 'dataxxPhysMapInfoNumOuts'.
     * 
     * @param dataxxPhysMapInfoNumOuts the value of field
     * 'dataxxPhysMapInfoNumOuts'.
     */
    public void setDataxxPhysMapInfoNumOuts(
            final bean.DataxxPhysMapInfoNumOuts dataxxPhysMapInfoNumOuts) {
        this._dataxxPhysMapInfoNumOuts = dataxxPhysMapInfoNumOuts;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.DataxxPhysMapInfo
     */
    public static bean.DataxxPhysMapInfo unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.DataxxPhysMapInfo) Unmarshaller.unmarshal(bean.DataxxPhysMapInfo.class, reader);
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
