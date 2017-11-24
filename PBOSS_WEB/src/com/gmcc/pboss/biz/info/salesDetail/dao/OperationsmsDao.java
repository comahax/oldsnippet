package com.gmcc.pboss.biz.info.salesDetail.dao;

import java.util.List;
import java.util.Map;
import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.biz.info.salesDetail.model.ChPwOperationsms;

public interface OperationsmsDao extends BaseDao {

	/**
	 * ÒµÎñ±àÂë²éÑ¯
	 */
	public List getOpnInfo(short opntype,String smsno,String cityid);
}
