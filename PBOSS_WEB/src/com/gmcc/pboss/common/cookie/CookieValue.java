package com.gmcc.pboss.common.cookie;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-11-4
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：Cookie的值
 */
public class CookieValue {
	/**用户名*/
	private String user;
	
	/**值*/
	private String value;
	
	/**保存时间：单位s*/
	private int saveTime;
	
	/**保存路径*/
	private String savePath;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(int saveTime) {
		this.saveTime = saveTime;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	
	
}
