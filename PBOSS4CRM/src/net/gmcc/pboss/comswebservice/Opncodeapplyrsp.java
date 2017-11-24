
package net.gmcc.pboss.comswebservice;

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
 *         &lt;element name="rspheader" type="{http://www.gmcc.net/pboss/COMSWebService/}rspheader"/>
 *         &lt;element name="rspbody">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="opnid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="parentid" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "rspheader",
    "rspbody"
})
@XmlRootElement(name = "opncodeapplyrsp")
public class Opncodeapplyrsp {

    @XmlElement(required = true)
    protected Rspheader rspheader;
    @XmlElement(required = true)
    protected Opncodeapplyrsp.Rspbody rspbody;

    /**
     * Gets the value of the rspheader property.
     * 
     * @return
     *     possible object is
     *     {@link Rspheader }
     *     
     */
    public Rspheader getRspheader() {
        return rspheader;
    }

    /**
     * Sets the value of the rspheader property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rspheader }
     *     
     */
    public void setRspheader(Rspheader value) {
        this.rspheader = value;
    }

    /**
     * Gets the value of the rspbody property.
     * 
     * @return
     *     possible object is
     *     {@link Opncodeapplyrsp.Rspbody }
     *     
     */
    public Opncodeapplyrsp.Rspbody getRspbody() {
        return rspbody;
    }

    /**
     * Sets the value of the rspbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link Opncodeapplyrsp.Rspbody }
     *     
     */
    public void setRspbody(Opncodeapplyrsp.Rspbody value) {
        this.rspbody = value;
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
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="opnid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="parentid" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "id",
        "state",
        "opnid",
        "parentid"
    })
    public static class Rspbody {

        @XmlElement(required = true)
        protected String id;
        protected int state;
        protected String opnid;
        @XmlElement(required = true)
        protected String parentid;

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

        /**
         * Gets the value of the state property.
         * 
         */
        public int getState() {
            return state;
        }

        /**
         * Sets the value of the state property.
         * 
         */
        public void setState(int value) {
            this.state = value;
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
         * Gets the value of the parentid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getParentid() {
            return parentid;
        }

        /**
         * Sets the value of the parentid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setParentid(String value) {
            this.parentid = value;
        }

    }

}
