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
 * Class AudioOut.
 * 
 * @version $Revision$ $Date$
 */
public class AudioOut implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _aoutList.
     */
    private java.util.List _aoutList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AudioOut() {
        super();
        this._aoutList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAout
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAout(
            final bean.Aout vAout)
    throws java.lang.IndexOutOfBoundsException {
        this._aoutList.add(vAout);
    }

    /**
     * 
     * 
     * @param index
     * @param vAout
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAout(
            final int index,
            final bean.Aout vAout)
    throws java.lang.IndexOutOfBoundsException {
        this._aoutList.add(index, vAout);
    }

    /**
     * Method enumerateAout.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateAout(
    ) {
        return java.util.Collections.enumeration(this._aoutList);
    }

    /**
     * Method getAout.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Aout at the given index
     */
    public bean.Aout getAout(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._aoutList.size()) {
            throw new IndexOutOfBoundsException("getAout: Index value '" + index + "' not in range [0.." + (this._aoutList.size() - 1) + "]");
        }
        
        return (bean.Aout) _aoutList.get(index);
    }

    /**
     * Method getAout.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Aout[] getAout(
    ) {
        bean.Aout[] array = new bean.Aout[0];
        return (bean.Aout[]) this._aoutList.toArray(array);
    }

    /**
     * Method getAoutCount.
     * 
     * @return the size of this collection
     */
    public int getAoutCount(
    ) {
        return this._aoutList.size();
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
     * Method iterateAout.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateAout(
    ) {
        return this._aoutList.iterator();
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
    public void removeAllAout(
    ) {
        this._aoutList.clear();
    }

    /**
     * Method removeAout.
     * 
     * @param vAout
     * @return true if the object was removed from the collection.
     */
    public boolean removeAout(
            final bean.Aout vAout) {
        boolean removed = _aoutList.remove(vAout);
        return removed;
    }

    /**
     * Method removeAoutAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Aout removeAoutAt(
            final int index) {
        java.lang.Object obj = this._aoutList.remove(index);
        return (bean.Aout) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vAout
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAout(
            final int index,
            final bean.Aout vAout)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._aoutList.size()) {
            throw new IndexOutOfBoundsException("setAout: Index value '" + index + "' not in range [0.." + (this._aoutList.size() - 1) + "]");
        }
        
        this._aoutList.set(index, vAout);
    }

    /**
     * 
     * 
     * @param vAoutArray
     */
    public void setAout(
            final bean.Aout[] vAoutArray) {
        //-- copy array
        _aoutList.clear();
        
        for (int i = 0; i < vAoutArray.length; i++) {
                this._aoutList.add(vAoutArray[i]);
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
     * @return the unmarshaled bean.AudioOut
     */
    public static bean.AudioOut unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.AudioOut) Unmarshaller.unmarshal(bean.AudioOut.class, reader);
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
