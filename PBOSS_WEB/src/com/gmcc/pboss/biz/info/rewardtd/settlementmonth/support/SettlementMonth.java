package com.gmcc.pboss.biz.info.rewardtd.settlementmonth.support;


public class SettlementMonth {
	private int id;
	private String wayid;
	private int waytype;
	private int custtype;
	private String oprmon;
	private String rwmon;
	private int period;
	private int rwperiod;
	private int chkitemid;
	private int opnid;
	private String rwtypename;
	private String imei;
	private String comid;
	private String comname;
	private String mainno;
	private String bchksucc;
	private double calcrwmoney;
	private double rwmoney;
	private String failrsn;
	private String updtime;

	public SettlementMonth() {
		super();
	}

	public SettlementMonth(int id, String wayid, int waytype, int custtype,
			String oprmon, String rwmon, int period, int rwperiod, int chkitemid,
			int opnid, String rwtypename, String imei, String comid,
			String comname, String mainno, String bchksucc, double calcrwmoney,
			double rwmoney, String failrsn, String updtime) {
		this.id = id;
		this.wayid = wayid;
		this.waytype = waytype;
		this.custtype = custtype;
		this.oprmon = oprmon;
		this.rwmon = rwmon;
		this.period = period;
		this.rwperiod = rwperiod;
		this.chkitemid = chkitemid;
		this.opnid = opnid;
		this.rwtypename = rwtypename;
		this.imei = imei;
		this.comid = comid;
		this.comname = comname;
		this.mainno = mainno;
		this.bchksucc = bchksucc;
		this.calcrwmoney = calcrwmoney;
		this.rwmoney = rwmoney;
		this.failrsn = failrsn;
		this.updtime = updtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public int getWaytype() {
		return waytype;
	}

	public void setWaytype(int waytype) {
		this.waytype = waytype;
	}

	public int getCusttype() {
		return custtype;
	}

	public void setCusttype(int custtype) {
		this.custtype = custtype;
	}

	public String getOprmon() {
		return oprmon;
	}

	public void setOprmon(String oprmon) {
		this.oprmon = oprmon;
	}

	public String getRwmon() {
		return rwmon;
	}

	public void setRwmon(String rwmon) {
		this.rwmon = rwmon;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getRwperiod() {
		return rwperiod;
	}

	public void setRwperiod(int rwperiod) {
		this.rwperiod = rwperiod;
	}

	public int getChkitemid() {
		return chkitemid;
	}

	public void setChkitemid(int chkitemid) {
		this.chkitemid = chkitemid;
	}

	public int getOpnid() {
		return opnid;
	}

	public void setOpnid(int opnid) {
		this.opnid = opnid;
	}

	public String getRwtypename() {
		return rwtypename;
	}

	public void setRwtypename(String rwtypename) {
		this.rwtypename = rwtypename;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public String getMainno() {
		return mainno;
	}

	public void setMainno(String mainno) {
		this.mainno = mainno;
	}

	public String getBchksucc() {
		return bchksucc;
	}

	public void setBchksucc(String bchksucc) {
		this.bchksucc = bchksucc;
	}

	public double getCalcrwmoney() {
		return calcrwmoney;
	}

	public void setCalcrwmoney(double calcrwmoney) {
		this.calcrwmoney = calcrwmoney;
	}

	public double getRwmoney() {
		return rwmoney;
	}

	public void setRwmoney(double rwmoney) {
		this.rwmoney = rwmoney;
	}

	public String getFailrsn() {
		return failrsn;
	}

	public void setFailrsn(String failrsn) {
		this.failrsn = failrsn;
	}

	public String getUpdtime() {
		return updtime;
	}

	public void setUpdtime(String updtime) {
		this.updtime = updtime;
	}

}
