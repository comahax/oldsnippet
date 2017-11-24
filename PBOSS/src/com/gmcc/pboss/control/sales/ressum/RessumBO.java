/**
 * auto-generated code
 * Tue Oct 13 09:30:24 CST 2009
 */
package com.gmcc.pboss.control.sales.ressum;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.ressum.RessumDAO;
import com.gmcc.pboss.business.sales.ressum.RessumDBParam;
import com.gmcc.pboss.business.sales.ressum.RessumVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RessumBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RessumBO extends AbstractControlBean implements
		Ressum {

	public RessumVO doCreate(RessumVO vo) throws Exception {
		try {
			RessumDAO dao = (RessumDAO) DAOFactory.build(RessumDAO.class, user);
			// TODO set the pk */
			return (RessumVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RessumVO vo) throws Exception {
		try {
			RessumDAO dao = (RessumDAO) DAOFactory.build(RessumDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RessumDAO dao = (RessumDAO) DAOFactory.build(RessumDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RessumVO doUpdate(RessumVO vo) throws Exception {
		try {
			RessumDAO dao = (RessumDAO) DAOFactory.build(RessumDAO.class,user);
			return (RessumVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RessumVO doFindByPk(Serializable pk) throws Exception {
		RessumDAO dao = (RessumDAO) DAOFactory.build(RessumDAO.class,user);
		return (RessumVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RessumDBParam params) throws Exception {
		RessumDAO dao = (RessumDAO) DAOFactory.build(RessumDAO.class,user);
		return dao.query(params);
	}

	public DataPackage doQueryRessum(Map<String,String> conditionMap, RessumDBParam param) throws Exception {
		RessumDAO dao = (RessumDAO) DAOFactory.build(RessumDAO.class,user);
		return dao.doQueryRessum(conditionMap, param);
	}
	
}
