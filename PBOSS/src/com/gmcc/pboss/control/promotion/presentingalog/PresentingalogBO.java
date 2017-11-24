/**
 * auto-generated code
 * Mon Sep 14 17:09:44 CST 2009
 */
package com.gmcc.pboss.control.promotion.presentingalog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.presentingalog.PresentingalogDBParam;
import com.gmcc.pboss.business.promotion.presentingalog.PresentingalogDAO;
import com.gmcc.pboss.business.promotion.presentingalog.PresentingalogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PresentingalogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/presentingalog/control/PresentingalogBO"
*    name="Presentingalog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PresentingalogBO extends AbstractControlBean implements
		Presentingalog {

	public PresentingalogVO doCreate(PresentingalogVO vo) throws Exception {
		try {
			PresentingalogDAO dao = (PresentingalogDAO) DAOFactory.build(PresentingalogDAO.class, user);
			// TODO set the pk */
			return (PresentingalogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PresentingalogVO vo) throws Exception {
		try {
			PresentingalogDAO dao = (PresentingalogDAO) DAOFactory.build(PresentingalogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PresentingalogDAO dao = (PresentingalogDAO) DAOFactory.build(PresentingalogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PresentingalogVO doUpdate(PresentingalogVO vo) throws Exception {
		try {
			PresentingalogDAO dao = (PresentingalogDAO) DAOFactory.build(PresentingalogDAO.class,user);
			return (PresentingalogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PresentingalogVO doFindByPk(Serializable pk) throws Exception {
		PresentingalogDAO dao = (PresentingalogDAO) DAOFactory.build(PresentingalogDAO.class,user);
		return (PresentingalogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PresentingalogDBParam params)
			throws Exception {
		PresentingalogDAO dao = (PresentingalogDAO) DAOFactory.build(PresentingalogDAO.class,user);
		return dao.query(params);
	}
}
