/**
 * auto-generated code
 * Mon Sep 07 10:52:58 CST 2009
 */
package com.gmcc.pboss.control.base.dictitemlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.dictitemlog.DictitemlogDBParam;
import com.gmcc.pboss.business.base.dictitemlog.DictitemlogDAO;
import com.gmcc.pboss.business.base.dictitemlog.DictitemlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: DictitemlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/dictitemlog/control/DictitemlogBO"
*    name="Dictitemlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class DictitemlogBO extends AbstractControlBean implements
		Dictitemlog {

	public DictitemlogVO doCreate(DictitemlogVO vo) throws Exception {
		try {
			DictitemlogDAO dao = (DictitemlogDAO) DAOFactory.build(DictitemlogDAO.class, user);
			// TODO set the pk */
			return (DictitemlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DictitemlogVO vo) throws Exception {
		try {
			DictitemlogDAO dao = (DictitemlogDAO) DAOFactory.build(DictitemlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DictitemlogDAO dao = (DictitemlogDAO) DAOFactory.build(DictitemlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DictitemlogVO doUpdate(DictitemlogVO vo) throws Exception {
		try {
			DictitemlogDAO dao = (DictitemlogDAO) DAOFactory.build(DictitemlogDAO.class,user);
			return (DictitemlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DictitemlogVO doFindByPk(Serializable pk) throws Exception {
		DictitemlogDAO dao = (DictitemlogDAO) DAOFactory.build(DictitemlogDAO.class,user);
		return (DictitemlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(DictitemlogDBParam params)
			throws Exception {
		DictitemlogDAO dao = (DictitemlogDAO) DAOFactory.build(DictitemlogDAO.class,user);
		return dao.query(params);
	}
}
