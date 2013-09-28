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
 * Class SnellController.
 * 
 * @version $Revision$ $Date$
 */
public class SnellController implements java.io.Serializable {


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
     * Field _name.
     */
    private java.lang.String _name;

    /**
     * Field _ipaddr1.
     */
    private java.lang.String _ipaddr1;

    /**
     * Field _port1.
     */
    private int _port1;

    /**
     * keeps track of state for field: _port1
     */
    private boolean _has_port1;

    /**
     * Field _ipaddr2.
     */
    private java.lang.String _ipaddr2;

    /**
     * Field _port2.
     */
    private int _port2;

    /**
     * keeps track of state for field: _port2
     */
    private boolean _has_port2;


      //----------------/
     //- Constructors -/
    //----------------/

    public SnellController() {
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
     */
    public void deletePort1(
    ) {
        this._has_port1= false;
    }

    /**
     */
    public void deletePort2(
    ) {
        this._has_port2= false;
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
     * Returns the value of field 'ipaddr1'.
     * 
     * @return the value of field 'Ipaddr1'.
     */
    public java.lang.String getIpaddr1(
    ) {
        return this._ipaddr1;
    }

    /**
     * Returns the value of field 'ipaddr2'.
     * 
     * @return the value of field 'Ipaddr2'.
     */
    public java.lang.String getIpaddr2(
    ) {
        return this._ipaddr2;
    }

    /**
     * Returns the value of field 'name'.
     * 
     * @return the value of field 'Name'.
     */
    public java.lang.String getName(
    ) {
        return this._name;
    }

    /**
     * Returns the value of field 'port1'.
     * 
     * @return the value of field 'Port1'.
     */
    public int getPort1(
    ) {
        return this._port1;
    }

    /**
     * Returns the value of field 'port2'.
     * 
     * @return the value of field 'Port2'.
     */
    public int getPort2(
    ) {
        return this._port2;
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
     * Method hasPort1.
     * 
     * @return true if at least one Port1 has been added
     */
    public boolean hasPort1(
    ) {
        return this._has_port1;
    }

    /**
     * Method hasPort2.
     * 
     * @return true if at least one Port2 has been added
     */
    public boolean hasPort2(
    ) {
        return this._has_port2;
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
     * Sets the value of field 'ipaddr1'.
     * 
     * @param ipaddr1 the value of field 'ipaddr1'.
     */
    public void setIpaddr1(
            final java.lang.String ipaddr1) {
        this._ipaddr1 = ipaddr1;
    }

    /**
     * Sets the value of field 'ipaddr2'.
     * 
     * @param ipaddr2 the value of field 'ipaddr2'.
     */
    public void setIpaddr2(
            final java.lang.String ipaddr2) {
        this._ipaddr2 = ipaddr2;
    }

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(
            final java.lang.String name) {
        this._name = name;
    }

    /**
     * Sets the value of field 'port1'.
     * 
     * @param port1 the value of field 'port1'.
     */
    public void setPort1(
            final int port1) {
        this._port1 = port1;
        this._has_port1 = true;
    }

    /**
     * Sets the value of field 'port2'.
     * 
     * @param port2 the value of field 'port2'.
     */
    public void setPort2(
            final int port2) {
        this._port2 = port2;
        this._has_port2 = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.SnellController
     */
    public static bean.SnellController unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.SnellController) Unmarshaller.unmarshal(bean.SnellController.class, reader);
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
