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
 * Class SnellDataxxIn.
 * 
 * @version $Revision$ $Date$
 */
public class SnellDataxxIn implements java.io.Serializable {


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

    /**
     * Field _mat.
     */
    private int _mat;

    /**
     * keeps track of state for field: _mat
     */
    private boolean _has_mat;

    /**
     * Field _dass.
     */
    private int _dass;

    /**
     * keeps track of state for field: _dass
     */
    private boolean _has_dass;


      //----------------/
     //- Constructors -/
    //----------------/

    public SnellDataxxIn() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDass(
    ) {
        this._has_dass= false;
    }

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
    public void deleteMat(
    ) {
        this._has_mat= false;
    }

    /**
     */
    public void deleteOut(
    ) {
        this._has_out= false;
    }

    /**
     * Returns the value of field 'dass'.
     * 
     * @return the value of field 'Dass'.
     */
    public int getDass(
    ) {
        return this._dass;
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
     * Returns the value of field 'mat'.
     * 
     * @return the value of field 'Mat'.
     */
    public int getMat(
    ) {
        return this._mat;
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
     * Method hasDass.
     * 
     * @return true if at least one Dass has been added
     */
    public boolean hasDass(
    ) {
        return this._has_dass;
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
     * Method hasMat.
     * 
     * @return true if at least one Mat has been added
     */
    public boolean hasMat(
    ) {
        return this._has_mat;
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
     * Sets the value of field 'dass'.
     * 
     * @param dass the value of field 'dass'.
     */
    public void setDass(
            final int dass) {
        this._dass = dass;
        this._has_dass = true;
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
     * Sets the value of field 'mat'.
     * 
     * @param mat the value of field 'mat'.
     */
    public void setMat(
            final int mat) {
        this._mat = mat;
        this._has_mat = true;
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
     * @return the unmarshaled bean.SnellDataxxIn
     */
    public static bean.SnellDataxxIn unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.SnellDataxxIn) Unmarshaller.unmarshal(bean.SnellDataxxIn.class, reader);
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
