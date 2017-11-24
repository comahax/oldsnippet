/**
 * auto-generated code
 * Sun Sep 13 11:38:11 CST 2009
 */
package com.gmcc.pboss.control.channel.operation;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.operation.OperationDBParam;
import com.gmcc.pboss.business.channel.operation.OperationDAO;
import com.gmcc.pboss.business.channel.operation.OperationVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OperationBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/operation/control/OperationBO"
*    name="Operation"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class OperationBO extends AbstractControlBean implements
		Operation {

	public OperationVO doCreate(OperationVO vo) throws Exception {
		try {
			OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class, user);
			// TODO set the pk */
			return (OperationVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OperationVO vo) throws Exception {
		try {
			OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperationVO doUpdate(OperationVO vo) throws Exception {
		try {
			OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,user);
			return (OperationVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperationVO doFindByPk(Serializable pk) throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,user);
		return (OperationVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OperationDBParam params)
			throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,user);
		return dao.query(params);
	}
}
