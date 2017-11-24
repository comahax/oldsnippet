/**
 * auto-generated code
 * Wed Sep 02 14:03:49 CST 2009
 */
package com.gmcc.pboss.control.resource.emptysimlog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.emptysimlog.EmptysimlogDBParam;
import com.gmcc.pboss.business.resource.emptysimlog.EmptysimlogDAO;
import com.gmcc.pboss.business.resource.emptysimlog.EmptysimlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: EmptysimlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/emptysimlog/control/EmptysimlogBO"
*    name="Emptysimlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class EmptysimlogBO extends AbstractControlBean implements
		Emptysimlog {

	public EmptysimlogVO doCreate(EmptysimlogVO vo) throws Exception {
		try {
			EmptysimlogDAO dao = (EmptysimlogDAO) DAOFactory.build(EmptysimlogDAO.class, user);
			// TODO set the pk */
			return (EmptysimlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmptysimlogVO vo) throws Exception {
		try {
			EmptysimlogDAO dao = (EmptysimlogDAO) DAOFactory.build(EmptysimlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmptysimlogDAO dao = (EmptysimlogDAO) DAOFactory.build(EmptysimlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmptysimlogVO doUpdate(EmptysimlogVO vo) throws Exception {
		try {
			EmptysimlogDAO dao = (EmptysimlogDAO) DAOFactory.build(EmptysimlogDAO.class,user);
			return (EmptysimlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmptysimlogVO doFindByPk(Serializable pk) throws Exception {
		EmptysimlogDAO dao = (EmptysimlogDAO) DAOFactory.build(EmptysimlogDAO.class,user);
		return (EmptysimlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmptysimlogDBParam params)
			throws Exception {
		EmptysimlogDAO dao = (EmptysimlogDAO) DAOFactory.build(EmptysimlogDAO.class,user);
		return dao.query(params);
	}
}
