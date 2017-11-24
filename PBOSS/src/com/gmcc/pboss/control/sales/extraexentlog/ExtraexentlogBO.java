/**
 * auto-generated code
 * Sun Jun 19 20:24:03 CST 2011
 */
package com.gmcc.pboss.control.sales.extraexentlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.extraexentlog.ExtraexentlogDBParam;
import com.gmcc.pboss.business.sales.extraexentlog.ExtraexentlogDAO;
import com.gmcc.pboss.business.sales.extraexentlog.ExtraexentlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ExtraexentlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ExtraexentlogBO extends AbstractControlBean implements
		Extraexentlog {

	public ExtraexentlogVO doCreate(ExtraexentlogVO vo) throws Exception {
		try {
			ExtraexentlogDAO dao = (ExtraexentlogDAO) DAOFactory.build(ExtraexentlogDAO.class, user);
			// TODO set the pk */
			return (ExtraexentlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ExtraexentlogVO vo) throws Exception {
		try {
			ExtraexentlogDAO dao = (ExtraexentlogDAO) DAOFactory.build(ExtraexentlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ExtraexentlogDAO dao = (ExtraexentlogDAO) DAOFactory.build(ExtraexentlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ExtraexentlogVO doUpdate(ExtraexentlogVO vo) throws Exception {
		try {
			ExtraexentlogDAO dao = (ExtraexentlogDAO) DAOFactory.build(ExtraexentlogDAO.class,user);
			return (ExtraexentlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ExtraexentlogVO doFindByPk(Serializable pk) throws Exception {
		ExtraexentlogDAO dao = (ExtraexentlogDAO) DAOFactory.build(ExtraexentlogDAO.class,user);
		return (ExtraexentlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ExtraexentlogDBParam params)
			throws Exception {
		ExtraexentlogDAO dao = (ExtraexentlogDAO) DAOFactory.build(ExtraexentlogDAO.class,user);
		return dao.query(params);
	}
}
