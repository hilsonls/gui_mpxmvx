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
 * Class SnellRouter.
 * 
 * @version $Revision$ $Date$
 */
public class SnellRouter implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ipaddr.
     */
    private bean.Ipaddr _ipaddr;

    /**
     * Field _tcpPort.
     */
    private bean.TcpPort _tcpPort;

    /**
     * Field _useTcpIp.
     */
    private bean.UseTcpIp _useTcpIp;

    /**
     * Field _video.
     */
    private bean.Video _video;

    /**
     * Field _audioSnell.
     */
    private bean.AudioSnell _audioSnell;

    /**
     * Field _dataxx.
     */
    private bean.Dataxx _dataxx;


      //----------------/
     //- Constructors -/
    //----------------/

    public SnellRouter() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'audioSnell'.
     * 
     * @return the value of field 'AudioSnell'.
     */
    public bean.AudioSnell getAudioSnell(
    ) {
        return this._audioSnell;
    }

    /**
     * Returns the value of field 'dataxx'.
     * 
     * @return the value of field 'Dataxx'.
     */
    public bean.Dataxx getDataxx(
    ) {
        return this._dataxx;
    }

    /**
     * Returns the value of field 'ipaddr'.
     * 
     * @return the value of field 'Ipaddr'.
     */
    public bean.Ipaddr getIpaddr(
    ) {
        return this._ipaddr;
    }

    /**
     * Returns the value of field 'tcpPort'.
     * 
     * @return the value of field 'TcpPort'.
     */
    public bean.TcpPort getTcpPort(
    ) {
        return this._tcpPort;
    }

    /**
     * Returns the value of field 'useTcpIp'.
     * 
     * @return the value of field 'UseTcpIp'.
     */
    public bean.UseTcpIp getUseTcpIp(
    ) {
        return this._useTcpIp;
    }

    /**
     * Returns the value of field 'video'.
     * 
     * @return the value of field 'Video'.
     */
    public bean.Video getVideo(
    ) {
        return this._video;
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
     * Sets the value of field 'audioSnell'.
     * 
     * @param audioSnell the value of field 'audioSnell'.
     */
    public void setAudioSnell(
            final bean.AudioSnell audioSnell) {
        this._audioSnell = audioSnell;
    }

    /**
     * Sets the value of field 'dataxx'.
     * 
     * @param dataxx the value of field 'dataxx'.
     */
    public void setDataxx(
            final bean.Dataxx dataxx) {
        this._dataxx = dataxx;
    }

    /**
     * Sets the value of field 'ipaddr'.
     * 
     * @param ipaddr the value of field 'ipaddr'.
     */
    public void setIpaddr(
            final bean.Ipaddr ipaddr) {
        this._ipaddr = ipaddr;
    }

    /**
     * Sets the value of field 'tcpPort'.
     * 
     * @param tcpPort the value of field 'tcpPort'.
     */
    public void setTcpPort(
            final bean.TcpPort tcpPort) {
        this._tcpPort = tcpPort;
    }

    /**
     * Sets the value of field 'useTcpIp'.
     * 
     * @param useTcpIp the value of field 'useTcpIp'.
     */
    public void setUseTcpIp(
            final bean.UseTcpIp useTcpIp) {
        this._useTcpIp = useTcpIp;
    }

    /**
     * Sets the value of field 'video'.
     * 
     * @param video the value of field 'video'.
     */
    public void setVideo(
            final bean.Video video) {
        this._video = video;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled bean.SnellRouter
     */
    public static bean.SnellRouter unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (bean.SnellRouter) Unmarshaller.unmarshal(bean.SnellRouter.class, reader);
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
