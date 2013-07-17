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
 * Class GpiInTaskTable.
 * 
 * @version $Revision$ $Date$
 */
public class GpiInTaskTable implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _gpiInTaskNameList.
     */
    private java.util.List _gpiInTaskNameList;


      //----------------/
     //- Constructors -/
    //----------------/

    public GpiInTaskTable() {
        super();
        this._gpiInTaskNameList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vGpiInTaskName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addGpiInTaskName(
            final bean.GpiInTaskName vGpiInTaskName)
    throws java.lang.IndexOutOfBoundsException {
        this._gpiInTaskNameList.add(vGpiInTaskName);
    }

    /**
     * 
     * 
     * @param index
     * @param vGpiInTaskName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addGpiInTaskName(
            final int index,
            final bean.GpiInTaskName vGpiInTaskName)
    throws java.lang.IndexOutOfBoundsException {
        this._gpiInTaskNameList.add(index, vGpiInTaskName);
    }

    /**
     * Method enumerateGpiInTaskName.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateGpiInTaskName(
    ) {
        return java.util.Collections.enumeration(this._gpiInTaskNameList);
    }

    /**
     * Method getGpiInTaskName.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.GpiInTaskName at the given inde
     */
    public bean.GpiInTaskName getGpiInTaskName(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._gpiInTaskNameList.size()) {
            throw new IndexOutOfBoundsException("getGpiInTaskName: Index value '" + index + "' not in range [0.." + (this._gpiInTaskNameList.size() - 1) + "]");
        }
        
        return (bean.GpiInTaskName) _gpiInTaskNameList.get(index);
    }

    /**
     * Method getGpiInTaskName.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.GpiInTaskName[] getGpiInTaskName(
    ) {
        bean.GpiInTaskName[] array = new bean.GpiInTaskName[0];
        return (bean.GpiInTaskName[]) this._gpiInTaskNameList.toArray(array);
    }

    /**
     * Method getGpiInTaskNameCount.
     * 
     * @return the size of this collection
     */
    public int getGpiInTaskNameCount(
    ) {
        return this._gpiInTaskNameList.size();
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
     * Method iterateGpiInTaskName.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateGpiInTaskName(
    ) {
        return this._gpiInTaskNameList.iterator();
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
    public void removeAllGpiInTaskName(
    ) {
        this._gpiInTaskNameList.clear();
    }

    /**
     * Method removeGpiInTaskName.
     * 
     * @param vGpiInTaskName
     * @return true if the object was removed from the collection.
     */
    public boolean removeGpiInTaskName(
            final bean.GpiInTaskName vGpiInTaskName) {
        boolean removed = _gpiInTaskNameList.remove(vGpiInTaskName);
        return removed;
    }

    /**
     * Method removeGpiInTaskNameAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.GpiInTaskName removeGpiInTaskNameAt(
            final int index) {
        java.lang.Object obj = this._gpiInTaskNameList.remove(index);
        return (bean.GpiInTaskName) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vGpiInTaskName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setGpiInTaskName(
            final int index,
            final bean.GpiInTaskName vGpiInTaskName)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._gpiInTaskNameList.size()) {
            throw new IndexOutOfBoundsException("setGpiInTaskName: Index value '" + index + "' not in range [0.." + (this._gpiInTaskNameList.size() - 1) + "]");
        }
        
        this._gpiInTaskNameList.set(index, vGpiInTaskName);
    }

    /**
     * 
     * 
     * @param vGpiInTaskNameArray
     */
    public void setGpiInTaskName(
            final bean.GpiInTaskName[] vGpiInTaskNameArray) {
        //-- copy array
        _gpiInTaskNameList.clear();
        
        for (int i = 0; i < vGpiInTaskNameArray.length; i++) {
                this._gpiInTaskNameList.add(vGpiInTaskNameArray[i]);
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
     * @return the unmarshaled bean.GpiInTaskTable
     */
    public static bean.GpiInTaskTable unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.GpiInTaskTable) Unmarshaller.unmarshal(bean.GpiInTaskTable.class, reader);
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
