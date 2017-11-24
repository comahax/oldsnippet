/**
 * auto-generated code
 * Thu Sep 17 15:16:39 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlncomlog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ppzlncomlog.PpzlncomlogDBParam;
import com.gmcc.pboss.business.promotion.ppzlncomlog.PpzlncomlogDAO;
import com.gmcc.pboss.business.promotion.ppzlncomlog.PpzlncomlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PpzlncomlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/ppzlncomlog/control/PpzlncomlogBO"
*    name="Ppzlncomlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PpzlncomlogBO extends AbstractControlBean implements
		Ppzlncomlog {

	public PpzlncomlogVO doCreate(PpzlncomlogVO vo) throws Exception {
		try {
			PpzlncomlogDAO dao = (PpzlncomlogDAO) DAOFactory.build(PpzlncomlogDAO.class, user);
			// TODO set the pk */
			return (PpzlncomlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PpzlncomlogVO vo) throws Exception {
		try {
			PpzlncomlogDAO dao = (PpzlncomlogDAO) DAOFactory.build(PpzlncomlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PpzlncomlogDAO dao = (PpzlncomlogDAO) DAOFactory.build(PpzlncomlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlncomlogVO doUpdate(PpzlncomlogVO vo) throws Exception {
		try {
			PpzlncomlogDAO dao = (PpzlncomlogDAO) DAOFactory.build(PpzlncomlogDAO.class,user);
			return (PpzlncomlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlncomlogVO doFindByPk(Serializable pk) throws Exception {
		PpzlncomlogDAO dao = (PpzlncomlogDAO) DAOFactory.build(PpzlncomlogDAO.class,user);
		return (PpzlncomlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PpzlncomlogDBParam params)
			throws Exception {
		PpzlncomlogDAO dao = (PpzlncomlogDAO) DAOFactory.build(PpzlncomlogDAO.class,user);
		return dao.query(params);
	}
}
