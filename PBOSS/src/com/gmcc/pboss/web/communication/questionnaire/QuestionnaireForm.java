/**
 * auto-generated code
 * Tue Sep 29 10:11:13 CST 2009
 */
package com.gmcc.pboss.web.communication.questionnaire;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.gmcc.pboss.business.communication.advaffix.AdvaffixVO;
import com.gmcc.pboss.business.communication.questionnaire.QuestionnaireVO;

/**
 * <p>Title: AdvinfoForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class QuestionnaireForm extends QuestionnaireVO {
	String objinfo;
	String delAffixs;
	List<AdvaffixVO> advaffixList = new LinkedList<AdvaffixVO>();
	
	Date currentdate;
	
	public List<AdvaffixVO> getAdvaffixList() {
		return advaffixList;
	}
	public void setAdvaffixList(List<AdvaffixVO> advaffixList) {
		this.advaffixList = advaffixList;
	}
	public String getObjinfo() {
		return objinfo;
	}
	public void setObjinfo(String objinfo) {
		this.objinfo = objinfo;
	}
	public String getDelAffixs() {
		return delAffixs;
	}
	public void setDelAffixs(String delAffixs) {
		this.delAffixs = delAffixs;
	}
	public Date getCurrentdate() {
		return currentdate;
	}
	public void setCurrentdate(Date currentdate) {
		this.currentdate = currentdate;
	}
}
