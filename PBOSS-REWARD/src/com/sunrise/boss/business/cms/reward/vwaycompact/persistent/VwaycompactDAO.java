/**
* auto-generated code
* Sat Oct 16 20:51:14 CST 2010
*/
package com.sunrise.boss.business.cms.reward.vwaycompact.persistent;

import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.StdrewardutListVO;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: VwaycompactDAO</p>
 * <p>Description: Data Access Object for VwaycompactVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public class VwaycompactDAO extends BaseDAO {

    /**
     * default constructor
     */
    public VwaycompactDAO(){
        super(VwaycompactVO.class);
    }
    public DataPackage queryStdrewardutcity(StdrewardutListVO params) throws Exception{
    	return this.queryByNamedSqlQuery("queryStdrewardutcity", params); 
    }
}
