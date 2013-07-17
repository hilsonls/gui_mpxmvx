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
 * Class Protocols.
 * 
 * @version $Revision$ $Date$
 */
public class Protocols implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ports.
     */
    private bean.Ports _ports;

    /**
     * Field _utahUSI.
     */
    private bean.UtahUSI _utahUSI;

    /**
     * Field _sierraRouter.
     */
    private bean.SierraRouter _sierraRouter;

    /**
     * Field _snellRouter.
     */
    private bean.SnellRouter _snellRouter;


      //----------------/
     //- Constructors -/
    //----------------/

    public Protocols() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'ports'.
     * 
     * @return the value of field 'Ports'.
     */
    public bean.Ports getPorts(
    ) {
        return this._ports;
    }

    /**
     * Returns the value of field 'sierraRouter'.
     * 
     * @return the value of field 'SierraRouter'.
     */
    public bean.SierraRouter getSierraRouter(
    ) {
        return this._sierraRouter;
    }

    /**
     * Returns the value of field 'snellRouter'.
     * 
     * @return the value of field 'SnellRouter'.
     */
    public bean.SnellRouter getSnellRouter(
    ) {
        return this._snellRouter;
    }

    /**
     * Returns the value of field 'utahUSI'.
     * 
     * @return the value of field 'UtahUSI'.
     */
    public bean.UtahUSI getUtahUSI(
    ) {
        return this._utahUSI;
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
     * Sets the value of field 'ports'.
     * 
     * @param ports the value of field 'ports'.
     */
    public void setPorts(
            final bean.Ports ports) {
        this._ports = ports;
    }

    /**
     * Sets the value of field 'sierraRouter'.
     * 
     * @param sierraRouter the value of field 'sierraRouter'.
     */
    public void setSierraRouter(
            final bean.SierraRouter sierraRouter) {
        this._sierraRouter = sierraRouter;
    }

    /**
     * Sets the value of field 'snellRouter'.
     * 
     * @param snellRouter the value of field 'snellRouter'.
     */
    public void setSnellRouter(
            final bean.SnellRouter snellRouter) {
        this._snellRouter = snellRouter;
    }

    /**
     * Sets the value of field 'utahUSI'.
     * 
     * @param utahUSI the value of field 'utahUSI'.
     */
    public void setUtahUSI(
            final bean.UtahUSI utahUSI) {
        this._utahUSI = utahUSI;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Protocols
     */
    public static bean.Protocols unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Protocols) Unmarshaller.unmarshal(bean.Protocols.class, reader);
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
