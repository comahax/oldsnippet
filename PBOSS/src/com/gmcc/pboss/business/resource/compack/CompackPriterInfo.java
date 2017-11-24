package com.gmcc.pboss.business.resource.compack;

import java.util.Date;

/**
 * 套卡包装(箱号或盒号)打印结果信息类
 * @author zhangsiwei
 */
public class CompackPriterInfo {

	/**箱号*/
	private String trunk_number;
	/**盒号*/
	private String box_number;
	/**商品标识*/
	private String comname;
	/**数量*/
	private int amount;
	/**分公司*/
	private String countyname;
	/**最后激活期*/
	private Date comactiveDate;
	
	public String getTrunk_number() {
		return trunk_number;
	}
	public void setTrunk_number(String trunk_number) {
		this.trunk_number = trunk_number;
	}
	public String getBox_number() {
		return box_number;
	}
	public void setBox_number(String box_number) {
		this.box_number = box_number;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCountyname() {
		return countyname;
	}
	public void setCountyname(String countyname) {
		this.countyname = countyname;
	}
	public Date getComactiveDate() {
		return comactiveDate;
	}
	public void setComactiveDate(Date comactiveDate) {
		this.comactiveDate = comactiveDate;
	}
	
}
