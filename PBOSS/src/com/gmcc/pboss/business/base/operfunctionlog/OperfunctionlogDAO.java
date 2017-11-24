/**
 * auto-generated code
 * Mon Sep 07 10:51:00 CST 2009
 */
package com.gmcc.pboss.business.base.operfunctionlog;

import com.gmcc.pboss.business.base.operfunction.OperfunctionDBParam;
import com.gmcc.pboss.business.base.operrolelog.OperrolelogDBParam;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OperfunctionlogDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OperfunctionlogDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public OperfunctionlogDAO(){
        super(OperfunctionlogVO.class);
    }
    
    public DataPackage query(Object param) throws Exception {
    	// TODO Auto-generated method stub
    	OperfunctionlogDBParam operfunctionlogDBParam = (OperfunctionlogDBParam)param;
    	operfunctionlogDBParam.getQueryConditions().put("region", CityMappingUtil.getCityNo(getDbFlag()));
    	return super.queryByNamedSqlQuery("system.operfunctionlogLimitedQuery", operfunctionlogDBParam);
    }
}
