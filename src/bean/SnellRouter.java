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
 * Class SnellRouter.
 * 
 * @version $Revision$ $Date$
 */
public class SnellRouter implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _snellControllerList.
     */
    private java.util.List _snellControllerList;

    /**
     * Field _snellVideoMatrix.
     */
    private bean.SnellVideoMatrix _snellVideoMatrix;

    /**
     * Field _snellAudioMatrix.
     */
    private bean.SnellAudioMatrix _snellAudioMatrix;

    /**
     * Field _snellDataxxMatrix.
     */
    private bean.SnellDataxxMatrix _snellDataxxMatrix;


      //----------------/
     //- Constructors -/
    //----------------/

    public SnellRouter() {
        super();
        this._snellControllerList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSnellController
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSnellController(
            final bean.SnellController vSnellController)
    throws java.lang.IndexOutOfBoundsException {
        this._snellControllerList.add(vSnellController);
    }

    /**
     * 
     * 
     * @param index
     * @param vSnellController
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSnellController(
            final int index,
            final bean.SnellController vSnellController)
    throws java.lang.IndexOutOfBoundsException {
        this._snellControllerList.add(index, vSnellController);
    }

    /**
     * Method enumerateSnellController.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateSnellController(
    ) {
        return java.util.Collections.enumeration(this._snellControllerList);
    }

    /**
     * Returns the value of field 'snellAudioMatrix'.
     * 
     * @return the value of field 'SnellAudioMatrix'.
     */
    public bean.SnellAudioMatrix getSnellAudioMatrix(
    ) {
        return this._snellAudioMatrix;
    }

    /**
     * Method getSnellController.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.SnellController at the given
     * index
     */
    public bean.SnellController getSnellController(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._snellControllerList.size()) {
            throw new IndexOutOfBoundsException("getSnellController: Index value '" + index + "' not in range [0.." + (this._snellControllerList.size() - 1) + "]");
        }
        
        return (bean.SnellController) _snellControllerList.get(index);
    }

    /**
     * Method getSnellController.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.SnellController[] getSnellController(
    ) {
        bean.SnellController[] array = new bean.SnellController[0];
        return (bean.SnellController[]) this._snellControllerList.toArray(array);
    }

    /**
     * Method getSnellControllerCount.
     * 
     * @return the size of this collection
     */
    public int getSnellControllerCount(
    ) {
        return this._snellControllerList.size();
    }

    /**
     * Returns the value of field 'snellDataxxMatrix'.
     * 
     * @return the value of field 'SnellDataxxMatrix'.
     */
    public bean.SnellDataxxMatrix getSnellDataxxMatrix(
    ) {
        return this._snellDataxxMatrix;
    }

    /**
     * Returns the value of field 'snellVideoMatrix'.
     * 
     * @return the value of field 'SnellVideoMatrix'.
     */
    public bean.SnellVideoMatrix getSnellVideoMatrix(
    ) {
        return this._snellVideoMatrix;
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
     * Method iterateSnellController.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateSnellController(
    ) {
        return this._snellControllerList.iterator();
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
    public void removeAllSnellController(
    ) {
        this._snellControllerList.clear();
    }

    /**
     * Method removeSnellController.
     * 
     * @param vSnellController
     * @return true if the object was removed from the collection.
     */
    public boolean removeSnellController(
            final bean.SnellController vSnellController) {
        boolean removed = _snellControllerList.remove(vSnellController);
        return removed;
    }

    /**
     * Method removeSnellControllerAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.SnellController removeSnellControllerAt(
            final int index) {
        java.lang.Object obj = this._snellControllerList.remove(index);
        return (bean.SnellController) obj;
    }

    /**
     * Sets the value of field 'snellAudioMatrix'.
     * 
     * @param snellAudioMatrix the value of field 'snellAudioMatrix'
     */
    public void setSnellAudioMatrix(
            final bean.SnellAudioMatrix snellAudioMatrix) {
        this._snellAudioMatrix = snellAudioMatrix;
    }

    /**
     * 
     * 
     * @param index
     * @param vSnellController
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSnellController(
            final int index,
            final bean.SnellController vSnellController)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._snellControllerList.size()) {
            throw new IndexOutOfBoundsException("setSnellController: Index value '" + index + "' not in range [0.." + (this._snellControllerList.size() - 1) + "]");
        }
        
        this._snellControllerList.set(index, vSnellController);
    }

    /**
     * 
     * 
     * @param vSnellControllerArray
     */
    public void setSnellController(
            final bean.SnellController[] vSnellControllerArray) {
        //-- copy array
        _snellControllerList.clear();
        
        for (int i = 0; i < vSnellControllerArray.length; i++) {
                this._snellControllerList.add(vSnellControllerArray[i]);
        }
    }

    /**
     * Sets the value of field 'snellDataxxMatrix'.
     * 
     * @param snellDataxxMatrix the value of field
     * 'snellDataxxMatrix'.
     */
    public void setSnellDataxxMatrix(
            final bean.SnellDataxxMatrix snellDataxxMatrix) {
        this._snellDataxxMatrix = snellDataxxMatrix;
    }

    /**
     * Sets the value of field 'snellVideoMatrix'.
     * 
     * @param snellVideoMatrix the value of field 'snellVideoMatrix'
     */
    public void setSnellVideoMatrix(
            final bean.SnellVideoMatrix snellVideoMatrix) {
        this._snellVideoMatrix = snellVideoMatrix;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.SnellRouter
     */
    public static bean.SnellRouter unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.SnellRouter) Unmarshaller.unmarshal(bean.SnellRouter.class, reader);
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
