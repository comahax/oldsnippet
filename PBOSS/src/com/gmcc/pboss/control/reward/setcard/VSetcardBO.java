package com.gmcc.pboss.control.reward.setcard;

import com.gmcc.pboss.business.reward.setcard.VSetcardDAO;
import com.gmcc.pboss.business.reward.setcard.VSetcardDBParam;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: PaymentBO
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author a-biao
 * @version 1.0
 */
public class VSetcardBO extends AbstractControlBean implements VSetcard {

	public DataPackage doQueryBySql(VSetcardDBParam params) throws Exception {
		try {
			VSetcardDAO dao = (VSetcardDAO) DAOFactory.build(
					VSetcardDAO.class, user);
			DataPackage dp = dao
					.queryByNamedSqlQuery(
							"com.gmcc.pboss.business.reward.setcard.doShowNameSql",
							params);
			return dp;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

}
