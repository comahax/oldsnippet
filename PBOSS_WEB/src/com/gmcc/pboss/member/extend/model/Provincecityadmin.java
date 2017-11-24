package com.gmcc.pboss.member.extend.model;

import java.util.Date;

import com.gmcc.pboss.common.bean.CodeReverse;


/**
 * ChPwEmployee entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Provincecityadmin extends CodeReverse implements java.io.Serializable {

	
	private long mobile;
	private String cityid;
	private String password;
	private long isnet;







	public long getMobile() {
		return mobile;
	}



	public void setMobile(long mobile) {
		this.mobile = mobile;
	}



	public String getCityid() {
		return cityid;
	}



	public void setCityid(String cityid) {
		this.cityid = cityid;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public long getIsnet() {
		return isnet;
	}



	public void setIsnet(long isnet) {
		this.isnet = isnet;
	}
}