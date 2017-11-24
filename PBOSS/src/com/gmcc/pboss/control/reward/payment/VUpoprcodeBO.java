package com.gmcc.pboss.control.reward.payment;

import com.gmcc.pboss.business.reward.payment.VUpoprcodeDAO;
import com.gmcc.pboss.business.reward.payment.VUpoprcodeDBParam;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class VUpoprcodeBO extends AbstractControlBean implements VUpoprcode {
	public DataPackage doQuery(VUpoprcodeDBParam params) throws Exception {
		try {
			VUpoprcodeDAO dao = (VUpoprcodeDAO) DAOFactory.build(
					VUpoprcodeDAO.class, user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQueryBySql(VUpoprcodeDBParam params) throws Exception {
		try {
			VUpoprcodeDAO dao = (VUpoprcodeDAO) DAOFactory.build(
					VUpoprcodeDAO.class, user);
			params.setSelectFieldsString("optype,ltype,stype");
			DataPackage dp = dao
					.queryByNamedSqlQuery(
							"com.gmcc.pboss.business.reward.ltype.doQueryBySql",
							params);
			return dp;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
}
