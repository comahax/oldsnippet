/**
* auto-generated code
* Wed Sep 04 21:22:46 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdrewardadc.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: ChPdRewardadcDAO</p>
 * <p>Description: Data Access Object for ChPdRewardadcVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRewardadcDAO extends BaseDAO {

    /**
     * default constructor
     */
    public ChPdRewardadcDAO(){
        super(ChPdRewardadcVO.class);
    }
    
    public DataPackage query(Object params) throws Exception {    	
    	return queryByNamedSqlQuery("boss.business.cms.provagent.rewardadc", params);
    }
}
