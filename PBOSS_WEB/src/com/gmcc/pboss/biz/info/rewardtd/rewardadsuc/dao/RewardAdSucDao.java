package com.gmcc.pboss.biz.info.rewardtd.rewardadsuc.dao;

import java.util.Map;

import com.gmcc.pboss.common.dao.BaseDao;

public interface RewardAdSucDao extends BaseDao{ 
	public String getComnameSuc (String bakinfo2);
	 

	//key-�������ID��value-�������NAME
	public Map<String,String> getDictitemRestype();

}
