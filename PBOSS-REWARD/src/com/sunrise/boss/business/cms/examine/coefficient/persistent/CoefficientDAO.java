/**
* auto-generated code
* Sun Nov 29 14:15:38 CST 2009
*/
package com.sunrise.boss.business.cms.examine.coefficient.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: CoefficientDAO</p>
 * <p>Description: Data Access Object for CoefficientVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CoefficientDAO extends BaseDAO {

    /**
     * default constructor
     */
    public CoefficientDAO(){
        super(CoefficientVO.class);
    }
    
    public DataPackage query(CoefficientListVO params) throws Exception{
    	return this.queryByNamedSqlQuery("cofficientQuery", params);
    }
}
