
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
 *                   &lt;element name="wayinfo">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="oprtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="wayid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="shortname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="svbrchcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="svccode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="mareacode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="buztypecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="adtypecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="logiscode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="longtitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="adacode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="waymagcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="catetype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="formtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="starttime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="buzarea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="mainlayer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="sublayer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="buzphoneno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="wayname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="cooperator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="waytype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="waysubtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="custtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="upperwayid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="busicode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="countyid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="cityid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="centerid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="citylevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="waylevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="bchlevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="function" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="miscode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="createtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="disabletime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="waystate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="runbyself" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="depotdet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="isshare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="alarmbizamount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="prtsource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="isconnected" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="connecttype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="runmode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="iscoreway" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="starlevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="pt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="chainhead" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="signstatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="empnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="magnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="terminumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="updatedate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="isstraitprd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="taxtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="istietong" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="rivltype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="iskzcz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="distype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="calcumode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="uniformtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="checked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="buzmanager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="subrunmode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlRootElement(name = "waysynreq")
public class Waysynreq {

    @XmlElement(required = true)
    protected Msgreqheader msgreqheader;
    @XmlElement(required = true)
    protected Waysynreq.Msgbody msgbody;

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
     *     {@link Waysynreq.Msgbody }
     *     
     */
    public Waysynreq.Msgbody getMsgbody() {
        return msgbody;
    }

