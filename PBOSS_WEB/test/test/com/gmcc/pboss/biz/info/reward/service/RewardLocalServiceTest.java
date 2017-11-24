package test.com.gmcc.pboss.biz.info.reward.service;

import java.util.List;

import com.gmcc.pboss.biz.info.reward.service.RewardLocalService;
import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocal;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocaltitle;

import test.com.gmcc.pboss.common.BaseTest;

public class RewardLocalServiceTest extends BaseTest {

	private RewardLocalService rewardLocalService;
	
	public void testQuery1() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		RewardQueryParameter parameter = new RewardQueryParameter();
		LoginMember member = new LoginMember();
		member.setWayid("NESW1DZBF");
		member.setCityno("ZS");
//		member.setCityid("ZS");
		
		parameter.setWayid(member.getWayid());
//		parameter.setRewardtype("1,2,3,4,5");
		parameter.setMonth("201007");
		parameter.setRewardtype("RPWDSumRealPay");
		
		ServiceResult result = rewardLocalService.query(member, parameter);
		if (result.isSuccess()){
//			System.out.println(result);
			Object[] rtn = (Object[]) result.getRetObject();
			ChPwRewardlocal localObj = (ChPwRewardlocal) rtn[0];
			List<ChPwRewardlocaltitle> ttlList = (List<ChPwRewardlocaltitle>) rtn[1];
			
			System.out.println(localObj.getRewardid()+"::[size:"+ ttlList.size() +"]::");
		}else{
			result.setMessage(ConfigUtil.getMessage(ServiceCode.REWARD_LOCAL, result.getRetCode()));
			System.out.println(result.getMessage()+"["+ result.getRetCode() +"]");
		}
		
	}
	/**
	 * @return the rewardLocalService
	 */
	public RewardLocalService getRewardLocalService() {
		return rewardLocalService;
	}
	/**
	 * @param rewardLocalService the rewardLocalService to set
	 */
	public void setRewardLocalService(RewardLocalService rewardLocalService) {
		this.rewardLocalService = rewardLocalService;
	}
}
