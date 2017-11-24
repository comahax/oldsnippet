/**
 * auto-generated code
 * Tue Sep 29 10:26:16 CST 2009
 */
package com.gmcc.pboss.business.communication.advaffix;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>Title: AdvaffixDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AdvaffixDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public AdvaffixDAO(){
        super(AdvaffixVO.class);
    }
    /**
     * 根据advinfoid 批量删除附件
     * @param advinfoid
     */
    public void deleteAffixsByAdvinfoId(Long advinfoid) throws Exception{
    	Session session = SessionUtils.currentSession(getDbFlag());
    	Query query = session.getNamedQuery(
    			"com.gmcc.pboss.business.communication.advaffix.deleteAffixsByAdvinfoId");
    	query.setLong("advinfoid", advinfoid);
    	
    	try {
    		query.executeUpdate();			
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
    }
}
