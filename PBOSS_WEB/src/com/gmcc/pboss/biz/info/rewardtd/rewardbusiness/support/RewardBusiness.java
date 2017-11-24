package com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.support;

public class RewardBusiness {
	private int id;
	private String wayid;
	private int waytype;
	private String oprmon;
	private String rwmon;
	private int rwperiod;
	private int chkitemid;
	private int opnid;
	private String rwtypename;
	private String imei;
	private String comid;
	private String comname;
	private String mainno;
	private int bchksucc;
	private double calcrwmoney;
	private double rwmoney;
	private String failrsn;
	private String updtime;
	
	//int>String
	private String custtype;
	private String period;
	
	
	
	private String chkitemname;
	private String rwstd;

	private String trwstd1;
	private String trwstd2;
	private String trwstd3;
	private String trwstd4;
	private String trwstd5;
	private String trwstd6;
	private String trwstd7;
	
//	private String tpasscnt1;
//	private String tpasscnt2;
//	private String tpasscnt3;
//	private String tpasscnt4;
//	private String tpasscnt5;
//	private String tpasscnt6;
//	private String tpasscnt7;
	
	private String trwmoney1;
	private String trwmoney2;
	private String trwmoney3;
	private String trwmoney4;
	private String trwmoney5;
	private String trwmoney6;
	private String trwmoney7;
	
	private String rwhlvl;
	private String busicnt;
	private String maxrwmoney;
	
	//附加属性 为页面分组显示用 
	private int oprmonCount = 1; 
	private int custtypeCount = 1;
	private int rwtypenameCount = 1;
	private int chkitemnameCount = 1;
	
	public RewardBusiness() {
		super();
	}

	public RewardBusiness(int id, String wayid, int waytype, String custtype,
			String oprmon, String rwmon, String period, int rwperiod, int chkitemid,
			int opnid, String rwtypename, String imei, String comid,
			String comname, String mainno, int bchksucc, double calcrwmoney,
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

	public int getBchksucc() {
		return bchksucc;
	}

	public void setBchksucc(int bchksucc) {
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

	public String getCusttype() {
		return custtype;
	}

	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getChkitemname() {
		return chkitemname;
	}

	public void setChkitemname(String chkitemname) {
		this.chkitemname = chkitemname;
	}

	public String getRwstd() {
		return rwstd;
	}

	public void setRwstd(String rwstd) {
		this.rwstd = rwstd;
	}

	public int getOprmonCount() {
		return oprmonCount;
	}

	public void setOprmonCount(int oprmonCount) {
		this.oprmonCount = oprmonCount;
	}

	public int getCusttypeCount() {
		return custtypeCount;
	}

	public void setCusttypeCount(int custtypeCount) {
		this.custtypeCount = custtypeCount;
	}

	public int getRwtypenameCount() {
		return rwtypenameCount;
	}

	public void setRwtypenameCount(int rwtypenameCount) {
		this.rwtypenameCount = rwtypenameCount;
	}

	public int getChkitemnameCount() {
		return chkitemnameCount;
	}

	public void setChkitemnameCount(int chkitemnameCount) {
		this.chkitemnameCount = chkitemnameCount;
	}

	public String getTrwstd1() {
		return trwstd1;
	}

	public void setTrwstd1(String trwstd1) {
		this.trwstd1 = trwstd1;
	}

	public String getTrwstd2() {
		return trwstd2;
	}

	public void setTrwstd2(String trwstd2) {
		this.trwstd2 = trwstd2;
	}

	public String getTrwstd3() {
		return trwstd3;
	}

	public void setTrwstd3(String trwstd3) {
		this.trwstd3 = trwstd3;
	}

	public String getTrwstd4() {
		return trwstd4;
	}

	public void setTrwstd4(String trwstd4) {
		this.trwstd4 = trwstd4;
	}

	public String getTrwstd5() {
		return trwstd5;
	}

	public void setTrwstd5(String trwstd5) {
		this.trwstd5 = trwstd5;
	}

	public String getTrwstd6() {
		return trwstd6;
	}

	public void setTrwstd6(String trwstd6) {
		this.trwstd6 = trwstd6;
	}

	public String getTrwstd7() {
		return trwstd7;
	}

	public void setTrwstd7(String trwstd7) {
		this.trwstd7 = trwstd7;
	}

	public String getRwhlvl() {
		return rwhlvl;
	}

	public void setRwhlvl(String rwhlvl) {
		this.rwhlvl = rwhlvl;
	}

	public String getBusicnt() {
		return busicnt;
	}

	public void setBusicnt(String busicnt) {
		this.busicnt = busicnt;
	}

	public String getTrwmoney1() {
		return trwmoney1;
	}

	public void setTrwmoney1(String trwmoney1) {
		this.trwmoney1 = trwmoney1;
	}

	public String getTrwmoney2() {
		return trwmoney2;
	}

	public void setTrwmoney2(String trwmoney2) {
		this.trwmoney2 = trwmoney2;
	}

	public String getTrwmoney3() {
		return trwmoney3;
	}

	public void setTrwmoney3(String trwmoney3) {
		this.trwmoney3 = trwmoney3;
	}

	public String getTrwmoney4() {
		return trwmoney4;
	}

	public void setTrwmoney4(String trwmoney4) {
		this.trwmoney4 = trwmoney4;
	}

	public String getTrwmoney5() {
		return trwmoney5;
	}

	public void setTrwmoney5(String trwmoney5) {
		this.trwmoney5 = trwmoney5;
	}

	public String getTrwmoney6() {
		return trwmoney6;
	}

	public void setTrwmoney6(String trwmoney6) {
		this.trwmoney6 = trwmoney6;
	}

	public String getTrwmoney7() {
		return trwmoney7;
	}

	public void setTrwmoney7(String trwmoney7) {
		this.trwmoney7 = trwmoney7;
	}

	public String getMaxrwmoney() {
		return maxrwmoney;
	}

	public void setMaxrwmoney(String maxrwmoney) {
		this.maxrwmoney = maxrwmoney;
	}
	
}
