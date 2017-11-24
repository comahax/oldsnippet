/**
* auto-generated code
* Mon Sep 04 20:34:08 CST 2006
*/
package com.sunrise.boss.business.zifee.eboxdisc.persistent;

import java.util.Iterator;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: EboxdiscDAO</p>
 * <p>Description: Data Access Object for EboxdiscVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public class EboxdiscDAO extends BaseLogDAO {

  
	public String dbFlag = getDbFlag();
    public EboxdiscDAO(){
        super(EboxdiscVO.class);
    }
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
