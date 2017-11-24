package com.gmcc.pboss.biz.info.regactInfo.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.regactInfo.service.RegactInfoService;
import com.gmcc.pboss.biz.info.regactInfo.service.RegactStatisticsService;
import com.gmcc.pboss.biz.info.regactInfo.support.RegactInfoQueryParameter;
import com.gmcc.pboss.biz.info.regactInfo.support.RegactStatisticsQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;

public class RegactInfoAction extends AbstractAction {

	private RegactInfoQueryParameter parameter;
	private RegactStatisticsQueryParameter paramSt;

	private RegactInfoService service;
	private RegactStatisticsService stService;

	public QueryParameter getParameter() {

		parameter = parameter == null ? new RegactInfoQueryParameter() : parameter;
		// parameter.setStartMonth("200905");
		// parameter.setEndMonth("200908");
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		LoginMember member = getMember();

		parameter.setWayid(member.getWayid());

		return parameter;
	}

	/**
	 * @return the paramSt
	 */
	public RegactStatisticsQueryParameter getParamSt() {
		paramSt = paramSt == null ? new RegactStatisticsQueryParameter() : paramSt;
		// parameter.setStartMonth("200905");
		// parameter.setEndMonth("200908");
		// ����ҳ��
		LoginMember member = getMember();

		paramSt.setWayid(member.getWayid());

		return paramSt;
	}

	/**
	 * @param paramSt the paramSt to set
	 */
	public void setParamSt(RegactStatisticsQueryParameter paramSt) {
		this.paramSt = paramSt;
	}

	/**
	 * @param parameter the parameter to set
	 */
	public void setParameter(RegactInfoQueryParameter parameter) {
		this.parameter = parameter;
	}
	/**
	 * @return the service
	 */
	public RegactInfoService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(RegactInfoService service) {
		this.service = service;
	}

	/**
	 * @return the stService
	 */
	public RegactStatisticsService getStService() {
		return stService;
	}

	/**
	 * @param stService the stService to set
	 */
	public void setStService(RegactStatisticsService stService) {
		this.stService = stService;
	}

	public void prepare() throws Exception {

	}
	/*
	 * �¶��׿�����Ǽ���ϸ
	 */
	public String doQuery() {

		LoginMember member = getMember();
		ServiceResult result = this.getService().transact(member, this.getParameter(), ServiceType.QUERY);

		// ��дJSON
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}

	public String doList() {
		this.setTitle(PageLoction.RegactInfoQuery);
		return super.doList();
	}
	
	public List getsetCols() {

		List setCols = new ArrayList();
		setCols.add(new ColumnSet("comresid", "�׿�����"));
		setCols.add(new ColumnSet("createtime", "�Ǽ�ʱ��"));
		setCols.add(new ColumnSet("acttime","����ʱ��"));
		return setCols;
	}

	/*
	 * �¶��׿�����Ǽ���ϸ
	 */
	public String getShowStCols() {
		// TODO Auto-generated method stub
		return JSONArray.fromObject(getStCols()).toString();
	}
	public List getStCols() {
		List setCols = new ArrayList();
//		setCols.add(new ColumnSet("opnid", "ҵ�����"));
		setCols.add(new ColumnSet("desc","","Ʒ��", "10%",true,false));
		setCols.add(new ColumnSet("actualActived", "ʵ�ʼ�����"));
		setCols.add(new ColumnSet("validActived", "��Ч������(���ŵǼ��뼤��Ϊͬһ�·�)"));
		setCols.add(new ColumnSet("rewardActived", "���ϼƳ꼤����"));
		return setCols;
	}

	public String doStatisticsQuery() {
		
		LoginMember member = getMember();
		ServiceResult result = stService.transact(member, this.getParamSt(), ServiceType.QUERY);
		
		// ��дJSON
		this.writeJSONServicePage(result, getStCols());
		return null;
	}
	
	public String doStatistics() {
		this.setTitle(PageLoction.RegactStatisticsQuery);
		return super.doList();
	}

	
}
