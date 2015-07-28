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
 * Class Screen.
 * 
 * @version $Revision$ $Date$
 */
public class Screen implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _numScreens.
     */
    private bean.NumScreens _numScreens;

    /**
     * Field _resolution.
     */
    private bean.Resolution _resolution;

    /**
     * Field _moduleScreenAspectRatio.
     */
    private bean.ModuleScreenAspectRatio _moduleScreenAspectRatio;

    /**
     * Field _genlock.
     */
    private bean.Genlock _genlock;

    /**
     * Field _hdcp.
     */
    private bean.Hdcp _hdcp;


      //----------------/
     //- Constructors -/
    //----------------/

    public Screen() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'genlock'.
     * 
     * @return the value of field 'Genlock'.
     */
    public bean.Genlock getGenlock(
    ) {
        return this._genlock;
    }

    /**
     * Returns the value of field 'hdcp'.
     * 
     * @return the value of field 'Hdcp'.
     */
    public bean.Hdcp getHdcp(
    ) {
        return this._hdcp;
    }

    /**
     * Returns the value of field 'moduleScreenAspectRatio'.
     * 
     * @return the value of field 'ModuleScreenAspectRatio'.
     */
    public bean.ModuleScreenAspectRatio getModuleScreenAspectRatio(
    ) {
        return this._moduleScreenAspectRatio;
    }

    /**
     * Returns the value of field 'numScreens'.
     * 
     * @return the value of field 'NumScreens'.
     */
    public bean.NumScreens getNumScreens(
    ) {
        return this._numScreens;
    }

    /**
     * Returns the value of field 'resolution'.
     * 
     * @return the value of field 'Resolution'.
     */
    public bean.Resolution getResolution(
    ) {
        return this._resolution;
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
     * Sets the value of field 'genlock'.
     * 
     * @param genlock the value of field 'genlock'.
     */
    public void setGenlock(
            final bean.Genlock genlock) {
        this._genlock = genlock;
    }

    /**
     * Sets the value of field 'hdcp'.
     * 
     * @param hdcp the value of field 'hdcp'.
     */
    public void setHdcp(
            final bean.Hdcp hdcp) {
        this._hdcp = hdcp;
    }

    /**
     * Sets the value of field 'moduleScreenAspectRatio'.
     * 
     * @param moduleScreenAspectRatio the value of field
     * 'moduleScreenAspectRatio'.
     */
    public void setModuleScreenAspectRatio(
            final bean.ModuleScreenAspectRatio moduleScreenAspectRatio) {
        this._moduleScreenAspectRatio = moduleScreenAspectRatio;
    }

    /**
     * Sets the value of field 'numScreens'.
     * 
     * @param numScreens the value of field 'numScreens'.
     */
    public void setNumScreens(
            final bean.NumScreens numScreens) {
        this._numScreens = numScreens;
    }

    /**
     * Sets the value of field 'resolution'.
     * 
     * @param resolution the value of field 'resolution'.
     */
    public void setResolution(
            final bean.Resolution resolution) {
        this._resolution = resolution;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Screen
     */
    public static bean.Screen unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Screen) Unmarshaller.unmarshal(bean.Screen.class, reader);
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
