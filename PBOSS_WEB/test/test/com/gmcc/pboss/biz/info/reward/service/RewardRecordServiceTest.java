package test.com.gmcc.pboss.biz.info.reward.service;

import java.util.List;

import test.com.gmcc.pboss.common.BaseTest;

import com.gmcc.pboss.biz.info.reward.dao.RewardRecordDao;
import com.gmcc.pboss.biz.info.reward.dao.hibernate.RewardRecordDaoHibernate;
import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

public class RewardRecordServiceTest extends BaseTest {

	private RewardService rewardRecordService;

	private RewardRecordDao rewardRecordDao;
	public RewardService getRewardRecordService() {
		return rewardRecordService;
	}

	public void setRewardRecordService(RewardService rewardRecordService) {
		this.rewardRecordService = rewardRecordService;
	}
	

	public RewardRecordDao getRewardRecordDao() {
		return rewardRecordDao;
	}

	public void setRewardRecordDao(RewardRecordDao rewardRecordDao) {
		this.rewardRecordDao = rewardRecordDao;
	}
	public void testQuery() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		RewardQueryParameter parameter = new RewardQueryParameter();
		parameter.setWayid("CH_2323");
		parameter.setRewardtype("0,1,2,3,4,5,6,7,8,30");
		parameter.setOpnid("0601160100157");
		ServiceResult result = rewardRecordService.query(new LoginMember(), parameter);
		System.out.println(result);
	}

	/**
	 * 测试DAO - RewardRecordDaoHibernate.statRewardBalance方法，提取酬金池余额
	 */
	public void testStatRewardBalance() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		RewardRecordDaoHibernate rrDao = (RewardRecordDaoHibernate)rewardRecordDao;
		RewardQueryParameter parameter = new RewardQueryParameter();
		parameter.setWayid("CH_2323");
		parameter.setTerm("3");
		parameter.setMonth("200908");
		
		Long balance = rrDao.statRewardBalance(parameter);
		System.out.println("balance-------------------------------: "+balance);
	}
}
