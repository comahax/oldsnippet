/**
* auto-generated code
* Sun Aug 01 20:25:48 CST 2010
*/
package com.sunrise.boss.business.cms.reward.vbusyxplan.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: VbusyxplanDAO</p>
 * <p>Description: Data Access Object for VbusyxplanVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
public class VbusyxplanDAO extends BaseDAO {

    /**
     * default constructor
     */
    public VbusyxplanDAO(){
        super(VbusyxplanVO.class);
    }
    public DataPackage queryBusyxplan(VbusyxplanListVO listvo) throws Exception {
		return queryByNamedSqlQuery("boss.cms.queryBusyxplanOut", listvo);
	}
}
