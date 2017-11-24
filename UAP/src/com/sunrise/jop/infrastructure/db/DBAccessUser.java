package com.sunrise.jop.infrastructure.db;

import java.io.Serializable;

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
	private String cityid;  //数据所在地市ID(数字如：757)
	private String ip;  //访问的来源IP
	private String dbFlag; //数据源标识，取值：集团库GDIB、出账库XXBILL、个人库XXIB
	
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

	public String getDbFlag() {
		return dbFlag;
	}

	public void setDbFlag(String dbFlag) {
		this.dbFlag = dbFlag;
	}

	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}

	public static DBAccessUser getInnerUser() throws Exception{
		DBAccessUser innerUser = new DBAccessUser();
		innerUser.setCityid("999");
		innerUser.setDbFlag(DBConstant.DB_FLAG_COMMON);
		innerUser.setOprcode("root");
		innerUser.setIp("127.0.0.1");
		return innerUser;
	}
	
	//增加使用登录user获取公共库user的方法 change by panmeifa 2014-01-15
	public static DBAccessUser getCommonUser(DBAccessUser user) throws Exception{
		DBAccessUser commUser = new DBAccessUser();
		commUser.setDbFlag(DBConstant.DB_FLAG_COMMON);
		if (user != null){
			commUser.setOprcode(user.getOprcode());
			commUser.setIp(user.getIp());
			commUser.setCityid(user.getCityid());
		}
		return commUser;
	}
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
