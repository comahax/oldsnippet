package com.gmcc.pboss.control.base.organization;

import java.io.Serializable;

import com.gmcc.pboss.business.base.operright.OperrightDAO;
import com.gmcc.pboss.business.base.organization.OrganizationDAO;
import com.gmcc.pboss.business.base.organization.OrganizationDBParam;
import com.gmcc.pboss.business.base.organization.OrganizationVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
/**
 * @ejb.bean local-jndi-name="com/gmcc/pboss/control/base/organization/OrganizationBO"
 *           name="Organization" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class OrganizationBO extends AbstractControlBean implements Organization{

	public OrganizationVO doCreate(OrganizationVO vo) throws Exception {
		try {
			OrganizationDAO dao = (OrganizationDAO) DAOFactory.build(OrganizationDAO.class, user);
			return (OrganizationVO) dao.create(vo);
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

	public OrganizationVO doFindByPk(Serializable pk) throws Exception {
		OrganizationDAO dao = (OrganizationDAO) DAOFactory.build(OrganizationDAO.class,
				user);
		return (OrganizationVO) dao.findByPk(pk);
		
	}

	public DataPackage doQuery(OrganizationDBParam params) throws Exception {
		OrganizationDAO dao = (OrganizationDAO) DAOFactory.build(OrganizationDAO.class,
				user);
		return dao.query(params);
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrganizationDAO dao = (OrganizationDAO) DAOFactory.build(OrganizationDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception e) {
			throw new JOPException(e);
		}
		
	}

	public void doRemoveByVO(OrganizationVO vo) throws Exception {
		try {
			OrganizationDAO dao = (OrganizationDAO) DAOFactory.build(OrganizationDAO.class, user);
			dao.remove(vo);
		} catch (Exception e) {
			throw new JOPException(e);
		}
		
	}

	public OrganizationVO doUpdate(OrganizationVO vo) throws Exception {
		try {
			OrganizationDAO dao = (OrganizationDAO) DAOFactory.build(OrganizationDAO.class, user);
			return (OrganizationVO) dao.update(vo);
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

}
