/**
 * auto-generated code
 * Wed Sep 02 17:01:06 CST 2009
 */
package com.gmcc.pboss.business.base.sysparam;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>Title: SysparamDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class SysparamDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public SysparamDAO(){
        super(SysparamVO.class);
    }
    
    public String doFindByID(Long systemid, String paramtype) throws Exception {
	    StringBuffer sql = new StringBuffer("SELECT this.paramvalue FROM ").append(SysparamVO.class.getName())
	    .append(" this where this.systemid='")
	    .append(systemid).append("' and this.paramtype ='").append(paramtype).append("' and sysdate between this.begintime and this.endtime ");
	
	    Session session = null;
	    try {
	        session = SessionUtils.currentSession(getDbFlag());
	        Query query = session.createQuery(sql.toString());
	        Iterator iter = query.iterate();
	        if (iter != null && iter.hasNext()) {
	        	Object obj = iter.next();
	            return obj==null?null:obj.toString();
	        }
	    }
	    catch (HibernateException ex) {
	        if (ex.getCause() != null) {
	            throw new Exception(ex.getCause());
	        }
	        else {
	            throw ex;
	        }
	    }
	
	    return null;
    }
}
