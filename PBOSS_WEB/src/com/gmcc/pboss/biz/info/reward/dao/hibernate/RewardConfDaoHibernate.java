package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gmcc.pboss.biz.info.reward.dao.RewardConfDao;
import com.gmcc.pboss.biz.info.reward.model.RewardConf;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class RewardConfDaoHibernate extends BaseDaoHibernate implements RewardConfDao {

	public RewardConfDaoHibernate() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	public RewardConf getRewardConf(String cityId, String rewardkind, String rewardmonth) {
		Criteria criteria = getSession().createCriteria(RewardConf.class);
		criteria.add(Restrictions.eq("cityid", cityId)).add(Restrictions.eq("rewardkind", rewardkind)).add(Restrictions.eq("rewardmonth", rewardmonth));
		return (RewardConf) criteria.uniqueResult();
	}

}
