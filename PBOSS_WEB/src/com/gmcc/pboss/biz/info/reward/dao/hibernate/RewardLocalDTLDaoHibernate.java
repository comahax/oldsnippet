package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.reward.dao.RewardLocalDTLDao;
import com.gmcc.pboss.biz.info.reward.dao.RewardLocalDao;
import com.gmcc.pboss.biz.info.reward.dao.RewardLocalTTLDao;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocal;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocaldtl;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocaltitle;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocalvalue;

public class RewardLocalDTLDaoHibernate extends BaseDaoHibernate implements RewardLocalDTLDao {

	public RewardLocalDTLDaoHibernate() {
		super(ChPwRewardlocaldtl.class);
	}

	public QueryResult doQuery(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		RewardQueryParameter param = (RewardQueryParameter) parameter;
		//必填项判断		
		Assert.notBlank(member.getWayid(), ServiceConditionCode.REWARD_WAY, "渠道编码不能为空！");
//		Assert.notBlank(param.getRewardtype(), ServiceConditionCode.REWARD_TYPE, "报表类型不能为空！");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "查询月份不能为空！");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "查询月份格式不正确！");
		

		//建立查询对象
		Criteria criteria = getSession().createCriteria(this.getPersistentClass());
		criteria.add(Restrictions.eq("rewardmonth", param.getMonth()));///月分条件
		criteria.add(Restrictions.eq("wayid", member.getWayid()));//渠道编码
		//手机号码条件
		if (StringUtils.isNotBlank(param.getOpermobile())){
			criteria.add(Restrictions.like("mobleno", "%"+ param.getOpermobile() +"%"));			
		}
		if (StringUtils.isNotBlank(param.getType())){
			criteria.add(Restrictions.eq("type", param.getType() ));			
		}
//		criteria.addOrder(Order.asc("id.seq"));
		//进行查询
		List<ChPwRewardlocaltitle> rtnList = criteria.list();
		QueryResult rtn = new QueryResult(null, rtnList);
		
		return rtn;
	}
}