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
 * Class NtpServers.
 * 
 * @version $Revision$ $Date$
 */
public class NtpServers implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ntpServerList.
     */
    private java.util.List _ntpServerList;


      //----------------/
     //- Constructors -/
    //----------------/

    public NtpServers() {
        super();
        this._ntpServerList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vNtpServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNtpServer(
            final bean.NtpServer vNtpServer)
    throws java.lang.IndexOutOfBoundsException {
        this._ntpServerList.add(vNtpServer);
    }

    /**
     * 
     * 
     * @param index
     * @param vNtpServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNtpServer(
            final int index,
            final bean.NtpServer vNtpServer)
    throws java.lang.IndexOutOfBoundsException {
        this._ntpServerList.add(index, vNtpServer);
    }

    /**
     * Method enumerateNtpServer.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateNtpServer(
    ) {
        return java.util.Collections.enumeration(this._ntpServerList);
    }

    /**
     * Method getNtpServer.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.NtpServer at the given index
     */
    public bean.NtpServer getNtpServer(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ntpServerList.size()) {
            throw new IndexOutOfBoundsException("getNtpServer: Index value '" + index + "' not in range [0.." + (this._ntpServerList.size() - 1) + "]");
        }
        
        return (bean.NtpServer) _ntpServerList.get(index);
    }

    /**
     * Method getNtpServer.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.NtpServer[] getNtpServer(
    ) {
        bean.NtpServer[] array = new bean.NtpServer[0];
        return (bean.NtpServer[]) this._ntpServerList.toArray(array);
    }

    /**
     * Method getNtpServerCount.
     * 
     * @return the size of this collection
     */
    public int getNtpServerCount(
    ) {
        return this._ntpServerList.size();
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
     * Method iterateNtpServer.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateNtpServer(
    ) {
        return this._ntpServerList.iterator();
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
    public void removeAllNtpServer(
    ) {
        this._ntpServerList.clear();
    }

    /**
     * Method removeNtpServer.
     * 
     * @param vNtpServer
     * @return true if the object was removed from the collection.
     */
    public boolean removeNtpServer(
            final bean.NtpServer vNtpServer) {
        boolean removed = _ntpServerList.remove(vNtpServer);
        return removed;
    }

    /**
     * Method removeNtpServerAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.NtpServer removeNtpServerAt(
            final int index) {
        java.lang.Object obj = this._ntpServerList.remove(index);
        return (bean.NtpServer) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vNtpServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setNtpServer(
            final int index,
            final bean.NtpServer vNtpServer)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ntpServerList.size()) {
            throw new IndexOutOfBoundsException("setNtpServer: Index value '" + index + "' not in range [0.." + (this._ntpServerList.size() - 1) + "]");
        }
        
        this._ntpServerList.set(index, vNtpServer);
    }

    /**
     * 
     * 
     * @param vNtpServerArray
     */
    public void setNtpServer(
            final bean.NtpServer[] vNtpServerArray) {
        //-- copy array
        _ntpServerList.clear();
        
        for (int i = 0; i < vNtpServerArray.length; i++) {
                this._ntpServerList.add(vNtpServerArray[i]);
        }
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.NtpServers
     */
    public static bean.NtpServers unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.NtpServers) Unmarshaller.unmarshal(bean.NtpServers.class, reader);
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
