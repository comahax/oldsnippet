/**
* auto-generated code
* Sat Nov 28 17:57:55 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnaudit.persistent;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.examine.exmnrslt.persistent.ExmnrsltListVO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExmnauditDAO</p>
 * <p>Description: Data Access Object for ExmnauditVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class VExmnauditDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public VExmnauditDAO(){
        super(VExmnauditVO.class);
    }
    /**
	 * 查找考核结果明细列表信息
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryExmnauditInfoList(ExmnauditListVO listVO)
			throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());

		SQLQuery query = (SQLQuery) session
				.getNamedQuery("queryExmnauditInfoList");
		String queryString = query.getQueryString();
		return queryBySql(queryString, listVO);
	}
   
}
