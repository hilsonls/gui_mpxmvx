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
 * Class Gpis.
 * 
 * @version $Revision$ $Date$
 */
public class Gpis implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _gpiInfo.
     */
    private bean.GpiInfo _gpiInfo;

    /**
     * Field _gpiInList.
     */
    private java.util.List _gpiInList;

    /**
     * Field _gpiOutList.
     */
    private java.util.List _gpiOutList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Gpis() {
        super();
        this._gpiInList = new java.util.ArrayList();
        this._gpiOutList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vGpiIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addGpiIn(
            final bean.GpiIn vGpiIn)
    throws java.lang.IndexOutOfBoundsException {
        this._gpiInList.add(vGpiIn);
    }

    /**
     * 
     * 
     * @param index
     * @param vGpiIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addGpiIn(
            final int index,
            final bean.GpiIn vGpiIn)
    throws java.lang.IndexOutOfBoundsException {
        this._gpiInList.add(index, vGpiIn);
    }

    /**
     * 
     * 
     * @param vGpiOut
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addGpiOut(
            final bean.GpiOut vGpiOut)
    throws java.lang.IndexOutOfBoundsException {
        this._gpiOutList.add(vGpiOut);
    }

    /**
     * 
     * 
     * @param index
     * @param vGpiOut
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addGpiOut(
            final int index,
            final bean.GpiOut vGpiOut)
    throws java.lang.IndexOutOfBoundsException {
        this._gpiOutList.add(index, vGpiOut);
    }

    /**
     * Method enumerateGpiIn.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateGpiIn(
    ) {
        return java.util.Collections.enumeration(this._gpiInList);
    }

    /**
     * Method enumerateGpiOut.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateGpiOut(
    ) {
        return java.util.Collections.enumeration(this._gpiOutList);
    }

    /**
     * Method getGpiIn.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.GpiIn at the given index
     */
    public bean.GpiIn getGpiIn(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._gpiInList.size()) {
            throw new IndexOutOfBoundsException("getGpiIn: Index value '" + index + "' not in range [0.." + (this._gpiInList.size() - 1) + "]");
        }
        
        return (bean.GpiIn) _gpiInList.get(index);
    }

    /**
     * Method getGpiIn.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.GpiIn[] getGpiIn(
    ) {
        bean.GpiIn[] array = new bean.GpiIn[0];
        return (bean.GpiIn[]) this._gpiInList.toArray(array);
    }

    /**
     * Method getGpiInCount.
     * 
     * @return the size of this collection
     */
    public int getGpiInCount(
    ) {
        return this._gpiInList.size();
    }

    /**
     * Returns the value of field 'gpiInfo'.
     * 
     * @return the value of field 'GpiInfo'.
     */
    public bean.GpiInfo getGpiInfo(
    ) {
        return this._gpiInfo;
    }

    /**
     * Method getGpiOut.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.GpiOut at the given index
     */
    public bean.GpiOut getGpiOut(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._gpiOutList.size()) {
            throw new IndexOutOfBoundsException("getGpiOut: Index value '" + index + "' not in range [0.." + (this._gpiOutList.size() - 1) + "]");
        }
        
        return (bean.GpiOut) _gpiOutList.get(index);
    }

    /**
     * Method getGpiOut.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.GpiOut[] getGpiOut(
    ) {
        bean.GpiOut[] array = new bean.GpiOut[0];
        return (bean.GpiOut[]) this._gpiOutList.toArray(array);
    }

    /**
     * Method getGpiOutCount.
     * 
     * @return the size of this collection
     */
    public int getGpiOutCount(
    ) {
        return this._gpiOutList.size();
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
     * Method iterateGpiIn.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateGpiIn(
    ) {
        return this._gpiInList.iterator();
    }

    /**
     * Method iterateGpiOut.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateGpiOut(
    ) {
        return this._gpiOutList.iterator();
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
    public void removeAllGpiIn(
    ) {
        this._gpiInList.clear();
    }

    /**
     */
    public void removeAllGpiOut(
    ) {
        this._gpiOutList.clear();
    }

    /**
     * Method removeGpiIn.
     * 
     * @param vGpiIn
     * @return true if the object was removed from the collection.
     */
    public boolean removeGpiIn(
            final bean.GpiIn vGpiIn) {
        boolean removed = _gpiInList.remove(vGpiIn);
        return removed;
    }

    /**
     * Method removeGpiInAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.GpiIn removeGpiInAt(
            final int index) {
        java.lang.Object obj = this._gpiInList.remove(index);
        return (bean.GpiIn) obj;
    }

    /**
     * Method removeGpiOut.
     * 
     * @param vGpiOut
     * @return true if the object was removed from the collection.
     */
    public boolean removeGpiOut(
            final bean.GpiOut vGpiOut) {
        boolean removed = _gpiOutList.remove(vGpiOut);
        return removed;
    }

    /**
     * Method removeGpiOutAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.GpiOut removeGpiOutAt(
            final int index) {
        java.lang.Object obj = this._gpiOutList.remove(index);
        return (bean.GpiOut) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vGpiIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setGpiIn(
            final int index,
            final bean.GpiIn vGpiIn)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._gpiInList.size()) {
            throw new IndexOutOfBoundsException("setGpiIn: Index value '" + index + "' not in range [0.." + (this._gpiInList.size() - 1) + "]");
        }
        
        this._gpiInList.set(index, vGpiIn);
    }

    /**
     * 
     * 
     * @param vGpiInArray
     */
    public void setGpiIn(
            final bean.GpiIn[] vGpiInArray) {
        //-- copy array
        _gpiInList.clear();
        
        for (int i = 0; i < vGpiInArray.length; i++) {
                this._gpiInList.add(vGpiInArray[i]);
        }
    }

    /**
     * Sets the value of field 'gpiInfo'.
     * 
     * @param gpiInfo the value of field 'gpiInfo'.
     */
    public void setGpiInfo(
            final bean.GpiInfo gpiInfo) {
        this._gpiInfo = gpiInfo;
    }

    /**
     * 
     * 
     * @param index
     * @param vGpiOut
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setGpiOut(
            final int index,
            final bean.GpiOut vGpiOut)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._gpiOutList.size()) {
            throw new IndexOutOfBoundsException("setGpiOut: Index value '" + index + "' not in range [0.." + (this._gpiOutList.size() - 1) + "]");
        }
        
        this._gpiOutList.set(index, vGpiOut);
    }

    /**
     * 
     * 
     * @param vGpiOutArray
     */
    public void setGpiOut(
            final bean.GpiOut[] vGpiOutArray) {
        //-- copy array
        _gpiOutList.clear();
        
        for (int i = 0; i < vGpiOutArray.length; i++) {
                this._gpiOutList.add(vGpiOutArray[i]);
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
     * @return the unmarshaled bean.Gpis
     */
    public static bean.Gpis unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Gpis) Unmarshaller.unmarshal(bean.Gpis.class, reader);
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
