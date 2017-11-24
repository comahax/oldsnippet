/**
* auto-generated code
* Fri Aug 25 11:28:40 CST 2006
*/
package com.sunrise.boss.business.cms.bchcontact.persistent;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: BchcontactDAO</p>
 * <p>Description: Data Access Object for BchcontactVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class BchcontactDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public BchcontactDAO(){
        super(BchcontactVO.class);
    }
    
	/**
	 * 只查询属于社会渠道的记录 yjr
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryByOprcodeAndType(BchcontactListVO params, String baseWayid)
			throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		
		SQLQuery query = (SQLQuery) session
				.getNamedQuery("boss.cms.queryBchcontactByAGWay");
		String queryString = query.getQueryString();
		params.getQueryConditions().put("basewayid",baseWayid);
		params.getQueryConditions().put("subtype",params.getSubtype());
		return queryBySql(queryString, params, 0);
	}
}
