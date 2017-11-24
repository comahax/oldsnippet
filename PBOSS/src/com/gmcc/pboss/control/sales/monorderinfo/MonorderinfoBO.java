/**
 * auto-generated code
 * Tue Oct 13 09:40:58 CST 2009
 */
package com.gmcc.pboss.control.sales.monorderinfo;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoDBParam;
import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoDAO;
import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: MonorderinfoBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MonorderinfoBO extends AbstractControlBean implements
		Monorderinfo {

	public MonorderinfoVO doCreate(MonorderinfoVO vo) throws Exception {
		try {
			MonorderinfoDAO dao = (MonorderinfoDAO) DAOFactory.build(MonorderinfoDAO.class, user);
			// TODO set the pk */
			return (MonorderinfoVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(MonorderinfoVO vo) throws Exception {
		try {
			MonorderinfoDAO dao = (MonorderinfoDAO) DAOFactory.build(MonorderinfoDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			MonorderinfoDAO dao = (MonorderinfoDAO) DAOFactory.build(MonorderinfoDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public MonorderinfoVO doUpdate(MonorderinfoVO vo) throws Exception {
		try {
			MonorderinfoDAO dao = (MonorderinfoDAO) DAOFactory.build(MonorderinfoDAO.class,user);
			return (MonorderinfoVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public MonorderinfoVO doFindByPk(Serializable pk) throws Exception {
		MonorderinfoDAO dao = (MonorderinfoDAO) DAOFactory.build(MonorderinfoDAO.class,user);
		return (MonorderinfoVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(MonorderinfoDBParam params)
			throws Exception {
		MonorderinfoDAO dao = (MonorderinfoDAO) DAOFactory.build(MonorderinfoDAO.class,user);
		return dao.query(params);
	}
}
