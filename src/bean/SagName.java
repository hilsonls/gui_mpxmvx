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
 * Class SagName.
 * 
 * @version $Revision$ $Date$
 */
public class SagName implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _val.
     */
    private java.lang.String _val;

    /**
     * Field _hborder.
     */
    private float _hborder;

    /**
     * keeps track of state for field: _hborder
     */
    private boolean _has_hborder;

    /**
     * Field _vborder.
     */
    private float _vborder;

    /**
     * keeps track of state for field: _vborder
     */
    private boolean _has_vborder;


      //----------------/
     //- Constructors -/
    //----------------/

    public SagName() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteHborder(
    ) {
        this._has_hborder= false;
    }

    /**
     */
    public void deleteVborder(
    ) {
        this._has_vborder= false;
    }

    /**
     * Returns the value of field 'hborder'.
     * 
     * @return the value of field 'Hborder'.
     */
    public float getHborder(
    ) {
        return this._hborder;
    }

    /**
     * Returns the value of field 'val'.
     * 
     * @return the value of field 'Val'.
     */
    public java.lang.String getVal(
    ) {
        return this._val;
    }

    /**
     * Returns the value of field 'vborder'.
     * 
     * @return the value of field 'Vborder'.
     */
    public float getVborder(
    ) {
        return this._vborder;
    }

    /**
     * Method hasHborder.
     * 
     * @return true if at least one Hborder has been added
     */
    public boolean hasHborder(
    ) {
        return this._has_hborder;
    }

    /**
     * Method hasVborder.
     * 
     * @return true if at least one Vborder has been added
     */
    public boolean hasVborder(
    ) {
        return this._has_vborder;
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
     * Sets the value of field 'hborder'.
     * 
     * @param hborder the value of field 'hborder'.
     */
    public void setHborder(
            final float hborder) {
        this._hborder = hborder;
        this._has_hborder = true;
    }

    /**
     * Sets the value of field 'val'.
     * 
     * @param val the value of field 'val'.
     */
    public void setVal(
            final java.lang.String val) {
        this._val = val;
    }

    /**
     * Sets the value of field 'vborder'.
     * 
     * @param vborder the value of field 'vborder'.
     */
    public void setVborder(
            final float vborder) {
        this._vborder = vborder;
        this._has_vborder = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.SagName
     */
    public static bean.SagName unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.SagName) Unmarshaller.unmarshal(bean.SagName.class, reader);
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
