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
	 * ��󶩹�������ѯ
	 * @param type Լ�����ͣ�����APPWAY��
	 * @param code Լ�����󣨺����̱��룩
	 * @return ��Ӧ���ݿ���е�һ����¼������������ maxtimes
	 */
	public FxSwOrdertimes getForMaxtiems(String type,String code){
		String[] properties = new String[]{type,code};
		String[] propertyNames = new String[]{"objtype","objectcode"};
		return (FxSwOrdertimes)super.getOne(propertyNames, properties);
	}
}
