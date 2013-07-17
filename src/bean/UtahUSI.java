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
 * Class UtahUSI.
 * 
 * @version $Revision$ $Date$
 */
public class UtahUSI implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _tcpPort.
     */
    private bean.TcpPort _tcpPort;

    /**
     * Field _enabled.
     */
    private bean.Enabled _enabled;


      //----------------/
     //- Constructors -/
    //----------------/

    public UtahUSI() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'enabled'.
     * 
     * @return the value of field 'Enabled'.
     */
    public bean.Enabled getEnabled(
    ) {
        return this._enabled;
    }

    /**
     * Returns the value of field 'tcpPort'.
     * 
     * @return the value of field 'TcpPort'.
     */
    public bean.TcpPort getTcpPort(
    ) {
        return this._tcpPort;
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
     * Sets the value of field 'enabled'.
     * 
     * @param enabled the value of field 'enabled'.
     */
    public void setEnabled(
            final bean.Enabled enabled) {
        this._enabled = enabled;
    }

    /**
     * Sets the value of field 'tcpPort'.
     * 
     * @param tcpPort the value of field 'tcpPort'.
     */
    public void setTcpPort(
            final bean.TcpPort tcpPort) {
        this._tcpPort = tcpPort;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.UtahUSI
     */
    public static bean.UtahUSI unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.UtahUSI) Unmarshaller.unmarshal(bean.UtahUSI.class, reader);
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
