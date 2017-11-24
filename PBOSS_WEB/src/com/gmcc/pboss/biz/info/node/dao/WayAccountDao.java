package com.gmcc.pboss.biz.info.node.dao;

import com.gmcc.pboss.biz.info.node.model.WayAccount;
import com.gmcc.pboss.common.dao.BaseDao;

public interface WayAccountDao extends BaseDao {
	public WayAccount getWayAccountByWayidAccno(String wayid);
}
