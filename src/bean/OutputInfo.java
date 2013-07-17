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
 * Class OutputInfo.
 * 
 * @version $Revision$ $Date$
 */
public class OutputInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _numOutputs.
     */
    private bean.NumOutputs _numOutputs;

    /**
     * Field _group.
     */
    private bean.Group _group;

    /**
     * Field _optionTables.
     */
    private bean.OptionTables _optionTables;


      //----------------/
     //- Constructors -/
    //----------------/

    public OutputInfo() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'group'.
     * 
     * @return the value of field 'Group'.
     */
    public bean.Group getGroup(
    ) {
        return this._group;
    }

    /**
     * Returns the value of field 'numOutputs'.
     * 
     * @return the value of field 'NumOutputs'.
     */
    public bean.NumOutputs getNumOutputs(
    ) {
        return this._numOutputs;
    }

    /**
     * Returns the value of field 'optionTables'.
     * 
     * @return the value of field 'OptionTables'.
     */
    public bean.OptionTables getOptionTables(
    ) {
        return this._optionTables;
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
     * Sets the value of field 'group'.
     * 
     * @param group the value of field 'group'.
     */
    public void setGroup(
            final bean.Group group) {
        this._group = group;
    }

    /**
     * Sets the value of field 'numOutputs'.
     * 
     * @param numOutputs the value of field 'numOutputs'.
     */
    public void setNumOutputs(
            final bean.NumOutputs numOutputs) {
        this._numOutputs = numOutputs;
    }

    /**
     * Sets the value of field 'optionTables'.
     * 
     * @param optionTables the value of field 'optionTables'.
     */
    public void setOptionTables(
            final bean.OptionTables optionTables) {
        this._optionTables = optionTables;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.OutputInfo
     */
    public static bean.OutputInfo unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.OutputInfo) Unmarshaller.unmarshal(bean.OutputInfo.class, reader);
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
