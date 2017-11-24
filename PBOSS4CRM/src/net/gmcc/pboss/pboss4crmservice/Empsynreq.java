
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
 *                   &lt;element name="empinfo">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="oprtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="employeeid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="oprcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="employeename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="edulevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nativehome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="polivisage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="servoffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="station" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="joblevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="intime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="worktime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="hereworktime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="employtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="officetel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="outtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="outresult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="homeaddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="cardid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="wayid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="waytype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="pvtemail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ofcphone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ofcemail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="speciality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="cityid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="countyid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="svccode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="posittype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="contacttype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="empstatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="actbank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="actno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="actname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="actpid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="bail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="gradschool" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="gradtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ismarried" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="outreason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="trainlevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="hobby" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="character" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="asses" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="workhistry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="prizeorpunish" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="empass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="right" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="isnet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="netpass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="isopen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="selectmobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="subname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="regdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="empattr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="empattrmemo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="istenseed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="isinternal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlRootElement(name = "empsynreq")
public class Empsynreq {

    @XmlElement(required = true)
    protected Msgreqheader msgreqheader;
    @XmlElement(required = true)
    protected Empsynreq.Msgbody msgbody;

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
     *     {@link Empsynreq.Msgbody }
     *     
     */
    public Empsynreq.Msgbody getMsgbody() {
        return msgbody;
    }

