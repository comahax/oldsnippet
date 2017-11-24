/**
* auto-generated code
* Wed Aug 29 19:13:31 CST 2012
*/
package com.sunrise.boss.business.cms.vchpwoperation.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: VChPwOperationDAO</p>
 * <p>Description: Data Access Object for VChPwOperationVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class VChPwOperationDAO extends BaseDAO {

    /**
     * default constructor
     */
    public VChPwOperationDAO(){
        super(VChPwOperationVO.class);
    }
    
    public DataPackage doQueryBusibelong(VChPwOperationListVO vchpwoperationvo) throws Exception {
    	DataPackage dp = this.queryByNamedSqlQuery("cms.operation.querybusibelong",vchpwoperationvo); 
		return dp; 
	}
    
}
