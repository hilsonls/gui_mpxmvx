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
     * Field _outputInfo.
     */
    private bean.OutputInfo _outputInfo;

    /**
     * Field _outputList.
     */
    private java.util.List _outputList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AudioOut() {
        super();
        this._outputList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vOutput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOutput(
            final bean.Output vOutput)
    throws java.lang.IndexOutOfBoundsException {
        this._outputList.add(vOutput);
    }

    /**
     * 
     * 
     * @param index
     * @param vOutput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOutput(
            final int index,
            final bean.Output vOutput)
    throws java.lang.IndexOutOfBoundsException {
        this._outputList.add(index, vOutput);
    }

    /**
     * Method enumerateOutput.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateOutput(
    ) {
        return java.util.Collections.enumeration(this._outputList);
    }

    /**
     * Method getOutput.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Output at the given index
     */
    public bean.Output getOutput(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._outputList.size()) {
            throw new IndexOutOfBoundsException("getOutput: Index value '" + index + "' not in range [0.." + (this._outputList.size() - 1) + "]");
        }
        
        return (bean.Output) _outputList.get(index);
    }

    /**
     * Method getOutput.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Output[] getOutput(
    ) {
        bean.Output[] array = new bean.Output[0];
        return (bean.Output[]) this._outputList.toArray(array);
    }

    /**
     * Method getOutputCount.
     * 
     * @return the size of this collection
     */
    public int getOutputCount(
    ) {
        return this._outputList.size();
    }

    /**
     * Returns the value of field 'outputInfo'.
     * 
     * @return the value of field 'OutputInfo'.
     */
    public bean.OutputInfo getOutputInfo(
    ) {
        return this._outputInfo;
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
     * Method iterateOutput.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateOutput(
    ) {
        return this._outputList.iterator();
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
    public void removeAllOutput(
    ) {
        this._outputList.clear();
    }

    /**
     * Method removeOutput.
     * 
     * @param vOutput
     * @return true if the object was removed from the collection.
     */
    public boolean removeOutput(
            final bean.Output vOutput) {
        boolean removed = _outputList.remove(vOutput);
        return removed;
    }

    /**
     * Method removeOutputAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Output removeOutputAt(
            final int index) {
        java.lang.Object obj = this._outputList.remove(index);
        return (bean.Output) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vOutput
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setOutput(
            final int index,
            final bean.Output vOutput)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._outputList.size()) {
            throw new IndexOutOfBoundsException("setOutput: Index value '" + index + "' not in range [0.." + (this._outputList.size() - 1) + "]");
        }
        
        this._outputList.set(index, vOutput);
    }

    /**
     * 
     * 
     * @param vOutputArray
     */
    public void setOutput(
            final bean.Output[] vOutputArray) {
        //-- copy array
        _outputList.clear();
        
        for (int i = 0; i < vOutputArray.length; i++) {
                this._outputList.add(vOutputArray[i]);
        }
    }

    /**
     * Sets the value of field 'outputInfo'.
     * 
     * @param outputInfo the value of field 'outputInfo'.
     */
    public void setOutputInfo(
            final bean.OutputInfo outputInfo) {
        this._outputInfo = outputInfo;
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
