/**
 * auto-generated code
 * Wed Jul 01 17:30:11 CST 2009
 */
package com.gmcc.pboss.control.channel.waycompact;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waycompact.WaycompactDBParam;
import com.gmcc.pboss.business.channel.waycompact.WaycompactDAO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WaycompactBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/waycompact/control/WaycompactBO"
*    name="Waycompact"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WaycompactBO extends AbstractControlBean implements
		Waycompact {

	public WaycompactVO doCreate(WaycompactVO vo) throws Exception {
		try {
			WaycompactDAO dao = (WaycompactDAO) DAOFactory.build(WaycompactDAO.class, user);
			// TODO set the pk */
			return (WaycompactVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaycompactVO vo) throws Exception {
		try {
			WaycompactDAO dao = (WaycompactDAO) DAOFactory.build(WaycompactDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaycompactDAO dao = (WaycompactDAO) DAOFactory.build(WaycompactDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaycompactVO doUpdate(WaycompactVO vo) throws Exception {
		try {
			WaycompactDAO dao = (WaycompactDAO) DAOFactory.build(WaycompactDAO.class,user);
			return (WaycompactVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaycompactVO doFindByPk(Serializable pk) throws Exception {
		WaycompactDAO dao = (WaycompactDAO) DAOFactory.build(WaycompactDAO.class,user);
		return (WaycompactVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaycompactDBParam params)
			throws Exception {
		WaycompactDAO dao = (WaycompactDAO) DAOFactory.build(WaycompactDAO.class,user);
		return dao.query(params);
	}
}
