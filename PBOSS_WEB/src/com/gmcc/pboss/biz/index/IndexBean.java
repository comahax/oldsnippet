package com.gmcc.pboss.biz.index;

import java.util.List;

import com.gmcc.pboss.model.communi.ChPwAdvinfo;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-11-6
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ��������ҳBean
 */
public class IndexBean {
	/**��������*/
	List<ChPwAdvinfo> pendingRequest;
	/**������Ϣ*/
	List<ChPwAdvinfo> affiche;
	/**ҵ����Ϣ*/
	List<ChPwAdvinfo> operationinfo;
	/**֪ʶ��*/
	List<ChPwAdvinfo> knowledge;
	/**�����ʾ�*/
	List<ChPwAdvinfo> questionnaire;
	/**�ҵ�����*/
	List<ChPwAdvinfo> interlocution;
	
	/*****************************Getter and Stter*********************************/
	public List<ChPwAdvinfo> getPendingRequest() {
		return pendingRequest;
	}
	public void setPendingRequest(List<ChPwAdvinfo> pendingRequest) {
		this.pendingRequest = pendingRequest;
	}
	public List<ChPwAdvinfo> getAffiche() {
		return affiche;
	}
	public void setAffiche(List<ChPwAdvinfo> affiche) {
		this.affiche = affiche;
	}
	public List<ChPwAdvinfo> getOperationinfo() {
		return operationinfo;
	}
	public void setOperationinfo(List<ChPwAdvinfo> operationinfo) {
		this.operationinfo = operationinfo;
	}
	public List<ChPwAdvinfo> getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(List<ChPwAdvinfo> knowledge) {
		this.knowledge = knowledge;
	}
	public List<ChPwAdvinfo> getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(List<ChPwAdvinfo> questionnaire) {
		this.questionnaire = questionnaire;
	}
	public List<ChPwAdvinfo> getInterlocution() {
		return interlocution;
	}
	public void setInterlocution(List<ChPwAdvinfo> interlocution) {
		this.interlocution = interlocution;
	}
	
	
}
