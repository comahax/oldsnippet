/**
 * auto-generated code
 * Mon Sep 07 10:54:49 CST 2009
 */
package com.gmcc.pboss.business.base.batchlog;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: BatchlogDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class BatchlogDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public BatchlogDAO(){
        super(BatchlogVO.class);
    }
    
    public DataPackage query(Object param) throws Exception {
    	// TODO Auto-generated method stub
    	BatchlogDBParam batchlogDBParam = (BatchlogDBParam)param;
    	batchlogDBParam.getQueryConditions().put("region", CityMappingUtil.getCityNo(getDbFlag()));
    	return super.queryByNamedSqlQuery("system.batchlogLimitedQuery", batchlogDBParam);
    }
}
