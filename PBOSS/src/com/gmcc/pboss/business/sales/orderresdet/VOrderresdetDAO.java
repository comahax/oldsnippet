package com.gmcc.pboss.business.sales.orderresdet;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class VOrderresdetDAO extends AbstractDAO {
	 /**
     * default constructor
     */
    public VOrderresdetDAO(){
        super(VOrderresdetVO.class);
    }
    public DataPackage queryEmptysimdisres(VOrderresdetDBParam params) throws Exception{
	   	
    	return queryByNamedSqlQuery("queryEmptysimdisres", params);
    }
 
}
