/**
* auto-generated code
* Fri Apr 18 17:19:00 CST 2008
*/
package com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: RbEboxChgLogDAO</p>
 * <p>Description: Data Access Object for RbEboxChgLogVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lmq
 * @version 1.0
 */
public class RbEboxChgLogDAO extends BaseDAO {

    public RbEboxChgLogDAO(){
        super(RbEboxChgLogVO.class);
    }
    
    
    public DataPackage queryRbEboxChgLog(String queryname,RbEboxChgLogListVO listVO) throws Exception {
    	return queryByNamedSqlQuery(queryname, listVO);
    }
    
    
}
