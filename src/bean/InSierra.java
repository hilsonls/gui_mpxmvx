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
 * Class InSierra.
 * 
 * @version $Revision$ $Date$
 */
public class InSierra implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id.
     */
    private int _id;

    /**
     * keeps track of state for field: _id
     */
    private boolean _has_id;

    /**
     * Field _out.
     */
    private int _out;

    /**
     * keeps track of state for field: _out
     */
    private boolean _has_out;

    /**
     * Field _lvl.
     */
    private int _lvl;

    /**
     * keeps track of state for field: _lvl
     */
    private boolean _has_lvl;

    /**
     * Field _en.
     */
    private boolean _en;

    /**
     * keeps track of state for field: _en
     */
    private boolean _has_en;


      //----------------/
     //- Constructors -/
    //----------------/

    public InSierra() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteEn(
    ) {
        this._has_en= false;
    }

    /**
     */
    public void deleteId(
    ) {
        this._has_id= false;
    }

    /**
     */
    public void deleteLvl(
    ) {
        this._has_lvl= false;
    }

    /**
     */
    public void deleteOut(
    ) {
        this._has_out= false;
    }

    /**
     * Returns the value of field 'en'.
     * 
     * @return the value of field 'En'.
     */
    public boolean getEn(
    ) {
        return this._en;
    }

    /**
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'Id'.
     */
    public int getId(
    ) {
        return this._id;
    }

    /**
     * Returns the value of field 'lvl'.
     * 
     * @return the value of field 'Lvl'.
     */
    public int getLvl(
    ) {
        return this._lvl;
    }

    /**
     * Returns the value of field 'out'.
     * 
     * @return the value of field 'Out'.
     */
    public int getOut(
    ) {
        return this._out;
    }

    /**
     * Method hasEn.
     * 
     * @return true if at least one En has been added
     */
    public boolean hasEn(
    ) {
        return this._has_en;
    }

    /**
     * Method hasId.
     * 
     * @return true if at least one Id has been added
     */
    public boolean hasId(
    ) {
        return this._has_id;
    }

    /**
     * Method hasLvl.
     * 
     * @return true if at least one Lvl has been added
     */
    public boolean hasLvl(
    ) {
        return this._has_lvl;
    }

    /**
     * Method hasOut.
     * 
     * @return true if at least one Out has been added
     */
    public boolean hasOut(
    ) {
        return this._has_out;
    }

    /**
     * Returns the value of field 'en'.
     * 
     * @return the value of field 'En'.
     */
    public boolean isEn(
    ) {
        return this._en;
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
     * Sets the value of field 'en'.
     * 
     * @param en the value of field 'en'.
     */
    public void setEn(
            final boolean en) {
        this._en = en;
        this._has_en = true;
    }

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(
            final int id) {
        this._id = id;
        this._has_id = true;
    }

    /**
     * Sets the value of field 'lvl'.
     * 
     * @param lvl the value of field 'lvl'.
     */
    public void setLvl(
            final int lvl) {
        this._lvl = lvl;
        this._has_lvl = true;
    }

    /**
     * Sets the value of field 'out'.
     * 
     * @param out the value of field 'out'.
     */
    public void setOut(
            final int out) {
        this._out = out;
        this._has_out = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.InSierra
     */
    public static bean.InSierra unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.InSierra) Unmarshaller.unmarshal(bean.InSierra.class, reader);
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
