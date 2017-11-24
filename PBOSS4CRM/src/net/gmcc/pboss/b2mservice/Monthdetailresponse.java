
package net.gmcc.pboss.b2mservice;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://www.gmcc.net/pboss/B2MService/}msgrspheader"/>
 *         &lt;element name="msgbody" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="details" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="businessname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="transactor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="reward" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
    "msgrspheader",
    "msgbody"
})
@XmlRootElement(name = "monthdetailresponse")
public class Monthdetailresponse {

    @XmlElement(required = true)
    protected Msgrspheader msgrspheader;
    protected Monthdetailresponse.Msgbody msgbody;

    /**
     * Gets the value of the msgrspheader property.
     * 
     * @return
     *     possible object is
     *     {@link Msgrspheader }
     *     
     */
    public Msgrspheader getMsgrspheader() {
        return msgrspheader;
    }

    /**
     * Sets the value of the msgrspheader property.
     * 
     * @param value
     *     allowed object is
     *     {@link Msgrspheader }
     *     
     */
    public void setMsgrspheader(Msgrspheader value) {
        this.msgrspheader = value;
    }

    /**
     * Gets the value of the msgbody property.
     * 
     * @return
     *     possible object is
     *     {@link Monthdetailresponse.Msgbody }
     *     
     */
    public Monthdetailresponse.Msgbody getMsgbody() {
        return msgbody;
    }

    /**
     * Sets the value of the msgbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link Monthdetailresponse.Msgbody }
     *     
     */
    public void setMsgbody(Monthdetailresponse.Msgbody value) {
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
     *         &lt;element name="details" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="businessname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="transactor" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="reward" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "details"
    })
    public static class Msgbody {

        protected List<Monthdetailresponse.Msgbody.Details> details;

        /**
         * Gets the value of the details property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the details property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDetails().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Monthdetailresponse.Msgbody.Details }
         * 
         * 
         */
        public List<Monthdetailresponse.Msgbody.Details> getDetails() {
            if (details == null) {
                details = new ArrayList<Monthdetailresponse.Msgbody.Details>();
            }
            return this.details;
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
         *         &lt;element name="businessname" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="transactor" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="reward" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "businessname",
            "transactor",
            "reward",
            "time"
        })
        public static class Details {

            @XmlElement(required = true)
            protected String businessname;
            @XmlElement(required = true)
            protected String transactor;
            @XmlElement(required = true)
            protected String reward;
            @XmlElement(required = true)
            protected String time;

            /**
             * Gets the value of the businessname property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBusinessname() {
                return businessname;
            }

            /**
             * Sets the value of the businessname property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBusinessname(String value) {
                this.businessname = value;
            }

            /**
             * Gets the value of the transactor property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransactor() {
                return transactor;
            }

            /**
             * Sets the value of the transactor property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransactor(String value) {
                this.transactor = value;
            }

            /**
             * Gets the value of the reward property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReward() {
                return reward;
            }

            /**
             * Sets the value of the reward property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReward(String value) {
                this.reward = value;
            }

            /**
             * Gets the value of the time property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTime() {
                return time;
            }

            /**
             * Sets the value of the time property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTime(String value) {
                this.time = value;
            }

        }

    }

}
