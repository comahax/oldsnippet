
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
    "msgrspheader"
})
@XmlRootElement(name = "smsbosynresponse")
public class Smsbosynresponse {

    @XmlElement(required = true)
    protected Msgrspheader msgrspheader;

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

}
