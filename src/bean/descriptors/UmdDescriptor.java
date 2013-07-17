/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.2</a>, using an XML
 * Schema.
 * $Id$
 */

package bean.descriptors;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import bean.Umd;

/**
 * Class UmdDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class UmdDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _elementDefinition.
     */
    private boolean _elementDefinition;

    /**
     * Field _nsPrefix.
     */
    private java.lang.String _nsPrefix;

    /**
     * Field _nsURI.
     */
    private java.lang.String _nsURI;

    /**
     * Field _xmlName.
     */
    private java.lang.String _xmlName;

    /**
     * Field _identity.
     */
    private org.exolab.castor.xml.XMLFieldDescriptor _identity;


      //----------------/
     //- Constructors -/
    //----------------/

    public UmdDescriptor() {
        super();
        _xmlName = "umd";
        _elementDefinition = true;
        
        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors
        
        //-- initialize element descriptors
        
        //-- _font
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Font.class, "_font", "font", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Umd target = (Umd) object;
                return target.getFont();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Umd target = (Umd) object;
                    target.setFont( (bean.Font) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Font");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _font
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _fontSize
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.FontSize.class, "_fontSize", "fontSize", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Umd target = (Umd) object;
                return target.getFontSize();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Umd target = (Umd) object;
                    target.setFontSize( (bean.FontSize) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.FontSize");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _fontSize
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _colour
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Colour.class, "_colour", "colour", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Umd target = (Umd) object;
                return target.getColour();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Umd target = (Umd) object;
                    target.setColour( (bean.Colour) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Colour");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _colour
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _bkcolour
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Bkcolour.class, "_bkcolour", "bkcolour", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Umd target = (Umd) object;
                return target.getBkcolour();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Umd target = (Umd) object;
                    target.setBkcolour( (bean.Bkcolour) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Bkcolour");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _bkcolour
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _umdPosition
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.UmdPosition.class, "_umdPosition", "umdPosition", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Umd target = (Umd) object;
                return target.getUmdPosition();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Umd target = (Umd) object;
                    target.setUmdPosition( (bean.UmdPosition) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.UmdPosition");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _umdPosition
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _umdSeparator
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.UmdSeparator.class, "_umdSeparator", "umdSeparator", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Umd target = (Umd) object;
                return target.getUmdSeparator();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Umd target = (Umd) object;
                    target.setUmdSeparator( (bean.UmdSeparator) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.UmdSeparator");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _umdSeparator
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _umdSeparatorColour
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.UmdSeparatorColour.class, "_umdSeparatorColour", "umdSeparatorColour", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Umd target = (Umd) object;
                return target.getUmdSeparatorColour();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Umd target = (Umd) object;
                    target.setUmdSeparatorColour( (bean.UmdSeparatorColour) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.UmdSeparatorColour");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _umdSeparatorColour
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _inside
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Inside.class, "_inside", "inside", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Umd target = (Umd) object;
                return target.getInside();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Umd target = (Umd) object;
                    target.setInside( (bean.Inside) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Inside");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _inside
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _visible
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Visible.class, "_visible", "visible", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Umd target = (Umd) object;
                return target.getVisible();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Umd target = (Umd) object;
                    target.setVisible( (bean.Visible) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Visible");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _visible
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _transparent
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Transparent.class, "_transparent", "transparent", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Umd target = (Umd) object;
                return target.getTransparent();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Umd target = (Umd) object;
                    target.setTransparent( (bean.Transparent) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Transparent");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _transparent
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _transparentLevel
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.TransparentLevel.class, "_transparentLevel", "transparentLevel", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Umd target = (Umd) object;
                return target.getTransparentLevel();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Umd target = (Umd) object;
                    target.setTransparentLevel( (bean.TransparentLevel) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.TransparentLevel");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _transparentLevel
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _umdTextList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.UmdText.class, "_umdTextList", "umdText", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Umd target = (Umd) object;
                return target.getUmdText();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Umd target = (Umd) object;
                    target.addUmdText( (bean.UmdText) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    Umd target = (Umd) object;
                    target.removeAllUmdText();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("bean.UmdText");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _umdTextList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method getAccessMode.
     * 
     * @return the access mode specified for this class.
     */
    public org.exolab.castor.mapping.AccessMode getAccessMode(
    ) {
        return null;
    }

    /**
     * Method getIdentity.
     * 
     * @return the identity field, null if this class has no
     * identity.
     */
    public org.exolab.castor.mapping.FieldDescriptor getIdentity(
    ) {
        return _identity;
    }

    /**
     * Method getJavaClass.
     * 
     * @return the Java class represented by this descriptor.
     */
    public java.lang.Class getJavaClass(
    ) {
        return bean.Umd.class;
    }

    /**
     * Method getNameSpacePrefix.
     * 
     * @return the namespace prefix to use when marshaling as XML.
     */
    public java.lang.String getNameSpacePrefix(
    ) {
        return _nsPrefix;
    }

    /**
     * Method getNameSpaceURI.
     * 
     * @return the namespace URI used when marshaling and
     * unmarshaling as XML.
     */
    public java.lang.String getNameSpaceURI(
    ) {
        return _nsURI;
    }

    /**
     * Method getValidator.
     * 
     * @return a specific validator for the class described by this
     * ClassDescriptor.
     */
    public org.exolab.castor.xml.TypeValidator getValidator(
    ) {
        return this;
    }

    /**
     * Method getXMLName.
     * 
     * @return the XML Name for the Class being described.
     */
    public java.lang.String getXMLName(
    ) {
        return _xmlName;
    }

    /**
     * Method isElementDefinition.
     * 
     * @return true if XML schema definition of this Class is that
     * of a global
     * element or element with anonymous type definition.
     */
    public boolean isElementDefinition(
    ) {
        return _elementDefinition;
    }

}
