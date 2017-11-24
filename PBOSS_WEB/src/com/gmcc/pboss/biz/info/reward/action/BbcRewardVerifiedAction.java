package com.gmcc.pboss.biz.info.reward.action;

import java.util.LinkedHashMap;
import java.util.Map;

import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PageLoction;

public class BbcRewardVerifiedAction extends RewardVerifiedAction {

	/**
	 * Ajax方法
	 */
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
		setTitle(PageLoction.BbcRewardVerifiedList);
		return SUCCESS;
	}

	public Map getRewareType(){
		Map rtn = new LinkedHashMap();
		rtn.put("", "请选择");
		Map consMap = Constant.getConstantsMap(ConstantsType.BBC_REWARDVERIFIED_TPYPE);
		if (consMap!=null) rtn.putAll(consMap);
		return rtn;
		
	}
	
	/**
	 * 返回导出Excel文件的名称
	 */
	protected String getExcelTitle(){
		String type = ((RewardFailQueryParameter)getParameter()).getType();
		return Constant.getConstantName(ConstantsType.BBC_REWARDVERIFIED_TPYPE,type);
	}
}
