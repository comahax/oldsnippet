package com.sunrise.boss.ui.commons;

import java.io.Serializable;
import java.util.Date;

import com.sunrise.boss.common.base.db.SessionFactoryRouter;

/**
 * <p>
 * Title: GDIBOSS
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
 * 
 * @version 1.0
 */
public class User implements Serializable {

	private static final long serialVersionUID = 3628497740671279410L;

	private String opercode; //����Ա����

	private String opername; //����Ա����

	private String wayid;	//����

	private String cityid;  //����Ա���ڵ���ID

	private Date logintime; //��½ʱ��
	
	private boolean provinceUser = false; //�Ƿ�ȫʡ�û�
	

	public Date getLogintime() {
		return logintime;
	}

	public String getOpercode() {
		return opercode;
	}

	public String getOpername() {
		return opername;
	}

	public String getWayid() {
		return wayid;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	public void setOpercode(String opercode) {
		this.opercode = opercode;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public boolean isProvinceUser() {
		return provinceUser;
	}

	public void setProvinceUser(boolean provinceUser) {
		this.provinceUser = provinceUser;
	}
	
	
	public String toString(){
		StringBuffer result = new StringBuffer("User:");
		return result.append("[opercode=").append(opercode)
		.append("][opername=").append(opername)
		.append("][wayid=").append(wayid)
		.append("][cityid=").append(cityid)
		.append("][provinceUser=").append(provinceUser)
		.append("][logintime=").append(logintime).append("]")
		.toString();
	}
	

	//
	public String conversionCityid(){
		return SessionFactoryRouter.conversionCityid(this.cityid);
	}	
	
	

}
