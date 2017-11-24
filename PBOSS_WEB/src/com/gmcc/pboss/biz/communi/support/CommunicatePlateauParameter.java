package com.gmcc.pboss.biz.communi.support;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-29
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：沟通平台处理参数
 */
public class CommunicatePlateauParameter extends QueryParameter {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7029653605938011358L;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	/***
	 * 回复内容
	 */
//	private String replyContent;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 信息ID
	 **/
	private Long advinfoid;
	
	/***
	 * 人员编码
	 */
	private String employeeid;
	
	/**
	 * 是否为店主 true表示店主 false表示店员
	 */
	private boolean isNet;
	
	/**
	 * 是否为首页 true表示首页 false表示【公告/业务/知识库信息查询】界面
	 */
	private boolean isIndexPage;
	
	/**
	 * <pre>
	 * 信息类型
	   "1".公告
	   "2".在线问答
	   "3".问卷调查
	   "4".知识库
	   "5".待办
	   "6".业务信息
	   </pre>
	 */
	private String type;
	/**
	 * 标题
	 */
	private String title;
	
	Date date = new Date();
	/**
	 * 开始时间 日期格式为 yyyy-MM-dd
	 */
	private String startDate = sdf.format(date).substring(0,8)+"01";
	/**
	 * 结算时间 日期格式为 yyyy-MM-dd
	 */
	private String accountDate = sdf.format(date);
	/**
	 * 我的提问状态 
	 */
	private String state ;
	/**
	 * 附件id
	 */
	private String affixid;
	/**
	 * 地址ID 
	 */
	private String cityid;

//	public String getReplyContent() {
//		return replyContent;
//	}
//
//	public void setReplyContent(String replyContent) {
//		this.replyContent = replyContent;
//	}

	public Long getAdvinfoid() {
		return advinfoid;
	}

	public void setAdvinfoid(Long advinfoid) {
		this.advinfoid = advinfoid;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public boolean isNet() {
		return isNet;
	}

	public void setNet(boolean isNet) {
		this.isNet = isNet;
	}
	
	public boolean isIndexPage() {
		return isIndexPage;
	}

	public void setIndexPage(boolean isIndexPage) {
		this.isIndexPage = isIndexPage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getAccountDate() {
		return accountDate;
	}

	public void setAccountDate(String accountDate) {
		this.accountDate = accountDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAffixid() {
		return affixid;
	}

	public void setAffixid(String affixid) {
		this.affixid = affixid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
}