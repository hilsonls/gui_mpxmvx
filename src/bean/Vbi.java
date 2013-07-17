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
 * Class Vbi.
 * 
 * @version $Revision$ $Date$
 */
public class Vbi implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ccIndicator.
     */
    private bean.CcIndicator _ccIndicator;

    /**
     * Field _ccVisible.
     */
    private bean.CcVisible _ccVisible;

    /**
     * Field _ccType.
     */
    private bean.CcType _ccType;

    /**
     * Field _xdsVisible.
     */
    private bean.XdsVisible _xdsVisible;

    /**
     * Field _ttIndicator.
     */
    private bean.TtIndicator _ttIndicator;

    /**
     * Field _ttVisible.
     */
    private bean.TtVisible _ttVisible;

    /**
     * Field _ttPage.
     */
    private bean.TtPage _ttPage;

    /**
     * Field _vitcVisible.
     */
    private bean.VitcVisible _vitcVisible;


      //----------------/
     //- Constructors -/
    //----------------/

    public Vbi() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'ccIndicator'.
     * 
     * @return the value of field 'CcIndicator'.
     */
    public bean.CcIndicator getCcIndicator(
    ) {
        return this._ccIndicator;
    }

    /**
     * Returns the value of field 'ccType'.
     * 
     * @return the value of field 'CcType'.
     */
    public bean.CcType getCcType(
    ) {
        return this._ccType;
    }

    /**
     * Returns the value of field 'ccVisible'.
     * 
     * @return the value of field 'CcVisible'.
     */
    public bean.CcVisible getCcVisible(
    ) {
        return this._ccVisible;
    }

    /**
     * Returns the value of field 'ttIndicator'.
     * 
     * @return the value of field 'TtIndicator'.
     */
    public bean.TtIndicator getTtIndicator(
    ) {
        return this._ttIndicator;
    }

    /**
     * Returns the value of field 'ttPage'.
     * 
     * @return the value of field 'TtPage'.
     */
    public bean.TtPage getTtPage(
    ) {
        return this._ttPage;
    }

    /**
     * Returns the value of field 'ttVisible'.
     * 
     * @return the value of field 'TtVisible'.
     */
    public bean.TtVisible getTtVisible(
    ) {
        return this._ttVisible;
    }

    /**
     * Returns the value of field 'vitcVisible'.
     * 
     * @return the value of field 'VitcVisible'.
     */
    public bean.VitcVisible getVitcVisible(
    ) {
        return this._vitcVisible;
    }

    /**
     * Returns the value of field 'xdsVisible'.
     * 
     * @return the value of field 'XdsVisible'.
     */
    public bean.XdsVisible getXdsVisible(
    ) {
        return this._xdsVisible;
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
     * Sets the value of field 'ccIndicator'.
     * 
     * @param ccIndicator the value of field 'ccIndicator'.
     */
    public void setCcIndicator(
            final bean.CcIndicator ccIndicator) {
        this._ccIndicator = ccIndicator;
    }

    /**
     * Sets the value of field 'ccType'.
     * 
     * @param ccType the value of field 'ccType'.
     */
    public void setCcType(
            final bean.CcType ccType) {
        this._ccType = ccType;
    }

    /**
     * Sets the value of field 'ccVisible'.
     * 
     * @param ccVisible the value of field 'ccVisible'.
     */
    public void setCcVisible(
            final bean.CcVisible ccVisible) {
        this._ccVisible = ccVisible;
    }

    /**
     * Sets the value of field 'ttIndicator'.
     * 
     * @param ttIndicator the value of field 'ttIndicator'.
     */
    public void setTtIndicator(
            final bean.TtIndicator ttIndicator) {
        this._ttIndicator = ttIndicator;
    }

    /**
     * Sets the value of field 'ttPage'.
     * 
     * @param ttPage the value of field 'ttPage'.
     */
    public void setTtPage(
            final bean.TtPage ttPage) {
        this._ttPage = ttPage;
    }

    /**
     * Sets the value of field 'ttVisible'.
     * 
     * @param ttVisible the value of field 'ttVisible'.
     */
    public void setTtVisible(
            final bean.TtVisible ttVisible) {
        this._ttVisible = ttVisible;
    }

    /**
     * Sets the value of field 'vitcVisible'.
     * 
     * @param vitcVisible the value of field 'vitcVisible'.
     */
    public void setVitcVisible(
            final bean.VitcVisible vitcVisible) {
        this._vitcVisible = vitcVisible;
    }

    /**
     * Sets the value of field 'xdsVisible'.
     * 
     * @param xdsVisible the value of field 'xdsVisible'.
     */
    public void setXdsVisible(
            final bean.XdsVisible xdsVisible) {
        this._xdsVisible = xdsVisible;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Vbi
     */
    public static bean.Vbi unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Vbi) Unmarshaller.unmarshal(bean.Vbi.class, reader);
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
