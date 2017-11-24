/**
 * auto-generated code
 * Mon Jan 04 14:36:51 CST 2010
 */
package com.sunrise.boss.business.cms.bbc.mmopn.persistent;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: MmopnDAO</p>
 * <p>Description: Data Access Object for MmopnVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class MmopnDAO extends BaseLogDAO {

	/**
	 * default constructor
	 */
	public MmopnDAO() {
		super(MmopnVO.class);
	}

	public void registerLog(String methodName, Object vo, User user)
			throws Exception {
		Class voClass = vo.getClass();

		if (vo instanceof OperationLog) {
			OperationLog operationLog = (OperationLog) vo;
			Class logVOClass = operationLog.logVOClass();
			Object logvo = logVOClass.newInstance();
			registerOperationLog(methodName, vo, logvo, user);
		}
	}

	public DataPackage queryRangemm(MmopnListVO params, String opnid)
			throws Exception {
		params.getQueryConditions().put("opnid", opnid);
		return queryByNamedSqlQuery("mmopnrangeQuery", params);
	}

	public DataPackage queryRangemusic(MmopnListVO params, String opnid)
			throws Exception {
		params.getQueryConditions().put("opnid", opnid);
		return queryByNamedSqlQuery("musicopnrangeQuery", params);
	}
}
