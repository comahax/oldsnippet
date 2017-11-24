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
	 * 按结算月份和报表类型返回标题表对象
	 * @param RewardQueryParameter month 结算月份  rewardtype 报表类型
	 * @return
	 */
	public List<ChPwRewardlocaltitle> getLocalTitle(QueryParameter parameter){
		RewardQueryParameter param = (RewardQueryParameter) parameter;
		//必填项判断		
//		Assert.notBlank(param.getRewardtype(), ServiceConditionCode.REWARD_WAY, "渠道编码不能为空！");
		Assert.notBlank(param.getRewardtype(), ServiceConditionCode.REWARD_TYPE, "报表类型不能为空！");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "查询月份不能为空！");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "查询月份格式不正确！");

		//建立查询对象
		Criteria criteria = getSession().createCriteria(this.getPersistentClass());
		criteria.add(Restrictions.eq("id.rewardmonth", param.getMonth()));///月分条件
		criteria.add(Restrictions.eq("id.rpttype", param.getRewardtype()));//报表类型
		criteria.addOrder(Order.asc("id.seq"));
		//进行查询
		List<ChPwRewardlocaltitle> rtn = criteria.list();
		return rtn;
	};
}