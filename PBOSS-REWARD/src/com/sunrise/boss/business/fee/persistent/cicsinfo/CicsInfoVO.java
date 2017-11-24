package com.sunrise.boss.business.fee.persistent.cicsinfo;

import java.io.Serializable;

public class CicsInfoVO implements Serializable {
	
	private String regionid; //������
	private String regionname; //������,�罭��Ϊ'JM'
	private String ctgmain; //cics���ͻ���ip,����Զ�̵��÷�ʽʱʹ��
	private String ctgspare; //cics���ÿͻ���ip,����Զ�̵��÷�ʽʱʹ��
	private Long ctgport; //cics�ͻ���ctg�˿�,һ��Ĭ��Ϊ2006
	private String cicsmain; //cics����������
	private String cicsspare; //cics���û�������
	private String cicsuser; //cics�û���
	private String cicspwd; //cics����
	
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
