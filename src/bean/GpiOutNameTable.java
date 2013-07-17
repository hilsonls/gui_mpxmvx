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
 * Class GpiOutNameTable.
 * 
 * @version $Revision$ $Date$
 */
public class GpiOutNameTable implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _gpiOutNameNameList.
     */
    private java.util.List _gpiOutNameNameList;


      //----------------/
     //- Constructors -/
    //----------------/

    public GpiOutNameTable() {
        super();
        this._gpiOutNameNameList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vGpiOutNameName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addGpiOutNameName(
            final bean.GpiOutNameName vGpiOutNameName)
    throws java.lang.IndexOutOfBoundsException {
        this._gpiOutNameNameList.add(vGpiOutNameName);
    }

    /**
     * 
     * 
     * @param index
     * @param vGpiOutNameName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addGpiOutNameName(
            final int index,
            final bean.GpiOutNameName vGpiOutNameName)
    throws java.lang.IndexOutOfBoundsException {
        this._gpiOutNameNameList.add(index, vGpiOutNameName);
    }

    /**
     * Method enumerateGpiOutNameName.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateGpiOutNameName(
    ) {
        return java.util.Collections.enumeration(this._gpiOutNameNameList);
    }

    /**
     * Method getGpiOutNameName.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.GpiOutNameName at the given
     * index
     */
    public bean.GpiOutNameName getGpiOutNameName(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._gpiOutNameNameList.size()) {
            throw new IndexOutOfBoundsException("getGpiOutNameName: Index value '" + index + "' not in range [0.." + (this._gpiOutNameNameList.size() - 1) + "]");
        }
        
        return (bean.GpiOutNameName) _gpiOutNameNameList.get(index);
    }

    /**
     * Method getGpiOutNameName.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.GpiOutNameName[] getGpiOutNameName(
    ) {
        bean.GpiOutNameName[] array = new bean.GpiOutNameName[0];
        return (bean.GpiOutNameName[]) this._gpiOutNameNameList.toArray(array);
    }

    /**
     * Method getGpiOutNameNameCount.
     * 
     * @return the size of this collection
     */
    public int getGpiOutNameNameCount(
    ) {
        return this._gpiOutNameNameList.size();
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
     * Method iterateGpiOutNameName.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateGpiOutNameName(
    ) {
        return this._gpiOutNameNameList.iterator();
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
    public void removeAllGpiOutNameName(
    ) {
        this._gpiOutNameNameList.clear();
    }

    /**
     * Method removeGpiOutNameName.
     * 
     * @param vGpiOutNameName
     * @return true if the object was removed from the collection.
     */
    public boolean removeGpiOutNameName(
            final bean.GpiOutNameName vGpiOutNameName) {
        boolean removed = _gpiOutNameNameList.remove(vGpiOutNameName);
        return removed;
    }

    /**
     * Method removeGpiOutNameNameAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.GpiOutNameName removeGpiOutNameNameAt(
            final int index) {
        java.lang.Object obj = this._gpiOutNameNameList.remove(index);
        return (bean.GpiOutNameName) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vGpiOutNameName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setGpiOutNameName(
            final int index,
            final bean.GpiOutNameName vGpiOutNameName)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._gpiOutNameNameList.size()) {
            throw new IndexOutOfBoundsException("setGpiOutNameName: Index value '" + index + "' not in range [0.." + (this._gpiOutNameNameList.size() - 1) + "]");
        }
        
        this._gpiOutNameNameList.set(index, vGpiOutNameName);
    }

    /**
     * 
     * 
     * @param vGpiOutNameNameArray
     */
    public void setGpiOutNameName(
            final bean.GpiOutNameName[] vGpiOutNameNameArray) {
        //-- copy array
        _gpiOutNameNameList.clear();
        
        for (int i = 0; i < vGpiOutNameNameArray.length; i++) {
                this._gpiOutNameNameList.add(vGpiOutNameNameArray[i]);
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
     * @return the unmarshaled bean.GpiOutNameTable
     */
    public static bean.GpiOutNameTable unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.GpiOutNameTable) Unmarshaller.unmarshal(bean.GpiOutNameTable.class, reader);
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
