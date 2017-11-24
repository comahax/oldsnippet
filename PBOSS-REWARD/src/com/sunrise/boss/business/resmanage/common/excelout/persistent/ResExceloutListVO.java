package com.sunrise.boss.business.resmanage.common.excelout.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

public class ResExceloutListVO extends BaseListVO {
	private String startindex;

	private String endindex;
	
	private boolean isExport = false;

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

	public boolean isExport() {
		return isExport;
	}

	public void setExport(boolean isExport) {
		this.isExport = isExport;
	}

}
