package com.gmcc.pboss.biz.info.rewardtd.rewardtdfail.dao.hibernate;

import java.util.List;
import org.hibernate.Query;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdfail.dao.RewardTdFailDao;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdfail.support.RewardTdFailInfo;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdfail.support.RewardTdFailQueryParameter;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;

public class RewardTdFailDaoHibernate extends BaseHqlQueryDao  implements RewardTdFailDao{
	
	public RewardTdFailDaoHibernate() {
		super(RewardTdFailInfo.class);
	}   
	

}
