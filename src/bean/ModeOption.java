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
 * Class ModeOption.
 * 
 * @version $Revision$ $Date$
 */
public class ModeOption implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _val.
     */
    private java.lang.String _val;

    /**
     * Field _sourceInputOptionsList.
     */
    private java.util.List _sourceInputOptionsList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ModeOption() {
        super();
        this._sourceInputOptionsList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSourceInputOptions
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSourceInputOptions(
            final bean.SourceInputOptions vSourceInputOptions)
    throws java.lang.IndexOutOfBoundsException {
        this._sourceInputOptionsList.add(vSourceInputOptions);
    }

    /**
     * 
     * 
     * @param index
     * @param vSourceInputOptions
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSourceInputOptions(
            final int index,
            final bean.SourceInputOptions vSourceInputOptions)
    throws java.lang.IndexOutOfBoundsException {
        this._sourceInputOptionsList.add(index, vSourceInputOptions);
    }

    /**
     * Method enumerateSourceInputOptions.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateSourceInputOptions(
    ) {
        return java.util.Collections.enumeration(this._sourceInputOptionsList);
    }

    /**
     * Method getSourceInputOptions.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.SourceInputOptions at the
     * given index
     */
    public bean.SourceInputOptions getSourceInputOptions(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._sourceInputOptionsList.size()) {
            throw new IndexOutOfBoundsException("getSourceInputOptions: Index value '" + index + "' not in range [0.." + (this._sourceInputOptionsList.size() - 1) + "]");
        }
        
        return (bean.SourceInputOptions) _sourceInputOptionsList.get(index);
    }

    /**
     * Method getSourceInputOptions.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.SourceInputOptions[] getSourceInputOptions(
    ) {
        bean.SourceInputOptions[] array = new bean.SourceInputOptions[0];
        return (bean.SourceInputOptions[]) this._sourceInputOptionsList.toArray(array);
    }

    /**
     * Method getSourceInputOptionsCount.
     * 
     * @return the size of this collection
     */
    public int getSourceInputOptionsCount(
    ) {
        return this._sourceInputOptionsList.size();
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
     * Method iterateSourceInputOptions.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateSourceInputOptions(
    ) {
        return this._sourceInputOptionsList.iterator();
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
    public void removeAllSourceInputOptions(
    ) {
        this._sourceInputOptionsList.clear();
    }

    /**
     * Method removeSourceInputOptions.
     * 
     * @param vSourceInputOptions
     * @return true if the object was removed from the collection.
     */
    public boolean removeSourceInputOptions(
            final bean.SourceInputOptions vSourceInputOptions) {
        boolean removed = _sourceInputOptionsList.remove(vSourceInputOptions);
        return removed;
    }

    /**
     * Method removeSourceInputOptionsAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.SourceInputOptions removeSourceInputOptionsAt(
            final int index) {
        java.lang.Object obj = this._sourceInputOptionsList.remove(index);
        return (bean.SourceInputOptions) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vSourceInputOptions
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSourceInputOptions(
            final int index,
            final bean.SourceInputOptions vSourceInputOptions)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._sourceInputOptionsList.size()) {
            throw new IndexOutOfBoundsException("setSourceInputOptions: Index value '" + index + "' not in range [0.." + (this._sourceInputOptionsList.size() - 1) + "]");
        }
        
        this._sourceInputOptionsList.set(index, vSourceInputOptions);
    }

    /**
     * 
     * 
     * @param vSourceInputOptionsArray
     */
    public void setSourceInputOptions(
            final bean.SourceInputOptions[] vSourceInputOptionsArray) {
        //-- copy array
        _sourceInputOptionsList.clear();
        
        for (int i = 0; i < vSourceInputOptionsArray.length; i++) {
                this._sourceInputOptionsList.add(vSourceInputOptionsArray[i]);
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
     * @return the unmarshaled bean.ModeOption
     */
    public static bean.ModeOption unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.ModeOption) Unmarshaller.unmarshal(bean.ModeOption.class, reader);
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
