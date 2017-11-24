package com.gmcc.pboss.biz.info.reward.dao;

import java.util.List;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocal;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocaltitle;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocalvalue;

public interface RewardLocalDao extends BaseDao {

	/**
	 * 按用户信息和结算月份和报表类型返回主表对象
	 * @param member
	 * @param parameter month 结算月份 Rewardtype 报表类型
	 * @return
	 */
	public ChPwRewardlocal getRewardlocalByUser(LoginMember member,QueryParameter parameter);
	/**
	 * 按用户信息和结算月份和报表类型返回主表对象集合
	 * @param member
	 * @param parameter month 结算月份 Rewardtype 报表类型
	 * @return
	 */
	public List<ChPwRewardlocal> getRewardlocalListByUser(LoginMember member,
			QueryParameter parameter);
	
	/**
	 * 按主表ID查询明细表
	 * @param id
	 * @return
	 */
	public List<ChPwRewardlocalvalue> getRewardlocalValuesById(Long id);
}
