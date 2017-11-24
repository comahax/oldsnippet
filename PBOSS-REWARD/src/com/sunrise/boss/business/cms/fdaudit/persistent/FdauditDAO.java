/**
 * auto-generated code
 * Thu Jul 26 16:12:39 CST 2007
 */
package com.sunrise.boss.business.cms.fdaudit.persistent;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.AbstractComponentType;
import org.hibernate.type.Type;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: FdauditDAO
 * </p>
 * <p>
 * Description: Data Access Object for FdauditVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author yuanweihai
 * @version 1.0
 */
public class FdauditDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public FdauditDAO() {
		super(FdauditVO.class);
	}

	public boolean fieldBackfill(String sql) throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		Connection con = session.connection();
		Statement stat = con.createStatement();
		boolean flag = stat.execute(sql);
		stat.close();
		return flag;

	}

	public Object doGetorgVO(Object vo, User user) throws Exception {
		Session session=SessionUtil.currentSession(getDbFlag());
		SessionFactory sessionFactory = session.getSessionFactory();
		session.evict(vo);
		ClassMetadata metadata = sessionFactory.getClassMetadata(vo.getClass());
		Type atype = metadata.getIdentifierType();
		BaseDAO baseDAO = new BaseDAO(vo.getClass(), user.getCityid());
		if (!(atype instanceof AbstractComponentType)) {
			String pk = metadata.getIdentifierPropertyName();
			return baseDAO.findByUniqueKey(pk, BeanUtils.getProperty(vo, pk));
		} else {
			AbstractComponentType type = (AbstractComponentType) atype;
			Serializable serializable = (Serializable) vo.getClass()
					.newInstance();
			String[] pks = type.getPropertyNames();
			for (int i = 0; i < pks.length; i++) {
				BeanUtils.copyProperty(serializable,pks[i],BeanUtils.getProperty(vo, pks[i]));
			}
			return baseDAO.findByPk(serializable);
		}

	}

}
