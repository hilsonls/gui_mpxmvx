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
 * Class Bkgnd.
 * 
 * @version $Revision$ $Date$
 */
public class Bkgnd implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _colour.
     */
    private bean.Colour _colour;

    /**
     * Field _useBitmap.
     */
    private bean.UseBitmap _useBitmap;

    /**
     * Field _bitmapFile.
     */
    private bean.BitmapFile _bitmapFile;

    /**
     * Field _style.
     */
    private bean.Style _style;


      //----------------/
     //- Constructors -/
    //----------------/

    public Bkgnd() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'bitmapFile'.
     * 
     * @return the value of field 'BitmapFile'.
     */
    public bean.BitmapFile getBitmapFile(
    ) {
        return this._bitmapFile;
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
     * Returns the value of field 'style'.
     * 
     * @return the value of field 'Style'.
     */
    public bean.Style getStyle(
    ) {
        return this._style;
    }

    /**
     * Returns the value of field 'useBitmap'.
     * 
     * @return the value of field 'UseBitmap'.
     */
    public bean.UseBitmap getUseBitmap(
    ) {
        return this._useBitmap;
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
     * Sets the value of field 'bitmapFile'.
     * 
     * @param bitmapFile the value of field 'bitmapFile'.
     */
    public void setBitmapFile(
            final bean.BitmapFile bitmapFile) {
        this._bitmapFile = bitmapFile;
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
     * Sets the value of field 'style'.
     * 
     * @param style the value of field 'style'.
     */
    public void setStyle(
            final bean.Style style) {
        this._style = style;
    }

    /**
     * Sets the value of field 'useBitmap'.
     * 
     * @param useBitmap the value of field 'useBitmap'.
     */
    public void setUseBitmap(
            final bean.UseBitmap useBitmap) {
        this._useBitmap = useBitmap;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Bkgnd
     */
    public static bean.Bkgnd unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Bkgnd) Unmarshaller.unmarshal(bean.Bkgnd.class, reader);
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
