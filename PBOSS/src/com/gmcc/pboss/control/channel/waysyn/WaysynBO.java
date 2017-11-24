/**
 * auto-generated code
 * Wed Jul 01 17:28:07 CST 2009
 */
package com.gmcc.pboss.control.channel.waysyn;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waysyn.WaysynDBParam;
import com.gmcc.pboss.business.channel.waysyn.WaysynDAO;
import com.gmcc.pboss.business.channel.waysyn.WaysynVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WaysynBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/waysyn/control/WaysynBO"
*    name="Waysyn"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WaysynBO extends AbstractControlBean implements
		Waysyn {

	public WaysynVO doCreate(WaysynVO vo) throws Exception {
		try {
			WaysynDAO dao = (WaysynDAO) DAOFactory.build(WaysynDAO.class, user);
			// TODO set the pk */
			return (WaysynVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaysynVO vo) throws Exception {
		try {
			WaysynDAO dao = (WaysynDAO) DAOFactory.build(WaysynDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaysynDAO dao = (WaysynDAO) DAOFactory.build(WaysynDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaysynVO doUpdate(WaysynVO vo) throws Exception {
		try {
			WaysynDAO dao = (WaysynDAO) DAOFactory.build(WaysynDAO.class,user);
			return (WaysynVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaysynVO doFindByPk(Serializable pk) throws Exception {
		WaysynDAO dao = (WaysynDAO) DAOFactory.build(WaysynDAO.class,user);
		return (WaysynVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaysynDBParam params)
			throws Exception {
		WaysynDAO dao = (WaysynDAO) DAOFactory.build(WaysynDAO.class,user);
		return dao.query(params);
	}
}
