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
 * Class Sources.
 * 
 * @version $Revision$ $Date$
 */
public class Sources implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sourceList.
     */
    private java.util.List _sourceList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Sources() {
        super();
        this._sourceList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSource
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSource(
            final bean.Source vSource)
    throws java.lang.IndexOutOfBoundsException {
        this._sourceList.add(vSource);
    }

    /**
     * 
     * 
     * @param index
     * @param vSource
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSource(
            final int index,
            final bean.Source vSource)
    throws java.lang.IndexOutOfBoundsException {
        this._sourceList.add(index, vSource);
    }

    /**
     * Method enumerateSource.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateSource(
    ) {
        return java.util.Collections.enumeration(this._sourceList);
    }

    /**
     * Method getSource.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Source at the given index
     */
    public bean.Source getSource(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._sourceList.size()) {
            throw new IndexOutOfBoundsException("getSource: Index value '" + index + "' not in range [0.." + (this._sourceList.size() - 1) + "]");
        }
        
        return (bean.Source) _sourceList.get(index);
    }

    /**
     * Method getSource.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Source[] getSource(
    ) {
        bean.Source[] array = new bean.Source[0];
        return (bean.Source[]) this._sourceList.toArray(array);
    }

    /**
     * Method getSourceCount.
     * 
     * @return the size of this collection
     */
    public int getSourceCount(
    ) {
        return this._sourceList.size();
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
     * Method iterateSource.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateSource(
    ) {
        return this._sourceList.iterator();
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
    public void removeAllSource(
    ) {
        this._sourceList.clear();
    }

    /**
     * Method removeSource.
     * 
     * @param vSource
     * @return true if the object was removed from the collection.
     */
    public boolean removeSource(
            final bean.Source vSource) {
        boolean removed = _sourceList.remove(vSource);
        return removed;
    }

    /**
     * Method removeSourceAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Source removeSourceAt(
            final int index) {
        java.lang.Object obj = this._sourceList.remove(index);
        return (bean.Source) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vSource
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSource(
            final int index,
            final bean.Source vSource)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._sourceList.size()) {
            throw new IndexOutOfBoundsException("setSource: Index value '" + index + "' not in range [0.." + (this._sourceList.size() - 1) + "]");
        }
        
        this._sourceList.set(index, vSource);
    }

    /**
     * 
     * 
     * @param vSourceArray
     */
    public void setSource(
            final bean.Source[] vSourceArray) {
        //-- copy array
        _sourceList.clear();
        
        for (int i = 0; i < vSourceArray.length; i++) {
                this._sourceList.add(vSourceArray[i]);
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
     * @return the unmarshaled bean.Sources
     */
    public static bean.Sources unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Sources) Unmarshaller.unmarshal(bean.Sources.class, reader);
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
