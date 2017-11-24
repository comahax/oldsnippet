/**
 * auto-generated code
 * Fri Oct 20 22:27:36 CST 2006
 */
package com.sunrise.boss.business.rightmanage.role.persistent;

import java.util.HashMap;

import com.sunrise.boss.business.cms.common.QueryUtil;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>
 * Title: RoleDAO
 * </p>
 * <p>
 * Description: Data Access Object for RoleVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class RoleDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public RoleDAO() {
		super(RoleVO.class);
	}

	public DataPackage query(RoleListVO params) throws Exception {
		
		QueryUtil queryUtil = new QueryUtil(getDbFlag());
		
		HashMap param = new HashMap(2);
		param.put("wayid",params.get_se_orgid());
		queryUtil.set_pageno(Integer.valueOf(params.get_pageno()).intValue());
		queryUtil.set_pagesize(Integer.valueOf(params.get_pagesize()).intValue());
		
		DataPackage dataPack = queryUtil.queryByName("getRolesByWay",param);

		return dataPack;

	}

	
}
