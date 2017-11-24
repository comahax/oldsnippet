package com.gmcc.pboss.biz.info.salesRpt.support.processor;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.salesRpt.service.SalesrServiceRetCode;
import com.gmcc.pboss.biz.info.salesRpt.support.OrderDtlQueryParameter;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.exception.AssertConditionException;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.common.util.DateUtil;
import com.gmcc.pboss.model.sales.FxSwOrder;
import com.gmcc.pboss.model.sales.FxSwOrdercomcate;
import com.gmcc.pboss.model.sales.FxSwOrderresdet;

public class OrderDtlQueryProcessor extends DefaultHqlQueryProcessor implements QueryParameterProcessor {
	/**
	 * 构造函数
	 */
	public OrderDtlQueryProcessor() {
		paramEnclose = false; //不使用参数封装
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub

		OrderDtlQueryParameter parm = (OrderDtlQueryParameter)parameter;
		
//		Assert.notBlank(parm.getWayid(), ServiceConditionCode.SALES_WAY, "渠道编码不能为空！");
		Assert.notBlank(parm.getOrderid(), SalesrServiceRetCode.ID_Empty, "ID不存在！");

//		if (StringUtils.isNotBlank(parm.getWayid())) query.setString("wayid", parm.getWayid());
		query.setString("orderid", parm.getOrderid());
		
	}

	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		String [] rtn = {"activedate"};
		return rtn;
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.support.DefaultHqlQueryProcessor#getHql()
	 */
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		OrderDtlQueryParameter parm = (OrderDtlQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();
		if (ConstantsType.SALES_SELECTYPE_RESDETS.equals(parm.getSelecType())){
			// 查询子表类型 - 订购资源明细
			hql.append("select orderresdet from FxSwOrderresdet orderresdet, FxSwOrder ord where ord.orderid = orderresdet.orderid and");
		}else if(ConstantsType.SALES_SELECTYPE_COMCATE.equals(parm.getSelecType())){
			//查询子表类型 - 订购商品种类
			hql.append("select ordercomcate from FxSwOrdercomcate ordercomcate, FxSwOrder ord where ord.orderid = ordercomcate.orderid and");
		}else{
			//类型出错
			Assert.isTrue(false, ServiceConditionCode.FAIL_DAO, "OrderDtlQueryParameter没有指定查询类型!");
		}
		
		hql.append(" ord.orderid = :orderid ");
		
//		if (StringUtils.isNotBlank(parm.getWayid())) hql.append("and ord.wayid = :wayid");
		return hql.toString();
	}

	public String getCntHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		return super.getCntHql(parameter);
	}
}
