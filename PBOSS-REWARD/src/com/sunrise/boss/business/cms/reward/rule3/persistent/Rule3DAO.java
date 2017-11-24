/**
 * auto-generated code
 * Mon Feb 04 12:04:50 CST 2008
 */
package com.sunrise.boss.business.cms.reward.rule3.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>
 * Title: Rule3DAO
 * </p>
 * <p>
 * Description: Data Access Object for Rule3VO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class Rule3DAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public Rule3DAO() {
		super(Rule3VO.class);
	}

	public DataPackage queryRuleIn3Tables(Rule3ListVO listvo) throws Exception {
		return queryByNamedSqlQuery("queryRuleIn3Tables", listvo);
	}
}
