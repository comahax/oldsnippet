package com.gmcc.pboss.common.config.bean;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-11-17
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：待办任务配置bean
 */
public class PendingTaskConfigBean {
	/**待办任务名称*/
	private String name;
	/**待办任务标题*/
	private String titel;
	/**待办任务URL*/
	private String url;
	/**待办任务计划完成时间（默认为7天）*/
	private int plantime = 7;
	/**待办任务接受对象（默认为4 特定人员）*/
	private int desttype = 4;
	/**待办任务是否短信通知（默认为1 需要）*/
	private int smsnotify= 1;
	/**待办任务是否需要审批（默认为0 否）*/
	private int ndapproval = 0;
	/**待办任务状态（默认为3已发布）*/
	private int state = 3;
	
	/**待办任务名称*/
	public String getName() {
		return name;
	}
	/**待办任务名称*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**待办任务标题*/
	public String getTitel() {
		return titel;
	}
	/**待办任务标题*/
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	/**待办任务URL*/
	public String getUrl() {
		return url;
	}
	/**待办任务URL*/
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**待办任务计划完成时间（默认为7天）*/
	public int getPlantime() {
		return plantime;
	}
	/**待办任务计划完成时间（默认为7天）*/
	public void setPlantime(int plantime) {
		this.plantime = plantime;
	}
	
	/**待办任务接受对象（默认为4 特定人员）*/
	public int getDesttype() {
		return desttype;
	}
	/**待办任务接受对象（默认为4 特定人员）*/
	public void setDesttype(int desttype) {
		this.desttype = desttype;
	}
	
	/**待办任务是否短信通知（默认为1 需要）*/
	public int getSmsnotify() {
		return smsnotify;
	}
	/**待办任务是否短信通知（默认为1 需要）*/
	public void setSmsnotify(int smsnotify) {
		this.smsnotify = smsnotify;
	}
	
	/**待办任务是否需要审批（默认为0 否）*/
	public int getNdapproval() {
		return ndapproval;
	}
	/**待办任务是否需要审批（默认为0 否）*/
	public void setNdapproval(int ndapproval) {
		this.ndapproval = ndapproval;
	}
	
	/**待办任务状态（默认为1 未发布）*/
	public int getState() {
		return state;
	}
	/**待办任务状态（默认为1 未发布）*/
	public void setState(int state) {
		this.state = state;
	}
	
	
}
