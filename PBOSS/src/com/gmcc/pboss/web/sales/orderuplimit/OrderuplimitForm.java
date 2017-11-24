/**
 * auto-generated code
 * Tue Oct 13 14:30:52 CST 2009
 */
package com.gmcc.pboss.web.sales.orderuplimit;

import java.util.List;

import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitVO;

/**
 * <p>Title: OrderuplimitForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OrderuplimitForm extends OrderuplimitVO {
	private String redalarm;
	private String yellowalarm;
	private String sysparamflag;
	private String brandstr [];
	private List brandlist;
	
	public String[] getBrandstr() {
		return brandstr;
	}
	public void setBrandstr(String[] brandstr) {
		this.brandstr = brandstr;
	}
	public String getSysparamflag() {
		return sysparamflag;
	}
	public void setSysparamflag(String sysparamflag) {
		this.sysparamflag = sysparamflag;
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
	public List getBrandlist() {
		return brandlist;
	}
	public void setBrandlist(List brandlist) {
		this.brandlist = brandlist;
	}
}
