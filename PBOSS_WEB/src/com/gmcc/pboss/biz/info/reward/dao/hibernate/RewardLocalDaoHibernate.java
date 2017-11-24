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
	 * 按用户信息和结算月份和报表类型返回主表对象
	 * @param member
	 * @param parameter month 结算月份 Rewardtype 报表类型
	 * @return
	 */
	public ChPwRewardlocal getRewardlocalByUser(LoginMember member,
			QueryParameter parameter) {
		// TODO Auto-generated method stub
		RewardQueryParameter param = (RewardQueryParameter) parameter;
		//必填项判断		
		Assert.notBlank(member.getWayid(), ServiceConditionCode.REWARD_WAY, "渠道编码不能为空！");
		Assert.notBlank(param.getRewardtype(), ServiceConditionCode.REWARD_TYPE, "报表类型不能为空！");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "查询月份不能为空！");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "查询月份格式不正确！");

		//建立查询对象
		Criteria criteria = getSession().createCriteria(this.getPersistentClass());
		criteria.add(Restrictions.eq("rewardmonth", param.getMonth()));///月分条件
		criteria.add(Restrictions.eq("rpttype", param.getRewardtype()));//报表类型
		criteria.add(Restrictions.eq("wayid", member.getWayid()));//报表类型
		
		//进行查询
		criteria.addOrder(Order.asc("rewardid"));
		List<ChPwRewardlocal> allList = criteria.list();

		if (allList.size()==0) return null;
		
		return allList.get(0);
	}
	/**
	 * 按用户信息和结算月份和报表类型返回主表对象集合
	 * @param member
	 * @param parameter month 结算月份 Rewardtype 报表类型
	 * @return
	 */
	public List<ChPwRewardlocal> getRewardlocalListByUser(LoginMember member,
			QueryParameter parameter) {
		// TODO Auto-generated method stub
		RewardQueryParameter param = (RewardQueryParameter) parameter;
		//必填项判断		
		Assert.notBlank(member.getWayid(), ServiceConditionCode.REWARD_WAY, "渠道编码不能为空！");
		Assert.notBlank(param.getRewardtype(), ServiceConditionCode.REWARD_TYPE, "报表类型不能为空！");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "查询月份不能为空！");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "查询月份格式不正确！");

		//建立查询对象
		Criteria criteria = getSession().createCriteria(this.getPersistentClass());
		criteria.add(Restrictions.eq("rewardmonth", param.getMonth()));///月分条件
		criteria.add(Restrictions.eq("rpttype", param.getRewardtype()));//报表类型
		criteria.add(Restrictions.eq("wayid", member.getWayid()));//报表类型
		
		//进行查询
		criteria.addOrder(Order.asc("rewardid"));
		List<ChPwRewardlocal> allList = criteria.list();
		return allList;
		//if (allList.size()==0) return null;
		
		//return allList.get(0);
	}

	/**
	 * 按主表ID查询明细表
	 * @param id
	 * @return
	 */
	public List<ChPwRewardlocalvalue> getRewardlocalValuesById(Long id) {
		// TODO Auto-generated method stub

		//必填项判断		
		Assert.notNull(id, ServiceConditionCode.ID_EMPTY, "ID不能为空！");
		
		String hql = "select localvalue from ChPwRewardlocalvalue localvalue where localvalue.id.mstid = :mstid order by localvalue.id.seq";
		Query query = getSession().createQuery(hql);
		query.setLong("mstid", id);
		
		return query.list();
	}
}