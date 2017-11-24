package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.reward.dao.RewardLocalDao;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocal;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocaltitle;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocalvalue;

public class RewardLocalDaoHibernate extends BaseDaoHibernate implements RewardLocalDao {

	public RewardLocalDaoHibernate() {
		super(ChPwRewardlocal.class);
	}


	/**
	 * ���û���Ϣ�ͽ����·ݺͱ������ͷ����������
	 * @param member
	 * @param parameter month �����·� Rewardtype ��������
	 * @return
	 */
	public ChPwRewardlocal getRewardlocalByUser(LoginMember member,
			QueryParameter parameter) {
		// TODO Auto-generated method stub
		RewardQueryParameter param = (RewardQueryParameter) parameter;
		//�������ж�		
		Assert.notBlank(member.getWayid(), ServiceConditionCode.REWARD_WAY, "�������벻��Ϊ�գ�");
		Assert.notBlank(param.getRewardtype(), ServiceConditionCode.REWARD_TYPE, "�������Ͳ���Ϊ�գ�");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "��ѯ�·ݲ���Ϊ�գ�");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "��ѯ�·ݸ�ʽ����ȷ��");

		//������ѯ����
		Criteria criteria = getSession().createCriteria(this.getPersistentClass());
		criteria.add(Restrictions.eq("rewardmonth", param.getMonth()));///�·�����
		criteria.add(Restrictions.eq("rpttype", param.getRewardtype()));//��������
		criteria.add(Restrictions.eq("wayid", member.getWayid()));//��������
		
		//���в�ѯ
		criteria.addOrder(Order.asc("rewardid"));
		List<ChPwRewardlocal> allList = criteria.list();

		if (allList.size()==0) return null;
		
		return allList.get(0);
	}
	/**
	 * ���û���Ϣ�ͽ����·ݺͱ������ͷ���������󼯺�
	 * @param member
	 * @param parameter month �����·� Rewardtype ��������
	 * @return
	 */
	public List<ChPwRewardlocal> getRewardlocalListByUser(LoginMember member,
			QueryParameter parameter) {
		// TODO Auto-generated method stub
		RewardQueryParameter param = (RewardQueryParameter) parameter;
		//�������ж�		
		Assert.notBlank(member.getWayid(), ServiceConditionCode.REWARD_WAY, "�������벻��Ϊ�գ�");
		Assert.notBlank(param.getRewardtype(), ServiceConditionCode.REWARD_TYPE, "�������Ͳ���Ϊ�գ�");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "��ѯ�·ݲ���Ϊ�գ�");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "��ѯ�·ݸ�ʽ����ȷ��");

		//������ѯ����
		Criteria criteria = getSession().createCriteria(this.getPersistentClass());
		criteria.add(Restrictions.eq("rewardmonth", param.getMonth()));///�·�����
		criteria.add(Restrictions.eq("rpttype", param.getRewardtype()));//��������
		criteria.add(Restrictions.eq("wayid", member.getWayid()));//��������
		
		//���в�ѯ
		criteria.addOrder(Order.asc("rewardid"));
		List<ChPwRewardlocal> allList = criteria.list();
		return allList;
		//if (allList.size()==0) return null;
		
		//return allList.get(0);
	}

	/**
	 * ������ID��ѯ��ϸ��
	 * @param id
	 * @return
	 */
	public List<ChPwRewardlocalvalue> getRewardlocalValuesById(Long id) {
		// TODO Auto-generated method stub

		//�������ж�		
		Assert.notNull(id, ServiceConditionCode.ID_EMPTY, "ID����Ϊ�գ�");
		
		String hql = "select localvalue from ChPwRewardlocalvalue localvalue where localvalue.id.mstid = :mstid order by localvalue.id.seq";
		Query query = getSession().createQuery(hql);
		query.setLong("mstid", id);
		
		return query.list();
	}
}