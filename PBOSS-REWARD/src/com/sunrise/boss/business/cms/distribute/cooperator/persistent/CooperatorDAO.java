/**
* auto-generated code
* Tue Dec 26 19:35:31 CST 2006
*/
package com.sunrise.boss.business.cms.distribute.cooperator.persistent;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: CooperatorDAO</p>
 * <p>Description: Data Access Object for CooperatorVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CooperatorDAO extends BaseLogDAO {
	public String dbFlag = getDbFlag();

    /**
     * default constructor
     */
    public CooperatorDAO(){
        super(CooperatorVO.class);
    }


    /**
     * 与合作商权限表的关联
     * ture 表示有关联
     * false 表示没有关联
     */
    /*public boolean doFindRelInCpright(Serializable coopID)
    	throws Exception{
    	String fk=(String)coopID;
        if (coopID != null) {
            StringBuffer sql = new StringBuffer("from ")
                .append("CprightVO cpr ")
                .append("where ")
            	.append("cpr.cooperauid='"+fk+"'");

            Session session = null;
            try {
                session = SessionUtil.currentSession(getDbFlag());               
                Query query = session.createQuery(sql.toString());
                //query.addScalar("seq",Hibernate.LONG );
                List list = query.list();
                return !list.isEmpty();
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
        return false;
    }
    //与合作商考核信息表的关联
    public boolean doFindRelInCpexam(Serializable coopID)
    throws Exception{
    	String fk=(String)coopID;
        if (coopID != null) {
            StringBuffer sql = new StringBuffer("from ")
                .append("CpexamVO cpe ")
                .append("where ")
            	.append("cpe.cooperauid='"+fk+"'");

            Session session = null;
            try {
                session = SessionUtil.currentSession(getDbFlag());               
                Query query = session.createQuery(sql.toString());
                //query.addScalar("seq",Hibernate.LONG );
                List list = query.list();
                return !list.isEmpty();
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
        return false;
    	
    }
    //与合作商商品销售规则表的关联
    public boolean doFindRelInCpcomsalerl(Serializable coopID)
    throws Exception{
    	String fk=(String)coopID;
        if (coopID != null) {
            StringBuffer sql = new StringBuffer("from ")
                .append("CpcomsalerlVO cpc ")
                .append("where ")
            	.append("cpc.cooperauid='"+fk+"'");

            Session session = null;
            try {
                session = SessionUtil.currentSession(getDbFlag());               
                Query query = session.createQuery(sql.toString());
                //query.addScalar("seq",Hibernate.LONG );
                List list = query.list();
                return !list.isEmpty();
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
        return false;
    	
    }
    */
    /*
     * 与合作商营收渠道表的关联
     * @param coopID
     * @param user
     * @return
     * @throws Exception
     */
  /*  public boolean doFindRelInCpbusfeeway(Serializable coopID)
	throws Exception{
    	String fk=(String)coopID;
        if (coopID != null) {
            StringBuffer sql = new StringBuffer("from ")
                .append("CpbusfeewayVO cpb ")
                .append("where ")
            	.append("cpb.cooperauid='"+fk+"'");

            Session session = null;
            try {
                session = SessionUtil.currentSession(getDbFlag());               
                Query query = session.createQuery(sql.toString());
                //query.addScalar("seq",Hibernate.LONG );
                List list = query.list();
                return !list.isEmpty();
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
        return false;
    }
    */
}
