/**
 * auto-generated code
 * Wed Jul 01 17:30:39 CST 2009
 */
package com.gmcc.pboss.control.channel.wayaccount;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.way.WayDAO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDAO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WayaccountBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/wayaccount/control/WayaccountBO"
*    name="Wayaccount"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WayaccountBO extends AbstractControlBean implements
		Wayaccount {

	public WayaccountVO doCreate(WayaccountVO vo) throws Exception {
		try {
			WayaccountDAO dao = (WayaccountDAO) DAOFactory.build(WayaccountDAO.class, user);
			// TODO set the pk */
			return (WayaccountVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WayaccountVO vo) throws Exception {
		try {
			WayaccountDAO dao = (WayaccountDAO) DAOFactory.build(WayaccountDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WayaccountDAO dao = (WayaccountDAO) DAOFactory.build(WayaccountDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayaccountVO doUpdate(WayaccountVO vo) throws Exception {
		try {
			WayaccountDAO dao = (WayaccountDAO) DAOFactory.build(WayaccountDAO.class,user);
			return (WayaccountVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayaccountVO doFindByPk(Serializable pk) throws Exception {
		WayaccountDAO dao = (WayaccountDAO) DAOFactory.build(WayaccountDAO.class,user);
		return (WayaccountVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WayaccountDBParam params)
			throws Exception {
		WayaccountDAO dao = (WayaccountDAO) DAOFactory.build(WayaccountDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryWayAndSubwayDetailInfo(WayaccountDBParam params,String wayid) 
			throws Exception {
		WayaccountDAO wdao = (WayaccountDAO) DAOFactory.build(WayaccountDAO.class, user);
		return wdao.queryWayAndSubwayDetailInfo(params, wayid);
	}
}
