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
 * Class ScaleTransition.
 * 
 * @version $Revision$ $Date$
 */
public class ScaleTransition implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id.
     */
    private int _id;

    /**
     * keeps track of state for field: _id
     */
    private boolean _has_id;

    /**
     * Field _transitionScale.
     */
    private bean.TransitionScale _transitionScale;

    /**
     * Field _upperExtent.
     */
    private bean.UpperExtent _upperExtent;

    /**
     * Field _lowerExtent.
     */
    private bean.LowerExtent _lowerExtent;

    /**
     * Field _units.
     */
    private bean.Units _units;

    /**
     * Field _upperNormal.
     */
    private bean.UpperNormal _upperNormal;

    /**
     * Field _lowerNormal.
     */
    private bean.LowerNormal _lowerNormal;


      //----------------/
     //- Constructors -/
    //----------------/

    public ScaleTransition() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteId(
    ) {
        this._has_id= false;
    }

    /**
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'Id'.
     */
    public int getId(
    ) {
        return this._id;
    }

    /**
     * Returns the value of field 'lowerExtent'.
     * 
     * @return the value of field 'LowerExtent'.
     */
    public bean.LowerExtent getLowerExtent(
    ) {
        return this._lowerExtent;
    }

    /**
     * Returns the value of field 'lowerNormal'.
     * 
     * @return the value of field 'LowerNormal'.
     */
    public bean.LowerNormal getLowerNormal(
    ) {
        return this._lowerNormal;
    }

    /**
     * Returns the value of field 'transitionScale'.
     * 
     * @return the value of field 'TransitionScale'.
     */
    public bean.TransitionScale getTransitionScale(
    ) {
        return this._transitionScale;
    }

    /**
     * Returns the value of field 'units'.
     * 
     * @return the value of field 'Units'.
     */
    public bean.Units getUnits(
    ) {
        return this._units;
    }

    /**
     * Returns the value of field 'upperExtent'.
     * 
     * @return the value of field 'UpperExtent'.
     */
    public bean.UpperExtent getUpperExtent(
    ) {
        return this._upperExtent;
    }

    /**
     * Returns the value of field 'upperNormal'.
     * 
     * @return the value of field 'UpperNormal'.
     */
    public bean.UpperNormal getUpperNormal(
    ) {
        return this._upperNormal;
    }

    /**
     * Method hasId.
     * 
     * @return true if at least one Id has been added
     */
    public boolean hasId(
    ) {
        return this._has_id;
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
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(
            final int id) {
        this._id = id;
        this._has_id = true;
    }

    /**
     * Sets the value of field 'lowerExtent'.
     * 
     * @param lowerExtent the value of field 'lowerExtent'.
     */
    public void setLowerExtent(
            final bean.LowerExtent lowerExtent) {
        this._lowerExtent = lowerExtent;
    }

    /**
     * Sets the value of field 'lowerNormal'.
     * 
     * @param lowerNormal the value of field 'lowerNormal'.
     */
    public void setLowerNormal(
            final bean.LowerNormal lowerNormal) {
        this._lowerNormal = lowerNormal;
    }

    /**
     * Sets the value of field 'transitionScale'.
     * 
     * @param transitionScale the value of field 'transitionScale'.
     */
    public void setTransitionScale(
            final bean.TransitionScale transitionScale) {
        this._transitionScale = transitionScale;
    }

    /**
     * Sets the value of field 'units'.
     * 
     * @param units the value of field 'units'.
     */
    public void setUnits(
            final bean.Units units) {
        this._units = units;
    }

    /**
     * Sets the value of field 'upperExtent'.
     * 
     * @param upperExtent the value of field 'upperExtent'.
     */
    public void setUpperExtent(
            final bean.UpperExtent upperExtent) {
        this._upperExtent = upperExtent;
    }

    /**
     * Sets the value of field 'upperNormal'.
     * 
     * @param upperNormal the value of field 'upperNormal'.
     */
    public void setUpperNormal(
            final bean.UpperNormal upperNormal) {
        this._upperNormal = upperNormal;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.ScaleTransition
     */
    public static bean.ScaleTransition unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.ScaleTransition) Unmarshaller.unmarshal(bean.ScaleTransition.class, reader);
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
