package com.sunrise.boss.business.fee.billing.billstatus.persistent;

import com.sunrise.jop.common.spring.SpringContextManager;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

import com.sunrise.jop.infrastructure.db.SessionManager;


/**
 * 
 * @author ryan 2013-10-17
 *
 */

public class BillStatusDAO extends AbstractDAO {
	public BillStatusDAO() {
		super(BillStatusVO.class);
	}

}