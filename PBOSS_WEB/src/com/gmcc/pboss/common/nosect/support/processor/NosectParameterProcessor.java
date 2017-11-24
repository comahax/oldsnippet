package com.gmcc.pboss.common.nosect.support.processor;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;

/**
 * 从兴公司营账研发部
 * @author yuwenjun
 * @date 2010-3-1
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：手机号码归属地查询
 */
public class NosectParameterProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {

	public void process(Criteria criteria, QueryParameter parameter) {
//		NosectQueryParameter param = (NosectQueryParameter) parameter;
//		
//		Assert.notBlank(param.getMobileNo(), ServiceConditionCode.REWARD_MOBILE, "手机号码不能为空！");
		return;
	}//process
	
	//通过手机号码查询归属地逻辑
	public void processCityQuery(Criteria criteria, String mobileNo){
		Assert.notBlank(mobileNo, ServiceConditionCode.REWARD_MOBILE, "手机号码不能为空！");
//		criteria.
		criteria.add(Restrictions.ge("endno", mobileNo));
		criteria.add(Restrictions.le("beginno", mobileNo));
	}
}
