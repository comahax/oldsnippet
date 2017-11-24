package com.gmcc.pboss.biz.info.salesRpt.dao;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.model.sales.FxRuOrderproce;

public interface OrderProceDao extends BaseDao {
	
	/**
	 * 按流程编号、入口状态提取订单流程步骤表对象
	 * @param flowid
	 * @param instate
	 * @return
	 */
	public FxRuOrderproce getByFlowidInstate(Long flowid,String instate);
}
