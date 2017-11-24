/**
 * auto-generated code
 * Tue Sep 08 09:43:07 CST 2009
 */
package com.gmcc.pboss.control.base.operatorlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.operatorlog.OperatorlogDBParam;
import com.gmcc.pboss.business.base.operatorlog.OperatorlogDAO;
import com.gmcc.pboss.business.base.operatorlog.OperatorlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OperatorlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/operatorlog/control/OperatorlogBO"
*    name="Operatorlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class OperatorlogBO extends AbstractControlBean implements
		Operatorlog {

	public OperatorlogVO doCreate(OperatorlogVO vo) throws Exception {
		try {
			OperatorlogDAO dao = (OperatorlogDAO) DAOFactory.build(OperatorlogDAO.class, user);
			// TODO set the pk */
			return (OperatorlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OperatorlogVO vo) throws Exception {
		try {
			OperatorlogDAO dao = (OperatorlogDAO) DAOFactory.build(OperatorlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OperatorlogDAO dao = (OperatorlogDAO) DAOFactory.build(OperatorlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperatorlogVO doUpdate(OperatorlogVO vo) throws Exception {
		try {
			OperatorlogDAO dao = (OperatorlogDAO) DAOFactory.build(OperatorlogDAO.class,user);
			return (OperatorlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperatorlogVO doFindByPk(Serializable pk) throws Exception {
		OperatorlogDAO dao = (OperatorlogDAO) DAOFactory.build(OperatorlogDAO.class,user);
		return (OperatorlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OperatorlogDBParam params)
			throws Exception {
		OperatorlogDAO dao = (OperatorlogDAO) DAOFactory.build(OperatorlogDAO.class,user);
		return dao.query(params);
	}
}
