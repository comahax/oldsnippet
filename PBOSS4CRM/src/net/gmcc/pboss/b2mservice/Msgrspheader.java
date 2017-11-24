
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
 *         &lt;element name="resp_time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sequence" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="req_seq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="operation_seq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="retinfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="retcode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="rettype" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "", propOrder = {
    "platformSrc",
    "processCode",
    "verifyCode",
    "respTime",
    "sequence",
    "retinfo"
})
@XmlRootElement(name = "msgrspheader")
public class Msgrspheader {

    @XmlElement(name = "platform_src", required = true)
    protected String platformSrc;
    @XmlElement(name = "process_code", required = true)
    protected String processCode;
    @XmlElement(name = "verify_code")
    protected String verifyCode;
    @XmlElement(name = "resp_time", required = true)
    protected String respTime;
    protected Msgrspheader.Sequence sequence;
    @XmlElement(required = true)
    protected Msgrspheader.Retinfo retinfo;

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
     * Gets the value of the respTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespTime() {
        return respTime;
    }

    /**
     * Sets the value of the respTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespTime(String value) {
        this.respTime = value;
    }

    /**
     * Gets the value of the sequence property.
     * 
     * @return
     *     possible object is
     *     {@link Msgrspheader.Sequence }
     *     
     */
    public Msgrspheader.Sequence getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Msgrspheader.Sequence }
     *     
     */
    public void setSequence(Msgrspheader.Sequence value) {
        this.sequence = value;
    }

    /**
     * Gets the value of the retinfo property.
     * 
     * @return
     *     possible object is
     *     {@link Msgrspheader.Retinfo }
     *     
     */
    public Msgrspheader.Retinfo getRetinfo() {
        return retinfo;
    }

    /**
     * Sets the value of the retinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Msgrspheader.Retinfo }
     *     
     */
    public void setRetinfo(Msgrspheader.Retinfo value) {
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
     *         &lt;element name="rettype" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
        "rettype",
        "retmsg"
    })
    public static class Retinfo {

        protected int retcode;
        protected int rettype;
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
         * Gets the value of the rettype property.
         * 
         */
        public int getRettype() {
            return rettype;
        }

        /**
         * Sets the value of the rettype property.
         * 
         */
        public void setRettype(int value) {
            this.rettype = value;
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
     *         &lt;element name="req_seq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="operation_seq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "reqSeq",
        "operationSeq"
    })
    public static class Sequence {

        @XmlElement(name = "req_seq")
        protected String reqSeq;
        @XmlElement(name = "operation_seq")
        protected String operationSeq;

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
         * Gets the value of the operationSeq property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOperationSeq() {
            return operationSeq;
        }

        /**
         * Sets the value of the operationSeq property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOperationSeq(String value) {
            this.operationSeq = value;
        }

    }

}
