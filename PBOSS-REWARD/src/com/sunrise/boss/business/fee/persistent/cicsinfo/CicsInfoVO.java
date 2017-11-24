package com.sunrise.boss.business.fee.persistent.cicsinfo;

import java.io.Serializable;

public class CicsInfoVO implements Serializable {
	
	private String regionid; //区域编号
	private String regionname; //区域简称,如江门为'JM'
	private String ctgmain; //cics主客户端ip,采用远程调用方式时使用
	private String ctgspare; //cics备用客户端ip,采用远程调用方式时使用
	private Long ctgport; //cics客户端ctg端口,一般默认为2006
	private String cicsmain; //cics主机服务名
	private String cicsspare; //cics备用机服务名
	private String cicsuser; //cics用户名
	private String cicspwd; //cics密码
	
	public String getCicsmain() {
		return cicsmain;
	}
	public void setCicsmain(String cicsmain) {
		this.cicsmain = cicsmain;
	}
	public String getCicspwd() {
		return cicspwd;
	}
	public void setCicspwd(String cicspwd) {
		this.cicspwd = cicspwd;
	}
	public String getCicsspare() {
		return cicsspare;
	}
	public void setCicsspare(String cicsspare) {
		this.cicsspare = cicsspare;
	}
	public String getCicsuser() {
		return cicsuser;
	}
	public void setCicsuser(String cicsuser) {
		this.cicsuser = cicsuser;
	}
	public String getCtgmain() {
		return ctgmain;
	}
	public void setCtgmain(String ctgmain) {
		this.ctgmain = ctgmain;
	}
	public Long getCtgport() {
		return ctgport;
	}
	public void setCtgport(Long ctgport) {
		this.ctgport = ctgport;
	}
	public String getCtgspare() {
		return ctgspare;
	}
	public void setCtgspare(String ctgspare) {
		this.ctgspare = ctgspare;
	}
	public String getRegionid() {
		return regionid;
	}
	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}
	public String getRegionname() {
		return regionname;
	}
	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}
}
