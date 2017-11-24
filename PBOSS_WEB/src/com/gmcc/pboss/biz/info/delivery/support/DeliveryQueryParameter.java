package com.gmcc.pboss.biz.info.delivery.support;

import java.util.Date;
import com.gmcc.pboss.biz.info.salesRpt.support.SalesOrderQueryParameter;
import com.gmcc.pboss.common.support.QueryAction;

public class DeliveryQueryParameter extends SalesOrderQueryParameter {

	public DeliveryQueryParameter() {
		setAction(QueryAction.SECTION);// �¶��׿�������ϸ��ѯ��ҳ
		this.modlogi = false;
	}
	/**
	 * ���͵���
	 */
	private String recid;
	/**
	 * disstate
	 */
	private String disstate;
	
	/**
	 * ����ʱ��>=
	 */
	private Date startDate;
	
	/**
	 * ����ʱ��<=
	 */
	private Date endDate;
	
	/**
	 * �ɷѷ�ʽ
	 */
	private String paytype;
	/**
	 * �����޸ĵ�ID
	 */
	private String recids;
	/**
	 * �ֹ�˾
	 */
	private String cntyComd;
	
	/**
	 * ��������
	 */
	private String logisticsno;
	private Boolean modlogi;
	
	public Boolean getModlogi() {
		return modlogi;
	}
	public void setModlogi(Boolean modlogi) {
		this.modlogi = modlogi;
	}
	/**
	 * @return the recid
	 */
	public String getRecid() {
		return recid;
	}
	/**
	 * @param recid the recid to set
	 */
	public void setRecid(String recid) {
		this.recid = recid;
	}
	/**
	 * @return the disstate
	 */
	public String getDisstate() {
		return disstate;
	}
	/**
	 * @param disstate the disstate to set
	 */
	public void setDisstate(String disstate) {
		this.disstate = disstate;
	}
	/**
	 * @return the recids
	 */
	public String getRecids() {
		return recids;
	}
	/**
	 * @param recids the recids to set
	 */
	public void setRecids(String recids) {
		this.recids = recids;
	}
	/**
	 * @return the paytype
	 */
	public String getPaytype() {
		return paytype;
	}
	/**
	 * @param paytype the paytype to set
	 */
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	/**
	 * @return the cntyComd
	 */
	public String getCntyComd() {
		return cntyComd;
	}
	/**
	 * @param cntyComd the cntyComd to set
	 */
	public void setCntyComd(String cntyComd) {
		this.cntyComd = cntyComd;
	}
	
	public String getLogisticsno() {
		return logisticsno;
	}

	public void setLogisticsno(String logisticsno) {
		this.logisticsno = logisticsno;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
