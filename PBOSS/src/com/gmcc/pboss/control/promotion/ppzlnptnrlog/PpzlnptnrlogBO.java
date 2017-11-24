/**
 * auto-generated code
 * Thu Sep 17 15:15:04 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlnptnrlog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ppzlnptnrlog.PpzlnptnrlogDBParam;
import com.gmcc.pboss.business.promotion.ppzlnptnrlog.PpzlnptnrlogDAO;
import com.gmcc.pboss.business.promotion.ppzlnptnrlog.PpzlnptnrlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PpzlnptnrlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/ppzlnptnrlog/control/PpzlnptnrlogBO"
*    name="Ppzlnptnrlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PpzlnptnrlogBO extends AbstractControlBean implements
		Ppzlnptnrlog {

	public PpzlnptnrlogVO doCreate(PpzlnptnrlogVO vo) throws Exception {
		try {
			PpzlnptnrlogDAO dao = (PpzlnptnrlogDAO) DAOFactory.build(PpzlnptnrlogDAO.class, user);
			// TODO set the pk */
			return (PpzlnptnrlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PpzlnptnrlogVO vo) throws Exception {
		try {
			PpzlnptnrlogDAO dao = (PpzlnptnrlogDAO) DAOFactory.build(PpzlnptnrlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PpzlnptnrlogDAO dao = (PpzlnptnrlogDAO) DAOFactory.build(PpzlnptnrlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlnptnrlogVO doUpdate(PpzlnptnrlogVO vo) throws Exception {
		try {
			PpzlnptnrlogDAO dao = (PpzlnptnrlogDAO) DAOFactory.build(PpzlnptnrlogDAO.class,user);
			return (PpzlnptnrlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlnptnrlogVO doFindByPk(Serializable pk) throws Exception {
		PpzlnptnrlogDAO dao = (PpzlnptnrlogDAO) DAOFactory.build(PpzlnptnrlogDAO.class,user);
		return (PpzlnptnrlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PpzlnptnrlogDBParam params)
			throws Exception {
		PpzlnptnrlogDAO dao = (PpzlnptnrlogDAO) DAOFactory.build(PpzlnptnrlogDAO.class,user);
		return dao.query(params);
	}
}
