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
 * Class Product.
 * 
 * @version $Revision$ $Date$
 */
public class Product implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _company.
     */
    private java.lang.String _company;

    /**
     * Field _model.
     */
    private java.lang.String _model;

    /**
     * Field _type.
     */
    private java.lang.String _type;

    /**
     * Field _numVidInputs.
     */
    private int _numVidInputs;

    /**
     * keeps track of state for field: _numVidInputs
     */
    private boolean _has_numVidInputs;

    /**
     * Field _maxVidInputs.
     */
    private int _maxVidInputs;

    /**
     * keeps track of state for field: _maxVidInputs
     */
    private boolean _has_maxVidInputs;


      //----------------/
     //- Constructors -/
    //----------------/

    public Product() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteMaxVidInputs(
    ) {
        this._has_maxVidInputs= false;
    }

    /**
     */
    public void deleteNumVidInputs(
    ) {
        this._has_numVidInputs= false;
    }

    /**
     * Returns the value of field 'company'.
     * 
     * @return the value of field 'Company'.
     */
    public java.lang.String getCompany(
    ) {
        return this._company;
    }

    /**
     * Returns the value of field 'maxVidInputs'.
     * 
     * @return the value of field 'MaxVidInputs'.
     */
    public int getMaxVidInputs(
    ) {
        return this._maxVidInputs;
    }

    /**
     * Returns the value of field 'model'.
     * 
     * @return the value of field 'Model'.
     */
    public java.lang.String getModel(
    ) {
        return this._model;
    }

    /**
     * Returns the value of field 'numVidInputs'.
     * 
     * @return the value of field 'NumVidInputs'.
     */
    public int getNumVidInputs(
    ) {
        return this._numVidInputs;
    }

    /**
     * Returns the value of field 'type'.
     * 
     * @return the value of field 'Type'.
     */
    public java.lang.String getType(
    ) {
        return this._type;
    }

    /**
     * Method hasMaxVidInputs.
     * 
     * @return true if at least one MaxVidInputs has been added
     */
    public boolean hasMaxVidInputs(
    ) {
        return this._has_maxVidInputs;
    }

    /**
     * Method hasNumVidInputs.
     * 
     * @return true if at least one NumVidInputs has been added
     */
    public boolean hasNumVidInputs(
    ) {
        return this._has_numVidInputs;
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
     * Sets the value of field 'company'.
     * 
     * @param company the value of field 'company'.
     */
    public void setCompany(
            final java.lang.String company) {
        this._company = company;
    }

    /**
     * Sets the value of field 'maxVidInputs'.
     * 
     * @param maxVidInputs the value of field 'maxVidInputs'.
     */
    public void setMaxVidInputs(
            final int maxVidInputs) {
        this._maxVidInputs = maxVidInputs;
        this._has_maxVidInputs = true;
    }

    /**
     * Sets the value of field 'model'.
     * 
     * @param model the value of field 'model'.
     */
    public void setModel(
            final java.lang.String model) {
        this._model = model;
    }

    /**
     * Sets the value of field 'numVidInputs'.
     * 
     * @param numVidInputs the value of field 'numVidInputs'.
     */
    public void setNumVidInputs(
            final int numVidInputs) {
        this._numVidInputs = numVidInputs;
        this._has_numVidInputs = true;
    }

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(
            final java.lang.String type) {
        this._type = type;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Product
     */
    public static bean.Product unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Product) Unmarshaller.unmarshal(bean.Product.class, reader);
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
