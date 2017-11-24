/**
 * auto-generated code
 * Wed Mar 05 16:41:04 CST 2008
 */
package com.sunrise.boss.business.cms.reward.rewardrulequery.persistent;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordListVO;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>
 * Title: StdrewardbjDAO
 * </p>
 * <p>
 * Description: Data Access Object for StdrewardbjVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author linli
 * @version 1.0
 */
public class RewardrulequeryDAO extends BaseDAO {

	public RewardrulequeryDAO() {
		super(RewardrulequeryVO.class);
	}

	public DataPackage doQuery(RewardrulequeryListVO params) throws Exception {
		return queryByNamedSqlQuery("boss.cms.reward.rewardrulequery.unionquery",params);
		
	}
}
