/**
 * auto-generated code
 * Thu Sep 17 15:13:36 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlnrulelog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ppzlnrulelog.PpzlnrulelogDBParam;
import com.gmcc.pboss.business.promotion.ppzlnrulelog.PpzlnrulelogDAO;
import com.gmcc.pboss.business.promotion.ppzlnrulelog.PpzlnrulelogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PpzlnrulelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/ppzlnrulelog/control/PpzlnrulelogBO"
*    name="Ppzlnrulelog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PpzlnrulelogBO extends AbstractControlBean implements
		Ppzlnrulelog {

	public PpzlnrulelogVO doCreate(PpzlnrulelogVO vo) throws Exception {
		try {
			PpzlnrulelogDAO dao = (PpzlnrulelogDAO) DAOFactory.build(PpzlnrulelogDAO.class, user);
			// TODO set the pk */
			return (PpzlnrulelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PpzlnrulelogVO vo) throws Exception {
		try {
			PpzlnrulelogDAO dao = (PpzlnrulelogDAO) DAOFactory.build(PpzlnrulelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PpzlnrulelogDAO dao = (PpzlnrulelogDAO) DAOFactory.build(PpzlnrulelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlnrulelogVO doUpdate(PpzlnrulelogVO vo) throws Exception {
		try {
			PpzlnrulelogDAO dao = (PpzlnrulelogDAO) DAOFactory.build(PpzlnrulelogDAO.class,user);
			return (PpzlnrulelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlnrulelogVO doFindByPk(Serializable pk) throws Exception {
		PpzlnrulelogDAO dao = (PpzlnrulelogDAO) DAOFactory.build(PpzlnrulelogDAO.class,user);
		return (PpzlnrulelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PpzlnrulelogDBParam params)
			throws Exception {
		PpzlnrulelogDAO dao = (PpzlnrulelogDAO) DAOFactory.build(PpzlnrulelogDAO.class,user);
		return dao.query(params);
	}
}
