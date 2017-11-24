/**
 * auto-generated code
 * Wed Aug 10 10:50:17 CST 2011
 */
package com.gmcc.pboss.business.sales.canorderinfo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>Title: canorderinfoDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class CanorderinfoDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public CanorderinfoDAO(){
        super(CanorderinfoVO.class);
    }
    
    public List doStatPartnerres(CanorderinfoDBParam params) throws Exception{
    	Session session = SessionUtils.currentSession(getDbFlag());
    	Query query = session.getNamedQuery("com.gmcc.pboss.business.sales.canorderinfo.doStatPartnerres");
    	query.setString("wayid", params.getWayid());
    	query.setDate("begintime", params.getBegintime());
    	query.setDate("endtime", params.getEndtime());
		return query.list();
	}
    
    
}
