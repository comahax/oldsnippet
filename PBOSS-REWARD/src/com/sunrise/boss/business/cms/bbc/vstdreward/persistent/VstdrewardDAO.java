/**
 * auto-generated code
 * Sun Sep 27 11:45:09 CST 2009
 */
package com.sunrise.boss.business.cms.bbc.vstdreward.persistent;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: vstdrewardDAO
 * </p>
 * <p>
 * Description: Data Access Object for vstdrewardVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class VstdrewardDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public VstdrewardDAO() {
		super(VstdrewardVO.class);
	}

	//
	public DataPackage queryRewardTables(VstdrewardListVO listvo, User user) throws Exception {
		if ("".equals(listvo.get_se_region())) {
			listvo.set_se_region(user.getCityid());
			listvo.getQueryConditions().put("REGION", listvo.get_se_region());
		} else if ("999".equals(listvo.get_se_region())) {
			return queryRewardTables2(listvo, user);
		} else if (user.getCityid().equals(listvo.get_se_region())) {
			listvo.getQueryConditions().put("REGION", user.getCityid());
			listvo.set_se_region("");
			return queryByNamedSqlQuery("queryRewardTables2", listvo);
		} else {
			listvo.getQueryConditions().put("REGION", user.getCityid());
		}
		listvo.set_se_region("");
		return queryByNamedSqlQuery("queryRewardTables", listvo);
	}
	
	//排序省公司排在前面,市公司排在后面
	public DataPackage queryRewardTablesDesc(VstdrewardListVO listvo, User user) throws Exception {
		if ("".equals(listvo.get_se_region())) {
			listvo.set_se_region(user.getCityid());
			listvo.getQueryConditions().put("REGION", listvo.get_se_region());
		} else if ("999".equals(listvo.get_se_region())) {
			return queryRewardTables2(listvo, user);
		} else if (user.getCityid().equals(listvo.get_se_region())) {
			listvo.getQueryConditions().put("REGION", user.getCityid());
			listvo.set_se_region("");
			return queryByNamedSqlQuery("queryRewardTables2", listvo);
		} else {
			listvo.getQueryConditions().put("REGION", user.getCityid());
		}
		listvo.set_se_region("");
		return queryByNamedSqlQuery("queryRewardTablesDesc", listvo);
	}

	public DataPackage queryRewardTables2(VstdrewardListVO listvo, User user) throws Exception {
		listvo.getQueryConditions().put("REGION", "999");
		listvo.set_se_region(""); 
		return queryByNamedSqlQuery("queryRewardTables2", listvo);
	}
	/**
	 * 
	 * @param listvo
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryRewardTables3(VstdrewardListVO listvo, User user) throws Exception {
		listvo.getQueryConditions().put("REGION",listvo.get_se_region());
		listvo.set_se_region("");
		return queryByNamedSqlQuery("queryRewardTables2", listvo);
	}
}
