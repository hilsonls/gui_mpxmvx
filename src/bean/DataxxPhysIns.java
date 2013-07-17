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
 * Class DataxxPhysIns.
 * 
 * @version $Revision$ $Date$
 */
public class DataxxPhysIns implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _snellDataxxInList.
     */
    private java.util.List _snellDataxxInList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DataxxPhysIns() {
        super();
        this._snellDataxxInList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSnellDataxxIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSnellDataxxIn(
            final bean.SnellDataxxIn vSnellDataxxIn)
    throws java.lang.IndexOutOfBoundsException {
        this._snellDataxxInList.add(vSnellDataxxIn);
    }

    /**
     * 
     * 
     * @param index
     * @param vSnellDataxxIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSnellDataxxIn(
            final int index,
            final bean.SnellDataxxIn vSnellDataxxIn)
    throws java.lang.IndexOutOfBoundsException {
        this._snellDataxxInList.add(index, vSnellDataxxIn);
    }

    /**
     * Method enumerateSnellDataxxIn.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateSnellDataxxIn(
    ) {
        return java.util.Collections.enumeration(this._snellDataxxInList);
    }

    /**
     * Method getSnellDataxxIn.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.SnellDataxxIn at the given inde
     */
    public bean.SnellDataxxIn getSnellDataxxIn(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._snellDataxxInList.size()) {
            throw new IndexOutOfBoundsException("getSnellDataxxIn: Index value '" + index + "' not in range [0.." + (this._snellDataxxInList.size() - 1) + "]");
        }
        
        return (bean.SnellDataxxIn) _snellDataxxInList.get(index);
    }

    /**
     * Method getSnellDataxxIn.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.SnellDataxxIn[] getSnellDataxxIn(
    ) {
        bean.SnellDataxxIn[] array = new bean.SnellDataxxIn[0];
        return (bean.SnellDataxxIn[]) this._snellDataxxInList.toArray(array);
    }

    /**
     * Method getSnellDataxxInCount.
     * 
     * @return the size of this collection
     */
    public int getSnellDataxxInCount(
    ) {
        return this._snellDataxxInList.size();
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
     * Method iterateSnellDataxxIn.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateSnellDataxxIn(
    ) {
        return this._snellDataxxInList.iterator();
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
    public void removeAllSnellDataxxIn(
    ) {
        this._snellDataxxInList.clear();
    }

    /**
     * Method removeSnellDataxxIn.
     * 
     * @param vSnellDataxxIn
     * @return true if the object was removed from the collection.
     */
    public boolean removeSnellDataxxIn(
            final bean.SnellDataxxIn vSnellDataxxIn) {
        boolean removed = _snellDataxxInList.remove(vSnellDataxxIn);
        return removed;
    }

    /**
     * Method removeSnellDataxxInAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.SnellDataxxIn removeSnellDataxxInAt(
            final int index) {
        java.lang.Object obj = this._snellDataxxInList.remove(index);
        return (bean.SnellDataxxIn) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vSnellDataxxIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSnellDataxxIn(
            final int index,
            final bean.SnellDataxxIn vSnellDataxxIn)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._snellDataxxInList.size()) {
            throw new IndexOutOfBoundsException("setSnellDataxxIn: Index value '" + index + "' not in range [0.." + (this._snellDataxxInList.size() - 1) + "]");
        }
        
        this._snellDataxxInList.set(index, vSnellDataxxIn);
    }

    /**
     * 
     * 
     * @param vSnellDataxxInArray
     */
    public void setSnellDataxxIn(
            final bean.SnellDataxxIn[] vSnellDataxxInArray) {
        //-- copy array
        _snellDataxxInList.clear();
        
        for (int i = 0; i < vSnellDataxxInArray.length; i++) {
                this._snellDataxxInList.add(vSnellDataxxInArray[i]);
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
     * @return the unmarshaled bean.DataxxPhysIns
     */
    public static bean.DataxxPhysIns unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.DataxxPhysIns) Unmarshaller.unmarshal(bean.DataxxPhysIns.class, reader);
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
