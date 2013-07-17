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
 * Class RemotesAvail.
 * 
 * @version $Revision$ $Date$
 */
public class RemotesAvail implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _remoteList.
     */
    private java.util.List _remoteList;


      //----------------/
     //- Constructors -/
    //----------------/

    public RemotesAvail() {
        super();
        this._remoteList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vRemote
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addRemote(
            final bean.Remote vRemote)
    throws java.lang.IndexOutOfBoundsException {
        this._remoteList.add(vRemote);
    }

    /**
     * 
     * 
     * @param index
     * @param vRemote
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addRemote(
            final int index,
            final bean.Remote vRemote)
    throws java.lang.IndexOutOfBoundsException {
        this._remoteList.add(index, vRemote);
    }

    /**
     * Method enumerateRemote.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateRemote(
    ) {
        return java.util.Collections.enumeration(this._remoteList);
    }

    /**
     * Method getRemote.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Remote at the given index
     */
    public bean.Remote getRemote(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._remoteList.size()) {
            throw new IndexOutOfBoundsException("getRemote: Index value '" + index + "' not in range [0.." + (this._remoteList.size() - 1) + "]");
        }
        
        return (bean.Remote) _remoteList.get(index);
    }

    /**
     * Method getRemote.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Remote[] getRemote(
    ) {
        bean.Remote[] array = new bean.Remote[0];
        return (bean.Remote[]) this._remoteList.toArray(array);
    }

    /**
     * Method getRemoteCount.
     * 
     * @return the size of this collection
     */
    public int getRemoteCount(
    ) {
        return this._remoteList.size();
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
     * Method iterateRemote.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateRemote(
    ) {
        return this._remoteList.iterator();
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
    public void removeAllRemote(
    ) {
        this._remoteList.clear();
    }

    /**
     * Method removeRemote.
     * 
     * @param vRemote
     * @return true if the object was removed from the collection.
     */
    public boolean removeRemote(
            final bean.Remote vRemote) {
        boolean removed = _remoteList.remove(vRemote);
        return removed;
    }

    /**
     * Method removeRemoteAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Remote removeRemoteAt(
            final int index) {
        java.lang.Object obj = this._remoteList.remove(index);
        return (bean.Remote) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vRemote
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setRemote(
            final int index,
            final bean.Remote vRemote)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._remoteList.size()) {
            throw new IndexOutOfBoundsException("setRemote: Index value '" + index + "' not in range [0.." + (this._remoteList.size() - 1) + "]");
        }
        
        this._remoteList.set(index, vRemote);
    }

    /**
     * 
     * 
     * @param vRemoteArray
     */
    public void setRemote(
            final bean.Remote[] vRemoteArray) {
        //-- copy array
        _remoteList.clear();
        
        for (int i = 0; i < vRemoteArray.length; i++) {
                this._remoteList.add(vRemoteArray[i]);
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
     * @return the unmarshaled bean.RemotesAvail
     */
    public static bean.RemotesAvail unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.RemotesAvail) Unmarshaller.unmarshal(bean.RemotesAvail.class, reader);
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
