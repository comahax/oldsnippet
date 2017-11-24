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
	 * Ajax����
	 */
	public String doQuery() {

		LoginMember member = getMember();
		// ������ѯ
		ServiceResult result = getService().transact(member, getParameter(), ServiceType.QUERY);
		// ��дJSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
	}
	/**
	 * ����ҳ��
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
		//������ʶ,�����Ǽ�,�������,�����·�,����ܶ�
		List setCols = new ArrayList();
		setCols.add(new ColumnSet("way.shortname","������ʶ"));
		setCols.add(new ColumnSet("way.waylevel","�����Ǽ�"));
		setCols.add(new ColumnSet("rewardtypeName","�������"));
		setCols.add(new ColumnSet("rewardmonth","�����·�"));
		setCols.add(new ColumnSet("paymoney","����ܶ�"));
		return setCols;
	}
	
	public Map getRewareType(){
		Map rtn = new LinkedHashMap();
		rtn.put("", "��ѡ��");
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
