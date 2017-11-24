/**
* auto-generated code
* Mon Apr 30 16:49:59 CST 2007
*/
package com.sunrise.boss.business.admin.logincase.persistent;

import com.sunrise.boss.common.base.db.*;

/**
 * <p>Title: LogincaseDAO</p>
 * <p>Description: Data Access Object for LogincaseVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class LogincaseDAO extends BaseDAO {

    /**
     * default constructor
     */
    public LogincaseDAO(){
        super(LogincaseVO.class);
    }
    
    public DataPackage query(Object params) throws Exception {    	
    	return queryByNamedSqlQuery("boss.admin.queryLogincase", params);
    }
}
