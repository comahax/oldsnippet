package com.sunrise.boss.business.fee.billing.uapstatistic.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.uapstatistic.persistent.UapStatisticDBParam;
import com.sunrise.boss.business.fee.billing.uapstatistic.persistent.UapStatisticDao;
import com.sunrise.boss.business.fee.billing.uapstatistic.persistent.UapStatisticVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class UapStatisticBO extends AbstractControlBean implements UapStatistic{

	public DataPackage doQuery(UapStatisticDBParam param)
			throws Exception {
		
		UapStatisticDao statisticDao = (UapStatisticDao)DAOFactory.build(UapStatisticDao.class, user);
		
		return statisticDao.query(param);
	}
	
}
