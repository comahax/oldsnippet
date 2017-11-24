package com.sunrise.boss.business.zifee.fixfeedisc.persistent;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Hibernate;

import com.sunrise.boss.common.base.db.*;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: FixfeediscDAO</p>
 * <p>Description: Data Access Object for FixfeediscVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class PcPsFixfeediscDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public PcPsFixfeediscDAO(){
        super(PcPsFixfeediscVO.class);
    }
    
    public String dbFlag = getDbFlag();

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
    
    /**
     * 取得表中某一个字段的最大值，如表中无记录则返回null
     */
    public Object getMaxValue(String prop)
        throws Exception {
        if (prop != null && prop.trim().length() > 0) {
            StringBuffer sql = new StringBuffer("SELECT max(this.")
                .append(prop).append(") FROM ").append(PcPsFixfeediscVO.class.getName())
                .append(" this");

            Session session = null;
            try {
                session = SessionUtil.currentSession(getDbFlag());
                Query query = session.createQuery(sql.toString());
                Iterator iter = query.iterate();
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
