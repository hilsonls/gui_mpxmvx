/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.2</a>, using an XML
 * Schema.
 * $Id$
 */

package bean;

/**
 * Class ObjectIntProperty.
 * 
 * @version $Revision$ $Date$
 */
public abstract class ObjectIntProperty implements java.io.Serializable {


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


      //----------------/
     //- Constructors -/
    //----------------/

    public ObjectIntProperty() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteVal(
    ) {
        this._has_val= false;
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
