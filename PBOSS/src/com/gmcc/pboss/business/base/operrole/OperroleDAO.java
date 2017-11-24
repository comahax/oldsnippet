/**
 * auto-generated code
 * Fri Jul 10 14:35:20 CST 2009
 */
package com.gmcc.pboss.business.base.operrole;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: OperroleDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Lee
 * @version 1.0
 */
public class OperroleDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public OperroleDAO(){
        super(OperroleVO.class);
    }
    
    public DataPackage queryWithRoleLimited(Object param,User user) throws Exception {
    	// TODO Auto-generated method stub
    	OperroleDBParam operroleDBParam = (OperroleDBParam)param;
    	operroleDBParam.getQueryConditions().put("region", CityMappingUtil.getCityNo(getDbFlag()));
    	operroleDBParam.getQueryConditions().put("loginwayid", user.getWayid());
    	operroleDBParam.getQueryConditions().put("logincityid", user.getCityid());
    	return super.queryByNamedSqlQuery("system.roleLimitedQuery", operroleDBParam);
    }
    
    public DataPackage queryWithoutRoleLimited(Object param,User user) throws Exception {
    	// TODO Auto-generated method stub
    	OperroleDBParam operroleDBParam = (OperroleDBParam)param;
    	operroleDBParam.getQueryConditions().put("region", CityMappingUtil.getCityNo(getDbFlag()));
    	operroleDBParam.getQueryConditions().put("loginwayid", user.getWayid());
    	operroleDBParam.getQueryConditions().put("logincityid", user.getCityid());
    	return super.queryByNamedSqlQuery("system.withoutRoleLimitedQuery", operroleDBParam);
    }
}