    /**
     * Sets the value of the msgbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link Waysynreq.Msgbody }
     *     
     */
    public void setMsgbody(Waysynreq.Msgbody value) {
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
     *         &lt;element name="wayinfo">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="oprtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="wayid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="shortname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="svbrchcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="svccode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="mareacode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="buztypecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="adtypecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="logiscode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="longtitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="adacode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="waymagcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="catetype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="formtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="starttime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="buzarea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="mainlayer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="sublayer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="buzphoneno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="wayname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="cooperator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="waytype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="waysubtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="custtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="upperwayid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="busicode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="countyid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="cityid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="centerid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="citylevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="waylevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="bchlevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="function" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="miscode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="createtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="disabletime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="waystate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="runbyself" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="depotdet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="isshare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="alarmbizamount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="prtsource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="isconnected" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="connecttype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="runmode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="iscoreway" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="starlevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="pt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="chainhead" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="signstatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="empnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="magnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="terminumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="updatedate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="isstraitprd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="taxtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="istietong" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="rivltype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="iskzcz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="distype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="calcumode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="uniformtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="checked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="buzmanager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="subrunmode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "wayinfo"
    })
    public static class Msgbody {

        @XmlElement(required = true)
        protected Waysynreq.Msgbody.Wayinfo wayinfo;

        /**
         * Gets the value of the wayinfo property.
         * 
         * @return
         *     possible object is
         *     {@link Waysynreq.Msgbody.Wayinfo }
         *     
         */
        public Waysynreq.Msgbody.Wayinfo getWayinfo() {
            return wayinfo;
        }

        /**
         * Sets the value of the wayinfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link Waysynreq.Msgbody.Wayinfo }
         *     
         */
        public void setWayinfo(Waysynreq.Msgbody.Wayinfo value) {
            this.wayinfo = value;
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
         *         &lt;element name="wayid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="shortname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="svbrchcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="svccode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="mareacode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="buztypecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="adtypecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="logiscode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="longtitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="adacode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="waymagcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="catetype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="formtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="starttime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="buzarea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="mainlayer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="sublayer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="buzphoneno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="wayname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="cooperator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="waytype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="waysubtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="custtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="upperwayid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="busicode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="countyid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="cityid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="centerid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="citylevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="waylevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="bchlevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="function" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="miscode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="createtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="disabletime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="waystate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="runbyself" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="depotdet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="isshare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="alarmbizamount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="prtsource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="isconnected" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="connecttype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="runmode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="iscoreway" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="starlevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="pt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="chainhead" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="signstatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="empnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="magnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="terminumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="updatedate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="isstraitprd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="taxtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="istietong" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="rivltype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="iskzcz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="distype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="calcumode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="uniformtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="checked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="buzmanager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="subrunmode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "wayid",
            "shortname",
            "svbrchcode",
            "svccode",
            "mareacode",
            "buztypecode",
            "adtypecode",
            "address",
            "logiscode",
            "latitude",
            "longtitude",
            "adacode",
            "waymagcode",
            "catetype",
            "formtype",
            "starttime",
            "buzarea",
            "mainlayer",
            "sublayer",
            "buzphoneno",
            "wayname",
            "cooperator",
            "waytype",
            "waysubtype",
            "custtype",
            "upperwayid",
            "busicode",
            "countyid",
            "cityid",
            "centerid",
            "citylevel",
            "waylevel",
            "bchlevel",
            "function",
            "miscode",
            "createtime",
            "disabletime",
            "waystate",
            "runbyself",
            "depotdet",
            "isshare",
            "alarmbizamount",
            "prtsource",
            "isconnected",
            "connecttype",
            "runmode",
            "iscoreway",
            "starlevel",
            "pt",
            "chainhead",
            "signstatus",
            "empnumber",
            "magnumber",
            "terminumber",
            "updatedate",
            "isstraitprd",
            "taxtype",
            "istietong",
            "rivltype",
            "iskzcz",
            "distype",
            "calcumode",
            "uniformtime",
            "checked",
            "buzmanager",
            "subrunmode"
        })
        public static class Wayinfo {
        	@XmlElement(required = true)
            protected String oprtype;
        	@XmlElement(required = true)
            protected String wayid;
            protected String shortname;
            protected String svbrchcode;
            protected String svccode;
            protected String mareacode;
            protected String buztypecode;
            protected String adtypecode;
            protected String address;
            protected String logiscode;
            protected String latitude;
            protected String longtitude;
            protected String adacode;
            protected String waymagcode;
            protected String catetype;
            protected String formtype;
            protected String starttime;
            protected String buzarea;
            protected String mainlayer;
            protected String sublayer;
            protected String buzphoneno;
            protected String wayname;
            protected String cooperator;
            protected String waytype;
            protected String waysubtype;
            protected String custtype;
            protected String upperwayid;
            protected String busicode;
            protected String countyid;
            protected String cityid;
            protected String centerid;
            protected String citylevel;
            protected String waylevel;
            protected String bchlevel;
            protected String function;
            protected String miscode;
            protected String createtime;
            protected String disabletime;
            protected String waystate;
            protected String runbyself;
            protected String depotdet;
            protected String isshare;
            protected String alarmbizamount;
            protected String prtsource;
            protected String isconnected;
            protected String connecttype;
            protected String runmode;
            protected String iscoreway;
            protected String starlevel;
            protected String pt;
            protected String chainhead;
            protected String signstatus;
            protected String empnumber;
            protected String magnumber;
            protected String terminumber;
            protected String updatedate;
            protected String isstraitprd;
            protected String taxtype;
            protected String istietong;
            protected String rivltype;
            protected String iskzcz;
            protected String distype;
            protected String calcumode;
            protected String uniformtime;
            protected String checked;
            protected String buzmanager;
            protected String subrunmode;

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
             * Gets the value of the shortname property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getShortname() {
                return shortname;
            }

            /**
             * Sets the value of the shortname property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setShortname(String value) {
                this.shortname = value;
            }

            /**
             * Gets the value of the svbrchcode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSvbrchcode() {
                return svbrchcode;
            }

            /**
             * Sets the value of the svbrchcode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSvbrchcode(String value) {
                this.svbrchcode = value;
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
             * Gets the value of the mareacode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMareacode() {
                return mareacode;
            }

            /**
             * Sets the value of the mareacode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMareacode(String value) {
                this.mareacode = value;
            }

            /**
             * Gets the value of the buztypecode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBuztypecode() {
                return buztypecode;
            }

            /**
             * Sets the value of the buztypecode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBuztypecode(String value) {
                this.buztypecode = value;
            }

            /**
             * Gets the value of the adtypecode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAdtypecode() {
                return adtypecode;
            }

            /**
             * Sets the value of the adtypecode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAdtypecode(String value) {
                this.adtypecode = value;
            }

            /**
             * Gets the value of the address property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddress() {
                return address;
            }

            /**
             * Sets the value of the address property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddress(String value) {
                this.address = value;
            }

            /**
             * Gets the value of the logiscode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLogiscode() {
                return logiscode;
            }

            /**
             * Sets the value of the logiscode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLogiscode(String value) {
                this.logiscode = value;
            }

            /**
             * Gets the value of the latitude property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLatitude() {
                return latitude;
            }

            /**
             * Sets the value of the latitude property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLatitude(String value) {
                this.latitude = value;
            }

            /**
             * Gets the value of the longtitude property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLongtitude() {
                return longtitude;
            }

            /**
             * Sets the value of the longtitude property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLongtitude(String value) {
                this.longtitude = value;
            }

            /**
             * Gets the value of the adacode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAdacode() {
                return adacode;
            }

            /**
             * Sets the value of the adacode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAdacode(String value) {
                this.adacode = value;
            }

            /**
             * Gets the value of the waymagcode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWaymagcode() {
                return waymagcode;
            }

            /**
             * Sets the value of the waymagcode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWaymagcode(String value) {
                this.waymagcode = value;
            }

            /**
             * Gets the value of the catetype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCatetype() {
                return catetype;
            }

            /**
             * Sets the value of the catetype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCatetype(String value) {
                this.catetype = value;
            }

            /**
             * Gets the value of the formtype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFormtype() {
                return formtype;
            }

            /**
             * Sets the value of the formtype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFormtype(String value) {
                this.formtype = value;
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
             * Gets the value of the buzarea property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBuzarea() {
                return buzarea;
            }

            /**
             * Sets the value of the buzarea property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBuzarea(String value) {
                this.buzarea = value;
            }

            /**
             * Gets the value of the mainlayer property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMainlayer() {
                return mainlayer;
            }

            /**
             * Sets the value of the mainlayer property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMainlayer(String value) {
                this.mainlayer = value;
            }

            /**
             * Gets the value of the sublayer property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSublayer() {
                return sublayer;
            }

            /**
             * Sets the value of the sublayer property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSublayer(String value) {
                this.sublayer = value;
            }

            /**
             * Gets the value of the buzphoneno property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBuzphoneno() {
                return buzphoneno;
            }

            /**
             * Sets the value of the buzphoneno property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBuzphoneno(String value) {
                this.buzphoneno = value;
            }

            /**
             * Gets the value of the wayname property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWayname() {
                return wayname;
            }

            /**
             * Sets the value of the wayname property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWayname(String value) {
                this.wayname = value;
            }

            /**
             * Gets the value of the cooperator property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCooperator() {
                return cooperator;
            }

            /**
             * Sets the value of the cooperator property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCooperator(String value) {
                this.cooperator = value;
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
             * Gets the value of the waysubtype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWaysubtype() {
                return waysubtype;
            }

            /**
             * Sets the value of the waysubtype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWaysubtype(String value) {
                this.waysubtype = value;
            }

            /**
             * Gets the value of the custtype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCusttype() {
                return custtype;
            }

            /**
             * Sets the value of the custtype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCusttype(String value) {
                this.custtype = value;
            }

            /**
             * Gets the value of the upperwayid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUpperwayid() {
                return upperwayid;
            }

            /**
             * Sets the value of the upperwayid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUpperwayid(String value) {
                this.upperwayid = value;
            }

            /**
             * Gets the value of the busicode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBusicode() {
                return busicode;
            }

            /**
             * Sets the value of the busicode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBusicode(String value) {
                this.busicode = value;
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
             * Gets the value of the centerid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCenterid() {
                return centerid;
            }

            /**
             * Sets the value of the centerid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCenterid(String value) {
                this.centerid = value;
            }

            /**
             * Gets the value of the citylevel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCitylevel() {
                return citylevel;
            }

            /**
             * Sets the value of the citylevel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCitylevel(String value) {
                this.citylevel = value;
            }

            /**
             * Gets the value of the waylevel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWaylevel() {
                return waylevel;
            }

            /**
             * Sets the value of the waylevel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWaylevel(String value) {
                this.waylevel = value;
            }

            /**
             * Gets the value of the bchlevel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBchlevel() {
                return bchlevel;
            }

            /**
             * Sets the value of the bchlevel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBchlevel(String value) {
                this.bchlevel = value;
            }

            /**
             * Gets the value of the function property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFunction() {
                return function;
            }

            /**
             * Sets the value of the function property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFunction(String value) {
                this.function = value;
            }

            /**
             * Gets the value of the miscode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMiscode() {
                return miscode;
            }

            /**
             * Sets the value of the miscode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMiscode(String value) {
                this.miscode = value;
            }

            /**
             * Gets the value of the createtime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCreatetime() {
                return createtime;
            }

            /**
             * Sets the value of the createtime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCreatetime(String value) {
                this.createtime = value;
            }

            /**
             * Gets the value of the disabletime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDisabletime() {
                return disabletime;
            }

            /**
             * Sets the value of the disabletime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDisabletime(String value) {
                this.disabletime = value;
            }

            /**
             * Gets the value of the waystate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWaystate() {
                return waystate;
            }

            /**
             * Sets the value of the waystate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWaystate(String value) {
                this.waystate = value;
            }

            /**
             * Gets the value of the runbyself property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRunbyself() {
                return runbyself;
            }

            /**
             * Sets the value of the runbyself property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRunbyself(String value) {
                this.runbyself = value;
            }

            /**
             * Gets the value of the depotdet property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDepotdet() {
                return depotdet;
            }

            /**
             * Sets the value of the depotdet property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDepotdet(String value) {
                this.depotdet = value;
            }

            /**
             * Gets the value of the isshare property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIsshare() {
                return isshare;
            }

            /**
             * Sets the value of the isshare property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIsshare(String value) {
                this.isshare = value;
            }

            /**
             * Gets the value of the alarmbizamount property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAlarmbizamount() {
                return alarmbizamount;
            }

            /**
             * Sets the value of the alarmbizamount property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAlarmbizamount(String value) {
                this.alarmbizamount = value;
            }

            /**
             * Gets the value of the prtsource property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPrtsource() {
                return prtsource;
            }

            /**
             * Sets the value of the prtsource property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPrtsource(String value) {
                this.prtsource = value;
            }

            /**
             * Gets the value of the isconnected property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIsconnected() {
                return isconnected;
            }

            /**
             * Sets the value of the isconnected property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIsconnected(String value) {
                this.isconnected = value;
            }

            /**
             * Gets the value of the connecttype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getConnecttype() {
                return connecttype;
            }

            /**
             * Sets the value of the connecttype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setConnecttype(String value) {
                this.connecttype = value;
            }

            /**
             * Gets the value of the runmode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRunmode() {
                return runmode;
            }

            /**
             * Sets the value of the runmode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRunmode(String value) {
                this.runmode = value;
            }

            /**
             * Gets the value of the iscoreway property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIscoreway() {
                return iscoreway;
            }

            /**
             * Sets the value of the iscoreway property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIscoreway(String value) {
                this.iscoreway = value;
            }

            /**
             * Gets the value of the starlevel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStarlevel() {
                return starlevel;
            }

            /**
             * Sets the value of the starlevel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStarlevel(String value) {
                this.starlevel = value;
            }

            /**
             * Gets the value of the pt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPt() {
                return pt;
            }

            /**
             * Sets the value of the pt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPt(String value) {
                this.pt = value;
            }

            /**
             * Gets the value of the chainhead property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getChainhead() {
                return chainhead;
            }

            /**
             * Sets the value of the chainhead property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setChainhead(String value) {
                this.chainhead = value;
            }

            /**
             * Gets the value of the signstatus property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSignstatus() {
                return signstatus;
            }

            /**
             * Sets the value of the signstatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSignstatus(String value) {
                this.signstatus = value;
            }

            /**
             * Gets the value of the empnumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmpnumber() {
                return empnumber;
            }

            /**
             * Sets the value of the empnumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmpnumber(String value) {
                this.empnumber = value;
            }

            /**
             * Gets the value of the magnumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMagnumber() {
                return magnumber;
            }

            /**
             * Sets the value of the magnumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMagnumber(String value) {
                this.magnumber = value;
            }

            /**
             * Gets the value of the terminumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTerminumber() {
                return terminumber;
            }

            /**
             * Sets the value of the terminumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTerminumber(String value) {
                this.terminumber = value;
            }

            /**
             * Gets the value of the updatedate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUpdatedate() {
                return updatedate;
            }

            /**
             * Sets the value of the updatedate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUpdatedate(String value) {
                this.updatedate = value;
            }

            /**
             * Gets the value of the isstraitprd property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIsstraitprd() {
                return isstraitprd;
            }

            /**
             * Sets the value of the isstraitprd property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIsstraitprd(String value) {
                this.isstraitprd = value;
            }

            /**
             * Gets the value of the taxtype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxtype() {
                return taxtype;
            }

            /**
             * Sets the value of the taxtype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxtype(String value) {
                this.taxtype = value;
            }

            /**
             * Gets the value of the istietong property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIstietong() {
                return istietong;
            }

            /**
             * Sets the value of the istietong property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIstietong(String value) {
                this.istietong = value;
            }

            /**
             * Gets the value of the rivltype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRivltype() {
                return rivltype;
            }

            /**
             * Sets the value of the rivltype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRivltype(String value) {
                this.rivltype = value;
            }

            /**
             * Gets the value of the iskzcz property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIskzcz() {
                return iskzcz;
            }

            /**
             * Sets the value of the iskzcz property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIskzcz(String value) {
                this.iskzcz = value;
            }

            /**
             * Gets the value of the distype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDistype() {
                return distype;
            }

            /**
             * Sets the value of the distype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDistype(String value) {
                this.distype = value;
            }

            /**
             * Gets the value of the calcumode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCalcumode() {
                return calcumode;
            }

            /**
             * Sets the value of the calcumode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCalcumode(String value) {
                this.calcumode = value;
            }

            /**
             * Gets the value of the uniformtime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUniformtime() {
                return uniformtime;
            }

            /**
             * Sets the value of the uniformtime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUniformtime(String value) {
                this.uniformtime = value;
            }

            /**
             * Gets the value of the checked property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getChecked() {
                return checked;
            }

            /**
             * Sets the value of the checked property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setChecked(String value) {
                this.checked = value;
            }

            /**
             * Gets the value of the buzmanager property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
			public String getBuzmanager() {
				return buzmanager;
			}

            /**
             * Sets the value of the buzmanager property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
			public void setBuzmanager(String buzmanager) {
				this.buzmanager = buzmanager;
			}

            /**
             * Gets the value of the subrunmode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
			public String getSubrunmode() {
				return subrunmode;
			}

            /**
             * Sets the value of the subrunmode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
			public void setSubrunmode(String subrunmode) {
				this.subrunmode = subrunmode;
			}

        }

    }

}
