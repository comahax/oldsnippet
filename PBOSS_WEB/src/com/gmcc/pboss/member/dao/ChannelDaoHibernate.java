package com.gmcc.pboss.member.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;

import com.gmcc.pboss.common.bean.Channel;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-8-19
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ����������DAOʵ����
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
		if(isnet!=4){//���Ǿ�����Ա
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
