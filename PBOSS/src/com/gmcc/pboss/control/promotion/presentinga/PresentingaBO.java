/**
 * auto-generated code
 * Mon Sep 14 17:09:30 CST 2009
 */
package com.gmcc.pboss.control.promotion.presentinga;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.presentinga.PresentingaDBParam;
import com.gmcc.pboss.business.promotion.presentinga.PresentingaDAO;
import com.gmcc.pboss.business.promotion.presentinga.PresentingaVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PresentingaBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/presentinga/control/PresentingaBO"
*    name="Presentinga"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PresentingaBO extends AbstractControlBean implements
		Presentinga {

	public PresentingaVO doCreate(PresentingaVO vo) throws Exception {
		try {
			PresentingaDAO dao = (PresentingaDAO) DAOFactory.build(PresentingaDAO.class, user);
			// TODO set the pk */
			return (PresentingaVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PresentingaVO vo) throws Exception {
		try {
			PresentingaDAO dao = (PresentingaDAO) DAOFactory.build(PresentingaDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PresentingaDAO dao = (PresentingaDAO) DAOFactory.build(PresentingaDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PresentingaVO doUpdate(PresentingaVO vo) throws Exception {
		try {
			PresentingaDAO dao = (PresentingaDAO) DAOFactory.build(PresentingaDAO.class,user);
			return (PresentingaVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PresentingaVO doFindByPk(Serializable pk) throws Exception {
		PresentingaDAO dao = (PresentingaDAO) DAOFactory.build(PresentingaDAO.class,user);
		return (PresentingaVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PresentingaDBParam params)
			throws Exception {
		PresentingaDAO dao = (PresentingaDAO) DAOFactory.build(PresentingaDAO.class,user);
		return dao.query(params);
	}
}
