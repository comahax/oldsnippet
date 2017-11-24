package com.gmcc.pboss.biz.communi.support;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-10-29
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ��������ͨƽ̨�������
 */
public class CommunicatePlateauParameter extends QueryParameter {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7029653605938011358L;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	/***
	 * �ظ�����
	 */
//	private String replyContent;
	/**
	 * ����
	 */
	private String content;
	/**
	 * ��ϢID
	 **/
	private Long advinfoid;
	
	/***
	 * ��Ա����
	 */
	private String employeeid;
	
	/**
	 * �Ƿ�Ϊ���� true��ʾ���� false��ʾ��Ա
	 */
	private boolean isNet;
	
	/**
	 * �Ƿ�Ϊ��ҳ true��ʾ��ҳ false��ʾ������/ҵ��/֪ʶ����Ϣ��ѯ������
	 */
	private boolean isIndexPage;
	
	/**
	 * <pre>
	 * ��Ϣ����
	   "1".����
	   "2".�����ʴ�
	   "3".�ʾ����
	   "4".֪ʶ��
	   "5".����
	   "6".ҵ����Ϣ
	   </pre>
	 */
	private String type;
	/**
	 * ����
	 */
	private String title;
	
	Date date = new Date();
	/**
	 * ��ʼʱ�� ���ڸ�ʽΪ yyyy-MM-dd
	 */
	private String startDate = sdf.format(date).substring(0,8)+"01";
	/**
	 * ����ʱ�� ���ڸ�ʽΪ yyyy-MM-dd
	 */
	private String accountDate = sdf.format(date);
	/**
	 * �ҵ�����״̬ 
	 */
	private String state ;
	/**
	 * ����id
	 */
	private String affixid;
	/**
	 * ��ַID 
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