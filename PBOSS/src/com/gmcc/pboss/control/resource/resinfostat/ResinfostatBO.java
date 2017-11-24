/**
 * auto-generated code
 * Mon Aug 16 15:40:34 CST 2010
 */
package com.gmcc.pboss.control.resource.resinfostat;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.resinfostat.ResinfostatDBParam;
import com.gmcc.pboss.business.resource.resinfostat.ResinfostatDAO;
import com.gmcc.pboss.business.resource.resinfostat.ResinfostatVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ResinfostatBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public class ResinfostatBO extends AbstractControlBean implements
		Resinfostat {

	public ResinfostatVO doCreate(ResinfostatVO vo) throws Exception {
		try {
			ResinfostatDAO dao = (ResinfostatDAO) DAOFactory.build(ResinfostatDAO.class, user);
			// TODO set the pk */
			return (ResinfostatVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ResinfostatVO vo) throws Exception {
		try {
			ResinfostatDAO dao = (ResinfostatDAO) DAOFactory.build(ResinfostatDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ResinfostatDAO dao = (ResinfostatDAO) DAOFactory.build(ResinfostatDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResinfostatVO doUpdate(ResinfostatVO vo) throws Exception {
		try {
			ResinfostatDAO dao = (ResinfostatDAO) DAOFactory.build(ResinfostatDAO.class,user);
			return (ResinfostatVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResinfostatVO doFindByPk(Serializable pk) throws Exception {
		ResinfostatDAO dao = (ResinfostatDAO) DAOFactory.build(ResinfostatDAO.class,user);
		return (ResinfostatVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResinfostatDBParam params)
			throws Exception {
		ResinfostatDAO dao = (ResinfostatDAO) DAOFactory.build(ResinfostatDAO.class,user);
		return dao.query(params);
	}
}
