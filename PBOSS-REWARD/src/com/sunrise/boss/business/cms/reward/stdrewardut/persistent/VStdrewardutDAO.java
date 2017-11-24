/**
* auto-generated code
* Fri Oct 08 14:53:45 CST 2010
*/
package com.sunrise.boss.business.cms.reward.stdrewardut.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: StdrewardutDAO</p>
 * <p>Description: Data Access Object for StdrewardutVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class VStdrewardutDAO extends BaseDAO {

    /**
     * default constructor
     */
    public VStdrewardutDAO(){
        super(VStdrewardutVO.class);
    }
    
    public DataPackage queryStdrewardut(StdrewardutListVO params) throws Exception{
    	return this.queryByNamedSqlQuery("queryStdrewardut", params);
    }
}
