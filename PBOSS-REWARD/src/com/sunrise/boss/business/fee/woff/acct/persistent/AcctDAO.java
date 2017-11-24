package com.sunrise.boss.business.fee.woff.acct.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;

/**
 * <p>Title: BillItemMagDAO</p>
 * <p>Description: Bill item management DAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public class AcctDAO extends BaseDAO{
	
    /**
     * default constructor
     */
    public AcctDAO(){
        super(AcctVO.class);
        super.setDbFlag("DB_COMMON", false);
       // super.setDbFlag("DB_BOSSCOMMON", false);
    }
    
}
