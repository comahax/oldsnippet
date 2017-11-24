/**
 * auto-generated code
 * Wed Jul 28 15:30:49 CST 2010
 */
package com.gmcc.pboss.business.sales.audit;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: AuditDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AuditDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public AuditDAO(){
        super(AuditVO.class);
    }
    
    public DataPackage getAuditInfo(AuditDBParam param)throws Exception {
    	return queryByNamedSqlQuery(
		"com.gmcc.pboss.business.sales.audit.Audit.getAuditInfo",
		param);
    } 
}
