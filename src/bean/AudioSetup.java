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
 * Class AudioSetup.
 * 
 * @version $Revision$ $Date$
 */
public class AudioSetup implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _scaleTransitionList.
     */
    private java.util.List _scaleTransitionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AudioSetup() {
        super();
        this._scaleTransitionList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vScaleTransition
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addScaleTransition(
            final bean.ScaleTransition vScaleTransition)
    throws java.lang.IndexOutOfBoundsException {
        this._scaleTransitionList.add(vScaleTransition);
    }

    /**
     * 
     * 
     * @param index
     * @param vScaleTransition
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addScaleTransition(
            final int index,
            final bean.ScaleTransition vScaleTransition)
    throws java.lang.IndexOutOfBoundsException {
        this._scaleTransitionList.add(index, vScaleTransition);
    }

    /**
     * Method enumerateScaleTransition.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateScaleTransition(
    ) {
        return java.util.Collections.enumeration(this._scaleTransitionList);
    }

    /**
     * Method getScaleTransition.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.ScaleTransition at the given
     * index
     */
    public bean.ScaleTransition getScaleTransition(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._scaleTransitionList.size()) {
            throw new IndexOutOfBoundsException("getScaleTransition: Index value '" + index + "' not in range [0.." + (this._scaleTransitionList.size() - 1) + "]");
        }
        
        return (bean.ScaleTransition) _scaleTransitionList.get(index);
    }

    /**
     * Method getScaleTransition.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.ScaleTransition[] getScaleTransition(
    ) {
        bean.ScaleTransition[] array = new bean.ScaleTransition[0];
        return (bean.ScaleTransition[]) this._scaleTransitionList.toArray(array);
    }

    /**
     * Method getScaleTransitionCount.
     * 
     * @return the size of this collection
     */
    public int getScaleTransitionCount(
    ) {
        return this._scaleTransitionList.size();
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
     * Method iterateScaleTransition.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateScaleTransition(
    ) {
        return this._scaleTransitionList.iterator();
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
    public void removeAllScaleTransition(
    ) {
        this._scaleTransitionList.clear();
    }

    /**
     * Method removeScaleTransition.
     * 
     * @param vScaleTransition
     * @return true if the object was removed from the collection.
     */
    public boolean removeScaleTransition(
            final bean.ScaleTransition vScaleTransition) {
        boolean removed = _scaleTransitionList.remove(vScaleTransition);
        return removed;
    }

    /**
     * Method removeScaleTransitionAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.ScaleTransition removeScaleTransitionAt(
            final int index) {
        java.lang.Object obj = this._scaleTransitionList.remove(index);
        return (bean.ScaleTransition) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vScaleTransition
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setScaleTransition(
            final int index,
            final bean.ScaleTransition vScaleTransition)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._scaleTransitionList.size()) {
            throw new IndexOutOfBoundsException("setScaleTransition: Index value '" + index + "' not in range [0.." + (this._scaleTransitionList.size() - 1) + "]");
        }
        
        this._scaleTransitionList.set(index, vScaleTransition);
    }

    /**
     * 
     * 
     * @param vScaleTransitionArray
     */
    public void setScaleTransition(
            final bean.ScaleTransition[] vScaleTransitionArray) {
        //-- copy array
        _scaleTransitionList.clear();
        
        for (int i = 0; i < vScaleTransitionArray.length; i++) {
                this._scaleTransitionList.add(vScaleTransitionArray[i]);
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
     * @return the unmarshaled bean.AudioSetup
     */
    public static bean.AudioSetup unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.AudioSetup) Unmarshaller.unmarshal(bean.AudioSetup.class, reader);
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
