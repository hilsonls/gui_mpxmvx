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
 * Class Objects.
 * 
 * @version $Revision$ $Date$
 */
public class Objects implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _oggettoList.
     */
    private java.util.List _oggettoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Objects() {
        super();
        this._oggettoList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vOggetto
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOggetto(
            final bean.Oggetto vOggetto)
    throws java.lang.IndexOutOfBoundsException {
        this._oggettoList.add(vOggetto);
    }

    /**
     * 
     * 
     * @param index
     * @param vOggetto
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOggetto(
            final int index,
            final bean.Oggetto vOggetto)
    throws java.lang.IndexOutOfBoundsException {
        this._oggettoList.add(index, vOggetto);
    }

    /**
     * Method enumerateOggetto.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateOggetto(
    ) {
        return java.util.Collections.enumeration(this._oggettoList);
    }

    /**
     * Method getOggetto.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Oggetto at the given index
     */
    public bean.Oggetto getOggetto(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._oggettoList.size()) {
            throw new IndexOutOfBoundsException("getOggetto: Index value '" + index + "' not in range [0.." + (this._oggettoList.size() - 1) + "]");
        }
        
        return (bean.Oggetto) _oggettoList.get(index);
    }

    /**
     * Method getOggetto.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Oggetto[] getOggetto(
    ) {
        bean.Oggetto[] array = new bean.Oggetto[0];
        return (bean.Oggetto[]) this._oggettoList.toArray(array);
    }

    /**
     * Method getOggettoCount.
     * 
     * @return the size of this collection
     */
    public int getOggettoCount(
    ) {
        return this._oggettoList.size();
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
     * Method iterateOggetto.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateOggetto(
    ) {
        return this._oggettoList.iterator();
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
    public void removeAllOggetto(
    ) {
        this._oggettoList.clear();
    }

    /**
     * Method removeOggetto.
     * 
     * @param vOggetto
     * @return true if the object was removed from the collection.
     */
    public boolean removeOggetto(
            final bean.Oggetto vOggetto) {
        boolean removed = _oggettoList.remove(vOggetto);
        return removed;
    }

    /**
     * Method removeOggettoAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Oggetto removeOggettoAt(
            final int index) {
        java.lang.Object obj = this._oggettoList.remove(index);
        return (bean.Oggetto) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vOggetto
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setOggetto(
            final int index,
            final bean.Oggetto vOggetto)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._oggettoList.size()) {
            throw new IndexOutOfBoundsException("setOggetto: Index value '" + index + "' not in range [0.." + (this._oggettoList.size() - 1) + "]");
        }
        
        this._oggettoList.set(index, vOggetto);
    }

    /**
     * 
     * 
     * @param vOggettoArray
     */
    public void setOggetto(
            final bean.Oggetto[] vOggettoArray) {
        //-- copy array
        _oggettoList.clear();
        
        for (int i = 0; i < vOggettoArray.length; i++) {
                this._oggettoList.add(vOggettoArray[i]);
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
     * @return the unmarshaled bean.Objects
     */
    public static bean.Objects unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Objects) Unmarshaller.unmarshal(bean.Objects.class, reader);
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
