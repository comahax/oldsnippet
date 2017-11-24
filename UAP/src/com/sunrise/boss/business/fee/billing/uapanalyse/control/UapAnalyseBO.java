package com.sunrise.boss.business.fee.billing.uapanalyse.control;

import com.sunrise.boss.business.fee.billing.uapanalyse.persistent.UapAnalyseDBParam;
import com.sunrise.boss.business.fee.billing.uapanalyse.persistent.UapAnalyseDao;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class UapAnalyseBO extends AbstractControlBean implements UapAnalyse {

	
	public DataPackage doQuery(UapAnalyseDBParam param) throws Exception {
		
		UapAnalyseDao dao = (UapAnalyseDao)DAOFactory.build(UapAnalyseDao.class, user);
		
		return dao.query(param);
	}

}
