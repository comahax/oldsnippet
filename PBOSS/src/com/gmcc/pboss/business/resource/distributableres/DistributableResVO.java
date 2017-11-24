package com.gmcc.pboss.business.resource.distributableres;

import com.sunrise.jop.infrastructure.db.BaseVO;

/**
 * 网点资源信息统计 实时
 * 
 * @author liang.qichao
 * 
 */
public class DistributableResVO extends BaseVO {


	private String brand;

	private String countyid;


	private Long cnt1; // 可售资源数量

	private Long cnt2; // 可分配资源数量

	private Long cnt3; // 待审核资源数量
	
	private Long cnt4; // 已审核未抽取
	
	private String comcategory;
	
	
	public DistributableResVO() {}

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

	public Long getCnt4() {
		return cnt4;
	}

	public void setCnt4(Long cnt4) {
		this.cnt4 = cnt4;
	}

	public String getComcategory() {
		return comcategory;
	}

	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}
	
}
