/**
 * auto-generated code
 * Mon Nov 23 16:57:18 CST 2009
 */
package com.gmcc.pboss.control.sales.comsellmid;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.comsellmid.ComsellmidDBParam;
import com.gmcc.pboss.business.sales.comsellmid.ComsellmidDAO;
import com.gmcc.pboss.business.sales.comsellmid.ComsellmidVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ComsellmidBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ComsellmidBO extends AbstractControlBean implements
		Comsellmid {

	public ComsellmidVO doCreate(ComsellmidVO vo) throws Exception {
		try {
			//ComsellmidDAO dao = (ComsellmidDAO) DAOFactory.build(ComsellmidDAO.class, "DB_BOSSCOMMON");
			ComsellmidDAO dao = (ComsellmidDAO) DAOFactory.build(ComsellmidDAO.class, user);
			// TODO set the pk */
			return (ComsellmidVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComsellmidVO vo) throws Exception {
		try {
			//ComsellmidDAO dao = (ComsellmidDAO) DAOFactory.build(ComsellmidDAO.class, "DB_BOSSCOMMON");
			ComsellmidDAO dao = (ComsellmidDAO) DAOFactory.build(ComsellmidDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			//ComsellmidDAO dao = (ComsellmidDAO) DAOFactory.build(ComsellmidDAO.class, "DB_BOSSCOMMON");
			ComsellmidDAO dao = (ComsellmidDAO) DAOFactory.build(ComsellmidDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComsellmidVO doUpdate(ComsellmidVO vo) throws Exception {
		try {
			//ComsellmidDAO dao = (ComsellmidDAO) DAOFactory.build(ComsellmidDAO.class, "DB_BOSSCOMMON");
			ComsellmidDAO dao = (ComsellmidDAO) DAOFactory.build(ComsellmidDAO.class,user);
			return (ComsellmidVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComsellmidVO doFindByPk(Serializable pk) throws Exception {
		ComsellmidDAO dao = (ComsellmidDAO) DAOFactory.build(ComsellmidDAO.class,user);
		return (ComsellmidVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComsellmidDBParam params)
			throws Exception {
		ComsellmidDAO dao = (ComsellmidDAO) DAOFactory.build(ComsellmidDAO.class,user);
		return dao.query(params);
	}
}
