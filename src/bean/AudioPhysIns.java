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
 * Class AudioPhysIns.
 * 
 * @version $Revision$ $Date$
 */
public class AudioPhysIns implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _snellAudioInList.
     */
    private java.util.List _snellAudioInList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AudioPhysIns() {
        super();
        this._snellAudioInList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSnellAudioIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSnellAudioIn(
            final bean.SnellAudioIn vSnellAudioIn)
    throws java.lang.IndexOutOfBoundsException {
        this._snellAudioInList.add(vSnellAudioIn);
    }

    /**
     * 
     * 
     * @param index
     * @param vSnellAudioIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSnellAudioIn(
            final int index,
            final bean.SnellAudioIn vSnellAudioIn)
    throws java.lang.IndexOutOfBoundsException {
        this._snellAudioInList.add(index, vSnellAudioIn);
    }

    /**
     * Method enumerateSnellAudioIn.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateSnellAudioIn(
    ) {
        return java.util.Collections.enumeration(this._snellAudioInList);
    }

    /**
     * Method getSnellAudioIn.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.SnellAudioIn at the given index
     */
    public bean.SnellAudioIn getSnellAudioIn(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._snellAudioInList.size()) {
            throw new IndexOutOfBoundsException("getSnellAudioIn: Index value '" + index + "' not in range [0.." + (this._snellAudioInList.size() - 1) + "]");
        }
        
        return (bean.SnellAudioIn) _snellAudioInList.get(index);
    }

    /**
     * Method getSnellAudioIn.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.SnellAudioIn[] getSnellAudioIn(
    ) {
        bean.SnellAudioIn[] array = new bean.SnellAudioIn[0];
        return (bean.SnellAudioIn[]) this._snellAudioInList.toArray(array);
    }

    /**
     * Method getSnellAudioInCount.
     * 
     * @return the size of this collection
     */
    public int getSnellAudioInCount(
    ) {
        return this._snellAudioInList.size();
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
     * Method iterateSnellAudioIn.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateSnellAudioIn(
    ) {
        return this._snellAudioInList.iterator();
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
    public void removeAllSnellAudioIn(
    ) {
        this._snellAudioInList.clear();
    }

    /**
     * Method removeSnellAudioIn.
     * 
     * @param vSnellAudioIn
     * @return true if the object was removed from the collection.
     */
    public boolean removeSnellAudioIn(
            final bean.SnellAudioIn vSnellAudioIn) {
        boolean removed = _snellAudioInList.remove(vSnellAudioIn);
        return removed;
    }

    /**
     * Method removeSnellAudioInAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.SnellAudioIn removeSnellAudioInAt(
            final int index) {
        java.lang.Object obj = this._snellAudioInList.remove(index);
        return (bean.SnellAudioIn) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vSnellAudioIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSnellAudioIn(
            final int index,
            final bean.SnellAudioIn vSnellAudioIn)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._snellAudioInList.size()) {
            throw new IndexOutOfBoundsException("setSnellAudioIn: Index value '" + index + "' not in range [0.." + (this._snellAudioInList.size() - 1) + "]");
        }
        
        this._snellAudioInList.set(index, vSnellAudioIn);
    }

    /**
     * 
     * 
     * @param vSnellAudioInArray
     */
    public void setSnellAudioIn(
            final bean.SnellAudioIn[] vSnellAudioInArray) {
        //-- copy array
        _snellAudioInList.clear();
        
        for (int i = 0; i < vSnellAudioInArray.length; i++) {
                this._snellAudioInList.add(vSnellAudioInArray[i]);
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
     * @return the unmarshaled bean.AudioPhysIns
     */
    public static bean.AudioPhysIns unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.AudioPhysIns) Unmarshaller.unmarshal(bean.AudioPhysIns.class, reader);
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
