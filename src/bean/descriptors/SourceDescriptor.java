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

import bean.Source;

/**
 * Class SourceDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class SourceDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


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

    public SourceDescriptor() {
        super();
        _xmlName = "source";
        _elementDefinition = true;
        
        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors
        
        //-- _id
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.Integer.TYPE, "_id", "id", org.exolab.castor.xml.NodeType.Attribute);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                if (!target.hasId()) { return null; }
                return new java.lang.Integer(target.getId());
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    // ignore null values for non optional primitives
                    if (value == null) { return; }
                    
                    target.setId( ((java.lang.Integer) value).intValue());
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("int");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _id
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
            org.exolab.castor.xml.validators.IntValidator typeValidator;
            typeValidator = new org.exolab.castor.xml.validators.IntValidator();
            fieldValidator.setValidator(typeValidator);
            typeValidator.setMinInclusive(-2147483648);
            typeValidator.setMaxInclusive(2147483647);
        }
        desc.setValidator(fieldValidator);
        //-- initialize element descriptors
        
        //-- _username
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Username.class, "_username", "username", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getUsername();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.setUsername( (bean.Username) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Username");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _username
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _type
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Type.class, "_type", "type", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getType();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.setType( (bean.Type) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Type");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _type
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _embedded
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Embedded.class, "_embedded", "embedded", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getEmbedded();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.setEmbedded( (bean.Embedded) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Embedded");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _embedded
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _embeddedAvail
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.EmbeddedAvail.class, "_embeddedAvail", "embeddedAvail", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getEmbeddedAvail();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.setEmbeddedAvail( (bean.EmbeddedAvail) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.EmbeddedAvail");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _embeddedAvail
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _ngm
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Ngm.class, "_ngm", "ngm", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getNgm();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.setNgm( (bean.Ngm) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Ngm");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _ngm
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _ngmName
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.NgmName.class, "_ngmName", "ngmName", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getNgmName();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.setNgmName( (bean.NgmName) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.NgmName");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _ngmName
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _audioDigitalRef
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.AudioDigitalRef.class, "_audioDigitalRef", "audioDigitalRef", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getAudioDigitalRef();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.setAudioDigitalRef( (bean.AudioDigitalRef) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.AudioDigitalRef");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _audioDigitalRef
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _audio0dBRef
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Audio0dBRef.class, "_audio0dBRef", "audio0dBRef", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getAudio0dBRef();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.setAudio0dBRef( (bean.Audio0dBRef) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Audio0dBRef");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _audio0dBRef
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _alarms
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Alarms.class, "_alarms", "alarms", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getAlarms();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.setAlarms( (bean.Alarms) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Alarms");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _alarms
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _audioAlarmSettings
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.AudioAlarmSettings.class, "_audioAlarmSettings", "audioAlarmSettings", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getAudioAlarmSettings();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.setAudioAlarmSettings( (bean.AudioAlarmSettings) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.AudioAlarmSettings");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _audioAlarmSettings
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _showPhaseList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.ShowPhase.class, "_showPhaseList", "showPhase", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getShowPhase();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.addShowPhase( (bean.ShowPhase) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    Source target = (Source) object;
                    target.removeAllShowPhase();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("bean.ShowPhase");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _showPhaseList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _audioInputList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.AudioInput.class, "_audioInputList", "audioInput", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getAudioInput();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.addAudioInput( (bean.AudioInput) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    Source target = (Source) object;
                    target.removeAllAudioInput();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("bean.AudioInput");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _audioInputList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _audioPhaseList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.AudioPhase.class, "_audioPhaseList", "audioPhase", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getAudioPhase();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.addAudioPhase( (bean.AudioPhase) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    Source target = (Source) object;
                    target.removeAllAudioPhase();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("bean.AudioPhase");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _audioPhaseList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _ngmInputList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.NgmInput.class, "_ngmInputList", "ngmInput", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getNgmInput();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.addNgmInput( (bean.NgmInput) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    Source target = (Source) object;
                    target.removeAllNgmInput();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("bean.NgmInput");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _ngmInputList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _ngmPhaseList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.NgmPhase.class, "_ngmPhaseList", "ngmPhase", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getNgmPhase();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.addNgmPhase( (bean.NgmPhase) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    Source target = (Source) object;
                    target.removeAllNgmPhase();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("bean.NgmPhase");
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _ngmPhaseList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _sourceSequence
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.SourceSequence.class, "_sourceSequence", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Source target = (Source) object;
                return target.getSourceSequence();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Source target = (Source) object;
                    target.setSourceSequence( (bean.SourceSequence) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new bean.SourceSequence();
            }
        };
        desc.setSchemaType("bean.SourceSequence");
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new bean.descriptors.SourceSequenceDescriptor());
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _sourceSequence
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
        return bean.Source.class;
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
