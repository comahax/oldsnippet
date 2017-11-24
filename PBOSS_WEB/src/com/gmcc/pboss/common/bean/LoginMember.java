package com.gmcc.pboss.common.bean;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.Role;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-7-29
 * ������Ŀ��
 * ����ģ�飺
 * �������û���¼����Session�еĶ���
 */
public class LoginMember implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7886524711501313042L;
	
	/**���������*/
	private String 	officetel;
	/**��������*/
	private String wayid;
	/**���б�ʶ*/
	private String cityid;
	/**���б��*/
	private String cityno;
	/**����*/
	private String employeename;
	/**��Ա����*/
	private String oprcode;
	/**�Ƿ�Ϊ���� isnet=0 ��ʾ ��Ա��isnet=1 ��ʾ ����,isnet=5 ��ʾ ʡ��˾����Ա,isnet=6 ��ʾ �й�˾����Ա*/
	private Long isnet;
	/**��ɫ����*/
	private String roleName;
	/**���ڷ�����*/
	private String servoffice;
	/**��ԱId ���ڲ�ѯ��������ʱʹ��*/
	private String employeeid;
	/**����*/
	private Channel channel;
	/**�Ƿ���ʾ���ģ��*/
	private String isShowReward;
	/**�Ƿ���ʾ���س��ģ��*/
	private String isShowLocalReward;
	/**����������-�տ�������*/
	private String recpers;
	/**����������-�տ����˻�*/
	private String acctno;
	/**����������-�տ��˿�����*/
	private String bankname;
	/**�ϼ�������������*/
	private String magName;
	/**�˵�����ԴӸ���ʼ���±��������� */
	private Map<String,ArrayList> menuMap;
	/**��Ա����*/
	private Short empattr2;
	/**��ϵ�绰*/
	private String telephone;
	/**�ӳ���Ϣ�Ƿ���� 2012-07-12 ʷ���� */
	private boolean infoloaded;
	
	/*
	private String employeeid;
	private String oprcode;
	private Date birthday;
	private Long sex;
	private Long edulevel;
	private String nativehome;
	private Long polivisage;
	private String department;
	private Long station;
	private Long joblevel;
	private Date intime;
	private Long worktime;
	private Long hereworktime;
	private Long employtype;
	private String company;
	private String telephone;
	private String officetel;
	private Date outtime;
	private String outresult;
	private String homeaddr;
	private String cardid;
	private String waytype;
	private String pvtemail;
	private String ofcphone;
	private String ofcemail;
	private String speciality;
	private String countyid;
	private String svccode;
	private String posittype;
	private Long contacttype;
	private Long empstatus;
	private String actbank;
	private String actno;
	private String actname;
	private String actpid;
	private Double bail;
	private String gradschool;
	private Date gradtime;
	private Long ismarried;
	private Long outreason;
	private String trainlevel;
	private String hobby;
	private String character;
	private String asses;
	private String workhistry;
	private String prizeorpunish;
	private String empass;
	private Long right;
	private String netpass;
	private Long isopen;
	private String selectmobile;
	*/
	/**��ɫ����*/
	public String getRoleName() {
		//return roleName = (this.isnet == Long.valueOf("1"))?"����":"��Ա";
		return Role.getRoleName(isnet.intValue());
	}
	/**��������*/
	public String getWayid() {
		return wayid;
	}
	/**��������*/
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	/**���б�ʶ*/
	public String getCityid() {
		return cityid;
	}
	/**���б�ʶ*/
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	/**����*/
	public String getEmployeename() {
		return employeename;
	}
	/**����*/
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	/**��Ա����*/
	public String getOprcode() {
		return oprcode;
	}
	/**��Ա����*/
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	/**�Ƿ�Ϊ���� isnet=0 ��ʾ ��Ա��isnet=1 ��ʾ ����,isnet=5 ��ʾ ʡ��˾����Ա,isnet=6 ��ʾ �й�˾����Ա*/
	public Long getIsnet() {
		return isnet;
	}
	/**�Ƿ�Ϊ���� isnet=0 ��ʾ ��Ա��isnet=1 ��ʾ ����,isnet=5 ��ʾ ʡ��˾����Ա,isnet=6 ��ʾ �й�˾����Ա*/
	public void setIsnet(Long isnet) {
		this.isnet = isnet;
	}
	/**���ڷ�����*/
	public String getServoffice() {
		return servoffice;
	}
	/**���ڷ�����*/
	public void setServoffice(String servoffice) {
		this.servoffice = servoffice;
	}
	/**���������*/
	public String getOfficetel() {
		return officetel;
	}
	/**���������*/
	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}
	/**���б��*/
	public String getCityno() {
		return cityno;
	}
	/**���б��*/
	public void setCityno(String cityid) {
		this.cityno = Constant.getConstantName(ConstantsType.BRANCH_NO, cityid);
	}
	/**��ԱId ���ڲ�ѯ��������ʱʹ��*/
	public String getEmployeeid() {
		return employeeid;
	}
	/**��ԱId ���ڲ�ѯ��������ʱʹ��*/
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	/**����*/
	public Channel getChannel() {
		return channel;
	}
	/**����*/
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public String getIsShowReward() {
		return isShowReward;
	}
	public void setIsShowReward(String isShowReward) {
		this.isShowReward = isShowReward;
	}
	public String getIsShowLocalReward() {
		return isShowLocalReward;
	}
	public void setIsShowLocalReward(String isShowLocalReward) {
		this.isShowLocalReward = isShowLocalReward;
	}
	
	public String getRecpers() {
		return recpers;
	}
	public void setRecpers(String recpers) {
		this.recpers = recpers;
	}
	public String getAcctno() {
		return acctno;
	}
	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
	public String getMagName() {
		return magName;
	}
	public void setMagName(String magName) {
		this.magName = magName;
	}
	
	public Map<String, ArrayList> getMenuMap() {
		if(menuMap==null){
			menuMap = new HashMap<String,ArrayList>();
		}
		return menuMap;
	}
	public void setMenuMap(Map<String, ArrayList> menuMap) {
		this.menuMap = menuMap;
	}
	public Short getEmpattr2() {
		return empattr2;
	}
	public void setEmpattr2(Short empattr2) {
		this.empattr2 = empattr2;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public boolean isInfoloaded() {
		return infoloaded;
	}
	public void setInfoloaded(boolean infoloaded) {
		this.infoloaded = infoloaded;
	}
}
