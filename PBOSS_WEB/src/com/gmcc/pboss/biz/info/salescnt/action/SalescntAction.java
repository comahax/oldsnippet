package com.gmcc.pboss.biz.info.salescnt.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.biz.info.salescnt.service.MemberService;
import com.gmcc.pboss.biz.info.salescnt.service.SalescntService;
import com.gmcc.pboss.biz.info.salescnt.support.SalescntQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;

public class SalescntAction extends AbstractAction {

	private SalescntQueryParameter parameter;
	private SalescntService service;
	private Map mbItem; // ��Ա����
	private MemberService stService;
	
	public QueryParameter getParameter() {
		parameter = parameter == null ? new SalescntQueryParameter() : parameter;
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		LoginMember member = getMember();

		parameter.setWayid(member.getWayid());
		return parameter;
	}
	
	public void prepare() throws Exception {
	}
	
	/**
	 * @return the service
	 */
	public SalescntService getService() {
		return service;
	}

	/**
	 * the service to set
	 * @param service
	 */
	public void setService(SalescntService service) {
		this.service = service;
	}
	
	/**
	 * @return the MemberService
	 */
	public MemberService getStService() {
		return stService;
	}

	/**
	 * @param MemberService the MemberService to set
	 */
	public void setStService(MemberService stService) {
		this.stService = stService;
	}
	
	public String doList() {
		this.setTitle(PageLoction.SalescntQuery);
		parameter = new SalescntQueryParameter();
		LoginMember member = getMember();
		parameter.setOpEmployeeid(member.getEmployeeid());
		parameter.setWayid2(member.getWayid());
		ServiceResult result = stService.transact(this.getMember(), parameter, ServiceType.QUERY);
		
		ArrayList list = (ArrayList)result.getRetResult().getData();
		Map c = (Map)list.get(0);
		this.setMbItem(c);
		// ��ʼ���Ǽ�ʱ��
		Date d = new Date();
		parameter.setEndoprtime(d);
		parameter.setStartoprtime(d);
		return super.doList();
	}
	
	/*
	 * ���ۻ��ܲ�ѯ
	 */
	public String doQuery() {

		LoginMember member = getMember();
		this.getParameter();
		if (member.getIsnet()==0) parameter.setOpEmployeeid(member.getEmployeeid());
		ServiceResult result = this.getService().transact(member, parameter, ServiceType.QUERY);

		// ��дJSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
	}
	
	public List getsetCols() {

		List setCols = new ArrayList();
		setCols.add(new ColumnSet("opntype", "ҵ������"));
		setCols.add(new ColumnSet("cnt", "��������"));
		return setCols;
	}

	public Map getMbItem() {
		return mbItem;
	}

	public void setMbItem(Map mbItem) {
		this.mbItem = mbItem;
	}
}
