/**
 * auto-generated code
 * Tue Jan 17 09:52:22 CST 2012
 */
package com.gmcc.pboss.business.sales.bankrecord;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: BankrecordDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class BankrecordDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public BankrecordDAO(){
        super(BankrecordVO.class);
    }
    
    public DataPackage doQueryBankRecordDetail(BankrecordDBParam params) throws Exception{
    	return queryByNamedSqlQuery("com.gmcc.pboss.business.sales.bankrecord.detailList", params);
	}
    
    public DataPackage doDetail(BankrecordDBParam params) throws Exception{
    	return queryByNamedSqlQuery("com.gmcc.pboss.business.sales.bankrecord.detail", params);
	}
}
