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
 * Class GpiOptionTables.
 * 
 * @version $Revision$ $Date$
 */
public class GpiOptionTables implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _gpiInName.
     */
    private java.lang.String _gpiInName;

    /**
     * Field _gpiInTask.
     */
    private java.lang.String _gpiInTask;

    /**
     * Field _gpiOutName.
     */
    private java.lang.String _gpiOutName;

    /**
     * Field _gpiOutTask.
     */
    private java.lang.String _gpiOutTask;


      //----------------/
     //- Constructors -/
    //----------------/

    public GpiOptionTables() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'gpiInName'.
     * 
     * @return the value of field 'GpiInName'.
     */
    public java.lang.String getGpiInName(
    ) {
        return this._gpiInName;
    }

    /**
     * Returns the value of field 'gpiInTask'.
     * 
     * @return the value of field 'GpiInTask'.
     */
    public java.lang.String getGpiInTask(
    ) {
        return this._gpiInTask;
    }

    /**
     * Returns the value of field 'gpiOutName'.
     * 
     * @return the value of field 'GpiOutName'.
     */
    public java.lang.String getGpiOutName(
    ) {
        return this._gpiOutName;
    }

    /**
     * Returns the value of field 'gpiOutTask'.
     * 
     * @return the value of field 'GpiOutTask'.
     */
    public java.lang.String getGpiOutTask(
    ) {
        return this._gpiOutTask;
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
     * Sets the value of field 'gpiInName'.
     * 
     * @param gpiInName the value of field 'gpiInName'.
     */
    public void setGpiInName(
            final java.lang.String gpiInName) {
        this._gpiInName = gpiInName;
    }

    /**
     * Sets the value of field 'gpiInTask'.
     * 
     * @param gpiInTask the value of field 'gpiInTask'.
     */
    public void setGpiInTask(
            final java.lang.String gpiInTask) {
        this._gpiInTask = gpiInTask;
    }

    /**
     * Sets the value of field 'gpiOutName'.
     * 
     * @param gpiOutName the value of field 'gpiOutName'.
     */
    public void setGpiOutName(
            final java.lang.String gpiOutName) {
        this._gpiOutName = gpiOutName;
    }

    /**
     * Sets the value of field 'gpiOutTask'.
     * 
     * @param gpiOutTask the value of field 'gpiOutTask'.
     */
    public void setGpiOutTask(
            final java.lang.String gpiOutTask) {
        this._gpiOutTask = gpiOutTask;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.GpiOptionTables
     */
    public static bean.GpiOptionTables unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.GpiOptionTables) Unmarshaller.unmarshal(bean.GpiOptionTables.class, reader);
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
