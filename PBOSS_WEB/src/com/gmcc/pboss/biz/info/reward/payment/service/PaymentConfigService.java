package com.gmcc.pboss.biz.info.reward.payment.service;

import com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfig;
import com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfiglog;
import com.gmcc.pboss.common.service.BaseService;

public interface PaymentConfigService extends BaseService {
	public ChCwConfig getConfigByQuery(String key);

	public ChCwConfig getConfigBySql(String key);

	public ChCwConfig getConfigByCriteria(String key);

	public boolean updateConfig(ChCwConfig config);

	public boolean saveConfiglog(ChCwConfiglog configlog);
}
