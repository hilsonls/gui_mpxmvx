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
 * Class VideoProperties.
 * 
 * @version $Revision$ $Date$
 */
public class VideoProperties implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _tally.
     */
    private bean.Tally _tally;

    /**
     * Field _vbi.
     */
    private bean.Vbi _vbi;

    /**
     * Field _wss.
     */
    private bean.Wss _wss;

    /**
     * Field _displayOnAllScreens.
     */
    private bean.DisplayOnAllScreens _displayOnAllScreens;

    /**
     * Field _sag.
     */
    private bean.Sag _sag;

    /**
     * Field _inputResolutionDisplay.
     */
    private bean.InputResolutionDisplay _inputResolutionDisplay;


      //----------------/
     //- Constructors -/
    //----------------/

    public VideoProperties() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'displayOnAllScreens'.
     * 
     * @return the value of field 'DisplayOnAllScreens'.
     */
    public bean.DisplayOnAllScreens getDisplayOnAllScreens(
    ) {
        return this._displayOnAllScreens;
    }

    /**
     * Returns the value of field 'inputResolutionDisplay'.
     * 
     * @return the value of field 'InputResolutionDisplay'.
     */
    public bean.InputResolutionDisplay getInputResolutionDisplay(
    ) {
        return this._inputResolutionDisplay;
    }

    /**
     * Returns the value of field 'sag'.
     * 
     * @return the value of field 'Sag'.
     */
    public bean.Sag getSag(
    ) {
        return this._sag;
    }

    /**
     * Returns the value of field 'tally'.
     * 
     * @return the value of field 'Tally'.
     */
    public bean.Tally getTally(
    ) {
        return this._tally;
    }

    /**
     * Returns the value of field 'vbi'.
     * 
     * @return the value of field 'Vbi'.
     */
    public bean.Vbi getVbi(
    ) {
        return this._vbi;
    }

    /**
     * Returns the value of field 'wss'.
     * 
     * @return the value of field 'Wss'.
     */
    public bean.Wss getWss(
    ) {
        return this._wss;
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
     * Sets the value of field 'displayOnAllScreens'.
     * 
     * @param displayOnAllScreens the value of field
     * 'displayOnAllScreens'.
     */
    public void setDisplayOnAllScreens(
            final bean.DisplayOnAllScreens displayOnAllScreens) {
        this._displayOnAllScreens = displayOnAllScreens;
    }

    /**
     * Sets the value of field 'inputResolutionDisplay'.
     * 
     * @param inputResolutionDisplay the value of field
     * 'inputResolutionDisplay'.
     */
    public void setInputResolutionDisplay(
            final bean.InputResolutionDisplay inputResolutionDisplay) {
        this._inputResolutionDisplay = inputResolutionDisplay;
    }

    /**
     * Sets the value of field 'sag'.
     * 
     * @param sag the value of field 'sag'.
     */
    public void setSag(
            final bean.Sag sag) {
        this._sag = sag;
    }

    /**
     * Sets the value of field 'tally'.
     * 
     * @param tally the value of field 'tally'.
     */
    public void setTally(
            final bean.Tally tally) {
        this._tally = tally;
    }

    /**
     * Sets the value of field 'vbi'.
     * 
     * @param vbi the value of field 'vbi'.
     */
    public void setVbi(
            final bean.Vbi vbi) {
        this._vbi = vbi;
    }

    /**
     * Sets the value of field 'wss'.
     * 
     * @param wss the value of field 'wss'.
     */
    public void setWss(
            final bean.Wss wss) {
        this._wss = wss;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.VideoProperties
     */
    public static bean.VideoProperties unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.VideoProperties) Unmarshaller.unmarshal(bean.VideoProperties.class, reader);
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
