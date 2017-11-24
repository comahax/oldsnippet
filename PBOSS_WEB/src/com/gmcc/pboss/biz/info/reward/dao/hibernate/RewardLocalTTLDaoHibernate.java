package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.basic.node.service.impl.WayApplyServiceImpl;
import com.gmcc.pboss.biz.info.reward.dao.RewardLocalDao;
import com.gmcc.pboss.biz.info.reward.dao.RewardLocalTTLDao;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocal;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocaltitle;

public class RewardLocalTTLDaoHibernate extends BaseDaoHibernate implements RewardLocalTTLDao {

	private static Logger logger = Logger.getLogger(RewardLocalTTLDaoHibernate.class);
	public RewardLocalTTLDaoHibernate() {
		super(ChPwRewardlocaltitle.class);
	}

	/**
	 * �������·ݺͱ������ͷ��ر�������
	 * @param RewardQueryParameter month �����·�  rewardtype ��������
	 * @return
	 */
	public List<ChPwRewardlocaltitle> getLocalTitle(QueryParameter parameter){
		RewardQueryParameter param = (RewardQueryParameter) parameter;
		//�������ж�		
//		Assert.notBlank(param.getRewardtype(), ServiceConditionCode.REWARD_WAY, "�������벻��Ϊ�գ�");
		Assert.notBlank(param.getRewardtype(), ServiceConditionCode.REWARD_TYPE, "�������Ͳ���Ϊ�գ�");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "��ѯ�·ݲ���Ϊ�գ�");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "��ѯ�·ݸ�ʽ����ȷ��");

		//������ѯ����
		Criteria criteria = getSession().createCriteria(this.getPersistentClass());
		criteria.add(Restrictions.eq("id.rewardmonth", param.getMonth()));///�·�����
		criteria.add(Restrictions.eq("id.rpttype", param.getRewardtype()));//��������
		criteria.addOrder(Order.asc("id.seq"));
		//���в�ѯ
		List<ChPwRewardlocaltitle> rtn = criteria.list();
		return rtn;
	};
}