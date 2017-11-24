package com.gmcc.pboss.biz.info.salesDetail.dao.hibernate;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.gmcc.pboss.biz.info.salesDetail.dao.OperationsmsDao;
import com.gmcc.pboss.biz.info.salesDetail.model.ChPwOperationsms;
import com.gmcc.pboss.biz.info.salesDetail.model.ChPwOperationsmsId;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;


public class OperationsmsDaoHinbernate extends BaseDaoHibernate implements
		OperationsmsDao {
	
	public OperationsmsDaoHinbernate(){
		super(ChPwOperationsms.class);
	}
	
	public List getOpnInfo(short opntype,String smsno,String cityid){
		Criteria criteria = this.getSession().createCriteria(this.getPersistentClass());
		criteria.add(Property.forName("id.opntype").eq(opntype));
		criteria.add(Property.forName("id.smsno").eq(smsno));
		criteria.add(Property.forName("id.cityid").eq(cityid));
		List<ChPwOperationsms> result = criteria.list();
		return result;
	}
}
