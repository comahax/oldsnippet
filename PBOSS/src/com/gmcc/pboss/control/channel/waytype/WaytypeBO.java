/**
 * auto-generated code
 * Wed Jul 08 11:41:20 CST 2009
 */
package com.gmcc.pboss.control.channel.waytype;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waytype.WaytypeDBParam;
import com.gmcc.pboss.business.channel.waytype.WaytypeDAO;
import com.gmcc.pboss.business.channel.waytype.WaytypeVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WaytypeBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/waytype/control/WaytypeBO"
*    name="Waytype"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WaytypeBO extends AbstractControlBean implements
		Waytype {

	public WaytypeVO doCreate(WaytypeVO vo) throws Exception {
		try {
			WaytypeDAO dao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class, user);
			// TODO set the pk */
			return (WaytypeVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaytypeVO vo) throws Exception {
		try {
			WaytypeDAO dao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaytypeDAO dao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaytypeVO doUpdate(WaytypeVO vo) throws Exception {
		try {
			WaytypeDAO dao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class,user);
			return (WaytypeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaytypeVO doFindByPk(Serializable pk) throws Exception {
		WaytypeDAO dao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class,user);
		return (WaytypeVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaytypeDBParam params)
			throws Exception {
		WaytypeDAO dao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class,user);
		return dao.query(params);
	}
}
