package com.gmcc.pboss.biz.info.delivery.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.delivery.bean.OrderPackageInfo;
import com.gmcc.pboss.biz.info.delivery.bean.OrderState;
import com.gmcc.pboss.biz.info.delivery.dao.DeliveryDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.member.model.Employee;
import com.gmcc.pboss.model.delivery.FxSwDisform;
import com.gmcc.pboss.model.sales.FxSwOrdercomcate;
import com.gmcc.pboss.model.sales.FxSwOrderresdet;

public class DeliveryDaoHibernate extends BaseHqlQueryDao implements DeliveryDao {

	public DeliveryDaoHibernate() {
		//设置主表
		super(FxSwDisform.class);
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate#getOne(java.lang.String[], java.lang.Object[])
	 */
	/**
	 * 重载父类的方法，把查询过程改为调用HQL查询
	 */
	@Override
	public Object getOne(String[] propertyNames, Object[] values) {
		// TODO Auto-generated method stub
		return super.getOne(propertyNames, values);
	}

	public List<OrderState> getOrderInfo(String orderId) {
		// TODO Auto-generated method stub

		Assert.notBlank(orderId, ServiceConditionCode.ID_EMPTY, "订单编号不能为空！");
//		FX_SW_ORDERCOMCATE
		Criteria query = getSession().createCriteria(FxSwOrdercomcate.class);
		ProjectionList projection = Projections.projectionList();
		projection.add(Projections.sum("orderamt"));	//sum(orderamt)
		projection.add(Projections.groupProperty("comcategory")); //Group by comcategory
		query.setProjection(projection);
		query.add(Restrictions.eq("orderid", orderId));
		
		List<Object[]> rtnList = query.list();
		//封装返回值
		List<OrderState> rtn = new ArrayList<OrderState>();
		for (Object[] obj:rtnList){
			OrderState odrState = new OrderState();
			odrState.setNum((Long) obj[0]);
			odrState.setDictitem((String) obj[1]);
			rtn.add(odrState);
		}
//		session.createCriteria(FxSwOrdercomcate.class);
		return rtn;
	}

	public List<FxSwOrdercomcate> getOrderComcateDtl(String orderId) {
		// TODO Auto-generated method stub
		Assert.notBlank(orderId, ServiceConditionCode.ID_EMPTY, "订单编号不能为空！");
		Criteria query = getSession().createCriteria(FxSwOrdercomcate.class);
		query.add(Restrictions.eq("orderid", orderId));
		return query.list();
	}

	/**
	 * 按订单ID、商品种类和订单类型返回批次等信息
	 * @param orderId
	 * @param ordercomtype
	 * @param category
	 * @return
	 */
	public List<OrderPackageInfo> getOrderBatchNoDtl(String orderId,
			String ordercomtype, String category) {
		// TODO Auto-generated method stub
		Assert.notBlank(orderId, ServiceConditionCode.ID_EMPTY, "订单编号不能为空！");
		Criteria query = getSession().createCriteria(FxSwOrderresdet.class);
		//设置Group 相关信息
		ProjectionList projection = Projections.projectionList();
		projection.add(Projections.count("detid"));	//sum(orderamt)
		projection.add(Projections.groupProperty("comcategory")); //Group by comcategory
		projection.add(Projections.groupProperty("batchno")); //Group by comcategory
		projection.add(Projections.groupProperty("boxnum")); //Group by comcategory
		projection.add(Projections.groupProperty("ordercomtype")); //Group by comcategory
		
		query.setProjection(projection);
		//封装查询条件
		query.add(Restrictions.eq("orderid", orderId));
		if (StringUtils.isNotEmpty(ordercomtype)) query.add(Restrictions.eq("ordercomtype", ordercomtype));
		if (StringUtils.isNotEmpty(category)) query.add(Restrictions.eq("comcategory", category));
 		//封装Order by order by batchno,boxnum
		query.addOrder(Property.forName("batchno").asc()); 
		query.addOrder(Property.forName("boxnum").asc()); 
		/*
		 * 封装的SQL语句
		 * select count(this_.DETID) as y0_, this_.COMCATEGORY as y1_, 
		 * this_.BATCHNO as y2_, this_.BOXNUM as y3_, this_.ORDERCOMTYPE as y4_ 
		 * from FX_SW_ORDERRESDET this_ 
		 * where this_.ORDERID=? and this_.ORDERCOMTYPE=? and this_.COMCATEGORY=? 
		 * group by this_.COMCATEGORY, this_.BATCHNO, this_.BOXNUM, this_.ORDERCOMTYPE
		 * order by this_.BATCHNO asc, this_.BOXNUM asc
		 */
		List<Object[]> queryLst = query.list();
		//封装返回值
		List<OrderPackageInfo> rtn = new ArrayList<OrderPackageInfo>();

		for (Object[] obj:queryLst){
			OrderPackageInfo dtl = new OrderPackageInfo();
			dtl.setCount((Integer) obj[0]);
			dtl.setComcategory((String) obj[1]);
			dtl.setBatchno((String) obj[2]);
			dtl.setBoxnum((String) obj[3]);
			dtl.setOrdercomtype((String) obj[4]);

			rtn.add(dtl);
		}
		return rtn;
	}


	/**
	 * 按订单ID、商品种类和订单类型返回最大值、最小值等信息
	 * @param orderId
	 * @param ordercomtype
	 * @param category
	 * @return
	 */
	public OrderPackageInfo getMaxMinDtl(String orderId, String ordercomtype,
			String category) {
		// TODO Auto-generated method stub
		Assert.notBlank(orderId, ServiceConditionCode.ID_EMPTY, "订单编号不能为空！");
		Criteria query = getSession().createCriteria(FxSwOrderresdet.class);
		//设置Group 相关信息
		ProjectionList projection = Projections.projectionList();
		projection.add(Projections.min("comresid"));	//min(comresid)
		projection.add(Projections.max("comresid"));	//max(comresid)
		projection.add(Projections.count("detid"));		//count(orderamt)
		
		query.setProjection(projection);
		//封装查询条件
		query.add(Restrictions.eq("orderid", orderId));
		if (StringUtils.isNotEmpty(ordercomtype)) query.add(Restrictions.eq("ordercomtype", ordercomtype));
		if (StringUtils.isNotEmpty(category)) query.add(Restrictions.eq("comcategory", category));
		/*合成的SQL语句
		 * select min(this_.COMRESID) as y0_, max(this_.COMRESID) as y1_, count(this_.DETID) as y2_ 
		 * from FX_SW_ORDERRESDET this_ 
		 * where this_.ORDERID=?  and this_.ORDERCOMTYPE=? and this_.COMCATEGORY=?
		 */
		Object[] dtl = (Object[]) query.uniqueResult();
		OrderPackageInfo rtn = null;
		if (dtl != null){
		 	rtn = new OrderPackageInfo();
		 	rtn.setMinres((String) dtl[0]);
		 	rtn.setMaxres((String) dtl[1]);
		 	rtn.setCount((Integer) dtl[2]);
		}
		return rtn;
	}

	public List<FxSwDisform> getFxSwDisform(String orderId,String discomcode) {
		Assert.notBlank(orderId, ServiceConditionCode.ID_EMPTY, "订单编号不能为空！");
		Criteria criteria = getSession().createCriteria(FxSwDisform.class);
		criteria.add(Restrictions.eq("orderid", orderId));
		criteria.add(Restrictions.eq("discomcode", discomcode));
		return criteria.list();
	}
	
	public Employee getWayNetEmployee(String wayid){
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("wayid", wayid));
		criteria.add(Restrictions.eq("isnet", new Long(1)));
		criteria.add(Restrictions.eq("empstatus", new Long(0)));
		List l = criteria.list();
		if(l.size()>0)
			return (Employee)l.get(0);
		return null;
	}
	
	public FxSwDisform getDisform(Long recid,String discomcode){
		Criteria criteria = getSession().createCriteria(FxSwDisform.class);
		criteria.add(Restrictions.eq("recid", recid));
		criteria.add(Restrictions.eq("discomcode", discomcode));
		return (FxSwDisform)criteria.uniqueResult();
	}
	
}

