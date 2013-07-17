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
 * Class OptionsList.
 * 
 * @version $Revision$ $Date$
 */
public class OptionsList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _nameList.
     */
    private java.util.List _nameList;


      //----------------/
     //- Constructors -/
    //----------------/

    public OptionsList() {
        super();
        this._nameList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addName(
            final bean.Name vName)
    throws java.lang.IndexOutOfBoundsException {
        this._nameList.add(vName);
    }

    /**
     * 
     * 
     * @param index
     * @param vName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addName(
            final int index,
            final bean.Name vName)
    throws java.lang.IndexOutOfBoundsException {
        this._nameList.add(index, vName);
    }

    /**
     * Method enumerateName.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateName(
    ) {
        return java.util.Collections.enumeration(this._nameList);
    }

    /**
     * Method getName.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Name at the given index
     */
    public bean.Name getName(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._nameList.size()) {
            throw new IndexOutOfBoundsException("getName: Index value '" + index + "' not in range [0.." + (this._nameList.size() - 1) + "]");
        }
        
        return (bean.Name) _nameList.get(index);
    }

    /**
     * Method getName.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Name[] getName(
    ) {
        bean.Name[] array = new bean.Name[0];
        return (bean.Name[]) this._nameList.toArray(array);
    }

    /**
     * Method getNameCount.
     * 
     * @return the size of this collection
     */
    public int getNameCount(
    ) {
        return this._nameList.size();
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
     * Method iterateName.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateName(
    ) {
        return this._nameList.iterator();
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
    public void removeAllName(
    ) {
        this._nameList.clear();
    }

    /**
     * Method removeName.
     * 
     * @param vName
     * @return true if the object was removed from the collection.
     */
    public boolean removeName(
            final bean.Name vName) {
        boolean removed = _nameList.remove(vName);
        return removed;
    }

    /**
     * Method removeNameAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Name removeNameAt(
            final int index) {
        java.lang.Object obj = this._nameList.remove(index);
        return (bean.Name) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vName
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setName(
            final int index,
            final bean.Name vName)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._nameList.size()) {
            throw new IndexOutOfBoundsException("setName: Index value '" + index + "' not in range [0.." + (this._nameList.size() - 1) + "]");
        }
        
        this._nameList.set(index, vName);
    }

    /**
     * 
     * 
     * @param vNameArray
     */
    public void setName(
            final bean.Name[] vNameArray) {
        //-- copy array
        _nameList.clear();
        
        for (int i = 0; i < vNameArray.length; i++) {
                this._nameList.add(vNameArray[i]);
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
     * @return the unmarshaled bean.OptionsList
     */
    public static bean.OptionsList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.OptionsList) Unmarshaller.unmarshal(bean.OptionsList.class, reader);
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
