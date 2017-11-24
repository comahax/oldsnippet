/**
 * auto-generated code
 * Wed Sep 02 17:20:17 CST 2009
 */
package com.gmcc.pboss.control.resource.comcategoryrelalog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.comcategoryrelalog.ComcategoryrelalogDBParam;
import com.gmcc.pboss.business.resource.comcategoryrelalog.ComcategoryrelalogDAO;
import com.gmcc.pboss.business.resource.comcategoryrelalog.ComcategoryrelalogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComcategoryrelalogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/comcategoryrelalog/control/ComcategoryrelalogBO"
*    name="Comcategoryrelalog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ComcategoryrelalogBO extends AbstractControlBean implements
		Comcategoryrelalog {

	public ComcategoryrelalogVO doCreate(ComcategoryrelalogVO vo) throws Exception {
		try {
			ComcategoryrelalogDAO dao = (ComcategoryrelalogDAO) DAOFactory.build(ComcategoryrelalogDAO.class, user);
			// TODO set the pk */
			return (ComcategoryrelalogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComcategoryrelalogVO vo) throws Exception {
		try {
			ComcategoryrelalogDAO dao = (ComcategoryrelalogDAO) DAOFactory.build(ComcategoryrelalogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComcategoryrelalogDAO dao = (ComcategoryrelalogDAO) DAOFactory.build(ComcategoryrelalogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComcategoryrelalogVO doUpdate(ComcategoryrelalogVO vo) throws Exception {
		try {
			ComcategoryrelalogDAO dao = (ComcategoryrelalogDAO) DAOFactory.build(ComcategoryrelalogDAO.class,user);
			return (ComcategoryrelalogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComcategoryrelalogVO doFindByPk(Serializable pk) throws Exception {
		ComcategoryrelalogDAO dao = (ComcategoryrelalogDAO) DAOFactory.build(ComcategoryrelalogDAO.class,user);
		return (ComcategoryrelalogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComcategoryrelalogDBParam params)
			throws Exception {
		ComcategoryrelalogDAO dao = (ComcategoryrelalogDAO) DAOFactory.build(ComcategoryrelalogDAO.class,user);
		return dao.query(params);
	}
}
