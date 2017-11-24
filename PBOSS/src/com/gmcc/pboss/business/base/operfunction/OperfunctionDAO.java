/**
 * auto-generated code
 * Tue Sep 08 16:02:06 CST 2009
 */
package com.gmcc.pboss.business.base.operfunction;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OperfunctionDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OperfunctionDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public OperfunctionDAO(){
        super(OperfunctionVO.class);
    }
    
    @Override
    public DataPackage query(Object param) throws Exception {
    	// TODO Auto-generated method stub
    	OperfunctionDBParam operfunctionDBParam = (OperfunctionDBParam)param;
    	operfunctionDBParam.getQueryConditions().put("region", CityMappingUtil.getCityNo(getDbFlag()));
    	return super.queryByNamedSqlQuery("system.operfunctionLimitedQuery", operfunctionDBParam);
    }
}
