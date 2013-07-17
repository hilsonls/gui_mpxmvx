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
 * Class Ports.
 * 
 * @version $Revision$ $Date$
 */
public class Ports implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _portList.
     */
    private java.util.List _portList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Ports() {
        super();
        this._portList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPort
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPort(
            final bean.Port vPort)
    throws java.lang.IndexOutOfBoundsException {
        this._portList.add(vPort);
    }

    /**
     * 
     * 
     * @param index
     * @param vPort
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPort(
            final int index,
            final bean.Port vPort)
    throws java.lang.IndexOutOfBoundsException {
        this._portList.add(index, vPort);
    }

    /**
     * Method enumeratePort.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumeratePort(
    ) {
        return java.util.Collections.enumeration(this._portList);
    }

    /**
     * Method getPort.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Port at the given index
     */
    public bean.Port getPort(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._portList.size()) {
            throw new IndexOutOfBoundsException("getPort: Index value '" + index + "' not in range [0.." + (this._portList.size() - 1) + "]");
        }
        
        return (bean.Port) _portList.get(index);
    }

    /**
     * Method getPort.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Port[] getPort(
    ) {
        bean.Port[] array = new bean.Port[0];
        return (bean.Port[]) this._portList.toArray(array);
    }

    /**
     * Method getPortCount.
     * 
     * @return the size of this collection
     */
    public int getPortCount(
    ) {
        return this._portList.size();
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
     * Method iteratePort.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iteratePort(
    ) {
        return this._portList.iterator();
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
     */
    public void removeAllPort(
    ) {
        this._portList.clear();
    }

    /**
     * Method removePort.
     * 
     * @param vPort
     * @return true if the object was removed from the collection.
     */
    public boolean removePort(
            final bean.Port vPort) {
        boolean removed = _portList.remove(vPort);
        return removed;
    }

    /**
     * Method removePortAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Port removePortAt(
            final int index) {
        java.lang.Object obj = this._portList.remove(index);
        return (bean.Port) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vPort
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPort(
            final int index,
            final bean.Port vPort)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._portList.size()) {
            throw new IndexOutOfBoundsException("setPort: Index value '" + index + "' not in range [0.." + (this._portList.size() - 1) + "]");
        }
        
        this._portList.set(index, vPort);
    }

    /**
     * 
     * 
     * @param vPortArray
     */
    public void setPort(
            final bean.Port[] vPortArray) {
        //-- copy array
        _portList.clear();
        
        for (int i = 0; i < vPortArray.length; i++) {
                this._portList.add(vPortArray[i]);
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
     * @return the unmarshaled bean.Ports
     */
    public static bean.Ports unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Ports) Unmarshaller.unmarshal(bean.Ports.class, reader);
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
