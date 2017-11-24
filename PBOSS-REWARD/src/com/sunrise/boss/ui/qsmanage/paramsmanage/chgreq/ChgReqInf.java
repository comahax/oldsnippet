package com.sunrise.boss.ui.qsmanage.paramsmanage.chgreq;
/**
 * 批量审批界面请求明细弹出框辅助类
 * @author wangguangying 20090416
 *
 */
public class ChgReqInf {
	
	private String tabcode;
	
	private String oprtype;
	
	private int count = 0;
	
	private Long matchid;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Long getMatchid() {
		return matchid;
	}

	public void setMatchid(Long matchid) {
		this.matchid = matchid;
	}

	public String getTabcode() {
		return tabcode;
	}

	public void setTabcode(String tabcode) {
		this.tabcode = tabcode;
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}
	
}
