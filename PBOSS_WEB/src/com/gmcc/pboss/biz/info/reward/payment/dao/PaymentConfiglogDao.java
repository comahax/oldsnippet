package com.gmcc.pboss.biz.info.reward.payment.dao;

import com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfiglog;
import com.gmcc.pboss.common.dao.BaseDao;

public interface PaymentConfiglogDao extends BaseDao {
	public boolean saveConfiglog(ChCwConfiglog configlog);
}
