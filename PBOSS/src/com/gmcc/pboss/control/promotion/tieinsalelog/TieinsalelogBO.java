/**
 * auto-generated code
 * Mon Sep 14 17:03:36 CST 2009
 */
package com.gmcc.pboss.control.promotion.tieinsalelog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.tieinsalelog.TieinsalelogDBParam;
import com.gmcc.pboss.business.promotion.tieinsalelog.TieinsalelogDAO;
import com.gmcc.pboss.business.promotion.tieinsalelog.TieinsalelogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: TieinsalelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/tieinsalelog/control/TieinsalelogBO"
*    name="Tieinsalelog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class TieinsalelogBO extends AbstractControlBean implements
		Tieinsalelog {

	public TieinsalelogVO doCreate(TieinsalelogVO vo) throws Exception {
		try {
			TieinsalelogDAO dao = (TieinsalelogDAO) DAOFactory.build(TieinsalelogDAO.class, user);
			// TODO set the pk */
			return (TieinsalelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(TieinsalelogVO vo) throws Exception {
		try {
			TieinsalelogDAO dao = (TieinsalelogDAO) DAOFactory.build(TieinsalelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			TieinsalelogDAO dao = (TieinsalelogDAO) DAOFactory.build(TieinsalelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public TieinsalelogVO doUpdate(TieinsalelogVO vo) throws Exception {
		try {
			TieinsalelogDAO dao = (TieinsalelogDAO) DAOFactory.build(TieinsalelogDAO.class,user);
			return (TieinsalelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public TieinsalelogVO doFindByPk(Serializable pk) throws Exception {
		TieinsalelogDAO dao = (TieinsalelogDAO) DAOFactory.build(TieinsalelogDAO.class,user);
		return (TieinsalelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(TieinsalelogDBParam params)
			throws Exception {
		TieinsalelogDAO dao = (TieinsalelogDAO) DAOFactory.build(TieinsalelogDAO.class,user);
		return dao.query(params);
	}
}
