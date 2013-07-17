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
 * Class SourceSequence.
 * 
 * @version $Revision$ $Date$
 */
public class SourceSequence implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _embeddedInputList.
     */
    private java.util.List _embeddedInputList;

    /**
     * Field _embeddedPhaseList.
     */
    private java.util.List _embeddedPhaseList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SourceSequence() {
        super();
        this._embeddedInputList = new java.util.ArrayList();
        this._embeddedPhaseList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vEmbeddedInput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEmbeddedInput(
            final bean.EmbeddedInput vEmbeddedInput)
    throws java.lang.IndexOutOfBoundsException {
        this._embeddedInputList.add(vEmbeddedInput);
    }

    /**
     * 
     * 
     * @param index
     * @param vEmbeddedInput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEmbeddedInput(
            final int index,
            final bean.EmbeddedInput vEmbeddedInput)
    throws java.lang.IndexOutOfBoundsException {
        this._embeddedInputList.add(index, vEmbeddedInput);
    }

    /**
     * 
     * 
     * @param vEmbeddedPhase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEmbeddedPhase(
            final bean.EmbeddedPhase vEmbeddedPhase)
    throws java.lang.IndexOutOfBoundsException {
        this._embeddedPhaseList.add(vEmbeddedPhase);
    }

    /**
     * 
     * 
     * @param index
     * @param vEmbeddedPhase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEmbeddedPhase(
            final int index,
            final bean.EmbeddedPhase vEmbeddedPhase)
    throws java.lang.IndexOutOfBoundsException {
        this._embeddedPhaseList.add(index, vEmbeddedPhase);
    }

    /**
     * Method enumerateEmbeddedInput.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateEmbeddedInput(
    ) {
        return java.util.Collections.enumeration(this._embeddedInputList);
    }

    /**
     * Method enumerateEmbeddedPhase.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateEmbeddedPhase(
    ) {
        return java.util.Collections.enumeration(this._embeddedPhaseList);
    }

    /**
     * Method getEmbeddedInput.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.EmbeddedInput at the given inde
     */
    public bean.EmbeddedInput getEmbeddedInput(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._embeddedInputList.size()) {
            throw new IndexOutOfBoundsException("getEmbeddedInput: Index value '" + index + "' not in range [0.." + (this._embeddedInputList.size() - 1) + "]");
        }
        
        return (bean.EmbeddedInput) _embeddedInputList.get(index);
    }

    /**
     * Method getEmbeddedInput.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.EmbeddedInput[] getEmbeddedInput(
    ) {
        bean.EmbeddedInput[] array = new bean.EmbeddedInput[0];
        return (bean.EmbeddedInput[]) this._embeddedInputList.toArray(array);
    }

    /**
     * Method getEmbeddedInputCount.
     * 
     * @return the size of this collection
     */
    public int getEmbeddedInputCount(
    ) {
        return this._embeddedInputList.size();
    }

    /**
     * Method getEmbeddedPhase.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.EmbeddedPhase at the given inde
     */
    public bean.EmbeddedPhase getEmbeddedPhase(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._embeddedPhaseList.size()) {
            throw new IndexOutOfBoundsException("getEmbeddedPhase: Index value '" + index + "' not in range [0.." + (this._embeddedPhaseList.size() - 1) + "]");
        }
        
        return (bean.EmbeddedPhase) _embeddedPhaseList.get(index);
    }

    /**
     * Method getEmbeddedPhase.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.EmbeddedPhase[] getEmbeddedPhase(
    ) {
        bean.EmbeddedPhase[] array = new bean.EmbeddedPhase[0];
        return (bean.EmbeddedPhase[]) this._embeddedPhaseList.toArray(array);
    }

    /**
     * Method getEmbeddedPhaseCount.
     * 
     * @return the size of this collection
     */
    public int getEmbeddedPhaseCount(
    ) {
        return this._embeddedPhaseList.size();
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
     * Method iterateEmbeddedInput.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateEmbeddedInput(
    ) {
        return this._embeddedInputList.iterator();
    }

    /**
     * Method iterateEmbeddedPhase.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateEmbeddedPhase(
    ) {
        return this._embeddedPhaseList.iterator();
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
    public void removeAllEmbeddedInput(
    ) {
        this._embeddedInputList.clear();
    }

    /**
     */
    public void removeAllEmbeddedPhase(
    ) {
        this._embeddedPhaseList.clear();
    }

    /**
     * Method removeEmbeddedInput.
     * 
     * @param vEmbeddedInput
     * @return true if the object was removed from the collection.
     */
    public boolean removeEmbeddedInput(
            final bean.EmbeddedInput vEmbeddedInput) {
        boolean removed = _embeddedInputList.remove(vEmbeddedInput);
        return removed;
    }

    /**
     * Method removeEmbeddedInputAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.EmbeddedInput removeEmbeddedInputAt(
            final int index) {
        java.lang.Object obj = this._embeddedInputList.remove(index);
        return (bean.EmbeddedInput) obj;
    }

    /**
     * Method removeEmbeddedPhase.
     * 
     * @param vEmbeddedPhase
     * @return true if the object was removed from the collection.
     */
    public boolean removeEmbeddedPhase(
            final bean.EmbeddedPhase vEmbeddedPhase) {
        boolean removed = _embeddedPhaseList.remove(vEmbeddedPhase);
        return removed;
    }

    /**
     * Method removeEmbeddedPhaseAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.EmbeddedPhase removeEmbeddedPhaseAt(
            final int index) {
        java.lang.Object obj = this._embeddedPhaseList.remove(index);
        return (bean.EmbeddedPhase) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vEmbeddedInput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setEmbeddedInput(
            final int index,
            final bean.EmbeddedInput vEmbeddedInput)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._embeddedInputList.size()) {
            throw new IndexOutOfBoundsException("setEmbeddedInput: Index value '" + index + "' not in range [0.." + (this._embeddedInputList.size() - 1) + "]");
        }
        
        this._embeddedInputList.set(index, vEmbeddedInput);
    }

    /**
     * 
     * 
     * @param vEmbeddedInputArray
     */
    public void setEmbeddedInput(
            final bean.EmbeddedInput[] vEmbeddedInputArray) {
        //-- copy array
        _embeddedInputList.clear();
        
        for (int i = 0; i < vEmbeddedInputArray.length; i++) {
                this._embeddedInputList.add(vEmbeddedInputArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vEmbeddedPhase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setEmbeddedPhase(
            final int index,
            final bean.EmbeddedPhase vEmbeddedPhase)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._embeddedPhaseList.size()) {
            throw new IndexOutOfBoundsException("setEmbeddedPhase: Index value '" + index + "' not in range [0.." + (this._embeddedPhaseList.size() - 1) + "]");
        }
        
        this._embeddedPhaseList.set(index, vEmbeddedPhase);
    }

    /**
     * 
     * 
     * @param vEmbeddedPhaseArray
     */
    public void setEmbeddedPhase(
            final bean.EmbeddedPhase[] vEmbeddedPhaseArray) {
        //-- copy array
        _embeddedPhaseList.clear();
        
        for (int i = 0; i < vEmbeddedPhaseArray.length; i++) {
                this._embeddedPhaseList.add(vEmbeddedPhaseArray[i]);
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
     * @return the unmarshaled bean.SourceSequence
     */
    public static bean.SourceSequence unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.SourceSequence) Unmarshaller.unmarshal(bean.SourceSequence.class, reader);
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
