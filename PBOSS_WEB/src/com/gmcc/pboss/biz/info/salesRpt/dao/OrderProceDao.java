package com.gmcc.pboss.biz.info.salesRpt.dao;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.model.sales.FxRuOrderproce;

public interface OrderProceDao extends BaseDao {
	
	/**
	 * �����̱�š����״̬��ȡ�������̲�������
	 * @param flowid
	 * @param instate
	 * @return
	 */
	public FxRuOrderproce getByFlowidInstate(Long flowid,String instate);
}
