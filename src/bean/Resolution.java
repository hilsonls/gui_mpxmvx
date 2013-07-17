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
 * Class Resolution.
 * 
 * @version $Revision$ $Date$
 */
public class Resolution extends bean.ObjectStringProperty 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _optionsName.
     */
    private java.lang.String _optionsName;

    /**
     * Field _hres.
     */
    private int _hres;

    /**
     * keeps track of state for field: _hres
     */
    private boolean _has_hres;

    /**
     * Field _vres.
     */
    private int _vres;

    /**
     * keeps track of state for field: _vres
     */
    private boolean _has_vres;


      //----------------/
     //- Constructors -/
    //----------------/

    public Resolution() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteHres(
    ) {
        this._has_hres= false;
    }

    /**
     */
    public void deleteVres(
    ) {
        this._has_vres= false;
    }

    /**
     * Returns the value of field 'hres'.
     * 
     * @return the value of field 'Hres'.
     */
    public int getHres(
    ) {
        return this._hres;
    }

    /**
     * Returns the value of field 'optionsName'.
     * 
     * @return the value of field 'OptionsName'.
     */
    public java.lang.String getOptionsName(
    ) {
        return this._optionsName;
    }

    /**
     * Returns the value of field 'vres'.
     * 
     * @return the value of field 'Vres'.
     */
    public int getVres(
    ) {
        return this._vres;
    }

    /**
     * Method hasHres.
     * 
     * @return true if at least one Hres has been added
     */
    public boolean hasHres(
    ) {
        return this._has_hres;
    }

    /**
     * Method hasVres.
     * 
     * @return true if at least one Vres has been added
     */
    public boolean hasVres(
    ) {
        return this._has_vres;
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
     * Sets the value of field 'hres'.
     * 
     * @param hres the value of field 'hres'.
     */
    public void setHres(
            final int hres) {
        this._hres = hres;
        this._has_hres = true;
    }

    /**
     * Sets the value of field 'optionsName'.
     * 
     * @param optionsName the value of field 'optionsName'.
     */
    public void setOptionsName(
            final java.lang.String optionsName) {
        this._optionsName = optionsName;
    }

    /**
     * Sets the value of field 'vres'.
     * 
     * @param vres the value of field 'vres'.
     */
    public void setVres(
            final int vres) {
        this._vres = vres;
        this._has_vres = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.ObjectStringProperty
     */
    public static bean.ObjectStringProperty unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.ObjectStringProperty) Unmarshaller.unmarshal(bean.Resolution.class, reader);
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
