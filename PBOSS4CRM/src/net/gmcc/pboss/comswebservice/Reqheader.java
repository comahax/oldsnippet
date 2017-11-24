
package net.gmcc.pboss.comswebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reqheader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reqheader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="platform" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="process_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="req_seq" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="req_time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="testflag" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="verify_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reqheader", propOrder = {
    "platform",
    "processCode",
    "reqSeq",
    "reqTime",
    "testflag",
    "verifyCode"
})
public class Reqheader {

    @XmlElement(required = true)
    protected String platform;
    @XmlElement(name = "process_code", required = true)
    protected String processCode;
    @XmlElement(name = "req_seq", required = true)
    protected String reqSeq;
    @XmlElement(name = "req_time", required = true)
    protected String reqTime;
    protected Integer testflag;
    @XmlElement(name = "verify_code")
    protected String verifyCode;

    /**
     * Gets the value of the platform property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the value of the platform property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatform(String value) {
        this.platform = value;
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
     * Gets the value of the testflag property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTestflag() {
        return testflag;
    }

    /**
     * Sets the value of the testflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTestflag(Integer value) {
        this.testflag = value;
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

}
