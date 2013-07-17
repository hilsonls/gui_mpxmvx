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
 * Class VideoCards.
 * 
 * @version $Revision$ $Date$
 */
public class VideoCards implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _cardList.
     */
    private java.util.List _cardList;


      //----------------/
     //- Constructors -/
    //----------------/

    public VideoCards() {
        super();
        this._cardList = new java.util.ArrayList();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCard
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCard(
            final bean.Card vCard)
    throws java.lang.IndexOutOfBoundsException {
        this._cardList.add(vCard);
    }

    /**
     * 
     * 
     * @param index
     * @param vCard
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCard(
            final int index,
            final bean.Card vCard)
    throws java.lang.IndexOutOfBoundsException {
        this._cardList.add(index, vCard);
    }

    /**
     * Method enumerateCard.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration enumerateCard(
    ) {
        return java.util.Collections.enumeration(this._cardList);
    }

    /**
     * Method getCard.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the bean.Card at the given index
     */
    public bean.Card getCard(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._cardList.size()) {
            throw new IndexOutOfBoundsException("getCard: Index value '" + index + "' not in range [0.." + (this._cardList.size() - 1) + "]");
        }
        
        return (bean.Card) _cardList.get(index);
    }

    /**
     * Method getCard.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public bean.Card[] getCard(
    ) {
        bean.Card[] array = new bean.Card[0];
        return (bean.Card[]) this._cardList.toArray(array);
    }

    /**
     * Method getCardCount.
     * 
     * @return the size of this collection
     */
    public int getCardCount(
    ) {
        return this._cardList.size();
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
     * Method iterateCard.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator iterateCard(
    ) {
        return this._cardList.iterator();
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
    public void removeAllCard(
    ) {
        this._cardList.clear();
    }

    /**
     * Method removeCard.
     * 
     * @param vCard
     * @return true if the object was removed from the collection.
     */
    public boolean removeCard(
            final bean.Card vCard) {
        boolean removed = _cardList.remove(vCard);
        return removed;
    }

    /**
     * Method removeCardAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public bean.Card removeCardAt(
            final int index) {
        java.lang.Object obj = this._cardList.remove(index);
        return (bean.Card) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCard
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCard(
            final int index,
            final bean.Card vCard)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._cardList.size()) {
            throw new IndexOutOfBoundsException("setCard: Index value '" + index + "' not in range [0.." + (this._cardList.size() - 1) + "]");
        }
        
        this._cardList.set(index, vCard);
    }

    /**
     * 
     * 
     * @param vCardArray
     */
    public void setCard(
            final bean.Card[] vCardArray) {
        //-- copy array
        _cardList.clear();
        
        for (int i = 0; i < vCardArray.length; i++) {
                this._cardList.add(vCardArray[i]);
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
     * @return the unmarshaled bean.VideoCards
     */
    public static bean.VideoCards unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.VideoCards) Unmarshaller.unmarshal(bean.VideoCards.class, reader);
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
