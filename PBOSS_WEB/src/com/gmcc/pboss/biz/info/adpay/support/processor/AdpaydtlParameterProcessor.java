package com.gmcc.pboss.biz.info.adpay.support.processor;

import org.hibernate.Query;

import com.gmcc.pboss.biz.info.adpay.support.AdpaydtlQueryParameter;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesrServiceRetCode;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;

public class AdpaydtlParameterProcessor extends DefaultHqlQueryProcessor  implements QueryParameterProcessor {

	public AdpaydtlParameterProcessor(){
		paramEnclose = true; //使用参数封装
	}

	@Override
	public String getHql(QueryParameter parameter) {
		return " select b,w.wayname from FxSwAdpaydet a,FxSwOrder b,Way w where a.orderid = b.orderid " +
				"and a.sumid = :sumid and b.wayid = w.wayid";
	}

	@Override
	public String[] getParamEncloseName() {
		return new String[]{"wayname"};
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		AdpaydtlQueryParameter param = (AdpaydtlQueryParameter)parameter;
		Assert.notNull(param.getSumid(), SalesrServiceRetCode.ID_Empty, "ID不存在！");
		query.setParameter("sumid", param.getSumid());
	}
	
}
