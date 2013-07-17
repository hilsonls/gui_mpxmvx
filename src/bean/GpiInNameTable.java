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
 * Class GpiInNameTable.
 * 
 * @version $Revision$ $Date$
 */
public class GpiInNameTable implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _gpiInNameNameList.
     */
    private java.util.List _gpiInNameNameList;


      //----------------/
     //- Constructors -/
    //----------------/

    public GpiInNameTable() {
        super();
        this._gpiInNameNameList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vGpiInNameName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addGpiInNameName(
            final bean.GpiInNameName vGpiInNameName)
    throws java.lang.IndexOutOfBoundsException {
        this._gpiInNameNameList.add(vGpiInNameName);
    }

    /**
     * 
     * 
     * @param index
     * @param vGpiInNameName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addGpiInNameName(
            final int index,
            final bean.GpiInNameName vGpiInNameName)
    throws java.lang.IndexOutOfBoundsException {
        this._gpiInNameNameList.add(index, vGpiInNameName);
    }

    /**
     * Method enumerateGpiInNameName.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateGpiInNameName(
    ) {
        return java.util.Collections.enumeration(this._gpiInNameNameList);
    }

    /**
     * Method getGpiInNameName.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.GpiInNameName at the given inde
     */
    public bean.GpiInNameName getGpiInNameName(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._gpiInNameNameList.size()) {
            throw new IndexOutOfBoundsException("getGpiInNameName: Index value '" + index + "' not in range [0.." + (this._gpiInNameNameList.size() - 1) + "]");
        }
        
        return (bean.GpiInNameName) _gpiInNameNameList.get(index);
    }

    /**
     * Method getGpiInNameName.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.GpiInNameName[] getGpiInNameName(
    ) {
        bean.GpiInNameName[] array = new bean.GpiInNameName[0];
        return (bean.GpiInNameName[]) this._gpiInNameNameList.toArray(array);
    }

    /**
     * Method getGpiInNameNameCount.
     * 
     * @return the size of this collection
     */
    public int getGpiInNameNameCount(
    ) {
        return this._gpiInNameNameList.size();
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
     * Method iterateGpiInNameName.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateGpiInNameName(
    ) {
        return this._gpiInNameNameList.iterator();
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
    public void removeAllGpiInNameName(
    ) {
        this._gpiInNameNameList.clear();
    }

    /**
     * Method removeGpiInNameName.
     * 
     * @param vGpiInNameName
     * @return true if the object was removed from the collection.
     */
    public boolean removeGpiInNameName(
            final bean.GpiInNameName vGpiInNameName) {
        boolean removed = _gpiInNameNameList.remove(vGpiInNameName);
        return removed;
    }

    /**
     * Method removeGpiInNameNameAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.GpiInNameName removeGpiInNameNameAt(
            final int index) {
        java.lang.Object obj = this._gpiInNameNameList.remove(index);
        return (bean.GpiInNameName) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vGpiInNameName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setGpiInNameName(
            final int index,
            final bean.GpiInNameName vGpiInNameName)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._gpiInNameNameList.size()) {
            throw new IndexOutOfBoundsException("setGpiInNameName: Index value '" + index + "' not in range [0.." + (this._gpiInNameNameList.size() - 1) + "]");
        }
        
        this._gpiInNameNameList.set(index, vGpiInNameName);
    }

    /**
     * 
     * 
     * @param vGpiInNameNameArray
     */
    public void setGpiInNameName(
            final bean.GpiInNameName[] vGpiInNameNameArray) {
        //-- copy array
        _gpiInNameNameList.clear();
        
        for (int i = 0; i < vGpiInNameNameArray.length; i++) {
                this._gpiInNameNameList.add(vGpiInNameNameArray[i]);
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
     * @return the unmarshaled bean.GpiInNameTable
     */
    public static bean.GpiInNameTable unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.GpiInNameTable) Unmarshaller.unmarshal(bean.GpiInNameTable.class, reader);
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
