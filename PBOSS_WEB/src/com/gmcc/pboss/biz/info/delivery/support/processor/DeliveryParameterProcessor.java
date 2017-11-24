package com.gmcc.pboss.biz.info.delivery.support.processor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.delivery.support.DeliveryQueryParameter;
import com.gmcc.pboss.biz.info.salesRpt.support.SalesOrderQueryParameter;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.exception.AssertConditionException;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.common.util.DateUtil;

public class DeliveryParameterProcessor extends DefaultHqlQueryProcessor implements QueryParameterProcessor {

//	public void process(Criteria criteria, QueryParameter parameter) {
//		DeliveryQueryParameter param = (DeliveryQueryParameter) parameter;
//
//		Assert.notBlank(param.getWayid(), ServiceConditionCode.SALES_WAY, "配送商编码不能为空！");
//		
////		Assert.notBlank(param.getComType(), ServiceConditionCode.SALES_COMTYPE, "商品种类不能为空！");
//		
//		criteria.add(Restrictions.eq("discomcode", param.getWayid()));
//		
//		//查询时间
//		if (StringUtils.isNotBlank(param.getMonth())){
//			Date getSet;
//			Date nextMouth;
//			try{
//				getSet = DateUtil.convertStringToDate("yyyyMMdd",param.getMonth()+"01");
//				nextMouth = DateUtil.DateDiff("M", getSet, 1);
//			}catch (ParseException e){
//				throw new AssertConditionException(ServiceConditionCode.REGACT_OPRTIME_FORMAT,"月份格式不正确！");
//			}
//			criteria.add(Restrictions.ge("createtime", getSet));
//			criteria.add(Restrictions.lt("createtime", nextMouth));
//		}
//		
//		//订单状态
//		if (StringUtils.isNotBlank(param.getDisstate())){
//			criteria.add(Restrictions.eq("disstate", param.getDisstate()));			
//		}
//		//配送单号
//		if (StringUtils.isNumeric(param.getRecid()) && StringUtils.isNotEmpty(param.getRecid())){
//			criteria.add(Restrictions.eq("recid", new Long(param.getRecid())));			
//		}
//		//订单编号
//		if (StringUtils.isNotBlank(param.getOrderid())){
//			criteria.add(Restrictions.like("orderid", param.getOrderid()+"%"));			
//		}
//	}//process

	public DeliveryParameterProcessor() {
		this.paramEnclose= true; //使用参数封装
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub

		DeliveryQueryParameter param = (DeliveryQueryParameter) parameter;
		Assert.notBlank(param.getWayid(), ServiceConditionCode.SALES_WAY, "配送商编码不能为空！");
		
		StringBuffer hql = new StringBuffer("select d,w.wayname,o.paytype,o.signstate,o.countyid from FxSwDisform d,Way w,FxSwOrder o " +
				"where d.recewayid = w.wayid and d.orderid = o.orderid " +
				"and d.discomcode = :discomcode");
		//不查待发货和作废的单
		hql.append(" and d.disstate <> '"+ ConstantsType.DISSTATE_WAITOUT +"' and d.disstate <> '"+ ConstantsType.DISSTATE_CANCEL +"' " );
		
		//查询时间
		if (param.getStartDate() != null && param.getEndDate() != null){
			hql.append(" and d.createtime between to_date(:oprtimeBegin, 'yyyy-MM-dd hh24:mi:ss') and to_date(:oprtimeEnd, 'yyyy-MM-dd hh24:mi:ss')");
		}
		//订单状态
		if (StringUtils.isNotBlank(param.getDisstate())){
			hql.append(" and d.disstate = :disstate");
		}
		//配送单号
		if (StringUtils.isNumeric(param.getRecid()) && StringUtils.isNotEmpty(param.getRecid())){
			hql.append(" and d.recid = :recid");
		}
		//订单编号
		if (StringUtils.isNotBlank(param.getOrderid())){
			hql.append(" and d.orderid like :orderid");
		}
		//缴费方式
		if (StringUtils.isNotBlank(param.getPaytype())){
			hql.append(" and o.paytype = :paytype");
		}
		//分公司
		if (StringUtils.isNotBlank(param.getCntyComd())){
			hql.append(" and o.countyid = :countyid");
		}
		hql.append(" order by d.createtime desc ");
		return hql.toString();
	}

	@Override
	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		String [] rtn = {"wayname","paytype","signstate","countyid"};
		return rtn;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {

		DeliveryQueryParameter param = (DeliveryQueryParameter) parameter;
		Assert.notBlank(param.getWayid(), ServiceConditionCode.SALES_WAY, "配送商编码不能为空！");
		
//		Assert.notBlank(param.getComType(), ServiceConditionCode.SALES_COMTYPE, "商品种类不能为空！");
		
		query.setString("discomcode", param.getWayid());
		
		//查询时间
		if (param.getStartDate() != null && param.getEndDate() != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String oprtimeBegin = sdf.format(param.getStartDate()) + " 00:00:00";
			String oprtimeEnd = sdf.format(param.getEndDate()) + " 23:59:59";
			query.setString("oprtimeBegin", oprtimeBegin);
			query.setString("oprtimeEnd", oprtimeEnd);
		}
		
		//订单状态
		if (StringUtils.isNotBlank(param.getDisstate())){
			query.setString("disstate", param.getDisstate());			
		}
		//配送单号
		if (StringUtils.isNumeric(param.getRecid()) && StringUtils.isNotEmpty(param.getRecid())){
			query.setLong("recid", new Long(param.getRecid()));
		}
		//订单编号
		if (StringUtils.isNotBlank(param.getOrderid())){
			query.setString("orderid", param.getOrderid()+"%");			
		}
		//缴费方式
		if (StringUtils.isNotBlank(param.getPaytype())){
			query.setString("paytype",param.getPaytype());
		}
		//分公司
		if (StringUtils.isNotBlank(param.getCntyComd())){
			query.setString("countyid",param.getCntyComd());
		}
	}

}
