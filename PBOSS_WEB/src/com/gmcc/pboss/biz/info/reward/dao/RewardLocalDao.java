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
	 * ���û���Ϣ�ͽ����·ݺͱ������ͷ����������
	 * @param member
	 * @param parameter month �����·� Rewardtype ��������
	 * @return
	 */
	public ChPwRewardlocal getRewardlocalByUser(LoginMember member,QueryParameter parameter);
	/**
	 * ���û���Ϣ�ͽ����·ݺͱ������ͷ���������󼯺�
	 * @param member
	 * @param parameter month �����·� Rewardtype ��������
	 * @return
	 */
	public List<ChPwRewardlocal> getRewardlocalListByUser(LoginMember member,
			QueryParameter parameter);
	
	/**
	 * ������ID��ѯ��ϸ��
	 * @param id
	 * @return
	 */
	public List<ChPwRewardlocalvalue> getRewardlocalValuesById(Long id);
}
