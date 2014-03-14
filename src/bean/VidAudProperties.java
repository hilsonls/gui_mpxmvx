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
 * Class VidAudProperties.
 * 
 * @version $Revision$ $Date$
 */
public class VidAudProperties implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _vidAudSource.
     */
    private bean.VidAudSource _vidAudSource;

    /**
     * Field _audioList.
     */
    private java.util.List _audioList;

    /**
     * Field _error.
     */
    private bean.Error _error;


      //----------------/
     //- Constructors -/
    //----------------/

    public VidAudProperties() {
        super();
        this._audioList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAudio
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAudio(
            final bean.Audio vAudio)
    throws java.lang.IndexOutOfBoundsException {
        this._audioList.add(vAudio);
    }

    /**
     * 
     * 
     * @param index
     * @param vAudio
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAudio(
            final int index,
            final bean.Audio vAudio)
    throws java.lang.IndexOutOfBoundsException {
        this._audioList.add(index, vAudio);
    }

    /**
     * Method enumerateAudio.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateAudio(
    ) {
        return java.util.Collections.enumeration(this._audioList);
    }

    /**
     * Method getAudio.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Audio at the given index
     */
    public bean.Audio getAudio(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._audioList.size()) {
            throw new IndexOutOfBoundsException("getAudio: Index value '" + index + "' not in range [0.." + (this._audioList.size() - 1) + "]");
        }
        
        return (bean.Audio) _audioList.get(index);
    }

    /**
     * Method getAudio.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Audio[] getAudio(
    ) {
        bean.Audio[] array = new bean.Audio[0];
        return (bean.Audio[]) this._audioList.toArray(array);
    }

    /**
     * Method getAudioCount.
     * 
     * @return the size of this collection
     */
    public int getAudioCount(
    ) {
        return this._audioList.size();
    }

    /**
     * Returns the value of field 'error'.
     * 
     * @return the value of field 'Error'.
     */
    public bean.Error getError(
    ) {
        return this._error;
    }

    /**
     * Returns the value of field 'vidAudSource'.
     * 
     * @return the value of field 'VidAudSource'.
     */
    public bean.VidAudSource getVidAudSource(
    ) {
        return this._vidAudSource;
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
     * Method iterateAudio.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateAudio(
    ) {
        return this._audioList.iterator();
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
    public void removeAllAudio(
    ) {
        this._audioList.clear();
    }

    /**
     * Method removeAudio.
     * 
     * @param vAudio
     * @return true if the object was removed from the collection.
     */
    public boolean removeAudio(
            final bean.Audio vAudio) {
        boolean removed = _audioList.remove(vAudio);
        return removed;
    }

    /**
     * Method removeAudioAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Audio removeAudioAt(
            final int index) {
        java.lang.Object obj = this._audioList.remove(index);
        return (bean.Audio) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vAudio
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAudio(
            final int index,
            final bean.Audio vAudio)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._audioList.size()) {
            throw new IndexOutOfBoundsException("setAudio: Index value '" + index + "' not in range [0.." + (this._audioList.size() - 1) + "]");
        }
        
        this._audioList.set(index, vAudio);
    }

    /**
     * 
     * 
     * @param vAudioArray
     */
    public void setAudio(
            final bean.Audio[] vAudioArray) {
        //-- copy array
        _audioList.clear();
        
        for (int i = 0; i < vAudioArray.length; i++) {
                this._audioList.add(vAudioArray[i]);
        }
    }

    /**
     * Sets the value of field 'error'.
     * 
     * @param error the value of field 'error'.
     */
    public void setError(
            final bean.Error error) {
        this._error = error;
    }

    /**
     * Sets the value of field 'vidAudSource'.
     * 
     * @param vidAudSource the value of field 'vidAudSource'.
     */
    public void setVidAudSource(
            final bean.VidAudSource vidAudSource) {
        this._vidAudSource = vidAudSource;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.VidAudProperties
     */
    public static bean.VidAudProperties unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.VidAudProperties) Unmarshaller.unmarshal(bean.VidAudProperties.class, reader);
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
