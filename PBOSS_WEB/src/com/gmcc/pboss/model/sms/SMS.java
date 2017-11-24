package com.gmcc.pboss.model.sms;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-12-2
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：短信抽象类
 */
public abstract class SMS {
	/**源号码*/
	private String srcterminal;
	/**目标号码*/
	private String destterminal;
	/**短信内容*/
	private String content;
	
	/**源号码*/
	public String getSrcterminal() {
		return this.srcterminal;
	}
	/**源号码*/
	public void setSrcterminal(String srcterminal) {
		this.srcterminal = srcterminal;
	}
	/**目标号码*/
	public String getDestterminal() {
		return this.destterminal;
	}
	/**目标号码*/
	public void setDestterminal(String destterminal) {
		this.destterminal = destterminal;
	}
	/**短信内容*/
	public String getContent() {
		return this.content;
	}
	/**短信内容*/
	public void setContent(String content) {
		this.content = content;
	}
}
