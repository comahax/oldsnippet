package com.sunrise.boss.business.admin.code2name.persistent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;

public class Code2NameDAO {

	public Code2NameDAO(String dbFlag){
		this.dbFlag = dbFlag;
	}
	
    private String dbFlag;


	public Object translateCode(String voName, String codeName,
			String nameName, Object codeValue) throws Exception {
		dbFlag = SessionFactoryRouter.checkIsCommonDB(voName, dbFlag);
		Session session = SessionUtil.currentSession(dbFlag);
		try {
			// ≤È—Ø”Ôæ‰£∫ select VO.name from voName as VO where VO.code=:code
			StringBuffer hql = new StringBuffer("select VO.").append(nameName)
					.append(" from ").append(voName).append(" as VO where VO.")
					.append(codeName).append(" = :code");
			Query query = session.createQuery(hql.toString());
			query.setParameter("code", codeValue);

			Iterator iter = query.iterate();
			if (iter != null && iter.hasNext()) {
				return iter.next();
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
	
	public Map valueList(String voName, String codeName,
			String nameName ) throws Exception {
		dbFlag = SessionFactoryRouter.checkIsCommonDB(voName, dbFlag);
		Session session = SessionUtil.currentSession(dbFlag);
		try {
			// ≤È—Ø”Ôæ‰£∫ select VO.name,VO.code from voName as VO 
			StringBuffer hql = new StringBuffer("select VO.").append(nameName)
					.append(",VO.").append(codeName).append(" from ").append(voName).append(" as VO ");
			Query query = session.createQuery(hql.toString());			
			Map maplist = new HashMap();
			Iterator iter = query.iterate();
			while (iter != null && iter.hasNext()) {
				Object[] value = (Object[])iter.next();
				if( value[1] != null && value[0] != null ){
					maplist.put(value[1].toString(),value[0].toString());
				}
			}
			return maplist;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
	}
}