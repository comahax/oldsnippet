package com.gmcc.pboss.biz.info.node.service;

import com.gmcc.pboss.biz.info.node.model.ChDstCooperator;
import com.gmcc.pboss.common.service.BaseService;

public interface ChDstCooperatorService extends BaseService {
	public ChDstCooperator getByWayid(String wayid);
}
