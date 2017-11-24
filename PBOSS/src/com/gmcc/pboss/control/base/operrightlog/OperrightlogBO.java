/**
 * auto-generated code
 * Mon Sep 07 10:51:49 CST 2009
 */
package com.gmcc.pboss.control.base.operrightlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.operrightlog.OperrightlogDBParam;
import com.gmcc.pboss.business.base.operrightlog.OperrightlogDAO;
import com.gmcc.pboss.business.base.operrightlog.OperrightlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OperrightlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/operrightlog/control/OperrightlogBO"
*    name="Operrightlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class OperrightlogBO extends AbstractControlBean implements
		Operrightlog {

	public OperrightlogVO doCreate(OperrightlogVO vo) throws Exception {
		try {
			OperrightlogDAO dao = (OperrightlogDAO) DAOFactory.build(OperrightlogDAO.class, user);
			// TODO set the pk */
			return (OperrightlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OperrightlogVO vo) throws Exception {
		try {
			OperrightlogDAO dao = (OperrightlogDAO) DAOFactory.build(OperrightlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OperrightlogDAO dao = (OperrightlogDAO) DAOFactory.build(OperrightlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperrightlogVO doUpdate(OperrightlogVO vo) throws Exception {
		try {
			OperrightlogDAO dao = (OperrightlogDAO) DAOFactory.build(OperrightlogDAO.class,user);
			return (OperrightlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperrightlogVO doFindByPk(Serializable pk) throws Exception {
		OperrightlogDAO dao = (OperrightlogDAO) DAOFactory.build(OperrightlogDAO.class,user);
		return (OperrightlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OperrightlogDBParam params)
			throws Exception {
		OperrightlogDAO dao = (OperrightlogDAO) DAOFactory.build(OperrightlogDAO.class,user);
		return dao.query(params);
	}
}
