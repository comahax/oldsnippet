/**
 * auto-generated code
 * Mon Sep 07 10:54:49 CST 2009
 */
package com.gmcc.pboss.control.base.batchlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.batchlog.BatchlogDAO;
import com.gmcc.pboss.business.base.batchlog.BatchlogDBParam;
import com.gmcc.pboss.business.base.batchlog.BatchlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: BatchlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/batchlog/control/BatchlogBO"
*    name="Batchlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class BatchlogBO extends AbstractControlBean implements
		Batchlog {

	public BatchlogVO doCreate(BatchlogVO vo) throws Exception {
		try {
			BatchlogDAO dao = (BatchlogDAO) DAOFactory.build(BatchlogDAO.class, user);
			// TODO set the pk */
			return (BatchlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BatchlogVO vo) throws Exception {
		try {
			BatchlogDAO dao = (BatchlogDAO) DAOFactory.build(BatchlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BatchlogDAO dao = (BatchlogDAO) DAOFactory.build(BatchlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BatchlogVO doUpdate(BatchlogVO vo) throws Exception {
		try {
			BatchlogDAO dao = (BatchlogDAO) DAOFactory.build(BatchlogDAO.class,user);
			return (BatchlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BatchlogVO doFindByPk(Serializable pk) throws Exception {
		BatchlogDAO dao = (BatchlogDAO) DAOFactory.build(BatchlogDAO.class,user);
		return (BatchlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BatchlogDBParam params)
			throws Exception {
		BatchlogDAO dao = (BatchlogDAO) DAOFactory.build(BatchlogDAO.class,user);
		return dao.query(params);
	}
}
