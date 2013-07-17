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

import bean.AudioPhysMapInfo;

/**
 * Class AudioPhysMapInfoDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class AudioPhysMapInfoDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


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

    public AudioPhysMapInfoDescriptor() {
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
        
        //-- _audioPhysMapInfoNumIns
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.AudioPhysMapInfoNumIns.class, "_audioPhysMapInfoNumIns", "numIns", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                AudioPhysMapInfo target = (AudioPhysMapInfo) object;
                return target.getAudioPhysMapInfoNumIns();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    AudioPhysMapInfo target = (AudioPhysMapInfo) object;
                    target.setAudioPhysMapInfoNumIns( (bean.AudioPhysMapInfoNumIns) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.AudioPhysMapInfoNumIns");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _audioPhysMapInfoNumIns
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _audioPhysMapInfoNumOuts
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.AudioPhysMapInfoNumOuts.class, "_audioPhysMapInfoNumOuts", "numOuts", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                AudioPhysMapInfo target = (AudioPhysMapInfo) object;
                return target.getAudioPhysMapInfoNumOuts();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    AudioPhysMapInfo target = (AudioPhysMapInfo) object;
                    target.setAudioPhysMapInfoNumOuts( (bean.AudioPhysMapInfoNumOuts) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.AudioPhysMapInfoNumOuts");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _audioPhysMapInfoNumOuts
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _audioPhysMapInfoNumLvls
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.AudioPhysMapInfoNumLvls.class, "_audioPhysMapInfoNumLvls", "numLvls", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                AudioPhysMapInfo target = (AudioPhysMapInfo) object;
                return target.getAudioPhysMapInfoNumLvls();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    AudioPhysMapInfo target = (AudioPhysMapInfo) object;
                    target.setAudioPhysMapInfoNumLvls( (bean.AudioPhysMapInfoNumLvls) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.AudioPhysMapInfoNumLvls");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _audioPhysMapInfoNumLvls
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _audioPhysMapInfoNumMats
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.AudioPhysMapInfoNumMats.class, "_audioPhysMapInfoNumMats", "numMats", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                AudioPhysMapInfo target = (AudioPhysMapInfo) object;
                return target.getAudioPhysMapInfoNumMats();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    AudioPhysMapInfo target = (AudioPhysMapInfo) object;
                    target.setAudioPhysMapInfoNumMats( (bean.AudioPhysMapInfoNumMats) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.AudioPhysMapInfoNumMats");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _audioPhysMapInfoNumMats
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _audioPhysMapInfoNumDass
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.AudioPhysMapInfoNumDass.class, "_audioPhysMapInfoNumDass", "numDass", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                AudioPhysMapInfo target = (AudioPhysMapInfo) object;
                return target.getAudioPhysMapInfoNumDass();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    AudioPhysMapInfo target = (AudioPhysMapInfo) object;
                    target.setAudioPhysMapInfoNumDass( (bean.AudioPhysMapInfoNumDass) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.AudioPhysMapInfoNumDass");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _audioPhysMapInfoNumDass
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
        return bean.AudioPhysMapInfo.class;
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
