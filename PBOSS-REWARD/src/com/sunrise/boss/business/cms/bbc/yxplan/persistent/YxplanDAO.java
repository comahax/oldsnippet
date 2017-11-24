/**
 * auto-generated code
 * Tue May 05 11:03:52 CST 2009
 */
package com.sunrise.boss.business.cms.bbc.yxplan.persistent;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>
 * Title: yxplanDAO
 * </p>
 * <p>
 * Description: Data Access Object for yxplanVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class YxplanDAO extends BaseLogDAO {

	/**
	 * default constructor
	 */
	public YxplanDAO() {
		super(YxplanVO.class);
	}

	public DataPackage doQueryName(YxplanListVO listvo) throws Exception {
		listvo.getQueryConditions().put("opnid", listvo.get_se_opnid());
		listvo.getQueryConditions().put("yxplanid", listvo.get_ne_yxplanid());
		listvo.getQueryConditions().put("yxplanname",
				"%" + listvo.get_sk_yxplanname() + "%");
		listvo.getQueryConditions().put("opnname",
				"%" + listvo.get_sk_opnname() + "%");
		return queryByNamedSqlQuery("queryYxplanBBC", listvo);
	}
}
