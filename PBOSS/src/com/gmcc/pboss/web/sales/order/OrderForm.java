/**
 * auto-generated code
 * Mon Oct 12 14:56:43 CST 2009
 */
package com.gmcc.pboss.web.sales.order;

import java.util.List;

import com.gmcc.pboss.business.sales.order.AuxiliaryInfoVO;
import com.gmcc.pboss.business.sales.order.OrderVO;

/**
 * <p>Title: OrderForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderForm extends OrderVO {
	private String hasAudit;//�������
	private String hasWaitAudit;//���ڴ������Ϣ
	private String flowOutstate;//�������̲������״̬
	private String custwaytypename;//������������
	private String cancelReason;//����ԭ��
	private String cancelDes;//��������
	private String ordcomid;//������Ʒ���
	private String step;//����ҳ����ת
	private String delaySeconds;//boss�ӿ������ӳٿ���
	private List<AuxiliaryInfoVO> auxInfoList=null;//��˸�����Ϣ
	private String[] stattypes=null;//��˸���������ͳ�Ʒ�ʽ��¼����
	private boolean isShowAus=false;//�Ƿ�չʾ��˸�����Ϣ
	private String monthParam;//����������ϵͳ����
	private Long giveCount;//����������
	private boolean isAppPass=false;//������������Ϣ�����Ƿ����ͨ��
	private String param44;//����鿪��
	private boolean firstDisplay=true;//�״ν��벻��ѯ����
	private java.util.Date auditTime;//���ʱ��
	
	private Double allactamt;
	private String allbrand;
	
	public boolean isFirstDisplay() {
		return firstDisplay;
	}

	public void setFirstDisplay(boolean firstDisplay) {
		this.firstDisplay = firstDisplay;
	}

	public String getParam44() {
		return param44;
	}

	public void setParam44(String param44) {
		this.param44 = param44;
	}

	public boolean isAppPass() {
		return isAppPass;
	}

	public void setAppPass(boolean isAppPass) {
		this.isAppPass = isAppPass;
	}

	public List<AuxiliaryInfoVO> getAuxInfoList() {
		return auxInfoList;
	}

	public void setAuxInfoList(List<AuxiliaryInfoVO> auxInfoList) {
		this.auxInfoList = auxInfoList;
	}

	public String getHasAudit() {
		return hasAudit;
	}

	public void setHasAudit(String hasAudit) {
		this.hasAudit = hasAudit;
	}

	public String getHasWaitAudit() {
		return hasWaitAudit;
	}

	public void setHasWaitAudit(String hasWaitAudit) {
		this.hasWaitAudit = hasWaitAudit;
	}

	public String getFlowOutstate() {
		return flowOutstate;
	}

	public void setFlowOutstate(String flowOutstate) {
		this.flowOutstate = flowOutstate;
	}

	public String getCustwaytypename() {
		return custwaytypename;
	}

	public void setCustwaytypename(String custwaytypename) {
		this.custwaytypename = custwaytypename;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancelDes() {
		return cancelDes;
	}

	public void setCancelDes(String cancelDes) {
		this.cancelDes = cancelDes;
	}

	public String getOrdcomid() {
		return ordcomid;
	}

	public void setOrdcomid(String ordcomid) {
		this.ordcomid = ordcomid;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getDelaySeconds() {
		return delaySeconds;
	}

	public void setDelaySeconds(String delaySeconds) {
		this.delaySeconds = delaySeconds;
	}

	public String[] getStattypes() {
		return stattypes;
	}

	public void setStattypes(String[] stattypes) {
		this.stattypes = stattypes;
	}

	

	public String getMonthParam() {
		return monthParam;
	}

	public void setMonthParam(String monthParam) {
		this.monthParam = monthParam;
	}

	public Long getGiveCount() {
		return giveCount;
	}

	public void setGiveCount(Long giveCount) {
		this.giveCount = giveCount;
	}

	public boolean isShowAus() {
		return isShowAus;
	}

	public void setShowAus(boolean isShowAus) {
		this.isShowAus = isShowAus;
	}

	public java.util.Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(java.util.Date auditTime) {
		this.auditTime = auditTime;
	}



	public Double getAllactamt() {
		return allactamt;
	}

	public void setAllactamt(Double allactamt) {
		this.allactamt = allactamt;
	}

	public String getAllbrand() {
		return allbrand;
	}

	public void setAllbrand(String allbrand) {
		this.allbrand = allbrand;
	}

	
	
}
