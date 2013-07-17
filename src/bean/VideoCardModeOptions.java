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
 * Class VideoCardModeOptions.
 * 
 * @version $Revision$ $Date$
 */
public class VideoCardModeOptions implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _modeOptionList.
     */
    private java.util.List _modeOptionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public VideoCardModeOptions() {
        super();
        this._modeOptionList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vModeOption
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addModeOption(
            final bean.ModeOption vModeOption)
    throws java.lang.IndexOutOfBoundsException {
        this._modeOptionList.add(vModeOption);
    }

    /**
     * 
     * 
     * @param index
     * @param vModeOption
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addModeOption(
            final int index,
            final bean.ModeOption vModeOption)
    throws java.lang.IndexOutOfBoundsException {
        this._modeOptionList.add(index, vModeOption);
    }

    /**
     * Method enumerateModeOption.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateModeOption(
    ) {
        return java.util.Collections.enumeration(this._modeOptionList);
    }

    /**
     * Method getModeOption.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.ModeOption at the given index
     */
    public bean.ModeOption getModeOption(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._modeOptionList.size()) {
            throw new IndexOutOfBoundsException("getModeOption: Index value '" + index + "' not in range [0.." + (this._modeOptionList.size() - 1) + "]");
        }
        
        return (bean.ModeOption) _modeOptionList.get(index);
    }

    /**
     * Method getModeOption.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.ModeOption[] getModeOption(
    ) {
        bean.ModeOption[] array = new bean.ModeOption[0];
        return (bean.ModeOption[]) this._modeOptionList.toArray(array);
    }

    /**
     * Method getModeOptionCount.
     * 
     * @return the size of this collection
     */
    public int getModeOptionCount(
    ) {
        return this._modeOptionList.size();
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
     * Method iterateModeOption.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateModeOption(
    ) {
        return this._modeOptionList.iterator();
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
    public void removeAllModeOption(
    ) {
        this._modeOptionList.clear();
    }

    /**
     * Method removeModeOption.
     * 
     * @param vModeOption
     * @return true if the object was removed from the collection.
     */
    public boolean removeModeOption(
            final bean.ModeOption vModeOption) {
        boolean removed = _modeOptionList.remove(vModeOption);
        return removed;
    }

    /**
     * Method removeModeOptionAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.ModeOption removeModeOptionAt(
            final int index) {
        java.lang.Object obj = this._modeOptionList.remove(index);
        return (bean.ModeOption) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vModeOption
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setModeOption(
            final int index,
            final bean.ModeOption vModeOption)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._modeOptionList.size()) {
            throw new IndexOutOfBoundsException("setModeOption: Index value '" + index + "' not in range [0.." + (this._modeOptionList.size() - 1) + "]");
        }
        
        this._modeOptionList.set(index, vModeOption);
    }

    /**
     * 
     * 
     * @param vModeOptionArray
     */
    public void setModeOption(
            final bean.ModeOption[] vModeOptionArray) {
        //-- copy array
        _modeOptionList.clear();
        
        for (int i = 0; i < vModeOptionArray.length; i++) {
                this._modeOptionList.add(vModeOptionArray[i]);
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
     * @return the unmarshaled bean.VideoCardModeOptions
     */
    public static bean.VideoCardModeOptions unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.VideoCardModeOptions) Unmarshaller.unmarshal(bean.VideoCardModeOptions.class, reader);
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
