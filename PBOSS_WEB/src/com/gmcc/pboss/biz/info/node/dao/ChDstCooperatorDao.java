package com.gmcc.pboss.biz.info.node.dao;

import com.gmcc.pboss.biz.info.node.model.ChDstCooperator;
import com.gmcc.pboss.common.dao.BaseDao;

public interface ChDstCooperatorDao extends BaseDao {
	public ChDstCooperator getByWayid(String wayid);
}
