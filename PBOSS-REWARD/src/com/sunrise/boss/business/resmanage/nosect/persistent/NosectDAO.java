package com.sunrise.boss.business.resmanage.nosect.persistent;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

public class NosectDAO extends BaseDAO {

	public NosectDAO() {
		super(NosectVO.class);
	}

	public NosectVO getNosectByMobileno(String mobileno) throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		NosectVO vo = null;
		String hql = "from NosectVO where beginno <=:mobileno and endno >=:mobileno";
		try {
			Query query = session.createQuery(hql);
			query.setParameter("mobileno", mobileno);
			Iterator it = query.iterate();
			if (it.hasNext()) {
				vo = (NosectVO) it.next();
			}
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return vo;
	}

	public int checkNosectDuplicate(String beginno, String endno, String cityid)
			throws Exception {
		BaseListVO listVO = new BaseListVO();
		listVO.getQueryConditions().put("beginno", beginno);
		listVO.getQueryConditions().put("endno", endno);
		listVO.getQueryConditions().put("cityid", cityid);
		try {
			Integer val = (Integer) queryUniqueByNamedSqlQuery(
					"res.nosect.nosectDuplicateCheck", listVO);
			return val.intValue();
		} catch (NonUniqueResultException ex) {
			throw ex;
		}
	}

	public List QryAvlNosect(String begno, String endno, String cityid)
			throws Exception {
		BaseListVO listVO = new BaseListVO();
		listVO.set_pagesize("0");
		listVO.getQueryConditions().put("begno", begno);
		listVO.getQueryConditions().put("endno", endno);
		listVO.getQueryConditions().put("cityid", cityid);
		listVO.getQueryConditions().put("length",
				String.valueOf(begno.length()));

		DataPackage dp = queryByNamedSqlQuery("res.nosect.qryAvlNosect", listVO);

		return (List) dp.getDatas();
	}
}
