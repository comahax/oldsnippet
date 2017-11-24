/**
 * auto-generated code
 * Tue Jun 22 17:25:03 CST 2010
 */
package com.gmcc.pboss.web.sales.stockalarm;

import java.util.List;

import com.gmcc.pboss.business.sales.stockalarm.StockalarmVO;

/**
 * <p>Title: StockalarmForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class StockalarmForm extends StockalarmVO {

	private String redalarm;
	private String yellowalarm;
	private String sysparamflag;
	private String brandstr [];
	private List brandlist;
	private String sbrand;
	
	
	public String getSbrand() {
		return sbrand;
	}
	public void setSbrand(String sbrand) {
		this.sbrand = sbrand;
	}
	public String getSysparamflag() {
		return sysparamflag;
	}
	public void setSysparamflag(String sysparamflag) {
		this.sysparamflag = sysparamflag;
	}
	public String[] getBrandstr() {
		return brandstr;
	}
	public void setBrandstr(String[] brandstr) {
		this.brandstr = brandstr;
	}
	public List getBrandlist() {
		return brandlist;
	}
	public void setBrandlist(List brandlist) {
		this.brandlist = brandlist;
	}
	public String getRedalarm() {
		return redalarm;
	}
	public void setRedalarm(String redalarm) {
		this.redalarm = redalarm;
	}
	public String getYellowalarm() {
		return yellowalarm;
	}
	public void setYellowalarm(String yellowalarm) {
		this.yellowalarm = yellowalarm;
	}
	
}
