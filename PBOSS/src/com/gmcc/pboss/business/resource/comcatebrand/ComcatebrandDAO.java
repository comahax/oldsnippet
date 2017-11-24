/**
 * auto-generated code
 * Sat Aug 13 11:12:29 CST 2011
 */
package com.gmcc.pboss.business.resource.comcatebrand;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComcatebrandDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class ComcatebrandDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ComcatebrandDAO(){
        super(ComcatebrandVO.class);
    }
    
    public DataPackage doQueryRes2Comcate(ComcatebrandDBParam params,String cityid) throws Exception{
    	/*Session session = SessionUtils.currentSession(ComcatebrandVO.class,getDbFlag());
    	Query query = session.getNamedQuery("com.gmcc.pboss.business.sales.canorderinfo.doQueryRes2Comcate");
    	query.setString("cityid", cityid);
		return query.list();*/
    	params.getQueryConditions().put("cityid", cityid);
    	return queryByNamedSqlQuery("com.gmcc.pboss.business.sales.canorderinfo.doQueryRes2Comcate", params);
	}
}
