/**
* auto-generated code
* Sat Feb 02 15:13:27 CST 2008
*/
package com.sunrise.boss.business.cms.reward.busyxplan.persistent;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BusyxplanDAO</p>
 * <p>Description: Data Access Object for BusyxplanVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BusyxplanDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public BusyxplanDAO(){
        super(BusyxplanVO.class);
    }
	public DataPackage queryBusyxplan(BusyxplanListVO params) throws Exception{
		params.getQueryConditions().put("opnid", params.get_se_opnid());
		params.getQueryConditions().put("yxplanid",params.get_ne_yxplanid() );
		params.getQueryConditions().put("yxplanname", params.get_se_yxplanname());
		params.getQueryConditions().put("opnname", params.get_se_opnname());

		return queryByNamedSqlQuery("boss.cms.queryBusyxplan", params, 0);
	}
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