    /**
     * Sets the value of the msgbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empsynreq.Msgbody }
     *     
     */
    public void setMsgbody(Empsynreq.Msgbody value) {
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
     *         &lt;element name="empinfo">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="oprtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="employeeid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="oprcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="employeename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="edulevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="nativehome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="polivisage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="servoffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="station" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="joblevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="intime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="worktime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="hereworktime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="employtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="officetel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="outtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="outresult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="homeaddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="cardid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="wayid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="waytype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="pvtemail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ofcphone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ofcemail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="speciality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="cityid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="countyid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="svccode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="posittype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="contacttype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="empstatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="actbank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="actno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="actname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="actpid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="bail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="gradschool" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="gradtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ismarried" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="outreason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="trainlevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="hobby" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="character" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="asses" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="workhistry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="prizeorpunish" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="empass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="right" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="isnet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="netpass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="isopen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="selectmobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="subname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="regdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="empattr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="empattrmemo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="istenseed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="isinternal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "empinfo"
    })
    public static class Msgbody {

        @XmlElement(required = true)
        protected Empsynreq.Msgbody.Empinfo empinfo;

        /**
         * Gets the value of the empinfo property.
         * 
         * @return
         *     possible object is
         *     {@link Empsynreq.Msgbody.Empinfo }
         *     
         */
        public Empsynreq.Msgbody.Empinfo getEmpinfo() {
            return empinfo;
        }

        /**
         * Sets the value of the empinfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link Empsynreq.Msgbody.Empinfo }
         *     
         */
        public void setEmpinfo(Empsynreq.Msgbody.Empinfo value) {
            this.empinfo = value;
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
         *         &lt;element name="oprtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="employeeid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="oprcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="employeename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="edulevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="nativehome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="polivisage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="servoffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="station" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="joblevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="intime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="worktime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="hereworktime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="employtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="officetel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="outtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="outresult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="homeaddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="cardid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="wayid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="waytype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="pvtemail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ofcphone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ofcemail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="speciality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="cityid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="countyid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="svccode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="posittype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="contacttype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="empstatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="actbank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="actno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="actname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="actpid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="bail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="gradschool" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="gradtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ismarried" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="outreason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="trainlevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="hobby" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="character" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="asses" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="workhistry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="prizeorpunish" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="empass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="right" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="isnet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="netpass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="isopen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="selectmobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="subname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="regdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="empattr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="empattrmemo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="istenseed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="isinternal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "oprtype",
            "employeeid",
            "oprcode",
            "employeename",
            "birthday",
            "sex",
            "edulevel",
            "nativehome",
            "polivisage",
            "department",
            "servoffice",
            "station",
            "joblevel",
            "intime",
            "worktime",
            "hereworktime",
            "employtype",
            "company",
            "telephone",
            "officetel",
            "outtime",
            "outresult",
            "homeaddr",
            "cardid",
            "wayid",
            "waytype",
            "pvtemail",
            "ofcphone",
            "ofcemail",
            "speciality",
            "cityid",
            "countyid",
            "svccode",
            "posittype",
            "contacttype",
            "empstatus",
            "actbank",
            "actno",
            "actname",
            "actpid",
            "bail",
            "gradschool",
            "gradtime",
            "ismarried",
            "outreason",
            "trainlevel",
            "hobby",
            "character",
            "asses",
            "workhistry",
            "prizeorpunish",
            "empass",
            "right",
            "isnet",
            "netpass",
            "isopen",
            "selectmobile",
            "subname",
            "regdate",
            "empattr",
            "empattrmemo",
            "istenseed",
            "isinternal"
        })
        public static class Empinfo {
        	@XmlElement(required = true)
            protected String oprtype;
        	@XmlElement(required = true)
            protected String employeeid;
            protected String oprcode;
            protected String employeename;
            protected String birthday;
            protected String sex;
            protected String edulevel;
            protected String nativehome;
            protected String polivisage;
            protected String department;
            protected String servoffice;
            protected String station;
            protected String joblevel;
            protected String intime;
            protected String worktime;
            protected String hereworktime;
            protected String employtype;
            protected String company;
            protected String telephone;
            protected String officetel;
            protected String outtime;
            protected String outresult;
            protected String homeaddr;
            protected String cardid;
            protected String wayid;
            protected String waytype;
            protected String pvtemail;
            protected String ofcphone;
            protected String ofcemail;
            protected String speciality;
            protected String cityid;
            protected String countyid;
            protected String svccode;
            protected String posittype;
            protected String contacttype;
            protected String empstatus;
            protected String actbank;
            protected String actno;
            protected String actname;
            protected String actpid;
            protected String bail;
            protected String gradschool;
            protected String gradtime;
            protected String ismarried;
            protected String outreason;
            protected String trainlevel;
            protected String hobby;
            protected String character;
            protected String asses;
            protected String workhistry;
            protected String prizeorpunish;
            protected String empass;
            protected String right;
            protected String isnet;
            protected String netpass;
            protected String isopen;
            protected String selectmobile;
            protected String subname;
            protected String regdate;
            protected String empattr;
            protected String empattrmemo;
            protected String istenseed;
            protected String isinternal;

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
             * Gets the value of the employeeid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmployeeid() {
                return employeeid;
            }

            /**
             * Sets the value of the employeeid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmployeeid(String value) {
                this.employeeid = value;
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
             * Gets the value of the employeename property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmployeename() {
                return employeename;
            }

            /**
             * Sets the value of the employeename property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmployeename(String value) {
                this.employeename = value;
            }

            /**
             * Gets the value of the birthday property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBirthday() {
                return birthday;
            }

            /**
             * Sets the value of the birthday property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBirthday(String value) {
                this.birthday = value;
            }

            /**
             * Gets the value of the sex property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSex() {
                return sex;
            }

            /**
             * Sets the value of the sex property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSex(String value) {
                this.sex = value;
            }

            /**
             * Gets the value of the edulevel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEdulevel() {
                return edulevel;
            }

            /**
             * Sets the value of the edulevel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEdulevel(String value) {
                this.edulevel = value;
            }

            /**
             * Gets the value of the nativehome property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNativehome() {
                return nativehome;
            }

            /**
             * Sets the value of the nativehome property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNativehome(String value) {
                this.nativehome = value;
            }

            /**
             * Gets the value of the polivisage property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPolivisage() {
                return polivisage;
            }

            /**
             * Sets the value of the polivisage property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPolivisage(String value) {
                this.polivisage = value;
            }

            /**
             * Gets the value of the department property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDepartment() {
                return department;
            }

            /**
             * Sets the value of the department property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDepartment(String value) {
                this.department = value;
            }

            /**
             * Gets the value of the servoffice property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getServoffice() {
                return servoffice;
            }

            /**
             * Sets the value of the servoffice property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setServoffice(String value) {
                this.servoffice = value;
            }

            /**
             * Gets the value of the station property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStation() {
                return station;
            }

            /**
             * Sets the value of the station property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStation(String value) {
                this.station = value;
            }

            /**
             * Gets the value of the joblevel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getJoblevel() {
                return joblevel;
            }

            /**
             * Sets the value of the joblevel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setJoblevel(String value) {
                this.joblevel = value;
            }

            /**
             * Gets the value of the intime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIntime() {
                return intime;
            }

            /**
             * Sets the value of the intime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIntime(String value) {
                this.intime = value;
            }

            /**
             * Gets the value of the worktime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWorktime() {
                return worktime;
            }

            /**
             * Sets the value of the worktime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWorktime(String value) {
                this.worktime = value;
            }

            /**
             * Gets the value of the hereworktime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHereworktime() {
                return hereworktime;
            }

            /**
             * Sets the value of the hereworktime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHereworktime(String value) {
                this.hereworktime = value;
            }

            /**
             * Gets the value of the employtype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmploytype() {
                return employtype;
            }

            /**
             * Sets the value of the employtype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmploytype(String value) {
                this.employtype = value;
            }

            /**
             * Gets the value of the company property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCompany() {
                return company;
            }

            /**
             * Sets the value of the company property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCompany(String value) {
                this.company = value;
            }

            /**
             * Gets the value of the telephone property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTelephone() {
                return telephone;
            }

            /**
             * Sets the value of the telephone property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTelephone(String value) {
                this.telephone = value;
            }

            /**
             * Gets the value of the officetel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOfficetel() {
                return officetel;
            }

            /**
             * Sets the value of the officetel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOfficetel(String value) {
                this.officetel = value;
            }

            /**
             * Gets the value of the outtime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOuttime() {
                return outtime;
            }

            /**
             * Sets the value of the outtime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOuttime(String value) {
                this.outtime = value;
            }

            /**
             * Gets the value of the outresult property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOutresult() {
                return outresult;
            }

            /**
             * Sets the value of the outresult property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOutresult(String value) {
                this.outresult = value;
            }

            /**
             * Gets the value of the homeaddr property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHomeaddr() {
                return homeaddr;
            }

            /**
             * Sets the value of the homeaddr property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHomeaddr(String value) {
                this.homeaddr = value;
            }

            /**
             * Gets the value of the cardid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCardid() {
                return cardid;
            }

            /**
             * Sets the value of the cardid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCardid(String value) {
                this.cardid = value;
            }

            /**
             * Gets the value of the wayid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWayid() {
                return wayid;
            }

            /**
             * Sets the value of the wayid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWayid(String value) {
                this.wayid = value;
            }

            /**
             * Gets the value of the waytype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWaytype() {
                return waytype;
            }

            /**
             * Sets the value of the waytype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWaytype(String value) {
                this.waytype = value;
            }

            /**
             * Gets the value of the pvtemail property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPvtemail() {
                return pvtemail;
            }

            /**
             * Sets the value of the pvtemail property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPvtemail(String value) {
                this.pvtemail = value;
            }

            /**
             * Gets the value of the ofcphone property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOfcphone() {
                return ofcphone;
            }

            /**
             * Sets the value of the ofcphone property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOfcphone(String value) {
                this.ofcphone = value;
            }

            /**
             * Gets the value of the ofcemail property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOfcemail() {
                return ofcemail;
            }

            /**
             * Sets the value of the ofcemail property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOfcemail(String value) {
                this.ofcemail = value;
            }

            /**
             * Gets the value of the speciality property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSpeciality() {
                return speciality;
            }

            /**
             * Sets the value of the speciality property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSpeciality(String value) {
                this.speciality = value;
            }

            /**
             * Gets the value of the cityid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCityid() {
                return cityid;
            }

            /**
             * Sets the value of the cityid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCityid(String value) {
                this.cityid = value;
            }

            /**
             * Gets the value of the countyid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCountyid() {
                return countyid;
            }

            /**
             * Sets the value of the countyid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCountyid(String value) {
                this.countyid = value;
            }

            /**
             * Gets the value of the svccode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSvccode() {
                return svccode;
            }

            /**
             * Sets the value of the svccode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSvccode(String value) {
                this.svccode = value;
            }

            /**
             * Gets the value of the posittype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPosittype() {
                return posittype;
            }

            /**
             * Sets the value of the posittype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPosittype(String value) {
                this.posittype = value;
            }

            /**
             * Gets the value of the contacttype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContacttype() {
                return contacttype;
            }

            /**
             * Sets the value of the contacttype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContacttype(String value) {
                this.contacttype = value;
            }

            /**
             * Gets the value of the empstatus property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmpstatus() {
                return empstatus;
            }

            /**
             * Sets the value of the empstatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmpstatus(String value) {
                this.empstatus = value;
            }

            /**
             * Gets the value of the actbank property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getActbank() {
                return actbank;
            }

            /**
             * Sets the value of the actbank property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setActbank(String value) {
                this.actbank = value;
            }

            /**
             * Gets the value of the actno property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getActno() {
                return actno;
            }

            /**
             * Sets the value of the actno property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setActno(String value) {
                this.actno = value;
            }

            /**
             * Gets the value of the actname property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getActname() {
                return actname;
            }

            /**
             * Sets the value of the actname property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setActname(String value) {
                this.actname = value;
            }

            /**
             * Gets the value of the actpid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getActpid() {
                return actpid;
            }

            /**
             * Sets the value of the actpid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setActpid(String value) {
                this.actpid = value;
            }

            /**
             * Gets the value of the bail property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBail() {
                return bail;
            }

            /**
             * Sets the value of the bail property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBail(String value) {
                this.bail = value;
            }

            /**
             * Gets the value of the gradschool property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGradschool() {
                return gradschool;
            }

            /**
             * Sets the value of the gradschool property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGradschool(String value) {
                this.gradschool = value;
            }

            /**
             * Gets the value of the gradtime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGradtime() {
                return gradtime;
            }

            /**
             * Sets the value of the gradtime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGradtime(String value) {
                this.gradtime = value;
            }

            /**
             * Gets the value of the ismarried property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIsmarried() {
                return ismarried;
            }

            /**
             * Sets the value of the ismarried property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIsmarried(String value) {
                this.ismarried = value;
            }

            /**
             * Gets the value of the outreason property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOutreason() {
                return outreason;
            }

            /**
             * Sets the value of the outreason property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOutreason(String value) {
                this.outreason = value;
            }

            /**
             * Gets the value of the trainlevel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTrainlevel() {
                return trainlevel;
            }

            /**
             * Sets the value of the trainlevel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTrainlevel(String value) {
                this.trainlevel = value;
            }

            /**
             * Gets the value of the hobby property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHobby() {
                return hobby;
            }

            /**
             * Sets the value of the hobby property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHobby(String value) {
                this.hobby = value;
            }

            /**
             * Gets the value of the character property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCharacter() {
                return character;
            }

            /**
             * Sets the value of the character property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCharacter(String value) {
                this.character = value;
            }

            /**
             * Gets the value of the asses property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAsses() {
                return asses;
            }

            /**
             * Sets the value of the asses property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAsses(String value) {
                this.asses = value;
            }

            /**
             * Gets the value of the workhistry property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWorkhistry() {
                return workhistry;
            }

            /**
             * Sets the value of the workhistry property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWorkhistry(String value) {
                this.workhistry = value;
            }

            /**
             * Gets the value of the prizeorpunish property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPrizeorpunish() {
                return prizeorpunish;
            }

            /**
             * Sets the value of the prizeorpunish property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPrizeorpunish(String value) {
                this.prizeorpunish = value;
            }

            /**
             * Gets the value of the empass property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmpass() {
                return empass;
            }

            /**
             * Sets the value of the empass property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmpass(String value) {
                this.empass = value;
            }

            /**
             * Gets the value of the right property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRight() {
                return right;
            }

            /**
             * Sets the value of the right property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRight(String value) {
                this.right = value;
            }

            /**
             * Gets the value of the isnet property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIsnet() {
                return isnet;
            }

            /**
             * Sets the value of the isnet property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIsnet(String value) {
                this.isnet = value;
            }

            /**
             * Gets the value of the netpass property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNetpass() {
                return netpass;
            }

            /**
             * Sets the value of the netpass property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNetpass(String value) {
                this.netpass = value;
            }

            /**
             * Gets the value of the isopen property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIsopen() {
                return isopen;
            }

            /**
             * Sets the value of the isopen property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIsopen(String value) {
                this.isopen = value;
            }

            /**
             * Gets the value of the selectmobile property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSelectmobile() {
                return selectmobile;
            }

            /**
             * Sets the value of the selectmobile property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSelectmobile(String value) {
                this.selectmobile = value;
            }

            /**
             * Gets the value of the subname property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSubname() {
                return subname;
            }

            /**
             * Sets the value of the subname property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSubname(String value) {
                this.subname = value;
            }

            /**
             * Gets the value of the regdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRegdate() {
                return regdate;
            }

            /**
             * Sets the value of the regdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRegdate(String value) {
                this.regdate = value;
            }

            /**
             * Gets the value of the empattr property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmpattr() {
                return empattr;
            }

            /**
             * Sets the value of the empattr property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmpattr(String value) {
                this.empattr = value;
            }

            /**
             * Gets the value of the empattrmemo property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmpattrmemo() {
                return empattrmemo;
            }

            /**
             * Sets the value of the empattrmemo property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmpattrmemo(String value) {
                this.empattrmemo = value;
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

}
