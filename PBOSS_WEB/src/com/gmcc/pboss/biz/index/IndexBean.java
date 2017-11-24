package com.gmcc.pboss.biz.index;

import java.util.List;

import com.gmcc.pboss.model.communi.ChPwAdvinfo;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-11-6
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：首页Bean
 */
public class IndexBean {
	/**待办任务*/
	List<ChPwAdvinfo> pendingRequest;
	/**公告信息*/
	List<ChPwAdvinfo> affiche;
	/**业务信息*/
	List<ChPwAdvinfo> operationinfo;
	/**知识库*/
	List<ChPwAdvinfo> knowledge;
	/**调查问卷*/
	List<ChPwAdvinfo> questionnaire;
	/**我的提问*/
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
