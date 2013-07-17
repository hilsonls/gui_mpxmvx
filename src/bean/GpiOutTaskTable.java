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
 * Class GpiOutTaskTable.
 * 
 * @version $Revision$ $Date$
 */
public class GpiOutTaskTable implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _gpiOutTaskNameList.
     */
    private java.util.List _gpiOutTaskNameList;


      //----------------/
     //- Constructors -/
    //----------------/

    public GpiOutTaskTable() {
        super();
        this._gpiOutTaskNameList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vGpiOutTaskName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addGpiOutTaskName(
            final bean.GpiOutTaskName vGpiOutTaskName)
    throws java.lang.IndexOutOfBoundsException {
        this._gpiOutTaskNameList.add(vGpiOutTaskName);
    }

    /**
     * 
     * 
     * @param index
     * @param vGpiOutTaskName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addGpiOutTaskName(
            final int index,
            final bean.GpiOutTaskName vGpiOutTaskName)
    throws java.lang.IndexOutOfBoundsException {
        this._gpiOutTaskNameList.add(index, vGpiOutTaskName);
    }

    /**
     * Method enumerateGpiOutTaskName.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateGpiOutTaskName(
    ) {
        return java.util.Collections.enumeration(this._gpiOutTaskNameList);
    }

    /**
     * Method getGpiOutTaskName.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.GpiOutTaskName at the given
     * index
     */
    public bean.GpiOutTaskName getGpiOutTaskName(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._gpiOutTaskNameList.size()) {
            throw new IndexOutOfBoundsException("getGpiOutTaskName: Index value '" + index + "' not in range [0.." + (this._gpiOutTaskNameList.size() - 1) + "]");
        }
        
        return (bean.GpiOutTaskName) _gpiOutTaskNameList.get(index);
    }

    /**
     * Method getGpiOutTaskName.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.GpiOutTaskName[] getGpiOutTaskName(
    ) {
        bean.GpiOutTaskName[] array = new bean.GpiOutTaskName[0];
        return (bean.GpiOutTaskName[]) this._gpiOutTaskNameList.toArray(array);
    }

    /**
     * Method getGpiOutTaskNameCount.
     * 
     * @return the size of this collection
     */
    public int getGpiOutTaskNameCount(
    ) {
        return this._gpiOutTaskNameList.size();
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
     * Method iterateGpiOutTaskName.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateGpiOutTaskName(
    ) {
        return this._gpiOutTaskNameList.iterator();
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
    public void removeAllGpiOutTaskName(
    ) {
        this._gpiOutTaskNameList.clear();
    }

    /**
     * Method removeGpiOutTaskName.
     * 
     * @param vGpiOutTaskName
     * @return true if the object was removed from the collection.
     */
    public boolean removeGpiOutTaskName(
            final bean.GpiOutTaskName vGpiOutTaskName) {
        boolean removed = _gpiOutTaskNameList.remove(vGpiOutTaskName);
        return removed;
    }

    /**
     * Method removeGpiOutTaskNameAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.GpiOutTaskName removeGpiOutTaskNameAt(
            final int index) {
        java.lang.Object obj = this._gpiOutTaskNameList.remove(index);
        return (bean.GpiOutTaskName) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vGpiOutTaskName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setGpiOutTaskName(
            final int index,
            final bean.GpiOutTaskName vGpiOutTaskName)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._gpiOutTaskNameList.size()) {
            throw new IndexOutOfBoundsException("setGpiOutTaskName: Index value '" + index + "' not in range [0.." + (this._gpiOutTaskNameList.size() - 1) + "]");
        }
        
        this._gpiOutTaskNameList.set(index, vGpiOutTaskName);
    }

    /**
     * 
     * 
     * @param vGpiOutTaskNameArray
     */
    public void setGpiOutTaskName(
            final bean.GpiOutTaskName[] vGpiOutTaskNameArray) {
        //-- copy array
        _gpiOutTaskNameList.clear();
        
        for (int i = 0; i < vGpiOutTaskNameArray.length; i++) {
                this._gpiOutTaskNameList.add(vGpiOutTaskNameArray[i]);
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
     * @return the unmarshaled bean.GpiOutTaskTable
     */
    public static bean.GpiOutTaskTable unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.GpiOutTaskTable) Unmarshaller.unmarshal(bean.GpiOutTaskTable.class, reader);
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
