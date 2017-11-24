
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
 *                   &lt;element name="recommender" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlRootElement(name = "monthstatisticrequest")
public class Monthstatisticrequest {

    @XmlElement(required = true)
    protected Msgreqheader msgreqheader;
    @XmlElement(required = true)
    protected Monthstatisticrequest.Msgbody msgbody;

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
     *     {@link Monthstatisticrequest.Msgbody }
     *     
     */
    public Monthstatisticrequest.Msgbody getMsgbody() {
        return msgbody;
    }

    /**
     * Sets the value of the msgbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link Monthstatisticrequest.Msgbody }
     *     
     */
    public void setMsgbody(Monthstatisticrequest.Msgbody value) {
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
     *         &lt;element name="recommender" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "recommender",
        "month"
    })
    public static class Msgbody {

        @XmlElement(required = true)
        protected String recommender;
        @XmlElement(required = true)
        protected String month;

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
         * Gets the value of the month property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMonth() {
            return month;
        }

        /**
         * Sets the value of the month property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMonth(String value) {
            this.month = value;
        }

    }

}
