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
 * Class ObjectsZOrder.
 * 
 * @version $Revision$ $Date$
 */
public class ObjectsZOrder implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _objectZOrderList.
     */
    private java.util.List _objectZOrderList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ObjectsZOrder() {
        super();
        this._objectZOrderList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vObjectZOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addObjectZOrder(
            final bean.ObjectZOrder vObjectZOrder)
    throws java.lang.IndexOutOfBoundsException {
        this._objectZOrderList.add(vObjectZOrder);
    }

    /**
     * 
     * 
     * @param index
     * @param vObjectZOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addObjectZOrder(
            final int index,
            final bean.ObjectZOrder vObjectZOrder)
    throws java.lang.IndexOutOfBoundsException {
        this._objectZOrderList.add(index, vObjectZOrder);
    }

    /**
     * Method enumerateObjectZOrder.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateObjectZOrder(
    ) {
        return java.util.Collections.enumeration(this._objectZOrderList);
    }

    /**
     * Method getObjectZOrder.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.ObjectZOrder at the given index
     */
    public bean.ObjectZOrder getObjectZOrder(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._objectZOrderList.size()) {
            throw new IndexOutOfBoundsException("getObjectZOrder: Index value '" + index + "' not in range [0.." + (this._objectZOrderList.size() - 1) + "]");
        }
        
        return (bean.ObjectZOrder) _objectZOrderList.get(index);
    }

    /**
     * Method getObjectZOrder.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.ObjectZOrder[] getObjectZOrder(
    ) {
        bean.ObjectZOrder[] array = new bean.ObjectZOrder[0];
        return (bean.ObjectZOrder[]) this._objectZOrderList.toArray(array);
    }

    /**
     * Method getObjectZOrderCount.
     * 
     * @return the size of this collection
     */
    public int getObjectZOrderCount(
    ) {
        return this._objectZOrderList.size();
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
     * Method iterateObjectZOrder.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateObjectZOrder(
    ) {
        return this._objectZOrderList.iterator();
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
    public void removeAllObjectZOrder(
    ) {
        this._objectZOrderList.clear();
    }

    /**
     * Method removeObjectZOrder.
     * 
     * @param vObjectZOrder
     * @return true if the object was removed from the collection.
     */
    public boolean removeObjectZOrder(
            final bean.ObjectZOrder vObjectZOrder) {
        boolean removed = _objectZOrderList.remove(vObjectZOrder);
        return removed;
    }

    /**
     * Method removeObjectZOrderAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.ObjectZOrder removeObjectZOrderAt(
            final int index) {
        java.lang.Object obj = this._objectZOrderList.remove(index);
        return (bean.ObjectZOrder) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vObjectZOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setObjectZOrder(
            final int index,
            final bean.ObjectZOrder vObjectZOrder)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._objectZOrderList.size()) {
            throw new IndexOutOfBoundsException("setObjectZOrder: Index value '" + index + "' not in range [0.." + (this._objectZOrderList.size() - 1) + "]");
        }
        
        this._objectZOrderList.set(index, vObjectZOrder);
    }

    /**
     * 
     * 
     * @param vObjectZOrderArray
     */
    public void setObjectZOrder(
            final bean.ObjectZOrder[] vObjectZOrderArray) {
        //-- copy array
        _objectZOrderList.clear();
        
        for (int i = 0; i < vObjectZOrderArray.length; i++) {
                this._objectZOrderList.add(vObjectZOrderArray[i]);
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
     * @return the unmarshaled bean.ObjectsZOrder
     */
    public static bean.ObjectsZOrder unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.ObjectsZOrder) Unmarshaller.unmarshal(bean.ObjectsZOrder.class, reader);
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
