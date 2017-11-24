package com.sunrise.boss.business.resmanage.com.persistent;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;

public class ComDAO extends BaseDAO {

	public ComDAO() {
		super(ComVO.class);
	}

	public Long getComtype(Long comid) throws Exception {
		Session session = SessionUtil.currentSession(this.getDbFlag());
		try {
			String sql = "select VO.comtype from ComVO as VO where VO.comid = :comid";
			Query query = session.createQuery(sql);
			query.setParameter("comid", comid);
			Iterator iter = query.iterate();
			if (iter != null && iter.hasNext()) {
				return (Long) iter.next();
			} else {
				return null;
			}
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
	}
}
