
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
 *         &lt;element ref="{http://www.gmcc.net/pboss/B2MService/}msgrspheader"/>
 *         &lt;element name="msgbody" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="brand" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="recommender" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="transactor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="teletype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="businessid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="businessname" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "msgrspheader",
    "msgbody"
})
@XmlRootElement(name = "singlerecordresponse")
public class Singlerecordresponse {

    @XmlElement(required = true)
    protected Msgrspheader msgrspheader;
    protected Singlerecordresponse.Msgbody msgbody;

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
     *     {@link Singlerecordresponse.Msgbody }
     *     
     */
    public Singlerecordresponse.Msgbody getMsgbody() {
        return msgbody;
    }

    /**
     * Sets the value of the msgbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link Singlerecordresponse.Msgbody }
     *     
     */
    public void setMsgbody(Singlerecordresponse.Msgbody value) {
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
     *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="brand" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="recommender" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="transactor" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="teletype" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="businessid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="businessname" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "city",
        "brand",
        "recommender",
        "transactor",
        "teletype",
        "businessid",
        "businessname",
        "reward",
        "time"
    })
    public static class Msgbody {

        @XmlElement(required = true)
        protected String city;
        @XmlElement(required = true)
        protected String brand;
        @XmlElement(required = true)
        protected String recommender;
        @XmlElement(required = true)
        protected String transactor;
        @XmlElement(required = true)
        protected String teletype;
        @XmlElement(required = true)
        protected String businessid;
        @XmlElement(required = true)
        protected String businessname;
        @XmlElement(required = true)
        protected String reward;
        @XmlElement(required = true)
        protected String time;

        /**
         * Gets the value of the city property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCity() {
            return city;
        }

        /**
         * Sets the value of the city property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCity(String value) {
            this.city = value;
        }

        /**
         * Gets the value of the brand property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrand() {
            return brand;
        }

        /**
         * Sets the value of the brand property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrand(String value) {
            this.brand = value;
        }

        /**
         * Gets the value of the recommender property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRecommender() {
            return recommender;
        }

        /**
         * Sets the value of the recommender property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRecommender(String value) {
            this.recommender = value;
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
         * Gets the value of the teletype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTeletype() {
            return teletype;
        }

        /**
         * Sets the value of the teletype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTeletype(String value) {
            this.teletype = value;
        }

        /**
         * Gets the value of the businessid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBusinessid() {
            return businessid;
        }

        /**
         * Sets the value of the businessid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBusinessid(String value) {
            this.businessid = value;
        }

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
