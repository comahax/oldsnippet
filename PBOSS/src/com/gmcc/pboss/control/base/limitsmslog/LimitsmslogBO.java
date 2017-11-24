/**
 * auto-generated code
 * Tue Nov 08 10:06:39 CST 2011
 */
package com.gmcc.pboss.control.base.limitsmslog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.limitsmslog.LimitsmslogDBParam;
import com.gmcc.pboss.business.base.limitsmslog.LimitsmslogDAO;
import com.gmcc.pboss.business.base.limitsmslog.LimitsmslogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: LimitsmslogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class LimitsmslogBO extends AbstractControlBean implements
		Limitsmslog {

	public LimitsmslogVO doCreate(LimitsmslogVO vo) throws Exception {
		try {
			LimitsmslogDAO dao = (LimitsmslogDAO) DAOFactory.build(LimitsmslogDAO.class, user);
			// TODO set the pk */
			return (LimitsmslogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(LimitsmslogVO vo) throws Exception {
		try {
			LimitsmslogDAO dao = (LimitsmslogDAO) DAOFactory.build(LimitsmslogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			LimitsmslogDAO dao = (LimitsmslogDAO) DAOFactory.build(LimitsmslogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LimitsmslogVO doUpdate(LimitsmslogVO vo) throws Exception {
		try {
			LimitsmslogDAO dao = (LimitsmslogDAO) DAOFactory.build(LimitsmslogDAO.class,user);
			return (LimitsmslogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LimitsmslogVO doFindByPk(Serializable pk) throws Exception {
		LimitsmslogDAO dao = (LimitsmslogDAO) DAOFactory.build(LimitsmslogDAO.class,user);
		return (LimitsmslogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(LimitsmslogDBParam params)
			throws Exception {
		LimitsmslogDAO dao = (LimitsmslogDAO) DAOFactory.build(LimitsmslogDAO.class,user);
		return dao.query(params);
	}
}
