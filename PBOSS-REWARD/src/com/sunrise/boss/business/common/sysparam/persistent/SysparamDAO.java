/**
* auto-generated code
* Fri Aug 11 16:47:18 CST 2006
*/
package com.sunrise.boss.business.common.sysparam.persistent;
import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: SysparamDAO</p>
 * <p>Description: Data Access Object for SysparamVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */
public class SysparamDAO extends BaseDAO {

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
	        session = SessionUtil.currentSession(this.getDbFlag());
	        Query query = session.createQuery(sql.toString());
	        Iterator iter = query.iterate();
	        if (iter != null && iter.hasNext()) {
	            return iter.next().toString();
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
    public SysparamVO doFindByunID(Long systemid, String paramtype) throws Exception {
	    StringBuffer sql = new StringBuffer(" FROM ").append(SysparamVO.class.getName())
	    .append(" where systemid=")
	    .append(systemid).append(" and paramtype ='").append(paramtype).append("'");
	
	    Session session = null;
	    try {
	        session = SessionUtil.currentSession(this.getDbFlag());
	        Query query = session.createQuery(sql.toString());
	        List list = query.list();
	        if (list!=null && list.size()!=0) {
	        	return (SysparamVO)list.get(0);
	        }else {
	        	return null;
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
	
    }
}
