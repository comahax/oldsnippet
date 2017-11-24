package com.gmcc.pboss.business.resource.wayrcstat;

import com.sunrise.jop.infrastructure.db.BaseVO;

/**
 * 网点资源信息统计 实时
 * 
 * @author liang.qichao
 * 
 */
public class WayrcstatVO extends BaseVO {

	private String wayid;

	private String brand;

	private String countyid;

	private String mareacode;

	private String wayname;

	private Long cnt1; // 库存量

	private Long cnt2; // 领货量

	private Long cnt3; // 激活量
	
//	private String statdate; // 快照日期, 历史查询使用
	
	public WayrcstatVO() {}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Long getCnt1() {
		return cnt1;
	}

	public void setCnt1(Long cnt1) {
		this.cnt1 = cnt1;
	}

	public Long getCnt2() {
		return cnt2;
	}

	public void setCnt2(Long cnt2) {
		this.cnt2 = cnt2;
	}

	public Long getCnt3() {
		return cnt3;
	}

	public void setCnt3(Long cnt3) {
		this.cnt3 = cnt3;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getMareacode() {
		return mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

//	public String getStatdate() {
//		return statdate;
//	}
//
//	public void setStatdate(String statdate) {
//		this.statdate = statdate;
//	}

}
