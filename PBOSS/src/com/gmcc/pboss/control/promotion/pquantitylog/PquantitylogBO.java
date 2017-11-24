/**
 * auto-generated code
 * Mon Sep 14 16:45:04 CST 2009
 */
package com.gmcc.pboss.control.promotion.pquantitylog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.pquantitylog.PquantitylogDBParam;
import com.gmcc.pboss.business.promotion.pquantitylog.PquantitylogDAO;
import com.gmcc.pboss.business.promotion.pquantitylog.PquantitylogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PquantitylogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/pquantitylog/control/PquantitylogBO"
*    name="Pquantitylog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PquantitylogBO extends AbstractControlBean implements
		Pquantitylog {

	public PquantitylogVO doCreate(PquantitylogVO vo) throws Exception {
		try {
			PquantitylogDAO dao = (PquantitylogDAO) DAOFactory.build(PquantitylogDAO.class, user);
			// TODO set the pk */
			return (PquantitylogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PquantitylogVO vo) throws Exception {
		try {
			PquantitylogDAO dao = (PquantitylogDAO) DAOFactory.build(PquantitylogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PquantitylogDAO dao = (PquantitylogDAO) DAOFactory.build(PquantitylogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PquantitylogVO doUpdate(PquantitylogVO vo) throws Exception {
		try {
			PquantitylogDAO dao = (PquantitylogDAO) DAOFactory.build(PquantitylogDAO.class,user);
			return (PquantitylogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PquantitylogVO doFindByPk(Serializable pk) throws Exception {
		PquantitylogDAO dao = (PquantitylogDAO) DAOFactory.build(PquantitylogDAO.class,user);
		return (PquantitylogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PquantitylogDBParam params)
			throws Exception {
		PquantitylogDAO dao = (PquantitylogDAO) DAOFactory.build(PquantitylogDAO.class,user);
		return dao.query(params);
	}
}
