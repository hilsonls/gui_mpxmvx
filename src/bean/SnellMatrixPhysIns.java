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
 * Class SnellMatrixPhysIns.
 * 
 * @version $Revision$ $Date$
 */
public class SnellMatrixPhysIns implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _snellMatrixInList.
     */
    private java.util.List _snellMatrixInList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SnellMatrixPhysIns() {
        super();
        this._snellMatrixInList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSnellMatrixIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSnellMatrixIn(
            final bean.SnellMatrixIn vSnellMatrixIn)
    throws java.lang.IndexOutOfBoundsException {
        this._snellMatrixInList.add(vSnellMatrixIn);
    }

    /**
     * 
     * 
     * @param index
     * @param vSnellMatrixIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSnellMatrixIn(
            final int index,
            final bean.SnellMatrixIn vSnellMatrixIn)
    throws java.lang.IndexOutOfBoundsException {
        this._snellMatrixInList.add(index, vSnellMatrixIn);
    }

    /**
     * Method enumerateSnellMatrixIn.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateSnellMatrixIn(
    ) {
        return java.util.Collections.enumeration(this._snellMatrixInList);
    }

    /**
     * Method getSnellMatrixIn.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.SnellMatrixIn at the given inde
     */
    public bean.SnellMatrixIn getSnellMatrixIn(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._snellMatrixInList.size()) {
            throw new IndexOutOfBoundsException("getSnellMatrixIn: Index value '" + index + "' not in range [0.." + (this._snellMatrixInList.size() - 1) + "]");
        }
        
        return (bean.SnellMatrixIn) _snellMatrixInList.get(index);
    }

    /**
     * Method getSnellMatrixIn.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.SnellMatrixIn[] getSnellMatrixIn(
    ) {
        bean.SnellMatrixIn[] array = new bean.SnellMatrixIn[0];
        return (bean.SnellMatrixIn[]) this._snellMatrixInList.toArray(array);
    }

    /**
     * Method getSnellMatrixInCount.
     * 
     * @return the size of this collection
     */
    public int getSnellMatrixInCount(
    ) {
        return this._snellMatrixInList.size();
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
     * Method iterateSnellMatrixIn.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateSnellMatrixIn(
    ) {
        return this._snellMatrixInList.iterator();
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
    public void removeAllSnellMatrixIn(
    ) {
        this._snellMatrixInList.clear();
    }

    /**
     * Method removeSnellMatrixIn.
     * 
     * @param vSnellMatrixIn
     * @return true if the object was removed from the collection.
     */
    public boolean removeSnellMatrixIn(
            final bean.SnellMatrixIn vSnellMatrixIn) {
        boolean removed = _snellMatrixInList.remove(vSnellMatrixIn);
        return removed;
    }

    /**
     * Method removeSnellMatrixInAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.SnellMatrixIn removeSnellMatrixInAt(
            final int index) {
        java.lang.Object obj = this._snellMatrixInList.remove(index);
        return (bean.SnellMatrixIn) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vSnellMatrixIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSnellMatrixIn(
            final int index,
            final bean.SnellMatrixIn vSnellMatrixIn)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._snellMatrixInList.size()) {
            throw new IndexOutOfBoundsException("setSnellMatrixIn: Index value '" + index + "' not in range [0.." + (this._snellMatrixInList.size() - 1) + "]");
        }
        
        this._snellMatrixInList.set(index, vSnellMatrixIn);
    }

    /**
     * 
     * 
     * @param vSnellMatrixInArray
     */
    public void setSnellMatrixIn(
            final bean.SnellMatrixIn[] vSnellMatrixInArray) {
        //-- copy array
        _snellMatrixInList.clear();
        
        for (int i = 0; i < vSnellMatrixInArray.length; i++) {
                this._snellMatrixInList.add(vSnellMatrixInArray[i]);
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
     * @return the unmarshaled bean.SnellMatrixPhysIns
     */
    public static bean.SnellMatrixPhysIns unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.SnellMatrixPhysIns) Unmarshaller.unmarshal(bean.SnellMatrixPhysIns.class, reader);
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
