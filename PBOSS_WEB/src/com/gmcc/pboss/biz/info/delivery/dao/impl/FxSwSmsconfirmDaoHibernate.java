package com.gmcc.pboss.biz.info.delivery.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.delivery.dao.FxSwSmsconfirmDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.sms.FxSwSmsconfirm;

public class FxSwSmsconfirmDaoHibernate extends BaseDaoHibernate implements FxSwSmsconfirmDao {

	public FxSwSmsconfirmDaoHibernate() {
		super(FxSwSmsconfirm.class);
	}
	
	public FxSwSmsconfirm getSmsconfirm(String type, String mobileno,String orderid,String state){
		Criteria criteria = getSession().createCriteria(FxSwSmsconfirm.class);
		criteria.add(Restrictions.eq("type", type));
		criteria.add(Restrictions.eq("mobileno", mobileno));
		criteria.add(Restrictions.eq("orderid", orderid));
		criteria.add(Restrictions.eq("state", state));
		//criteria.add(Restrictions.ge("sendtime", date));
		criteria.addOrder(Order.asc("sendtime"));
		List result = criteria.list();
		if(result.size()==0)
			return null;
		return (FxSwSmsconfirm)result.get(0);
	}

}
