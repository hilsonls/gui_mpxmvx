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
 * Class SagPresets.
 * 
 * @version $Revision$ $Date$
 */
public class SagPresets implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sagNameList.
     */
    private java.util.List _sagNameList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SagPresets() {
        super();
        this._sagNameList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSagName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSagName(
            final bean.SagName vSagName)
    throws java.lang.IndexOutOfBoundsException {
        this._sagNameList.add(vSagName);
    }

    /**
     * 
     * 
     * @param index
     * @param vSagName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSagName(
            final int index,
            final bean.SagName vSagName)
    throws java.lang.IndexOutOfBoundsException {
        this._sagNameList.add(index, vSagName);
    }

    /**
     * Method enumerateSagName.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateSagName(
    ) {
        return java.util.Collections.enumeration(this._sagNameList);
    }

    /**
     * Method getSagName.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.SagName at the given index
     */
    public bean.SagName getSagName(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._sagNameList.size()) {
            throw new IndexOutOfBoundsException("getSagName: Index value '" + index + "' not in range [0.." + (this._sagNameList.size() - 1) + "]");
        }
        
        return (bean.SagName) _sagNameList.get(index);
    }

    /**
     * Method getSagName.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.SagName[] getSagName(
    ) {
        bean.SagName[] array = new bean.SagName[0];
        return (bean.SagName[]) this._sagNameList.toArray(array);
    }

    /**
     * Method getSagNameCount.
     * 
     * @return the size of this collection
     */
    public int getSagNameCount(
    ) {
        return this._sagNameList.size();
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
     * Method iterateSagName.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateSagName(
    ) {
        return this._sagNameList.iterator();
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
    public void removeAllSagName(
    ) {
        this._sagNameList.clear();
    }

    /**
     * Method removeSagName.
     * 
     * @param vSagName
     * @return true if the object was removed from the collection.
     */
    public boolean removeSagName(
            final bean.SagName vSagName) {
        boolean removed = _sagNameList.remove(vSagName);
        return removed;
    }

    /**
     * Method removeSagNameAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.SagName removeSagNameAt(
            final int index) {
        java.lang.Object obj = this._sagNameList.remove(index);
        return (bean.SagName) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vSagName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSagName(
            final int index,
            final bean.SagName vSagName)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._sagNameList.size()) {
            throw new IndexOutOfBoundsException("setSagName: Index value '" + index + "' not in range [0.." + (this._sagNameList.size() - 1) + "]");
        }
        
        this._sagNameList.set(index, vSagName);
    }

    /**
     * 
     * 
     * @param vSagNameArray
     */
    public void setSagName(
            final bean.SagName[] vSagNameArray) {
        //-- copy array
        _sagNameList.clear();
        
        for (int i = 0; i < vSagNameArray.length; i++) {
                this._sagNameList.add(vSagNameArray[i]);
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
     * @return the unmarshaled bean.SagPresets
     */
    public static bean.SagPresets unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.SagPresets) Unmarshaller.unmarshal(bean.SagPresets.class, reader);
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
