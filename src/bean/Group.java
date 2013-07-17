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
 * Class Group.
 * 
 * @version $Revision$ $Date$
 */
public class Group extends bean.ObjectStringProperty 
implements java.io.Serializable
{


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
     * Field _first.
     */
    private int _first;

    /**
     * keeps track of state for field: _first
     */
    private boolean _has_first;

    /**
     * Field _last.
     */
    private int _last;

    /**
     * keeps track of state for field: _last
     */
    private boolean _has_last;


      //----------------/
     //- Constructors -/
    //----------------/

    public Group() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteFirst(
    ) {
        this._has_first= false;
    }

    /**
     */
    public void deleteId(
    ) {
        this._has_id= false;
    }

    /**
     */
    public void deleteLast(
    ) {
        this._has_last= false;
    }

    /**
     * Returns the value of field 'first'.
     * 
     * @return the value of field 'First'.
     */
    public int getFirst(
    ) {
        return this._first;
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
     * Returns the value of field 'last'.
     * 
     * @return the value of field 'Last'.
     */
    public int getLast(
    ) {
        return this._last;
    }

    /**
     * Method hasFirst.
     * 
     * @return true if at least one First has been added
     */
    public boolean hasFirst(
    ) {
        return this._has_first;
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
     * Method hasLast.
     * 
     * @return true if at least one Last has been added
     */
    public boolean hasLast(
    ) {
        return this._has_last;
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
     * Sets the value of field 'first'.
     * 
     * @param first the value of field 'first'.
     */
    public void setFirst(
            final int first) {
        this._first = first;
        this._has_first = true;
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
     * Sets the value of field 'last'.
     * 
     * @param last the value of field 'last'.
     */
    public void setLast(
            final int last) {
        this._last = last;
        this._has_last = true;
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
        return (bean.ObjectStringProperty) Unmarshaller.unmarshal(bean.Group.class, reader);
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
