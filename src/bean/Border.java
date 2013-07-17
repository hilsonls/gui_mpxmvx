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
 * Class Border.
 * 
 * @version $Revision$ $Date$
 */
public class Border implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _separator.
     */
    private bean.Separator _separator;

    /**
     * Field _width.
     */
    private bean.Width _width;

    /**
     * Field _colour.
     */
    private bean.Colour _colour;

    /**
     * Field _style.
     */
    private bean.Style _style;

    /**
     * Field _visible.
     */
    private bean.Visible _visible;


      //----------------/
     //- Constructors -/
    //----------------/

    public Border() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'separator'.
     * 
     * @return the value of field 'Separator'.
     */
    public bean.Separator getSeparator(
    ) {
        return this._separator;
    }

    /**
     * Returns the value of field 'style'.
     * 
     * @return the value of field 'Style'.
     */
    public bean.Style getStyle(
    ) {
        return this._style;
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
     * Returns the value of field 'width'.
     * 
     * @return the value of field 'Width'.
     */
    public bean.Width getWidth(
    ) {
        return this._width;
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
     * Sets the value of field 'colour'.
     * 
     * @param colour the value of field 'colour'.
     */
    public void setColour(
            final bean.Colour colour) {
        this._colour = colour;
    }

    /**
     * Sets the value of field 'separator'.
     * 
     * @param separator the value of field 'separator'.
     */
    public void setSeparator(
            final bean.Separator separator) {
        this._separator = separator;
    }

    /**
     * Sets the value of field 'style'.
     * 
     * @param style the value of field 'style'.
     */
    public void setStyle(
            final bean.Style style) {
        this._style = style;
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
     * Sets the value of field 'width'.
     * 
     * @param width the value of field 'width'.
     */
    public void setWidth(
            final bean.Width width) {
        this._width = width;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Border
     */
    public static bean.Border unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Border) Unmarshaller.unmarshal(bean.Border.class, reader);
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
