/**
 * auto-generated code
 * Mon Sep 07 11:18:53 CST 2009
 */
package com.gmcc.pboss.business.base.operrolelog;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OperrolelogDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OperrolelogDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public OperrolelogDAO(){
        super(OperrolelogVO.class);
    }
    
    public DataPackage queryWithRoleLimited(Object param) throws Exception {
    	// TODO Auto-generated method stub
    	OperrolelogDBParam operrolelogDBParam = (OperrolelogDBParam)param;
    	operrolelogDBParam.getQueryConditions().put("region", CityMappingUtil.getCityNo(getDbFlag()));
    	return super.queryByNamedSqlQuery("system.log.roleLimitedQuery", operrolelogDBParam);
    }
    
    public DataPackage queryWithoutRoleLimited(Object param) throws Exception {
    	// TODO Auto-generated method stub
    	OperrolelogDBParam operrolelogDBParam = (OperrolelogDBParam)param;
    	operrolelogDBParam.getQueryConditions().put("region", CityMappingUtil.getCityNo(getDbFlag()));
    	return super.queryByNamedSqlQuery("system.log.withoutRoleLimitedQuery", operrolelogDBParam);
    }
}
