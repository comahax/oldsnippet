package com.gmcc.pboss.biz.communi.action;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.communi.service.CommunicatePlateauOperation;
import com.gmcc.pboss.biz.communi.service.CommunicateReplyService;
import com.gmcc.pboss.biz.communi.support.CommunicateReplyParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;

public class CommunicateReplyAction extends AbstractAction {

	private CommunicateReplyParameter parameter;
	
	private CommunicateReplyService service;
	
	public String doReplyQuery(){
		LoginMember member = this.getMember();
		parameter.setOid(member.getEmployeeid());
		parameter.setOperation(CommunicatePlateauOperation.REPLAY_QUERY);
		
		ServiceResult result = service.transact(member, getParameter(), ServiceType.QUERY);
		
		//返回JSON对象
		this.writeJSONServicePage(result, getAffcheCols());
		return null;
	}
	
	private List getAffcheCols(){
		List<ColumnSet> list = new ArrayList<ColumnSet>();
		list.add(new ColumnSet("replytime","回复时间","25%"));
		list.add(new ColumnSet("oid","回复人","25%"));
		list.add(new ColumnSet("replycontent","回复内容","50%"));
		return list;
	}
	/**
	 * 调查问卷反馈
	 * @return
	 */
	public String doQuestionnaireReplyQuery(){
		LoginMember member = this.getMember();
		parameter.setOid(member.getEmployeeid());
		parameter.setOperation(CommunicatePlateauOperation.REPLAY_QUERY);
		
		ServiceResult result = service.transact(member, getParameter(), ServiceType.QUERY);
		
		//返回JSON对象
		this.writeJSONServicePage(result, geQuestionnaireCols());
		return null;
	}
	
	private List geQuestionnaireCols(){
		List<ColumnSet> list = new ArrayList<ColumnSet>();
		list.add(new ColumnSet("replytime","回复时间","25%"));
		list.add(new ColumnSet("oid","回复人","15%"));
		list.add(new ColumnSet("affix","附件","60%"));
		return list;
	}
	
	
	@Override
	public List getsetCols() {
		return getAffcheCols();
	}
	
	@Override
	public QueryParameter getParameter() {
		parameter = (parameter == null)? new CommunicateReplyParameter():parameter;
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		return parameter;
	}

	public void prepare() throws Exception {

	}

	public void setParameter(CommunicateReplyParameter parameter) {
		this.parameter = parameter;
	}

	public CommunicateReplyService getService() {
		return service;
	}

	public void setService(CommunicateReplyService service) {
		this.service = service;
	}
	
}
