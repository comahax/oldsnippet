/**
 * auto-generated code
 * Mon Sep 07 10:51:00 CST 2009
 */
package com.gmcc.pboss.control.base.operfunctionlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.operfunctionlog.OperfunctionlogDBParam;
import com.gmcc.pboss.business.base.operfunctionlog.OperfunctionlogDAO;
import com.gmcc.pboss.business.base.operfunctionlog.OperfunctionlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OperfunctionlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/operfunctionlog/control/OperfunctionlogBO"
*    name="Operfunctionlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class OperfunctionlogBO extends AbstractControlBean implements
		Operfunctionlog {

	public OperfunctionlogVO doCreate(OperfunctionlogVO vo) throws Exception {
		try {
			OperfunctionlogDAO dao = (OperfunctionlogDAO) DAOFactory.build(OperfunctionlogDAO.class, user);
			// TODO set the pk */
			return (OperfunctionlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OperfunctionlogVO vo) throws Exception {
		try {
			OperfunctionlogDAO dao = (OperfunctionlogDAO) DAOFactory.build(OperfunctionlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OperfunctionlogDAO dao = (OperfunctionlogDAO) DAOFactory.build(OperfunctionlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperfunctionlogVO doUpdate(OperfunctionlogVO vo) throws Exception {
		try {
			OperfunctionlogDAO dao = (OperfunctionlogDAO) DAOFactory.build(OperfunctionlogDAO.class,user);
			return (OperfunctionlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperfunctionlogVO doFindByPk(Serializable pk) throws Exception {
		OperfunctionlogDAO dao = (OperfunctionlogDAO) DAOFactory.build(OperfunctionlogDAO.class,user);
		return (OperfunctionlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OperfunctionlogDBParam params)
			throws Exception {
		OperfunctionlogDAO dao = (OperfunctionlogDAO) DAOFactory.build(OperfunctionlogDAO.class,user);
		return dao.query(params);
	}
}
