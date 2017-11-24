/**
 * auto-generated code
 * Fri Sep 25 15:01:17 CST 2009
 */
package com.gmcc.pboss.control.resource.resimport;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.resimport.ResimportDBParam;
import com.gmcc.pboss.business.resource.resimport.ResimportDAO;
import com.gmcc.pboss.business.resource.resimport.ResimportVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ResimportBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResimportBO extends AbstractControlBean implements
		Resimport {

	public ResimportVO doCreate(ResimportVO vo) throws Exception {
		try {
			ResimportDAO dao = (ResimportDAO) DAOFactory.build(ResimportDAO.class, user);
			// TODO set the pk */
			return (ResimportVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ResimportVO vo) throws Exception {
		try {
			ResimportDAO dao = (ResimportDAO) DAOFactory.build(ResimportDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ResimportDAO dao = (ResimportDAO) DAOFactory.build(ResimportDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResimportVO doUpdate(ResimportVO vo) throws Exception {
		try {
			ResimportDAO dao = (ResimportDAO) DAOFactory.build(ResimportDAO.class,user);
			return (ResimportVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResimportVO doFindByPk(Serializable pk) throws Exception {
		ResimportDAO dao = (ResimportDAO) DAOFactory.build(ResimportDAO.class,user);
		return (ResimportVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResimportDBParam params)
			throws Exception {
		ResimportDAO dao = (ResimportDAO) DAOFactory.build(ResimportDAO.class,user);
		return dao.query(params);
	}
}
