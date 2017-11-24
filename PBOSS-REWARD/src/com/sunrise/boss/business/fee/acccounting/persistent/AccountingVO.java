package com.sunrise.boss.business.fee.acccounting.persistent;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleVO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;
import com.sunrise.boss.common.base.db.BaseListVO;



public class AccountingVO extends BaseListVO implements java.io.Serializable  {


	private String message;    //������Ϣ
	private String onlybrt;    //Ĭ�ϲ�ѯ��������,trueֻ��ѯ��Ч��������
	private String isshowlog;    //��ѯ��־ 101 102 103 104 * 
	
	
	
	private String cityid;     //�б�ʶ
	private String cityname;       //�й�˾����
	private BlTouchRuleVO btrvo;  //��������vo
	private ValidBillCycVO vbcvo;  //��Ч��������vo
	
	private String[] citygroup; //�б�ʶ��
	private String _ne_validbillcyc; //��������
	private String _se_batchnum;  //����
	private String regiongroup;  //û��,�������У���ѯ�����ֶ�
	private String stepKey;		//�ڵ�ؼ���
	
	private String _se_subphase;
	private String _se_billingphase;
	
	private String startstep;    //д����������־��,���ʲ��� 101,102,103,104,105
	
	private String startrsn; 	//д����������־��,����ԭ��
	
	private List isrestart; 
	
	//������־�Ӳ���
	private List fixlist;
	private List usrlist;
	private List acclist;
	private List cfmlist;
	private List redlist;
	
	
	public String getStepKey() {
		return stepKey;
	}
	public void setStepKey(String stepKey) {
		this.stepKey = stepKey;
	}
	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}
	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}
	public String get_se_batchnum() {
		return _se_batchnum;
	}
	public void set_se_batchnum(String _se_batchnum) {
		this._se_batchnum = _se_batchnum;
	}

	public String getRegiongroup() {
		return regiongroup;
	}
	public void setRegiongroup(String regiongroup) {
		this.citygroup = StringUtils.split(regiongroup, ",");
	}
	public BlTouchRuleVO getBtrvo() {
		return btrvo;
	}
	public void setBtrvo(BlTouchRuleVO btrvo) {
		this.btrvo = btrvo;
	}
	public String getCityname() {
		return cityname;
	}
	
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ValidBillCycVO getVbcvo() {
		return vbcvo;
	}
	public void setVbcvo(ValidBillCycVO vbcvo) {
		this.vbcvo = vbcvo;
	}
	public String[] getCitygroup() {
		return citygroup;
	}
	public void setCitygroup(String[] citygroup) {
		this.citygroup = citygroup;
	}
	public String get_se_billingphase() {
		return _se_billingphase;
	}
	public void set_se_billingphase(String _se_billingphase) {
		this._se_billingphase = _se_billingphase;
	}
	public String get_se_subphase() {
		return _se_subphase;
	}
	public void set_se_subphase(String _se_subphase) {
		this._se_subphase = _se_subphase;
	}
	public String getOnlybrt() {
		return onlybrt;
	}
	public void setOnlybrt(String onlybrt) {
		this.onlybrt = onlybrt;
	}
	public String getStartrsn() {
		return startrsn;
	}
	public void setStartrsn(String startrsn) {
		this.startrsn = startrsn;
	}
	public String getStartstep() {
		return startstep;
	}
	public void setStartstep(String startstep) {
		this.startstep = startstep;
	}
	public List getAcclist() {
		return acclist;
	}
	public void setAcclist(List acclist) {
		this.acclist = acclist;
	}
	public List getCfmlist() {
		return cfmlist;
	}
	public void setCfmlist(List cfmlist) {
		this.cfmlist = cfmlist;
	}
	public List getFixlist() {
		return fixlist;
	}
	public void setFixlist(List fixlist) {
		this.fixlist = fixlist;
	}
	public List getUsrlist() {
		return usrlist;
	}
	public void setUsrlist(List usrlist) {
		this.usrlist = usrlist;
	}
	public String getIsshowlog() {
		return isshowlog;
	}
	public void setIsshowlog(String isshowlog) {
		this.isshowlog = isshowlog;
	}
	public List getIsrestart() {
		return isrestart;
	}
	public void setIsrestart(List isrestart) {
		this.isrestart = isrestart;
	}
	public List getRedlist() {
		return redlist;
	}
	public void setRedlist(List redlist) {
		this.redlist = redlist;
	}

	

	
}