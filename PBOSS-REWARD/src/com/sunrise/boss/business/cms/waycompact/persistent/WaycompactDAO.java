/**
* auto-generated code
* Fri Aug 25 11:29:29 CST 2006
*/
package com.sunrise.boss.business.cms.waycompact.persistent;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactListVO;
import com.sunrise.boss.common.base.db.*;

/**
 * <p>Title: WaycompactDAO</p>
 * <p>Description: Data Access Object for WaycompactVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class WaycompactDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public WaycompactDAO(){
        super(WaycompactVO.class);
    }
    
	/**
	 * 只查询属于社会渠道的记录 yjr
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryByOprcodeAndType(WaycompactListVO params, String baseWayid)
			throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		
		SQLQuery query = (SQLQuery) session
				.getNamedQuery("boss.cms.queryCompactByAGWay");
		String queryString = query.getQueryString();
		params.getQueryConditions().put("basewayid",baseWayid);
		params.getQueryConditions().put("subtype",params.getSubtype());
		return queryBySql(queryString, params, 0);
	}
}
