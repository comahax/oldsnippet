/**
 * auto-generated code
 * Mon Sep 07 10:50:13 CST 2009
 */
package com.gmcc.pboss.business.base.rolerightlog;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RolerightlogDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class RolerightlogDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public RolerightlogDAO(){
        super(RolerightlogVO.class);
    }
    
    public DataPackage queryWithRoleLimited(Object param) throws Exception {
    	// TODO Auto-generated method stub
    	return super.queryByNamedSqlQuery("system.rolerightlogLimitedQuery", param);
    }
}
