/**
* auto-generated code
* Fri Feb 01 18:12:16 CST 2008
*/
package com.sunrise.boss.business.cms.stdrewardbs.persistent;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.SessionUtil;

/** 
 * <p>Title: StdrewardbsDAO</p>
 * <p>Description: Data Access Object for StdrewardbsVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author  
 * @version 1.0
 */
public class StdrewardbsDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public StdrewardbsDAO(){
        super(StdrewardbsVO.class);
    }
    public void deleteStar(String str) throws Exception {
    	Session session = SessionUtil.currentSession(getDbFlag());
    	Query countQuery = session.createQuery("delete from StdrewardbsVO where rewardid="+str);
    	countQuery.executeUpdate();
    }
    public int selectStar(String str,String region,String limit) throws Exception { 
    	Session session = SessionUtil.currentSession(getDbFlag());
    	SQLQuery countQuery = session.createSQLQuery("select region from CH_PW_STDREWARDBS where rewardid="+str+" and region="+region);
    	//SQLQuery countQuery = session.createSQLQuery("select typechname,typename from CH_PW_FDAUDITDEF group by typechname,typename");
    	
    	countQuery.addScalar("region", Hibernate.STRING);
    	//countQuery.addScalar("typename", Hibernate.STRING);
    	
    	List list = countQuery.list();
    	return list.size();
    }
}
