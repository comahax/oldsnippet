package com.sunrise.boss.business.resmanage.common.excelout;

import java.sql.ResultSet;
import java.util.List;

public class ExceloutRet {
	private List datas;
	private ResultSet rs;
	private boolean haveDatas;

	public boolean isHaveDatas() {
		return haveDatas;
	}
	public void setHaveDatas(boolean haveDatas) {
		this.haveDatas = haveDatas;
	}
	public List getDatas() {
		return datas;
	}
	public void setDatas(List datas) {
		this.datas = datas;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
}
