/**
 * auto-generated code
 * Wed Jul 01 17:31:42 CST 2009
 */
package com.gmcc.pboss.control.channel.netsynlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.netsynlog.NetsynlogDBParam;
import com.gmcc.pboss.business.channel.netsynlog.NetsynlogDAO;
import com.gmcc.pboss.business.channel.netsynlog.NetsynlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: NetsynlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/netsynlog/control/NetsynlogBO"
*    name="Netsynlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class NetsynlogBO extends AbstractControlBean implements
		Netsynlog {

	public NetsynlogVO doCreate(NetsynlogVO vo) throws Exception {
		try {
			NetsynlogDAO dao = (NetsynlogDAO) DAOFactory.build(NetsynlogDAO.class, user);
			// TODO set the pk */
			return (NetsynlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(NetsynlogVO vo) throws Exception {
		try {
			NetsynlogDAO dao = (NetsynlogDAO) DAOFactory.build(NetsynlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			NetsynlogDAO dao = (NetsynlogDAO) DAOFactory.build(NetsynlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NetsynlogVO doUpdate(NetsynlogVO vo) throws Exception {
		try {
			NetsynlogDAO dao = (NetsynlogDAO) DAOFactory.build(NetsynlogDAO.class,user);
			return (NetsynlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NetsynlogVO doFindByPk(Serializable pk) throws Exception {
		NetsynlogDAO dao = (NetsynlogDAO) DAOFactory.build(NetsynlogDAO.class,user);
		return (NetsynlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(NetsynlogDBParam params)
			throws Exception {
		NetsynlogDAO dao = (NetsynlogDAO) DAOFactory.build(NetsynlogDAO.class,user);
		return dao.query(params);
	}
}
