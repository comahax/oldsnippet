package com.sunrise.boss.business.resmanage.common;

import com.sunrise.boss.common.base.db.BaseListVO;

public class ResExceloutListVO extends BaseListVO {
	private String startindex;

	private String endindex;

	public String getEndindex() {
		return endindex;
	}

	public void setEndindex(String endindex) {
		this.endindex = endindex;
	}

	public String getStartindex() {
		return startindex;
	}

	public void setStartindex(String startindex) {
		this.startindex = startindex;
	}

}
