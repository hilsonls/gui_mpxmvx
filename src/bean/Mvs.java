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
 * Class Mvs.
 * 
 * @version $Revision$ $Date$
 */
public class Mvs implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _mvList.
     */
    private java.util.List _mvList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Mvs() {
        super();
        this._mvList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vMv
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMv(
            final bean.Mv vMv)
    throws java.lang.IndexOutOfBoundsException {
        this._mvList.add(vMv);
    }

    /**
     * 
     * 
     * @param index
     * @param vMv
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMv(
            final int index,
            final bean.Mv vMv)
    throws java.lang.IndexOutOfBoundsException {
        this._mvList.add(index, vMv);
    }

    /**
     * Method enumerateMv.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateMv(
    ) {
        return java.util.Collections.enumeration(this._mvList);
    }

    /**
     * Method getMv.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Mv at the given index
     */
    public bean.Mv getMv(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._mvList.size()) {
            throw new IndexOutOfBoundsException("getMv: Index value '" + index + "' not in range [0.." + (this._mvList.size() - 1) + "]");
        }
        
        return (bean.Mv) _mvList.get(index);
    }

    /**
     * Method getMv.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Mv[] getMv(
    ) {
        bean.Mv[] array = new bean.Mv[0];
        return (bean.Mv[]) this._mvList.toArray(array);
    }

    /**
     * Method getMvCount.
     * 
     * @return the size of this collection
     */
    public int getMvCount(
    ) {
        return this._mvList.size();
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
     * Method iterateMv.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateMv(
    ) {
        return this._mvList.iterator();
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
    public void removeAllMv(
    ) {
        this._mvList.clear();
    }

    /**
     * Method removeMv.
     * 
     * @param vMv
     * @return true if the object was removed from the collection.
     */
    public boolean removeMv(
            final bean.Mv vMv) {
        boolean removed = _mvList.remove(vMv);
        return removed;
    }

    /**
     * Method removeMvAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Mv removeMvAt(
            final int index) {
        java.lang.Object obj = this._mvList.remove(index);
        return (bean.Mv) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vMv
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setMv(
            final int index,
            final bean.Mv vMv)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._mvList.size()) {
            throw new IndexOutOfBoundsException("setMv: Index value '" + index + "' not in range [0.." + (this._mvList.size() - 1) + "]");
        }
        
        this._mvList.set(index, vMv);
    }

    /**
     * 
     * 
     * @param vMvArray
     */
    public void setMv(
            final bean.Mv[] vMvArray) {
        //-- copy array
        _mvList.clear();
        
        for (int i = 0; i < vMvArray.length; i++) {
                this._mvList.add(vMvArray[i]);
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
     * @return the unmarshaled bean.Mvs
     */
    public static bean.Mvs unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Mvs) Unmarshaller.unmarshal(bean.Mvs.class, reader);
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
