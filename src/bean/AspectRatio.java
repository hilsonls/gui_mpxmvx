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
 * Class AspectRatio.
 * 
 * @version $Revision$ $Date$
 */
public class AspectRatio extends bean.ObjectStringProperty 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _optionsName.
     */
    private java.lang.String _optionsName;

    /**
     * Field _float.
     */
    private java.lang.String _float;

    /**
     * Field _extLeft.
     */
    private int _extLeft;

    /**
     * keeps track of state for field: _extLeft
     */
    private boolean _has_extLeft;

    /**
     * Field _extRight.
     */
    private int _extRight;

    /**
     * keeps track of state for field: _extRight
     */
    private boolean _has_extRight;

    /**
     * Field _extTop.
     */
    private int _extTop;

    /**
     * keeps track of state for field: _extTop
     */
    private boolean _has_extTop;

    /**
     * Field _extBottom.
     */
    private int _extBottom;

    /**
     * keeps track of state for field: _extBottom
     */
    private boolean _has_extBottom;

    /**
     * Field _useVideo.
     */
    private boolean _useVideo;

    /**
     * keeps track of state for field: _useVideo
     */
    private boolean _has_useVideo;


      //----------------/
     //- Constructors -/
    //----------------/

    public AspectRatio() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteExtBottom(
    ) {
        this._has_extBottom= false;
    }

    /**
     */
    public void deleteExtLeft(
    ) {
        this._has_extLeft= false;
    }

    /**
     */
    public void deleteExtRight(
    ) {
        this._has_extRight= false;
    }

    /**
     */
    public void deleteExtTop(
    ) {
        this._has_extTop= false;
    }

    /**
     */
    public void deleteUseVideo(
    ) {
        this._has_useVideo= false;
    }

    /**
     * Returns the value of field 'extBottom'.
     * 
     * @return the value of field 'ExtBottom'.
     */
    public int getExtBottom(
    ) {
        return this._extBottom;
    }

    /**
     * Returns the value of field 'extLeft'.
     * 
     * @return the value of field 'ExtLeft'.
     */
    public int getExtLeft(
    ) {
        return this._extLeft;
    }

    /**
     * Returns the value of field 'extRight'.
     * 
     * @return the value of field 'ExtRight'.
     */
    public int getExtRight(
    ) {
        return this._extRight;
    }

    /**
     * Returns the value of field 'extTop'.
     * 
     * @return the value of field 'ExtTop'.
     */
    public int getExtTop(
    ) {
        return this._extTop;
    }

    /**
     * Returns the value of field 'float'.
     * 
     * @return the value of field 'Float'.
     */
    public java.lang.String getFloat(
    ) {
        return this._float;
    }

    /**
     * Returns the value of field 'optionsName'.
     * 
     * @return the value of field 'OptionsName'.
     */
    public java.lang.String getOptionsName(
    ) {
        return this._optionsName;
    }

    /**
     * Returns the value of field 'useVideo'.
     * 
     * @return the value of field 'UseVideo'.
     */
    public boolean getUseVideo(
    ) {
        return this._useVideo;
    }

    /**
     * Method hasExtBottom.
     * 
     * @return true if at least one ExtBottom has been added
     */
    public boolean hasExtBottom(
    ) {
        return this._has_extBottom;
    }

    /**
     * Method hasExtLeft.
     * 
     * @return true if at least one ExtLeft has been added
     */
    public boolean hasExtLeft(
    ) {
        return this._has_extLeft;
    }

    /**
     * Method hasExtRight.
     * 
     * @return true if at least one ExtRight has been added
     */
    public boolean hasExtRight(
    ) {
        return this._has_extRight;
    }

    /**
     * Method hasExtTop.
     * 
     * @return true if at least one ExtTop has been added
     */
    public boolean hasExtTop(
    ) {
        return this._has_extTop;
    }

    /**
     * Method hasUseVideo.
     * 
     * @return true if at least one UseVideo has been added
     */
    public boolean hasUseVideo(
    ) {
        return this._has_useVideo;
    }

    /**
     * Returns the value of field 'useVideo'.
     * 
     * @return the value of field 'UseVideo'.
     */
    public boolean isUseVideo(
    ) {
        return this._useVideo;
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
     * Sets the value of field 'extBottom'.
     * 
     * @param extBottom the value of field 'extBottom'.
     */
    public void setExtBottom(
            final int extBottom) {
        this._extBottom = extBottom;
        this._has_extBottom = true;
    }

    /**
     * Sets the value of field 'extLeft'.
     * 
     * @param extLeft the value of field 'extLeft'.
     */
    public void setExtLeft(
            final int extLeft) {
        this._extLeft = extLeft;
        this._has_extLeft = true;
    }

    /**
     * Sets the value of field 'extRight'.
     * 
     * @param extRight the value of field 'extRight'.
     */
    public void setExtRight(
            final int extRight) {
        this._extRight = extRight;
        this._has_extRight = true;
    }

    /**
     * Sets the value of field 'extTop'.
     * 
     * @param extTop the value of field 'extTop'.
     */
    public void setExtTop(
            final int extTop) {
        this._extTop = extTop;
        this._has_extTop = true;
    }

    /**
     * Sets the value of field 'float'.
     * 
     * @param _float
     * @param float the value of field 'float'.
     */
    public void setFloat(
            final java.lang.String _float) {
        this._float = _float;
    }

    /**
     * Sets the value of field 'optionsName'.
     * 
     * @param optionsName the value of field 'optionsName'.
     */
    public void setOptionsName(
            final java.lang.String optionsName) {
        this._optionsName = optionsName;
    }

    /**
     * Sets the value of field 'useVideo'.
     * 
     * @param useVideo the value of field 'useVideo'.
     */
    public void setUseVideo(
            final boolean useVideo) {
        this._useVideo = useVideo;
        this._has_useVideo = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.ObjectStringProperty
     */
    public static bean.ObjectStringProperty unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.ObjectStringProperty) Unmarshaller.unmarshal(bean.AspectRatio.class, reader);
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
