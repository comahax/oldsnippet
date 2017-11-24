package com.gmcc.pboss.biz.info.adpay.support.processor;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.adpay.support.AdpaysumQueryParameter;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;

public class AdpaysumParameterProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {

	public void process(Criteria criteria, QueryParameter parameter) {
		AdpaysumQueryParameter param = (AdpaysumQueryParameter) parameter;
		Assert.notBlank(param.getDiscomcode(), ServiceConditionCode.SALES_WAY, "配送商编码不能为空！");
		
		criteria.add(Restrictions.eq("discomcode", param.getDiscomcode()));
		
		if(param.getSumid()!=null){
			criteria.add(Restrictions.eq("sumid", param.getSumid()));
		}
		
		if(param.getCreateTimeFrom()!=null){
			criteria.add(Restrictions.ge("createTime", param.getCreateTimeFrom()));
		}
		if(param.getCreateTimeTo()!=null){
			criteria.add(Restrictions.le("createTime", DateUtils.addMilliseconds(DateUtils.addDays(param.getCreateTimeTo(), 1), -1)));
		}
		if(param.getState()!=null && !"".equals(param.getState())){
			criteria.add(Restrictions.eq("state", param.getState()));
		}
		criteria.addOrder(Order.desc("createTime"));
		criteria.addOrder(Order.asc("sumid"));
	}


}
