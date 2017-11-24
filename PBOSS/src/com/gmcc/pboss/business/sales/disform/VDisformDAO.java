/**
 * auto-generated code
 * Wed Oct 14 17:29:02 CST 2009
 */
package com.gmcc.pboss.business.sales.disform;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: DisformDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class VDisformDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public VDisformDAO(){
        super(VDisformVO.class);
    }
    
    public DataPackage doDisformList(DisformDBParam params) throws Exception {
		return queryByNamedSqlQuery("queryDisformList", params);
	}
}
