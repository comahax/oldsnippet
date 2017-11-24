
package net.gmcc.pboss.pboss4crmservice;

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
 *         &lt;element ref="{http://www.gmcc.net/pboss/PBOSS4CRMService/}msgreqheader"/>
 *         &lt;element name="msgbody">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mobileno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="companycode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="commissionercode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="agentcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="staffname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="staffcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="personid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="registerdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="enabledate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="stopdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="oercode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="istenseed" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="isinternal" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlRootElement(name = "modifypromcomminforeq")
public class Modifypromcomminforeq {

    @XmlElement(required = true)
    protected Msgreqheader msgreqheader;
    @XmlElement(required = true)
    protected Modifypromcomminforeq.Msgbody msgbody;

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
     *     {@link Modifypromcomminforeq.Msgbody }
     *     
     */
    public Modifypromcomminforeq.Msgbody getMsgbody() {
        return msgbody;
    }

    /**
     * Sets the value of the msgbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link Modifypromcomminforeq.Msgbody }
     *     
     */
    public void setMsgbody(Modifypromcomminforeq.Msgbody value) {
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
     *         &lt;element name="mobileno" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="companycode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="commissionercode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="agentcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="staffname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="staffcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="personid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="registerdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="enabledate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="stopdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="oercode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="istenseed" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="isinternal" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "mobileno",
        "companycode",
        "commissionercode",
        "agentcode",
        "staffname",
        "staffcode",
        "personid",
        "email",
        "registerdate",
        "enabledate",
        "stopdate",
        "status",
        "oercode",
        "istenseed",
        "isinternal"
    })
    public static class Msgbody {

        @XmlElement(required = true)
        protected String mobileno;
        protected String companycode;
        protected String commissionercode;
        @XmlElement(required = true)
        protected String agentcode;
        @XmlElement(required = true)
        protected String staffname;
        @XmlElement(required = true)
        protected String staffcode;
        protected String personid;
        protected String email;
        @XmlElement(required = true)
        protected String registerdate;
        @XmlElement(required = true)
        protected String enabledate;
        @XmlElement(required = true)
        protected String stopdate;
        @XmlElement(required = true)
        protected String status;
        @XmlElement(required = true)
        protected String oercode;
        protected String istenseed;
        protected String isinternal;

        /**
         * Gets the value of the mobileno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMobileno() {
            return mobileno;
        }

        /**
         * Sets the value of the mobileno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMobileno(String value) {
            this.mobileno = value;
        }

        /**
         * Gets the value of the companycode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCompanycode() {
            return companycode;
        }

        /**
         * Sets the value of the companycode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCompanycode(String value) {
            this.companycode = value;
        }

        /**
         * Gets the value of the commissionercode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCommissionercode() {
            return commissionercode;
        }

        /**
         * Sets the value of the commissionercode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCommissionercode(String value) {
            this.commissionercode = value;
        }

        /**
         * Gets the value of the agentcode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAgentcode() {
            return agentcode;
        }

        /**
         * Sets the value of the agentcode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAgentcode(String value) {
            this.agentcode = value;
        }

        /**
         * Gets the value of the staffname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStaffname() {
            return staffname;
        }

        /**
         * Sets the value of the staffname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStaffname(String value) {
            this.staffname = value;
        }

        /**
         * Gets the value of the staffcode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStaffcode() {
            return staffcode;
        }

        /**
         * Sets the value of the staffcode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStaffcode(String value) {
            this.staffcode = value;
        }

        /**
         * Gets the value of the personid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPersonid() {
            return personid;
        }

        /**
         * Sets the value of the personid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPersonid(String value) {
            this.personid = value;
        }

        /**
         * Gets the value of the email property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEmail() {
            return email;
        }

        /**
         * Sets the value of the email property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEmail(String value) {
            this.email = value;
        }

        /**
         * Gets the value of the registerdate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRegisterdate() {
            return registerdate;
        }

        /**
         * Sets the value of the registerdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRegisterdate(String value) {
            this.registerdate = value;
        }

        /**
         * Gets the value of the enabledate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEnabledate() {
            return enabledate;
        }

        /**
         * Sets the value of the enabledate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEnabledate(String value) {
            this.enabledate = value;
        }

        /**
         * Gets the value of the stopdate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStopdate() {
            return stopdate;
        }

        /**
         * Sets the value of the stopdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStopdate(String value) {
            this.stopdate = value;
        }

        /**
         * Gets the value of the status property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatus(String value) {
            this.status = value;
        }

        /**
         * Gets the value of the oercode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOercode() {
            return oercode;
        }

        /**
         * Sets the value of the oercode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOercode(String value) {
            this.oercode = value;
        }

        /**
         * Gets the value of the istenseed property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIstenseed() {
            return istenseed;
        }

        /**
         * Sets the value of the istenseed property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIstenseed(String value) {
            this.istenseed = value;
        }

        /**
         * Gets the value of the isinternal property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIsinternal() {
            return isinternal;
        }

        /**
         * Sets the value of the isinternal property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIsinternal(String value) {
            this.isinternal = value;
        }

    }

}
