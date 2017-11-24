
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
 *         &lt;element ref="{http://www.gmcc.net/pboss/B2MService/}msgreqheader"/>
 *         &lt;element name="msgbody">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="srcseq" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ruleid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="opnid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="calcopnid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="calcmonth" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="wayid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="oprtime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="oprcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="busivalue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="rewardtype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ossrc" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "msgreqheader",
    "msgbody"
})
@XmlRootElement(name = "smsbosynrequest")
public class Smsbosynrequest {

    @XmlElement(required = true)
    protected Msgreqheader msgreqheader;
    @XmlElement(required = true)
    protected Smsbosynrequest.Msgbody msgbody;

    /**
     * Gets the value of the msgreqheader property.
     * 
     * @return
     *     possible object is
     *     {@link Msgreqheader }
     *     
     */
    public Msgreqheader getMsgreqheader() {
        return msgreqheader;
    }

    /**
     * Sets the value of the msgreqheader property.
     * 
     * @param value
     *     allowed object is
     *     {@link Msgreqheader }
     *     
     */
    public void setMsgreqheader(Msgreqheader value) {
        this.msgreqheader = value;
    }

    /**
     * Gets the value of the msgbody property.
     * 
     * @return
     *     possible object is
     *     {@link Smsbosynrequest.Msgbody }
     *     
     */
    public Smsbosynrequest.Msgbody getMsgbody() {
        return msgbody;
    }

    /**
     * Sets the value of the msgbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link Smsbosynrequest.Msgbody }
     *     
     */
    public void setMsgbody(Smsbosynrequest.Msgbody value) {
        this.msgbody = value;
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
     *         &lt;element name="srcseq" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ruleid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="opnid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="calcopnid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="calcmonth" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="wayid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="oprtime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="oprcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="busivalue" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="rewardtype" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ossrc" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "srcseq",
        "ruleid",
        "opnid",
        "calcopnid",
        "calcmonth",
        "wayid",
        "oprtime",
        "oprcode",
        "mobile",
        "busivalue",
        "rewardtype",
        "ossrc"
    })
    public static class Msgbody {

        @XmlElement(required = true)
        protected String srcseq;
        protected String ruleid;
        @XmlElement(required = true)
        protected String opnid;
        @XmlElement(required = true)
        protected String calcopnid;
        @XmlElement(required = true)
        protected String calcmonth;
        @XmlElement(required = true)
        protected String wayid;
        @XmlElement(required = true)
        protected String oprtime;
        @XmlElement(required = true)
        protected String oprcode;
        @XmlElement(required = true)
        protected String mobile;
        @XmlElement(required = true)
        protected String busivalue;
        @XmlElement(required = true)
        protected String rewardtype;
        @XmlElement(required = true)
        protected String ossrc;

        /**
         * Gets the value of the srcseq property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSrcseq() {
            return srcseq;
        }

        /**
         * Sets the value of the srcseq property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSrcseq(String value) {
            this.srcseq = value;
        }

        /**
         * Gets the value of the ruleid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRuleid() {
            return ruleid;
        }

        /**
         * Sets the value of the ruleid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRuleid(String value) {
            this.ruleid = value;
        }

        /**
         * Gets the value of the opnid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOpnid() {
            return opnid;
        }

        /**
         * Sets the value of the opnid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOpnid(String value) {
            this.opnid = value;
        }

        /**
         * Gets the value of the calcopnid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCalcopnid() {
            return calcopnid;
        }

        /**
         * Sets the value of the calcopnid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCalcopnid(String value) {
            this.calcopnid = value;
        }

        /**
         * Gets the value of the calcmonth property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCalcmonth() {
            return calcmonth;
        }

        /**
         * Sets the value of the calcmonth property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCalcmonth(String value) {
            this.calcmonth = value;
        }

        /**
         * Gets the value of the wayid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWayid() {
            return wayid;
        }

        /**
         * Sets the value of the wayid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWayid(String value) {
            this.wayid = value;
        }

        /**
         * Gets the value of the oprtime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOprtime() {
            return oprtime;
        }

        /**
         * Sets the value of the oprtime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOprtime(String value) {
            this.oprtime = value;
        }

        /**
         * Gets the value of the oprcode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOprcode() {
            return oprcode;
        }

        /**
         * Sets the value of the oprcode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOprcode(String value) {
            this.oprcode = value;
        }

        /**
         * Gets the value of the mobile property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMobile() {
            return mobile;
        }

        /**
         * Sets the value of the mobile property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMobile(String value) {
            this.mobile = value;
        }

        /**
         * Gets the value of the busivalue property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBusivalue() {
            return busivalue;
        }

        /**
         * Sets the value of the busivalue property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBusivalue(String value) {
            this.busivalue = value;
        }

        /**
         * Gets the value of the rewardtype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRewardtype() {
            return rewardtype;
        }

        /**
         * Sets the value of the rewardtype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRewardtype(String value) {
            this.rewardtype = value;
        }

        /**
         * Gets the value of the ossrc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOssrc() {
            return ossrc;
        }

        /**
         * Sets the value of the ossrc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOssrc(String value) {
            this.ossrc = value;
        }

    }

}
