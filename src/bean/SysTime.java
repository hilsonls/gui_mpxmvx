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
 * Class SysTime.
 * 
 * @version $Revision$ $Date$
 */
public class SysTime implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _syncMode.
     */
    private bean.SyncMode _syncMode;

    /**
     * Field _currTime.
     */
    private bean.CurrTime _currTime;

    /**
     * Field _ntpServers.
     */
    private bean.NtpServers _ntpServers;

    /**
     * Field _vitcSource.
     */
    private bean.VitcSource _vitcSource;

    /**
     * Field _sysTimeTimezone.
     */
    private bean.SysTimeTimezone _sysTimeTimezone;


      //----------------/
     //- Constructors -/
    //----------------/

    public SysTime() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'currTime'.
     * 
     * @return the value of field 'CurrTime'.
     */
    public bean.CurrTime getCurrTime(
    ) {
        return this._currTime;
    }

    /**
     * Returns the value of field 'ntpServers'.
     * 
     * @return the value of field 'NtpServers'.
     */
    public bean.NtpServers getNtpServers(
    ) {
        return this._ntpServers;
    }

    /**
     * Returns the value of field 'syncMode'.
     * 
     * @return the value of field 'SyncMode'.
     */
    public bean.SyncMode getSyncMode(
    ) {
        return this._syncMode;
    }

    /**
     * Returns the value of field 'sysTimeTimezone'.
     * 
     * @return the value of field 'SysTimeTimezone'.
     */
    public bean.SysTimeTimezone getSysTimeTimezone(
    ) {
        return this._sysTimeTimezone;
    }

    /**
     * Returns the value of field 'vitcSource'.
     * 
     * @return the value of field 'VitcSource'.
     */
    public bean.VitcSource getVitcSource(
    ) {
        return this._vitcSource;
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
     * Sets the value of field 'currTime'.
     * 
     * @param currTime the value of field 'currTime'.
     */
    public void setCurrTime(
            final bean.CurrTime currTime) {
        this._currTime = currTime;
    }

    /**
     * Sets the value of field 'ntpServers'.
     * 
     * @param ntpServers the value of field 'ntpServers'.
     */
    public void setNtpServers(
            final bean.NtpServers ntpServers) {
        this._ntpServers = ntpServers;
    }

    /**
     * Sets the value of field 'syncMode'.
     * 
     * @param syncMode the value of field 'syncMode'.
     */
    public void setSyncMode(
            final bean.SyncMode syncMode) {
        this._syncMode = syncMode;
    }

    /**
     * Sets the value of field 'sysTimeTimezone'.
     * 
     * @param sysTimeTimezone the value of field 'sysTimeTimezone'.
     */
    public void setSysTimeTimezone(
            final bean.SysTimeTimezone sysTimeTimezone) {
        this._sysTimeTimezone = sysTimeTimezone;
    }

    /**
     * Sets the value of field 'vitcSource'.
     * 
     * @param vitcSource the value of field 'vitcSource'.
     */
    public void setVitcSource(
            final bean.VitcSource vitcSource) {
        this._vitcSource = vitcSource;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.SysTime
     */
    public static bean.SysTime unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.SysTime) Unmarshaller.unmarshal(bean.SysTime.class, reader);
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
