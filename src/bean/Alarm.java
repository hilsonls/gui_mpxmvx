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
 * Class Alarm.
 * 
 * @version $Revision$ $Date$
 */
public class Alarm implements java.io.Serializable {


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
     * Field _title.
     */
    private bean.Title _title;

    /**
     * Field _enabled.
     */
    private bean.Enabled _enabled;

    /**
     * Field _delay.
     */
    private bean.Delay _delay;

    /**
     * Field _autoReset.
     */
    private bean.AutoReset _autoReset;

    /**
     * Field _autoResetDelay.
     */
    private bean.AutoResetDelay _autoResetDelay;

    /**
     * Field _logging.
     */
    private bean.Logging _logging;

    /**
     * Field _showInObjects.
     */
    private bean.ShowInObjects _showInObjects;

    /**
     * Field _showInList.
     */
    private bean.ShowInList _showInList;

    /**
     * Field _snmp.
     */
    private bean.Snmp _snmp;

    /**
     * Field _useInterval.
     */
    private bean.UseInterval _useInterval;

    /**
     * Field _intervalName.
     */
    private bean.IntervalName _intervalName;


      //----------------/
     //- Constructors -/
    //----------------/

    public Alarm() {
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
     * Returns the value of field 'autoReset'.
     * 
     * @return the value of field 'AutoReset'.
     */
    public bean.AutoReset getAutoReset(
    ) {
        return this._autoReset;
    }

    /**
     * Returns the value of field 'autoResetDelay'.
     * 
     * @return the value of field 'AutoResetDelay'.
     */
    public bean.AutoResetDelay getAutoResetDelay(
    ) {
        return this._autoResetDelay;
    }

    /**
     * Returns the value of field 'delay'.
     * 
     * @return the value of field 'Delay'.
     */
    public bean.Delay getDelay(
    ) {
        return this._delay;
    }

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
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'Id'.
     */
    public int getId(
    ) {
        return this._id;
    }

    /**
     * Returns the value of field 'intervalName'.
     * 
     * @return the value of field 'IntervalName'.
     */
    public bean.IntervalName getIntervalName(
    ) {
        return this._intervalName;
    }

    /**
     * Returns the value of field 'logging'.
     * 
     * @return the value of field 'Logging'.
     */
    public bean.Logging getLogging(
    ) {
        return this._logging;
    }

    /**
     * Returns the value of field 'showInList'.
     * 
     * @return the value of field 'ShowInList'.
     */
    public bean.ShowInList getShowInList(
    ) {
        return this._showInList;
    }

    /**
     * Returns the value of field 'showInObjects'.
     * 
     * @return the value of field 'ShowInObjects'.
     */
    public bean.ShowInObjects getShowInObjects(
    ) {
        return this._showInObjects;
    }

    /**
     * Returns the value of field 'snmp'.
     * 
     * @return the value of field 'Snmp'.
     */
    public bean.Snmp getSnmp(
    ) {
        return this._snmp;
    }

    /**
     * Returns the value of field 'title'.
     * 
     * @return the value of field 'Title'.
     */
    public bean.Title getTitle(
    ) {
        return this._title;
    }

    /**
     * Returns the value of field 'useInterval'.
     * 
     * @return the value of field 'UseInterval'.
     */
    public bean.UseInterval getUseInterval(
    ) {
        return this._useInterval;
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
     * Sets the value of field 'autoReset'.
     * 
     * @param autoReset the value of field 'autoReset'.
     */
    public void setAutoReset(
            final bean.AutoReset autoReset) {
        this._autoReset = autoReset;
    }

    /**
     * Sets the value of field 'autoResetDelay'.
     * 
     * @param autoResetDelay the value of field 'autoResetDelay'.
     */
    public void setAutoResetDelay(
            final bean.AutoResetDelay autoResetDelay) {
        this._autoResetDelay = autoResetDelay;
    }

    /**
     * Sets the value of field 'delay'.
     * 
     * @param delay the value of field 'delay'.
     */
    public void setDelay(
            final bean.Delay delay) {
        this._delay = delay;
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
     * Sets the value of field 'intervalName'.
     * 
     * @param intervalName the value of field 'intervalName'.
     */
    public void setIntervalName(
            final bean.IntervalName intervalName) {
        this._intervalName = intervalName;
    }

    /**
     * Sets the value of field 'logging'.
     * 
     * @param logging the value of field 'logging'.
     */
    public void setLogging(
            final bean.Logging logging) {
        this._logging = logging;
    }

    /**
     * Sets the value of field 'showInList'.
     * 
     * @param showInList the value of field 'showInList'.
     */
    public void setShowInList(
            final bean.ShowInList showInList) {
        this._showInList = showInList;
    }

    /**
     * Sets the value of field 'showInObjects'.
     * 
     * @param showInObjects the value of field 'showInObjects'.
     */
    public void setShowInObjects(
            final bean.ShowInObjects showInObjects) {
        this._showInObjects = showInObjects;
    }

    /**
     * Sets the value of field 'snmp'.
     * 
     * @param snmp the value of field 'snmp'.
     */
    public void setSnmp(
            final bean.Snmp snmp) {
        this._snmp = snmp;
    }

    /**
     * Sets the value of field 'title'.
     * 
     * @param title the value of field 'title'.
     */
    public void setTitle(
            final bean.Title title) {
        this._title = title;
    }

    /**
     * Sets the value of field 'useInterval'.
     * 
     * @param useInterval the value of field 'useInterval'.
     */
    public void setUseInterval(
            final bean.UseInterval useInterval) {
        this._useInterval = useInterval;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Alarm
     */
    public static bean.Alarm unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Alarm) Unmarshaller.unmarshal(bean.Alarm.class, reader);
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
