/**
 * auto-generated code
 * Thu Sep 17 15:18:01 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlnreslog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ppzlnreslog.PpzlnreslogDBParam;
import com.gmcc.pboss.business.promotion.ppzlnreslog.PpzlnreslogDAO;
import com.gmcc.pboss.business.promotion.ppzlnreslog.PpzlnreslogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PpzlnreslogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/ppzlnreslog/control/PpzlnreslogBO"
*    name="Ppzlnreslog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PpzlnreslogBO extends AbstractControlBean implements
		Ppzlnreslog {

	public PpzlnreslogVO doCreate(PpzlnreslogVO vo) throws Exception {
		try {
			PpzlnreslogDAO dao = (PpzlnreslogDAO) DAOFactory.build(PpzlnreslogDAO.class, user);
			// TODO set the pk */
			return (PpzlnreslogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PpzlnreslogVO vo) throws Exception {
		try {
			PpzlnreslogDAO dao = (PpzlnreslogDAO) DAOFactory.build(PpzlnreslogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PpzlnreslogDAO dao = (PpzlnreslogDAO) DAOFactory.build(PpzlnreslogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlnreslogVO doUpdate(PpzlnreslogVO vo) throws Exception {
		try {
			PpzlnreslogDAO dao = (PpzlnreslogDAO) DAOFactory.build(PpzlnreslogDAO.class,user);
			return (PpzlnreslogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlnreslogVO doFindByPk(Serializable pk) throws Exception {
		PpzlnreslogDAO dao = (PpzlnreslogDAO) DAOFactory.build(PpzlnreslogDAO.class,user);
		return (PpzlnreslogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PpzlnreslogDBParam params)
			throws Exception {
		PpzlnreslogDAO dao = (PpzlnreslogDAO) DAOFactory.build(PpzlnreslogDAO.class,user);
		return dao.query(params);
	}
}
