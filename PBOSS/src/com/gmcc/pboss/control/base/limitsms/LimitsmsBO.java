/**
 * auto-generated code
 * Tue Nov 08 09:56:31 CST 2011
 */
package com.gmcc.pboss.control.base.limitsms;

import java.io.Serializable;

import com.gmcc.pboss.business.base.limitsms.LimitsmsDBParam;
import com.gmcc.pboss.business.base.limitsms.LimitsmsDAO;
import com.gmcc.pboss.business.base.limitsms.LimitsmsVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: LimitsmsBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class LimitsmsBO extends AbstractControlBean implements
		Limitsms {

	public LimitsmsVO doCreate(LimitsmsVO vo) throws Exception {
		try {
			LimitsmsDAO dao = (LimitsmsDAO) DAOFactory.build(LimitsmsDAO.class, user);
			// TODO set the pk */
			return (LimitsmsVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(LimitsmsVO vo) throws Exception {
		try {
			LimitsmsDAO dao = (LimitsmsDAO) DAOFactory.build(LimitsmsDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			LimitsmsDAO dao = (LimitsmsDAO) DAOFactory.build(LimitsmsDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LimitsmsVO doUpdate(LimitsmsVO vo) throws Exception {
		try {
			LimitsmsDAO dao = (LimitsmsDAO) DAOFactory.build(LimitsmsDAO.class,user);
			return (LimitsmsVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LimitsmsVO doFindByPk(Serializable pk) throws Exception {
		LimitsmsDAO dao = (LimitsmsDAO) DAOFactory.build(LimitsmsDAO.class,user);
		return (LimitsmsVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(LimitsmsDBParam params)
			throws Exception {
		LimitsmsDAO dao = (LimitsmsDAO) DAOFactory.build(LimitsmsDAO.class,user);
		return dao.query(params);
	}
}
