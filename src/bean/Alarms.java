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
 * Class Alarms.
 * 
 * @version $Revision$ $Date$
 */
public class Alarms implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _alarmList.
     */
    private java.util.List _alarmList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Alarms() {
        super();
        this._alarmList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAlarm
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAlarm(
            final bean.Alarm vAlarm)
    throws java.lang.IndexOutOfBoundsException {
        this._alarmList.add(vAlarm);
    }

    /**
     * 
     * 
     * @param index
     * @param vAlarm
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAlarm(
            final int index,
            final bean.Alarm vAlarm)
    throws java.lang.IndexOutOfBoundsException {
        this._alarmList.add(index, vAlarm);
    }

    /**
     * Method enumerateAlarm.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateAlarm(
    ) {
        return java.util.Collections.enumeration(this._alarmList);
    }

    /**
     * Method getAlarm.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Alarm at the given index
     */
    public bean.Alarm getAlarm(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._alarmList.size()) {
            throw new IndexOutOfBoundsException("getAlarm: Index value '" + index + "' not in range [0.." + (this._alarmList.size() - 1) + "]");
        }
        
        return (bean.Alarm) _alarmList.get(index);
    }

    /**
     * Method getAlarm.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Alarm[] getAlarm(
    ) {
        bean.Alarm[] array = new bean.Alarm[0];
        return (bean.Alarm[]) this._alarmList.toArray(array);
    }

    /**
     * Method getAlarmCount.
     * 
     * @return the size of this collection
     */
    public int getAlarmCount(
    ) {
        return this._alarmList.size();
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
     * Method iterateAlarm.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateAlarm(
    ) {
        return this._alarmList.iterator();
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
     * Method removeAlarm.
     * 
     * @param vAlarm
     * @return true if the object was removed from the collection.
     */
    public boolean removeAlarm(
            final bean.Alarm vAlarm) {
        boolean removed = _alarmList.remove(vAlarm);
        return removed;
    }

    /**
     * Method removeAlarmAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Alarm removeAlarmAt(
            final int index) {
        java.lang.Object obj = this._alarmList.remove(index);
        return (bean.Alarm) obj;
    }

    /**
     */
    public void removeAllAlarm(
    ) {
        this._alarmList.clear();
    }

    /**
     * 
     * 
     * @param index
     * @param vAlarm
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAlarm(
            final int index,
            final bean.Alarm vAlarm)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._alarmList.size()) {
            throw new IndexOutOfBoundsException("setAlarm: Index value '" + index + "' not in range [0.." + (this._alarmList.size() - 1) + "]");
        }
        
        this._alarmList.set(index, vAlarm);
    }

    /**
     * 
     * 
     * @param vAlarmArray
     */
    public void setAlarm(
            final bean.Alarm[] vAlarmArray) {
        //-- copy array
        _alarmList.clear();
        
        for (int i = 0; i < vAlarmArray.length; i++) {
                this._alarmList.add(vAlarmArray[i]);
        }
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Alarms
     */
    public static bean.Alarms unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Alarms) Unmarshaller.unmarshal(bean.Alarms.class, reader);
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
