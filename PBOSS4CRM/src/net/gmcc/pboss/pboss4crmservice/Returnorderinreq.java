
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
 *                   &lt;element name="busitype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="orderid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="bossworkfid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="orderresult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="orderresultinfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlRootElement(name = "returnorderinreq")
public class Returnorderinreq {

    @XmlElement(required = true)
    protected Msgreqheader msgreqheader;
    @XmlElement(required = true)
    protected Returnorderinreq.Msgbody msgbody;

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
     *     {@link Returnorderinreq.Msgbody }
     *     
     */
    public Returnorderinreq.Msgbody getMsgbody() {
        return msgbody;
    }

    /**
     * Sets the value of the msgbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link Returnorderinreq.Msgbody }
     *     
     */
    public void setMsgbody(Returnorderinreq.Msgbody value) {
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
     *         &lt;element name="busitype" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="orderid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="bossworkfid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="orderresult" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="orderresultinfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "busitype",
        "orderid",
        "bossworkfid",
        "orderresult",
        "orderresultinfo"
    })
    public static class Msgbody {

        @XmlElement(required = true)
        protected String busitype;
        @XmlElement(required = true)
        protected String orderid;
        protected String bossworkfid;
        @XmlElement(required = true)
        protected String orderresult;
        protected String orderresultinfo;

        /**
         * Gets the value of the busitype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBusitype() {
            return busitype;
        }

        /**
         * Sets the value of the busitype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBusitype(String value) {
            this.busitype = value;
        }

        /**
         * Gets the value of the orderid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrderid() {
            return orderid;
        }

        /**
         * Sets the value of the orderid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrderid(String value) {
            this.orderid = value;
        }

        /**
         * Gets the value of the bossworkfid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBossworkfid() {
            return bossworkfid;
        }

        /**
         * Sets the value of the bossworkfid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBossworkfid(String value) {
            this.bossworkfid = value;
        }

        /**
         * Gets the value of the orderresult property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrderresult() {
            return orderresult;
        }

        /**
         * Sets the value of the orderresult property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrderresult(String value) {
            this.orderresult = value;
        }

        /**
         * Gets the value of the orderresultinfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrderresultinfo() {
            return orderresultinfo;
        }

        /**
         * Sets the value of the orderresultinfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrderresultinfo(String value) {
            this.orderresultinfo = value;
        }

    }

}
