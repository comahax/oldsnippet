/**
 * auto-generated code
 * Wed Jan 04 10:07:20 CST 2012
 */
package com.gmcc.pboss.business.channel.bondformlog;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: BondformlogDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class BondformlogDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public BondformlogDAO(){
        super(BondformlogVO.class);
    }
    
    public DataPackage bondformLogVoList(DBQueryParam param ) throws Exception {
		// TODO Auto-generated method stub
	   
		return queryByNamedSqlQuery("com.gmcc.pboss.business.channel.bondformlog.BondformLogVoList",param);
	  
	}
    public DataPackage bondformLogVoListForExcel(DBQueryParam param ) throws Exception {
		// TODO Auto-generated method stub
	   
		return queryByNamedSqlQuery("com.gmcc.pboss.business.channel.bondformlog.List",param);
	  
	}
}
