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

	static public final String GSUBS_STATE_STOP = "US532"; // ���Ų�Ʒͣ��
	
	static public final String GSUBS_STATE_DOCAN = "US528"; // ��������������

	static public final String GSUBS_STATE_PRECAN = "US531"; // ����ԤԼ����

	static public final String GSUBS_STATE_VALID = "US10,US22,US30,US531,US532"; // ��Ч�û�״̬(������ͨ�û��ͼ����û�)

	public GroupSubscriberDAO() {
		super(GroupSubscriberVO.class);
	}

}