/**
 * auto-generated code
 * Mon Sep 07 10:49:06 CST 2009
 */
package com.gmcc.pboss.business.base.rolefunctionlog;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RolefunctionlogDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class RolefunctionlogDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public RolefunctionlogDAO(){
        super(RolefunctionlogVO.class);
    }
    
    public DataPackage queryWithRoleLimited(Object param) throws Exception {
    	// TODO Auto-generated method stub
    	return super.queryByNamedSqlQuery("system.rolefunctionlogLimitedQuery", param);
    }
}
