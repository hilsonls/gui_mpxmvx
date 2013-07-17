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
 * Class Umd.
 * 
 * @version $Revision$ $Date$
 */
public class Umd implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _font.
     */
    private bean.Font _font;

    /**
     * Field _fontSize.
     */
    private bean.FontSize _fontSize;

    /**
     * Field _colour.
     */
    private bean.Colour _colour;

    /**
     * Field _bkcolour.
     */
    private bean.Bkcolour _bkcolour;

    /**
     * Field _umdPosition.
     */
    private bean.UmdPosition _umdPosition;

    /**
     * Field _umdSeparator.
     */
    private bean.UmdSeparator _umdSeparator;

    /**
     * Field _umdSeparatorColour.
     */
    private bean.UmdSeparatorColour _umdSeparatorColour;

    /**
     * Field _inside.
     */
    private bean.Inside _inside;

    /**
     * Field _visible.
     */
    private bean.Visible _visible;

    /**
     * Field _transparent.
     */
    private bean.Transparent _transparent;

    /**
     * Field _transparentLevel.
     */
    private bean.TransparentLevel _transparentLevel;

    /**
     * Field _umdTextList.
     */
    private java.util.List _umdTextList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Umd() {
        super();
        this._umdTextList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUmdText
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUmdText(
            final bean.UmdText vUmdText)
    throws java.lang.IndexOutOfBoundsException {
        this._umdTextList.add(vUmdText);
    }

    /**
     * 
     * 
     * @param index
     * @param vUmdText
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUmdText(
            final int index,
            final bean.UmdText vUmdText)
    throws java.lang.IndexOutOfBoundsException {
        this._umdTextList.add(index, vUmdText);
    }

    /**
     * Method enumerateUmdText.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateUmdText(
    ) {
        return java.util.Collections.enumeration(this._umdTextList);
    }

    /**
     * Returns the value of field 'bkcolour'.
     * 
     * @return the value of field 'Bkcolour'.
     */
    public bean.Bkcolour getBkcolour(
    ) {
        return this._bkcolour;
    }

    /**
     * Returns the value of field 'colour'.
     * 
     * @return the value of field 'Colour'.
     */
    public bean.Colour getColour(
    ) {
        return this._colour;
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
     * Returns the value of field 'inside'.
     * 
     * @return the value of field 'Inside'.
     */
    public bean.Inside getInside(
    ) {
        return this._inside;
    }

    /**
     * Returns the value of field 'transparent'.
     * 
     * @return the value of field 'Transparent'.
     */
    public bean.Transparent getTransparent(
    ) {
        return this._transparent;
    }

    /**
     * Returns the value of field 'transparentLevel'.
     * 
     * @return the value of field 'TransparentLevel'.
     */
    public bean.TransparentLevel getTransparentLevel(
    ) {
        return this._transparentLevel;
    }

    /**
     * Returns the value of field 'umdPosition'.
     * 
     * @return the value of field 'UmdPosition'.
     */
    public bean.UmdPosition getUmdPosition(
    ) {
        return this._umdPosition;
    }

    /**
     * Returns the value of field 'umdSeparator'.
     * 
     * @return the value of field 'UmdSeparator'.
     */
    public bean.UmdSeparator getUmdSeparator(
    ) {
        return this._umdSeparator;
    }

    /**
     * Returns the value of field 'umdSeparatorColour'.
     * 
     * @return the value of field 'UmdSeparatorColour'.
     */
    public bean.UmdSeparatorColour getUmdSeparatorColour(
    ) {
        return this._umdSeparatorColour;
    }

    /**
     * Method getUmdText.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.UmdText at the given index
     */
    public bean.UmdText getUmdText(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._umdTextList.size()) {
            throw new IndexOutOfBoundsException("getUmdText: Index value '" + index + "' not in range [0.." + (this._umdTextList.size() - 1) + "]");
        }
        
        return (bean.UmdText) _umdTextList.get(index);
    }

    /**
     * Method getUmdText.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.UmdText[] getUmdText(
    ) {
        bean.UmdText[] array = new bean.UmdText[0];
        return (bean.UmdText[]) this._umdTextList.toArray(array);
    }

    /**
     * Method getUmdTextCount.
     * 
     * @return the size of this collection
     */
    public int getUmdTextCount(
    ) {
        return this._umdTextList.size();
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
     * Method iterateUmdText.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateUmdText(
    ) {
        return this._umdTextList.iterator();
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
    public void removeAllUmdText(
    ) {
        this._umdTextList.clear();
    }

    /**
     * Method removeUmdText.
     * 
     * @param vUmdText
     * @return true if the object was removed from the collection.
     */
    public boolean removeUmdText(
            final bean.UmdText vUmdText) {
        boolean removed = _umdTextList.remove(vUmdText);
        return removed;
    }

    /**
     * Method removeUmdTextAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.UmdText removeUmdTextAt(
            final int index) {
        java.lang.Object obj = this._umdTextList.remove(index);
        return (bean.UmdText) obj;
    }

    /**
     * Sets the value of field 'bkcolour'.
     * 
     * @param bkcolour the value of field 'bkcolour'.
     */
    public void setBkcolour(
            final bean.Bkcolour bkcolour) {
        this._bkcolour = bkcolour;
    }

    /**
     * Sets the value of field 'colour'.
     * 
     * @param colour the value of field 'colour'.
     */
    public void setColour(
            final bean.Colour colour) {
        this._colour = colour;
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
     * Sets the value of field 'inside'.
     * 
     * @param inside the value of field 'inside'.
     */
    public void setInside(
            final bean.Inside inside) {
        this._inside = inside;
    }

    /**
     * Sets the value of field 'transparent'.
     * 
     * @param transparent the value of field 'transparent'.
     */
    public void setTransparent(
            final bean.Transparent transparent) {
        this._transparent = transparent;
    }

    /**
     * Sets the value of field 'transparentLevel'.
     * 
     * @param transparentLevel the value of field 'transparentLevel'
     */
    public void setTransparentLevel(
            final bean.TransparentLevel transparentLevel) {
        this._transparentLevel = transparentLevel;
    }

    /**
     * Sets the value of field 'umdPosition'.
     * 
     * @param umdPosition the value of field 'umdPosition'.
     */
    public void setUmdPosition(
            final bean.UmdPosition umdPosition) {
        this._umdPosition = umdPosition;
    }

    /**
     * Sets the value of field 'umdSeparator'.
     * 
     * @param umdSeparator the value of field 'umdSeparator'.
     */
    public void setUmdSeparator(
            final bean.UmdSeparator umdSeparator) {
        this._umdSeparator = umdSeparator;
    }

    /**
     * Sets the value of field 'umdSeparatorColour'.
     * 
     * @param umdSeparatorColour the value of field
     * 'umdSeparatorColour'.
     */
    public void setUmdSeparatorColour(
            final bean.UmdSeparatorColour umdSeparatorColour) {
        this._umdSeparatorColour = umdSeparatorColour;
    }

    /**
     * 
     * 
     * @param index
     * @param vUmdText
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUmdText(
            final int index,
            final bean.UmdText vUmdText)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._umdTextList.size()) {
            throw new IndexOutOfBoundsException("setUmdText: Index value '" + index + "' not in range [0.." + (this._umdTextList.size() - 1) + "]");
        }
        
        this._umdTextList.set(index, vUmdText);
    }

    /**
     * 
     * 
     * @param vUmdTextArray
     */
    public void setUmdText(
            final bean.UmdText[] vUmdTextArray) {
        //-- copy array
        _umdTextList.clear();
        
        for (int i = 0; i < vUmdTextArray.length; i++) {
                this._umdTextList.add(vUmdTextArray[i]);
        }
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
     * @return the unmarshaled bean.Umd
     */
    public static bean.Umd unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.Umd) Unmarshaller.unmarshal(bean.Umd.class, reader);
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
