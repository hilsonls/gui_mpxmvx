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
 * Class TextProperties.
 * 
 * @version $Revision$ $Date$
 */
public class TextProperties implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _alignment.
     */
    private bean.Alignment _alignment;

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
     * Field _lineList.
     */
    private java.util.List _lineList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TextProperties() {
        super();
        this._lineList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vLine
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLine(
            final bean.Line vLine)
    throws java.lang.IndexOutOfBoundsException {
        this._lineList.add(vLine);
    }

    /**
     * 
     * 
     * @param index
     * @param vLine
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLine(
            final int index,
            final bean.Line vLine)
    throws java.lang.IndexOutOfBoundsException {
        this._lineList.add(index, vLine);
    }

    /**
     * Method enumerateLine.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateLine(
    ) {
        return java.util.Collections.enumeration(this._lineList);
    }

    /**
     * Returns the value of field 'alignment'.
     * 
     * @return the value of field 'Alignment'.
     */
    public bean.Alignment getAlignment(
    ) {
        return this._alignment;
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
     * Method getLine.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Line at the given index
     */
    public bean.Line getLine(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._lineList.size()) {
            throw new IndexOutOfBoundsException("getLine: Index value '" + index + "' not in range [0.." + (this._lineList.size() - 1) + "]");
        }
        
        return (bean.Line) _lineList.get(index);
    }

    /**
     * Method getLine.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Line[] getLine(
    ) {
        bean.Line[] array = new bean.Line[0];
        return (bean.Line[]) this._lineList.toArray(array);
    }

    /**
     * Method getLineCount.
     * 
     * @return the size of this collection
     */
    public int getLineCount(
    ) {
        return this._lineList.size();
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
     * Method iterateLine.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateLine(
    ) {
        return this._lineList.iterator();
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
    public void removeAllLine(
    ) {
        this._lineList.clear();
    }

    /**
     * Method removeLine.
     * 
     * @param vLine
     * @return true if the object was removed from the collection.
     */
    public boolean removeLine(
            final bean.Line vLine) {
        boolean removed = _lineList.remove(vLine);
        return removed;
    }

    /**
     * Method removeLineAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Line removeLineAt(
            final int index) {
        java.lang.Object obj = this._lineList.remove(index);
        return (bean.Line) obj;
    }

    /**
     * Sets the value of field 'alignment'.
     * 
     * @param alignment the value of field 'alignment'.
     */
    public void setAlignment(
            final bean.Alignment alignment) {
        this._alignment = alignment;
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
     * 
     * 
     * @param index
     * @param vLine
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setLine(
            final int index,
            final bean.Line vLine)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._lineList.size()) {
            throw new IndexOutOfBoundsException("setLine: Index value '" + index + "' not in range [0.." + (this._lineList.size() - 1) + "]");
        }
        
        this._lineList.set(index, vLine);
    }

    /**
     * 
     * 
     * @param vLineArray
     */
    public void setLine(
            final bean.Line[] vLineArray) {
        //-- copy array
        _lineList.clear();
        
        for (int i = 0; i < vLineArray.length; i++) {
                this._lineList.add(vLineArray[i]);
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
     * @return the unmarshaled bean.TextProperties
     */
    public static bean.TextProperties unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.TextProperties) Unmarshaller.unmarshal(bean.TextProperties.class, reader);
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
