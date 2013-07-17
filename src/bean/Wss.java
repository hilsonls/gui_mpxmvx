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
 * Class Wss.
 * 
 * @version $Revision$ $Date$
 */
public class Wss implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _mode.
     */
    private bean.Mode _mode;

    /**
     * Field _colour.
     */
    private bean.Colour _colour;

    /**
     * Field _aspectEnabled.
     */
    private bean.AspectEnabled _aspectEnabled;

    /**
     * Field _aspectDefault.
     */
    private bean.AspectDefault _aspectDefault;

    /**
     * Field _aspectIndicator.
     */
    private bean.AspectIndicator _aspectIndicator;


      //----------------/
     //- Constructors -/
    //----------------/

    public Wss() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'aspectDefault'.
     * 
     * @return the value of field 'AspectDefault'.
     */
    public bean.AspectDefault getAspectDefault(
    ) {
        return this._aspectDefault;
    }

    /**
     * Returns the value of field 'aspectEnabled'.
     * 
     * @return the value of field 'AspectEnabled'.
     */
    public bean.AspectEnabled getAspectEnabled(
    ) {
        return this._aspectEnabled;
    }

    /**
     * Returns the value of field 'aspectIndicator'.
     * 
     * @return the value of field 'AspectIndicator'.
     */
    public bean.AspectIndicator getAspectIndicator(
    ) {
        return this._aspectIndicator;
    }

    /**
     * Returns the value of field 'colour'.
     * 
     * @return the value of field 'Colour'.
     */
    public bean.Colour getColour(
    ) {
        return this._colour;
    }

    /**
     * Returns the value of field 'mode'.
     * 
     * @return the value of field 'Mode'.
     */
    public bean.Mode getMode(
    ) {
        return this._mode;
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
     * Sets the value of field 'aspectDefault'.
     * 
     * @param aspectDefault the value of field 'aspectDefault'.
     */
    public void setAspectDefault(
            final bean.AspectDefault aspectDefault) {
        this._aspectDefault = aspectDefault;
    }

    /**
     * Sets the value of field 'aspectEnabled'.
     * 
     * @param aspectEnabled the value of field 'aspectEnabled'.
     */
    public void setAspectEnabled(
            final bean.AspectEnabled aspectEnabled) {
        this._aspectEnabled = aspectEnabled;
    }

    /**
     * Sets the value of field 'aspectIndicator'.
     * 
     * @param aspectIndicator the value of field 'aspectIndicator'.
     */
    public void setAspectIndicator(
            final bean.AspectIndicator aspectIndicator) {
        this._aspectIndicator = aspectIndicator;
    }

    /**
     * Sets the value of field 'colour'.
     * 
     * @param colour the value of field 'colour'.
     */
    public void setColour(
            final bean.Colour colour) {
        this._colour = colour;
    }

    /**
     * Sets the value of field 'mode'.
     * 
     * @param mode the value of field 'mode'.
     */
    public void setMode(
            final bean.Mode mode) {
        this._mode = mode;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Wss
     */
    public static bean.Wss unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Wss) Unmarshaller.unmarshal(bean.Wss.class, reader);
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
