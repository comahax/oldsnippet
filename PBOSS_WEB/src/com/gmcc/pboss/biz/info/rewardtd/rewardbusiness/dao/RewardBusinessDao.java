package com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.dao;

import java.util.List;

import com.gmcc.pboss.common.dao.BaseDao;

public interface RewardBusinessDao extends BaseDao {
	public List getBusistat(String wayid,String oprmon);
	
}
