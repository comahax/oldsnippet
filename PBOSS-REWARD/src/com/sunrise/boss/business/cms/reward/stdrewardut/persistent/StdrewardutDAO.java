/**
* auto-generated code
* Fri Oct 08 14:53:45 CST 2010
*/
package com.sunrise.boss.business.cms.reward.stdrewardut.persistent;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: StdrewardutDAO</p>
 * <p>Description: Data Access Object for StdrewardutVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class StdrewardutDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public StdrewardutDAO(){
        super(StdrewardutVO.class);
    }
    /**
     * 手工记录日志.
     * @param methodName
     * @param vo
     * @param user
     * @throws Exception
     */
    public void registerLog(String methodName, Object vo ,User user) throws Exception {				
		Class voClass = vo.getClass();

		if(vo instanceof OperationLog) {
			OperationLog operationLog = (OperationLog)vo;
			Class logVOClass = operationLog.logVOClass();
			Object logvo = logVOClass.newInstance();
			registerOperationLog(methodName, vo, logvo,user);
		}		
	}
}
