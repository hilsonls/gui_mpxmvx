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
 * Class CurrTime.
 * 
 * @version $Revision$ $Date$
 */
public class CurrTime implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _hour.
     */
    private int _hour;

    /**
     * keeps track of state for field: _hour
     */
    private boolean _has_hour;

    /**
     * Field _minute.
     */
    private int _minute;

    /**
     * keeps track of state for field: _minute
     */
    private boolean _has_minute;

    /**
     * Field _second.
     */
    private int _second;

    /**
     * keeps track of state for field: _second
     */
    private boolean _has_second;

    /**
     * Field _day.
     */
    private int _day;

    /**
     * keeps track of state for field: _day
     */
    private boolean _has_day;

    /**
     * Field _month.
     */
    private int _month;

    /**
     * keeps track of state for field: _month
     */
    private boolean _has_month;

    /**
     * Field _year.
     */
    private int _year;

    /**
     * keeps track of state for field: _year
     */
    private boolean _has_year;


      //----------------/
     //- Constructors -/
    //----------------/

    public CurrTime() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDay(
    ) {
        this._has_day= false;
    }

    /**
     */
    public void deleteHour(
    ) {
        this._has_hour= false;
    }

    /**
     */
    public void deleteMinute(
    ) {
        this._has_minute= false;
    }

    /**
     */
    public void deleteMonth(
    ) {
        this._has_month= false;
    }

    /**
     */
    public void deleteSecond(
    ) {
        this._has_second= false;
    }

    /**
     */
    public void deleteYear(
    ) {
        this._has_year= false;
    }

    /**
     * Returns the value of field 'day'.
     * 
     * @return the value of field 'Day'.
     */
    public int getDay(
    ) {
        return this._day;
    }

    /**
     * Returns the value of field 'hour'.
     * 
     * @return the value of field 'Hour'.
     */
    public int getHour(
    ) {
        return this._hour;
    }

    /**
     * Returns the value of field 'minute'.
     * 
     * @return the value of field 'Minute'.
     */
    public int getMinute(
    ) {
        return this._minute;
    }

    /**
     * Returns the value of field 'month'.
     * 
     * @return the value of field 'Month'.
     */
    public int getMonth(
    ) {
        return this._month;
    }

    /**
     * Returns the value of field 'second'.
     * 
     * @return the value of field 'Second'.
     */
    public int getSecond(
    ) {
        return this._second;
    }

    /**
     * Returns the value of field 'year'.
     * 
     * @return the value of field 'Year'.
     */
    public int getYear(
    ) {
        return this._year;
    }

    /**
     * Method hasDay.
     * 
     * @return true if at least one Day has been added
     */
    public boolean hasDay(
    ) {
        return this._has_day;
    }

    /**
     * Method hasHour.
     * 
     * @return true if at least one Hour has been added
     */
    public boolean hasHour(
    ) {
        return this._has_hour;
    }

    /**
     * Method hasMinute.
     * 
     * @return true if at least one Minute has been added
     */
    public boolean hasMinute(
    ) {
        return this._has_minute;
    }

    /**
     * Method hasMonth.
     * 
     * @return true if at least one Month has been added
     */
    public boolean hasMonth(
    ) {
        return this._has_month;
    }

    /**
     * Method hasSecond.
     * 
     * @return true if at least one Second has been added
     */
    public boolean hasSecond(
    ) {
        return this._has_second;
    }

    /**
     * Method hasYear.
     * 
     * @return true if at least one Year has been added
     */
    public boolean hasYear(
    ) {
        return this._has_year;
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
     * Sets the value of field 'day'.
     * 
     * @param day the value of field 'day'.
     */
    public void setDay(
            final int day) {
        this._day = day;
        this._has_day = true;
    }

    /**
     * Sets the value of field 'hour'.
     * 
     * @param hour the value of field 'hour'.
     */
    public void setHour(
            final int hour) {
        this._hour = hour;
        this._has_hour = true;
    }

    /**
     * Sets the value of field 'minute'.
     * 
     * @param minute the value of field 'minute'.
     */
    public void setMinute(
            final int minute) {
        this._minute = minute;
        this._has_minute = true;
    }

    /**
     * Sets the value of field 'month'.
     * 
     * @param month the value of field 'month'.
     */
    public void setMonth(
            final int month) {
        this._month = month;
        this._has_month = true;
    }

    /**
     * Sets the value of field 'second'.
     * 
     * @param second the value of field 'second'.
     */
    public void setSecond(
            final int second) {
        this._second = second;
        this._has_second = true;
    }

    /**
     * Sets the value of field 'year'.
     * 
     * @param year the value of field 'year'.
     */
    public void setYear(
            final int year) {
        this._year = year;
        this._has_year = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.CurrTime
     */
    public static bean.CurrTime unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.CurrTime) Unmarshaller.unmarshal(bean.CurrTime.class, reader);
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
