
package net.gmcc.pboss.comswebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rspheader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rspheader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="platform" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="process_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="req_seq" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rsp_seq" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rsp_time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="retinfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="retcode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="retmsg" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "rspheader", propOrder = {
    "platform",
    "processCode",
    "reqSeq",
    "rspSeq",
    "rspTime",
    "retinfo"
})
public class Rspheader {

    @XmlElement(required = true)
    protected String platform;
    @XmlElement(name = "process_code", required = true)
    protected String processCode;
    @XmlElement(name = "req_seq", required = true)
    protected String reqSeq;
    @XmlElement(name = "rsp_seq", required = true)
    protected String rspSeq;
    @XmlElement(name = "rsp_time", required = true)
    protected String rspTime;
    @XmlElement(required = true)
    protected Rspheader.Retinfo retinfo;

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
     * Gets the value of the rspSeq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRspSeq() {
        return rspSeq;
    }

    /**
     * Sets the value of the rspSeq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRspSeq(String value) {
        this.rspSeq = value;
    }

    /**
     * Gets the value of the rspTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRspTime() {
        return rspTime;
    }

    /**
     * Sets the value of the rspTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRspTime(String value) {
        this.rspTime = value;
    }

    /**
     * Gets the value of the retinfo property.
     * 
     * @return
     *     possible object is
     *     {@link Rspheader.Retinfo }
     *     
     */
    public Rspheader.Retinfo getRetinfo() {
        return retinfo;
    }

    /**
     * Sets the value of the retinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rspheader.Retinfo }
     *     
     */
    public void setRetinfo(Rspheader.Retinfo value) {
        this.retinfo = value;
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
     *         &lt;element name="retcode" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="retmsg" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "retcode",
        "retmsg"
    })
    public static class Retinfo {

        protected int retcode;
        @XmlElement(required = true)
        protected String retmsg;

        /**
         * Gets the value of the retcode property.
         * 
         */
        public int getRetcode() {
            return retcode;
        }

        /**
         * Sets the value of the retcode property.
         * 
         */
        public void setRetcode(int value) {
            this.retcode = value;
        }

        /**
         * Gets the value of the retmsg property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRetmsg() {
            return retmsg;
        }

        /**
         * Sets the value of the retmsg property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRetmsg(String value) {
            this.retmsg = value;
        }

    }

}
