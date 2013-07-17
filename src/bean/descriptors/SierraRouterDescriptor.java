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

import bean.SierraRouter;

/**
 * Class SierraRouterDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class SierraRouterDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


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

    public SierraRouterDescriptor() {
        super();
        _xmlName = "sierraRouter";
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
                SierraRouter target = (SierraRouter) object;
                return target.getIpaddr();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SierraRouter target = (SierraRouter) object;
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
                SierraRouter target = (SierraRouter) object;
                return target.getTcpPort();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SierraRouter target = (SierraRouter) object;
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
        //-- _enabled
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.Enabled.class, "_enabled", "enabled", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SierraRouter target = (SierraRouter) object;
                return target.getEnabled();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SierraRouter target = (SierraRouter) object;
                    target.setEnabled( (bean.Enabled) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.Enabled");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _enabled
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _physMapInfo
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.PhysMapInfo.class, "_physMapInfo", "physMapInfo", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SierraRouter target = (SierraRouter) object;
                return target.getPhysMapInfo();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SierraRouter target = (SierraRouter) object;
                    target.setPhysMapInfo( (bean.PhysMapInfo) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.PhysMapInfo");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _physMapInfo
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _physIns
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(bean.PhysIns.class, "_physIns", "physIns", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                SierraRouter target = (SierraRouter) object;
                return target.getPhysIns();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    SierraRouter target = (SierraRouter) object;
                    target.setPhysIns( (bean.PhysIns) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("bean.PhysIns");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);
        
        //-- validation code for: _physIns
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
        return bean.SierraRouter.class;
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
