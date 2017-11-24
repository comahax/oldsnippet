package com.gmcc.pboss.biz.info.salesRpt.dao.hibernate;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.salesRpt.dao.SalesOrderDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.sales.FxSwOrder;

public class SalesOrderDaoHibernate extends BaseDaoHibernate implements SalesOrderDao{

	public SalesOrderDaoHibernate() {
		//设置主表
		super(FxSwOrder.class);
	}
	
	/**
	 * 获取当月已经提交订单条数，不含用户取消的订单
	 * 默认时间限制是查询发生当月，通过获取系统时间实现
	 * 不统计CANCEL的订单
	 * @param code  合作商编码
	 * @return 当月有效订单数目
	 */
	public int getNumbers(String code){
		Criteria criteria = this.getSession().createCriteria(this.getPersistentClass());
		criteria.add(Property.forName("wayid").eq(code));
		criteria.add(Restrictions.not(Property.forName("orderstate").eq("CANCEL")));
		Calendar calendar = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1, 0, 0, 0);
		Date lo = cal2.getTime();
		cal2.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, 0, 0, 0, 0);
		Date hi = cal2.getTime();
		criteria.add(Property.forName("createtime").between(lo, hi));
		
		//String queryString = "select count(i) from FxSwOrder i " +
		//					 "where i.orderstate<>'CANCEL' and i.wayid=:code " +
		//					 " add (i.createtime between :lo and :hi)";
		//Query query= this.getSession().createQuery(queryString);
		//query.setParameter("code", code,Hibernate.STRING);
		//query.setParameter("lo", lo,Hibernate.DATE);
		//query.setParameter("hi", hi,Hibernate.DATE);
		//return (Integer)query.uniqueResult();
		
		return criteria.list().size();
	}
	
	/**
	 * 根据ORDERID获取订单
	 * @param 订单ID
	 * @return 
	 */
	public FxSwOrder getById(String orderid){
		String propertyNames[] = {"orderid"};
		String values[] = {orderid};
		FxSwOrder result = (FxSwOrder)this.getOne(propertyNames, values);
		return result;
	}
}

