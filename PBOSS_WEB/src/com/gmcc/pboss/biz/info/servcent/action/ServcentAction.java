package com.gmcc.pboss.biz.info.servcent.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.biz.info.servcent.service.ServcentService;
import com.gmcc.pboss.biz.info.servcent.support.ServcentQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.servcent.Servcent;

public class ServcentAction extends AbstractAction {

	private ServcentQueryParameter parameter;
	private ServcentService service;
	private String _se_countyid;
	
	public QueryParameter getParameter() {
		parameter = parameter == null ? new ServcentQueryParameter() : parameter;
		
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		
		return parameter;
	}
	
	
	public void prepare() throws Exception {
	}

	/*
	 * ���۷�������
	 */
	public String doQuery() {

		LoginMember member = getMember();
		ServiceResult result = this.getService().transact(member, this.getParameter(), ServiceType.QUERY);

		// ��дJSON
		if (result.isSuccess()) {
			if (result.getRetResult().getData().size() == 0) {
				Servcent sev = new Servcent("","��ֵ");
				ArrayList<Servcent> list = new ArrayList<Servcent>();
				list.add(sev);
				result.getRetResult().setData(list);
			}
		}
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	public String doList() {
		this.setTitle(PageLoction.RegactInfoQuery);
		getParameter();
		if (StringUtils.isNotEmpty(get_se_countyid())) {
			parameter.setCountyid(get_se_countyid());
		}
		return super.doList();
	}
	
	public List getsetCols() {

		List setCols = new ArrayList();
		setCols.add(new ColumnSet("svccode", "���۷������ı���"));
		setCols.add(new ColumnSet("svcname", "���۷�����������"));
		return setCols;
	}
	

	public ServcentService getService() {
		return service;
	}


	public void setService(ServcentService service) {
		this.service = service;
	}


	public String get_se_countyid() {
		return _se_countyid;
	}


	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}
}
