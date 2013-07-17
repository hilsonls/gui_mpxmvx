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
 * Class PhysIns.
 * 
 * @version $Revision$ $Date$
 */
public class PhysIns implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _inSierraList.
     */
    private java.util.List _inSierraList;


      //----------------/
     //- Constructors -/
    //----------------/

    public PhysIns() {
        super();
        this._inSierraList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vInSierra
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addInSierra(
            final bean.InSierra vInSierra)
    throws java.lang.IndexOutOfBoundsException {
        this._inSierraList.add(vInSierra);
    }

    /**
     * 
     * 
     * @param index
     * @param vInSierra
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addInSierra(
            final int index,
            final bean.InSierra vInSierra)
    throws java.lang.IndexOutOfBoundsException {
        this._inSierraList.add(index, vInSierra);
    }

    /**
     * Method enumerateInSierra.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateInSierra(
    ) {
        return java.util.Collections.enumeration(this._inSierraList);
    }

    /**
     * Method getInSierra.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.InSierra at the given index
     */
    public bean.InSierra getInSierra(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._inSierraList.size()) {
            throw new IndexOutOfBoundsException("getInSierra: Index value '" + index + "' not in range [0.." + (this._inSierraList.size() - 1) + "]");
        }
        
        return (bean.InSierra) _inSierraList.get(index);
    }

    /**
     * Method getInSierra.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.InSierra[] getInSierra(
    ) {
        bean.InSierra[] array = new bean.InSierra[0];
        return (bean.InSierra[]) this._inSierraList.toArray(array);
    }

    /**
     * Method getInSierraCount.
     * 
     * @return the size of this collection
     */
    public int getInSierraCount(
    ) {
        return this._inSierraList.size();
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
     * Method iterateInSierra.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateInSierra(
    ) {
        return this._inSierraList.iterator();
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
    public void removeAllInSierra(
    ) {
        this._inSierraList.clear();
    }

    /**
     * Method removeInSierra.
     * 
     * @param vInSierra
     * @return true if the object was removed from the collection.
     */
    public boolean removeInSierra(
            final bean.InSierra vInSierra) {
        boolean removed = _inSierraList.remove(vInSierra);
        return removed;
    }

    /**
     * Method removeInSierraAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.InSierra removeInSierraAt(
            final int index) {
        java.lang.Object obj = this._inSierraList.remove(index);
        return (bean.InSierra) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vInSierra
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setInSierra(
            final int index,
            final bean.InSierra vInSierra)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._inSierraList.size()) {
            throw new IndexOutOfBoundsException("setInSierra: Index value '" + index + "' not in range [0.." + (this._inSierraList.size() - 1) + "]");
        }
        
        this._inSierraList.set(index, vInSierra);
    }

    /**
     * 
     * 
     * @param vInSierraArray
     */
    public void setInSierra(
            final bean.InSierra[] vInSierraArray) {
        //-- copy array
        _inSierraList.clear();
        
        for (int i = 0; i < vInSierraArray.length; i++) {
                this._inSierraList.add(vInSierraArray[i]);
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
     * @return the unmarshaled bean.PhysIns
     */
    public static bean.PhysIns unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.PhysIns) Unmarshaller.unmarshal(bean.PhysIns.class, reader);
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
