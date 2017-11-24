package com.sunrise.boss.business.fee.woff.acctset.persistent;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: AcctSetDAO</p>
 * <p>Description: Account Set DAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public class AcctSetDAO extends BaseDAO{
    /**
     * default constructor
     */
    public AcctSetDAO(){
        super(AcctSetVO.class);
    }
}
