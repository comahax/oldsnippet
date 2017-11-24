/**
 * auto-generated code
 * Mon Jul 04 16:25:21 CST 2011
 */
package com.gmcc.pboss.business.resource.phonestate;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PhonestateDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public class PhonestateDAO extends AbstractDAO { 
	/**
     * default constructor
     */
    public PhonestateDAO(){
        super(PhonestateVO.class);
    }
    

	public DataPackage QueryOrderidByComresid(DBQueryParam param) throws Exception {
		// TODO Auto-generated method stub
	   
		return queryByNamedSqlQuery("com.gmcc.pboss.business.resource.phonestate.QueryOrderidByComresid",param);
	  
	}
}
