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
 * Class Network.
 * 
 * @version $Revision$ $Date$
 */
public class Network implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _hostname.
     */
    private bean.Hostname _hostname;

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
     * Field _dnsList.
     */
    private java.util.List _dnsList;

    /**
     * Field _snmpv2c.
     */
    private bean.Snmpv2c _snmpv2c;

    /**
     * Field _snmpMgrs.
     */
    private bean.SnmpMgrs _snmpMgrs;


      //----------------/
     //- Constructors -/
    //----------------/

    public Network() {
        super();
        this._dnsList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vDns
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDns(
            final bean.Dns vDns)
    throws java.lang.IndexOutOfBoundsException {
        this._dnsList.add(vDns);
    }

    /**
     * 
     * 
     * @param index
     * @param vDns
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDns(
            final int index,
            final bean.Dns vDns)
    throws java.lang.IndexOutOfBoundsException {
        this._dnsList.add(index, vDns);
    }

    /**
     * Method enumerateDns.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateDns(
    ) {
        return java.util.Collections.enumeration(this._dnsList);
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
     * Method getDns.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Dns at the given index
     */
    public bean.Dns getDns(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._dnsList.size()) {
            throw new IndexOutOfBoundsException("getDns: Index value '" + index + "' not in range [0.." + (this._dnsList.size() - 1) + "]");
        }
        
        return (bean.Dns) _dnsList.get(index);
    }

    /**
     * Method getDns.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Dns[] getDns(
    ) {
        bean.Dns[] array = new bean.Dns[0];
        return (bean.Dns[]) this._dnsList.toArray(array);
    }

    /**
     * Method getDnsCount.
     * 
     * @return the size of this collection
     */
    public int getDnsCount(
    ) {
        return this._dnsList.size();
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
     * Returns the value of field 'hostname'.
     * 
     * @return the value of field 'Hostname'.
     */
    public bean.Hostname getHostname(
    ) {
        return this._hostname;
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
     * Returns the value of field 'netmask'.
     * 
     * @return the value of field 'Netmask'.
     */
    public bean.Netmask getNetmask(
    ) {
        return this._netmask;
    }

    /**
     * Returns the value of field 'snmpMgrs'.
     * 
     * @return the value of field 'SnmpMgrs'.
     */
    public bean.SnmpMgrs getSnmpMgrs(
    ) {
        return this._snmpMgrs;
    }

    /**
     * Returns the value of field 'snmpv2c'.
     * 
     * @return the value of field 'Snmpv2c'.
     */
    public bean.Snmpv2c getSnmpv2c(
    ) {
        return this._snmpv2c;
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
     * Method iterateDns.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateDns(
    ) {
        return this._dnsList.iterator();
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
     */
    public void removeAllDns(
    ) {
        this._dnsList.clear();
    }

    /**
     * Method removeDns.
     * 
     * @param vDns
     * @return true if the object was removed from the collection.
     */
    public boolean removeDns(
            final bean.Dns vDns) {
        boolean removed = _dnsList.remove(vDns);
        return removed;
    }

    /**
     * Method removeDnsAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Dns removeDnsAt(
            final int index) {
        java.lang.Object obj = this._dnsList.remove(index);
        return (bean.Dns) obj;
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
     * 
     * 
     * @param index
     * @param vDns
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDns(
            final int index,
            final bean.Dns vDns)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._dnsList.size()) {
            throw new IndexOutOfBoundsException("setDns: Index value '" + index + "' not in range [0.." + (this._dnsList.size() - 1) + "]");
        }
        
        this._dnsList.set(index, vDns);
    }

    /**
     * 
     * 
     * @param vDnsArray
     */
    public void setDns(
            final bean.Dns[] vDnsArray) {
        //-- copy array
        _dnsList.clear();
        
        for (int i = 0; i < vDnsArray.length; i++) {
                this._dnsList.add(vDnsArray[i]);
        }
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
     * Sets the value of field 'hostname'.
     * 
     * @param hostname the value of field 'hostname'.
     */
    public void setHostname(
            final bean.Hostname hostname) {
        this._hostname = hostname;
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
     * Sets the value of field 'netmask'.
     * 
     * @param netmask the value of field 'netmask'.
     */
    public void setNetmask(
            final bean.Netmask netmask) {
        this._netmask = netmask;
    }

    /**
     * Sets the value of field 'snmpMgrs'.
     * 
     * @param snmpMgrs the value of field 'snmpMgrs'.
     */
    public void setSnmpMgrs(
            final bean.SnmpMgrs snmpMgrs) {
        this._snmpMgrs = snmpMgrs;
    }

    /**
     * Sets the value of field 'snmpv2c'.
     * 
     * @param snmpv2c the value of field 'snmpv2c'.
     */
    public void setSnmpv2c(
            final bean.Snmpv2c snmpv2c) {
        this._snmpv2c = snmpv2c;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Network
     */
    public static bean.Network unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Network) Unmarshaller.unmarshal(bean.Network.class, reader);
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
