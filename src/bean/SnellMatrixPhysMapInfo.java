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
 * Class SnellMatrixPhysMapInfo.
 * 
 * @version $Revision$ $Date$
 */
public class SnellMatrixPhysMapInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _snellMatrixNumIns.
     */
    private bean.SnellMatrixNumIns _snellMatrixNumIns;

    /**
     * Field _snellMatrixNumOuts.
     */
    private bean.SnellMatrixNumOuts _snellMatrixNumOuts;

    /**
     * Field _snellMatrixNumLvls.
     */
    private bean.SnellMatrixNumLvls _snellMatrixNumLvls;

    /**
     * Field _snellMatrixNumMats.
     */
    private bean.SnellMatrixNumMats _snellMatrixNumMats;

    /**
     * Field _snellMatrixNumDass.
     */
    private bean.SnellMatrixNumDass _snellMatrixNumDass;


      //----------------/
     //- Constructors -/
    //----------------/

    public SnellMatrixPhysMapInfo() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'snellMatrixNumDass'.
     * 
     * @return the value of field 'SnellMatrixNumDass'.
     */
    public bean.SnellMatrixNumDass getSnellMatrixNumDass(
    ) {
        return this._snellMatrixNumDass;
    }

    /**
     * Returns the value of field 'snellMatrixNumIns'.
     * 
     * @return the value of field 'SnellMatrixNumIns'.
     */
    public bean.SnellMatrixNumIns getSnellMatrixNumIns(
    ) {
        return this._snellMatrixNumIns;
    }

    /**
     * Returns the value of field 'snellMatrixNumLvls'.
     * 
     * @return the value of field 'SnellMatrixNumLvls'.
     */
    public bean.SnellMatrixNumLvls getSnellMatrixNumLvls(
    ) {
        return this._snellMatrixNumLvls;
    }

    /**
     * Returns the value of field 'snellMatrixNumMats'.
     * 
     * @return the value of field 'SnellMatrixNumMats'.
     */
    public bean.SnellMatrixNumMats getSnellMatrixNumMats(
    ) {
        return this._snellMatrixNumMats;
    }

    /**
     * Returns the value of field 'snellMatrixNumOuts'.
     * 
     * @return the value of field 'SnellMatrixNumOuts'.
     */
    public bean.SnellMatrixNumOuts getSnellMatrixNumOuts(
    ) {
        return this._snellMatrixNumOuts;
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
     * Sets the value of field 'snellMatrixNumDass'.
     * 
     * @param snellMatrixNumDass the value of field
     * 'snellMatrixNumDass'.
     */
    public void setSnellMatrixNumDass(
            final bean.SnellMatrixNumDass snellMatrixNumDass) {
        this._snellMatrixNumDass = snellMatrixNumDass;
    }

    /**
     * Sets the value of field 'snellMatrixNumIns'.
     * 
     * @param snellMatrixNumIns the value of field
     * 'snellMatrixNumIns'.
     */
    public void setSnellMatrixNumIns(
            final bean.SnellMatrixNumIns snellMatrixNumIns) {
        this._snellMatrixNumIns = snellMatrixNumIns;
    }

    /**
     * Sets the value of field 'snellMatrixNumLvls'.
     * 
     * @param snellMatrixNumLvls the value of field
     * 'snellMatrixNumLvls'.
     */
    public void setSnellMatrixNumLvls(
            final bean.SnellMatrixNumLvls snellMatrixNumLvls) {
        this._snellMatrixNumLvls = snellMatrixNumLvls;
    }

    /**
     * Sets the value of field 'snellMatrixNumMats'.
     * 
     * @param snellMatrixNumMats the value of field
     * 'snellMatrixNumMats'.
     */
    public void setSnellMatrixNumMats(
            final bean.SnellMatrixNumMats snellMatrixNumMats) {
        this._snellMatrixNumMats = snellMatrixNumMats;
    }

    /**
     * Sets the value of field 'snellMatrixNumOuts'.
     * 
     * @param snellMatrixNumOuts the value of field
     * 'snellMatrixNumOuts'.
     */
    public void setSnellMatrixNumOuts(
            final bean.SnellMatrixNumOuts snellMatrixNumOuts) {
        this._snellMatrixNumOuts = snellMatrixNumOuts;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.SnellMatrixPhysMapInfo
     */
    public static bean.SnellMatrixPhysMapInfo unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.SnellMatrixPhysMapInfo) Unmarshaller.unmarshal(bean.SnellMatrixPhysMapInfo.class, reader);
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
