/**
* auto-generated code
* Sat Dec 03 10:12:28 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.service.persistent;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ServiceDAO</p>
 * <p>Description: Data Access Object for ServiceVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ServiceDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public ServiceDAO(){
        super(ServiceVO.class);
    }
    
    /*public void registerLog(String methodName, Object vo ,User user) throws Exception {				
		Class voClass = vo.getClass();
		if(vo instanceof OperationLog) {
			OperationLog operationLog = (OperationLog)vo;
			Class logVOClass = operationLog.logVOClass();
			Object logvo = logVOClass.newInstance();
			registerOperationLog(methodName, vo, logvo,user);
		}		
	}*/
}
