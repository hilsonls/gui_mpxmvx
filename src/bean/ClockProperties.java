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
 * Class ClockProperties.
 * 
 * @version $Revision$ $Date$
 */
public class ClockProperties implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _digital.
     */
    private bean.Digital _digital;

    /**
     * Field _hour24time.
     */
    private bean.Hour24time _hour24time;

    /**
     * Field _timezoneEnabled.
     */
    private bean.TimezoneEnabled _timezoneEnabled;

    /**
     * Field _timezone.
     */
    private bean.Timezone _timezone;

    /**
     * Field _offset.
     */
    private bean.Offset _offset;

    /**
     * Field _colour.
     */
    private bean.Colour _colour;

    /**
     * Field _missingSourceColour.
     */
    private bean.MissingSourceColour _missingSourceColour;

    /**
     * Field _bkcolour.
     */
    private bean.Bkcolour _bkcolour;

    /**
     * Field _displayDate.
     */
    private bean.DisplayDate _displayDate;

    /**
     * Field _dateFormat.
     */
    private bean.DateFormat _dateFormat;


      //----------------/
     //- Constructors -/
    //----------------/

    public ClockProperties() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'bkcolour'.
     * 
     * @return the value of field 'Bkcolour'.
     */
    public bean.Bkcolour getBkcolour(
    ) {
        return this._bkcolour;
    }

    /**
     * Returns the value of field 'colour'.
     * 
     * @return the value of field 'Colour'.
     */
    public bean.Colour getColour(
    ) {
        return this._colour;
    }

    /**
     * Returns the value of field 'dateFormat'.
     * 
     * @return the value of field 'DateFormat'.
     */
    public bean.DateFormat getDateFormat(
    ) {
        return this._dateFormat;
    }

    /**
     * Returns the value of field 'digital'.
     * 
     * @return the value of field 'Digital'.
     */
    public bean.Digital getDigital(
    ) {
        return this._digital;
    }

    /**
     * Returns the value of field 'displayDate'.
     * 
     * @return the value of field 'DisplayDate'.
     */
    public bean.DisplayDate getDisplayDate(
    ) {
        return this._displayDate;
    }

    /**
     * Returns the value of field 'hour24time'.
     * 
     * @return the value of field 'Hour24time'.
     */
    public bean.Hour24time getHour24time(
    ) {
        return this._hour24time;
    }

    /**
     * Returns the value of field 'missingSourceColour'.
     * 
     * @return the value of field 'MissingSourceColour'.
     */
    public bean.MissingSourceColour getMissingSourceColour(
    ) {
        return this._missingSourceColour;
    }

    /**
     * Returns the value of field 'offset'.
     * 
     * @return the value of field 'Offset'.
     */
    public bean.Offset getOffset(
    ) {
        return this._offset;
    }

    /**
     * Returns the value of field 'timezone'.
     * 
     * @return the value of field 'Timezone'.
     */
    public bean.Timezone getTimezone(
    ) {
        return this._timezone;
    }

    /**
     * Returns the value of field 'timezoneEnabled'.
     * 
     * @return the value of field 'TimezoneEnabled'.
     */
    public bean.TimezoneEnabled getTimezoneEnabled(
    ) {
        return this._timezoneEnabled;
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
     * Sets the value of field 'bkcolour'.
     * 
     * @param bkcolour the value of field 'bkcolour'.
     */
    public void setBkcolour(
            final bean.Bkcolour bkcolour) {
        this._bkcolour = bkcolour;
    }

    /**
     * Sets the value of field 'colour'.
     * 
     * @param colour the value of field 'colour'.
     */
    public void setColour(
            final bean.Colour colour) {
        this._colour = colour;
    }

    /**
     * Sets the value of field 'dateFormat'.
     * 
     * @param dateFormat the value of field 'dateFormat'.
     */
    public void setDateFormat(
            final bean.DateFormat dateFormat) {
        this._dateFormat = dateFormat;
    }

    /**
     * Sets the value of field 'digital'.
     * 
     * @param digital the value of field 'digital'.
     */
    public void setDigital(
            final bean.Digital digital) {
        this._digital = digital;
    }

    /**
     * Sets the value of field 'displayDate'.
     * 
     * @param displayDate the value of field 'displayDate'.
     */
    public void setDisplayDate(
            final bean.DisplayDate displayDate) {
        this._displayDate = displayDate;
    }

    /**
     * Sets the value of field 'hour24time'.
     * 
     * @param hour24time the value of field 'hour24time'.
     */
    public void setHour24time(
            final bean.Hour24time hour24time) {
        this._hour24time = hour24time;
    }

    /**
     * Sets the value of field 'missingSourceColour'.
     * 
     * @param missingSourceColour the value of field
     * 'missingSourceColour'.
     */
    public void setMissingSourceColour(
            final bean.MissingSourceColour missingSourceColour) {
        this._missingSourceColour = missingSourceColour;
    }

    /**
     * Sets the value of field 'offset'.
     * 
     * @param offset the value of field 'offset'.
     */
    public void setOffset(
            final bean.Offset offset) {
        this._offset = offset;
    }

    /**
     * Sets the value of field 'timezone'.
     * 
     * @param timezone the value of field 'timezone'.
     */
    public void setTimezone(
            final bean.Timezone timezone) {
        this._timezone = timezone;
    }

    /**
     * Sets the value of field 'timezoneEnabled'.
     * 
     * @param timezoneEnabled the value of field 'timezoneEnabled'.
     */
    public void setTimezoneEnabled(
            final bean.TimezoneEnabled timezoneEnabled) {
        this._timezoneEnabled = timezoneEnabled;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.ClockProperties
     */
    public static bean.ClockProperties unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.ClockProperties) Unmarshaller.unmarshal(bean.ClockProperties.class, reader);
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
