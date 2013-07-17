/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.2</a>, using an XML
 * Schema.
 * $Id$
 */

package bean;

/**
 * Class ObjectStringProperty.
 * 
 * @version $Revision$ $Date$
 */
public abstract class ObjectStringProperty implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _val.
     */
    private java.lang.String _val;


      //----------------/
     //- Constructors -/
    //----------------/

    public ObjectStringProperty() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

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
     * Sets the value of field 'val'.
     * 
     * @param val the value of field 'val'.
     */
    public void setVal(
            final java.lang.String val) {
        this._val = val;
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
