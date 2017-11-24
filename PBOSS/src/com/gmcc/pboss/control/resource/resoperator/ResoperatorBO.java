/**
 * auto-generated code
 * Fri May 25 11:37:59 CST 2012
 */
package com.gmcc.pboss.control.resource.resoperator;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.resoperator.ResoperatorDBParam;
import com.gmcc.pboss.business.resource.resoperator.ResoperatorDAO;
import com.gmcc.pboss.business.resource.resoperator.ResoperatorVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ResoperatorBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ResoperatorBO extends AbstractControlBean implements
		Resoperator {

	public ResoperatorVO doCreate(ResoperatorVO vo) throws Exception {
		try {
			ResoperatorDAO dao = (ResoperatorDAO) DAOFactory.build(ResoperatorDAO.class, user);
			// TODO set the pk */
			return (ResoperatorVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ResoperatorVO vo) throws Exception {
		try {
			ResoperatorDAO dao = (ResoperatorDAO) DAOFactory.build(ResoperatorDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ResoperatorDAO dao = (ResoperatorDAO) DAOFactory.build(ResoperatorDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResoperatorVO doUpdate(ResoperatorVO vo) throws Exception {
		try {
			ResoperatorDAO dao = (ResoperatorDAO) DAOFactory.build(ResoperatorDAO.class,user);
			return (ResoperatorVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResoperatorVO doFindByPk(Serializable pk) throws Exception {
		ResoperatorDAO dao = (ResoperatorDAO) DAOFactory.build(ResoperatorDAO.class,user);
		return (ResoperatorVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResoperatorDBParam params)
			throws Exception {
		ResoperatorDAO dao = (ResoperatorDAO) DAOFactory.build(ResoperatorDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doWayinfo(ResoperatorDBParam params) throws Exception{
		ResoperatorDAO dao = (ResoperatorDAO) DAOFactory.build(ResoperatorDAO.class,user);
		params.setSelectFieldsString("wayname,wayid,operid");
		params.setSelectFieldsUseVOType(true);
		return dao.queryByNamedSqlQuery("resoperatorVOList",params);
	}
	
}
