/**
 * auto-generated code
 * Wed Jul 01 17:32:06 CST 2009
 */
package com.gmcc.pboss.control.channel.netsyn;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.netsyn.NetsynDBParam;
import com.gmcc.pboss.business.channel.netsyn.NetsynDAO;
import com.gmcc.pboss.business.channel.netsyn.NetsynVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: NetsynBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/netsyn/control/NetsynBO"
*    name="Netsyn"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class NetsynBO extends AbstractControlBean implements
		Netsyn {

	public NetsynVO doCreate(NetsynVO vo) throws Exception {
		try {
			NetsynDAO dao = (NetsynDAO) DAOFactory.build(NetsynDAO.class, user);
			// TODO set the pk */
			return (NetsynVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(NetsynVO vo) throws Exception {
		try {
			NetsynDAO dao = (NetsynDAO) DAOFactory.build(NetsynDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			NetsynDAO dao = (NetsynDAO) DAOFactory.build(NetsynDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NetsynVO doUpdate(NetsynVO vo) throws Exception {
		try {
			NetsynDAO dao = (NetsynDAO) DAOFactory.build(NetsynDAO.class,user);
			return (NetsynVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NetsynVO doFindByPk(Serializable pk) throws Exception {
		NetsynDAO dao = (NetsynDAO) DAOFactory.build(NetsynDAO.class,user);
		return (NetsynVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(NetsynDBParam params)
			throws Exception {
		NetsynDAO dao = (NetsynDAO) DAOFactory.build(NetsynDAO.class,user);
		return dao.query(params);
	}
}
