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
 * Class NgmServers.
 * 
 * @version $Revision$ $Date$
 */
public class NgmServers implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ngmServerList.
     */
    private java.util.List _ngmServerList;


      //----------------/
     //- Constructors -/
    //----------------/

    public NgmServers() {
        super();
        this._ngmServerList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vNgmServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNgmServer(
            final bean.NgmServer vNgmServer)
    throws java.lang.IndexOutOfBoundsException {
        this._ngmServerList.add(vNgmServer);
    }

    /**
     * 
     * 
     * @param index
     * @param vNgmServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNgmServer(
            final int index,
            final bean.NgmServer vNgmServer)
    throws java.lang.IndexOutOfBoundsException {
        this._ngmServerList.add(index, vNgmServer);
    }

    /**
     * Method enumerateNgmServer.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateNgmServer(
    ) {
        return java.util.Collections.enumeration(this._ngmServerList);
    }

    /**
     * Method getNgmServer.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.NgmServer at the given index
     */
    public bean.NgmServer getNgmServer(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ngmServerList.size()) {
            throw new IndexOutOfBoundsException("getNgmServer: Index value '" + index + "' not in range [0.." + (this._ngmServerList.size() - 1) + "]");
        }
        
        return (bean.NgmServer) _ngmServerList.get(index);
    }

    /**
     * Method getNgmServer.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.NgmServer[] getNgmServer(
    ) {
        bean.NgmServer[] array = new bean.NgmServer[0];
        return (bean.NgmServer[]) this._ngmServerList.toArray(array);
    }

    /**
     * Method getNgmServerCount.
     * 
     * @return the size of this collection
     */
    public int getNgmServerCount(
    ) {
        return this._ngmServerList.size();
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
     * Method iterateNgmServer.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateNgmServer(
    ) {
        return this._ngmServerList.iterator();
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
    public void removeAllNgmServer(
    ) {
        this._ngmServerList.clear();
    }

    /**
     * Method removeNgmServer.
     * 
     * @param vNgmServer
     * @return true if the object was removed from the collection.
     */
    public boolean removeNgmServer(
            final bean.NgmServer vNgmServer) {
        boolean removed = _ngmServerList.remove(vNgmServer);
        return removed;
    }

    /**
     * Method removeNgmServerAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.NgmServer removeNgmServerAt(
            final int index) {
        java.lang.Object obj = this._ngmServerList.remove(index);
        return (bean.NgmServer) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vNgmServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setNgmServer(
            final int index,
            final bean.NgmServer vNgmServer)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ngmServerList.size()) {
            throw new IndexOutOfBoundsException("setNgmServer: Index value '" + index + "' not in range [0.." + (this._ngmServerList.size() - 1) + "]");
        }
        
        this._ngmServerList.set(index, vNgmServer);
    }

    /**
     * 
     * 
     * @param vNgmServerArray
     */
    public void setNgmServer(
            final bean.NgmServer[] vNgmServerArray) {
        //-- copy array
        _ngmServerList.clear();
        
        for (int i = 0; i < vNgmServerArray.length; i++) {
                this._ngmServerList.add(vNgmServerArray[i]);
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
     * @return the unmarshaled bean.NgmServers
     */
    public static bean.NgmServers unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.NgmServers) Unmarshaller.unmarshal(bean.NgmServers.class, reader);
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
