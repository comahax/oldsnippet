package com.sunrise.boss.business.zifee.yxplan.persistent;

import java.util.Iterator;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.SessionUtil;

public class YxPlanDAO extends BaseLogDAO {
	
	public String dbFlag = getDbFlag();
	public YxPlanDAO() {
		super(YxPlanVO.class);
	}
	
	public YxPlanDAO(Class voClass) {
		super(YxPlanVO.class);
		// TODO Auto-generated constructor stub
	}
    /**
     * 根据SEQUENCE名称取得seq的值
     */
    public Object getSequence(String seqname)
        throws Exception {
        if (seqname != null && seqname.trim().length() > 0) {
            StringBuffer sql = new StringBuffer("SELECT ")
                .append(seqname).append(".NEXTVAL seq FROM dual");

            Session session = null;
            try {
                session = SessionUtil.currentSession(getDbFlag());               
                SQLQuery query = session.createSQLQuery(sql.toString());
                query.addScalar("seq",Hibernate.LONG );
                Iterator iter = query.list().iterator();
                if (iter != null && iter.hasNext()) {
                    return iter.next();
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
        return null;
    }

}
