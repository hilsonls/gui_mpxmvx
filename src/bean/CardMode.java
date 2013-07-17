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
 * Class CardMode.
 * 
 * @version $Revision$ $Date$
 */
public class CardMode implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _val.
     */
    private java.lang.String _val;

    /**
     * Field _optionsName.
     */
    private java.lang.String _optionsName;

    /**
     * Field _sourceInputList.
     */
    private java.util.List _sourceInputList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CardMode() {
        super();
        this._sourceInputList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSourceInput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSourceInput(
            final bean.SourceInput vSourceInput)
    throws java.lang.IndexOutOfBoundsException {
        this._sourceInputList.add(vSourceInput);
    }

    /**
     * 
     * 
     * @param index
     * @param vSourceInput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSourceInput(
            final int index,
            final bean.SourceInput vSourceInput)
    throws java.lang.IndexOutOfBoundsException {
        this._sourceInputList.add(index, vSourceInput);
    }

    /**
     * Method enumerateSourceInput.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateSourceInput(
    ) {
        return java.util.Collections.enumeration(this._sourceInputList);
    }

    /**
     * Returns the value of field 'optionsName'.
     * 
     * @return the value of field 'OptionsName'.
     */
    public java.lang.String getOptionsName(
    ) {
        return this._optionsName;
    }

    /**
     * Method getSourceInput.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.SourceInput at the given index
     */
    public bean.SourceInput getSourceInput(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._sourceInputList.size()) {
            throw new IndexOutOfBoundsException("getSourceInput: Index value '" + index + "' not in range [0.." + (this._sourceInputList.size() - 1) + "]");
        }
        
        return (bean.SourceInput) _sourceInputList.get(index);
    }

    /**
     * Method getSourceInput.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.SourceInput[] getSourceInput(
    ) {
        bean.SourceInput[] array = new bean.SourceInput[0];
        return (bean.SourceInput[]) this._sourceInputList.toArray(array);
    }

    /**
     * Method getSourceInputCount.
     * 
     * @return the size of this collection
     */
    public int getSourceInputCount(
    ) {
        return this._sourceInputList.size();
    }

    /**
     * Returns the value of field 'val'.
     * 
     * @return the value of field 'Val'.
     */
    public java.lang.String getVal(
    ) {
        return this._val;
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
     * Method iterateSourceInput.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateSourceInput(
    ) {
        return this._sourceInputList.iterator();
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
    public void removeAllSourceInput(
    ) {
        this._sourceInputList.clear();
    }

    /**
     * Method removeSourceInput.
     * 
     * @param vSourceInput
     * @return true if the object was removed from the collection.
     */
    public boolean removeSourceInput(
            final bean.SourceInput vSourceInput) {
        boolean removed = _sourceInputList.remove(vSourceInput);
        return removed;
    }

    /**
     * Method removeSourceInputAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.SourceInput removeSourceInputAt(
            final int index) {
        java.lang.Object obj = this._sourceInputList.remove(index);
        return (bean.SourceInput) obj;
    }

    /**
     * Sets the value of field 'optionsName'.
     * 
     * @param optionsName the value of field 'optionsName'.
     */
    public void setOptionsName(
            final java.lang.String optionsName) {
        this._optionsName = optionsName;
    }

    /**
     * 
     * 
     * @param index
     * @param vSourceInput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSourceInput(
            final int index,
            final bean.SourceInput vSourceInput)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._sourceInputList.size()) {
            throw new IndexOutOfBoundsException("setSourceInput: Index value '" + index + "' not in range [0.." + (this._sourceInputList.size() - 1) + "]");
        }
        
        this._sourceInputList.set(index, vSourceInput);
    }

    /**
     * 
     * 
     * @param vSourceInputArray
     */
    public void setSourceInput(
            final bean.SourceInput[] vSourceInputArray) {
        //-- copy array
        _sourceInputList.clear();
        
        for (int i = 0; i < vSourceInputArray.length; i++) {
                this._sourceInputList.add(vSourceInputArray[i]);
        }
    }

    /**
     * Sets the value of field 'val'.
     * 
     * @param val the value of field 'val'.
     */
    public void setVal(
            final java.lang.String val) {
        this._val = val;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.CardMode
     */
    public static bean.CardMode unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.CardMode) Unmarshaller.unmarshal(bean.CardMode.class, reader);
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
