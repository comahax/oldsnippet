package com.sunrise.boss.business.fee.billing.billlogdeta.persistent;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * Data access object (DAO) for domain model
 * 
 * @author MyEclipse - Hibernate Tools
 */
public class VBillLogDetaDAO extends AbstractDAO {
	public VBillLogDetaDAO() {
		super(VBillLogDetaVO.class);
	}
	
	public DataPackage queryBillLogDeta(BillLogDetaDBParam param) throws Exception{
		return queryByNamedSqlQuery("query.billLogDeta",param);
	}

}