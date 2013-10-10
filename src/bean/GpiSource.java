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
 * Class GpiSource.
 * 
 * @version $Revision$ $Date$
 */
public class GpiSource extends bean.ObjectStringProperty 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _mode.
     */
    private int _mode;

    /**
     * keeps track of state for field: _mode
     */
    private boolean _has_mode;

    /**
     * Field _gpip.
     */
    private java.lang.String _gpip;

    /**
     * Field _gpir.
     */
    private java.lang.String _gpir;

    /**
     * Field _optionsName.
     */
    private java.lang.String _optionsName;


      //----------------/
     //- Constructors -/
    //----------------/

    public GpiSource() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteMode(
    ) {
        this._has_mode= false;
    }

    /**
     * Returns the value of field 'gpip'.
     * 
     * @return the value of field 'Gpip'.
     */
    public java.lang.String getGpip(
    ) {
        return this._gpip;
    }

    /**
     * Returns the value of field 'gpir'.
     * 
     * @return the value of field 'Gpir'.
     */
    public java.lang.String getGpir(
    ) {
        return this._gpir;
    }

    /**
     * Returns the value of field 'mode'.
     * 
     * @return the value of field 'Mode'.
     */
    public int getMode(
    ) {
        return this._mode;
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
     * Method hasMode.
     * 
     * @return true if at least one Mode has been added
     */
    public boolean hasMode(
    ) {
        return this._has_mode;
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
     * Sets the value of field 'gpip'.
     * 
     * @param gpip the value of field 'gpip'.
     */
    public void setGpip(
            final java.lang.String gpip) {
        this._gpip = gpip;
    }

    /**
     * Sets the value of field 'gpir'.
     * 
     * @param gpir the value of field 'gpir'.
     */
    public void setGpir(
            final java.lang.String gpir) {
        this._gpir = gpir;
    }

    /**
     * Sets the value of field 'mode'.
     * 
     * @param mode the value of field 'mode'.
     */
    public void setMode(
            final int mode) {
        this._mode = mode;
        this._has_mode = true;
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
        return (bean.ObjectStringProperty) Unmarshaller.unmarshal(bean.GpiSource.class, reader);
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
