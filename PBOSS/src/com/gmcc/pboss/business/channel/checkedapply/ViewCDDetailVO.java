package com.gmcc.pboss.business.channel.checkedapply;

public class ViewCDDetailVO {
	
	private String cityid;
	private String applytype;
	private String status;
	private String wayid;
	
	private String wayname;
	private String countyid;//�ֹ�˾
	private String oprtime;//���ʱ��
	private String oprcode2;//�����
	private String oprcode;//���빤��
	private String wtype;//��������
	private String chktype;//���˷�ʽ
	
	private String istop;//��Ǳ�����㡢ʡ�������������㡢Ŀ��������
	
	private String waystatus;
	
	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getApplytype() {
		return applytype;
	}

	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getOprtime() {
		return oprtime;
	}

	public void setOprtime(String oprtime) {
		this.oprtime = oprtime;
	}

	public String getOprcode2() {
		return oprcode2;
	}

	public void setOprcode2(String oprcode2) {
		this.oprcode2 = oprcode2;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getWtype() {
		return wtype;
	}

	public void setWtype(String wtype) {
		this.wtype = wtype;
	}

	public String getChktype() {
		return chktype;
	}

	public void setChktype(String chktype) {
		this.chktype = chktype;
	}

	public String getWaystatus() {
		return waystatus;
	}

	public void setWaystatus(String waystatus) {
		this.waystatus = waystatus;
	}
}
