/**
 * auto-generated code
 * Fri Dec 30 09:40:47 CST 2011
 */
package com.gmcc.pboss.business.channel.invoice;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: InvoiceDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class InvoiceDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public InvoiceDAO(){
        super(InvoiceVO.class);
    }
    
	public DataPackage queryInvoiceList(DBQueryParam param ) throws Exception {
		// TODO Auto-generated method stub
	   
		return queryByNamedSqlQuery("com.gmcc.pboss.business.channel.invoice.QueryInvoiceList",param);
	  
	}
}
