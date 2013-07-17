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
 * Class GpiInfo.
 * 
 * @version $Revision$ $Date$
 */
public class GpiInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _gpiOptionTables.
     */
    private bean.GpiOptionTables _gpiOptionTables;

    /**
     * Field _numIns.
     */
    private bean.NumIns _numIns;

    /**
     * Field _gpiNumOuts.
     */
    private bean.GpiNumOuts _gpiNumOuts;


      //----------------/
     //- Constructors -/
    //----------------/

    public GpiInfo() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'gpiNumOuts'.
     * 
     * @return the value of field 'GpiNumOuts'.
     */
    public bean.GpiNumOuts getGpiNumOuts(
    ) {
        return this._gpiNumOuts;
    }

    /**
     * Returns the value of field 'gpiOptionTables'.
     * 
     * @return the value of field 'GpiOptionTables'.
     */
    public bean.GpiOptionTables getGpiOptionTables(
    ) {
        return this._gpiOptionTables;
    }

    /**
     * Returns the value of field 'numIns'.
     * 
     * @return the value of field 'NumIns'.
     */
    public bean.NumIns getNumIns(
    ) {
        return this._numIns;
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
     * Sets the value of field 'gpiNumOuts'.
     * 
     * @param gpiNumOuts the value of field 'gpiNumOuts'.
     */
    public void setGpiNumOuts(
            final bean.GpiNumOuts gpiNumOuts) {
        this._gpiNumOuts = gpiNumOuts;
    }

    /**
     * Sets the value of field 'gpiOptionTables'.
     * 
     * @param gpiOptionTables the value of field 'gpiOptionTables'.
     */
    public void setGpiOptionTables(
            final bean.GpiOptionTables gpiOptionTables) {
        this._gpiOptionTables = gpiOptionTables;
    }

    /**
     * Sets the value of field 'numIns'.
     * 
     * @param numIns the value of field 'numIns'.
     */
    public void setNumIns(
            final bean.NumIns numIns) {
        this._numIns = numIns;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.GpiInfo
     */
    public static bean.GpiInfo unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.GpiInfo) Unmarshaller.unmarshal(bean.GpiInfo.class, reader);
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
