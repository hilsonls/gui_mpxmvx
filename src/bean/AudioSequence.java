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
 * Class AudioSequence.
 * 
 * @version $Revision$ $Date$
 */
public class AudioSequence implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public AudioSequence() {
        super();
        this._items = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAudioSequenceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAudioSequenceItem(
            final bean.AudioSequenceItem vAudioSequenceItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vAudioSequenceItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vAudioSequenceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAudioSequenceItem(
            final int index,
            final bean.AudioSequenceItem vAudioSequenceItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vAudioSequenceItem);
    }

    /**
     * Method enumerateAudioSequenceItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateAudioSequenceItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getAudioSequenceItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.AudioSequenceItem at the given
     * index
     */
    public bean.AudioSequenceItem getAudioSequenceItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getAudioSequenceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }
        
        return (bean.AudioSequenceItem) _items.get(index);
    }

    /**
     * Method getAudioSequenceItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.AudioSequenceItem[] getAudioSequenceItem(
    ) {
        bean.AudioSequenceItem[] array = new bean.AudioSequenceItem[0];
        return (bean.AudioSequenceItem[]) this._items.toArray(array);
    }

    /**
     * Method getAudioSequenceItemCount.
     * 
     * @return the size of this collection
     */
    public int getAudioSequenceItemCount(
    ) {
        return this._items.size();
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
     * Method iterateAudioSequenceItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateAudioSequenceItem(
    ) {
        return this._items.iterator();
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
    public void removeAllAudioSequenceItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeAudioSequenceItem.
     * 
     * @param vAudioSequenceItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeAudioSequenceItem(
            final bean.AudioSequenceItem vAudioSequenceItem) {
        boolean removed = _items.remove(vAudioSequenceItem);
        return removed;
    }

    /**
     * Method removeAudioSequenceItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.AudioSequenceItem removeAudioSequenceItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (bean.AudioSequenceItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vAudioSequenceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAudioSequenceItem(
            final int index,
            final bean.AudioSequenceItem vAudioSequenceItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setAudioSequenceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }
        
        this._items.set(index, vAudioSequenceItem);
    }

    /**
     * 
     * 
     * @param vAudioSequenceItemArray
     */
    public void setAudioSequenceItem(
            final bean.AudioSequenceItem[] vAudioSequenceItemArray) {
        //-- copy array
        _items.clear();
        
        for (int i = 0; i < vAudioSequenceItemArray.length; i++) {
                this._items.add(vAudioSequenceItemArray[i]);
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
     * @return the unmarshaled bean.AudioSequence
     */
    public static bean.AudioSequence unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.AudioSequence) Unmarshaller.unmarshal(bean.AudioSequence.class, reader);
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
