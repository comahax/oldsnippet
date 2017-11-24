/**
 * auto-generated code
 * Wed Sep 02 16:29:57 CST 2009
 */
package com.gmcc.pboss.control.resource.comressmplog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.comressmplog.ComressmplogDBParam;
import com.gmcc.pboss.business.resource.comressmplog.ComressmplogDAO;
import com.gmcc.pboss.business.resource.comressmplog.ComressmplogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComressmplogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/comressmplog/control/ComressmplogBO"
*    name="Comressmplog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ComressmplogBO extends AbstractControlBean implements
		Comressmplog {

	public ComressmplogVO doCreate(ComressmplogVO vo) throws Exception {
		try {
			ComressmplogDAO dao = (ComressmplogDAO) DAOFactory.build(ComressmplogDAO.class, user);
			// TODO set the pk */
			return (ComressmplogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComressmplogVO vo) throws Exception {
		try {
			ComressmplogDAO dao = (ComressmplogDAO) DAOFactory.build(ComressmplogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComressmplogDAO dao = (ComressmplogDAO) DAOFactory.build(ComressmplogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComressmplogVO doUpdate(ComressmplogVO vo) throws Exception {
		try {
			ComressmplogDAO dao = (ComressmplogDAO) DAOFactory.build(ComressmplogDAO.class,user);
			return (ComressmplogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComressmplogVO doFindByPk(Serializable pk) throws Exception {
		ComressmplogDAO dao = (ComressmplogDAO) DAOFactory.build(ComressmplogDAO.class,user);
		return (ComressmplogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComressmplogDBParam params)
			throws Exception {
		ComressmplogDAO dao = (ComressmplogDAO) DAOFactory.build(ComressmplogDAO.class,user);
		return dao.query(params);
	}
}
