/**
 * auto-generated code
 * Wed Aug 16 09:58:20 CST 2006
 */
package com.sunrise.boss.business.fee.groupquery.groupsubscriber.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;

/**
 * <p>
 * Title: GroupSubscriberDAO
 * </p>
 * <p>
 * Description: Data Access Object for GroupSubscriberVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author mys
 * @version 1.0
 */
public class GroupSubscriberDAO extends BaseDAO {

	static public final String GSUBS_STATE_STOP = "US532"; // 集团产品停用
	
	static public final String GSUBS_STATE_DOCAN = "US528"; // 销户订单处理中

	static public final String GSUBS_STATE_PRECAN = "US531"; // 集团预约销户

	static public final String GSUBS_STATE_VALID = "US10,US22,US30,US531,US532"; // 有效用户状态(包括普通用户和集团用户)

	public GroupSubscriberDAO() {
		super(GroupSubscriberVO.class);
	}

}