/**
 * auto-generated code
 * Mon Jul 13 10:33:51 CST 2009
 */
package com.gmcc.pboss.business.base.operright;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OperrightDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Lee
 * @version 1.0
 */
public class OperrightDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public OperrightDAO(){
        super(OperrightVO.class);
    }
    
    @Override
    public DataPackage query(Object param) throws Exception {
    	// TODO Auto-generated method stub
    	OperrightDBParam operrightDBParam = (OperrightDBParam)param;
    	operrightDBParam.getQueryConditions().put("region", CityMappingUtil.getCityNo(getDbFlag()));
    	return super.queryByNamedSqlQuery("system.operrightLimitedQuery", operrightDBParam);
    }
}
