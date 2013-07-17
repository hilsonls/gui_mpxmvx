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
 * Class CarrierLossAlarm.
 * 
 * @version $Revision$ $Date$
 */
public class CarrierLossAlarm implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _pairList.
     */
    private java.util.List _pairList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CarrierLossAlarm() {
        super();
        this._pairList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPair
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPair(
            final bean.Pair vPair)
    throws java.lang.IndexOutOfBoundsException {
        this._pairList.add(vPair);
    }

    /**
     * 
     * 
     * @param index
     * @param vPair
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPair(
            final int index,
            final bean.Pair vPair)
    throws java.lang.IndexOutOfBoundsException {
        this._pairList.add(index, vPair);
    }

    /**
     * Method enumeratePair.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumeratePair(
    ) {
        return java.util.Collections.enumeration(this._pairList);
    }

    /**
     * Method getPair.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Pair at the given index
     */
    public bean.Pair getPair(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._pairList.size()) {
            throw new IndexOutOfBoundsException("getPair: Index value '" + index + "' not in range [0.." + (this._pairList.size() - 1) + "]");
        }
        
        return (bean.Pair) _pairList.get(index);
    }

    /**
     * Method getPair.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Pair[] getPair(
    ) {
        bean.Pair[] array = new bean.Pair[0];
        return (bean.Pair[]) this._pairList.toArray(array);
    }

    /**
     * Method getPairCount.
     * 
     * @return the size of this collection
     */
    public int getPairCount(
    ) {
        return this._pairList.size();
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
     * Method iteratePair.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iteratePair(
    ) {
        return this._pairList.iterator();
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
    public void removeAllPair(
    ) {
        this._pairList.clear();
    }

    /**
     * Method removePair.
     * 
     * @param vPair
     * @return true if the object was removed from the collection.
     */
    public boolean removePair(
            final bean.Pair vPair) {
        boolean removed = _pairList.remove(vPair);
        return removed;
    }

    /**
     * Method removePairAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Pair removePairAt(
            final int index) {
        java.lang.Object obj = this._pairList.remove(index);
        return (bean.Pair) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vPair
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPair(
            final int index,
            final bean.Pair vPair)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._pairList.size()) {
            throw new IndexOutOfBoundsException("setPair: Index value '" + index + "' not in range [0.." + (this._pairList.size() - 1) + "]");
        }
        
        this._pairList.set(index, vPair);
    }

    /**
     * 
     * 
     * @param vPairArray
     */
    public void setPair(
            final bean.Pair[] vPairArray) {
        //-- copy array
        _pairList.clear();
        
        for (int i = 0; i < vPairArray.length; i++) {
                this._pairList.add(vPairArray[i]);
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
     * @return the unmarshaled bean.CarrierLossAlarm
     */
    public static bean.CarrierLossAlarm unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.CarrierLossAlarm) Unmarshaller.unmarshal(bean.CarrierLossAlarm.class, reader);
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
