package com.gmcc.pboss.biz.info.rewardtd.rewardadsuc.dao;

import java.util.Map;

import com.gmcc.pboss.common.dao.BaseDao;

public interface RewardAdSucDao extends BaseDao{ 
	public String getComnameSuc (String bakinfo2);
	 

	//key-酬金类型ID，value-酬金类型NAME
	public Map<String,String> getDictitemRestype();

}
