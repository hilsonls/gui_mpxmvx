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
 * Class TimerProperties.
 * 
 * @version $Revision$ $Date$
 */
public class TimerProperties implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _triggerGpi.
     */
    private bean.TriggerGpi _triggerGpi;

    /**
     * Field _gpiSource.
     */
    private bean.GpiSource _gpiSource;

    /**
     * Field _startTime.
     */
    private bean.StartTime _startTime;

    /**
     * Field _stopTime.
     */
    private bean.StopTime _stopTime;

    /**
     * Field _countDown.
     */
    private bean.CountDown _countDown;

    /**
     * Field _showFrames.
     */
    private bean.ShowFrames _showFrames;

    /**
     * Field _font.
     */
    private bean.Font _font;

    /**
     * Field _fontSize.
     */
    private bean.FontSize _fontSize;

    /**
     * Field _fgColour.
     */
    private bean.FgColour _fgColour;

    /**
     * Field _transColour.
     */
    private bean.TransColour _transColour;

    /**
     * Field _destColour.
     */
    private bean.DestColour _destColour;

    /**
     * Field _bgColour.
     */
    private bean.BgColour _bgColour;


      //----------------/
     //- Constructors -/
    //----------------/

    public TimerProperties() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'bgColour'.
     * 
     * @return the value of field 'BgColour'.
     */
    public bean.BgColour getBgColour(
    ) {
        return this._bgColour;
    }

    /**
     * Returns the value of field 'countDown'.
     * 
     * @return the value of field 'CountDown'.
     */
    public bean.CountDown getCountDown(
    ) {
        return this._countDown;
    }

    /**
     * Returns the value of field 'destColour'.
     * 
     * @return the value of field 'DestColour'.
     */
    public bean.DestColour getDestColour(
    ) {
        return this._destColour;
    }

    /**
     * Returns the value of field 'fgColour'.
     * 
     * @return the value of field 'FgColour'.
     */
    public bean.FgColour getFgColour(
    ) {
        return this._fgColour;
    }

    /**
     * Returns the value of field 'font'.
     * 
     * @return the value of field 'Font'.
     */
    public bean.Font getFont(
    ) {
        return this._font;
    }

    /**
     * Returns the value of field 'fontSize'.
     * 
     * @return the value of field 'FontSize'.
     */
    public bean.FontSize getFontSize(
    ) {
        return this._fontSize;
    }

    /**
     * Returns the value of field 'gpiSource'.
     * 
     * @return the value of field 'GpiSource'.
     */
    public bean.GpiSource getGpiSource(
    ) {
        return this._gpiSource;
    }

    /**
     * Returns the value of field 'showFrames'.
     * 
     * @return the value of field 'ShowFrames'.
     */
    public bean.ShowFrames getShowFrames(
    ) {
        return this._showFrames;
    }

    /**
     * Returns the value of field 'startTime'.
     * 
     * @return the value of field 'StartTime'.
     */
    public bean.StartTime getStartTime(
    ) {
        return this._startTime;
    }

    /**
     * Returns the value of field 'stopTime'.
     * 
     * @return the value of field 'StopTime'.
     */
    public bean.StopTime getStopTime(
    ) {
        return this._stopTime;
    }

    /**
     * Returns the value of field 'transColour'.
     * 
     * @return the value of field 'TransColour'.
     */
    public bean.TransColour getTransColour(
    ) {
        return this._transColour;
    }

    /**
     * Returns the value of field 'triggerGpi'.
     * 
     * @return the value of field 'TriggerGpi'.
     */
    public bean.TriggerGpi getTriggerGpi(
    ) {
        return this._triggerGpi;
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
     * Sets the value of field 'bgColour'.
     * 
     * @param bgColour the value of field 'bgColour'.
     */
    public void setBgColour(
            final bean.BgColour bgColour) {
        this._bgColour = bgColour;
    }

    /**
     * Sets the value of field 'countDown'.
     * 
     * @param countDown the value of field 'countDown'.
     */
    public void setCountDown(
            final bean.CountDown countDown) {
        this._countDown = countDown;
    }

    /**
     * Sets the value of field 'destColour'.
     * 
     * @param destColour the value of field 'destColour'.
     */
    public void setDestColour(
            final bean.DestColour destColour) {
        this._destColour = destColour;
    }

    /**
     * Sets the value of field 'fgColour'.
     * 
     * @param fgColour the value of field 'fgColour'.
     */
    public void setFgColour(
            final bean.FgColour fgColour) {
        this._fgColour = fgColour;
    }

    /**
     * Sets the value of field 'font'.
     * 
     * @param font the value of field 'font'.
     */
    public void setFont(
            final bean.Font font) {
        this._font = font;
    }

    /**
     * Sets the value of field 'fontSize'.
     * 
     * @param fontSize the value of field 'fontSize'.
     */
    public void setFontSize(
            final bean.FontSize fontSize) {
        this._fontSize = fontSize;
    }

    /**
     * Sets the value of field 'gpiSource'.
     * 
     * @param gpiSource the value of field 'gpiSource'.
     */
    public void setGpiSource(
            final bean.GpiSource gpiSource) {
        this._gpiSource = gpiSource;
    }

    /**
     * Sets the value of field 'showFrames'.
     * 
     * @param showFrames the value of field 'showFrames'.
     */
    public void setShowFrames(
            final bean.ShowFrames showFrames) {
        this._showFrames = showFrames;
    }

    /**
     * Sets the value of field 'startTime'.
     * 
     * @param startTime the value of field 'startTime'.
     */
    public void setStartTime(
            final bean.StartTime startTime) {
        this._startTime = startTime;
    }

    /**
     * Sets the value of field 'stopTime'.
     * 
     * @param stopTime the value of field 'stopTime'.
     */
    public void setStopTime(
            final bean.StopTime stopTime) {
        this._stopTime = stopTime;
    }

    /**
     * Sets the value of field 'transColour'.
     * 
     * @param transColour the value of field 'transColour'.
     */
    public void setTransColour(
            final bean.TransColour transColour) {
        this._transColour = transColour;
    }

    /**
     * Sets the value of field 'triggerGpi'.
     * 
     * @param triggerGpi the value of field 'triggerGpi'.
     */
    public void setTriggerGpi(
            final bean.TriggerGpi triggerGpi) {
        this._triggerGpi = triggerGpi;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.TimerProperties
     */
    public static bean.TimerProperties unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.TimerProperties) Unmarshaller.unmarshal(bean.TimerProperties.class, reader);
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
