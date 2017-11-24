package com.gmcc.pboss.biz.info.salesRpt.support.processor;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.salesRpt.support.OrderTimesQueryParameter;
import com.gmcc.pboss.common.exception.AssertConditionException;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;

public class OrderTimesParameterProcessor extends
		DefaultQueryParameterProcessor implements QueryParameterProcessor{
	public void process(Criteria criteria, QueryParameter parameter) {
		OrderTimesQueryParameter param = (OrderTimesQueryParameter) parameter;
		
		Assert.notBlank(param.getWayid(), ServiceConditionCode.SALES_WAY, "渠道编码不能为空！");
		
		criteria.add(Restrictions.eq("objectcode", param.getWayid()));
		criteria.add(Restrictions.eq("objtype", param.getWaytype()));
	}//process

}
