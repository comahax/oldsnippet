/**
* auto-generated code
* Thu Dec 22 09:33:15 CST 2011
*/
package com.sunrise.boss.business.cms.reward.stdrewardcq.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: StdrewardcqDAO</p>
 * <p>Description: Data Access Object for StdrewardcqVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class StdrewardcqDAO extends BaseDAO {

    /**
     * default constructor
     */
    public StdrewardcqDAO(){
        super(StdrewardcqVO.class);
    }
    public DataPackage query22(StdrewardcqListVO params1) throws Exception{
    	StringBuffer sql = new StringBuffer();
//		sql.append(" select SLV, INTVMONTH, rewardstd ")
		sql.append(" select a.* ")
		.append("   from CH_PW_STDREWARDCQ a, ch_pw_stdreward b ")
//		.append(" Where a.cityid = "+ cityid +" ")
		.append("  where a.REWARDID = b. REWARDID ")
		.append(" and b. REWARDTYPE = 60 ");		
		
		return  queryBySql(sql.toString(), params1);
    }
}
