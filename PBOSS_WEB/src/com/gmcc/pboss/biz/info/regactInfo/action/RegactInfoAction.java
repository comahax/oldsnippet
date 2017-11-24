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
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
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
		// 设置页码
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
	 * 月度套卡激活登记明细
	 */
	public String doQuery() {

		LoginMember member = getMember();
		ServiceResult result = this.getService().transact(member, this.getParameter(), ServiceType.QUERY);

		// 回写JSON
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}

	public String doList() {
		this.setTitle(PageLoction.RegactInfoQuery);
		return super.doList();
	}
	
	public List getsetCols() {

		List setCols = new ArrayList();
		setCols.add(new ColumnSet("comresid", "套卡号码"));
		setCols.add(new ColumnSet("createtime", "登记时间"));
		setCols.add(new ColumnSet("acttime","激活时间"));
		return setCols;
	}

	/*
	 * 月度套卡激活登记明细
	 */
	public String getShowStCols() {
		// TODO Auto-generated method stub
		return JSONArray.fromObject(getStCols()).toString();
	}
	public List getStCols() {
		List setCols = new ArrayList();
//		setCols.add(new ColumnSet("opnid", "业务代码"));
		setCols.add(new ColumnSet("desc","","品牌", "10%",true,false));
		setCols.add(new ColumnSet("actualActived", "实际激活量"));
		setCols.add(new ColumnSet("validActived", "有效激活量(短信登记与激活为同一月份)"));
		setCols.add(new ColumnSet("rewardActived", "符合计酬激活量"));
		return setCols;
	}

	public String doStatisticsQuery() {
		
		LoginMember member = getMember();
		ServiceResult result = stService.transact(member, this.getParamSt(), ServiceType.QUERY);
		
		// 回写JSON
		this.writeJSONServicePage(result, getStCols());
		return null;
	}
	
	public String doStatistics() {
		this.setTitle(PageLoction.RegactStatisticsQuery);
		return super.doList();
	}

	
}
