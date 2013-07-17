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
 * Class Tally.
 * 
 * @version $Revision$ $Date$
 */
public class Tally implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _type.
     */
    private bean.Type _type;

    /**
     * Field _style.
     */
    private bean.Style _style;

    /**
     * Field _shape.
     */
    private bean.Shape _shape;

    /**
     * Field _tallyPosition.
     */
    private bean.TallyPosition _tallyPosition;

    /**
     * Field _disabledColourSource.
     */
    private bean.DisabledColourSource _disabledColourSource;

    /**
     * Field _disabledColour.
     */
    private bean.DisabledColour _disabledColour;

    /**
     * Field _visible.
     */
    private bean.Visible _visible;


      //----------------/
     //- Constructors -/
    //----------------/

    public Tally() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'disabledColour'.
     * 
     * @return the value of field 'DisabledColour'.
     */
    public bean.DisabledColour getDisabledColour(
    ) {
        return this._disabledColour;
    }

    /**
     * Returns the value of field 'disabledColourSource'.
     * 
     * @return the value of field 'DisabledColourSource'.
     */
    public bean.DisabledColourSource getDisabledColourSource(
    ) {
        return this._disabledColourSource;
    }

    /**
     * Returns the value of field 'shape'.
     * 
     * @return the value of field 'Shape'.
     */
    public bean.Shape getShape(
    ) {
        return this._shape;
    }

    /**
     * Returns the value of field 'style'.
     * 
     * @return the value of field 'Style'.
     */
    public bean.Style getStyle(
    ) {
        return this._style;
    }

    /**
     * Returns the value of field 'tallyPosition'.
     * 
     * @return the value of field 'TallyPosition'.
     */
    public bean.TallyPosition getTallyPosition(
    ) {
        return this._tallyPosition;
    }

    /**
     * Returns the value of field 'type'.
     * 
     * @return the value of field 'Type'.
     */
    public bean.Type getType(
    ) {
        return this._type;
    }

    /**
     * Returns the value of field 'visible'.
     * 
     * @return the value of field 'Visible'.
     */
    public bean.Visible getVisible(
    ) {
        return this._visible;
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
     * Sets the value of field 'disabledColour'.
     * 
     * @param disabledColour the value of field 'disabledColour'.
     */
    public void setDisabledColour(
            final bean.DisabledColour disabledColour) {
        this._disabledColour = disabledColour;
    }

    /**
     * Sets the value of field 'disabledColourSource'.
     * 
     * @param disabledColourSource the value of field
     * 'disabledColourSource'.
     */
    public void setDisabledColourSource(
            final bean.DisabledColourSource disabledColourSource) {
        this._disabledColourSource = disabledColourSource;
    }

    /**
     * Sets the value of field 'shape'.
     * 
     * @param shape the value of field 'shape'.
     */
    public void setShape(
            final bean.Shape shape) {
        this._shape = shape;
    }

    /**
     * Sets the value of field 'style'.
     * 
     * @param style the value of field 'style'.
     */
    public void setStyle(
            final bean.Style style) {
        this._style = style;
    }

    /**
     * Sets the value of field 'tallyPosition'.
     * 
     * @param tallyPosition the value of field 'tallyPosition'.
     */
    public void setTallyPosition(
            final bean.TallyPosition tallyPosition) {
        this._tallyPosition = tallyPosition;
    }

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(
            final bean.Type type) {
        this._type = type;
    }

    /**
     * Sets the value of field 'visible'.
     * 
     * @param visible the value of field 'visible'.
     */
    public void setVisible(
            final bean.Visible visible) {
        this._visible = visible;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.Tally
     */
    public static bean.Tally unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Tally) Unmarshaller.unmarshal(bean.Tally.class, reader);
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
