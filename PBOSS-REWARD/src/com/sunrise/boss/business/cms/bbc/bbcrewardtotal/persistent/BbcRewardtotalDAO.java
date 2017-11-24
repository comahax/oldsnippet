/**
* auto-generated code
* Mon Dec 08 10:50:04 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.bbcrewardtotal.persistent;

import com.sunrise.boss.business.cms.bbc.bbcrewardtotal.persistent.BbcRewardtotalListVO;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: WayintegraltransruleDAO</p>
 * <p>Description: Data Access Object for WayintegraltransruleVO</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
public class BbcRewardtotalDAO extends BaseDAO {

    /**
     * default constructor
     */
    public BbcRewardtotalDAO(){
        super(BbcRewardtotalVO.class);
    }
    
    public DataPackage query(BbcRewardtotalListVO params) throws Exception{
    	return queryByNamedSqlQuery("bbcRewardtotalQuery", params);
    }
}
