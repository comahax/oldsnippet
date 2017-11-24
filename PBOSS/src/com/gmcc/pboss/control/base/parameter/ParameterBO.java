package com.gmcc.pboss.control.base.parameter;

import java.io.Serializable;

import com.gmcc.pboss.business.base.parameter.ParameterDAO;
import com.gmcc.pboss.business.base.parameter.ParameterDBParam;
import com.gmcc.pboss.business.base.parameter.ParameterVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
/**
 * @ejb.bean local-jndi-name="com/gmcc/pboss/control/base/parameter/ParameterBO"
 *           name="Parameter" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class ParameterBO extends AbstractControlBean implements Parameter{

	public ParameterVO doCreate(ParameterVO vo) throws Exception {
		try {
			ParameterDAO dao = (ParameterDAO) DAOFactory.build(ParameterDAO.class, user);
			return (ParameterVO) dao.create(vo);
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

	public ParameterVO doFindByPk(Serializable pk) throws Exception {
		ParameterDAO dao = (ParameterDAO) DAOFactory.build(ParameterDAO.class,
				user);
		return (ParameterVO) dao.findByPk(pk);
		
	}

	public DataPackage doQuery(ParameterDBParam params) throws Exception {
		ParameterDAO dao = (ParameterDAO) DAOFactory.build(ParameterDAO.class,
				user);
		return dao.query(params);
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ParameterDAO dao = (ParameterDAO) DAOFactory.build(ParameterDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception e) {
			throw new JOPException(e);
		}
		
	}

	public void doRemoveByVO(ParameterVO vo) throws Exception {
		try {
			ParameterDAO dao = (ParameterDAO) DAOFactory.build(ParameterDAO.class, user);
			dao.remove(vo);
		} catch (Exception e) {
			throw new JOPException(e);
		}
		
	}

	public ParameterVO doUpdate(ParameterVO vo) throws Exception {
		try {
			ParameterDAO dao = (ParameterDAO) DAOFactory.build(ParameterDAO.class, user);
			return (ParameterVO) dao.update(vo);
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

}
