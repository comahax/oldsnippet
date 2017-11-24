/**
 * auto-generated code
 * Wed Feb 24 15:46:47 CST 2010
 */
package com.gmcc.pboss.business.cms.examine.exmnstddtl.control;

import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnstddtl.persistent.ExmnstddtlDAO;
import com.gmcc.pboss.business.cms.examine.exmnstddtl.persistent.ExmnstddtlListVO;
import com.gmcc.pboss.business.cms.examine.exmnstddtl.persistent.ExmnstddtlVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ExmnstddtlBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ExmnstddtlBO extends AbstractControlBean implements
		Exmnstddtl {

	public ExmnstddtlVO doCreate(ExmnstddtlVO vo) throws Exception {
		try {
			ExmnstddtlDAO dao = (ExmnstddtlDAO) DAOFactory.build(ExmnstddtlDAO.class, user);
			// TODO set the pk */
			return (ExmnstddtlVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ExmnstddtlVO vo) throws Exception {
		try {
			ExmnstddtlDAO dao = (ExmnstddtlDAO) DAOFactory.build(ExmnstddtlDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ExmnstddtlDAO dao = (ExmnstddtlDAO) DAOFactory.build(ExmnstddtlDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ExmnstddtlVO doUpdate(ExmnstddtlVO vo) throws Exception {
		try {
			ExmnstddtlDAO dao = (ExmnstddtlDAO) DAOFactory.build(ExmnstddtlDAO.class,user);
			return (ExmnstddtlVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ExmnstddtlVO doFindByPk(Serializable pk) throws Exception {
		ExmnstddtlDAO dao = (ExmnstddtlDAO) DAOFactory.build(ExmnstddtlDAO.class,user);
		return (ExmnstddtlVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ExmnstddtlListVO params)
			throws Exception {
		ExmnstddtlDAO dao = (ExmnstddtlDAO) DAOFactory.build(ExmnstddtlDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryBySql(String queryString, ExmnstddtlListVO params) throws Exception{
		ExmnstddtlDAO dao = (ExmnstddtlDAO) DAOFactory.build(ExmnstddtlDAO.class,user);
		return dao.queryBySql(queryString, params);
	}
	public DataPackage doQueryByNameSql(String queryString, ExmnstddtlListVO params) throws Exception{
		ExmnstddtlDAO dao = (ExmnstddtlDAO) DAOFactory.build(ExmnstddtlDAO.class,user);
		return dao.queryByNamedSqlQuery(queryString, params);
	}
}
