
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
 *                   &lt;element name="reward" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlRootElement(name = "sumstatisticresponse")
public class Sumstatisticresponse {

    @XmlElement(required = true)
    protected Msgrspheader msgrspheader;
    protected Sumstatisticresponse.Msgbody msgbody;

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
     *     {@link Sumstatisticresponse.Msgbody }
     *     
     */
    public Sumstatisticresponse.Msgbody getMsgbody() {
        return msgbody;
    }

    /**
     * Sets the value of the msgbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sumstatisticresponse.Msgbody }
     *     
     */
    public void setMsgbody(Sumstatisticresponse.Msgbody value) {
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
     *         &lt;element name="reward" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "reward"
    })
    public static class Msgbody {

        @XmlElement(required = true)
        protected String reward;

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

    }

}
