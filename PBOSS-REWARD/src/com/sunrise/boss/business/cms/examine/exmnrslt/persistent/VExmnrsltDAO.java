/**
* auto-generated code
* Sun Nov 29 14:14:27 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnrslt.persistent;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: ExmnrsltDAO</p>
 * <p>Description: Data Access Object for ExmnrsltVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class VExmnrsltDAO extends BaseDAO {

    /**
     * default constructor
     */
    public VExmnrsltDAO(){
        super(VExmnrsltVO.class);
    }
	/**
	 * 查找考核结果明细列表信息
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryExmnrsltInfo(ExmnrsltListVO listVO)
			throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());

		SQLQuery query = (SQLQuery) session
				.getNamedQuery("getExmnrsltInfo");
		String queryString = query.getQueryString();
		listVO.getQueryConditions().put("exmnid", listVO.get_ne_exmnid());
		listVO.getQueryConditions().put("wayid", listVO.get_se_wayid());
		listVO.getQueryConditions().put("exmnperiod", listVO.get_se_exmnperiod());
		
		return queryBySql(queryString, listVO);
	}
}
