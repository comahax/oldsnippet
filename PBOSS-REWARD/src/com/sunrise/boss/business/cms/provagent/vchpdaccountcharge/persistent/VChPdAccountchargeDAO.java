/**
* auto-generated code
* Wed Sep 04 20:56:32 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: VChPdAccountchargeDAO</p>
 * <p>Description: Data Access Object for VChPdAccountchargeVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class VChPdAccountchargeDAO extends BaseDAO {

    /**
     * default constructor
     */
    public VChPdAccountchargeDAO(){
        super(VChPdAccountchargeVO.class);
    }
    
    public DataPackage query(VChPdAccountchargeListVO params) throws Exception {
		return queryByNamedSqlQuery("cms.provagent.VChPdAccountchargeQuery", params);
	}
}
