/**
 * auto-generated code
 * Sun Oct 18 20:50:56 CST 2009
 */
package com.gmcc.pboss.control.channel.waycompctlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waycompctlog.WaycompctlogDBParam;
import com.gmcc.pboss.business.channel.waycompctlog.WaycompctlogDAO;
import com.gmcc.pboss.business.channel.waycompctlog.WaycompctlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WaycompctlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WaycompctlogBO extends AbstractControlBean implements
		Waycompctlog {

	public WaycompctlogVO doCreate(WaycompctlogVO vo) throws Exception {
		try {
			WaycompctlogDAO dao = (WaycompctlogDAO) DAOFactory.build(WaycompctlogDAO.class, user);
			// TODO set the pk */
			return (WaycompctlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaycompctlogVO vo) throws Exception {
		try {
			WaycompctlogDAO dao = (WaycompctlogDAO) DAOFactory.build(WaycompctlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaycompctlogDAO dao = (WaycompctlogDAO) DAOFactory.build(WaycompctlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaycompctlogVO doUpdate(WaycompctlogVO vo) throws Exception {
		try {
			WaycompctlogDAO dao = (WaycompctlogDAO) DAOFactory.build(WaycompctlogDAO.class,user);
			return (WaycompctlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaycompctlogVO doFindByPk(Serializable pk) throws Exception {
		WaycompctlogDAO dao = (WaycompctlogDAO) DAOFactory.build(WaycompctlogDAO.class,user);
		return (WaycompctlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaycompctlogDBParam params)
			throws Exception {
		WaycompctlogDAO dao = (WaycompctlogDAO) DAOFactory.build(WaycompctlogDAO.class,user);
		return dao.query(params);
	}
}
