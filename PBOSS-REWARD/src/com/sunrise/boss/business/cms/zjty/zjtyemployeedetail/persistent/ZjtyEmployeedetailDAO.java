/**
* auto-generated code
* Fri Feb 13 09:03:29 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: ZjtyEmployeedetailDAO</p>
 * <p>Description: Data Access Object for ZjtyEmployeedetailVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyEmployeedetailDAO extends BaseDAO {

    /**
     * default constructor
     */
    public ZjtyEmployeedetailDAO(){
        super(ZjtyEmployeedetailVO.class);
    }
    
    public DataPackage query(ZjtyEmployeedetailListVO params) throws Exception{
    	return this.queryByNamedSqlQuery("zjtyemployeedetailQuery", params);
    }
}
