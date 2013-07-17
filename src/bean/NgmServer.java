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
 * Class NgmServer.
 * 
 * @version $Revision$ $Date$
 */
public class NgmServer implements java.io.Serializable {


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
     * Field _alias.
     */
    private bean.Alias _alias;

    /**
     * Field _ipaddr.
     */
    private bean.Ipaddr _ipaddr;


      //----------------/
     //- Constructors -/
    //----------------/

    public NgmServer() {
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
     * Returns the value of field 'alias'.
     * 
     * @return the value of field 'Alias'.
     */
    public bean.Alias getAlias(
    ) {
        return this._alias;
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
     * Returns the value of field 'ipaddr'.
     * 
     * @return the value of field 'Ipaddr'.
     */
    public bean.Ipaddr getIpaddr(
    ) {
        return this._ipaddr;
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
     * Sets the value of field 'alias'.
     * 
     * @param alias the value of field 'alias'.
     */
    public void setAlias(
            final bean.Alias alias) {
        this._alias = alias;
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
     * Sets the value of field 'ipaddr'.
     * 
     * @param ipaddr the value of field 'ipaddr'.
     */
    public void setIpaddr(
            final bean.Ipaddr ipaddr) {
        this._ipaddr = ipaddr;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.NgmServer
     */
    public static bean.NgmServer unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.NgmServer) Unmarshaller.unmarshal(bean.NgmServer.class, reader);
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
