package com.sunrise.boss.business.zifee.feedisc.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.feedisclog.persistent.FeedisclogVO;

/** @author Hibernate CodeGenerator */
public class FeediscVO implements Serializable,OperationLog {

    /** identifier field */
    private Long feediscid;

    /** persistent field */
    private Long yxplanid;

    /** nullable persistent field */
    private Double wrapoutrate;

    /** nullable persistent field */
    private Double wrapinrate;

    /** nullable persistent field */
    private Long wrapminute;

    /** nullable persistent field */
    private Double wrapfee;
    
    /** nullable persistent field */
	private Double halfwrapfee;

    /** nullable persistent field */
    private Long acctid;

    /** nullable persistent field */
    private String areacod;

    /** nullable persistent field */
    private Long areagroupid;

    /** nullable persistent field */
    private String disccondition;

    /** nullable persistent field */
    private String calltype;

    /** nullable persistent field */
    private Double busyrate;

    /** nullable persistent field */
    private Double freerate;

    /** nullable persistent field */
    private Double ipdisc;

    /** nullable persistent field */
    private String disckind;

    /** nullable persistent field */
    private String discscope;

    /** nullable persistent field */
    private String lowmobile;

    /** nullable persistent field */
    private String highmobile;

    /** nullable persistent field */
    private String disclocalcode;

    /** nullable persistent field */
    private String discdistrict;

    /** nullable persistent field */
    private Double wnzjdiscrate;

    /** nullable persistent field */
    private Double wwzjdiscrate;

    /** nullable persistent field */
    private Double wnbjdiscrate;

    /** nullable persistent field */
    private Double wwbjdiscrate;

    /** nullable persistent field */
    private Float rate;

    /** nullable persistent field */
    private String disctype;

    /** nullable persistent field */
    private Double deratecomm;

    /** nullable persistent field */
    private Double deraterent;

    /** nullable persistent field */
    private Double deratefunc;

    /** nullable persistent field */
    private Double minamt;

    /** nullable persistent field */
    private Double maxamt;

    /** nullable persistent field */
    private String billtype;

    /** nullable persistent field */
    private Long discminu;

    /** nullable persistent field */
    private String vpmnid;

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
	private String busitype;
	
	/** nullable persistent field */
	private String accessplatform;
	
	/** nullable persistent field */
	private Double gotoneuprate;
	
	/** nullable persistent field */
	private Double gotonedownrate;
	
	/** nullable persistent field */
	private Double smpuprate;
	
	/** nullable persistent field */
	private Double smpdownrate;
	
	private Long groupfreecount;
	private Double groupfreefee;
	
	private Double rate4;
    private Long beginnum4;
    private Long endnum4;
    private Double rate5;
    private Long beginnum5;
    private Long endnum5;
    private Double rate6;
    private Long beginnum6;
    private Long endnum6;
    
    private Long smsinfoupload;


    /** full constructor */
    public FeediscVO(java.lang.Long yxplanid, java.lang.Double wrapoutrate, java.lang.Double wrapinrate, java.lang.Long wrapminute, java.lang.Double wrapfee, java.lang.Long acctid, java.lang.String areacode, java.lang.Long areagroupid, java.lang.String disccondition, java.lang.String calltype, java.lang.Double busyrate, java.lang.Double freerate, java.lang.Double ipdisc, java.lang.String disckind, java.lang.String discscope, java.lang.String lowmobile, java.lang.String highmobile, java.lang.String disclocalcode, java.lang.String discdistrict, java.lang.Double wnzjdiscrate, java.lang.Double wwzjdiscrate, java.lang.Double wnbjdiscrate, java.lang.Double wwbjdiscrate, java.lang.Float rate, java.lang.String disctype, java.lang.Double deratecomm, java.lang.Double deraterent, java.lang.Double deratefunc, java.lang.Double minamt, java.lang.Double maxamt, java.lang.String billtype, java.lang.Long discminu, java.lang.String vpmnid, java.lang.Byte schedsendflag, java.lang.String currbillcode, java.lang.Byte paybyothersflag, java.lang.Long discnum, java.lang.Double rate1, java.lang.Long beginnum1, java.lang.Long endnum1, java.lang.Double rate2, java.lang.Long beginnum2, java.lang.Long endnum2, java.lang.Double rate3, java.lang.Long beginnum3, java.lang.Long endnum3, java.lang.String ratingtype, java.lang.String remark, java.lang.Long groupfreecount, java.lang.Double groupfreefee) {
        this.yxplanid = yxplanid;
        this.wrapoutrate = wrapoutrate;
        this.wrapinrate = wrapinrate;
        this.wrapminute = wrapminute;
        this.wrapfee = wrapfee;
        this.acctid = acctid;
        this.areacod = areacode;
        this.areagroupid = areagroupid;
        this.disccondition = disccondition;
        this.calltype = calltype;
        this.busyrate = busyrate;
        this.freerate = freerate;
        this.ipdisc = ipdisc;
        this.disckind = disckind;
        this.discscope = discscope;
        this.lowmobile = lowmobile;
        this.highmobile = highmobile;
        this.disclocalcode = disclocalcode;
        this.discdistrict = discdistrict;
        this.wnzjdiscrate = wnzjdiscrate;
        this.wwzjdiscrate = wwzjdiscrate;
        this.wnbjdiscrate = wnbjdiscrate;
        this.wwbjdiscrate = wwbjdiscrate;
        this.rate = rate;
        this.disctype = disctype;
        this.deratecomm = deratecomm;
        this.deraterent = deraterent;
        this.deratefunc = deratefunc;
        this.minamt = minamt;
        this.maxamt = maxamt;
        this.billtype = billtype;
        this.discminu = discminu;
        this.vpmnid = vpmnid;
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
        this.groupfreecount = groupfreecount;
        this.groupfreefee = groupfreefee;
    }

    
    
