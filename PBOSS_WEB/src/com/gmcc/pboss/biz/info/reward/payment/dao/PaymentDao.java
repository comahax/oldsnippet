package com.gmcc.pboss.biz.info.reward.payment.dao;

import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.common.dao.BaseDao;

public interface PaymentDao extends BaseDao {
	
	public Way getWayInfo(String wayid, String magcode);
	
//	public List getBusistat(AdjustmentQueryParameter parameter);
}
