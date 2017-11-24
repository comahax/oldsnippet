/**
 * 
 */
package com.sunrise.boss.business.fee.billing.validbillcyc.persistent;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>
 * Title: GDIBOSS
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Hanny Yeung
 * @version 1.0
 */
public class ValidBillCycDAO extends BaseDAO {
	public ValidBillCycDAO() {
		super(ValidBillCycVO.class);
	}
}
