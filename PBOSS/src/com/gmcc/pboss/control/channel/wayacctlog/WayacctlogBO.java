/**
 * auto-generated code
 * Thu Nov 05 10:44:22 CST 2009
 */
package com.gmcc.pboss.control.channel.wayacctlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.wayacctlog.WayacctlogDBParam;
import com.gmcc.pboss.business.channel.wayacctlog.WayacctlogDAO;
import com.gmcc.pboss.business.channel.wayacctlog.WayacctlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: WayacctlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WayacctlogBO extends AbstractControlBean implements
		Wayacctlog {

	public WayacctlogVO doCreate(WayacctlogVO vo) throws Exception {
		try {
			WayacctlogDAO dao = (WayacctlogDAO) DAOFactory.build(WayacctlogDAO.class, user);
			// TODO set the pk */
			return (WayacctlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WayacctlogVO vo) throws Exception {
		try {
			WayacctlogDAO dao = (WayacctlogDAO) DAOFactory.build(WayacctlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WayacctlogDAO dao = (WayacctlogDAO) DAOFactory.build(WayacctlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayacctlogVO doUpdate(WayacctlogVO vo) throws Exception {
		try {
			WayacctlogDAO dao = (WayacctlogDAO) DAOFactory.build(WayacctlogDAO.class,user);
			return (WayacctlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayacctlogVO doFindByPk(Serializable pk) throws Exception {
		WayacctlogDAO dao = (WayacctlogDAO) DAOFactory.build(WayacctlogDAO.class,user);
		return (WayacctlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WayacctlogDBParam params)
			throws Exception {
		WayacctlogDAO dao = (WayacctlogDAO) DAOFactory.build(WayacctlogDAO.class,user);
		return dao.query(params);
	}
}
