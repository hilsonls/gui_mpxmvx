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
 * Class LiveRead.
 * 
 * @version $Revision$ $Date$
 */
public class LiveRead implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _moduleList.
     */
    private java.util.List _moduleList;


      //----------------/
     //- Constructors -/
    //----------------/

    public LiveRead() {
        super();
        this._moduleList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vModule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addModule(
            final bean.Module vModule)
    throws java.lang.IndexOutOfBoundsException {
        this._moduleList.add(vModule);
    }

    /**
     * 
     * 
     * @param index
     * @param vModule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addModule(
            final int index,
            final bean.Module vModule)
    throws java.lang.IndexOutOfBoundsException {
        this._moduleList.add(index, vModule);
    }

    /**
     * Method enumerateModule.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateModule(
    ) {
        return java.util.Collections.enumeration(this._moduleList);
    }

    /**
     * Method getModule.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Module at the given index
     */
    public bean.Module getModule(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._moduleList.size()) {
            throw new IndexOutOfBoundsException("getModule: Index value '" + index + "' not in range [0.." + (this._moduleList.size() - 1) + "]");
        }
        
        return (bean.Module) _moduleList.get(index);
    }

    /**
     * Method getModule.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Module[] getModule(
    ) {
        bean.Module[] array = new bean.Module[0];
        return (bean.Module[]) this._moduleList.toArray(array);
    }

    /**
     * Method getModuleCount.
     * 
     * @return the size of this collection
     */
    public int getModuleCount(
    ) {
        return this._moduleList.size();
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
     * Method iterateModule.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateModule(
    ) {
        return this._moduleList.iterator();
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
    public void removeAllModule(
    ) {
        this._moduleList.clear();
    }

    /**
     * Method removeModule.
     * 
     * @param vModule
     * @return true if the object was removed from the collection.
     */
    public boolean removeModule(
            final bean.Module vModule) {
        boolean removed = _moduleList.remove(vModule);
        return removed;
    }

    /**
     * Method removeModuleAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Module removeModuleAt(
            final int index) {
        java.lang.Object obj = this._moduleList.remove(index);
        return (bean.Module) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vModule
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setModule(
            final int index,
            final bean.Module vModule)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._moduleList.size()) {
            throw new IndexOutOfBoundsException("setModule: Index value '" + index + "' not in range [0.." + (this._moduleList.size() - 1) + "]");
        }
        
        this._moduleList.set(index, vModule);
    }

    /**
     * 
     * 
     * @param vModuleArray
     */
    public void setModule(
            final bean.Module[] vModuleArray) {
        //-- copy array
        _moduleList.clear();
        
        for (int i = 0; i < vModuleArray.length; i++) {
                this._moduleList.add(vModuleArray[i]);
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
     * @return the unmarshaled bean.LiveRead
     */
    public static bean.LiveRead unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.LiveRead) Unmarshaller.unmarshal(bean.LiveRead.class, reader);
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
