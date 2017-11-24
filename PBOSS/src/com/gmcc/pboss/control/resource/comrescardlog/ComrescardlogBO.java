/**
 * auto-generated code
 * Wed Sep 02 16:33:10 CST 2009
 */
package com.gmcc.pboss.control.resource.comrescardlog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.comrescardlog.ComrescardlogDBParam;
import com.gmcc.pboss.business.resource.comrescardlog.ComrescardlogDAO;
import com.gmcc.pboss.business.resource.comrescardlog.ComrescardlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComrescardlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/comrescardlog/control/ComrescardlogBO"
*    name="Comrescardlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ComrescardlogBO extends AbstractControlBean implements
		Comrescardlog {

	public ComrescardlogVO doCreate(ComrescardlogVO vo) throws Exception {
		try {
			ComrescardlogDAO dao = (ComrescardlogDAO) DAOFactory.build(ComrescardlogDAO.class, user);
			// TODO set the pk */
			return (ComrescardlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComrescardlogVO vo) throws Exception {
		try {
			ComrescardlogDAO dao = (ComrescardlogDAO) DAOFactory.build(ComrescardlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComrescardlogDAO dao = (ComrescardlogDAO) DAOFactory.build(ComrescardlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComrescardlogVO doUpdate(ComrescardlogVO vo) throws Exception {
		try {
			ComrescardlogDAO dao = (ComrescardlogDAO) DAOFactory.build(ComrescardlogDAO.class,user);
			return (ComrescardlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComrescardlogVO doFindByPk(Serializable pk) throws Exception {
		ComrescardlogDAO dao = (ComrescardlogDAO) DAOFactory.build(ComrescardlogDAO.class,user);
		return (ComrescardlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComrescardlogDBParam params)
			throws Exception {
		ComrescardlogDAO dao = (ComrescardlogDAO) DAOFactory.build(ComrescardlogDAO.class,user);
		return dao.query(params);
	}
}
