/**
 * auto-generated code
 * Thu Sep 17 15:12:34 CST 2009
 */
package com.gmcc.pboss.business.promotion.ppzlnrule;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PpzlnruleDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PpzlnruleDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public PpzlnruleDAO() {
		super(PpzlnruleVO.class);
	}

	public DataPackage doPpzlnruleList() throws Exception {
		return queryByNamedSqlQuery("com.gmcc.pboss.business.promotion.ppzlnrule.queryPpzlnruleList");
	}

	/**
	 * 根据方案标识pid获取规则列表，orderBy决定是否按优先级升序排序
	 * @param pid
	 * @return
	 */
	public DataPackage queryRulesByPid(long pid, boolean orderBy)
			throws Exception {
		PpzlnruleDBParam params = new PpzlnruleDBParam();
		params.setSelectFieldsString("RULEID,PID,PRI");
		params.getQueryConditions().put("PID", pid);
		params.set_pagesize("0");
		params.setDataOnly(true);
		if (orderBy) {
			params.set_orderby("PRI");
		}
		return queryByNamedSqlQuery(
				"com.gmcc.pboss.business.promotion.ppzlnrule.queryRulesByPid",
				params);

	}

}
