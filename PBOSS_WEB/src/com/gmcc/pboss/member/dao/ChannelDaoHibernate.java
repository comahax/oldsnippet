package com.gmcc.pboss.member.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;

import com.gmcc.pboss.common.bean.Channel;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-8-19
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：渠道DAO实现类
* */
public class ChannelDaoHibernate extends BaseDaoHibernate implements IChannelDao {
	
	public ChannelDaoHibernate() {
		super(Channel.class);
		// TODO Auto-generated constructor stub
	}

	public Channel getChannelByWayId(String wayId,long isnet) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Property.forName("wayid").eq(wayId));
		if(isnet!=4){//不是经理人员
			criteria.add(Property.forName("waytype").eq("AG"));
		}
		return (Channel)criteria.uniqueResult();
	}
	public Channel getByWayId(String wayId) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Property.forName("wayid").eq(wayId));
		
		return (Channel)criteria.uniqueResult();
	}
}
