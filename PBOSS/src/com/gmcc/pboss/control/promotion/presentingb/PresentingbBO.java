/**
 * auto-generated code
 * Mon Sep 14 17:07:50 CST 2009
 */
package com.gmcc.pboss.control.promotion.presentingb;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.presentingb.PresentingbDBParam;
import com.gmcc.pboss.business.promotion.presentingb.PresentingbDAO;
import com.gmcc.pboss.business.promotion.presentingb.PresentingbVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PresentingbBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/presentingb/control/PresentingbBO"
*    name="Presentingb"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PresentingbBO extends AbstractControlBean implements
		Presentingb {

	public PresentingbVO doCreate(PresentingbVO vo) throws Exception {
		try {
			PresentingbDAO dao = (PresentingbDAO) DAOFactory.build(PresentingbDAO.class, user);
			// TODO set the pk */
			return (PresentingbVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PresentingbVO vo) throws Exception {
		try {
			PresentingbDAO dao = (PresentingbDAO) DAOFactory.build(PresentingbDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PresentingbDAO dao = (PresentingbDAO) DAOFactory.build(PresentingbDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PresentingbVO doUpdate(PresentingbVO vo) throws Exception {
		try {
			PresentingbDAO dao = (PresentingbDAO) DAOFactory.build(PresentingbDAO.class,user);
			return (PresentingbVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PresentingbVO doFindByPk(Serializable pk) throws Exception {
		PresentingbDAO dao = (PresentingbDAO) DAOFactory.build(PresentingbDAO.class,user);
		return (PresentingbVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PresentingbDBParam params)
			throws Exception {
		PresentingbDAO dao = (PresentingbDAO) DAOFactory.build(PresentingbDAO.class,user);
		return dao.query(params);
	}
}
