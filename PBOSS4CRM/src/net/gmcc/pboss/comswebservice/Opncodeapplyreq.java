
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
 *         &lt;element name="reqheader" type="{http://www.gmcc.net/pboss/COMSWebService/}reqheader"/>
 *         &lt;element name="reqbody">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="cityid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="parentid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="opnname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="busibelong" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="startdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="enddate" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "reqheader",
    "reqbody"
})
@XmlRootElement(name = "opncodeapplyreq")
public class Opncodeapplyreq {

    @XmlElement(required = true)
    protected Reqheader reqheader;
    @XmlElement(required = true)
    protected Opncodeapplyreq.Reqbody reqbody;

    /**
     * Gets the value of the reqheader property.
     * 
     * @return
     *     possible object is
     *     {@link Reqheader }
     *     
     */
    public Reqheader getReqheader() {
        return reqheader;
    }

    /**
     * Sets the value of the reqheader property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reqheader }
     *     
     */
    public void setReqheader(Reqheader value) {
        this.reqheader = value;
    }

    /**
     * Gets the value of the reqbody property.
     * 
     * @return
     *     possible object is
     *     {@link Opncodeapplyreq.Reqbody }
     *     
     */
    public Opncodeapplyreq.Reqbody getReqbody() {
        return reqbody;
    }

    /**
     * Sets the value of the reqbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link Opncodeapplyreq.Reqbody }
     *     
     */
    public void setReqbody(Opncodeapplyreq.Reqbody value) {
        this.reqbody = value;
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
     *         &lt;element name="cityid" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="parentid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="opnname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="busibelong" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="startdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="enddate" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "cityid",
        "parentid",
        "opnname",
        "busibelong",
        "startdate",
        "enddate"
    })
    public static class Reqbody {

        @XmlElement(required = true)
        protected String id;
        protected int cityid;
        @XmlElement(required = true)
        protected String parentid;
        @XmlElement(required = true)
        protected String opnname;
        @XmlElement(required = true)
        protected String busibelong;
        @XmlElement(required = true)
        protected String startdate;
        @XmlElement(required = true)
        protected String enddate;

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
         * Gets the value of the cityid property.
         * 
         */
        public int getCityid() {
            return cityid;
        }

        /**
         * Sets the value of the cityid property.
         * 
         */
        public void setCityid(int value) {
            this.cityid = value;
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

        /**
         * Gets the value of the opnname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOpnname() {
            return opnname;
        }

        /**
         * Sets the value of the opnname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOpnname(String value) {
            this.opnname = value;
        }

        /**
         * Gets the value of the busibelong property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBusibelong() {
            return busibelong;
        }

        /**
         * Sets the value of the busibelong property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBusibelong(String value) {
            this.busibelong = value;
        }

        /**
         * Gets the value of the startdate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStartdate() {
            return startdate;
        }

        /**
         * Sets the value of the startdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStartdate(String value) {
            this.startdate = value;
        }

        /**
         * Gets the value of the enddate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEnddate() {
            return enddate;
        }

        /**
         * Sets the value of the enddate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEnddate(String value) {
            this.enddate = value;
        }

    }

}
