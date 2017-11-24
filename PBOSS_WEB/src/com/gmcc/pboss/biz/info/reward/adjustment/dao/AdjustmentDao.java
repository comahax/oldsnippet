package com.gmcc.pboss.biz.info.reward.adjustment.dao;

import java.util.List;

import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.biz.info.reward.adjustment.support.AdjustmentQueryParameter;
import com.gmcc.pboss.common.dao.BaseDao;

public interface AdjustmentDao extends BaseDao {
	
	public Way getWayInfo(String wayid, String magcode);
	
//	public List getBusistat(AdjustmentQueryParameter parameter);
}
