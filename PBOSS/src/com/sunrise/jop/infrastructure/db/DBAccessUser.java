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
 * @version 1.1 增加IP参数
 */
public class DBAccessUser implements Serializable {

	private static final long serialVersionUID = 3628497740671279410L;

	private String oprcode;  //操作员编号
	private String cityid;  //数据所在地市ID(字母)
	private String ip;  //访问的来源IP
	private String macAddr;
	private String remoteName;
	
	
	
	//危险操作,一旦修改了innerUser内置用户的属性给修改了,所有用户的登录状态都会受到影响
	//比如本来innerUser为999
	//A用户如果是由 static块获取用户的话, 修改user的cityid为A会把innerUser内置用户的cityid刷为A
	//B用户登录如果也是由 static块获取用户的话, 获取cityid亦为A
	//详细见main方法实现
	
//	private static final DBAccessUser innerUser;
//	
//	static  {
//		//内置的用户， 用于code2name, 登录检查，权限检查等内部操作，如果需要，可以修改默认用户的cityid等属性。
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
