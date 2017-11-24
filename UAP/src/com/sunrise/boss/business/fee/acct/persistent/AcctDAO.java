package com.sunrise.boss.business.fee.acct.persistent;

import com.sunrise.jop.infrastructure.db.AbstractDAO;


/**
 * <p>Title: BillItemMagDAO</p>
 * <p>Description: Bill item management DAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public class AcctDAO extends AbstractDAO{
	
    /**
     * default constructor
     */
    public AcctDAO(){
        super(AcctVO.class);
    }
}
