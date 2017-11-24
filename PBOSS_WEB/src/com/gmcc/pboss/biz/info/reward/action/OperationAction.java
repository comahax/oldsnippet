package com.gmcc.pboss.biz.info.reward.action;

import java.io.UnsupportedEncodingException;

import com.gmcc.pboss.biz.info.reward.service.OperationService;
import com.gmcc.pboss.biz.info.reward.support.OperationQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.QueryParameter;

public class OperationAction extends AbstractAction {

	private OperationQueryParameter parameter;

	private OperationService service;

	private String q;

	public QueryParameter getParameter() {
		parameter = new OperationQueryParameter();
		parameter.setQuery(getQ());

		return parameter;
	}

	public void setParameter(OperationQueryParameter parameter) {
		this.parameter = parameter;
	}

	public OperationService getService() {
		return service;
	}

	public void setService(OperationService service) {
		this.service = service;
	}

	public String getQ() {
		try {
			return new String(q.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public void setQ(String q) {
		this.q = q;
	}

	public void prepare() throws Exception {

	}

	public String doQuery() {

		LoginMember member = this.getMember();

		ServiceResult result = service.transact(member, getParameter(), ServiceType.QUERY);

		writeJSONServiceData(result);

		return null;
	}
}
