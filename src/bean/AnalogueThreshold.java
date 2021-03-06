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
 * Class AnalogueThreshold.
 * 
 * @version $Revision$ $Date$
 */
public class AnalogueThreshold implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _val.
     */
    private int _val;

    /**
     * keeps track of state for field: _val
     */
    private boolean _has_val;

    /**
     * Field _min.
     */
    private int _min;

    /**
     * keeps track of state for field: _min
     */
    private boolean _has_min;

    /**
     * Field _max.
     */
    private int _max;

    /**
     * keeps track of state for field: _max
     */
    private boolean _has_max;


      //----------------/
     //- Constructors -/
    //----------------/

    public AnalogueThreshold() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteMax(
    ) {
        this._has_max= false;
    }

    /**
     */
    public void deleteMin(
    ) {
        this._has_min= false;
    }

    /**
     */
    public void deleteVal(
    ) {
        this._has_val= false;
    }

    /**
     * Returns the value of field 'max'.
     * 
     * @return the value of field 'Max'.
     */
    public int getMax(
    ) {
        return this._max;
    }

    /**
     * Returns the value of field 'min'.
     * 
     * @return the value of field 'Min'.
     */
    public int getMin(
    ) {
        return this._min;
    }

    /**
     * Returns the value of field 'val'.
     * 
     * @return the value of field 'Val'.
     */
    public int getVal(
    ) {
        return this._val;
    }

    /**
     * Method hasMax.
     * 
     * @return true if at least one Max has been added
     */
    public boolean hasMax(
    ) {
        return this._has_max;
    }

    /**
     * Method hasMin.
     * 
     * @return true if at least one Min has been added
     */
    public boolean hasMin(
    ) {
        return this._has_min;
    }

    /**
     * Method hasVal.
     * 
     * @return true if at least one Val has been added
     */
    public boolean hasVal(
    ) {
        return this._has_val;
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
     * Sets the value of field 'max'.
     * 
     * @param max the value of field 'max'.
     */
    public void setMax(
            final int max) {
        this._max = max;
        this._has_max = true;
    }

    /**
     * Sets the value of field 'min'.
     * 
     * @param min the value of field 'min'.
     */
    public void setMin(
            final int min) {
        this._min = min;
        this._has_min = true;
    }

    /**
     * Sets the value of field 'val'.
     * 
     * @param val the value of field 'val'.
     */
    public void setVal(
            final int val) {
        this._val = val;
        this._has_val = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.AnalogueThreshold
     */
    public static bean.AnalogueThreshold unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.AnalogueThreshold) Unmarshaller.unmarshal(bean.AnalogueThreshold.class, reader);
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
