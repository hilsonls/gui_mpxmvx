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
 * Class Oggetto.
 * 
 * @version $Revision$ $Date$
 */
public class Oggetto implements java.io.Serializable {


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
     * Field _type.
     */
    private bean.Type _type;

    /**
     * Field _username.
     */
    private bean.Username _username;

    /**
     * Field _valid.
     */
    private bean.Valid _valid;

    /**
     * Field _objectScreen.
     */
    private bean.ObjectScreen _objectScreen;

    /**
     * Field _filename.
     */
    private bean.Filename _filename;

    /**
     * Field _position.
     */
    private bean.Position _position;

    /**
     * Field _aspectRatio.
     */
    private bean.AspectRatio _aspectRatio;

    /**
     * Field _border.
     */
    private bean.Border _border;

    /**
     * Field _parent.
     */
    private bean.Parent _parent;

    /**
     * Field _umd.
     */
    private bean.Umd _umd;

    /**
     * Field _objectSequence.
     */
    private bean.ObjectSequence _objectSequence;


      //----------------/
     //- Constructors -/
    //----------------/

    public Oggetto() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteId(
    ) {
        this._has_id= false;
    }

    /**
     * Returns the value of field 'aspectRatio'.
     * 
     * @return the value of field 'AspectRatio'.
     */
    public bean.AspectRatio getAspectRatio(
    ) {
        return this._aspectRatio;
    }

    /**
     * Returns the value of field 'border'.
     * 
     * @return the value of field 'Border'.
     */
    public bean.Border getBorder(
    ) {
        return this._border;
    }

    /**
     * Returns the value of field 'filename'.
     * 
     * @return the value of field 'Filename'.
     */
    public bean.Filename getFilename(
    ) {
        return this._filename;
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
     * Returns the value of field 'objectScreen'.
     * 
     * @return the value of field 'ObjectScreen'.
     */
    public bean.ObjectScreen getObjectScreen(
    ) {
        return this._objectScreen;
    }

    /**
     * Returns the value of field 'objectSequence'.
     * 
     * @return the value of field 'ObjectSequence'.
     */
    public bean.ObjectSequence getObjectSequence(
    ) {
        return this._objectSequence;
    }

    /**
     * Returns the value of field 'parent'.
     * 
     * @return the value of field 'Parent'.
     */
    public bean.Parent getParent(
    ) {
        return this._parent;
    }

    /**
     * Returns the value of field 'position'.
     * 
     * @return the value of field 'Position'.
     */
    public bean.Position getPosition(
    ) {
        return this._position;
    }

    /**
     * Returns the value of field 'type'.
     * 
     * @return the value of field 'Type'.
     */
    public bean.Type getType(
    ) {
        return this._type;
    }

    /**
     * Returns the value of field 'umd'.
     * 
     * @return the value of field 'Umd'.
     */
    public bean.Umd getUmd(
    ) {
        return this._umd;
    }

    /**
     * Returns the value of field 'username'.
     * 
     * @return the value of field 'Username'.
     */
    public bean.Username getUsername(
    ) {
        return this._username;
    }

    /**
     * Returns the value of field 'valid'.
     * 
     * @return the value of field 'Valid'.
     */
    public bean.Valid getValid(
    ) {
        return this._valid;
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
     * Sets the value of field 'aspectRatio'.
     * 
     * @param aspectRatio the value of field 'aspectRatio'.
     */
    public void setAspectRatio(
            final bean.AspectRatio aspectRatio) {
        this._aspectRatio = aspectRatio;
    }

    /**
     * Sets the value of field 'border'.
     * 
     * @param border the value of field 'border'.
     */
    public void setBorder(
            final bean.Border border) {
        this._border = border;
    }

    /**
     * Sets the value of field 'filename'.
     * 
     * @param filename the value of field 'filename'.
     */
    public void setFilename(
            final bean.Filename filename) {
        this._filename = filename;
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
     * Sets the value of field 'objectScreen'.
     * 
     * @param objectScreen the value of field 'objectScreen'.
     */
    public void setObjectScreen(
            final bean.ObjectScreen objectScreen) {
        this._objectScreen = objectScreen;
    }

    /**
     * Sets the value of field 'objectSequence'.
     * 
     * @param objectSequence the value of field 'objectSequence'.
     */
    public void setObjectSequence(
            final bean.ObjectSequence objectSequence) {
        this._objectSequence = objectSequence;
    }

    /**
     * Sets the value of field 'parent'.
     * 
     * @param parent the value of field 'parent'.
     */
    public void setParent(
            final bean.Parent parent) {
        this._parent = parent;
    }

    /**
     * Sets the value of field 'position'.
     * 
     * @param position the value of field 'position'.
     */
    public void setPosition(
            final bean.Position position) {
        this._position = position;
    }

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(
            final bean.Type type) {
        this._type = type;
    }

    /**
     * Sets the value of field 'umd'.
     * 
     * @param umd the value of field 'umd'.
     */
    public void setUmd(
            final bean.Umd umd) {
        this._umd = umd;
    }

    /**
     * Sets the value of field 'username'.
     * 
     * @param username the value of field 'username'.
     */
    public void setUsername(
            final bean.Username username) {
        this._username = username;
    }

    /**
     * Sets the value of field 'valid'.
     * 
     * @param valid the value of field 'valid'.
     */
    public void setValid(
            final bean.Valid valid) {
        this._valid = valid;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Oggetto
     */
    public static bean.Oggetto unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Oggetto) Unmarshaller.unmarshal(bean.Oggetto.class, reader);
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
