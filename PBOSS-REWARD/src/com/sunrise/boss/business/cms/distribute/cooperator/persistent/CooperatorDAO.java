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
     * �������Ȩ�ޱ�Ĺ���
     * ture ��ʾ�й���
     * false ��ʾû�й���
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
    //������̿�����Ϣ��Ĺ���
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
    //���������Ʒ���۹����Ĺ���
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
     * �������Ӫ��������Ĺ���
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
