
package net.gmcc.pboss.b2mservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="platform_src" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="process_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="verify_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="req_time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="req_seq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unicontact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="testflag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="route" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="channelinfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="operatorid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="channelid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "platformSrc",
    "processCode",
    "verifyCode",
    "reqTime",
    "reqSeq",
    "unicontact",
    "testflag",
    "route",
    "channelinfo"
})
@XmlRootElement(name = "msgreqheader")
public class Msgreqheader {

    @XmlElement(name = "platform_src", required = true)
    protected String platformSrc;
    @XmlElement(name = "process_code", required = true)
    protected String processCode;
    @XmlElement(name = "verify_code")
    protected String verifyCode;
    @XmlElement(name = "req_time", required = true)
    protected String reqTime;
    @XmlElement(name = "req_seq")
    protected String reqSeq;
    protected String unicontact;
    protected String testflag;
    @XmlElement(required = true)
    protected String route;
    protected Msgreqheader.Channelinfo channelinfo;

    /**
     * Gets the value of the platformSrc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatformSrc() {
        return platformSrc;
    }

    /**
     * Sets the value of the platformSrc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatformSrc(String value) {
        this.platformSrc = value;
    }

    /**
     * Gets the value of the processCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessCode() {
        return processCode;
    }

    /**
     * Sets the value of the processCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessCode(String value) {
        this.processCode = value;
    }

    /**
     * Gets the value of the verifyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * Sets the value of the verifyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerifyCode(String value) {
        this.verifyCode = value;
    }

    /**
     * Gets the value of the reqTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqTime() {
        return reqTime;
    }

    /**
     * Sets the value of the reqTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqTime(String value) {
        this.reqTime = value;
    }

    /**
     * Gets the value of the reqSeq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqSeq() {
        return reqSeq;
    }

    /**
     * Sets the value of the reqSeq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqSeq(String value) {
        this.reqSeq = value;
    }

    /**
     * Gets the value of the unicontact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnicontact() {
        return unicontact;
    }

    /**
     * Sets the value of the unicontact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnicontact(String value) {
        this.unicontact = value;
    }

    /**
     * Gets the value of the testflag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestflag() {
        return testflag;
    }

    /**
     * Sets the value of the testflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestflag(String value) {
        this.testflag = value;
    }

    /**
     * Gets the value of the route property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoute() {
        return route;
    }

    /**
     * Sets the value of the route property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoute(String value) {
        this.route = value;
    }

    /**
     * Gets the value of the channelinfo property.
     * 
     * @return
     *     possible object is
     *     {@link Msgreqheader.Channelinfo }
     *     
     */
    public Msgreqheader.Channelinfo getChannelinfo() {
        return channelinfo;
    }

    /**
     * Sets the value of the channelinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Msgreqheader.Channelinfo }
     *     
     */
    public void setChannelinfo(Msgreqheader.Channelinfo value) {
        this.channelinfo = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="operatorid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="channelid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "operatorid",
        "channelid"
    })
    public static class Channelinfo {

        protected String operatorid;
        protected String channelid;

        /**
         * Gets the value of the operatorid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOperatorid() {
            return operatorid;
        }

        /**
         * Sets the value of the operatorid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOperatorid(String value) {
            this.operatorid = value;
        }

        /**
         * Gets the value of the channelid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getChannelid() {
            return channelid;
        }

        /**
         * Sets the value of the channelid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setChannelid(String value) {
            this.channelid = value;
        }

    }

}
