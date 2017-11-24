/**
 * auto-generated code
 * Mon Sep 07 10:48:24 CST 2009
 */
package com.gmcc.pboss.control.base.functionitemlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.functionitemlog.FunctionitemlogDBParam;
import com.gmcc.pboss.business.base.functionitemlog.FunctionitemlogDAO;
import com.gmcc.pboss.business.base.functionitemlog.FunctionitemlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: FunctionitemlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/functionitemlog/control/FunctionitemlogBO"
*    name="Functionitemlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class FunctionitemlogBO extends AbstractControlBean implements
		Functionitemlog {

	public FunctionitemlogVO doCreate(FunctionitemlogVO vo) throws Exception {
		try {
			FunctionitemlogDAO dao = (FunctionitemlogDAO) DAOFactory.build(FunctionitemlogDAO.class, user);
			// TODO set the pk */
			return (FunctionitemlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(FunctionitemlogVO vo) throws Exception {
		try {
			FunctionitemlogDAO dao = (FunctionitemlogDAO) DAOFactory.build(FunctionitemlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			FunctionitemlogDAO dao = (FunctionitemlogDAO) DAOFactory.build(FunctionitemlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public FunctionitemlogVO doUpdate(FunctionitemlogVO vo) throws Exception {
		try {
			FunctionitemlogDAO dao = (FunctionitemlogDAO) DAOFactory.build(FunctionitemlogDAO.class,user);
			return (FunctionitemlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public FunctionitemlogVO doFindByPk(Serializable pk) throws Exception {
		FunctionitemlogDAO dao = (FunctionitemlogDAO) DAOFactory.build(FunctionitemlogDAO.class,user);
		return (FunctionitemlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(FunctionitemlogDBParam params)
			throws Exception {
		FunctionitemlogDAO dao = (FunctionitemlogDAO) DAOFactory.build(FunctionitemlogDAO.class,user);
		return dao.query(params);
	}
}
