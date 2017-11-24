package com.sunrise.boss.business.resmanage.resparams.control;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Date;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.common.pubdef.ResConstant;
import com.sunrise.boss.business.resmanage.resparams.persistent.ResparamsVO;
import com.sunrise.boss.business.resmanage.resparams.persistent.ResparamsDAO;
import com.sunrise.boss.business.resmanage.resparams.persistent.ResparamsListVO;
import com.sunrise.pub.tools.PublicUtils;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/resmanage/resparams/control/ResparamsControlBean"
 *           name="ResparamsControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class ResparamsControlBean extends AbstractControlBean implements
		ResparamsControl {

	public ResparamsVO doCreate(ResparamsVO vo, User user) throws Exception {
		try {
			ResparamsDAO dao = (ResparamsDAO) DAOFactory.build(
					ResparamsDAO.class, user.getCityid());
			return (ResparamsVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(ResparamsVO vo, User user) throws Exception {
		try {
			ResparamsDAO dao = (ResparamsDAO) DAOFactory.build(
					ResparamsDAO.class, user.getCityid());
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public ResparamsVO doUpdate(ResparamsVO vo, User user) throws Exception {
		try {
			ResparamsDAO dao = (ResparamsDAO) DAOFactory.build(
					ResparamsDAO.class, user.getCityid());
			return (ResparamsVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public ResparamsVO doFindByPk(Serializable pk, User user) throws Exception {
		ResparamsDAO dao = (ResparamsDAO) DAOFactory.build(ResparamsDAO.class,
				user.getCityid());
		return (ResparamsVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResparamsListVO params, User user)
			throws Exception {
		ResparamsDAO dao = (ResparamsDAO) DAOFactory.build(ResparamsDAO.class,
				user.getCityid());
		return dao.query(params);
	}

	private String getBuf(Object obj) throws Exception {
		Method[] m = obj.getClass().getDeclaredMethods();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < m.length; i++) {
			if (m[i].getName().startsWith("get")) {
				if (m[i].getReturnType() == Date.class) {
					Date date = (Date) m[i].invoke(obj, null);
					if (date != null)
						buf.append(PublicUtils.utilDateToStr(date)).append("~");
					else
						buf.append("").append("~");
				} else {
					Object o = m[i].invoke(obj, null);
					if (o != null)
						buf.append(o.toString()).append("~");
					else
						buf.append("").append("~");
				}
			}
		}
		return buf.toString();
	}

	private String getBufstr(Object obj) throws Exception {
		Method[] m = obj.getClass().getDeclaredMethods();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < m.length; i++) {
			if (m[i].getName().startsWith("get")) {
				buf.append(m[i].getName().substring(3)).append("~");
			}
		}
		return buf.toString();
	}

	public void doLog4create(String tablename, Object obj, User user)
			throws Exception {
		try {
			ResparamsVO vo = new ResparamsVO();
			ResparamsDAO dao = (ResparamsDAO) DAOFactory.build(
					ResparamsDAO.class, user);
			vo.setLogdate(new Date(System.currentTimeMillis()));
			vo.setNewbuf(getBuf(obj));
			vo.setBufstr(getBufstr(obj));
			vo.setOprcode(user.getOpercode());
			vo.setOprtype(ResConstant.RESOPRTYPE_PUTINDB);
			vo.setTablename(tablename.toUpperCase());
			dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doLog4delete(String tablename, Object obj, User user)
			throws Exception {
		try {
			ResparamsVO vo = new ResparamsVO();
			ResparamsDAO dao = (ResparamsDAO) DAOFactory.build(
					ResparamsDAO.class, user);
			vo.setLogdate(new Date(System.currentTimeMillis()));
			vo.setOldbuf(getBuf(obj));
			vo.setBufstr(getBufstr(obj));
			vo.setOprcode(user.getOpercode());
			vo.setOprtype(ResConstant.RESOPRTYPE_DEL);
			vo.setTablename(tablename.toUpperCase());
			dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doLog4update(String tablename, Object newobj, Object oldobj,
			User user) throws Exception {
		try {
			ResparamsVO vo = new ResparamsVO();
			ResparamsDAO dao = (ResparamsDAO) DAOFactory.build(
					ResparamsDAO.class, user);
			vo.setLogdate(new Date(System.currentTimeMillis()));
			vo.setNewbuf(getBuf(newobj));
			vo.setOldbuf(getBuf(oldobj));
			vo.setBufstr(getBufstr(newobj));
			vo.setOprcode(user.getOpercode());
			vo.setOprtype(ResConstant.RESOPRTYPE_PROPERTYCHANGE);
			vo.setTablename(tablename.toUpperCase());
			dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
}
