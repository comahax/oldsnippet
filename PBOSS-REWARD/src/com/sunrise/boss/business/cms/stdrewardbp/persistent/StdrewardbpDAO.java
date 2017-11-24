/**
* auto-generated code
* Fri Feb 01 18:09:59 CST 2008
*/
package com.sunrise.boss.business.cms.stdrewardbp.persistent;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: StdrewardbpDAO</p>
 * <p>Description: Data Access Object for StdrewardbpVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class StdrewardbpDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public StdrewardbpDAO(){
        super(StdrewardbpVO.class);
    }
    public void deleteBp(String str) throws Exception {
    	Session session = SessionUtil.currentSession(getDbFlag());
    	Query countQuery = session.createQuery("delete from StdrewardbpVO where rewardid="+str);
    	countQuery.executeUpdate();
    }
    public int selectBp(String str,String region) throws Exception {
    	Session session = SessionUtil.currentSession(getDbFlag());
    	SQLQuery countQuery = session.createSQLQuery("select region from CH_PW_STDREWARDBP where rewardid="+str+" and region="+region);
    	//SQLQuery countQuery = session.createSQLQuery("select typechname,typename from CH_PW_FDAUDITDEF group by typechname,typename");
    	
    	countQuery.addScalar("region", Hibernate.STRING);
    	//countQuery.addScalar("typename", Hibernate.STRING);
    	
    	List list = countQuery.list();
    	return list.size();
    }
}
