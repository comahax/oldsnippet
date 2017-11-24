package com.gmcc.pboss.biz.info.salesRpt.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;

import com.gmcc.pboss.biz.info.salesRpt.dao.OrderTimesDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.sales.FxSwOrdertimes;

public class OrderTimesDaoHibernate extends BaseDaoHibernate implements OrderTimesDao{
	
	public OrderTimesDaoHibernate(){
		super(FxSwOrdertimes.class);
	}
	/**
	 * 最大订购次数查询
	 * @param type 约束类型（渠道APPWAY）
	 * @param code 约束对象（合作商编码）
	 * @return 对应数据库表中的一条记录，含最大次数项 maxtimes
	 */
	public FxSwOrdertimes getForMaxtiems(String type,String code){
		String[] properties = new String[]{type,code};
		String[] propertyNames = new String[]{"objtype","objectcode"};
		return (FxSwOrdertimes)super.getOne(propertyNames, properties);
	}
}
