/**
 * auto-generated code
 * Wed Jul 01 17:02:51 CST 2009
 */
package com.gmcc.pboss.control.channel.waysynlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waysynlog.WaysynlogDBParam;
import com.gmcc.pboss.business.channel.waysynlog.WaysynlogDAO;
import com.gmcc.pboss.business.channel.waysynlog.WaysynlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WaysynlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/waysynlog/control/WaysynlogBO"
*    name="Waysynlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WaysynlogBO extends AbstractControlBean implements
		Waysynlog {

	public WaysynlogVO doCreate(WaysynlogVO vo) throws Exception {
		try {
			WaysynlogDAO dao = (WaysynlogDAO) DAOFactory.build(WaysynlogDAO.class, user);
			// TODO set the pk */
			return (WaysynlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaysynlogVO vo) throws Exception {
		try {
			WaysynlogDAO dao = (WaysynlogDAO) DAOFactory.build(WaysynlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaysynlogDAO dao = (WaysynlogDAO) DAOFactory.build(WaysynlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaysynlogVO doUpdate(WaysynlogVO vo) throws Exception {
		try {
			WaysynlogDAO dao = (WaysynlogDAO) DAOFactory.build(WaysynlogDAO.class,user);
			return (WaysynlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaysynlogVO doFindByPk(Serializable pk) throws Exception {
		WaysynlogDAO dao = (WaysynlogDAO) DAOFactory.build(WaysynlogDAO.class,user);
		return (WaysynlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaysynlogDBParam params)
			throws Exception {
		WaysynlogDAO dao = (WaysynlogDAO) DAOFactory.build(WaysynlogDAO.class,user);
		return dao.query(params);
	}
}
