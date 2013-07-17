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

import bean.SnellRouter;

/**
 * Class SnellRouterDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class SnellRouterDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


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

    public SnellRouterDescriptor() {
        super();
        _xmlName = "snellRouter";
        _elementDefinition = true;
        
        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors
        
        //-- initialize element descriptors
        
        //-- _ipaddr
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Ipaddr.class, "_ipaddr", "ipaddr", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SnellRouter target = (SnellRouter) object;
                return target.getIpaddr();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SnellRouter target = (SnellRouter) object;
                    target.setIpaddr( (bean.Ipaddr) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Ipaddr");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _ipaddr
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _tcpPort
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.TcpPort.class, "_tcpPort", "tcpPort", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SnellRouter target = (SnellRouter) object;
                return target.getTcpPort();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SnellRouter target = (SnellRouter) object;
                    target.setTcpPort( (bean.TcpPort) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.TcpPort");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _tcpPort
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _useTcpIp
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.UseTcpIp.class, "_useTcpIp", "useTcpIp", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SnellRouter target = (SnellRouter) object;
                return target.getUseTcpIp();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SnellRouter target = (SnellRouter) object;
                    target.setUseTcpIp( (bean.UseTcpIp) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.UseTcpIp");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _useTcpIp
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _video
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Video.class, "_video", "video", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SnellRouter target = (SnellRouter) object;
                return target.getVideo();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SnellRouter target = (SnellRouter) object;
                    target.setVideo( (bean.Video) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Video");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _video
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _audioSnell
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.AudioSnell.class, "_audioSnell", "audio", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SnellRouter target = (SnellRouter) object;
                return target.getAudioSnell();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SnellRouter target = (SnellRouter) object;
                    target.setAudioSnell( (bean.AudioSnell) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.AudioSnell");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _audioSnell
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _dataxx
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Dataxx.class, "_dataxx", "dataxx", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SnellRouter target = (SnellRouter) object;
                return target.getDataxx();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SnellRouter target = (SnellRouter) object;
                    target.setDataxx( (bean.Dataxx) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Dataxx");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _dataxx
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
        return bean.SnellRouter.class;
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
