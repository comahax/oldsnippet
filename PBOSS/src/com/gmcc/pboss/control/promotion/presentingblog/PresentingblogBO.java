/**
 * auto-generated code
 * Mon Sep 14 17:08:10 CST 2009
 */
package com.gmcc.pboss.control.promotion.presentingblog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.presentingblog.PresentingblogDBParam;
import com.gmcc.pboss.business.promotion.presentingblog.PresentingblogDAO;
import com.gmcc.pboss.business.promotion.presentingblog.PresentingblogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PresentingblogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/presentingblog/control/PresentingblogBO"
*    name="Presentingblog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PresentingblogBO extends AbstractControlBean implements
		Presentingblog {

	public PresentingblogVO doCreate(PresentingblogVO vo) throws Exception {
		try {
			PresentingblogDAO dao = (PresentingblogDAO) DAOFactory.build(PresentingblogDAO.class, user);
			// TODO set the pk */
			return (PresentingblogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PresentingblogVO vo) throws Exception {
		try {
			PresentingblogDAO dao = (PresentingblogDAO) DAOFactory.build(PresentingblogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PresentingblogDAO dao = (PresentingblogDAO) DAOFactory.build(PresentingblogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PresentingblogVO doUpdate(PresentingblogVO vo) throws Exception {
		try {
			PresentingblogDAO dao = (PresentingblogDAO) DAOFactory.build(PresentingblogDAO.class,user);
			return (PresentingblogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PresentingblogVO doFindByPk(Serializable pk) throws Exception {
		PresentingblogDAO dao = (PresentingblogDAO) DAOFactory.build(PresentingblogDAO.class,user);
		return (PresentingblogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PresentingblogDBParam params)
			throws Exception {
		PresentingblogDAO dao = (PresentingblogDAO) DAOFactory.build(PresentingblogDAO.class,user);
		return dao.query(params);
	}
}
