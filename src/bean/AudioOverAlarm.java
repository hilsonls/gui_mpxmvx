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
 * Class AudioOverAlarm.
 * 
 * @version $Revision$ $Date$
 */
public class AudioOverAlarm implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _analogueThreshold.
     */
    private bean.AnalogueThreshold _analogueThreshold;

    /**
     * Field _digitalThreshold.
     */
    private bean.DigitalThreshold _digitalThreshold;

    /**
     * Field _chanList.
     */
    private java.util.List _chanList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AudioOverAlarm() {
        super();
        this._chanList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vChan
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addChan(
            final bean.Chan vChan)
    throws java.lang.IndexOutOfBoundsException {
        this._chanList.add(vChan);
    }

    /**
     * 
     * 
     * @param index
     * @param vChan
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addChan(
            final int index,
            final bean.Chan vChan)
    throws java.lang.IndexOutOfBoundsException {
        this._chanList.add(index, vChan);
    }

    /**
     * Method enumerateChan.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateChan(
    ) {
        return java.util.Collections.enumeration(this._chanList);
    }

    /**
     * Returns the value of field 'analogueThreshold'.
     * 
     * @return the value of field 'AnalogueThreshold'.
     */
    public bean.AnalogueThreshold getAnalogueThreshold(
    ) {
        return this._analogueThreshold;
    }

    /**
     * Method getChan.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Chan at the given index
     */
    public bean.Chan getChan(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._chanList.size()) {
            throw new IndexOutOfBoundsException("getChan: Index value '" + index + "' not in range [0.." + (this._chanList.size() - 1) + "]");
        }
        
        return (bean.Chan) _chanList.get(index);
    }

    /**
     * Method getChan.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Chan[] getChan(
    ) {
        bean.Chan[] array = new bean.Chan[0];
        return (bean.Chan[]) this._chanList.toArray(array);
    }

    /**
     * Method getChanCount.
     * 
     * @return the size of this collection
     */
    public int getChanCount(
    ) {
        return this._chanList.size();
    }

    /**
     * Returns the value of field 'digitalThreshold'.
     * 
     * @return the value of field 'DigitalThreshold'.
     */
    public bean.DigitalThreshold getDigitalThreshold(
    ) {
        return this._digitalThreshold;
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
     * Method iterateChan.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateChan(
    ) {
        return this._chanList.iterator();
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
    public void removeAllChan(
    ) {
        this._chanList.clear();
    }

    /**
     * Method removeChan.
     * 
     * @param vChan
     * @return true if the object was removed from the collection.
     */
    public boolean removeChan(
            final bean.Chan vChan) {
        boolean removed = _chanList.remove(vChan);
        return removed;
    }

    /**
     * Method removeChanAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Chan removeChanAt(
            final int index) {
        java.lang.Object obj = this._chanList.remove(index);
        return (bean.Chan) obj;
    }

    /**
     * Sets the value of field 'analogueThreshold'.
     * 
     * @param analogueThreshold the value of field
     * 'analogueThreshold'.
     */
    public void setAnalogueThreshold(
            final bean.AnalogueThreshold analogueThreshold) {
        this._analogueThreshold = analogueThreshold;
    }

    /**
     * 
     * 
     * @param index
     * @param vChan
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setChan(
            final int index,
            final bean.Chan vChan)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._chanList.size()) {
            throw new IndexOutOfBoundsException("setChan: Index value '" + index + "' not in range [0.." + (this._chanList.size() - 1) + "]");
        }
        
        this._chanList.set(index, vChan);
    }

    /**
     * 
     * 
     * @param vChanArray
     */
    public void setChan(
            final bean.Chan[] vChanArray) {
        //-- copy array
        _chanList.clear();
        
        for (int i = 0; i < vChanArray.length; i++) {
                this._chanList.add(vChanArray[i]);
        }
    }

    /**
     * Sets the value of field 'digitalThreshold'.
     * 
     * @param digitalThreshold the value of field 'digitalThreshold'
     */
    public void setDigitalThreshold(
            final bean.DigitalThreshold digitalThreshold) {
        this._digitalThreshold = digitalThreshold;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.AudioOverAlarm
     */
    public static bean.AudioOverAlarm unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.AudioOverAlarm) Unmarshaller.unmarshal(bean.AudioOverAlarm.class, reader);
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
