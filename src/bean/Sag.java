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
 * Class Sag.
 * 
 * @version $Revision$ $Date$
 */
public class Sag implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sagVisible.
     */
    private bean.SagVisible _sagVisible;

    /**
     * Field _preset.
     */
    private bean.Preset _preset;

    /**
     * Field _useCustom.
     */
    private bean.UseCustom _useCustom;

    /**
     * Field _vborderCustom.
     */
    private bean.VborderCustom _vborderCustom;

    /**
     * Field _hborderCustom.
     */
    private bean.HborderCustom _hborderCustom;


      //----------------/
     //- Constructors -/
    //----------------/

    public Sag() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'hborderCustom'.
     * 
     * @return the value of field 'HborderCustom'.
     */
    public bean.HborderCustom getHborderCustom(
    ) {
        return this._hborderCustom;
    }

    /**
     * Returns the value of field 'preset'.
     * 
     * @return the value of field 'Preset'.
     */
    public bean.Preset getPreset(
    ) {
        return this._preset;
    }

    /**
     * Returns the value of field 'sagVisible'.
     * 
     * @return the value of field 'SagVisible'.
     */
    public bean.SagVisible getSagVisible(
    ) {
        return this._sagVisible;
    }

    /**
     * Returns the value of field 'useCustom'.
     * 
     * @return the value of field 'UseCustom'.
     */
    public bean.UseCustom getUseCustom(
    ) {
        return this._useCustom;
    }

    /**
     * Returns the value of field 'vborderCustom'.
     * 
     * @return the value of field 'VborderCustom'.
     */
    public bean.VborderCustom getVborderCustom(
    ) {
        return this._vborderCustom;
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
     * Sets the value of field 'hborderCustom'.
     * 
     * @param hborderCustom the value of field 'hborderCustom'.
     */
    public void setHborderCustom(
            final bean.HborderCustom hborderCustom) {
        this._hborderCustom = hborderCustom;
    }

    /**
     * Sets the value of field 'preset'.
     * 
     * @param preset the value of field 'preset'.
     */
    public void setPreset(
            final bean.Preset preset) {
        this._preset = preset;
    }

    /**
     * Sets the value of field 'sagVisible'.
     * 
     * @param sagVisible the value of field 'sagVisible'.
     */
    public void setSagVisible(
            final bean.SagVisible sagVisible) {
        this._sagVisible = sagVisible;
    }

    /**
     * Sets the value of field 'useCustom'.
     * 
     * @param useCustom the value of field 'useCustom'.
     */
    public void setUseCustom(
            final bean.UseCustom useCustom) {
        this._useCustom = useCustom;
    }

    /**
     * Sets the value of field 'vborderCustom'.
     * 
     * @param vborderCustom the value of field 'vborderCustom'.
     */
    public void setVborderCustom(
            final bean.VborderCustom vborderCustom) {
        this._vborderCustom = vborderCustom;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Sag
     */
    public static bean.Sag unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Sag) Unmarshaller.unmarshal(bean.Sag.class, reader);
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
