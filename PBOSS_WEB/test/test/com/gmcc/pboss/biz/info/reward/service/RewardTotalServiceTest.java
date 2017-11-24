package test.com.gmcc.pboss.biz.info.reward.service;

import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

import test.com.gmcc.pboss.common.BaseTest;

public class RewardTotalServiceTest extends BaseTest {

	private RewardService rewardTotalService;
	private RewardService rewardRecordService;

	public RewardService getRewardTotalService() {
		return rewardTotalService;
	}

	public void setRewardTotalService(RewardService rewardTotalService) {
		this.rewardTotalService = rewardTotalService;
	}

	/**
	 * @return the rewardRecordService
	 */
	public RewardService getRewardRecordService() {
		return rewardRecordService;
	}

	/**
	 * @param rewardRecordService the rewardRecordService to set
	 */
	public void setRewardRecordService(RewardService rewardRecordService) {
		this.rewardRecordService = rewardRecordService;
	}

	public void testQuery1() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		RewardQueryParameter parameter = new RewardQueryParameter();
		LoginMember member = new LoginMember();
		member.setWayid("CH_2323");
		member.setCityno("ZS");
//		member.setCityid("ZS");
		
		parameter.setWayid(member.getWayid());
//		parameter.setRewardtype("1,2,3,4,5");
		parameter.setMonth("200907");
		
		ServiceResult result = rewardRecordService.query(member, parameter);
		if (result.isSuccess()){
//			System.out.println(result);
			System.out.println(result.getRetResult().getData().size());
		}else{
			result.setMessage(ConfigUtil.getMessage(ServiceCode.REWARD_SOCIETY, result.getRetCode()));
			System.out.println(result.getMessage()+"["+ result.getRetCode() +"]");
		}
		
	}
	/**
	 * 提取酬金池余额 - 使用Service
	 */
	public void testQueryBalance(){
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		LoginMember member = new LoginMember();
		member.setWayid("CH_2323");
		member.setCityno("ZS");
		

		RewardQueryParameter parameter = new RewardQueryParameter();
		parameter.setMonth("200908");

		ServiceResult result = rewardRecordService.other(member, parameter);
		if (result.isSuccess()){
//			System.out.println(result);
			Long rtn[] = (Long[]) result.getRetObject();//返回值封装在Long[]中:[0]=二期结算金额总额;[1]=三期结算金额总额,
			System.out.println(rtn.length+":0:"+rtn[0]+":1:"+rtn[1]);
		}else{
			result.setMessage(ConfigUtil.getMessage(ServiceCode.REWARD_SOCIETY, result.getRetCode()));
			System.out.println(result.getMessage()+"["+ result.getRetCode() +"]");
		}
		
	}
}
