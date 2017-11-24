/**
 * auto-generated code
 * Fri Jul 20 19:05:15 CST 2007
 */
package com.sunrise.boss.business.fee.qsmanage.fixfeesettle.persistent;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycDAO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>
 * Title: FixFeeSettleDAO
 * </p>
 * <p>
 * Description: Data Access Object for FixFeeSettleVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author lmq
 * @version 1.0
 */
public class FixFeeSettleBakDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public FixFeeSettleBakDAO() {
		super(FixFeeSettleBakVO.class);
	}

	public Object getMaxValidBillCyc() throws Exception {
		setVoClass(ValidBillCycVO.class);
		return getMaxid("state", "1", "validbillcyc");
	}

}
