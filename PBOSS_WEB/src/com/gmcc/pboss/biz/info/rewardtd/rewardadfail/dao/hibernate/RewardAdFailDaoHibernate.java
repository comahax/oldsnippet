package com.gmcc.pboss.biz.info.rewardtd.rewardadfail.dao.hibernate;

import com.gmcc.pboss.biz.info.rewardtd.rewardadfail.dao.RewardAdFailDao;
import com.gmcc.pboss.biz.info.rewardtd.rewardadfail.support.RewardAdFailInfo;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;

public class RewardAdFailDaoHibernate extends BaseHqlQueryDao  implements RewardAdFailDao{
	
	public RewardAdFailDaoHibernate() {
		super(RewardAdFailInfo.class);
	}   
	

}
