package com.gmcc.pboss.control.sales.emptysimdisres;

import com.gmcc.pboss.business.sales.orderresdet.VOrderresdetDAO;
import com.gmcc.pboss.business.sales.orderresdet.VOrderresdetDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class EmptysimdisresBO extends AbstractControlBean implements
		Emptysimdisres {

	public DataPackage doQueryEmptysimdisres(VOrderresdetDBParam params) throws Exception {
		VOrderresdetDAO dao = (VOrderresdetDAO) DAOFactory.build(
				VOrderresdetDAO.class, user);
		return dao.queryEmptysimdisres(params);
	}

}
