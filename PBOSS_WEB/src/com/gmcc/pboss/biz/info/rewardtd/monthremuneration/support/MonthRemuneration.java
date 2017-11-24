package com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support;

public class MonthRemuneration {
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

	private String tbusicnt1;
	private String tbusicnt2;
	private String tbusicnt3;
	private String tbusicnt4;
	private String tbusicnt5;
	private String tbusicnt6;
	private String tbusicnt7;
	
	private String tpasscnt1;
	private String tpasscnt2;
	private String tpasscnt3;
	private String tpasscnt4;
	private String tpasscnt5;
	private String tpasscnt6;
	private String tpasscnt7;
	
	private double trwmoney1;
	private double trwmoney2;
	private double trwmoney3;
	private double trwmoney4;
	private double trwmoney5;
	private double trwmoney6;
	private double trwmoney7;
	
	private String sumbusicnt;
	private String sumpasscnt;
	private double sumrwmoney;
	
	//附加属性 为页面分组显示用 
	private int rwmonCount = 1; 
	private int custtypeCount = 1;
	private int rwtypenameCount = 1;
	private int chkitemnameCount = 1;
	
	public MonthRemuneration() {
		super();
	}

	public MonthRemuneration(int id, String wayid, int waytype, String custtype,
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

	public String getTbusicnt1() {
		return tbusicnt1;
	}

	public void setTbusicnt1(String tbusicnt1) {
		this.tbusicnt1 = tbusicnt1;
	}

	public String getTbusicnt2() {
		return tbusicnt2;
	}

	public void setTbusicnt2(String tbusicnt2) {
		this.tbusicnt2 = tbusicnt2;
	}

	public String getTbusicnt3() {
		return tbusicnt3;
	}

	public void setTbusicnt3(String tbusicnt3) {
		this.tbusicnt3 = tbusicnt3;
	}

	public String getTbusicnt4() {
		return tbusicnt4;
	}

	public void setTbusicnt4(String tbusicnt4) {
		this.tbusicnt4 = tbusicnt4;
	}

	public String getTbusicnt5() {
		return tbusicnt5;
	}

	public void setTbusicnt5(String tbusicnt5) {
		this.tbusicnt5 = tbusicnt5;
	}

	public String getTbusicnt6() {
		return tbusicnt6;
	}

	public void setTbusicnt6(String tbusicnt6) {
		this.tbusicnt6 = tbusicnt6;
	}

	public String getTbusicnt7() {
		return tbusicnt7;
	}

	public void setTbusicnt7(String tbusicnt7) {
		this.tbusicnt7 = tbusicnt7;
	}

	public String getTpasscnt1() {
		return tpasscnt1;
	}

	public void setTpasscnt1(String tpasscnt1) {
		this.tpasscnt1 = tpasscnt1;
	}

	public String getTpasscnt2() {
		return tpasscnt2;
	}

	public void setTpasscnt2(String tpasscnt2) {
		this.tpasscnt2 = tpasscnt2;
	}

	public String getTpasscnt3() {
		return tpasscnt3;
	}

	public void setTpasscnt3(String tpasscnt3) {
		this.tpasscnt3 = tpasscnt3;
	}

	public String getTpasscnt4() {
		return tpasscnt4;
	}

	public void setTpasscnt4(String tpasscnt4) {
		this.tpasscnt4 = tpasscnt4;
	}

	public String getTpasscnt5() {
		return tpasscnt5;
	}

	public void setTpasscnt5(String tpasscnt5) {
		this.tpasscnt5 = tpasscnt5;
	}

	public String getTpasscnt6() {
		return tpasscnt6;
	}

	public void setTpasscnt6(String tpasscnt6) {
		this.tpasscnt6 = tpasscnt6;
	}

	public String getTpasscnt7() {
		return tpasscnt7;
	}

	public void setTpasscnt7(String tpasscnt7) {
		this.tpasscnt7 = tpasscnt7;
	}

	
	public double getTrwmoney1() {
		return trwmoney1;
	}

	public void setTrwmoney1(double trwmoney1) {
		this.trwmoney1 = trwmoney1;
	}

	public double getTrwmoney2() {
		return trwmoney2;
	}

	public void setTrwmoney2(double trwmoney2) {
		this.trwmoney2 = trwmoney2;
	}

	public double getTrwmoney3() {
		return trwmoney3;
	}

	public void setTrwmoney3(double trwmoney3) {
		this.trwmoney3 = trwmoney3;
	}

	public double getTrwmoney4() {
		return trwmoney4;
	}

	public void setTrwmoney4(double trwmoney4) {
		this.trwmoney4 = trwmoney4;
	}

	public double getTrwmoney5() {
		return trwmoney5;
	}

	public void setTrwmoney5(double trwmoney5) {
		this.trwmoney5 = trwmoney5;
	}

	public double getTrwmoney6() {
		return trwmoney6;
	}

	public void setTrwmoney6(double trwmoney6) {
		this.trwmoney6 = trwmoney6;
	}

	public double getTrwmoney7() {
		return trwmoney7;
	}

	public void setTrwmoney7(double trwmoney7) {
		this.trwmoney7 = trwmoney7;
	}

	public String getSumbusicnt() {
		return sumbusicnt;
	}

	public void setSumbusicnt(String sumbusicnt) {
		this.sumbusicnt = sumbusicnt;
	}

	public String getSumpasscnt() {
		return sumpasscnt;
	}

	public void setSumpasscnt(String sumpasscnt) {
		this.sumpasscnt = sumpasscnt;
	}

	public double getSumrwmoney() {
		return sumrwmoney;
	}

	public void setSumrwmoney(double sumrwmoney) {
		this.sumrwmoney = sumrwmoney;
	}

	public int getRwmonCount() {
		return rwmonCount;
	}

	public void setRwmonCount(int rwmonCount) {
		this.rwmonCount = rwmonCount;
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

}
