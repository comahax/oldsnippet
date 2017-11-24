package com.gmcc.pboss.biz.info.reward.payment.dao;

import com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfig;
import com.gmcc.pboss.common.dao.BaseDao;

public interface PaymentConfigDao extends BaseDao {
	public ChCwConfig getConfigByQuery(String key);

	public ChCwConfig getConfigBySql(String key);

	public ChCwConfig getConfigByCriteria(String key);

	public boolean updateConfig(ChCwConfig config);

}
