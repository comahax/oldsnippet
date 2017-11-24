package com.gmcc.pboss.biz.basic.node.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;

import com.gmcc.pboss.biz.basic.node.dao.ChPwFlownameDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.channel.ChPwFlowname;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-10-28
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class ChPwFlownameDaoHibernate extends BaseDaoHibernate implements ChPwFlownameDao{

	public ChPwFlownameDaoHibernate() {
		super(ChPwFlowname.class);
	}

	public String getOprcodeByStepID(String stepID) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Property.forName("stepid").eq(stepID));
		ChPwFlowname flowname = (ChPwFlowname)criteria.uniqueResult();
		
		String oprcode = (flowname!=null)?flowname.getOprcode():"";
		return oprcode;
	}
	
}
