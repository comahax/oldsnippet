/**
 * auto-generated code
 * Mon Sep 14 16:46:42 CST 2009
 */
package com.gmcc.pboss.control.promotion.tieinsale;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.tieinsale.TieinsaleDBParam;
import com.gmcc.pboss.business.promotion.tieinsale.TieinsaleDAO;
import com.gmcc.pboss.business.promotion.tieinsale.TieinsaleVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: TieinsaleBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/tieinsale/control/TieinsaleBO"
*    name="Tieinsale"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class TieinsaleBO extends AbstractControlBean implements
		Tieinsale {

	public TieinsaleVO doCreate(TieinsaleVO vo) throws Exception {
		try {
			TieinsaleDAO dao = (TieinsaleDAO) DAOFactory.build(TieinsaleDAO.class, user);
			// TODO set the pk */
			return (TieinsaleVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(TieinsaleVO vo) throws Exception {
		try {
			TieinsaleDAO dao = (TieinsaleDAO) DAOFactory.build(TieinsaleDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			TieinsaleDAO dao = (TieinsaleDAO) DAOFactory.build(TieinsaleDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public TieinsaleVO doUpdate(TieinsaleVO vo) throws Exception {
		try {
			TieinsaleDAO dao = (TieinsaleDAO) DAOFactory.build(TieinsaleDAO.class,user);
			return (TieinsaleVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public TieinsaleVO doFindByPk(Serializable pk) throws Exception {
		TieinsaleDAO dao = (TieinsaleDAO) DAOFactory.build(TieinsaleDAO.class,user);
		return (TieinsaleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(TieinsaleDBParam params)
			throws Exception {
		TieinsaleDAO dao = (TieinsaleDAO) DAOFactory.build(TieinsaleDAO.class,user);
		return dao.query(params);
	}
}
