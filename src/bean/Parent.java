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
 * Class Parent.
 * 
 * @version $Revision$ $Date$
 */
public class Parent extends bean.ObjectStringProperty 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _objid.
     */
    private int _objid;

    /**
     * keeps track of state for field: _objid
     */
    private boolean _has_objid;

    /**
     * Field _optionsName.
     */
    private java.lang.String _optionsName;

    /**
     * Field _anchorPoint.
     */
    private bean.AnchorPoint _anchorPoint;

    /**
     * Field _xoffs.
     */
    private bean.Xoffs _xoffs;

    /**
     * Field _yoffs.
     */
    private bean.Yoffs _yoffs;

    /**
     * Field _lockSizeRatio.
     */
    private bean.LockSizeRatio _lockSizeRatio;


      //----------------/
     //- Constructors -/
    //----------------/

    public Parent() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteObjid(
    ) {
        this._has_objid= false;
    }

    /**
     * Returns the value of field 'anchorPoint'.
     * 
     * @return the value of field 'AnchorPoint'.
     */
    public bean.AnchorPoint getAnchorPoint(
    ) {
        return this._anchorPoint;
    }

    /**
     * Returns the value of field 'lockSizeRatio'.
     * 
     * @return the value of field 'LockSizeRatio'.
     */
    public bean.LockSizeRatio getLockSizeRatio(
    ) {
        return this._lockSizeRatio;
    }

    /**
     * Returns the value of field 'objid'.
     * 
     * @return the value of field 'Objid'.
     */
    public int getObjid(
    ) {
        return this._objid;
    }

    /**
     * Returns the value of field 'optionsName'.
     * 
     * @return the value of field 'OptionsName'.
     */
    public java.lang.String getOptionsName(
    ) {
        return this._optionsName;
    }

    /**
     * Returns the value of field 'xoffs'.
     * 
     * @return the value of field 'Xoffs'.
     */
    public bean.Xoffs getXoffs(
    ) {
        return this._xoffs;
    }

    /**
     * Returns the value of field 'yoffs'.
     * 
     * @return the value of field 'Yoffs'.
     */
    public bean.Yoffs getYoffs(
    ) {
        return this._yoffs;
    }

    /**
     * Method hasObjid.
     * 
     * @return true if at least one Objid has been added
     */
    public boolean hasObjid(
    ) {
        return this._has_objid;
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
     * Sets the value of field 'anchorPoint'.
     * 
     * @param anchorPoint the value of field 'anchorPoint'.
     */
    public void setAnchorPoint(
            final bean.AnchorPoint anchorPoint) {
        this._anchorPoint = anchorPoint;
    }

    /**
     * Sets the value of field 'lockSizeRatio'.
     * 
     * @param lockSizeRatio the value of field 'lockSizeRatio'.
     */
    public void setLockSizeRatio(
            final bean.LockSizeRatio lockSizeRatio) {
        this._lockSizeRatio = lockSizeRatio;
    }

    /**
     * Sets the value of field 'objid'.
     * 
     * @param objid the value of field 'objid'.
     */
    public void setObjid(
            final int objid) {
        this._objid = objid;
        this._has_objid = true;
    }

    /**
     * Sets the value of field 'optionsName'.
     * 
     * @param optionsName the value of field 'optionsName'.
     */
    public void setOptionsName(
            final java.lang.String optionsName) {
        this._optionsName = optionsName;
    }

    /**
     * Sets the value of field 'xoffs'.
     * 
     * @param xoffs the value of field 'xoffs'.
     */
    public void setXoffs(
            final bean.Xoffs xoffs) {
        this._xoffs = xoffs;
    }

    /**
     * Sets the value of field 'yoffs'.
     * 
     * @param yoffs the value of field 'yoffs'.
     */
    public void setYoffs(
            final bean.Yoffs yoffs) {
        this._yoffs = yoffs;
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
        return (bean.ObjectStringProperty) Unmarshaller.unmarshal(bean.Parent.class, reader);
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
