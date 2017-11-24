/**
 * auto-generated code
 * Tue Aug 24 11:24:17 CST 2010
 */
package com.gmcc.pboss.business.sales.bankdeduct;

import com.gmcc.pboss.business.sales.bankrecord.BankrecordDBParam;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: BankdeductDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class BankdeductDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public BankdeductDAO(){
        super(BankdeductVO.class);
    }
    
    public DataPackage doDeduct(BankdeductDBParam params) throws Exception{
    	return queryByNamedSqlQuery("com.gmcc.pboss.business.sales.bankrecord.deductList", params);
	}
}
