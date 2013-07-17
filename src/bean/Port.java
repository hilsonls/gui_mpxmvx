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
 * Class Port.
 * 
 * @version $Revision$ $Date$
 */
public class Port implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id.
     */
    private int _id;

    /**
     * keeps track of state for field: _id
     */
    private boolean _has_id;

    /**
     * Field _baud.
     */
    private bean.Baud _baud;

    /**
     * Field _bits.
     */
    private bean.Bits _bits;

    /**
     * Field _parity.
     */
    private bean.Parity _parity;

    /**
     * Field _stop.
     */
    private bean.Stop _stop;

    /**
     * Field _flow.
     */
    private bean.Flow _flow;

    /**
     * Field _protocol.
     */
    private bean.Protocol _protocol;


      //----------------/
     //- Constructors -/
    //----------------/

    public Port() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteId(
    ) {
        this._has_id= false;
    }

    /**
     * Returns the value of field 'baud'.
     * 
     * @return the value of field 'Baud'.
     */
    public bean.Baud getBaud(
    ) {
        return this._baud;
    }

    /**
     * Returns the value of field 'bits'.
     * 
     * @return the value of field 'Bits'.
     */
    public bean.Bits getBits(
    ) {
        return this._bits;
    }

    /**
     * Returns the value of field 'flow'.
     * 
     * @return the value of field 'Flow'.
     */
    public bean.Flow getFlow(
    ) {
        return this._flow;
    }

    /**
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'Id'.
     */
    public int getId(
    ) {
        return this._id;
    }

    /**
     * Returns the value of field 'parity'.
     * 
     * @return the value of field 'Parity'.
     */
    public bean.Parity getParity(
    ) {
        return this._parity;
    }

    /**
     * Returns the value of field 'protocol'.
     * 
     * @return the value of field 'Protocol'.
     */
    public bean.Protocol getProtocol(
    ) {
        return this._protocol;
    }

    /**
     * Returns the value of field 'stop'.
     * 
     * @return the value of field 'Stop'.
     */
    public bean.Stop getStop(
    ) {
        return this._stop;
    }

    /**
     * Method hasId.
     * 
     * @return true if at least one Id has been added
     */
    public boolean hasId(
    ) {
        return this._has_id;
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
     * Sets the value of field 'baud'.
     * 
     * @param baud the value of field 'baud'.
     */
    public void setBaud(
            final bean.Baud baud) {
        this._baud = baud;
    }

    /**
     * Sets the value of field 'bits'.
     * 
     * @param bits the value of field 'bits'.
     */
    public void setBits(
            final bean.Bits bits) {
        this._bits = bits;
    }

    /**
     * Sets the value of field 'flow'.
     * 
     * @param flow the value of field 'flow'.
     */
    public void setFlow(
            final bean.Flow flow) {
        this._flow = flow;
    }

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(
            final int id) {
        this._id = id;
        this._has_id = true;
    }

    /**
     * Sets the value of field 'parity'.
     * 
     * @param parity the value of field 'parity'.
     */
    public void setParity(
            final bean.Parity parity) {
        this._parity = parity;
    }

    /**
     * Sets the value of field 'protocol'.
     * 
     * @param protocol the value of field 'protocol'.
     */
    public void setProtocol(
            final bean.Protocol protocol) {
        this._protocol = protocol;
    }

    /**
     * Sets the value of field 'stop'.
     * 
     * @param stop the value of field 'stop'.
     */
    public void setStop(
            final bean.Stop stop) {
        this._stop = stop;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Port
     */
    public static bean.Port unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Port) Unmarshaller.unmarshal(bean.Port.class, reader);
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
