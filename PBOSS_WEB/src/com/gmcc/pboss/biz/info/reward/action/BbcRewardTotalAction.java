package com.gmcc.pboss.biz.info.reward.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.biz.info.reward.support.BbcRewardQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;

public class BbcRewardTotalAction extends RewardRecordAction {

	private BbcRewardQueryParameter parameter;

	public QueryParameter getParameter() {

		parameter = parameter == null ? new BbcRewardQueryParameter() : parameter;
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
	 * Ajax方法
	 */
	public String doQuery() {

		LoginMember member = getMember();
		// 启动查询
		ServiceResult result = getService().transact(member, getParameter(), ServiceType.QUERY);
		// 回写JSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
	}
	/**
	 * 生成页面
	 */
	public String doList() {

//		LoginMember member = getMember();
//
//		ServiceResult result = getService().transact(member, getParameter(), ServiceType.QUERY);
//
//		setMessage(result.getMessage());
//
//		setResult(result.getRetResult());
		setTitle(PageLoction.BbcRewardTotalList);
		return SUCCESS;
	}

	public List getsetCols() {
		//渠道标识,渠道星级,酬金类型,结算月份,酬金总额
		List setCols = new ArrayList();
		setCols.add(new ColumnSet("way.shortname","渠道标识"));
		setCols.add(new ColumnSet("way.waylevel","渠道星级"));
		setCols.add(new ColumnSet("rewardtypeName","酬金类型"));
		setCols.add(new ColumnSet("rewardmonth","结算月份"));
		setCols.add(new ColumnSet("paymoney","酬金总额"));
		return setCols;
	}
	
	public Map getRewareType(){
		Map rtn = new LinkedHashMap();
		rtn.put("", "请选择");
		Map consMap = Constant.getConstantsMap(ConstantsType.BBC_REWARD_TPYPE);
		if (consMap!=null) rtn.putAll(consMap);
		return rtn;
		
	}
	/**
	 * @param parameter the parameter to set
	 */
	public void setParameter(BbcRewardQueryParameter parameter) {
		this.parameter = parameter;
	}
}
