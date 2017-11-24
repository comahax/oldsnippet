
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
 *                   &lt;element name="oprinfo">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="optime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="oprcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="oprtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="operid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="opername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="passchgdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="opergroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="opertype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="operlevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ismanager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="contactphone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="orgid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="isrestrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="starttime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="endtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="enablegprs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="gprsstarttime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="gprsendtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ischkmac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="mac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="createdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="statusdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="rele_staff_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="start_using_time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="end_using_time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="logintype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="smnotityflag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "msgreqheader",
    "msgbody"
})
@XmlRootElement(name = "oprsynreq")
public class Oprsynreq {

    @XmlElement(required = true)
    protected Msgreqheader msgreqheader;
    @XmlElement(required = true)
    protected Oprsynreq.Msgbody msgbody;

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
     *     {@link Oprsynreq.Msgbody }
     *     
     */
    public Oprsynreq.Msgbody getMsgbody() {
        return msgbody;
    }

    /**
     * Sets the value of the msgbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link Oprsynreq.Msgbody }
     *     
     */
    public void setMsgbody(Oprsynreq.Msgbody value) {
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
     *         &lt;element name="oprinfo">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="optime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="oprcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="oprtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="operid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="opername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="passchgdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="opergroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="opertype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="operlevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ismanager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="contactphone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="orgid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="isrestrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="starttime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="endtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="enablegprs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="gprsstarttime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="gprsendtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ischkmac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="mac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="createdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="statusdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="rele_staff_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="start_using_time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="end_using_time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="logintype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="smnotityflag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "oprinfo"
    })
    public static class Msgbody {

        @XmlElement(required = true)
        protected Oprsynreq.Msgbody.Oprinfo oprinfo;

        /**
         * Gets the value of the oprinfo property.
         * 
         * @return
         *     possible object is
         *     {@link Oprsynreq.Msgbody.Oprinfo }
         *     
         */
        public Oprsynreq.Msgbody.Oprinfo getOprinfo() {
            return oprinfo;
        }

        /**
         * Sets the value of the oprinfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link Oprsynreq.Msgbody.Oprinfo }
         *     
         */
        public void setOprinfo(Oprsynreq.Msgbody.Oprinfo value) {
            this.oprinfo = value;
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
         *         &lt;element name="optime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="oprcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="oprtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="operid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="opername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="passchgdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="opergroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="opertype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="operlevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ismanager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="contactphone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="orgid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="isrestrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="starttime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="endtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="enablegprs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="gprsstarttime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="gprsendtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ischkmac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="mac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="createdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="statusdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="rele_staff_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="start_using_time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="end_using_time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="logintype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="smnotityflag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "optime",
            "oprcode",
            "oprtype",
            "operid",
            "region",
            "opername",
            "password",
            "passchgdate",
            "opergroup",
            "opertype",
            "operlevel",
            "ismanager",
            "contactphone",
            "orgid",
            "isrestrict",
            "starttime",
            "endtime",
            "enablegprs",
            "gprsstarttime",
            "gprsendtime",
            "ischkmac",
            "mac",
            "notes",
            "createdate",
            "status",
            "statusdate",
            "releStaffId",
            "startUsingTime",
            "endUsingTime",
            "logintype",
            "smnotityflag"
        })
        public static class Oprinfo {

            protected String optime;
            protected String oprcode;
            @XmlElement(required = true)
            protected String oprtype;
            @XmlElement(required = true)
            protected String operid;
            protected String region;
            protected String opername;
            protected String password;
            protected String passchgdate;
            protected String opergroup;
            protected String opertype;
            protected String operlevel;
            protected String ismanager;
            protected String contactphone;
            protected String orgid;
            protected String isrestrict;
            protected String starttime;
            protected String endtime;
            protected String enablegprs;
            protected String gprsstarttime;
            protected String gprsendtime;
            protected String ischkmac;
            protected String mac;
            protected String notes;
            protected String createdate;
            protected String status;
            protected String statusdate;
            @XmlElement(name = "rele_staff_id")
            protected String releStaffId;
            @XmlElement(name = "start_using_time")
            protected String startUsingTime;
            @XmlElement(name = "end_using_time")
            protected String endUsingTime;
            protected String logintype;
            protected String smnotityflag;

            /**
             * Gets the value of the optime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOptime() {
                return optime;
            }

            /**
             * Sets the value of the optime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOptime(String value) {
                this.optime = value;
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
             * Gets the value of the oprtype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOprtype() {
                return oprtype;
            }

            /**
             * Sets the value of the oprtype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOprtype(String value) {
                this.oprtype = value;
            }

            /**
             * Gets the value of the operid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOperid() {
                return operid;
            }

            /**
             * Sets the value of the operid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOperid(String value) {
                this.operid = value;
            }

            /**
             * Gets the value of the region property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRegion() {
                return region;
            }

            /**
             * Sets the value of the region property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRegion(String value) {
                this.region = value;
            }

            /**
             * Gets the value of the opername property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOpername() {
                return opername;
            }

            /**
             * Sets the value of the opername property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOpername(String value) {
                this.opername = value;
            }

            /**
             * Gets the value of the password property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPassword() {
                return password;
            }

            /**
             * Sets the value of the password property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPassword(String value) {
                this.password = value;
            }

            /**
             * Gets the value of the passchgdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPasschgdate() {
                return passchgdate;
            }

            /**
             * Sets the value of the passchgdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPasschgdate(String value) {
                this.passchgdate = value;
            }

            /**
             * Gets the value of the opergroup property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOpergroup() {
                return opergroup;
            }

            /**
             * Sets the value of the opergroup property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOpergroup(String value) {
                this.opergroup = value;
            }

            /**
             * Gets the value of the opertype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOpertype() {
                return opertype;
            }

            /**
             * Sets the value of the opertype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOpertype(String value) {
                this.opertype = value;
            }

            /**
             * Gets the value of the operlevel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOperlevel() {
                return operlevel;
            }

            /**
             * Sets the value of the operlevel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOperlevel(String value) {
                this.operlevel = value;
            }

            /**
             * Gets the value of the ismanager property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIsmanager() {
                return ismanager;
            }

            /**
             * Sets the value of the ismanager property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIsmanager(String value) {
                this.ismanager = value;
            }

            /**
             * Gets the value of the contactphone property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContactphone() {
                return contactphone;
            }

            /**
             * Sets the value of the contactphone property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContactphone(String value) {
                this.contactphone = value;
            }

            /**
             * Gets the value of the orgid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOrgid() {
                return orgid;
            }

            /**
             * Sets the value of the orgid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOrgid(String value) {
                this.orgid = value;
            }

            /**
             * Gets the value of the isrestrict property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIsrestrict() {
                return isrestrict;
            }

            /**
             * Sets the value of the isrestrict property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIsrestrict(String value) {
                this.isrestrict = value;
            }

            /**
             * Gets the value of the starttime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStarttime() {
                return starttime;
            }

            /**
             * Sets the value of the starttime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStarttime(String value) {
                this.starttime = value;
            }

            /**
             * Gets the value of the endtime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEndtime() {
                return endtime;
            }

            /**
             * Sets the value of the endtime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEndtime(String value) {
                this.endtime = value;
            }

            /**
             * Gets the value of the enablegprs property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEnablegprs() {
                return enablegprs;
            }

            /**
             * Sets the value of the enablegprs property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEnablegprs(String value) {
                this.enablegprs = value;
            }

            /**
             * Gets the value of the gprsstarttime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGprsstarttime() {
                return gprsstarttime;
            }

            /**
             * Sets the value of the gprsstarttime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGprsstarttime(String value) {
                this.gprsstarttime = value;
            }

            /**
             * Gets the value of the gprsendtime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGprsendtime() {
                return gprsendtime;
            }

            /**
             * Sets the value of the gprsendtime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGprsendtime(String value) {
                this.gprsendtime = value;
            }

            /**
             * Gets the value of the ischkmac property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIschkmac() {
                return ischkmac;
            }

            /**
             * Sets the value of the ischkmac property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIschkmac(String value) {
                this.ischkmac = value;
            }

            /**
             * Gets the value of the mac property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMac() {
                return mac;
            }

            /**
             * Sets the value of the mac property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMac(String value) {
                this.mac = value;
            }

            /**
             * Gets the value of the notes property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNotes() {
                return notes;
            }

            /**
             * Sets the value of the notes property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNotes(String value) {
                this.notes = value;
            }

            /**
             * Gets the value of the createdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCreatedate() {
                return createdate;
            }

            /**
             * Sets the value of the createdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCreatedate(String value) {
                this.createdate = value;
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
             * Gets the value of the statusdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStatusdate() {
                return statusdate;
            }

            /**
             * Sets the value of the statusdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStatusdate(String value) {
                this.statusdate = value;
            }

            /**
             * Gets the value of the releStaffId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReleStaffId() {
                return releStaffId;
            }

            /**
             * Sets the value of the releStaffId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReleStaffId(String value) {
                this.releStaffId = value;
            }

            /**
             * Gets the value of the startUsingTime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStartUsingTime() {
                return startUsingTime;
            }

            /**
             * Sets the value of the startUsingTime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStartUsingTime(String value) {
                this.startUsingTime = value;
            }

            /**
             * Gets the value of the endUsingTime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEndUsingTime() {
                return endUsingTime;
            }

            /**
             * Sets the value of the endUsingTime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEndUsingTime(String value) {
                this.endUsingTime = value;
            }

            /**
             * Gets the value of the logintype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLogintype() {
                return logintype;
            }

            /**
             * Sets the value of the logintype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLogintype(String value) {
                this.logintype = value;
            }

            /**
             * Gets the value of the smnotityflag property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSmnotityflag() {
                return smnotityflag;
            }

            /**
             * Sets the value of the smnotityflag property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSmnotityflag(String value) {
                this.smnotityflag = value;
            }

        }

    }

}
