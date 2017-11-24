package com.sunrise.jop.infrastructure.db;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * <p>
 * Title: BOSS
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author HuangBaiming
 * @author He Kun
 * 
 * @version 1.0
 * @version 1.1 ����IP����
 */
public class DBAccessUser implements Serializable {

	private static final long serialVersionUID = 3628497740671279410L;

	private String oprcode;  //����Ա���
	private String cityid;  //�������ڵ���ID(��ĸ)
	private String ip;  //���ʵ���ԴIP
	private String macAddr;
	private String remoteName;
	
	
	
	//Σ�ղ���,һ���޸���innerUser�����û������Ը��޸���,�����û��ĵ�¼״̬�����ܵ�Ӱ��
	//���籾��innerUserΪ999
	//A�û�������� static���ȡ�û��Ļ�, �޸�user��cityidΪA���innerUser�����û���cityidˢΪA
	//B�û���¼���Ҳ���� static���ȡ�û��Ļ�, ��ȡcityid��ΪA
	//��ϸ��main����ʵ��
	
//	private static final DBAccessUser innerUser;
//	
//	static  {
//		//���õ��û��� ����code2name, ��¼��飬Ȩ�޼����ڲ������������Ҫ�������޸�Ĭ���û���cityid�����ԡ�
//		innerUser = new DBAccessUser();
//		innerUser.setCityid("DB_COMMON");
//		innerUser.setOprcode("root");
//		innerUser.setIp("127.0.0.1");
//	}
	
	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {	
		this.cityid = cityid;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getMacAddr() {
		return macAddr;
	}

	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}

	public String getRemoteName() {
		return remoteName;
	}

	public void setRemoteName(String remoteName) {
		this.remoteName = remoteName;
	}

	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}

	public static DBAccessUser getInnerUser() throws Exception{
		DBAccessUser innerUser = new DBAccessUser();
		innerUser.setCityid("DB_COMMON");
		innerUser.setOprcode("root");
		innerUser.setIp("127.0.0.1");
		return innerUser;
	}
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
