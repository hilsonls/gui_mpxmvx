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
 * Class SnmpMgrs.
 * 
 * @version $Revision$ $Date$
 */
public class SnmpMgrs implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _snmpMgrList.
     */
    private java.util.List _snmpMgrList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SnmpMgrs() {
        super();
        this._snmpMgrList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSnmpMgr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSnmpMgr(
            final bean.SnmpMgr vSnmpMgr)
    throws java.lang.IndexOutOfBoundsException {
        this._snmpMgrList.add(vSnmpMgr);
    }

    /**
     * 
     * 
     * @param index
     * @param vSnmpMgr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSnmpMgr(
            final int index,
            final bean.SnmpMgr vSnmpMgr)
    throws java.lang.IndexOutOfBoundsException {
        this._snmpMgrList.add(index, vSnmpMgr);
    }

    /**
     * Method enumerateSnmpMgr.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateSnmpMgr(
    ) {
        return java.util.Collections.enumeration(this._snmpMgrList);
    }

    /**
     * Method getSnmpMgr.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.SnmpMgr at the given index
     */
    public bean.SnmpMgr getSnmpMgr(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._snmpMgrList.size()) {
            throw new IndexOutOfBoundsException("getSnmpMgr: Index value '" + index + "' not in range [0.." + (this._snmpMgrList.size() - 1) + "]");
        }
        
        return (bean.SnmpMgr) _snmpMgrList.get(index);
    }

    /**
     * Method getSnmpMgr.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.SnmpMgr[] getSnmpMgr(
    ) {
        bean.SnmpMgr[] array = new bean.SnmpMgr[0];
        return (bean.SnmpMgr[]) this._snmpMgrList.toArray(array);
    }

    /**
     * Method getSnmpMgrCount.
     * 
     * @return the size of this collection
     */
    public int getSnmpMgrCount(
    ) {
        return this._snmpMgrList.size();
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
     * Method iterateSnmpMgr.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateSnmpMgr(
    ) {
        return this._snmpMgrList.iterator();
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
    public void removeAllSnmpMgr(
    ) {
        this._snmpMgrList.clear();
    }

    /**
     * Method removeSnmpMgr.
     * 
     * @param vSnmpMgr
     * @return true if the object was removed from the collection.
     */
    public boolean removeSnmpMgr(
            final bean.SnmpMgr vSnmpMgr) {
        boolean removed = _snmpMgrList.remove(vSnmpMgr);
        return removed;
    }

    /**
     * Method removeSnmpMgrAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.SnmpMgr removeSnmpMgrAt(
            final int index) {
        java.lang.Object obj = this._snmpMgrList.remove(index);
        return (bean.SnmpMgr) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vSnmpMgr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSnmpMgr(
            final int index,
            final bean.SnmpMgr vSnmpMgr)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._snmpMgrList.size()) {
            throw new IndexOutOfBoundsException("setSnmpMgr: Index value '" + index + "' not in range [0.." + (this._snmpMgrList.size() - 1) + "]");
        }
        
        this._snmpMgrList.set(index, vSnmpMgr);
    }

    /**
     * 
     * 
     * @param vSnmpMgrArray
     */
    public void setSnmpMgr(
            final bean.SnmpMgr[] vSnmpMgrArray) {
        //-- copy array
        _snmpMgrList.clear();
        
        for (int i = 0; i < vSnmpMgrArray.length; i++) {
                this._snmpMgrList.add(vSnmpMgrArray[i]);
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
     * @return the unmarshaled bean.SnmpMgrs
     */
    public static bean.SnmpMgrs unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.SnmpMgrs) Unmarshaller.unmarshal(bean.SnmpMgrs.class, reader);
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
