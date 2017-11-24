/**
* auto-generated code
* Fri Feb 01 18:05:53 CST 2008
*/
package com.sunrise.boss.business.cms.stdreward.persistent;

import com.sunrise.boss.business.cms.reward.creditstd.persistent.CreditstdListVO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: StdrewardDAO</p>
 * <p>Description: Data Access Object for StdrewardVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class StdrewardDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public StdrewardDAO(){
        super(StdrewardVO.class);
    }
    
    public DataPackage queryfor5455(StdrewardListVO params1) throws Exception {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" Select * from CH_PW_STDREWARD where REWARDTYPE in('54','55') ");
		
		return  queryBySql(sql.toString(), params1);
	}
    
}
