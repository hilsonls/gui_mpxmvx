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

import bean.DataxxPhysMapInfo;

/**
 * Class DataxxPhysMapInfoDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class DataxxPhysMapInfoDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


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

    public DataxxPhysMapInfoDescriptor() {
        super();
        _xmlName = "physMapInfo";
        _elementDefinition = true;
        
        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors
        
        //-- initialize element descriptors
        
        //-- _dataxxPhysMapInfoNumIns
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.DataxxPhysMapInfoNumIns.class, "_dataxxPhysMapInfoNumIns", "numIns", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                DataxxPhysMapInfo target = (DataxxPhysMapInfo) object;
                return target.getDataxxPhysMapInfoNumIns();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    DataxxPhysMapInfo target = (DataxxPhysMapInfo) object;
                    target.setDataxxPhysMapInfoNumIns( (bean.DataxxPhysMapInfoNumIns) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.DataxxPhysMapInfoNumIns");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _dataxxPhysMapInfoNumIns
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dataxxPhysMapInfoNumOuts
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.DataxxPhysMapInfoNumOuts.class, "_dataxxPhysMapInfoNumOuts", "numOuts", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                DataxxPhysMapInfo target = (DataxxPhysMapInfo) object;
                return target.getDataxxPhysMapInfoNumOuts();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    DataxxPhysMapInfo target = (DataxxPhysMapInfo) object;
                    target.setDataxxPhysMapInfoNumOuts( (bean.DataxxPhysMapInfoNumOuts) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.DataxxPhysMapInfoNumOuts");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _dataxxPhysMapInfoNumOuts
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dataxxPhysMapInfoNumLvls
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.DataxxPhysMapInfoNumLvls.class, "_dataxxPhysMapInfoNumLvls", "numLvls", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                DataxxPhysMapInfo target = (DataxxPhysMapInfo) object;
                return target.getDataxxPhysMapInfoNumLvls();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    DataxxPhysMapInfo target = (DataxxPhysMapInfo) object;
                    target.setDataxxPhysMapInfoNumLvls( (bean.DataxxPhysMapInfoNumLvls) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.DataxxPhysMapInfoNumLvls");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _dataxxPhysMapInfoNumLvls
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dataxxPhysMapInfoNumMats
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.DataxxPhysMapInfoNumMats.class, "_dataxxPhysMapInfoNumMats", "numMats", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                DataxxPhysMapInfo target = (DataxxPhysMapInfo) object;
                return target.getDataxxPhysMapInfoNumMats();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    DataxxPhysMapInfo target = (DataxxPhysMapInfo) object;
                    target.setDataxxPhysMapInfoNumMats( (bean.DataxxPhysMapInfoNumMats) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.DataxxPhysMapInfoNumMats");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _dataxxPhysMapInfoNumMats
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dataxxPhysMapInfoNumDass
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.DataxxPhysMapInfoNumDass.class, "_dataxxPhysMapInfoNumDass", "numDass", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                DataxxPhysMapInfo target = (DataxxPhysMapInfo) object;
                return target.getDataxxPhysMapInfoNumDass();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    DataxxPhysMapInfo target = (DataxxPhysMapInfo) object;
                    target.setDataxxPhysMapInfoNumDass( (bean.DataxxPhysMapInfoNumDass) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.DataxxPhysMapInfoNumDass");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _dataxxPhysMapInfoNumDass
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
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
        return bean.DataxxPhysMapInfo.class;
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
