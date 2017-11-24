/**
 * auto-generated code
 * Mon Sep 14 16:43:37 CST 2009
 */
package com.gmcc.pboss.control.promotion.pquantity;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.pquantity.PquantityDBParam;
import com.gmcc.pboss.business.promotion.pquantity.PquantityDAO;
import com.gmcc.pboss.business.promotion.pquantity.PquantityVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PquantityBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/pquantity/control/PquantityBO"
*    name="Pquantity"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PquantityBO extends AbstractControlBean implements
		Pquantity {

	public PquantityVO doCreate(PquantityVO vo) throws Exception {
		try {
			PquantityDAO dao = (PquantityDAO) DAOFactory.build(PquantityDAO.class, user);
			// TODO set the pk */
			return (PquantityVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PquantityVO vo) throws Exception {
		try {
			PquantityDAO dao = (PquantityDAO) DAOFactory.build(PquantityDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PquantityDAO dao = (PquantityDAO) DAOFactory.build(PquantityDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PquantityVO doUpdate(PquantityVO vo) throws Exception {
		try {
			PquantityDAO dao = (PquantityDAO) DAOFactory.build(PquantityDAO.class,user);
			return (PquantityVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PquantityVO doFindByPk(Serializable pk) throws Exception {
		PquantityDAO dao = (PquantityDAO) DAOFactory.build(PquantityDAO.class,user);
		return (PquantityVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PquantityDBParam params)
			throws Exception {
		PquantityDAO dao = (PquantityDAO) DAOFactory.build(PquantityDAO.class,user);
		return dao.query(params);
	}
}
