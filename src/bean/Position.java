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
 * Class Position.
 * 
 * @version $Revision$ $Date$
 */
public class Position implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _x.
     */
    private bean.X _x;

    /**
     * Field _y.
     */
    private bean.Y _y;

    /**
     * Field _width.
     */
    private bean.Width _width;

    /**
     * Field _height.
     */
    private bean.Height _height;


      //----------------/
     //- Constructors -/
    //----------------/

    public Position() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'height'.
     * 
     * @return the value of field 'Height'.
     */
    public bean.Height getHeight(
    ) {
        return this._height;
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
     * Returns the value of field 'x'.
     * 
     * @return the value of field 'X'.
     */
    public bean.X getX(
    ) {
        return this._x;
    }

    /**
     * Returns the value of field 'y'.
     * 
     * @return the value of field 'Y'.
     */
    public bean.Y getY(
    ) {
        return this._y;
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
     * Sets the value of field 'height'.
     * 
     * @param height the value of field 'height'.
     */
    public void setHeight(
            final bean.Height height) {
        this._height = height;
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
     * Sets the value of field 'x'.
     * 
     * @param x the value of field 'x'.
     */
    public void setX(
            final bean.X x) {
        this._x = x;
    }

    /**
     * Sets the value of field 'y'.
     * 
     * @param y the value of field 'y'.
     */
    public void setY(
            final bean.Y y) {
        this._y = y;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Position
     */
    public static bean.Position unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Position) Unmarshaller.unmarshal(bean.Position.class, reader);
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
