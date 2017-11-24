package com.gmcc.pboss.biz.info.node.dao;

import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.common.dao.BaseDao;

public interface WayDao extends BaseDao{
	public Way getByWayid(String wayid);
}