    public Long getSmsinfoupload() {
		return smsinfoupload;
	}



	public void setSmsinfoupload(Long smsinfoupload) {
		this.smsinfoupload = smsinfoupload;
	}



	public Long getEndnum6() {
		return endnum6;
	}


	public void setEndnum6(Long endnum6) {
		this.endnum6 = endnum6;
	}


	/** default constructor */
    public FeediscVO() {
    }

    /** minimal constructor */
    public FeediscVO(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Long getFeediscid() {
        return this.feediscid;
    }

    public void setFeediscid(java.lang.Long feediscid) {
        this.feediscid = feediscid;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Double getWrapoutrate() {
        return this.wrapoutrate;
    }

    public void setWrapoutrate(java.lang.Double wrapoutrate) {
        this.wrapoutrate = wrapoutrate;
    }

    public java.lang.Double getWrapinrate() {
        return this.wrapinrate;
    }

    public void setWrapinrate(java.lang.Double wrapinrate) {
        this.wrapinrate = wrapinrate;
    }

    public java.lang.Long getWrapminute() {
        return this.wrapminute;
    }

    public void setWrapminute(java.lang.Long wrapminute) {
        this.wrapminute = wrapminute;
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

    public java.lang.String getAreacod() {
        return this.areacod;
    }

    public void setAreacod(java.lang.String areacode) {
        this.areacod = areacode;
    }

    public java.lang.Long getAreagroupid() {
        return this.areagroupid;
    }

    public void setAreagroupid(java.lang.Long areagroupid) {
        this.areagroupid = areagroupid;
    }

    public java.lang.String getDisccondition() {
        return this.disccondition;
    }

    public void setDisccondition(java.lang.String disccondition) {
        this.disccondition = disccondition;
    }

    public java.lang.String getCalltype() {
        return this.calltype;
    }

    public void setCalltype(java.lang.String calltype) {
        this.calltype = calltype;
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

    public java.lang.Double getIpdisc() {
        return this.ipdisc;
    }

    public void setIpdisc(java.lang.Double ipdisc) {
        this.ipdisc = ipdisc;
    }

    public java.lang.String getDisckind() {
        return this.disckind;
    }

    public void setDisckind(java.lang.String disckind) {
        this.disckind = disckind;
    }

    public java.lang.String getDiscscope() {
        return this.discscope;
    }

    public void setDiscscope(java.lang.String discscope) {
        this.discscope = discscope;
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

    public java.lang.String getDisclocalcode() {
        return this.disclocalcode;
    }

    public void setDisclocalcode(java.lang.String disclocalcode) {
        this.disclocalcode = disclocalcode;
    }

    public java.lang.String getDiscdistrict() {
        return this.discdistrict;
    }

    public void setDiscdistrict(java.lang.String discdistrict) {
        this.discdistrict = discdistrict;
    }

    public java.lang.Double getWnzjdiscrate() {
        return this.wnzjdiscrate;
    }

    public void setWnzjdiscrate(java.lang.Double wnzjdiscrate) {
        this.wnzjdiscrate = wnzjdiscrate;
    }

    public java.lang.Double getWwzjdiscrate() {
        return this.wwzjdiscrate;
    }

    public void setWwzjdiscrate(java.lang.Double wwzjdiscrate) {
        this.wwzjdiscrate = wwzjdiscrate;
    }

    public java.lang.Double getWnbjdiscrate() {
        return this.wnbjdiscrate;
    }

    public void setWnbjdiscrate(java.lang.Double wnbjdiscrate) {
        this.wnbjdiscrate = wnbjdiscrate;
    }

    public java.lang.Double getWwbjdiscrate() {
        return this.wwbjdiscrate;
    }

    public void setWwbjdiscrate(java.lang.Double wwbjdiscrate) {
        this.wwbjdiscrate = wwbjdiscrate;
    }

    public java.lang.Float getRate() {
        return this.rate;
    }

    public void setRate(java.lang.Float rate) {
        this.rate = rate;
    }

    public java.lang.String getDisctype() {
        return this.disctype;
    }

    public void setDisctype(java.lang.String disctype) {
        this.disctype = disctype;
    }

    public java.lang.Double getDeratecomm() {
        return this.deratecomm;
    }

    public void setDeratecomm(java.lang.Double deratecomm) {
        this.deratecomm = deratecomm;
    }

    public java.lang.Double getDeraterent() {
        return this.deraterent;
    }

    public void setDeraterent(java.lang.Double deraterent) {
        this.deraterent = deraterent;
    }

    public java.lang.Double getDeratefunc() {
        return this.deratefunc;
    }

    public void setDeratefunc(java.lang.Double deratefunc) {
        this.deratefunc = deratefunc;
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

    public java.lang.String getBilltype() {
        return this.billtype;
    }

    public void setBilltype(java.lang.String billtype) {
        this.billtype = billtype;
    }

    public java.lang.Long getDiscminu() {
        return this.discminu;
    }

    public void setDiscminu(java.lang.Long discminu) {
        this.discminu = discminu;
    }

    public java.lang.String getVpmnid() {
        return this.vpmnid;
    }

    public void setVpmnid(java.lang.String vpmnid) {
        this.vpmnid = vpmnid;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("feediscid", getFeediscid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof FeediscVO) ) return false;
        FeediscVO castOther = (FeediscVO) other;
        return new EqualsBuilder()
            .append(this.getFeediscid(), castOther.getFeediscid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFeediscid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return FeedisclogVO.class;
	}

	public Double getHalfwrapfee() {
		return halfwrapfee;
	}

	public void setHalfwrapfee(Double halfwrapfee) {
		this.halfwrapfee = halfwrapfee;
	}

	public String getAccessplatform() {
		return accessplatform;
	}

	public void setAccessplatform(String accessplatform) {
		this.accessplatform = accessplatform;
	}

	public String getBusitype() {
		return busitype;
	}

	public void setBusitype(String busitype) {
		this.busitype = busitype;
	}

	public Double getGotonedownrate() {
		return gotonedownrate;
	}

	public void setGotonedownrate(Double gotonedownrate) {
		this.gotonedownrate = gotonedownrate;
	}

	public Double getGotoneuprate() {
		return gotoneuprate;
	}

	public void setGotoneuprate(Double gotoneuprate) {
		this.gotoneuprate = gotoneuprate;
	}

	public Double getSmpdownrate() {
		return smpdownrate;
	}

	public void setSmpdownrate(Double smpdownrate) {
		this.smpdownrate = smpdownrate;
	}

	public Double getSmpuprate() {
		return smpuprate;
	}

	public void setSmpuprate(Double smpuprate) {
		this.smpuprate = smpuprate;
	}

	public Long getGroupfreecount() {
		return groupfreecount;
	}

	public void setGroupfreecount(Long groupfreecount) {
		this.groupfreecount = groupfreecount;
	}

	public Double getGroupfreefee() {
		return groupfreefee;
	}

	public void setGroupfreefee(Double groupfreefee) {
		this.groupfreefee = groupfreefee;
	}

	public Double getRate4() {
		return rate4;
	}

	public void setRate4(Double rate4) {
		this.rate4 = rate4;
	}

	public Long getBeginnum4() {
		return beginnum4;
	}

	public void setBeginnum4(Long beginnum4) {
		this.beginnum4 = beginnum4;
	}

	public Long getEndnum4() {
		return endnum4;
	}

	public void setEndnum4(Long endnum4) {
		this.endnum4 = endnum4;
	}

	public Double getRate5() {
		return rate5;
	}

	public void setRate5(Double rate5) {
		this.rate5 = rate5;
	}

	public Long getBeginnum5() {
		return beginnum5;
	}

	public void setBeginnum5(Long beginnum5) {
		this.beginnum5 = beginnum5;
	}

	public Long getEndnum5() {
		return endnum5;
	}

	public void setEndnum5(Long endnum5) {
		this.endnum5 = endnum5;
	}

	public Double getRate6() {
		return rate6;
	}

	public void setRate6(Double rate6) {
		this.rate6 = rate6;
	}

	public Long getBeginnum6() {
		return beginnum6;
	}

	public void setBeginnum6(Long beginnum6) {
		this.beginnum6 = beginnum6;
	}
	
}
