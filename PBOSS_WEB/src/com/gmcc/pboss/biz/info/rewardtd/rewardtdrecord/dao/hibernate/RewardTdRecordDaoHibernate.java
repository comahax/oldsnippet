package com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.dao.hibernate;
 
import java.util.List; 
import org.hibernate.Query; 
import com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.dao.RewardTdRecordDao;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.support.RewardTdRecordInfo;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.support.RewardTdRecordQueryParameter;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
 

public class RewardTdRecordDaoHibernate extends BaseHqlQueryDao implements RewardTdRecordDao{
	
	public RewardTdRecordDaoHibernate() {
		super(RewardTdRecordInfo.class);
	}  
	
}
