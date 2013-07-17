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
 * Class PhysMapInfo.
 * 
 * @version $Revision$ $Date$
 */
public class PhysMapInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _numOuts.
     */
    private bean.NumOuts _numOuts;

    /**
     * Field _numInsSierra.
     */
    private bean.NumInsSierra _numInsSierra;

    /**
     * Field _numLvls.
     */
    private bean.NumLvls _numLvls;


      //----------------/
     //- Constructors -/
    //----------------/

    public PhysMapInfo() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'numInsSierra'.
     * 
     * @return the value of field 'NumInsSierra'.
     */
    public bean.NumInsSierra getNumInsSierra(
    ) {
        return this._numInsSierra;
    }

    /**
     * Returns the value of field 'numLvls'.
     * 
     * @return the value of field 'NumLvls'.
     */
    public bean.NumLvls getNumLvls(
    ) {
        return this._numLvls;
    }

    /**
     * Returns the value of field 'numOuts'.
     * 
     * @return the value of field 'NumOuts'.
     */
    public bean.NumOuts getNumOuts(
    ) {
        return this._numOuts;
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
     * Sets the value of field 'numInsSierra'.
     * 
     * @param numInsSierra the value of field 'numInsSierra'.
     */
    public void setNumInsSierra(
            final bean.NumInsSierra numInsSierra) {
        this._numInsSierra = numInsSierra;
    }

    /**
     * Sets the value of field 'numLvls'.
     * 
     * @param numLvls the value of field 'numLvls'.
     */
    public void setNumLvls(
            final bean.NumLvls numLvls) {
        this._numLvls = numLvls;
    }

    /**
     * Sets the value of field 'numOuts'.
     * 
     * @param numOuts the value of field 'numOuts'.
     */
    public void setNumOuts(
            final bean.NumOuts numOuts) {
        this._numOuts = numOuts;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.PhysMapInfo
     */
    public static bean.PhysMapInfo unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.PhysMapInfo) Unmarshaller.unmarshal(bean.PhysMapInfo.class, reader);
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
