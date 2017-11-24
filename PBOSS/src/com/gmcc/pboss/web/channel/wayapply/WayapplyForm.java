/**
 * auto-generated code
 * Wed Oct 28 16:03:21 CST 2009
 */
package com.gmcc.pboss.web.channel.wayapply;

import com.gmcc.pboss.business.channel.wayapply.WayapplyVO;

/**
 * <p>Title: WayapplyForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WayapplyForm extends WayapplyVO {

	private String worktype;//处理工单的单类型
	private String cmdvalue;//
	public String getWorktype() {
		return worktype;
	}

	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}

	public String getCmdvalue() {
		return cmdvalue;
	}

	public void setCmdvalue(String cmdvalue) {
		this.cmdvalue = cmdvalue;
	}
	
}
