/**
 * auto-generated code
 * Wed Jul 01 17:29:43 CST 2009
 */
package com.gmcc.pboss.control.channel.waybussarea;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waybussarea.WaybussareaDBParam;
import com.gmcc.pboss.business.channel.waybussarea.WaybussareaDAO;
import com.gmcc.pboss.business.channel.waybussarea.WaybussareaVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WaybussareaBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/waybussarea/control/WaybussareaBO"
*    name="Waybussarea"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WaybussareaBO extends AbstractControlBean implements
		Waybussarea {

	public WaybussareaVO doCreate(WaybussareaVO vo) throws Exception {
		try {
			WaybussareaDAO dao = (WaybussareaDAO) DAOFactory.build(WaybussareaDAO.class, user);
			// TODO set the pk */
			return (WaybussareaVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaybussareaVO vo) throws Exception {
		try {
			WaybussareaDAO dao = (WaybussareaDAO) DAOFactory.build(WaybussareaDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaybussareaDAO dao = (WaybussareaDAO) DAOFactory.build(WaybussareaDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaybussareaVO doUpdate(WaybussareaVO vo) throws Exception {
		try {
			WaybussareaDAO dao = (WaybussareaDAO) DAOFactory.build(WaybussareaDAO.class,user);
			return (WaybussareaVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaybussareaVO doFindByPk(Serializable pk) throws Exception {
		WaybussareaDAO dao = (WaybussareaDAO) DAOFactory.build(WaybussareaDAO.class,user);
		return (WaybussareaVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaybussareaDBParam params)
			throws Exception {
		WaybussareaDAO dao = (WaybussareaDAO) DAOFactory.build(WaybussareaDAO.class,user);
		return dao.query(params);
	}
}
