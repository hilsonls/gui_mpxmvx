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
 * Class Error.
 * 
 * @version $Revision$ $Date$
 */
public class Error implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _colour.
     */
    private bean.Colour _colour;

    /**
     * Field _clearColour.
     */
    private bean.ClearColour _clearColour;

    /**
     * Field _showName.
     */
    private bean.ShowName _showName;

    /**
     * Field _visible.
     */
    private bean.Visible _visible;

    /**
     * Field _objectErrorMsgSize.
     */
    private bean.ObjectErrorMsgSize _objectErrorMsgSize;


      //----------------/
     //- Constructors -/
    //----------------/

    public Error() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'clearColour'.
     * 
     * @return the value of field 'ClearColour'.
     */
    public bean.ClearColour getClearColour(
    ) {
        return this._clearColour;
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
     * Returns the value of field 'objectErrorMsgSize'.
     * 
     * @return the value of field 'ObjectErrorMsgSize'.
     */
    public bean.ObjectErrorMsgSize getObjectErrorMsgSize(
    ) {
        return this._objectErrorMsgSize;
    }

    /**
     * Returns the value of field 'showName'.
     * 
     * @return the value of field 'ShowName'.
     */
    public bean.ShowName getShowName(
    ) {
        return this._showName;
    }

    /**
     * Returns the value of field 'visible'.
     * 
     * @return the value of field 'Visible'.
     */
    public bean.Visible getVisible(
    ) {
        return this._visible;
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
     * Sets the value of field 'clearColour'.
     * 
     * @param clearColour the value of field 'clearColour'.
     */
    public void setClearColour(
            final bean.ClearColour clearColour) {
        this._clearColour = clearColour;
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
     * Sets the value of field 'objectErrorMsgSize'.
     * 
     * @param objectErrorMsgSize the value of field
     * 'objectErrorMsgSize'.
     */
    public void setObjectErrorMsgSize(
            final bean.ObjectErrorMsgSize objectErrorMsgSize) {
        this._objectErrorMsgSize = objectErrorMsgSize;
    }

    /**
     * Sets the value of field 'showName'.
     * 
     * @param showName the value of field 'showName'.
     */
    public void setShowName(
            final bean.ShowName showName) {
        this._showName = showName;
    }

    /**
     * Sets the value of field 'visible'.
     * 
     * @param visible the value of field 'visible'.
     */
    public void setVisible(
            final bean.Visible visible) {
        this._visible = visible;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Error
     */
    public static bean.Error unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Error) Unmarshaller.unmarshal(bean.Error.class, reader);
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
