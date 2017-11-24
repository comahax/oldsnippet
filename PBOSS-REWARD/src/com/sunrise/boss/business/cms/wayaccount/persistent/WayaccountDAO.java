/**
* auto-generated code
* Sat Aug 26 10:44:13 CST 2006
*/
package com.sunrise.boss.business.cms.wayaccount.persistent;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.*;

/**
 * <p>Title: WayaccountDAO</p>
 * <p>Description: Data Access Object for WayaccountVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayaccountDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public WayaccountDAO(){
        super(WayaccountVO.class);
    }
    
	/**
	 * 只查询属于社会渠道的记录 yjr
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryByOprcodeAndType(WayaccountListVO params, String baseWayid)
			throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		
		SQLQuery query = (SQLQuery) session
				.getNamedQuery("boss.cms.queryAccountByAGWay");
		String queryString = query.getQueryString();
		params.getQueryConditions().put("basewayid",baseWayid);
		params.getQueryConditions().put("subtype",params.getSubtype());
		return queryBySql(queryString, params, 0);
	}
}
