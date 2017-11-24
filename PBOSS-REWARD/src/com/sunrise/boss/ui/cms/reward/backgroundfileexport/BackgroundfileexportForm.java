package com.sunrise.boss.ui.cms.reward.backgroundfileexport;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: FaildataqueryForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author 	Linli
 * @version 1.0
 */
public class BackgroundfileexportForm extends BaseActionForm {
	
	private String calcmonth;
	private String cityid;
	
	public String getCalcmonth() {
		return calcmonth;
	}
	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	
}
