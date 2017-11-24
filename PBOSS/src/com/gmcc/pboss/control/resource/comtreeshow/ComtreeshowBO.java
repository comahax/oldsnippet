/**
 * auto-generated code
 * Wed Sep 09 09:21:23 CST 2009
 */
package com.gmcc.pboss.control.resource.comtreeshow;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.comtreeshow.ComtreeshowDBParam;
import com.gmcc.pboss.business.resource.comtreeshow.ComtreeshowDAO;
import com.gmcc.pboss.business.resource.comtreeshow.ComtreeshowVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComtreeshowBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/comtreeshow/control/ComtreeshowBO"
*    name="Comtreeshow"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ComtreeshowBO extends AbstractControlBean implements
		Comtreeshow {

	public ComtreeshowVO doCreate(ComtreeshowVO vo) throws Exception {
		try {
			ComtreeshowDAO dao = (ComtreeshowDAO) DAOFactory.build(ComtreeshowDAO.class, user);
			// TODO set the pk */
			return (ComtreeshowVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComtreeshowVO vo) throws Exception {
		try {
			ComtreeshowDAO dao = (ComtreeshowDAO) DAOFactory.build(ComtreeshowDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComtreeshowDAO dao = (ComtreeshowDAO) DAOFactory.build(ComtreeshowDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComtreeshowVO doUpdate(ComtreeshowVO vo) throws Exception {
		try {
			ComtreeshowDAO dao = (ComtreeshowDAO) DAOFactory.build(ComtreeshowDAO.class,user);
			return (ComtreeshowVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComtreeshowVO doFindByPk(Serializable pk) throws Exception {
		ComtreeshowDAO dao = (ComtreeshowDAO) DAOFactory.build(ComtreeshowDAO.class,user);
		return (ComtreeshowVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComtreeshowDBParam params)
			throws Exception {
		ComtreeshowDAO dao = (ComtreeshowDAO) DAOFactory.build(ComtreeshowDAO.class,user);
		return dao.query(params);
	}
}
