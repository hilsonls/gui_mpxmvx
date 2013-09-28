/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.2</a>, using an XML
 * Schema.
 * $Id$
 */

package bean;

/**
 * Class SnellMatrixTableType.
 * 
 * @version $Revision$ $Date$
 */
public abstract class SnellMatrixTableType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _snellMatrixPhysMapInfo.
     */
    private bean.SnellMatrixPhysMapInfo _snellMatrixPhysMapInfo;

    /**
     * Field _snellMatrixPhysIns.
     */
    private bean.SnellMatrixPhysIns _snellMatrixPhysIns;


      //----------------/
     //- Constructors -/
    //----------------/

    public SnellMatrixTableType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'snellMatrixPhysIns'.
     * 
     * @return the value of field 'SnellMatrixPhysIns'.
     */
    public bean.SnellMatrixPhysIns getSnellMatrixPhysIns(
    ) {
        return this._snellMatrixPhysIns;
    }

    /**
     * Returns the value of field 'snellMatrixPhysMapInfo'.
     * 
     * @return the value of field 'SnellMatrixPhysMapInfo'.
     */
    public bean.SnellMatrixPhysMapInfo getSnellMatrixPhysMapInfo(
    ) {
        return this._snellMatrixPhysMapInfo;
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
     * Sets the value of field 'snellMatrixPhysIns'.
     * 
     * @param snellMatrixPhysIns the value of field
     * 'snellMatrixPhysIns'.
     */
    public void setSnellMatrixPhysIns(
            final bean.SnellMatrixPhysIns snellMatrixPhysIns) {
        this._snellMatrixPhysIns = snellMatrixPhysIns;
    }

    /**
     * Sets the value of field 'snellMatrixPhysMapInfo'.
     * 
     * @param snellMatrixPhysMapInfo the value of field
     * 'snellMatrixPhysMapInfo'.
     */
    public void setSnellMatrixPhysMapInfo(
            final bean.SnellMatrixPhysMapInfo snellMatrixPhysMapInfo) {
        this._snellMatrixPhysMapInfo = snellMatrixPhysMapInfo;
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
