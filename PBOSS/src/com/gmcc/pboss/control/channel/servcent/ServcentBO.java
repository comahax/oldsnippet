/**
 * auto-generated code
 * Wed Jul 08 10:58:48 CST 2009
 */
package com.gmcc.pboss.control.channel.servcent;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.servcent.ServcentDBParam;
import com.gmcc.pboss.business.channel.servcent.ServcentDAO;
import com.gmcc.pboss.business.channel.servcent.ServcentVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ServcentBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/servcent/control/ServcentBO"
*    name="Servcent"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ServcentBO extends AbstractControlBean implements
		Servcent {

	public ServcentVO doCreate(ServcentVO vo) throws Exception {
		try {
			ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class, user);
			// TODO set the pk */
			return (ServcentVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ServcentVO vo) throws Exception {
		try {
			ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ServcentVO doUpdate(ServcentVO vo) throws Exception {
		try {
			ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,user);
			return (ServcentVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ServcentVO doFindByPk(Serializable pk) throws Exception {
		ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,user);
		return (ServcentVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ServcentDBParam params)
			throws Exception {
		ServcentDAO dao = (ServcentDAO) DAOFactory.build(ServcentDAO.class,user);
		return dao.query(params);
	}
}
