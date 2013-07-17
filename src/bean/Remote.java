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
 * Class Remote.
 * 
 * @version $Revision$ $Date$
 */
public class Remote implements java.io.Serializable {


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
     * Field _collectiveMode.
     */
    private bean.CollectiveMode _collectiveMode;

    /**
     * Field _mac.
     */
    private bean.Mac _mac;

    /**
     * Field _dhcp.
     */
    private bean.Dhcp _dhcp;

    /**
     * Field _ipaddr.
     */
    private bean.Ipaddr _ipaddr;

    /**
     * Field _netmask.
     */
    private bean.Netmask _netmask;

    /**
     * Field _gateway.
     */
    private bean.Gateway _gateway;

    /**
     * Field _mvs.
     */
    private bean.Mvs _mvs;


      //----------------/
     //- Constructors -/
    //----------------/

    public Remote() {
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
     * Returns the value of field 'collectiveMode'.
     * 
     * @return the value of field 'CollectiveMode'.
     */
    public bean.CollectiveMode getCollectiveMode(
    ) {
        return this._collectiveMode;
    }

    /**
     * Returns the value of field 'dhcp'.
     * 
     * @return the value of field 'Dhcp'.
     */
    public bean.Dhcp getDhcp(
    ) {
        return this._dhcp;
    }

    /**
     * Returns the value of field 'gateway'.
     * 
     * @return the value of field 'Gateway'.
     */
    public bean.Gateway getGateway(
    ) {
        return this._gateway;
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
     * Returns the value of field 'mac'.
     * 
     * @return the value of field 'Mac'.
     */
    public bean.Mac getMac(
    ) {
        return this._mac;
    }

    /**
     * Returns the value of field 'mvs'.
     * 
     * @return the value of field 'Mvs'.
     */
    public bean.Mvs getMvs(
    ) {
        return this._mvs;
    }

    /**
     * Returns the value of field 'netmask'.
     * 
     * @return the value of field 'Netmask'.
     */
    public bean.Netmask getNetmask(
    ) {
        return this._netmask;
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
     * Sets the value of field 'collectiveMode'.
     * 
     * @param collectiveMode the value of field 'collectiveMode'.
     */
    public void setCollectiveMode(
            final bean.CollectiveMode collectiveMode) {
        this._collectiveMode = collectiveMode;
    }

    /**
     * Sets the value of field 'dhcp'.
     * 
     * @param dhcp the value of field 'dhcp'.
     */
    public void setDhcp(
            final bean.Dhcp dhcp) {
        this._dhcp = dhcp;
    }

    /**
     * Sets the value of field 'gateway'.
     * 
     * @param gateway the value of field 'gateway'.
     */
    public void setGateway(
            final bean.Gateway gateway) {
        this._gateway = gateway;
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
     * Sets the value of field 'mac'.
     * 
     * @param mac the value of field 'mac'.
     */
    public void setMac(
            final bean.Mac mac) {
        this._mac = mac;
    }

    /**
     * Sets the value of field 'mvs'.
     * 
     * @param mvs the value of field 'mvs'.
     */
    public void setMvs(
            final bean.Mvs mvs) {
        this._mvs = mvs;
    }

    /**
     * Sets the value of field 'netmask'.
     * 
     * @param netmask the value of field 'netmask'.
     */
    public void setNetmask(
            final bean.Netmask netmask) {
        this._netmask = netmask;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Remote
     */
    public static bean.Remote unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Remote) Unmarshaller.unmarshal(bean.Remote.class, reader);
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
