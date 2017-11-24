package com.sunrise.boss.business.zifee.feedisclog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class FeedisclogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.sql.Timestamp optime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long yxplanid;

    /** nullable persistent field */
    private Long feediscid;

    /** nullable persistent field */
    private Double wrapfee;

    /** nullable persistent field */
    private Long acctid;

    /** nullable persistent field */
    private Double minamt;

    /** nullable persistent field */
    private Double maxamt;

    /** nullable persistent field */
    private Double deratecomm;

    /** nullable persistent field */
    private Double wnbjdiscrate;

    /** nullable persistent field */
    private Double wnzjdiscrate;

    /** nullable persistent field */
    private Double wwbjdiscrate;

    /** nullable persistent field */
    private Double wwzjdiscrate;

    /** nullable persistent field */
    private Double rate;

    /** nullable persistent field */
    private String disclocalcode;

    /** nullable persistent field */
    private String discscope;

    /** nullable persistent field */
    private Long discminu;

    /** nullable persistent field */
    private String lowmobile;

    /** nullable persistent field */
    private String highmobile;

    /** nullable persistent field */
    private String disctype;

    /** nullable persistent field */
    private String discdistrict;

    /** nullable persistent field */
    private String billtype;

    /** nullable persistent field */
    private String disckind;

    /** nullable persistent field */
    private Byte schedsendflag;

    /** nullable persistent field */
    private String currbillcode;

    /** nullable persistent field */
    private Byte paybyothersflag;

    /** nullable persistent field */
    private Long discnum;

    /** nullable persistent field */
    private Double rate1;

    /** nullable persistent field */
    private Long beginnum1;

    /** nullable persistent field */
    private Long endnum1;

    /** nullable persistent field */
    private Double rate2;

    /** nullable persistent field */
    private Long beginnum2;

    /** nullable persistent field */
    private Long endnum2;

    /** nullable persistent field */
    private Double rate3;

    /** nullable persistent field */
    private Long beginnum3;

    /** nullable persistent field */
    private Long endnum3;

    /** nullable persistent field */
    private String ratingtype;

    /** nullable persistent field */
    private String remark;

    /** nullable persistent field */
    private Double ipdisc;

    /** nullable persistent field */
    private Long wrapminute;

    /** nullable persistent field */
    private Double wrapinrate;

    /** nullable persistent field */
    private Double wrapoutrate;

    /** nullable persistent field */
    private Double deratefunc;

    /** nullable persistent field */
    private Double deraterent;

    /** nullable persistent field */
    private Double busyrate;

    /** nullable persistent field */
    private Double freerate;

    /** nullable persistent field */
    private String calltype;

    /** nullable persistent field */
    private String disccondition;

    /** nullable persistent field */
    private String vpmnid;
    
    private Long smsinfoupload;

    /** full constructor */
    public FeedisclogVO(java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long yxplanid, java.lang.Long feediscid, java.lang.Double wrapfee, java.lang.Long acctid, java.lang.Double minamt, java.lang.Double maxamt, java.lang.Double deratecomm, java.lang.Double wnbjdiscrate, java.lang.Double wnzjdiscrate, java.lang.Double wwbjdiscrate, java.lang.Double wwzjdiscrate, java.lang.Double rate, java.lang.String disclocalcode, java.lang.String discscope, java.lang.Long discminu, java.lang.String lowmobile, java.lang.String highmobile, java.lang.String disctype, java.lang.String discdistrict, java.lang.String billtype, java.lang.String disckind, java.lang.Byte schedsendflag, java.lang.String currbillcode, java.lang.Byte paybyothersflag, java.lang.Long discnum, java.lang.Double rate1, java.lang.Long beginnum1, java.lang.Long endnum1, java.lang.Double rate2, java.lang.Long beginnum2, java.lang.Long endnum2, java.lang.Double rate3, java.lang.Long beginnum3, java.lang.Long endnum3, java.lang.String ratingtype, java.lang.String remark, java.lang.Double ipdisc, java.lang.Long wrapminute, java.lang.Double wrapinrate, java.lang.Double wrapoutrate, java.lang.Double deratefunc, java.lang.Double deraterent, java.lang.Double busyrate, java.lang.Double freerate, java.lang.String calltype, java.lang.String disccondition, java.lang.String vpmnid) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.yxplanid = yxplanid;
        this.feediscid = feediscid;
        this.wrapfee = wrapfee;
        this.acctid = acctid;
        this.minamt = minamt;
        this.maxamt = maxamt;
        this.deratecomm = deratecomm;
        this.wnbjdiscrate = wnbjdiscrate;
        this.wnzjdiscrate = wnzjdiscrate;
        this.wwbjdiscrate = wwbjdiscrate;
        this.wwzjdiscrate = wwzjdiscrate;
        this.rate = rate;
        this.disclocalcode = disclocalcode;
        this.discscope = discscope;
        this.discminu = discminu;
        this.lowmobile = lowmobile;
        this.highmobile = highmobile;
        this.disctype = disctype;
        this.discdistrict = discdistrict;
        this.billtype = billtype;
        this.disckind = disckind;
        this.schedsendflag = schedsendflag;
        this.currbillcode = currbillcode;
        this.paybyothersflag = paybyothersflag;
        this.discnum = discnum;
        this.rate1 = rate1;
        this.beginnum1 = beginnum1;
        this.endnum1 = endnum1;
        this.rate2 = rate2;
        this.beginnum2 = beginnum2;
        this.endnum2 = endnum2;
        this.rate3 = rate3;
        this.beginnum3 = beginnum3;
        this.endnum3 = endnum3;
        this.ratingtype = ratingtype;
        this.remark = remark;
        this.ipdisc = ipdisc;
        this.wrapminute = wrapminute;
        this.wrapinrate = wrapinrate;
        this.wrapoutrate = wrapoutrate;
        this.deratefunc = deratefunc;
        this.deraterent = deraterent;
        this.busyrate = busyrate;
        this.freerate = freerate;
        this.calltype = calltype;
        this.disccondition = disccondition;
        this.vpmnid = vpmnid;
    }

    /** default constructor */
    public FeedisclogVO() {
    }
    
    /** minimal constructor */
    public FeedisclogVO(java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
    }
    
    public Long getSmsinfoupload() {
		return smsinfoupload;
	}

	public void setSmsinfoupload(Long smsinfoupload) {
		this.smsinfoupload = smsinfoupload;
	}

	public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.sql.Timestamp getOptime() {
        return this.optime;
    }

    public void setOptime(java.sql.Timestamp optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Long getFeediscid() {
        return this.feediscid;
    }

    public void setFeediscid(java.lang.Long feediscid) {
        this.feediscid = feediscid;
    }

    public java.lang.Double getWrapfee() {
        return this.wrapfee;
    }

    public void setWrapfee(java.lang.Double wrapfee) {
        this.wrapfee = wrapfee;
    }

    public java.lang.Long getAcctid() {
        return this.acctid;
    }

    public void setAcctid(java.lang.Long acctid) {
        this.acctid = acctid;
    }

    public java.lang.Double getMinamt() {
        return this.minamt;
    }

    public void setMinamt(java.lang.Double minamt) {
        this.minamt = minamt;
    }

    public java.lang.Double getMaxamt() {
        return this.maxamt;
    }

    public void setMaxamt(java.lang.Double maxamt) {
        this.maxamt = maxamt;
    }

    public java.lang.Double getDeratecomm() {
        return this.deratecomm;
    }

    public void setDeratecomm(java.lang.Double deratecomm) {
        this.deratecomm = deratecomm;
    }

    public java.lang.Double getWnbjdiscrate() {
        return this.wnbjdiscrate;
    }

    public void setWnbjdiscrate(java.lang.Double wnbjdiscrate) {
        this.wnbjdiscrate = wnbjdiscrate;
    }

    public java.lang.Double getWnzjdiscrate() {
        return this.wnzjdiscrate;
    }

    public void setWnzjdiscrate(java.lang.Double wnzjdiscrate) {
        this.wnzjdiscrate = wnzjdiscrate;
    }

    public java.lang.Double getWwbjdiscrate() {
        return this.wwbjdiscrate;
    }

    public void setWwbjdiscrate(java.lang.Double wwbjdiscrate) {
        this.wwbjdiscrate = wwbjdiscrate;
    }

    public java.lang.Double getWwzjdiscrate() {
        return this.wwzjdiscrate;
    }

    public void setWwzjdiscrate(java.lang.Double wwzjdiscrate) {
        this.wwzjdiscrate = wwzjdiscrate;
    }

    public java.lang.Double getRate() {
        return this.rate;
    }

    public void setRate(java.lang.Double rate) {
        this.rate = rate;
    }

    public java.lang.String getDisclocalcode() {
        return this.disclocalcode;
    }

    public void setDisclocalcode(java.lang.String disclocalcode) {
        this.disclocalcode = disclocalcode;
    }

    public java.lang.String getDiscscope() {
        return this.discscope;
    }

    public void setDiscscope(java.lang.String discscope) {
        this.discscope = discscope;
    }

    public java.lang.Long getDiscminu() {
        return this.discminu;
    }

    public void setDiscminu(java.lang.Long discminu) {
        this.discminu = discminu;
    }

    public java.lang.String getLowmobile() {
        return this.lowmobile;
    }

    public void setLowmobile(java.lang.String lowmobile) {
        this.lowmobile = lowmobile;
    }

    public java.lang.String getHighmobile() {
        return this.highmobile;
    }

    public void setHighmobile(java.lang.String highmobile) {
        this.highmobile = highmobile;
    }

    public java.lang.String getDisctype() {
        return this.disctype;
    }

    public void setDisctype(java.lang.String disctype) {
        this.disctype = disctype;
    }

    public java.lang.String getDiscdistrict() {
        return this.discdistrict;
    }

    public void setDiscdistrict(java.lang.String discdistrict) {
        this.discdistrict = discdistrict;
    }

    public java.lang.String getBilltype() {
        return this.billtype;
    }

    public void setBilltype(java.lang.String billtype) {
        this.billtype = billtype;
    }

    public java.lang.String getDisckind() {
        return this.disckind;
    }

    public void setDisckind(java.lang.String disckind) {
        this.disckind = disckind;
    }

    public java.lang.Byte getSchedsendflag() {
        return this.schedsendflag;
    }

    public void setSchedsendflag(java.lang.Byte schedsendflag) {
        this.schedsendflag = schedsendflag;
    }

    public java.lang.String getCurrbillcode() {
        return this.currbillcode;
    }

    public void setCurrbillcode(java.lang.String currbillcode) {
        this.currbillcode = currbillcode;
    }

    public java.lang.Byte getPaybyothersflag() {
        return this.paybyothersflag;
    }

    public void setPaybyothersflag(java.lang.Byte paybyothersflag) {
        this.paybyothersflag = paybyothersflag;
    }

    public java.lang.Long getDiscnum() {
        return this.discnum;
    }

    public void setDiscnum(java.lang.Long discnum) {
        this.discnum = discnum;
    }

    public java.lang.Double getRate1() {
        return this.rate1;
    }

    public void setRate1(java.lang.Double rate1) {
        this.rate1 = rate1;
    }

    public java.lang.Long getBeginnum1() {
        return this.beginnum1;
    }

    public void setBeginnum1(java.lang.Long beginnum1) {
        this.beginnum1 = beginnum1;
    }

    public java.lang.Long getEndnum1() {
        return this.endnum1;
    }

    public void setEndnum1(java.lang.Long endnum1) {
        this.endnum1 = endnum1;
    }

    public java.lang.Double getRate2() {
        return this.rate2;
    }

    public void setRate2(java.lang.Double rate2) {
        this.rate2 = rate2;
    }

    public java.lang.Long getBeginnum2() {
        return this.beginnum2;
    }

    public void setBeginnum2(java.lang.Long beginnum2) {
        this.beginnum2 = beginnum2;
    }

    public java.lang.Long getEndnum2() {
        return this.endnum2;
    }

    public void setEndnum2(java.lang.Long endnum2) {
        this.endnum2 = endnum2;
    }

    public java.lang.Double getRate3() {
        return this.rate3;
    }

    public void setRate3(java.lang.Double rate3) {
        this.rate3 = rate3;
    }

    public java.lang.Long getBeginnum3() {
        return this.beginnum3;
    }

    public void setBeginnum3(java.lang.Long beginnum3) {
        this.beginnum3 = beginnum3;
    }

    public java.lang.Long getEndnum3() {
        return this.endnum3;
    }

    public void setEndnum3(java.lang.Long endnum3) {
        this.endnum3 = endnum3;
    }

    public java.lang.String getRatingtype() {
        return this.ratingtype;
    }

    public void setRatingtype(java.lang.String ratingtype) {
        this.ratingtype = ratingtype;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public java.lang.Double getIpdisc() {
        return this.ipdisc;
    }

    public void setIpdisc(java.lang.Double ipdisc) {
        this.ipdisc = ipdisc;
    }

    public java.lang.Long getWrapminute() {
        return this.wrapminute;
    }

    public void setWrapminute(java.lang.Long wrapminute) {
        this.wrapminute = wrapminute;
    }

    public java.lang.Double getWrapinrate() {
        return this.wrapinrate;
    }

    public void setWrapinrate(java.lang.Double wrapinrate) {
        this.wrapinrate = wrapinrate;
    }

    public java.lang.Double getWrapoutrate() {
        return this.wrapoutrate;
    }

    public void setWrapoutrate(java.lang.Double wrapoutrate) {
        this.wrapoutrate = wrapoutrate;
    }

    public java.lang.Double getDeratefunc() {
        return this.deratefunc;
    }

    public void setDeratefunc(java.lang.Double deratefunc) {
        this.deratefunc = deratefunc;
    }

    public java.lang.Double getDeraterent() {
        return this.deraterent;
    }

    public void setDeraterent(java.lang.Double deraterent) {
        this.deraterent = deraterent;
    }

    public java.lang.Double getBusyrate() {
        return this.busyrate;
    }

    public void setBusyrate(java.lang.Double busyrate) {
        this.busyrate = busyrate;
    }

    public java.lang.Double getFreerate() {
        return this.freerate;
    }

    public void setFreerate(java.lang.Double freerate) {
        this.freerate = freerate;
    }

    public java.lang.String getCalltype() {
        return this.calltype;
    }

    public void setCalltype(java.lang.String calltype) {
        this.calltype = calltype;
    }

    public java.lang.String getDisccondition() {
        return this.disccondition;
    }

    public void setDisccondition(java.lang.String disccondition) {
        this.disccondition = disccondition;
    }

    public java.lang.String getVpmnid() {
        return this.vpmnid;
    }

    public void setVpmnid(java.lang.String vpmnid) {
        this.vpmnid = vpmnid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof FeedisclogVO) ) return false;
        FeedisclogVO castOther = (FeedisclogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
