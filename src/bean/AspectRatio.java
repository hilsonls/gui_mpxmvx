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
 * Class AspectRatio.
 * 
 * @version $Revision$ $Date$
 */
public class AspectRatio extends bean.ObjectStringProperty 
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
     * Field _float.
     */
    private java.lang.String _float;

    /**
     * Field _extX.
     */
    private int _extX;

    /**
     * keeps track of state for field: _extX
     */
    private boolean _has_extX;

    /**
     * Field _extY.
     */
    private int _extY;

    /**
     * keeps track of state for field: _extY
     */
    private boolean _has_extY;


      //----------------/
     //- Constructors -/
    //----------------/

    public AspectRatio() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteExtX(
    ) {
        this._has_extX= false;
    }

    /**
     */
    public void deleteExtY(
    ) {
        this._has_extY= false;
    }

    /**
     * Returns the value of field 'extX'.
     * 
     * @return the value of field 'ExtX'.
     */
    public int getExtX(
    ) {
        return this._extX;
    }

    /**
     * Returns the value of field 'extY'.
     * 
     * @return the value of field 'ExtY'.
     */
    public int getExtY(
    ) {
        return this._extY;
    }

    /**
     * Returns the value of field 'float'.
     * 
     * @return the value of field 'Float'.
     */
    public java.lang.String getFloat(
    ) {
        return this._float;
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
     * Method hasExtX.
     * 
     * @return true if at least one ExtX has been added
     */
    public boolean hasExtX(
    ) {
        return this._has_extX;
    }

    /**
     * Method hasExtY.
     * 
     * @return true if at least one ExtY has been added
     */
    public boolean hasExtY(
    ) {
        return this._has_extY;
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
     * Sets the value of field 'extX'.
     * 
     * @param extX the value of field 'extX'.
     */
    public void setExtX(
            final int extX) {
        this._extX = extX;
        this._has_extX = true;
    }

    /**
     * Sets the value of field 'extY'.
     * 
     * @param extY the value of field 'extY'.
     */
    public void setExtY(
            final int extY) {
        this._extY = extY;
        this._has_extY = true;
    }

    /**
     * Sets the value of field 'float'.
     * 
     * @param _float
     * @param float the value of field 'float'.
     */
    public void setFloat(
            final java.lang.String _float) {
        this._float = _float;
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
        return (bean.ObjectStringProperty) Unmarshaller.unmarshal(bean.AspectRatio.class, reader);
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
