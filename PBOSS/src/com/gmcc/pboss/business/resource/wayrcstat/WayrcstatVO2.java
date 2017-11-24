package com.gmcc.pboss.business.resource.wayrcstat;

import java.io.Serializable;
import java.util.Date;

import com.sunrise.jop.infrastructure.db.BaseVO;

/**
 * 网点资源信息统计 历史
 * @author liang.qichao
 *
 */
public class WayrcstatVO2 extends BaseVO implements Serializable {

	private String wayid;

	private String brand;

	private String countyid;

	private String mareacode;

	private String wayname;

	private Long cnt1; // 库存量

	private Long cnt2; // 领货量

	private Long cnt3; // 激活量
	
	private Date statdate;

	
    /** nullable persistent field */
    private Long maxstock;

    /** nullable persistent field */
    private Long redvalue;

    /** nullable persistent field */
    private Long yelvalue;

    /** nullable persistent field */
    private String alarmlevel;
	
    private String waymagcode;
    
    private Long starlevel;
    
	

	public String getWaymagcode() {
		return waymagcode;
	}

	public void setWaymagcode(String waymagcode) {
		this.waymagcode = waymagcode;
	}

	public Long getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(Long starlevel) {
		this.starlevel = starlevel;
	}

	public Long getMaxstock() {
		return maxstock;
	}

	public void setMaxstock(Long maxstock) {
		this.maxstock = maxstock;
	}

	public Long getRedvalue() {
		return redvalue;
	}

	public void setRedvalue(Long redvalue) {
		this.redvalue = redvalue;
	}

	public Long getYelvalue() {
		return yelvalue;
	}

	public void setYelvalue(Long yelvalue) {
		this.yelvalue = yelvalue;
	}

	public String getAlarmlevel() {
		return alarmlevel;
	}

	public void setAlarmlevel(String alarmlevel) {
		this.alarmlevel = alarmlevel;
	}



	public Date getStatdate() {
		return statdate;
	}

	public void setStatdate(Date statdate) {
		this.statdate = statdate;
	}

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
}
