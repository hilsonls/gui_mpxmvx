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
 * Class VideoPhysIns.
 * 
 * @version $Revision$ $Date$
 */
public class VideoPhysIns implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _inList.
     */
    private java.util.List _inList;


      //----------------/
     //- Constructors -/
    //----------------/

    public VideoPhysIns() {
        super();
        this._inList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIn(
            final bean.In vIn)
    throws java.lang.IndexOutOfBoundsException {
        this._inList.add(vIn);
    }

    /**
     * 
     * 
     * @param index
     * @param vIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIn(
            final int index,
            final bean.In vIn)
    throws java.lang.IndexOutOfBoundsException {
        this._inList.add(index, vIn);
    }

    /**
     * Method enumerateIn.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateIn(
    ) {
        return java.util.Collections.enumeration(this._inList);
    }

    /**
     * Method getIn.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.In at the given index
     */
    public bean.In getIn(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._inList.size()) {
            throw new IndexOutOfBoundsException("getIn: Index value '" + index + "' not in range [0.." + (this._inList.size() - 1) + "]");
        }
        
        return (bean.In) _inList.get(index);
    }

    /**
     * Method getIn.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.In[] getIn(
    ) {
        bean.In[] array = new bean.In[0];
        return (bean.In[]) this._inList.toArray(array);
    }

    /**
     * Method getInCount.
     * 
     * @return the size of this collection
     */
    public int getInCount(
    ) {
        return this._inList.size();
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
     * Method iterateIn.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateIn(
    ) {
        return this._inList.iterator();
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
    public void removeAllIn(
    ) {
        this._inList.clear();
    }

    /**
     * Method removeIn.
     * 
     * @param vIn
     * @return true if the object was removed from the collection.
     */
    public boolean removeIn(
            final bean.In vIn) {
        boolean removed = _inList.remove(vIn);
        return removed;
    }

    /**
     * Method removeInAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.In removeInAt(
            final int index) {
        java.lang.Object obj = this._inList.remove(index);
        return (bean.In) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vIn
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setIn(
            final int index,
            final bean.In vIn)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._inList.size()) {
            throw new IndexOutOfBoundsException("setIn: Index value '" + index + "' not in range [0.." + (this._inList.size() - 1) + "]");
        }
        
        this._inList.set(index, vIn);
    }

    /**
     * 
     * 
     * @param vInArray
     */
    public void setIn(
            final bean.In[] vInArray) {
        //-- copy array
        _inList.clear();
        
        for (int i = 0; i < vInArray.length; i++) {
                this._inList.add(vInArray[i]);
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
     * @return the unmarshaled bean.VideoPhysIns
     */
    public static bean.VideoPhysIns unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.VideoPhysIns) Unmarshaller.unmarshal(bean.VideoPhysIns.class, reader);
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
