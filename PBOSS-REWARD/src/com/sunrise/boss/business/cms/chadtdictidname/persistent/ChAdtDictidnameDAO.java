/**
* auto-generated code
* Mon Dec 19 14:58:11 CST 2011
*/
package com.sunrise.boss.business.cms.chadtdictidname.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: ChAdtDictidnameDAO</p>
 * <p>Description: Data Access Object for ChAdtDictidnameVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtDictidnameDAO extends BaseDAO {

    /**
     * default constructor
     */
    public ChAdtDictidnameDAO(){
        super(ChAdtDictidnameVO.class);
    }
    
    public DataPackage query(Object params) throws Exception {    	
    	return queryByNamedSqlQuery("boss.business.cms.chadtdictidname", params);
    }
    
    public DataPackage querySelf(Object params) throws Exception {    	
    	return super.query(params);
    }
}
